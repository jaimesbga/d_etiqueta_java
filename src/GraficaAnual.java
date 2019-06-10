import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.text.html.parser.DTD;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.JOptionPane;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.Rotation;

public class GraficaAnual {
    private JFrame ventana;
    private JTabbedPane pestanas;
    private JPanel p_barras, p_pie, p_pie2, p_linea;
    private JComboBox lista;
    private JLabel fondo, label1;
    private JButton imprimir, cerrar;
    private java.sql.ResultSet resp;
    
    private String dirIP;
    
    public GraficaAnual(String ip) {
        dirIP = ip;
        
        iniciarComponentes();
        
        ventana.setVisible(true);
    }
    
    public void iniciarComponentes(){
        ventana = new JFrame();
        ventana.setTitle("Gráfica Anual");
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
        
        label1 = new JLabel();
        label1.setText("Seleccione Año: ");
        label1.setSize(100,25);
        label1.setLocation(50,90);
        
        lista = new JComboBox();
        lista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
        lista.setSize(100,25);
        lista.setLocation(150,90);
        lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pestanas.removeAll();
                
                p_pie = crearPiePanel(Integer.parseInt(lista.getSelectedItem().toString()));
                p_pie2 = crearPiePanel2(Integer.parseInt(lista.getSelectedItem().toString()));
                p_barras = crearBarrasPanel(Integer.parseInt(lista.getSelectedItem().toString()));
                p_linea = crearLineasPanel(Integer.parseInt(lista.getSelectedItem().toString()));

                pestanas.addTab("Pie 3D", p_pie);
                pestanas.addTab("Pie 2D", p_pie2);
                pestanas.addTab("Barras", p_barras);
                pestanas.addTab("Lineas", p_linea);
            }
        });
        
        pestanas = new JTabbedPane();
        pestanas.setSize(570,400);
        pestanas.setLocation(10,130);
        
        Calendar cal = Calendar.getInstance();
        int anoActual = cal.get(cal.YEAR);
        lista.setSelectedItem(anoActual);
        
        p_pie = crearPiePanel(Integer.parseInt(lista.getSelectedItem().toString()));
        p_pie2 = crearPiePanel2(Integer.parseInt(lista.getSelectedItem().toString()));
        p_barras = crearBarrasPanel(Integer.parseInt(lista.getSelectedItem().toString()));
        p_linea = crearLineasPanel(Integer.parseInt(lista.getSelectedItem().toString()));
        
        pestanas.addTab("Pie 3D", p_pie);
        pestanas.addTab("Pie 2D", p_pie2);
        pestanas.addTab("Barras", p_barras);
        pestanas.addTab("Lineas", p_linea);
        
        imprimir = new JButton();
        imprimir.setText("Imprimir");
        imprimir.setMnemonic('I');
        imprimir.setSize(100,25);
        imprimir.setLocation(150, 550);
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintJob mip = ventana.getToolkit().getPrintJob(ventana,"Gráficas",null);
                if(mip!=null){
                    Graphics imp = mip.getGraphics();            
                    if(imp!=null){
                        if(pestanas.getSelectedIndex()==0){
                            p_pie.printAll(imp);
                        }
                        if(pestanas.getSelectedIndex()==0){
                            p_pie2.printAll(imp);
                        }
                        if(pestanas.getSelectedIndex()==2){
                            p_barras.printAll(imp);
                        }
                        if(pestanas.getSelectedIndex()==3){
                            p_linea.printAll(imp);
                        }
                        imp.dispose();
                    }
                }
                if(mip!=null){
                    mip.end();
                }
            }
        });
        
        cerrar = new JButton();
        cerrar.setText("Cerrar");
        cerrar.setMnemonic('C');
        cerrar.setSize(100,25);
        cerrar.setLocation(230, 550);//300
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventana.dispose();
            }
        });
        
        ventana.add(fondo);
        ventana.add(label1);
        ventana.add(lista);
        ventana.add(pestanas);
        //ventana.add(imprimir);
        ventana.add(cerrar);
    }
    
    public JPanel crearPiePanel(int ano){
        JFreeChart chart = crearPieChart(crearPieDataSet(ano), ano);
        return new ChartPanel(chart);
    }
    
    public JPanel crearPiePanel2(int ano){
        JFreeChart chart = crearPieChart2(crearPieDataSet(ano), ano);
        return new ChartPanel(chart);
    }
    
    public JFreeChart crearPieChart2(PieDataset dataset, int ano){
         JFreeChart chart = ChartFactory.createPieChart(
            "Ingresos "+ano,  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        plot.setNoDataMessage("No hay datos");

        return chart;
    }
    
    private JFreeChart crearPieChart(PieDataset piedataset, int ano){
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Ingresos "+ano, piedataset, true, true, false);
        PiePlot3D pieplot3d = (PiePlot3D)jfreechart.getPlot();
        pieplot3d.setDarkerSides(true);
        pieplot3d.setStartAngle(290D);
        pieplot3d.setDirection(Rotation.CLOCKWISE);
        pieplot3d.setForegroundAlpha(0.5F);
        pieplot3d.setNoDataMessage("No hay datos");
        return jfreechart;
    }
    
    public PieDataset crearPieDataSet(int ano){
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        Conexion con = new Conexion(dirIP);
        if(con.conectar() == 1){
            String query;
            query = "select "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='01/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='02/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='03/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='04/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='05/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='06/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='07/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='08/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='09/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='10/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='11/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='12/"+ano+"') "
                    +"from dual";
            
            java.sql.ResultSet res = con.consultar(query);
            resp = res;
            try {
                if(res.next()){
                    dataset.setValue("Enero", new Double(res.getString(1)));
                    dataset.setValue("Febrero", new Double(res.getString(2)));
                    dataset.setValue("Marzo", new Double(res.getString(3)));
                    dataset.setValue("Abril", new Double(res.getString(4)));
                    dataset.setValue("Mayo", new Double(res.getString(5)));
                    dataset.setValue("Junio", new Double(res.getString(6)));
                    dataset.setValue("Julio", new Double(res.getString(7)));
                    dataset.setValue("Agosto", new Double(res.getString(8)));
                    dataset.setValue("Septiembre", new Double(res.getString(9)));
                    dataset.setValue("Octubre", new Double(res.getString(10)));
                    dataset.setValue("Noviembre", new Double(res.getString(11)));
                    dataset.setValue("Diciembre", new Double(res.getString(12)));
                }
                con.desconectar();
            }
            catch (Exception e) {  }
        }
        else{
            JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
        
        
        return dataset;
    }
    
    public JPanel crearBarrasPanel(int ano){
        JFreeChart chart = crearBarrasChart(crearBarrasDataSet(ano), ano);
        return new ChartPanel(chart);
    }
    
    public JFreeChart crearBarrasChart(DefaultCategoryDataset dataset, int ano){
        JFreeChart chart = ChartFactory.createBarChart3D(
           "Ingresos "+ano, "Meses",
           "Bs.F.",
           dataset,
           PlotOrientation.VERTICAL,
           true,
           true,
           false
        );
        
        return chart;
    } 
    
    public DefaultCategoryDataset crearBarrasDataSet(int ano){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        Conexion con = new Conexion(dirIP);
        if(con.conectar() == 1){
            String query;
            query = "select "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='01/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='02/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='03/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='04/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='05/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='06/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='07/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='08/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='09/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='10/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='11/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='12/"+ano+"') "
                    +"from dual";
            
             java.sql.ResultSet res = con.consultar(query);
            
            try {
                if(res.next()){
                    String SITIO_1 = "D' Etiqueta - Ingresos "+ano;
                    dataset.setValue(new Double(res.getString(1)), SITIO_1, "Ene");
                    dataset.setValue(new Double(res.getString(2)), SITIO_1, "Feb");
                    dataset.setValue(new Double(res.getString(3)), SITIO_1, "Mar");
                    dataset.setValue(new Double(res.getString(4)), SITIO_1, "Abr");
                    dataset.setValue(new Double(res.getString(5)), SITIO_1, "May");
                    dataset.setValue(new Double(res.getString(6)), SITIO_1, "Jun");
                    dataset.setValue(new Double(res.getString(7)), SITIO_1, "Jul");
                    dataset.setValue(new Double(res.getString(8)), SITIO_1, "Ago");
                    dataset.setValue(new Double(res.getString(9)), SITIO_1, "Sep");
                    dataset.setValue(new Double(res.getString(10)), SITIO_1, "Octe");
                    dataset.setValue(new Double(res.getString(11)), SITIO_1, "Nov");
                    dataset.setValue(new Double(res.getString(12)), SITIO_1, "Dic");
                }
                con.desconectar();
            }
            catch (Exception e) {  }
        }
        else{
            JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
        
        return dataset;
    }
 
    public JPanel crearLineasPanel(int ano){
        JFreeChart chart = crearLineasChart(crearLineasDataSet(ano), ano);
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        
        return panel;
    }
    
    public JFreeChart crearLineasChart(XYDataset dataset, int ano){
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Ingresos "+ano,  // title
            "Mes",             // x-axis label
            "Total de Ingresos",   // y-axis label
            dataset,            // data
            true,               // create legend?
            true,               // generate tooltips?
            false               // generate URLs?
        );

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setDrawSeriesLineAsPath(true);
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

        return chart;
    }
    
    public XYDataset crearLineasDataSet(int ano){
        TimeSeries s1 = new TimeSeries("Ingresos "+ano);
        
        Conexion con = new Conexion(dirIP);
        if(con.conectar() == 1){
            String query;
            query = "select "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='01/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='02/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='03/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='04/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='05/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='06/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='07/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='08/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='09/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='10/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='11/"+ano+"'), "
                    +"(select IFNULL(sum(MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID=c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='1' and DATE_FORMAT(fecha, '%m/%Y')='12/"+ano+"') "
                    +"from dual";
            
            java.sql.ResultSet res = con.consultar(query);
            
            try {
                if(res.next()){
                    s1.add(new Month(1, ano), new Double(res.getString(1)));
                    s1.add(new Month(2, ano), new Double(res.getString(2)));
                    s1.add(new Month(3, ano), new Double(res.getString(3)));
                    s1.add(new Month(4, ano), new Double(res.getString(4)));
                    s1.add(new Month(5, ano), new Double(res.getString(5)));
                    s1.add(new Month(6, ano), new Double(res.getString(6)));
                    s1.add(new Month(7, ano), new Double(res.getString(7)));
                    s1.add(new Month(8, ano), new Double(res.getString(8)));
                    s1.add(new Month(9, ano), new Double(res.getString(9)));
                    s1.add(new Month(10, ano), new Double(res.getString(10)));
                    s1.add(new Month(11, ano), new Double(res.getString(11)));
                    s1.add(new Month(12, ano), new Double(res.getString(12)));
                }
                con.desconectar();
            }
            catch (Exception e) {  }
        }
        else{
            JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
        
        

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
    }
}
