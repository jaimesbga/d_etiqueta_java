import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AgregarUbicacion extends javax.swing.JFrame {
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2269411021380146943L;
	public AgregarUbicacion(String ip) {
        dirIP = ip;
        
        initComponents();
        init2();
        cargarVentana();
        
        setVisible(true);
    }    
                       
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("D' Etiqueta - Ubicaciones");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrar(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Pago.gif")));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestionar Ubicaciones"));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jTextField1.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButton1.setMnemonic('G');
        jButton1.setText("Guardar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar(evt);
            }
        });

        jButton2.setMnemonic('C');
        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jButton1)
                        .addGap(68, 68, 68)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(29, 29, 29))
        );
        pack();
    }                        

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
        if(con.getEstado() == 1){
            con.desconectar();
        }
        dispose();
    }                                     

    private void guardar(java.awt.event.ActionEvent evt) {                         
        if(jTextField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Falta la Ubicación", "Advertencia", JOptionPane.OK_OPTION);
        }
        else{
            if(con.getEstado() == 1){
                String query = "select count(*) from UBICACIONES where DESCRIPCION = '"+jTextField1.getText()+"'";
                java.sql.ResultSet res = con.consultar(query);
                try {
                    res.next();
                    String cant = res.getString(1);
                    if(cant.compareTo("0") == 0){
                        query = "select max(ID)+1 from UBICACIONES";
                        res = con.consultar(query);
                        res.next();
                        String id = res.getString(1);
                        query = "insert into UBICACIONES values('"+id+"', '"+jTextField1.getText()+"')";
                        if(con.actualizar(query) == 1){                            
                            JOptionPane.showMessageDialog(this,"Registro Exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            cargarVentana();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"La Ubicación ya existe", "Advertencia", JOptionPane.OK_OPTION);
                    }
                }
                catch (Exception e) {

                }
            }
        }        
    }                        

    private void cerrar(java.awt.event.WindowEvent evt) {                        
        if(con.getEstado() == 1){
            con.desconectar();
        }
        dispose();
    }                       
    
    private void init2(){
        con = new Conexion(dirIP);
        if(con.conectar() == 0){
            JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
        modelo = new DefaultListModel();
        jList1.setModel(modelo);
        jList1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int minselec = jList1.getMinSelectionIndex();
                int maxselec = jList1.getMaxSelectionIndex();
                int value=0;
                for(int i = minselec; i<=maxselec;i++){
                    if(jList1.isSelectedIndex(i)){
                        value = i;
                        break;
                    }
                }
                if(value == 0){
                    jTextField1.setText("");
                    jTextField1.setEditable(true);
                    jButton1.setEnabled(true);
                }
                else{
                    jTextField1.setEditable(false);
                    jButton1.setEnabled(false);
                    jTextField1.setText(modelo.getElementAt(value).toString());
                }
            }
        });
        
        java.awt.Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(d.getWidth()/2-this.getWidth()/2), (int)(d.getHeight()/2-this.getHeight()/2));
    }
    
    public void cargarVentana(){
        modelo.clear();
        String query = "select * from UBICACIONES order by ID";
        java.sql.ResultSet res = con.consultar(query);
        try {
            modelo.addElement("Nuevo");
            while(res.next()){
                modelo.addElement(res.getString(2));
            }
        }
        catch (Exception e) {
            
        }
    }
    
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarUbicaciones("127.0.0.1");
            }
        });
    }*/
    
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    
    private DefaultListModel modelo;
    private String dirIP;
    private Conexion con;
}
