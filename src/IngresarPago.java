import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

public class IngresarPago extends javax.swing.JDialog {
    private javax.swing.JCheckBox c_TarjetaDebito;
    private javax.swing.JCheckBox c_TarjetaCredito;
    private javax.swing.JCheckBox c_cheque;
    private javax.swing.JCheckBox c_efectivo;
    private javax.swing.JCheckBox c_otro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_logo;
    private javax.swing.JTextField t_monto;    
    
    private String agrega;
    
    public IngresarPago(javax.swing.JFrame parent) {
        super(parent, true);
        
        agrega = "";
        
        initComponents();
        
        c_efectivo.setSelected(true);
        t_monto.setEditable(true);
        jButton1.setEnabled(true);
        t_monto.requestFocus();
        
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        // Center in the parent
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
        
        setVisible(true);
    }
    
    public IngresarPago(javax.swing.JDialog parent) {
        super(parent, true);
        
        agrega = "";
        
        initComponents();
        
        c_efectivo.setSelected(true);
        t_monto.setEditable(true);
        jButton1.setEnabled(true);
        
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
        
        setVisible(true);
    }
    
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        c_efectivo = new javax.swing.JCheckBox();
        c_cheque = new javax.swing.JCheckBox();
        c_TarjetaCredito = new javax.swing.JCheckBox();
        c_TarjetaDebito = new javax.swing.JCheckBox();
        c_otro = new javax.swing.JCheckBox();
        
        t_monto = new javax.swing.JTextField();
        t_monto.setEditable(false);
        t_monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {                
                if(evt.getKeyCode()==10){
                    if(!t_monto.getText().isEmpty()){
                        aceptar(null);
                    }
                    else{
                        cancelar(null);
                    }
                }                
            }
        });
        
        jLabel1 = new javax.swing.JLabel();
        l_logo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("D Etiqueta - Registrar Pago");
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
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

        c_TarjetaCredito.setFont(new java.awt.Font("Arial", 0, 14));
        c_TarjetaCredito.setText("Tarjeta de Cr\u00e9dito");
        c_TarjetaCredito.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        c_TarjetaCredito.setMargin(new java.awt.Insets(0, 0, 0, 0));
        c_TarjetaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarCheck(evt);
            }
        });

        c_TarjetaDebito.setFont(new java.awt.Font("Arial", 0, 14));
        c_TarjetaDebito.setText("Tarjeta de D\u00e9bito");
        c_TarjetaDebito.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        c_TarjetaDebito.setMargin(new java.awt.Insets(0, 0, 0, 0));
        c_TarjetaDebito.addActionListener(new java.awt.event.ActionListener() {
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
        jLabel1.setText("Monto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(c_otro)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_TarjetaCredito)
                            .addComponent(c_efectivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_TarjetaDebito)
                            .addComponent(c_cheque))
                        .addContainerGap(19, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(t_monto, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_efectivo)
                    .addComponent(c_cheque))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_TarjetaCredito)
                    .addComponent(c_TarjetaDebito))
                .addGap(19, 19, 19)
                .addComponent(c_otro)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(t_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        l_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Pago.gif")));

        jButton1.setMnemonic('A');
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar(evt);
            }
        });
        jButton1.setEnabled(false);

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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton1)
                        .addGap(58, 58, 58)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(l_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
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
        //
        if(t_monto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese Monto a Pagar", "Advertencia", JOptionPane.OK_OPTION);
        }
        else{
            try{
                Float cant = Float.parseFloat(t_monto.getText());
                if(cant<0){
                    cant = Float.parseFloat("aa");
                }
                agrega = "";
                if(c_efectivo.isSelected()){
                    agrega = "Efectivo";
                }
                if(c_cheque.isSelected()){
                    agrega = "Cheque";
                }
                if(c_TarjetaCredito.isSelected()){
                    agrega = "Tarj. Créd.";
                }
                if(c_TarjetaDebito.isSelected()){
                    agrega = "Tarj. Déb.";
                }
                if(c_otro.isSelected()){
                    agrega = "Otro";
                }
                
                agrega = agrega + "-" + t_monto.getText();
                
                setVisible(false);
                dispose();
            }
            catch(java.lang.NumberFormatException er){
                JOptionPane.showMessageDialog(null, "Monto a Pagar Incorrecto", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
    } 
    
    public String getAgrega(){
        return agrega;
    }
    
    public void seleccionarCheck(java.awt.event.ActionEvent evt){
        if(c_efectivo.isSelected() && evt.getSource().equals(c_efectivo)){
            c_cheque.setSelected(false);
            c_TarjetaCredito.setSelected(false);
            c_TarjetaDebito.setSelected(false);
            c_otro.setSelected(false);
        }

        if(c_cheque.isSelected() && evt.getSource().equals(c_cheque)){
            c_efectivo.setSelected(false);
            c_TarjetaCredito.setSelected(false);
            c_TarjetaDebito.setSelected(false);
            c_otro.setSelected(false);
        }
        
        if(c_TarjetaCredito.isSelected() && evt.getSource().equals(c_TarjetaCredito)){
            c_cheque.setSelected(false);
            c_efectivo.setSelected(false);
            c_TarjetaDebito.setSelected(false);
            c_otro.setSelected(false);
        }
        
        if(c_TarjetaDebito.isSelected() && evt.getSource().equals(c_TarjetaDebito)){
            c_cheque.setSelected(false);
            c_TarjetaCredito.setSelected(false);
            c_efectivo.setSelected(false);
            c_otro.setSelected(false);
        }
        
        if(c_otro.isSelected() && evt.getSource().equals(c_otro)){
            c_cheque.setSelected(false);
            c_TarjetaCredito.setSelected(false);
            c_TarjetaDebito.setSelected(false);
            c_efectivo.setSelected(false);
        }
        
        if(c_efectivo.isSelected() || c_cheque.isSelected() || c_TarjetaCredito.isSelected() || c_TarjetaDebito.isSelected() || c_otro.isSelected()){
            jButton1.setEnabled(true);
            t_monto.setEditable(true);
            t_monto.requestFocus();
        }
        else{
            jButton1.setEnabled(false);
            t_monto.setEditable(false);
        }
    }
}
