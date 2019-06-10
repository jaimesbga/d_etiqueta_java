import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JOptionPane;


public class BuscarPedidos extends javax.swing.JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton anoMay;
    private javax.swing.JButton anoMen;
    private javax.swing.JButton b_buscar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JButton b_detalles;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel l_imagen;
    private javax.swing.JTable listaResultados;
    private javax.swing.JButton mesMay;
    private javax.swing.JButton mesMen;
    private javax.swing.JTable tabla;
    
    private DefaultTableModel_M modeloCalendario = null;
    private DefaultTableModel_M modeloResultados = null;
    
    private String vecMes[];
    private GregorianCalendar calendar = null;
    private Date dina = null;
    private String entry;    
    private int mm;
    private int yy;
    
    int cont;
    
    private String dirIP;
    private Conexion con;
    
    public BuscarPedidos(String ip) {
        dirIP = ip;
        
        initComponents();
        init2();
        
        calendar = null;
        dina = null;
        
        //conectar();
        cargarTabla();
        
        setVisible(true);
    }
    
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        mesMen = new javax.swing.JButton();
        mesMay = new javax.swing.JButton();
        anoMen = new javax.swing.JButton();
        anoMay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        l_imagen = new javax.swing.JLabel();
        b_buscar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaResultados = new javax.swing.JTable();
        b_detalles = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("D' Etiqueta - Buscar Pedidos");
        setResizable(false);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione Fecha"));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"
            }
        ));
        tabla.setAutoscrolls(false);
        tabla.setColumnSelectionAllowed(true);
        tabla.setDoubleBuffered(true);
        jScrollPane1.setViewportView(tabla);

        mesMen.setText("<");

        mesMay.setText(">");

        anoMen.setText("<<");

        anoMay.setText(">>");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(anoMen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mesMen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mesMay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anoMay)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anoMen)
                    .addComponent(mesMen)
                    .addComponent(anoMay)
                    .addComponent(mesMay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        l_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Contrato.gif")));

        b_buscar.setText("Buscar");
        b_buscar.setMnemonic('B');
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entregas", "Devoluciones", "Todas" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));
        listaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Contrato", "Fecha Entrega", "Fecha Devolución", "Cédula", "Nombre", "Tipo"
            }
        ));
        jScrollPane3.setViewportView(listaResultados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        );

        b_detalles.setText("Detalles");
        b_detalles.setMnemonic('D');

        b_cancelar.setText("Cancelar");
        b_cancelar.setMnemonic('C');

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_imagen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(b_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(b_detalles)
                        .addGap(63, 63, 63)
                        .addComponent(b_cancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_buscar)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_detalles)
                    .addComponent(b_cancelar))
                .addContainerGap())
        );
        pack();
    }
   
    public void init2(){
        String meses = "Enero Febrero Marzo Abril Mayo Junio Julio Agosto Septiembre Octubre Noviembe Diciembre";
        vecMes = meses.split(" ");        
        
        mesMen.addActionListener(this);
        mesMay.addActionListener(this);
        anoMen.addActionListener(this);
        anoMay.addActionListener(this);
        b_buscar.addActionListener(this);
        b_detalles.addActionListener(this); 
        b_cancelar.addActionListener(this); 
        
        modeloCalendario = new DefaultTableModel_M(new Object [][] {
            {null,null ,null ,null },
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}},
            new String [] {
                "Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"
        });
        tabla.setModel(modeloCalendario);
        tabla.getTableHeader().setReorderingAllowed(false);
        
        cont = 0;
        
        modeloResultados = new DefaultTableModel_M(null,
            new String [] {
                "Contrato", "Entrega", "Devolución", "Cédula", "Nombre", "Tipo"
        });
        listaResultados.setModel(modeloResultados);
        listaResultados.getTableHeader().setReorderingAllowed(false);
        
        java.awt.Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(d.getWidth()/2-this.getWidth()/2), (int)(d.getHeight()/2-this.getHeight()/2));
    }
    
    
    public void cargarTabla(){
        for(int ii=0;ii<6;ii++){
            for(int jj=0;jj<7;jj++){
                tabla.setValueAt(null,ii,jj);
            }
        }
        try{
            if (dina==null){
                dina = new Date();
                calendar = new java.util.GregorianCalendar();
                calendar.setTime(dina);
                int mmm = calendar.get(java.util.Calendar.MONTH) ;   
                int yyy = calendar.get(java.util.Calendar.YEAR) ;   
                entry = "01/"+(mmm+1)+"/"+yyy;
            }
            dina = DateFormat.getDateInstance
            (DateFormat.SHORT,Locale.FRANCE).parse(entry);
            calendar = new GregorianCalendar();
            calendar.setTime(dina);            
        }
        catch(Exception er){ }        
        
        mm = calendar.get(Calendar.MONTH) ;   
        yy = calendar.get(Calendar.YEAR) ;   
        int px = calendar.get(Calendar.DAY_OF_WEEK)-1; 

        jLabel1.setText(vecMes[mm]+" - "+yy);
        
        int num;
        switch(mm){
            case 0: case 2: case 4: case 6: case 7: case 9: case 11:
                num=31;
                break;
            case 1:
                if((calendar.isLeapYear(yy))&&(yy%1000!=0))
                    num=29;
                else
                    num=28;
                break;
            default:
                num=30;
        }
        
        int cont=1;
        int x, y;
        x = px;
        y = 0;
        for(int ii=0;ii<num;ii++){
            tabla.setValueAt(cont, y, x);
            cont++;
            x++;
            if(x == 7){
                x=0;
                y++;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == anoMen){
            entry = "1/"+(calendar.get(Calendar.MONTH)+1)+"/"+(calendar.get(Calendar.YEAR)-1);
            cargarTabla();
	}
	if (e.getSource() == anoMay){
            entry = "1/"+(calendar.get(Calendar.MONTH)+1)+"/"+(calendar.get(Calendar.YEAR)+1);
            cargarTabla();
	}		
	if (e.getSource() == mesMen){
            entry = "1/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR);
            cargarTabla();
	}		
	if (e.getSource() == mesMay){
            entry = "1/"+(calendar.get(Calendar.MONTH)+2)+"/"+calendar.get(Calendar.YEAR);
            cargarTabla();
        }
        if(e.getSource() == b_buscar){
             int xs[] = tabla.getSelectedColumns();
             int ys[] = tabla.getSelectedRows();
             
             if(xs.length>0){                 
                 if(tabla.getValueAt(ys[0], xs[0]) != null && tabla.getValueAt(ys[ys.length-1], xs[xs.length-1]) != null){
                     String fecMin, fecMax;
                     
                     if(mm<9){
                        if(tabla.getValueAt(ys[0], xs[0]).toString().length()==2){
                            fecMin = tabla.getValueAt(ys[0], xs[0]).toString()+"/0"+(mm+1)+"/"+yy;
                        }
                        else{
                            fecMin = "0"+tabla.getValueAt(ys[0], xs[0]).toString()+"/0"+(mm+1)+"/"+yy;
                        }
                        if(tabla.getValueAt(ys[ys.length-1], xs[xs.length-1]).toString().length()==2){
                            fecMax = tabla.getValueAt(ys[ys.length-1], xs[xs.length-1]).toString()+"/0"+(mm+1)+"/"+yy;
                        }
                        else{
                            fecMax = "0"+tabla.getValueAt(ys[ys.length-1], xs[xs.length-1]).toString()+"/0"+(mm+1)+"/"+yy;
                        }
                     }
                     else{
                        if(tabla.getValueAt(ys[0], xs[0]).toString().length()==2){
                            fecMin = tabla.getValueAt(ys[0], xs[0]).toString()+"/"+(mm+1)+"/"+yy;
                        }
                        else{
                            fecMin = "0"+tabla.getValueAt(ys[0], xs[0]).toString()+"/"+(mm+1)+"/"+yy;
                        }
                        if(tabla.getValueAt(ys[ys.length-1], xs[xs.length-1]).toString().length()==2){
                            fecMax = tabla.getValueAt(ys[ys.length-1], xs[xs.length-1]).toString()+"/"+(mm+1)+"/"+yy;
                        }
                        else{
                            fecMax = "0"+tabla.getValueAt(ys[ys.length-1], xs[xs.length-1]).toString()+"/"+(mm+1)+"/"+yy;
                        }
                     }
                     
                     listaResultados.removeAll();
                     cont = 0;
                     agregarResultados(fecMin, fecMax);    
                 }
                 else{
                     JOptionPane.showMessageDialog(this,"Selecione fecha válida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                 }
             }
             else{
                 JOptionPane.showMessageDialog(this,"Selecione fecha", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
             }
             
             //System.out.println("");
             //--------------------------------------------------------------------
            /*if(tabla.getSelectedRow() != -1){
                int xt = tabla.getSelectedColumn();
                int yt = tabla.getSelectedRow();
                String fecha = "";
                if(tabla.getValueAt(yt, xt) != null){
                    if(mm<9){
                        if(tabla.getValueAt(yt, xt).toString().length()==2){
                            fecha = tabla.getValueAt(yt, xt).toString()+"/0"+(mm+1)+"/"+yy;
                        }
                        else{
                            fecha = "0"+tabla.getValueAt(yt, xt).toString()+"/0"+(mm+1)+"/"+yy;
                        }
                    }
                    else{
                        if(tabla.getValueAt(yt, xt).toString().length()==2){
                            fecha = tabla.getValueAt(yt, xt).toString()+"/"+(mm+1)+"/"+yy;
                        }
                        else{
                            fecha = "0"+tabla.getValueAt(yt, xt).toString()+"/"+(mm+1)+"/"+yy;
                        }
                    }
                    listaResultados.removeAll();
                    cont = 0;
                    agregarResultados(fecha);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Selecione una fecha", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Selecione una fecha", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }*/
        }        
        if(e.getSource() == b_cancelar){
            if(con != null && con.getEstado()==1){
                con.desconectar();
            }
            this.setVisible(false);
            this.dispose();
        }
        if(e.getSource() == b_detalles){
            if(listaResultados.getSelectedRow() !=- 1){
                detalles(listaResultados.getValueAt(listaResultados.getSelectedRow(),0).toString());
            }
        }
    }
    
    public void detalles(String valor){
        int id_cto = Integer.parseInt(valor);
        
        //EditarContrato obj = new EditarContrato(dirIP,id_cto);
        new EditarNuevoContrato(dirIP, id_cto);
    }
    
    @SuppressWarnings("unused")
    public void agregarResultados(String fecMin, String fecMax){ 
        
        try{
            if(con==null){
                conectar();
            }
            if(con.getEstado() == 0){
                con.conectar();
            }
            if(con.getEstado() == 1){            
                String query, queryCount;
                java.sql.ResultSet res;
                int count=0;
                
                queryCount = "select count(*) from CONTRATOS cto, CLIENTES cte where cto.CTE_CEDULA = cte.CEDULA and (cto.ESTADO='ACTIVO' or cto.ESTADO='PENDIENTE') and";
                
                query = "select cto.ID, cte.CEDULA, cte.NOMBRE, to_char(cto.FECHA_ENTREGA,'DD/MM/YYYY'), to_char(cto.FECHA_DEVOLUCION,'DD/MM/YYYY'), cto.ESTADO from CONTRATOS cto, CLIENTES cte where cto.CTE_CEDULA = cte.CEDULA and";
                String op = jComboBox1.getSelectedItem().toString();
                String opwhere = "";
                String tipo = "";
                if(op.compareToIgnoreCase("Entregas")==0){                    
                    opwhere = " cto.Estado='PENDIENTE' and cto.FECHA_ENTREGA between TO_DATE('"+fecMin+"','DD/MM/YYYY') and TO_DATE('"+fecMax+"','DD/MM/YYYY')";
                    tipo = "Entrega   ";
                }
                if(op.compareToIgnoreCase("Devoluciones")==0){
                     opwhere = " cto.Estado='ACTIVO' and cto.FECHA_DEVOLUCION between TO_DATE('"+fecMin+"','DD/MM/YYYY') and TO_DATE('"+fecMax+"','DD/MM/YYYY')";
                     tipo = "Devolución";
                }
                if(op.compareTo("Todas")==0){
                     opwhere = " (cto.Estado='PENDIENTE' or cto.ESTADO='ACTIVO') and ((cto.FECHA_ENTREGA between TO_DATE('"+fecMin+"','DD/MM/YYYY') and TO_DATE('"+fecMax+"','DD/MM/YYYY')) or (cto.FECHA_DEVOLUCION between TO_DATE('"+fecMin+"','DD/MM/YYYY') and TO_DATE('"+fecMax+"','DD/MM/YYYY')))";
                     tipo="";
                     //opwhere = "";
                     //queryCount = "select (select count(*) from CONTRATOS cto, CLIENTES cte where cto.CTE_CEDULA = cte.CEDULA and and (cto.Estado='PENDIENTE' or cto.ESTADO='ACTIVO') and ((cto.FECHA_ENTREGA between '01/11/2009' and '07/11/2009') or (cto.FECHA_DEVOLUCION between '01/11/2009' and '07/11";
                     
                }
                query = query + opwhere + "order by cto.ID";
                queryCount = queryCount + opwhere;
                //System.out.println(query);
                //System.out.println(queryCount);
                res = con.consultar(queryCount);
                res.next();
                count = Integer.parseInt(res.getString(1));
                Object[][] dat = new Object[count][6];
                
                res = con.consultar(query);
                int entra = 0;
                while(res.next()){
                    entra = 1;
                    String idCto = "";
                    String ced = "";
                    
					String nom = "";
                    String fecEntrega = "";
                    String fecDevolucion = "";
                    String linea = "";
                    
                    idCto = " 000000"+res.getString(1);
                    idCto = idCto.substring(idCto.length()-6, idCto.length());
                    ced = res.getString(2);
                    fecEntrega = res.getString(4);
                    fecDevolucion = res.getString(5);                    
                    String estado = res.getString(6);
                    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
                    Date d1 = df.parse(fecMin);
                    Date d2 = df.parse(fecMax);
                    
                    
                    if(estado.compareToIgnoreCase("ACTIVO")==0){
                        tipo = "Devolución";
                    }
                    if(estado.compareToIgnoreCase("PENDIENTE")==0){
                        tipo = "  Entrega   ";
                    }
                    /*if(fecEntrega.compareTo(fecMin) == 0 || (fecEntrega.compareTo(fecMin)>=1 && fecEntrega.compareTo(fecMax)<=-1)){
                        tipo = "  Entrega   ";
                    }
                    else{
                        tipo = "Devolución";
                    }*/
                    
                    //if(tipo.compareTo("") == 0){
                    //System.out.println(fecEntrega+" "+fec);
                    /*if(fecEntrega.compareTo(fec) == 0){
                        tipo = "  Entrega   ";
                    }
                    else{
                        tipo = "Devolución";
                    }*/
                    //}                    
                    //linea = idCto+ " -- "+ced+" -- "+fecEntrega+" -- "+fecDevolucion+" -- "+tipo+" -- "+res.getString(3);
                    //"Contrato", "Entrega", "Devolución", "Cédula", "Nombre", "Tipo"
                    
                    
                    int in = 0;
                    /*for(int i=0;i<listaResultados.getRowCount();i++){
                        if(listaResultados.getValueAt(i,0) != null && listaResultados.getValueAt(i,0).toString().compareTo(idCto) == 0){
                            in = 1;
                            break;
                        }
                    }*/
                    if(in == 0){
                        dat[cont][0] = idCto;
                        dat[cont][1] = fecEntrega;
                        dat[cont][2] = fecDevolucion;
                        dat[cont][3] = ced;
                        dat[cont][4] = res.getString(3);
                        dat[cont][5] = tipo;
                        cont++;
                    }
                }
                modeloResultados.setDataVector(dat, new String [] {
                    "Contrato", "Entrega", "Devolución", "Cédula", "Nombre", "Tipo"
                });  
                if(entra == 0){
                    JOptionPane.showMessageDialog(this,"No se encontraron resultados para esa fecha", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                //con.desconectar();
            }
            else{
                JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
        catch(Exception e){e.printStackTrace();}
    }
    @SuppressWarnings("unused")
   public void agregarResultados(String fec){ 
        
        try{
            if(con==null){
                conectar();
            }
            if(con.getEstado() == 0){
                con.conectar();
            }
            if(con.getEstado() == 1){            
                String query, queryCount;
                java.sql.ResultSet res;
                int count=0;
                
                queryCount = "select count(*) from CONTRATOS cto, CLIENTES cte where cto.CTE_CEDULA = cte.CEDULA and (cto.ESTADO='ACTIVO' or cto.ESTADO='PENDIENTE') and";
                
                query = "select cto.ID, cte.CEDULA, cte.NOMBRE, to_char(cto.FECHA_ENTREGA,'DD/MM/YYYY'), to_char(cto.FECHA_DEVOLUCION,'DD/MM/YYYY') from CONTRATOS cto, CLIENTES cte where cto.CTE_CEDULA = cte.CEDULA and (cto.ESTADO='ACTIVO' or cto.ESTADO='PENDIENTE') and";
                String op = jComboBox1.getSelectedItem().toString();
                String opwhere = "";
                String tipo = "";
                if(op.compareToIgnoreCase("Entregas")==0){
                    opwhere = " cto.FECHA_ENTREGA = '"+fec+"'";
                    tipo = "Entrega   ";
                }
                if(op.compareToIgnoreCase("Devoluciones")==0){
                     opwhere = " cto.FECHA_DEVOLUCION = '"+fec+"'";
                     tipo = "Devolución";
                }
                if(op.compareTo("Todas")==0){
                     opwhere = " (cto.FECHA_ENTREGA = '"+fec+"' or cto.FECHA_DEVOLUCION = '"+fec+"')";
                     tipo="";
                }
                query = query + opwhere + "order by cto.ID";
                queryCount = queryCount + opwhere;
                
                res = con.consultar(queryCount);
                res.next();
                count = Integer.parseInt(res.getString(1));
                Object[][] dat = new Object[count][6];
                
                res = con.consultar(query);
                int entra = 0;
                while(res.next()){
                    entra = 1;
                    String idCto = "";
                    String ced = "";
                    String nom = "";
                    String fecEntrega = "";
                    String fecDevolucion = "";
                    String linea = "";
                    
                    idCto = " 000000"+res.getString(1);
                    idCto = idCto.substring(idCto.length()-7, idCto.length());
                    ced = res.getString(2);
                    fecEntrega = res.getString(4);
                    fecDevolucion = res.getString(5);                    
                    
                    //if(tipo.compareTo("") == 0){
                    //System.out.println(fecEntrega+" "+fec);
                        if(fecEntrega.compareTo(fec) == 0){
                            tipo = "  Entrega   ";
                        }
                        else{
                            tipo = "Devolución";
                        }
                    //}                    
                    //linea = idCto+ " -- "+ced+" -- "+fecEntrega+" -- "+fecDevolucion+" -- "+tipo+" -- "+res.getString(3);
                    //"Contrato", "Entrega", "Devolución", "Cédula", "Nombre", "Tipo"
                    
                    
                    int in = 0;
                    /*for(int i=0;i<listaResultados.getRowCount();i++){
                        if(listaResultados.getValueAt(i,0) != null && listaResultados.getValueAt(i,0).toString().compareTo(idCto) == 0){
                            in = 1;
                            break;
                        }
                    }*/
                    if(in == 0){
                        dat[cont][0] = idCto;
                        dat[cont][1] = fecEntrega;
                        dat[cont][2] = fecDevolucion;
                        dat[cont][3] = ced;
                        dat[cont][4] = res.getString(3);
                        dat[cont][5] = tipo;
                        cont++;
                    }
                }
                modeloResultados.setDataVector(dat, new String [] {
                    "Contrato", "Entrega", "Devolución", "Cédula", "Nombre", "Tipo"
                });  
                if(entra == 0){
                    JOptionPane.showMessageDialog(this,"No se encontraron resultados para esa fecha", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
                //con.desconectar();
            }
            else{
                JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
        catch(Exception e){e.printStackTrace();}
    }
    
    public void conectar(){
        con = null;
        con = new Conexion(dirIP);
        if(con.conectar() == 0){
            JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
}