import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
public class MostrarDisponibilidad extends javax.swing.JDialog {
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    
    private DefaultTableModel_M modelo = null;
    private String dirIP;
    private String datos[];
    private String agrega;
    
    public MostrarDisponibilidad(java.awt.Frame parent, String ip, String dat[]) {        
        super(parent, true);
        dirIP = ip;
        datos = dat;
        initComponents();
        init2();
        cargarTabla();
        
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        int xf = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int yf = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(xf, yf));
        
        setVisible(true);
    }
           
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("D' Etiqueta Disponibilidad");
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Disponibilidad"));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Entrega", "Fecha Devolución", "Ejemplar"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setMnemonic('A');
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar(evt);
            }
        });

        jButton2.setMnemonic('C');
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addGap(168, 168, 168)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pack();
    }

    private void cancelar(java.awt.event.ActionEvent evt) {                          
        agrega = "";
        this.dispose();
    }                         

    private void agregar(java.awt.event.ActionEvent evt) {                         
        int index = jTable1.getSelectedRow();
        if(index > -1){
            agrega = jTable1.getValueAt(index,2).toString();
            this.dispose();
        }
    }                        
    
    public void init2(){
        agrega = "";
        modelo = new DefaultTableModel_M(null,
            new String [] {
                "Fecha Entrega", "Fecha devolución", "Ejemplar"
        });
        jTable1.setModel(modelo);
        jTable1.getTableHeader().setReorderingAllowed(false);
        
        
    }
    
    public String getAgrega(){
        return agrega;
    }
    
    public void cargarTabla(){
        String query, queryCount;
        query = "select to_char(c.FECHA_ENTREGA,'DD/MM/YYYY'), to_char(c.FECHA_DEVOLUCION,'DD/MM/YYYY'), a.NUM_EJEMPLAR "+
                "from CONTRATOS c, ITEMS i, ACCESORIOS a "+
                "where c.ID = i.CTO_ID and i.ARO_ID = a.id and (c.ESTADO='Activo' or c.ESTADO = 'Pendiente') and "+
                "a.TARO_ID='"+datos[0]+"' and a.FARO_ID='"+datos[1]+"' and a.CARO_ID='"+datos[2]+"' and a.MARO_ID='"+datos[4]+"' and a.TALLA='"+datos[3]+"'";
        
        queryCount = "select count(*) "+
                "from CONTRATOS c, ITEMS i, ACCESORIOS a "+
                "where c.ID = i.CTO_ID and i.ARO_ID = a.id and (c.ESTADO='Activo' or c.ESTADO = 'Pendiente') and "+
                "a.TARO_ID='"+datos[0]+"' and a.FARO_ID='"+datos[1]+"' and a.CARO_ID='"+datos[2]+"' and a.MARO_ID='"+datos[4]+"' and a.TALLA='"+datos[3]+"' "+
                "order by c.FECHA_ENTREGA";
        
        Conexion con = new Conexion(dirIP);
        if(con.conectar() == 1){            
            try{
                java.sql.ResultSet res = con.consultar(queryCount);
                res.next();
                int count = Integer.parseInt(res.getString(1));
                Object[][] dat = new Object[count][3];
                
                int cont =0 ;
                res = con.consultar(query);
                while(res.next()){
                    dat[cont][0] = res.getString(1);
                    dat[cont][1] = res.getString(2);
                    dat[cont][2] = res.getString(3);
                    cont++;
                }
                modelo.setDataVector(dat, new String [] {
                    "Fecha Entrega", "Fecha devolución", "Ejemplar"
                });  
            }
            catch(Exception er){}
            con.desconectar();
        }
    }
}
