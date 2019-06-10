import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class BuscarPedidos_L extends javax.swing.JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton anoMay;
    private javax.swing.JButton anoMen;
    private javax.swing.JButton b_buscar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JButton b_detalles;
    private javax.swing.JButton b_limpiar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l_imagen;
    private javax.swing.JList listaResultados;
    private javax.swing.JButton mesMay;
    private javax.swing.JButton mesMen;
    private DefaultTableModel_M modeloTabla = null;
    private javax.swing.JTable tabla;
    private DefaultListModel lista;    
            
    private String vecMes[];
    private GregorianCalendar calendar = null;
    private Date dina = null;
    private String entry;    
    private int mm;
    private int yy;
    
    private Conexion con;
    private String dirIP;
    
    public BuscarPedidos_L(String ip) {
        dirIP = ip;
        
        initComponents();
        init2();
        
        calendar = null;
        dina = null;
        
        conectar();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listaResultados = new javax.swing.JList();
        b_limpiar = new javax.swing.JButton();
        b_detalles = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione Fecha"));
        modeloTabla = new DefaultTableModel_M(new Object [][] {
            {null,null ,null ,null },
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}},
            new String [] {
                "Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"
        });
        tabla.setModel(modeloTabla);
        tabla.getTableHeader().setReorderingAllowed(false);
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
                .addContainerGap(45, Short.MAX_VALUE)
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entregas", "Devoluciones", "Todas" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));
        jScrollPane2.setViewportView(listaResultados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        b_limpiar.setText("Limpiar");

        b_detalles.setText("Detalles");

        b_cancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l_imagen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(b_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(b_detalles)
                        .addGap(78, 78, 78)
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
                        .addGap(85, 85, 85)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_buscar)
                            .addComponent(b_limpiar))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
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
        
        lista = new DefaultListModel();
        listaResultados.setModel(lista);
        
        mesMen.addActionListener(this);
        mesMay.addActionListener(this);
        anoMen.addActionListener(this);
        anoMay.addActionListener(this);
        b_buscar.addActionListener(this);
        b_cancelar.addActionListener(this); 
        b_limpiar.addActionListener(this); 
        b_detalles.addActionListener(this); 
    }
    
    public void conectar(){
        con = null;
        con = new Conexion(dirIP);
        if(con.conectar() == 0){
            JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
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
            if(tabla.getSelectedRow() != -1){
                int xt = tabla.getSelectedColumn();
                int yt = tabla.getSelectedRow();
                String fecha = "";
                if(tabla.getValueAt(yt, xt) != null){
                    if(mm<9){
                        fecha = tabla.getValueAt(yt, xt).toString()+"/0"+(mm+1)+"/"+yy;
                    }
                    else{
                        fecha = tabla.getValueAt(yt, xt).toString()+"/"+(mm+1)+"/"+yy;
                    }
                    agregarResultados(fecha);
                }
            }
        }
        if(e.getSource() == b_limpiar){
            lista.clear();
        }
        if(e.getSource() == b_cancelar){
            con.desconectar();
            this.setVisible(false);
            this.dispose();
        }
        if(e.getSource() == b_detalles){
            if(listaResultados.getSelectedIndex() !=- 1){
                detalles(lista.getElementAt(listaResultados.getSelectedIndex()).toString());
            }
        }
    }
    
    public void agregarResultados(String fec){
        try{
            if(con.getEstado() == 0){
                conectar();
            }
            if(con.getEstado() == 1){
                String query = "select cto.ID, cte.CEDULA, cte.NOMBRE, to_char(cto.FECHA_ENTREGA,'DD/MM/YYYY'), to_char(cto.FECHA_DEVOLUCION,'DD/MM/YYYY')  from CONTRATOS cto, CLIENTES cte where cto.CTE_CEDULA = cte.CEDULA and cto.ESTADO='Activo' and";
                String op = jComboBox1.getSelectedItem().toString();
                String opwhere = "";
                String tipo = "";
                if(op.compareTo("Entregas")==0){
                    opwhere = " cto.FECHA_ENTREGA = '"+fec+"'";
                    tipo = "Entrega   ";
                }
                if(op.compareTo("Devoluciones")==0){
                     opwhere = " cto.FECHA_DEVOLUCION = '"+fec+"'";
                     tipo = "Devolución";
                }
                if(op.compareTo("Todas")==0){
                     opwhere = " (cto.FECHA_ENTREGA = '"+fec+"' or cto.FECHA_DEVOLUCION = '"+fec+"')";
                }
                query = query + opwhere + "order by cto.ID";
                
                java.sql.ResultSet res = con.consultar(query);
                int entra = 0;
                while(res.next()){
                    entra = 1;
                    String idCto = "";
                    String ced = "";
                    @SuppressWarnings("unused")
					final String nom = "";
                    String fecEntrega = "";
                    String fecDevolucion = "";
                    String linea = "";
                    
                    idCto = " 000000"+res.getString(1);
                    idCto = idCto.substring(idCto.length()-7, idCto.length());
                    ced = "          "+res.getString(2);
                    ced = ced.substring(ced.length()-10, ced.length());
                    fecEntrega = "          "+res.getString(4);
                    fecEntrega = fecEntrega.substring(fecEntrega.length()-10, fecEntrega.length());
                    fecDevolucion = "          "+res.getString(5);
                    fecDevolucion = fecDevolucion.substring(fecDevolucion.length()-10, fecDevolucion.length());
                    
                    if(tipo.compareTo("") == 0){
                        if(fecEntrega.compareTo(fec) == 0){
                            tipo = "  Entrega   ";
                        }
                        else{
                            tipo = "Devolución";
                        }
                    }
                    
                    linea = idCto+ " -- "+ced+" -- "+fecEntrega+" -- "+fecDevolucion+" -- "+tipo+" -- "+res.getString(3);
                    int in = 0;
                    for(int i=0;i<lista.getSize();i++){
                        if(lista.getElementAt(i).toString().compareTo(linea)==0){
                            in = 1;
                            break;
                        }
                    }
                    if(in == 0){
                        lista.addElement(linea);
                    }
                }
                if(entra == 0){
                    JOptionPane.showMessageDialog(this,"No se encontraron resultados para esa fecha", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
        catch(Exception e){}
    }
    
    public void detalles(String valor){
        int id_cto = Integer.parseInt(valor.substring(0,valor.indexOf(" ")));
        new EditarContrato(dirIP,id_cto);
    }
}
