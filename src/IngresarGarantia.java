import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class IngresarGarantia extends javax.swing.JDialog {
    private javax.swing.JCheckBox c_cheque;
    private javax.swing.JCheckBox c_efectivo;
    private javax.swing.JCheckBox c_otro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_logo;
    private javax.swing.JTextField t_observacion;    
    
    private String agrega;
    
    public IngresarGarantia(javax.swing.JFrame parent) {
        super(parent, true);
        
        agrega = "";
        
        initComponents();
        c_efectivo.setSelected(true);
        t_observacion.setEditable(true);
        jButton1.setEnabled(true);
        t_observacion.requestFocus();
        
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
        
        setVisible(true);
    }
    
    public IngresarGarantia(javax.swing.JDialog parent) {
        super(parent, true);
        
        agrega = "";
        
        initComponents();
        
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        // Center in the parent
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
        
        setVisible(true);
    }
    
                         
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        c_efectivo = new javax.swing.JCheckBox();
        c_cheque = new javax.swing.JCheckBox();
        c_otro = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        t_observacion = new javax.swing.JTextField();
        t_observacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode()==10){
                    if(!t_observacion.getText().isEmpty()){
                        aceptar(null);
                    }
                    else{
                        cancelar(null);
                    }
                }                
            }
        });
        t_observacion.setEditable(false);
        l_logo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton1.setEnabled(false);        
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("D Etiqueta - Registrar Garantía");
        
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Garant\u00eda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        c_efectivo.setFont(new java.awt.Font("Arial", 0, 14));
        c_efectivo.setText("Efectivo");
        c_efectivo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        c_efectivo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        c_efectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarCheck(evt);
            }
        });
        
        c_cheque.setFont(new java.awt.Font("Arial", 0, 14));
        c_cheque.setText("Cheque");
        c_cheque.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        c_cheque.setMargin(new java.awt.Insets(0, 0, 0, 0));
        c_cheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarCheck(evt);
            }
        });
        
        c_otro.setFont(new java.awt.Font("Arial", 0, 14));
        c_otro.setText("Otro");
        c_otro.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        c_otro.setMargin(new java.awt.Insets(0, 0, 0, 0));
        c_otro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarCheck(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setText("Observacion:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(c_efectivo)
                        .addGap(27, 27, 27)
                        .addComponent(c_cheque)
                        .addGap(54, 54, 54)
                        .addComponent(c_otro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(t_observacion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_otro)
                    .addComponent(c_cheque)
                    .addComponent(c_efectivo))
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_observacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        l_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Pago.gif")));

        jButton1.setMnemonic('A');
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(t_observacion.getText().length()>50){
                    JOptionPane.showMessageDialog(null, "Máximo 50 Caracteres", "Advertencia", JOptionPane.OK_OPTION);
                }
                else{
                    aceptar(evt);
                }
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jButton1)
                .addGap(55, 55, 55)
                .addComponent(jButton2)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(l_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }

    private void cancelar(java.awt.event.ActionEvent evt) {                          
        //
        agrega = "";
        setVisible(false);
        dispose();
    }                         

    private void aceptar(java.awt.event.ActionEvent evt) {                         
        if(t_observacion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese Observación", "Advertencia", JOptionPane.OK_OPTION);
        }
        else{
            agrega = "";
            if(c_efectivo.isSelected()){
                agrega = "Efectivo";
            }
            if(c_cheque.isSelected()){
                agrega = "Cheque";
            }
            if(c_otro.isSelected()){
                agrega = "Otro";
            }
                
            agrega = agrega + "@" + t_observacion.getText();
                
            setVisible(false);
            dispose();
        }
    }
    
    public String getAgrega(){
        return agrega;
    }
    
    public void seleccionarCheck(java.awt.event.ActionEvent evt){
        if(c_efectivo.isSelected() && evt.getSource().equals(c_efectivo)){
            c_cheque.setSelected(false);
            c_otro.setSelected(false);
        }

        if(c_cheque.isSelected() && evt.getSource().equals(c_cheque)){
            c_efectivo.setSelected(false);
            c_otro.setSelected(false);
        }
        
        if(c_otro.isSelected() && evt.getSource().equals(c_otro)){
            c_cheque.setSelected(false);
            c_efectivo.setSelected(false);
        }
        
        if(c_efectivo.isSelected() || c_cheque.isSelected() || c_otro.isSelected()){
            jButton1.setEnabled(true);
            t_observacion.setEditable(true);
            t_observacion.requestFocus();
        }
        else{
            jButton1.setEnabled(false);
            t_observacion.setEditable(false);
        }
    }
}
