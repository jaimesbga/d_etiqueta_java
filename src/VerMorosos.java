import javax.swing.JOptionPane;

public class VerMorosos extends javax.swing.JFrame {
    
    public VerMorosos(String ip) {
        dirIP = ip;
        
        initComponents();
        init2();
        
        cargarVentana();
        
        setVisible(true);
    }
     
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaResultados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("D' Etiqueta - Morosos");
        setResizable(false);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Contrato.gif")));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contratos Morosos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14)));
        jPanel1.setFont(new java.awt.Font("Arial", 1, 14));
        listaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contrato", "Devolución", "Cédula", "Teléfono", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(listaResultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setMnemonic('C');
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar(evt);
            }
        });

        jButton2.setMnemonic('D');
        jButton2.setText("Detalles");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalles(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jButton2)
                .addGap(52, 52, 52)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(27, 27, 27))
        );
        pack();
    }

    private void detalles(java.awt.event.ActionEvent evt) {                          
        if(listaResultados.getSelectedRow() !=- 1){
                detalles(listaResultados.getValueAt(listaResultados.getSelectedRow(),0).toString());
        }
    }                         

    public void detalles(String valor){
        int id_cto = Integer.parseInt(valor);
        
        EditarContrato obj = new EditarContrato(dirIP,id_cto);
    }
    
    public void init2(){
        modeloResultados = new DefaultTableModel_M(null,
            new String [] {
                "Contrato", "Entrega", "Devolución", "Cédula", "Nombre", "Tipo"
        });
        listaResultados.setModel(modeloResultados);
        listaResultados.getTableHeader().setReorderingAllowed(false);
        
        java.awt.Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(d.getWidth()/2-this.getWidth()/2), (int)(d.getHeight()/2-this.getHeight()/2));
    }
    
    private void cerrar(java.awt.event.ActionEvent evt) {                        
        this.setVisible(false);
        this.dispose();
    }                       
 
    public void cargarVentana(){
        javax.swing.DefaultListModel lista = new javax.swing.DefaultListModel();
        Conexion con = new Conexion(dirIP);
        if(con.conectar() == 1){
            java.sql.ResultSet res;            
            
            String queryCount = "select count(*) "
                            +"from CLIENTES cte, CONTRATOS cto "
                            +"where cto.CTE_CEDULA = cte.CEDULA and cto.ESTADO = 'ACTIVO' and cto.FECHA_DEVOLUCION < SYSDATE()";
            
            String query = "select cto.ID, DATE_FORMAT(cto.FECHA_DEVOLUCION,'%d/%m/%Y'), cte.CEDUlA, cte.NOMBRE, cte.TELEFONO1 "
                            +"from CLIENTES cte, CONTRATOS cto "
                            +"where cto.CTE_CEDULA = cte.CEDULA and cto.ESTADO = 'ACTIVO' and cto.FECHA_DEVOLUCION < SYSDATE() "
                            +"order by cto.ID";
                        
            try{
                res = con.consultar(queryCount);
                res.next();
                int count = Integer.parseInt(res.getString(1));
                Object[][] dat = new Object[count][5];
                
                res = con.consultar(query);
                int cont = 0;
                while(res.next()){
                    String idCto = " 000000"+res.getString(1);
                    idCto = idCto.substring(idCto.length()-7, idCto.length());
                    String fecha = res.getString(2);                    
                    String ced = res.getString(3);
                    String nom = res.getString(4);
                    String tlf = res.getString(5);
                    
                    dat[cont][0] = idCto;
                    dat[cont][1] = fecha;
                    dat[cont][2] = ced;
                    dat[cont][3] = tlf;
                    dat[cont][4] = nom;
                    
                    cont++;
                }
                modeloResultados.setDataVector(dat, new String [] {
                    "Contrato", "Devolución", "Cédula", "Teléfono", "Nombre"
                });
            }
            catch(Exception er){er.printStackTrace();}
            con.desconectar();
        }
        else{
            JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listaResultados;
    
    private DefaultTableModel_M modeloResultados = null;
    private String dirIP;
}
