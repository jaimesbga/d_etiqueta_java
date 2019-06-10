import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class BuscarContrato extends javax.swing.JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaResultados;
    private javax.swing.JTextField t_cedula;
    private javax.swing.JTextField t_codigo;
    private javax.swing.JTextField t_fechaEmision;
    private javax.swing.JTextField t_fechaEntrega;
    private javax.swing.JTextField t_fechaDevolucion;
    private DefaultTableModel_M modeloResultados = null;
    
    private Conexion con;
    
    private String dirIP;
    
    public BuscarContrato(javax.swing.JFrame parent, String ip) {
        super(parent, true);        
        dirIP = ip;
        
        conectar();
        
        initComponents();
        
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        int xf = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int yf = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(xf, yf));
        inicializar();
        setVisible(true);
    }
    
    public BuscarContrato(javax.swing.JDialog parent, String ip) {
        super(parent, true);
        dirIP = ip;
        
        conectar();
        
        initComponents();
        
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        int xf = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int yf = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(xf, yf));
        inicializar();
        setVisible(true);
    }
    
    public void inicializar(){
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
        t_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode()==10){
                    buscar(null);
                }
            }
        });
        t_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode()==10){
                    buscar(null);
                }
            }
        });
        /*t_fechaEmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ingresarFecha(t_fechaEmision);
                evt.consume();
            }
        });*/
        t_fechaEmision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarFecha(t_fechaEmision);
            }
        });
        /*t_fechaEntrega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ingresarFecha(t_fechaEntrega);
                evt.consume();
            }
        });*/
        t_fechaEntrega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarFecha(t_fechaEntrega);
            }
        });
        /*t_fechaDevolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ingresarFecha(t_fechaDevolucion);
                evt.consume();
            }
        });*/
        t_fechaDevolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarFecha(t_fechaDevolucion);
            }
        });
    }
    
    public void conectar(){
        con = null;
        con = new Conexion(dirIP);
        if(con.conectar() == 0){
            JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
         
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        t_codigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        t_cedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t_fechaEmision = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t_fechaEntrega = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        t_fechaDevolucion = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaResultados = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("D' Etiqueta - Buscar Contrato");
        setResizable(false);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Pago.gif")));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        jButton1.setMnemonic('B');
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar(evt);
            }
        });
        
        jLabel2.setText("C\u00f3digo:");

        jLabel3.setText("C.I.:");

        jLabel4.setText("Fecha Emisi\u00f3n:");

        jLabel5.setText("Fecha Entrega:");

        jLabel6.setText("Fecha Devoluci\u00f3n:");

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarFecha(t_fechaEmision);
            }
        });

        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarFecha(t_fechaEntrega);
            }
        });
        
        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarFecha(t_fechaDevolucion);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t_fechaEntrega)
                    .addComponent(t_cedula)
                    .addComponent(t_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(t_fechaEmision, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(t_fechaDevolucion))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(42, 42, 42)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(t_fechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_fechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton5))
                .addGap(20, 20, 20))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));
        
        modeloResultados = new DefaultTableModel_M(null,
            new String [] {
                "Contrato", "Estado", "Fecha Emisión", "Cédula", "Nombre"
        });
        listaResultados.setModel(modeloResultados);
        listaResultados.getTableHeader().setReorderingAllowed(false);
        
        jScrollPane1.setViewportView(listaResultados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setMnemonic('A');
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               aceptar(evt);
            }
        });

        jButton6.setMnemonic('C');
        jButton6.setText("Cancelar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        java.awt.Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(d.getWidth()/2-this.getWidth()/2), (int)(d.getHeight()/2-this.getHeight()/2));
    }
    
   private void ingresarFecha(javax.swing.JTextField txt) {                               
        Calendario obj = new Calendario(this, "Seleccione fecha");
        String agrega = "";
        agrega = obj.getAgrega();
        obj.dispose();
        if(!agrega.isEmpty()){
            txt.setText(agrega);
        }
    }
    
    private void buscar(java.awt.event.ActionEvent evt){
        String query = "";
        String queryCont = "";
        String idCto = "";
        String idCte = "";
        String fecEmision = "";
        String fecEntrega = "";
        String fecDevolucion = "";
        
        fecDevolucion = t_fechaDevolucion.getText();        
        query = "select cto.ID, cto.ESTADO, cte.CEDULA, cte.NOMBRE, to_char(cto.FECHA_EMISION,'DD/MM/YYYY')  from CONTRATOS cto, CLIENTES cte where cto.CTE_CEDULA = cte.CEDULA";
        queryCont = "select count(*) from CONTRATOS where '1'='1'";
        
        try{
            if(!t_codigo.getText().isEmpty()){
                idCto = " and ID = '"+t_codigo.getText()+"'";
            }
        }
        catch(Exception er){
            JOptionPane.showMessageDialog(this,"Formato del Código Incorrecto", "Advertencia", JOptionPane.OK_OPTION);
        }
        if(!t_cedula.getText().isEmpty()){
            idCte = " and CTE_CEDULA = '"+t_cedula.getText()+"'";
        }
        if(!t_fechaEmision.getText().isEmpty()){
            fecEmision = " and FECHA_EMISION = TO_DATE('"+t_fechaEmision.getText()+"', 'DD/MM/YYYY')";
        }
        if(!t_fechaEntrega.getText().isEmpty()){
            fecEntrega = " and FECHA_ENTREGA = TO_DATE('"+t_fechaEntrega.getText()+"', 'DD/MM/YYYY')";
        }
        if(!t_fechaDevolucion.getText().isEmpty()){
            fecDevolucion = " and FECHA_DEVOLUCION = TO_DATE('"+t_fechaDevolucion.getText()+"', 'DD/MM/YYYY')";
        }
        
        query = query + idCto + idCte + fecEmision + fecEntrega + fecDevolucion + " order by cto.ID";
        queryCont = queryCont + idCto + idCte + fecEmision + fecEntrega + fecDevolucion;        
        
        try {
            if(con.getEstado()==0){
                conectar();
            }
            
            if(con.getEstado()==1){
                //System.out.println(queryCont);
                java.sql.ResultSet res = con.consultar(queryCont);
                res.next();
                Object dat[][] = new Object[Integer.parseInt(res.getString(1))][5];
                
                listaResultados.removeAll();
                try{
                    res = con.consultar(query);
                }
                catch(java.lang.IllegalThreadStateException ee){}
                
                int cont = 0;
                while(res.next()){
                    String id_cto = " 0000000"+res.getString(1);
                    id_cto = id_cto.substring(id_cto.length()-6, id_cto.length());
                    String est_cto = res.getString(2);
                    String id_cte = res.getString(3);
                    String fec_cto = res.getString(5);
                    String nom_cte = res.getString(4);
                                        
                    //linea = id_cto+"  --  "+est_cto+"  --  "+id_cte+"  --  "+fec_cto+"  --  "+nom_cte;
                    //"Contrato", "Estado", "Fecha Emisión", "Cédula", "Nombre"
                    dat[cont][0] = id_cto;
                    dat[cont][1] = est_cto;
                    dat[cont][2] = fec_cto;
                    dat[cont][3] = id_cte;
                    dat[cont][4] = nom_cte;
                    
                    cont++;
                }
                modeloResultados.setDataVector(dat, new String [] {
                    "Contrato", "Estado", "Fecha Emisión", "Cédula", "Nombre"
                });  
                if(cont == 0){
                    JOptionPane.showMessageDialog(this,"No se encontraron resultados", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
                
                //listaResultados.setListData(lista);
            }
            else{
                JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
        catch (Exception er) {  }
    }
    
    public void aceptar(java.awt.event.ActionEvent evt){
        int index = listaResultados.getSelectedRow();
        if(index >=0){
            int idCto = Integer.parseInt(listaResultados.getValueAt(index,0).toString());
            if(con.getEstado() == 1){            
                con.desconectar();
            }
            
            this.dispose();
             new EditarNuevoContrato(dirIP,idCto);
        }
    }
    
    public void cancelar(){
        if(con.getEstado() == 1){            
            con.desconectar();
        }
        this.dispose();
    }
}
