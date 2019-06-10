import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;

public class InformeDiario extends javax.swing.JFrame implements ActionListener{    
    
    public InformeDiario(String ip) {
        dirIP = ip;
        
        initComponents();
        init2();
        
        this.setVisible(true);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        mesMen = new javax.swing.JButton();
        mesMay = new javax.swing.JButton();
        anoMen = new javax.swing.JButton();
        anoMay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resumen Diario");
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen Diario"));
        jLabel3.setText("Cantidad de Contratos:");

        jLabel4.setText("Efectivo:");

        jLabel5.setText("Cheques:");

        jLabel6.setText("Tarjeta de Cr\u00e9dito:");

        jLabel7.setText("Tarjeta de D\u00e9bito:");

        jLabel8.setText("Otros:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel9.setText("Total:");

        jTextField1.setEditable(false);
        jTextField1.setText("0");

        jTextField2.setEditable(false);
        jTextField2.setText("0");

        jTextField3.setEditable(false);
        jTextField3.setText("0");

        jTextField4.setEditable(false);
        jTextField4.setText("0");

        jTextField5.setEditable(false);
        jTextField5.setText("0");

        jTextField6.setEditable(false);
        jTextField6.setText("0");

        jTextField7.setEditable(false);
        jTextField7.setText("0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setText("Res\u00famen: --/--/----");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Pago.gif")));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel12.setText("al --/--/----");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel5))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(94, 94, 94))
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione Fecha"));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(anoMen)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mesMen)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mesMay)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(anoMay)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anoMen)
                    .addComponent(mesMen)
                    .addComponent(anoMay)
                    .addComponent(mesMay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jButton1.setMnemonic('C');
        jButton1.setText("Cerrar");

        jButton2.setMnemonic('B');
        jButton2.setText("Buscar");

        jButton3.setMnemonic('I');
        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimir(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton2)
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jButton3)
                .addGap(58, 58, 58)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(93, 93, 93)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>                        

    private void imprimir(java.awt.event.ActionEvent evt) {                          
        PrintJob mip = getToolkit().getPrintJob(this,jLabel10.getText(),null);            
        if(mip!=null){
            /*javax.swing.JPanel miPanel = new javax.swing.JPanel();
            miPanel =  jPanel1;
            miPanel.setBackground(java.awt.Color.WHITE);*/
            Graphics imp = mip.getGraphics();            
            if(imp!=null){
                //miPanel.printAll(imp);
                jPanel1.printAll(imp);
                imp.dispose();
            }
        }
        if(mip!=null){
            mip.end();
        }
    }                         
        
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformeDiario("127.0.0.1");
            }
        });
    }*/
    
    public void init2(){
        jLabel12.setVisible(false);
        
        String meses = "Enero Febrero Marzo Abril Mayo Junio Julio Agosto Septiembre Octubre Noviembe Diciembre";
        vecMes = meses.split(" ");        
        
        mesMen.addActionListener(this);
        mesMay.addActionListener(this);
        anoMen.addActionListener(this);
        anoMay.addActionListener(this);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        
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
        
        cargarTabla();
        
        con = new Conexion(dirIP);
        java.awt.Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(d.getWidth()/2-this.getWidth()/2), (int)(d.getHeight()/2-this.getHeight()/2));
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
        if(e.getSource() == jButton2){
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
                     
                     //listaResultados.removeAll();
                     //cont = 0;
                     jLabel10.setText("Resúmen: "+fecMin);
                     if(fecMin.compareToIgnoreCase(fecMax) ==0 ){
                         jLabel12.setVisible(false);
                     }
                     else{
                         jLabel12.setVisible(true);
                         jLabel12.setText("al "+fecMax);
                     }
                     agregarResultados(fecMin, fecMax);    
                 }
                 else{
                     JOptionPane.showMessageDialog(this,"Selecione fecha válida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                 }
             }
             else{
                 JOptionPane.showMessageDialog(this,"Selecione fecha", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
             }
        }
        if (e.getSource() == jButton1){
            this.setVisible(false);
            this.dispose();
        }
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
    
    public void agregarResultados(String fecMin, String fecMax){ 
        if(con.conectar() == 1){
            String query = "";
            query = "select "
                    +"(select count(*) from CONTRATOS where ESTADO != 'CANCELADO' and FECHA_EMISION between DATE_FORMAT('"+fecMin+"','%Y-%m-%d') and DATE_FORMAT('"+fecMax+"','%Y-%m-%d')), "
                    +"(select IFNULL(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.TPGO_ID='01' and p.FECHA between DATE_FORMAT('"+fecMin+"','%Y-%m-%d') and DATE_FORMAT('"+fecMax+"','%Y-%m-%d')), "
                    +"(select IFNULL(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.TPGO_ID='02' and p.FECHA between DATE_FORMAT('"+fecMin+"','%Y-%m-%d') and DATE_FORMAT('"+fecMax+"','%Y-%m-%d')), "
                    +"(select IFNULL(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.TPGO_ID='03' and p.FECHA between DATE_FORMAT('"+fecMin+"','%Y-%m-%d') and DATE_FORMAT('"+fecMax+"','%Y-%m-%d')), "
                    +"(select IFNULL(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.TPGO_ID='04' and p.FECHA between DATE_FORMAT('"+fecMin+"','%Y-%m-%d') and DATE_FORMAT('"+fecMax+"','%Y-%m-%d')), "
                    +"(select IFNULL(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.TPGO_ID='05' and p.FECHA between DATE_FORMAT('"+fecMin+"','%Y-%m-%d') and DATE_FORMAT('"+fecMax+"','%Y-%m-%d')), "
                    +"(select IFNULL(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.FECHA between DATE_FORMAT('"+fecMin+"','%Y-%m-%d') and DATE_FORMAT('"+fecMax+"','%Y-%m-%d')) "
                    +"from dual";
            System.out.println(query);
            java.sql.ResultSet res = con.consultar(query);
            try{
                if(res.next()){
                    jTextField1.setText(res.getString(1));
                    jTextField2.setText(res.getString(2));
                    jTextField3.setText(res.getString(3));
                    jTextField4.setText(res.getString(4));
                    jTextField5.setText(res.getString(5));
                    jTextField6.setText(res.getString(6));
                    jTextField7.setText(res.getString(7));
                }
            }
            catch(Exception er){}
            
            con.desconectar();
        }
        else{
            JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
    }    
    
    public void agregarResultados(String fecha){
        if(con.conectar() == 1){
            String query = "";
            query = "select "
                    +"(select count(*) from CONTRATOS where ESTADO != 'CANCELADO' and FECHA_EMISION = '"+fecha+"'), "
                    +"(select nvl(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.TPGO_ID='01' and p.FECHA = to_date('"+fecha+"','DD/MM/YYYY')), "                    
                    +"(select nvl(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.TPGO_ID='02' and p.FECHA = to_date('"+fecha+"','DD/MM/YYYY')), "
                    +"(select nvl(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.TPGO_ID='03' and p.FECHA = to_date('"+fecha+"','DD/MM/YYYY')), "
                    +"(select nvl(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.TPGO_ID='04' and p.FECHA = to_date('"+fecha+"','DD/MM/YYYY')), "
                    +"(select nvl(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.TPGO_ID='05' and p.FECHA = to_date('"+fecha+"','DD/MM/YYYY')), "
                    +"(select nvl(sum(p.MONTO),0) from PAGOS p, CONTRATOS c where p.CTO_ID = c.ID and c.ESTADO != 'CANCELADO' and p.MVO_ID='01' and p.FECHA = to_date('"+fecha+"','DD/MM/YYYY')) "
                    +"from dual";
            java.sql.ResultSet res = con.consultar(query);
            try{
                if(res.next()){
                    jTextField1.setText(res.getString(1));
                    jTextField2.setText(res.getString(2));
                    jTextField3.setText(res.getString(3));
                    jTextField4.setText(res.getString(4));
                    jTextField5.setText(res.getString(5));
                    jTextField6.setText(res.getString(6));
                    jTextField7.setText(res.getString(7));
                }
            }
            catch(Exception er){}
            
            con.desconectar();
        }
        else{
            JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton anoMay;
    private javax.swing.JButton anoMen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton mesMay;
    private javax.swing.JButton mesMen;
    private javax.swing.JTable tabla;
    // End of variables declaration                   
    private DefaultTableModel_M modeloCalendario = null;
    private String vecMes[];
    private GregorianCalendar calendar = null;
    private Date dina = null;
    private String entry;    
    private int mm;
    private int yy;
    
    private String dirIP;
    private Conexion con;
}
