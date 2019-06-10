
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;

public class BuscarProximasEntregas extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel_M modeloResultados = null;
    private String calendario[][];
    private GregorianCalendar calendar = null;
    private Date dina = null;
    private String entry;
    private int mm;
    private int yy;

    private String dirIP;
    
    public BuscarProximasEntregas(String ip) {
        dirIP = ip;
        initComponents();
        init2();
        cargarCalendario();
        this.setVisible(true);
        consultar();
        
    }

    
 
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("D' Etiqueta - Buscar Próximas Entregas");
        setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Contrato.gif"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("Entregas desde:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contrato N°", "Entrega", "Devolución", "Cédula", "Nombre"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setMnemonic('D');
        jButton1.setText("Detallles");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            //@Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalles(evt);
            }
        });

        jButton2.setMnemonic('C');
        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            //@Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }

    private void detalles(java.awt.event.ActionEvent evt) {
        if(jTable1.getSelectedRow() !=- 1){
            String id = jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
            int cto = Integer.parseInt(id);
             new EditarNuevoContrato(dirIP, cto);
        }
    }

    private void cancelar(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public void init2(){
        java.awt.Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(d.getWidth()/2-this.getWidth()/2), (int)(d.getHeight()/2-this.getHeight()/2));

        modeloResultados = new DefaultTableModel_M(null,
            new String [] {
                "Contrato N°", "Entrega", "Devolución", "Cédula", "Nombre"
        });
        jTable1.setModel(modeloResultados);
        jTable1.getTableHeader().setReorderingAllowed(false);

        calendario = new String[6][7];
    }

    public void cargarCalendario(){
        for(int ii=0;ii<6;ii++){
            for(int jj=0;jj<7;jj++){
                calendario[ii][jj] = null;
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

        //jLabel1.setText(vecMes[mm]+" - "+yy);

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
            //tabla.setValueAt(cont, y, x);
            calendario[y][x] = String.valueOf(cont);
            cont++;
            x++;
            if(x == 7){
                x=0;
                y++;
            }
        }
    }

    public void consultar(){
        String semana = "Entregas desde: Lunes ";
        String da1 = "", ma1="", aa1="", da2 = "", ma2="", aa2="";;
        int d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int m = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int a = Calendar.getInstance().get(Calendar.YEAR);

        int sem = 0;
        for(int i=0; i<6;i++){
            for(int j=0;j<7;j++){
                if(calendario[i][j] != null && Integer.parseInt(calendario[i][j]) == d){
                    sem = i;
                    j = 10;
                    i = 10;
                }
            }
        }

        String fechaIni = "", fechaFin = "";
        
        if(calendario[sem][1]!=null){
            fechaIni = calendario[sem][1]+"/"+m+"/"+a;      
            da1 = calendario[sem][1];
            ma1 = String.valueOf(m);
            aa1 = String.valueOf(a);
        }
        if(calendario[sem][6]!=null){
            fechaFin = calendario[sem][6]+"/"+m+"/"+a;
            da2 = calendario[sem][6];
            ma2 = String.valueOf(m);
            aa2 = String.valueOf(a);
        }

        if(fechaIni.compareTo("") == 0){
            cambiarMes(1);
            m= m-1;
            for(int i=5;i>=0;i--){
                for(int j=6;j>=0;j--){
                    if(calendario[i][j] != null){
                        if(m<1){
                            m=12;
                            a = a-1;
                        }
                        fechaIni = calendario[i][1]+"/"+m+"/"+a;
                        da1 = calendario[i][1];
                        ma1 = String.valueOf(m);
                        aa1 = String.valueOf(a);
                        i=-1;
                        j=-1;
                    }
                }
            }
        }
        if(fechaFin.compareTo("") == 0){
            cambiarMes(2);
            m = m + 1;
            if(m>12){
                m = 1;
                a = a+1;
            }
            fechaFin = calendario[0][6] + "/" + m +"/" + a;
            da2 = calendario[0][6];
            ma2 = String.valueOf(m);
            aa2 = String.valueOf(a);
        }
        
        if(da1.length() == 1){
            da1 = "0" + da1;
        }
         if(da2.length() == 1){
            da2 = "0" + da2;
        }
         if(ma1.length() == 1){
            ma1 = "0" + ma1;
        }
         if(ma2.length() == 1){
            ma2 = "0" + ma2;
        }
        
        semana = semana+da1+"/"+ma1+"/"+aa1+" hasta el Sábado "+da2+"/"+ma2+"/"+aa2;
        System.out.println(semana);
        jLabel2.setText(semana);

        //System.out.println("Fecha ini es: "+fechaIni);
        //System.out.println("Fecha fin es: "+fechaFin);

        agregarResultados(fechaIni, fechaFin);
    }

    @SuppressWarnings("static-access")
	public void cambiarMes(int opcion){
        //1 mes menor  2 mes mayor
        /*if (e.getSource() == anoMen){
            entry = "1/"+(calendar.get(Calendar.MONTH)+1)+"/"+(calendar.get(Calendar.YEAR)-1);
            cargarTabla();
	}
	if (e.getSource() == anoMay){
            entry = "1/"+(calendar.get(Calendar.MONTH)+1)+"/"+(calendar.get(Calendar.YEAR)+1);
            cargarTabla();
	}*/
	if (opcion == 1){
            entry = "1/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR);
            cargarCalendario();
	}
	if (opcion == 2){
            if(calendar.get(calendar.MONTH)+2 < 13){
                entry = "1/"+(calendar.get(Calendar.MONTH)+2)+"/"+calendar.get(Calendar.YEAR);
            }
            else{
                entry = "1/1/"+(calendar.get(Calendar.YEAR)+1);
            }

            cargarCalendario();
        }
    }
    @SuppressWarnings("unused")
    public void agregarResultados(String fecMin, String fecMax){
        Conexion con;

        try{
            con = new Conexion(dirIP);
            if(con.getEstado() == 0){
                con.conectar();
            }
            if(con.getEstado() == 1){
                String query, queryCount;
                java.sql.ResultSet res;
                int count=0;

                queryCount = "select count(*) from CONTRATOS cto, CLIENTES cte where cto.CTE_CEDULA = cte.CEDULA and (cto.ESTADO='ACTIVO' or cto.ESTADO='PENDIENTE') and";

                query = "select cto.ID, cte.CEDULA, cte.NOMBRE, to_char(cto.FECHA_ENTREGA,'DD/MM/YYYY'), to_char(cto.FECHA_DEVOLUCION,'DD/MM/YYYY'), cto.ESTADO from CONTRATOS cto, CLIENTES cte where cto.CTE_CEDULA = cte.CEDULA and";
                String op = "Entregas";
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
                Object[][] dat = new Object[count][5];

                res = con.consultar(query);
                int entra = 0;
                int cont = 0;
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
                    int in = 0;
                    if(in == 0){
                        dat[cont][0] = idCto;
                        dat[cont][1] = fecEntrega;
                        dat[cont][2] = fecDevolucion;
                        dat[cont][3] = ced;
                        dat[cont][4] = res.getString(3);
                        //dat[cont][5] = tipo;
                        cont++;
                    }
                }
                modeloResultados.setDataVector(dat, new String [] {
                    "Contrato Nº", "Entrega", "Devolución", "Cédula", "Nombre"
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

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration

}
