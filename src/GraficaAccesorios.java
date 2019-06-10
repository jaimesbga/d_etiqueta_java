import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.Rotation;

public class GraficaAccesorios {    
    private JFrame ventana;
    private JPanel p_datos, p_grafica, p_barras, p_tabla;
    private JTabbedPane pestanas;
    private JComboBox c_ano, c_tipo, c_orden;
    private JLabel fondo, label1, label2, label3;
    private JButton b_buscar, b_cerrar;
    private JTable tabla;
    private DefaultTableModel_M modelo = null;
    
    private String dirIP;
    public GraficaAccesorios(String ip) {
        dirIP = ip;
        
        iniciarComponentes();
        cargarPestanas();
        //cargarTabla();
        //p_grafica = crearPiePanel();
        //p_barras = createBarrasPanel();
        
        ventana.setVisible(true);
    }
    
    public void iniciarComponentes(){
        ventana = new JFrame();
        ventana.setTitle("D' Etiqueta - Estadísticas de Trajes");
        ventana.setDefaultCloseOperation(ventana.DISPOSE_ON_CLOSE);
        ventana.setSize(600,630);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setLocation((int)(d.getWidth()/2-ventana.getWidth()/2), (int)(d.getHeight()/2-ventana.getHeight()/2));
        ventana.setLayout(null);
        ventana.setResizable(false);
        
        fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Pago.gif")));
        fondo.setSize(281,49);
        fondo.setLocation(150,10);
        
        p_datos = new JPanel();
        p_datos.setBorder(javax.swing.BorderFactory.createTitledBorder("Características"));
        p_datos.setSize(570,80);
        p_datos.setLocation(10,80);
        p_datos.setLayout(null);
        
        label1 = new JLabel();
        label1.setText("Tipo Accesorio: ");
        label1.setSize(100,50);
        label1.setLocation(50, 20);
        
        c_tipo = new JComboBox();        
        c_tipo.setSize(140, 20);
        c_tipo.setLocation(160, 35);
        c_tipo.addItem("Todos");
        Conexion con = new Conexion(dirIP);
        if(con.conectar() ==1){
            java.sql.ResultSet res = con.consultar("select DESCRIPCION from TIPO_ACCESORIOS order by ID");
            try {
                while(res.next()){
                    c_tipo.addItem(res.getString(1));
                }
            }
            catch(Exception e){ /*System.out.println("error2");*/ }
            con.desconectar();
        }
        else{
            JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
        
        label2 = new JLabel();
        label2.setText("Año:");
        label2.setSize(100,50);
        label2.setLocation(350, 20);
        
        c_ano = new JComboBox();
        c_ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
        c_ano.setSize(90, 20);
        c_ano.setLocation(400, 35);
        
        label3 = new JLabel();
        label3.setText("Ordenar por:");
        label3.setSize(100,50);
        label3.setLocation(385, 20);
        label3.setVisible(false);
        
        c_orden = new JComboBox();
        c_orden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cantidad", "Total BsF."}));
        c_orden.setSize(100, 20);
        c_orden.setLocation(460, 35);
        c_orden.setVisible(false);
        
        p_datos.add(label1);
        p_datos.add(c_tipo);
        p_datos.add(label2);
        p_datos.add(c_ano);
        p_datos.add(label3);
        p_datos.add(c_orden);
        
        b_buscar = new JButton();
        b_buscar.setText("Actualizar");
        b_buscar.setSize(100,25);
        b_buscar.setLocation(180,550);
        b_buscar.setMnemonic('A');
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarPestanas();
            }
        });
        
        b_cerrar = new JButton();
        b_cerrar.setText("Cerrar");
        b_cerrar.setSize(100,25);
        b_cerrar.setLocation(320,550);
        b_cerrar.setMnemonic('C');
        b_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventana.dispose();
            }
        });
        
        pestanas = new JTabbedPane();
        pestanas.setSize(570,350);
        pestanas.setLocation(10,180);        
        
        p_tabla = new JPanel();
        p_tabla.setSize(570,320); 
        p_tabla.setLayout(null);
        
        tabla = new JTable();        
        modelo = new DefaultTableModel_M(null,
            new String [] {
                "Cantidad", "Total BsF.", "Tipo", "Forma", "Color", "Marca","Talla"
        });
        tabla.setModel(modelo);
        tabla.getTableHeader().setReorderingAllowed(false);
        
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setSize(550, 300);
        scroll.setLocation(10,10);        
        p_tabla.add(scroll);
        
        /*pestanas.addTab("Gráfica Pie", p_grafica);
        pestanas.addTab("Gráfica Barras", p_barras);
        pestanas.addTab("Tabla", p_tabla);*/
        
        ventana.add(fondo);
        ventana.add(p_datos);
        ventana.add(pestanas);
        ventana.add(b_buscar);
        ventana.add(b_cerrar);
    }
    
    public String crearQuery(){
        String query;
        String tipo, ano, orden;
        
        if(c_ano.getSelectedItem().toString().compareToIgnoreCase("Todos")==0){
            ano = "";
        }
        else{
            ano = "and to_char(cto.FECHA_EMISION,'YYYY') = '"+c_ano.getSelectedItem().toString()+"' ";
        }  
        
        orden = "order by cantidad desc";
        /*if(c_orden.getSelectedItem().toString().compareToIgnoreCase("Total BsF.") == 0){
            orden = "order by total desc";
        }
        else{
            orden = "order by cantidad desc";
        }*/
        
        query = "select count(itm.ARO_ID) as cantidad, itm.ARO_ID as id "
                    +"from CONTRATOS cto, ITEMS itm "
                    +"where cto.ID = itm.CTO_ID "
                    +"and (cto.ESTADO='ACTIVO' or cto.ESTADO='PENDIENTE' or cto.ESTADO='FINALIZADO') "
                    +ano
                    +"group by itm.ARO_ID ";
        query = query + orden;
        
        return query;
    }
    
    public String crearQueryCount(){
        String query, subquery;
        String tipo, ano;
        
        if(c_ano.getSelectedItem().toString().compareToIgnoreCase("Todos")==0){
            ano = "";
        }
        else{
            ano = "and to_char(cto.FECHA_EMISION,'YYYY') = '"+c_ano.getSelectedItem().toString()+"' ";
        }
        
        subquery = "select count(*) "
                    +"from CONTRATOS cto, ITEMS itm "
                    +"where cto.ID = itm.CTO_ID "
                    +"and (cto.ESTADO='ACTIVO' or cto.ESTADO='PENDIENTE' or cto.ESTADO='FINALIZADO') "
                    +ano+" group by itm.ARO_ID)";
        query = "select IFNULL(count(*),0) from (" + subquery;
        
        return query;
    }
    
    public void cargarTabla(){
        try{
            Conexion con = new Conexion(dirIP);
            if(con.conectar() == 1){
                java.sql.ResultSet res = con.consultar(crearQueryCount());
                res.next();
                //System.out.println(crearQueryCount()+"---"+res.getString(1));
                //System.out.println("++++++++"+crearQueryCount());
                String datos[][] = new String [Integer.parseInt(res.getString(1))][7];
                int pos = 0;
                int contTotal = 0;
                String id, cantidad, total, tipo, forma, color, color1, color2, color3, marca, talla;
                
                res = con.consultar(crearQuery());
                //System.out.println("------------"+crearQuery());
                while(res.next()){
                    cantidad = res.getString(1);
                    //total = res.getString(2);
                    id = res.getString(2);
                    
                    String query;
                    query = "select ta.DESCRIPCION, fa.DESCRIPCION, ca.COLOR1, ca.COLOR2, ca.COLOR3, ma.DESCRIPCION, aro.TALLA "
                            +"from ACCESORIOS aro, TIPO_ACCESORIOS ta, FORMA_ACCESORIOS fa, COLOR_ACCESORIOS ca, MARCA_ACCESORIOS ma "
                            +"where aro.TARO_ID=ta.ID and aro.FARO_ID=fa.ID and  aro.CARO_ID=ca.ID and aro.MARO_ID=ma.ID "
                            +"and aro.ID='"+id+"'";
                    
                    java.sql.ResultSet desc = con.consultar(query);
                    desc.next();
                    tipo = desc.getString(1);
                    forma = desc.getString(2);
                    color1 = desc.getString(3);
                    color2 = desc.getString(4);
                    color3 = desc.getString(5);
                    marca = desc.getString(6);
                    talla = desc.getString(7);
                    
                    if(c_tipo.getSelectedItem().toString().compareToIgnoreCase("Todos")==0){
                        contTotal++;
                    }
                    else{
                        if(c_tipo.getSelectedItem().toString().compareToIgnoreCase(tipo)==0){
                            contTotal++;
                        }
                    }
                    
                    color = "";
                    if(color1!=null){
                        color = color1;
                    }
                    if(color2!=null){
                        color = color+"-"+color2;
                    }
                    if(color3!=null){
                        color = color+"-"+color3;
                    }
                    
                    if(c_tipo.getSelectedItem().toString().compareToIgnoreCase("Todos")==0 || c_tipo.getSelectedItem().toString().compareTo(tipo)==0){
                        int entra = 0;                    
                        for(int k=0;k<pos;k++){
                            if(datos[k][2].compareTo(tipo)==0 && datos[k][3].compareTo(forma)==0 && datos[k][4].compareTo(color)==0 && datos[k][5].compareTo(marca)==0 && datos[k][6].compareTo(talla)==0){
                                entra = 1;
                                datos[k][0] = String.valueOf(Integer.parseInt(datos[k][0]) + Integer.parseInt(cantidad));
                                //datos[k][1] = String.valueOf(Integer.parseInt(datos[k][1]) + Integer.parseInt(total));
                            }
                        }

                        if(entra == 0){
                            datos[pos][0] = cantidad;
                            //datos[pos][1] = total;
                            datos[pos][1] = tipo;
                            datos[pos][2] = forma;
                            datos[pos][3] = color;
                            datos[pos][4] = marca;
                            datos[pos][5] = talla;
                            pos++;
                        }
                    }
                }
                con.desconectar();
                //******//if(pos!=contTotal){
                if(true){
                    String dat[][] = new String[pos][7];
                    int c=0;
                    for(int i=0; i<pos;i++){
                        //****//if(c_tipo.getSelectedItem().toString().compareToIgnoreCase(datos[i][2])==0){
                            for(int j=0; j<6; j++){
                                dat[c][j] = datos[i][j];                                
                            }
                            c++;
                        //****//}
                    }
                    modelo.setDataVector(dat, new String [] {
                        "Cantidad", "Tipo", "Forma", "Color", "Marca","Talla"
                    });
                }
                else{
                    modelo.setDataVector(datos, new String [] {
                        "Cantidad", "Tipo", "Forma", "Color", "Marca","Talla"
                    });
                } 
                
            }
            else{
                JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
        catch(Exception e){ /*System.out.println("error1"); e.printStackTrace();*/}        
    }
    
    public JPanel crearPiePanel(){
        JFreeChart chart = crearPieChart(crearPieDataSet());
        return new ChartPanel(chart);
    }
    
    private JFreeChart crearPieChart(PieDataset piedataset){
        JFreeChart jfreechart;
        jfreechart = ChartFactory.createPieChart3D("Cantidad Retiros", piedataset, true, true, false);
        /*if(c_orden.getSelectedItem().toString().compareToIgnoreCase("Total BsF.") == 0){
            jfreechart = ChartFactory.createPieChart3D("Ingresos por Accesorio", piedataset, true, true, false);
        }
        else{
            jfreechart = ChartFactory.createPieChart3D("Cantidad Retiros", piedataset, true, true, false);
        }*/
        
        PiePlot3D pieplot3d = (PiePlot3D)jfreechart.getPlot();
        pieplot3d.setDarkerSides(true);
        pieplot3d.setStartAngle(290D);
        pieplot3d.setDirection(Rotation.CLOCKWISE);
        pieplot3d.setForegroundAlpha(0.5F);
        pieplot3d.setNoDataMessage("No hay accesorios alquilados");
        return jfreechart;
    }
    
    public PieDataset crearPieDataSet(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(int i=0; i<tabla.getRowCount() && i<5;i++){
            if(tabla.getValueAt(i, 0)!=null && !tabla.getValueAt(i, 0).toString().isEmpty()){
                String sitio = tabla.getValueAt(i, 1).toString()+"-"+tabla.getValueAt(i, 3).toString()+"-"+tabla.getValueAt(i, 4).toString()+"-Talla "+tabla.getValueAt(i, 5).toString();
                dataset.setValue(sitio, new Double(tabla.getValueAt(i, 0).toString()));
                /*if(c_orden.getSelectedItem().toString().compareToIgnoreCase("Total BsF.") == 0){
                    dataset.setValue(sitio, new Double(tabla.getValueAt(i, 1).toString()));
                }
                else{                
                    dataset.setValue(sitio, new Double(tabla.getValueAt(i, 0).toString()));
                }*/
            }
        }
        return dataset;
    }
    
    public CategoryDataset createBarrasDataset(){
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        
        for(int i=0;i<tabla.getRowCount() && i<5; i++){
            if(tabla.getValueAt(i, 0)!=null && !tabla.getValueAt(i, 0).toString().isEmpty()){
                String sitio = tabla.getValueAt(i, 1).toString()+"-"+tabla.getValueAt(i, 3).toString()+"-"+tabla.getValueAt(i, 4).toString()+"-Talla "+tabla.getValueAt(i, 5).toString();
                defaultcategorydataset.addValue(new Double(tabla.getValueAt(i, 0).toString()), "S1", sitio);
            }
        }
        
        /*if(c_orden.getSelectedItem().toString().compareToIgnoreCase("Total BsF.") == 0){
            for(int i=0;i<tabla.getRowCount() && i<5; i++){
                String sitio = tabla.getValueAt(i, 2).toString()+"-"+tabla.getValueAt(i, 4).toString()+"-"+tabla.getValueAt(i, 5).toString()+"-Talla "+tabla.getValueAt(i, 6).toString();
                defaultcategorydataset.addValue(new Double(tabla.getValueAt(i, 1).toString()), "S1", sitio);
            }
        }
        else{
             for(int i=0;i<tabla.getRowCount() && i<5; i++){
                if(tabla.getValueAt(i, 0)!=null && !tabla.getValueAt(i, 0).toString().isEmpty()){
                    String sitio = tabla.getValueAt(i, 2).toString()+"-"+tabla.getValueAt(i, 4).toString()+"-"+tabla.getValueAt(i, 5).toString()+"-Talla "+tabla.getValueAt(i, 6).toString();
                    defaultcategorydataset.addValue(new Double(tabla.getValueAt(i, 0).toString()), "S1", sitio);
                }
            }
        }*/
        
        
        return defaultcategorydataset;
    }

    public JFreeChart createBarrasChart(CategoryDataset categorydataset){
        JFreeChart jfreechart;
        jfreechart = ChartFactory.createBarChart("Cantidad de Retiros", "Accesorios", "Cantidad", categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        /*if(c_orden.getSelectedItem().toString().compareToIgnoreCase("Total BsF.") == 0){
            jfreechart = ChartFactory.createBarChart("Ingresos por Accesorio", "Accesorios", "BsF.", categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        }
        else{
            jfreechart = ChartFactory.createBarChart("Cantidad de Retiros", "Accesorios", "Cantidad", categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        } */       
        /*TextTitle texttitle = new TextTitle("Source: Freshmeat (http://www.freshmeat.net/)", new Font("Dialog", 0, 10));
        texttitle.setPosition(RectangleEdge.BOTTOM);
        jfreechart.addSubtitle(texttitle);*/
        ChartUtilities.applyCurrentTheme(jfreechart);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.getDomainAxis().setMaximumCategoryLabelWidthRatio(0.8F);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setDrawBarOutline(false);
        StandardCategoryToolTipGenerator standardcategorytooltipgenerator;
        
        standardcategorytooltipgenerator = new StandardCategoryToolTipGenerator("{1}: {2} veces", new DecimalFormat("0"));
        
        /*if(c_orden.getSelectedItem().toString().compareToIgnoreCase("Total BsF.") == 0){
            standardcategorytooltipgenerator = new StandardCategoryToolTipGenerator("{1}: {2} BsF.", new DecimalFormat("0"));
        }
        else{
            standardcategorytooltipgenerator = new StandardCategoryToolTipGenerator("{1}: {2} veces", new DecimalFormat("0"));
        }*/
        barrenderer.setBaseToolTipGenerator(standardcategorytooltipgenerator);
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.RED, 0.0F, 0.0F, new Color(0, 0, 64));
        barrenderer.setSeriesPaint(0, gradientpaint);
        return jfreechart;
    }

    public JPanel createBarrasPanel(){
        JFreeChart jfreechart = createBarrasChart(createBarrasDataset());
        return new ChartPanel(jfreechart);
    }
    
    public void cargarPestanas(){
        pestanas.removeAll();
        cargarTabla();
        p_grafica = crearPiePanel();
        p_barras = createBarrasPanel(); 
        pestanas.addTab("Gráfica Pie", p_grafica);
        pestanas.addTab("Gráfica Barras", p_barras);
        pestanas.addTab("Tabla", p_tabla);
    }
}
