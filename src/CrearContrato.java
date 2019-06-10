import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CrearContrato extends javax.swing.JFrame {    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel l_logo;
    private javax.swing.JPanel p_cliente;
    private javax.swing.JPanel p_observaciones;
    private javax.swing.JPanel p_pagos;
    private javax.swing.JPanel p_pedido;
    private javax.swing.JTextField t_FechaDevolucion;
    private javax.swing.JTextField t_FechaEntrega;
    private javax.swing.JTextField t_cedula;
    private javax.swing.JTextField t_correo;
    private javax.swing.JTextField t_direccion;
    private javax.swing.JTextField t_nombre;
    private javax.swing.JTextField t_rif;
    private javax.swing.JTextField t_tlf1;
    private javax.swing.JTextField t_tlf2;
    private javax.swing.JTextField t_total;
    private javax.swing.JTextField t_totalPagado;
    private javax.swing.JTextField t_totalRestante;
    private DefaultTableModel_M modeloResultados = null;
    private DefaultTableModel_M modeloPagos = null;
    private DefaultTableModel_M modeloGarantias = null;
    
    private String dirIP;
    private String idSucursal;
       
    public CrearContrato(String ip, String suc) {
        dirIP = ip;
        idSucursal = suc;
        
        initComponents();
        init2();
        cargarVentana();
        
        this.setVisible(true);
    }
                            
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        p_observaciones = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        l_logo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        p_cliente = new javax.swing.JPanel();
        t_cedula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        t_nombre = new javax.swing.JTextField();
        t_direccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        t_correo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        t_rif = new javax.swing.JTextField();
        t_tlf1 = new javax.swing.JTextField();
        t_tlf2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        p_pedido = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        t_total = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        p_pagos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        t_totalPagado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        t_totalRestante = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        t_FechaEntrega = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        t_FechaDevolucion = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("D' Etiqueta - Crear Contrato");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        p_observaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout p_observacionesLayout = new javax.swing.GroupLayout(p_observaciones);
        p_observaciones.setLayout(p_observacionesLayout);
        p_observacionesLayout.setHorizontalGroup(
            p_observacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_observacionesLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        p_observacionesLayout.setVerticalGroup(
            p_observacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_observacionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        l_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Contrato.gif")));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel5.setText("Contrato N\u00ba:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel10.setText("Fecha Emisi\u00f3n:");

        p_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jButton1.setMnemonic('B');
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(t_cedula.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese un número de Cédula", "Advertencia", JOptionPane.OK_OPTION);
                }
                else{
                    limpiarCamposCliente();
                    buscar(evt, t_cedula.getText());
                }
            }
        });

        jButton2.setMnemonic('E');
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(t_cedula.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese un número de Cédula", "Advertencia", JOptionPane.OK_OPTION);
                }
                else{
                    limpiarCamposCliente();
                    AgregarCliente2 obj = new AgregarCliente2(dirIP, t_cedula.getText(), t_cedula);
                }
            }
        });

        jButton3.setMnemonic('N');
        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCamposCliente();
                AgregarCliente2 obj = new AgregarCliente2(dirIP, true, t_cedula);
            }
        });
        
        //Boton '+' Accesorios
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
                    Date d1;     //d1>d2 -> 1
                    Date d2;     //d1<d2 -> -1
                    if(t_FechaEntrega.getText().isEmpty() && t_FechaDevolucion.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Seleccione fecha de entrega y devolución", "Advertencia", JOptionPane.OK_OPTION);
                    }
                    else{
                        d1 = df.parse(t_FechaEntrega.getText());
                        d2 = df.parse(t_FechaDevolucion.getText());
                        if(d1.compareTo(d2) > 0){
                            JOptionPane.showMessageDialog(null,"La fecha de entrega debe ser menor a la fecha de devolución", "Advertencia", JOptionPane.OK_OPTION);
                        }
                        else{
                            ingresarAccesorio(evt);
                        }                        
                    }                    
                }
                catch (Exception e) {
                    
                }
            }
        });
        
        //Boton '-' Accesorios
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAccesorio(evt);
            }
        });
        
        //Boton '+' Pagos
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarPago(evt);
            }
        });
        
        //Boton '-' Pagos
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPago(evt);
            }
        });
        
        //Boton '+' Garantias
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarGarantia(evt);
            }
        });
        
        //Boton '-' Garantias
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarGarantia(evt);
            }
        });
        
        //Boton '+' Fecha Entrega
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarFecha(evt, t_FechaEntrega);
            }
        });
        
        //Boton '+' Fecha Devolucion
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarFecha(evt, t_FechaDevolucion);
            }
        });

        t_nombre.setEditable(false);

        t_direccion.setEditable(false);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Direcci\u00f3n:");

        jLabel3.setText("Tel\u00e9fono 1:");

        jLabel6.setText("Correo:");

        t_correo.setEditable(false);

        jLabel7.setText("RIF:");

        t_rif.setEditable(false);

        t_tlf1.setEditable(false);

        t_tlf2.setEditable(false);

        jLabel8.setText("Tel\u00e9fono 2:");

        jLabel9.setText("C\u00e9dula:");

        javax.swing.GroupLayout p_clienteLayout = new javax.swing.GroupLayout(p_cliente);
        p_cliente.setLayout(p_clienteLayout);
        p_clienteLayout.setHorizontalGroup(
            p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(p_clienteLayout.createSequentialGroup()
                        .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_clienteLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel9)))
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30))
                    .addGroup(p_clienteLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_direccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                    .addGroup(p_clienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                    .addComponent(t_nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                    .addGroup(p_clienteLayout.createSequentialGroup()
                        .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_tlf1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(t_correo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_clienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(14, 14, 14))
                            .addGroup(p_clienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_tlf2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(t_rif, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))
                .addContainerGap())
        );
        p_clienteLayout.setVerticalGroup(
            p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_clienteLayout.createSequentialGroup()
                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(t_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(3, 3, 3)
                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(t_tlf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_tlf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(t_rif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(t_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))))
        );

        p_pedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Pedido"));
        p_pedido.setAutoscrolls(true);
        jButton4.setText("+");

        t_total.setEditable(false);

        jLabel4.setText("Total a Pagar");

        modeloResultados = new DefaultTableModel_M( new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Precio"
        });
        jTable1.setModel(modeloResultados);
        jTable1.getTableHeader().setReorderingAllowed(false); 
        
        //jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jButton7.setText("-");

        javax.swing.GroupLayout p_pedidoLayout = new javax.swing.GroupLayout(p_pedido);
        p_pedido.setLayout(p_pedidoLayout);
        p_pedidoLayout.setHorizontalGroup(
            p_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_pedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addGroup(p_pedidoLayout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(t_total, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        p_pedidoLayout.setVerticalGroup(
            p_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_pedidoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(t_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton5.setMnemonic('P');
        jButton5.setText("Procesar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesar(evt);
            }
        });

        jButton6.setMnemonic('C');
        jButton6.setText("Cancelar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Garant\u00edas"));
        /*jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo", "Descripción"
            }
        ));*/
        modeloGarantias = new DefaultTableModel_M( new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo", "Descripción"
        });
        jTable3.setModel(modeloGarantias);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable3);

        jButton10.setText("+");

        jButton11.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p_pagos.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagos"));
        modeloPagos = new DefaultTableModel_M( new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo Pago", "Monto"
        });
        jTable2.setModel(modeloPagos);
        jTable2.getTableHeader().setReorderingAllowed(false);
        /*jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo Pago", "Monto"
            }
        ));
        jTable2.setEnabled(false);*/
        jScrollPane3.setViewportView(jTable2);

        jButton8.setText("+");

        jButton9.setText("-");

        jLabel11.setText("Total:");

        t_totalPagado.setEditable(false);

        jLabel12.setText("Resta:");

        t_totalRestante.setEditable(false);

        javax.swing.GroupLayout p_pagosLayout = new javax.swing.GroupLayout(p_pagos);
        p_pagos.setLayout(p_pagosLayout);
        p_pagosLayout.setHorizontalGroup(
            p_pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_pagosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_pagosLayout.createSequentialGroup()
                        .addGroup(p_pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_totalRestante, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(t_totalPagado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        p_pagosLayout.setVerticalGroup(
            p_pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_pagosLayout.createSequentialGroup()
                .addGroup(p_pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_pagosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton9))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(t_totalPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_pagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(t_totalRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Entrega"));
        jLabel13.setText("Fecha de Entrega:");

        jLabel14.setText("Fecha de Devoluci\u00f3n:");

        jButton12.setText("+");

        jButton13.setText("+");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(t_FechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_FechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(130, 130, 130))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(t_FechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_FechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2697, 2697, 2697))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jButton5)
                .addGap(41, 41, 41)
                .addComponent(jButton6)
                .addContainerGap(2920, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(l_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addGap(2692, 2692, 2692))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(p_observaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(p_pagos, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(p_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2697, 2697, 2697))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(p_pagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(162, 162, 162))
        );
        jScrollPane4.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
        java.awt.Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(d.getWidth()/2-this.getWidth()/2), (int)(d.getHeight()/2-this.getHeight()/2));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
    }
    
    public void init2(){
        int anchoColumna = 0;
        int ancho = jTable1.getWidth();
        javax.swing.table.TableColumnModel model = jTable1.getColumnModel();
        javax.swing.table.TableColumn t;        
        t = model.getColumn(0);
        anchoColumna=(20*ancho)/100;
        t.setPreferredWidth(anchoColumna);
        t = model.getColumn(1);
        anchoColumna=(70*ancho)/100;
        t.setPreferredWidth(anchoColumna);
        t = model.getColumn(2);
        anchoColumna=(10*ancho)/100;
        t.setPreferredWidth(anchoColumna);
        
        anchoColumna = 0;
        ancho = jTable3.getWidth();
        model = jTable3.getColumnModel();
        t = model.getColumn(0);
        anchoColumna=(20*ancho)/100;
        t.setPreferredWidth(anchoColumna);
        t = model.getColumn(1);
        anchoColumna=(80*ancho)/100;
        t.setPreferredWidth(anchoColumna);
        
        t_FechaEntrega.setEditable(false);
        t_FechaDevolucion.setEditable(false);
        //jTable3.setEnabled(false);
    }
    
    public void buscar(java.awt.event.ActionEvent evt, String cedula) { 
        Conexion con = new Conexion(dirIP);
        if(con.conectar() == 1){
            try{
                java.sql.ResultSet res = con.consultar("select * from CLIENTES where cedula='"+cedula+"'");
                if(res.next()){
                    limpiarCamposCliente();
                    t_cedula.setText(res.getString(1));
                    t_nombre.setText(res.getString(2));
                    t_direccion.setText(res.getString(3));
                    t_tlf1.setText(res.getString(4));
                    t_tlf2.setText(res.getString(5));
                    t_correo.setText(res.getString(6));
                    t_rif.setText(res.getString(7));
                }
                else{
                    JOptionPane.showMessageDialog(this,"No se encontro el Cliente", "Advertencia", JOptionPane.OK_OPTION);
                }
                con.desconectar();
            }
            catch(Exception er){ /*er.printStackTrace();*/ }
        }
        else{
            JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
    }                      

    private void cancelar(java.awt.event.ActionEvent evt) {                          
        this.setVisible(false);
        this.dispose();        
    }                         

    private void procesar(java.awt.event.ActionEvent evt) {
        int error = 0;
        
        if(t_nombre.getText().isEmpty()){
            error = 1;
            JOptionPane.showMessageDialog(this,"Falta los datos del Cliente", "Advertencia", JOptionPane.OK_OPTION);
        }
        if(error == 0 && t_FechaEntrega.getText().isEmpty()){
            error = 1;
            JOptionPane.showMessageDialog(this,"Falta la fecha de entrega", "Advertencia", JOptionPane.OK_OPTION);
        }
        if(error == 0 && t_FechaDevolucion.getText().isEmpty()){
            error = 1;
            JOptionPane.showMessageDialog(this,"Falta la fecha de devolución", "Advertencia", JOptionPane.OK_OPTION);
        }
        if(error == 0 && jTable1.getValueAt(0,0) == null){
            error = 1;
            JOptionPane.showMessageDialog(this,"No hay Accesorios Registrados", "Advertencia", JOptionPane.OK_OPTION);
        }
        if(error == 0 && jTextArea1.getText().length()>100){
            error = 1;
            JOptionPane.showMessageDialog(this,"Máx 100 caracteres en Observaciones", "Advertencia", JOptionPane.OK_OPTION);
        }
        /*if(error == 0 && jTable3.getValueAt(0,0) == null){
            error = 1;
            JOptionPane.showMessageDialog(this,"No hay Garantias Registradas", "Advertencia", JOptionPane.OK_OPTION);
        }  */      
        
        if(error == 0){
            String fecEmision = jLabel10.getText().substring(15,jLabel10.getText().length());
            String fecEntrega = t_FechaEntrega.getText();
            String fecDevolucion = t_FechaDevolucion.getText();
            String ced = t_cedula.getText();
            String totPag = t_total.getText();
            String idCto = "";
            String edo = "";
            
            Conexion con = new Conexion(dirIP);
            try{
                if(con.conectar() == 1){
                    java.sql.ResultSet res = con.consultar("select nvl(max(ID)+1,1) from CONTRATOS");
                    res.next();
                    idCto = res.getString(1);
                    
                    /*if(fecEmision.compareTo(fecEntrega) == 0){
                        edo = "ACTIVO";
                    }
                    else{
                        edo = "PENDIENTE";
                    }
                    */
                    edo = "PENDIENTE";
                    //System.out.println("insert into CONTRATOS values('"+idCto+"','"+fecEmision+"','"+fecEntrega+"','"+fecDevolucion+"','"+totPag+"','"+edo+"','"+ced+"','"+idSucursal+"')");
                    if(con.actualizar("insert into CONTRATOS values('"+idCto+"','"+fecEmision+"','"+fecEntrega+"','"+fecDevolucion+"',"+totPag+",'"+edo+"','"+ced+"','"+idSucursal+"')") == 1){
                    //if(true){
                        jLabel5.setText("Contrato Nº: "+idCto);
                        //System.out.println("CTO insert into CONTRATOS values('"+idCto+"','"+fecEmision+"','"+fecEntrega+"','"+fecDevolucion+"',"+totPag+",'"+edo+"','"+ced+"','"+idSucursal+"')");
                        for(int ii=0;ii<jTable2.getRowCount();ii++){                            
                            if(jTable2.getValueAt(ii,0) != null){
                                String tipPgo = jTable2.getValueAt(ii,0).toString();
                                String montPgo = jTable2.getValueAt(ii,1).toString();
                                String idPgo = "";
                                String motiv = "01";
                                String idpago = "";
                                
                                if(tipPgo.compareTo("Efectivo") == 0){
                                    tipPgo = "01";
                                }
                                if(tipPgo.compareTo("Cheque") == 0){
                                    tipPgo = "02";
                                }
                                if(tipPgo.compareTo("Tarj. Créd.") == 0){
                                    tipPgo = "03";
                                }
                                if(tipPgo.compareTo("Tarj. Déb.") == 0){
                                    tipPgo = "04";
                                }
                                if(tipPgo.compareTo("Otro") == 0){
                                    tipPgo = "05";
                                }
                                
                                res = con.consultar("select nvl(max(ID)+1,1) from PAGOS");
                                res.next();
                                idpago = res.getString(1);
                                
                                con.actualizar("insert into PAGOS values('"+idpago+"','',"+montPgo+",'"+fecEmision+"','"+idCto+"','"+tipPgo+"','"+motiv+"')");
                                //System.out.println("PGO insert into PAGOS values('"+idpago+"','','"+montPgo+"','"+fecEmision+"','"+idCto+"','"+tipPgo+"','"+motiv+"')");
                            }
                            else{
                                break;
                            }                            
                        }
                        for(int ii=0;ii<jTable3.getRowCount();ii++){
                            if(jTable3.getValueAt(ii,0) != null){
                                String tipGta = jTable3.getValueAt(ii,0).toString();
                                String desc = jTable3.getValueAt(ii,1).toString();
                                String idGta = "";
                                String motiv = "02";
                                String idgarant = "";
                                
                                if(tipGta.compareTo("Efectivo") == 0){
                                    tipGta = "01";
                                }
                                if(tipGta.compareTo("Cheque") == 0){
                                    tipGta = "02";
                                }                                
                                if(tipGta.compareTo("Otro") == 0){
                                    tipGta = "05";
                                }
                                
                                res = con.consultar("select nvl(max(ID)+1,1) from PAGOS");
                                res.next();
                                idgarant = res.getString(1);
                                
                                con.actualizar("insert into PAGOS values('"+idgarant+"','"+desc+"','','"+fecEmision+"','"+idCto+"','"+tipGta+"','"+motiv+"')");
                                //System.out.println("GTA insert into PAGOS values('"+idgarant+"','"+desc+"','','"+fecEmision+"','"+idCto+"','"+tipGta+"','"+motiv+"')");
                            }
                            else{
                                break;
                            }
                        }
                        
                        //-----------------------------01010102-0101
                        
                        for(int ii=0;ii<jTable1.getRowCount();ii++){
                            if(jTable1.getValueAt(ii,0) != null){
                                String codigos[] = new String[6];
                                String codigo = jTable1.getValueAt(ii,0).toString();
                                codigos[0] = codigo.substring(0,2);
                                codigos[1] = codigo.substring(2,4);
                                codigos[2] = codigo.substring(4,6);
                                codigos[3] = codigo.substring(6,8);
                                boolean data = false;
                                if(codigos[3].compareTo("00")==0){codigos[3] =codigos[3] ;data=true;}
                                
                                if(codigos[3].charAt(0) == '0' && codigos[3].length()>1&&data!=true){
                                    codigos[3] = codigos[3].substring(1,codigos[3].length());
                                }
                                
                                codigos[4] = codigo.substring(9,11);
                                codigos[5] = codigo.substring(11,13);
                                
                                /*String desc = jTable1.getValueAt(ii,2).toString();
                                int iparent = -1;
                                int dparent = desc.length()-1;
                                for(int j=0;j<desc.length();j++){
                                    if(desc.charAt(j) == '('){
                                        iparent = j;
                                    }
                                }
                                String descMarca = desc.substring(iparent+1, dparent);
                                res = con.consultar("select DESCRIPCION from MARCA_ACCESORIOS where ID='"+descMarca+"'");
                                res.next();
                                codigos[4] = res.getString(1);*/
                                
                                
                                
                                
                                /*String query = "select ID from ACCESORIOS "+
                                        "where TALLA='"+codigos[3]+"' and TARO_ID='"+codigos[0]+"' and FARO_ID='"+codigos[1]+"' and CARO_ID='"+codigos[2]+"' and UBN_ID='01'";*/
                                String query = "select ID from ACCESORIOS where "
                                                +"TARO_ID='"+codigos[0]+"' and FARO_ID='"+codigos[1]+"' and CARO_ID='"+codigos[2]+"' and MARO_ID='"+codigos[4]+"' and NUM_EJEMPLAR='"+codigos[5]+"' and TALLA='"+codigos[3]+"'";
                               System.out.println(query);
                                res = con.consultar(query);                                
                                if(res.next()){
                                    String idAccesorio = res.getString(1);
                                    query = "select nvl(max(ID)+1,1) from ITEMS";/////Porblema solucionado
                                    res = con.consultar(query);
                                    res.next();
                                    String idItem = res.getString(1);
                                    query = "insert into ITEMS values('"+idItem+"', '1', "+jTable1.getValueAt(ii,2).toString()+", '"+idCto+"', '"+idAccesorio+"')";
                                    con.actualizar(query);
                                    //System.out.println("ITM "+query);
                                    /*if(edo.compareToIgnoreCase("ACTIVO") == 0){
                                        query = "update ACCESORIOS set UBN_ID = '04' where ID = '"+idAccesorio+"'";
                                        con.actualizar(query);
                                        //System.out.println(query);                                        
                                    }*/
                                }
                            }
                            else{
                                break;
                            }
                        }
                        
                        //-----------------------------
                        
                        if(jTextArea1.getText().length()>0){
                            String observac = jTextArea1.getText();
                            String idObs = "";

                            res = con.consultar("select nvl(max(ID)+1,1) from OBSERVACIONES");
                            res.next();
                            idObs = res.getString(1);

                            con.actualizar("insert into OBSERVACIONES values('"+idObs+"','"+observac+"','"+idCto+"')");
                            //System.out.println("OBN insert into OBSERVACIONES values('"+idObs+"','"+observac+"','"+idCto+"')");
                        }
                        con.desconectar();
                        JOptionPane.showMessageDialog(this,"Contrato Procesado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        EditarContrato ec = new EditarContrato(dirIP, Integer.parseInt(idCto));
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"No se pudo Procesar el Contrato", "Advertencia", JOptionPane.OK_OPTION);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
                }
            }
            catch(Exception er){ er.printStackTrace(); }            
        }
    }
    
    private void ingresarPago(java.awt.event.ActionEvent evt) {
        IngresarPago obj = new IngresarPago(this);
        String agrega = obj.getAgrega();
        obj.dispose();  
        if(!agrega.isEmpty()){
            for(int i=0;i<jTable2.getRowCount();i++){
                if(jTable2.getValueAt(i,0) == null){
                    String palab[];
                    palab = agrega.split("-");
                    jTable2.setValueAt(palab[0],i,0);
                    jTable2.setValueAt(palab[1],i,1);
                    break;
                }
            }            
            calcularTotales();
        }
    }
    
    public void eliminarPago(java.awt.event.ActionEvent evt){
        int index = jTable2.getSelectedRow();
        if(index != -1 && jTable2.getValueAt(index,0)!=null){
            for(int i=index;i<jTable2.getRowCount()-1;i++){
                jTable2.setValueAt(jTable2.getValueAt(i+1, 0),i,0);
                jTable2.setValueAt(jTable2.getValueAt(i+1, 1),i,1);
            }
            jTable2.setValueAt(null,jTable2.getRowCount()-1,0);
            jTable2.setValueAt(null,jTable2.getRowCount()-1,1);
            calcularTotales();
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione el pago a eliminar", "Advertencia", JOptionPane.OK_OPTION);
        }
        
        
        /*for(int i=jTable2.getRowCount()-1; i>=0; i--){
            if(jTable2.getValueAt(i,0) != null){
                jTable2.setValueAt(null,i,0);
                jTable2.setValueAt(null,i,1);
                break;
            }
        }
        calcularTotales();*/
    }
    
    public void calcularTotales(){
        float totalPag=0;
        for(int i=0;i<jTable1.getRowCount();i++){
            if(jTable1.getValueAt(i,2) != null){
                totalPag = totalPag + Float.parseFloat(jTable1.getValueAt(i,2).toString());                    
            }
        }
        t_total.setText(String.valueOf(totalPag));
        
        float total = 0;
        for(int i=0;i<jTable2.getRowCount();i++){
            if(jTable2.getValueAt(i,0) != null){
                total = total + Float.parseFloat(jTable2.getValueAt(i,1).toString());                    
            }
        }
        t_totalPagado.setText(String.valueOf(total));
        if(!t_total.getText().isEmpty()){
            t_totalRestante.setText(t_total.getText());
        }
        if(!t_total.getText().isEmpty()){
            t_totalRestante.setText(String.valueOf( Float.parseFloat(t_total.getText()) - Float.parseFloat(t_totalPagado.getText()) ));
        }
        else{
            t_totalRestante.setText(String.valueOf( 0 - Float.parseFloat(t_totalPagado.getText()) ));
        }
    }
    
    public void limpiarCamposCliente(){
        t_nombre.setText("");
        t_direccion.setText("");
        t_tlf1.setText("");;
        t_tlf2.setText("");
        t_correo.setText("");
        t_rif.setText("");
    }
    
    public void cargarVentana(){        
        String dia = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
        if(Integer.parseInt(mes)<10){
            mes = "0"+mes;
        }
        String anho = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        jLabel10.setText("Fecha Emisión: "+dia+"/"+mes+"/"+anho);
        
        t_total.setText("0.0");
        t_totalPagado.setText("0.0");
        t_totalRestante.setText("0.0");
    }
    
    private void ingresarGarantia(java.awt.event.ActionEvent evt) {
        IngresarGarantia obj = new IngresarGarantia(this);
        String agrega = obj.getAgrega();
        obj.dispose();  
        if(!agrega.isEmpty()){
            for(int i=0;i<jTable3.getRowCount();i++){
                if(jTable3.getValueAt(i,0) == null){
                    String palab[];
                    palab = agrega.split("@");
                    jTable3.setValueAt(palab[0],i,0);
                    jTable3.setValueAt(palab[1],i,1);
                    break;
                }
            }
        }
    }
    
    public void eliminarGarantia(java.awt.event.ActionEvent evt){
        int index = jTable3.getSelectedRow();
        if(index != -1 && jTable3.getValueAt(index,0)!=null){
            for(int i=index;i<jTable3.getRowCount()-1;i++){
                jTable3.setValueAt(jTable3.getValueAt(i+1, 0),i,0);
                jTable3.setValueAt(jTable3.getValueAt(i+1, 1),i,1);
            }
            jTable3.setValueAt(null,jTable3.getRowCount()-1,0);
            jTable3.setValueAt(null,jTable3.getRowCount()-1,1);
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione la garantía a eliminar", "Advertencia", JOptionPane.OK_OPTION);
        }
        
        /*for(int i=jTable3.getRowCount()-1; i>=0; i--){
            if(jTable3.getValueAt(i,0) != null){
                jTable3.setValueAt(null,i,0);
                jTable3.setValueAt(null,i,1);
                break;
            }
        }*/
    }
    
    public void ingresarFecha(java.awt.event.ActionEvent evt, JTextField txt){
        Calendario obj = new Calendario(this);
        String agrega = obj.getAgrega();
        GregorianCalendar selec = obj.getFechaAgrega();
        obj.dispose();
        if(!agrega.isEmpty()){
            GregorianCalendar actual = (GregorianCalendar) GregorianCalendar.getInstance();
            //actual.set(actual.MONTH, actual.get(actual.MONTH)+1);            
            if(actual.compareTo(selec)<=0 || (actual.get(actual.DAY_OF_MONTH)==selec.get(selec.DAY_OF_MONTH)
                        && actual.get(actual.MONTH)==selec.get(selec.MONTH) && actual.get(actual.YEAR)==selec.get(selec.YEAR))){
                txt.setText(agrega);
            }
            else{
                JOptionPane.showMessageDialog(this,"La fecha ya paso, seleccione otra", "Advertencia", JOptionPane.OK_OPTION);
            }            
        }
    }
    
    private void ingresarAccesorio(java.awt.event.ActionEvent evt) {
        if(t_FechaEntrega.getText().isEmpty() && t_FechaDevolucion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Seleccione fecha de entrega y devolución", "Advertencia", JOptionPane.OK_OPTION);
        }
        else{
             String f1[], f2[], d1, d2;
             f1 = t_FechaEntrega.getText().split("/");
             if(f1[2].length() == 4){
                 f1[2] = f1[2].substring(2,4);
             }             
             f2 = t_FechaDevolucion.getText().split("/");
             if(f2[2].length() == 4){
                 f2[2] = f2[2].substring(2,4);
             } 
             d1 = f1[0] + "/" +f1[1] + "/" + f1[2];
             d2 = f2[0] + "/" +f2[1] + "/" + f2[2];
             
             Pre_Cant obj = null;// = new Pre_Cant(this,dirIP,d1, d2);
             String datos[] = obj.Retorna_Cad();
             
             //                 fa   ta   ca  tal  ma  ejm  precio         
             //String datos[] = {"01","01","01","M","01","1","100"};
             java.sql.ResultSet res;
             /*String disp[] = new String[5];
             String ejempl = "0";
             if(datos!=null){
                 disp[0] = datos[0];
                 disp[1] = datos[1];
                 disp[2] = datos[2];
                 disp[3] = datos[3];
                 disp[4] = datos[4];
                 MostrarDisponibilidad obj = new MostrarDisponibilidad(this,dirIP,disp);
                 String agrega = obj.getAgrega();
                 if(agrega!=""){
                     ejempl = agrega;
                 }
             }
             if(ejempl.compareTo("0") != 0){*/
             if(datos!=null){
                 for(int i=0;i<jTable1.getRowCount();i++){
                     if(jTable1.getValueAt(i,0) == null){
                         String cod = "";
                         String desc = "";
                         if(datos[3].length()==1){
                             datos[3] = "0"+datos[3];
                         }
                         if(datos[4].length()==1){
                             datos[4] = "0"+datos[4];
                         }
                         if(datos[5].length()==1){
                             datos[5] = "0"+datos[5];
                         }
                         cod = datos[0] + datos[1] + datos[2] + datos[3] + "-" + datos[4] + datos[5];

                         Conexion con = new Conexion(dirIP);                     
                         if(con.conectar() == 1){ 
                             res = con.consultar("select ta.DESCRIPCION, fa.DESCRIPCION, ca.COLOR1, ca.COLOR2, ca.COLOR3, ma.DESCRIPCION "
                                                +"from TIPO_ACCESORIOS ta, FORMA_ACCESORIOS fa, COLOR_ACCESORIOS ca, MARCA_ACCESORIOS ma "
                                                +"where ta.ID='"+datos[0]+"' and fa.ID='"+datos[1]+"' and ca.ID='"+datos[2]+"' and ma.ID='"+datos[4]+"'");
                             try{
                                 res.next();
                                 String descTip = res.getString(1);
                                 String descFor = res.getString(2);
                                 String descCol1 = res.getString(3);
                                 String descCol2 = res.getString(4);
                                 String descCol3 = res.getString(5);
                                 String descMarc = res.getString(6);

                                 String descCol = "";
                                 if(descCol1 != null){
                                    descCol = descCol + descCol1;
                                 }
                                 if(descCol2 != null){
                                    descCol = descCol + " - " +descCol2;
                                 }
                                 if(descCol3 != null){
                                    descCol = descCol + " - " +descCol3;
                                 }
                                 desc = descTip + " " + descFor + " " + descCol + " Talla " + datos[3] + " (" + descMarc + ")";                             
                             }
                             catch(Exception er){}
                             con.desconectar();
                         }
                         else{
                             JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
                         }                  

                         jTable1.setValueAt(cod, i, 0);
                         jTable1.setValueAt(desc,i,1);
                         jTable1.setValueAt(datos[6],i,2);
                         /*jTable1.setValueAt(datos[5],i,1);
                         jTable1.setValueAt(desc,i,2);
                         jTable1.setValueAt(datos[6],i,3);
                         jTable1.setValueAt(datos[7],i,4);*/

                         float tot = Float.parseFloat(t_total.getText())+Float.parseFloat(datos[6]);
                         t_total.setText(String.valueOf(tot));
                         t_totalRestante.setText(String.valueOf(Float.parseFloat(t_total.getText()) - Float.parseFloat(t_totalPagado.getText())));

                         break;
                     }
                 }
             }
        }
     }
     
     private void eliminarAccesorio(java.awt.event.ActionEvent evt) {
        /*for(int i=jTable1.getRowCount()-1; i>=0; i--){
            if(jTable1.getValueAt(i,0) != null){
                jTable1.setValueAt(null,i,0);
                jTable1.setValueAt(null,i,1);
                jTable1.setValueAt(null,i,2);                
                break;
            }
        }*/
        int index = jTable1.getSelectedRow();
        if(index != -1 && jTable1.getValueAt(index,0)!=null){
            for(int i=index;i<jTable1.getRowCount()-1;i++){
                jTable1.setValueAt(jTable1.getValueAt(i+1, 0),i,0);
                jTable1.setValueAt(jTable1.getValueAt(i+1, 1),i,1);
                jTable1.setValueAt(jTable1.getValueAt(i+1, 2),i,2);
            }
            jTable1.setValueAt(null,jTable1.getRowCount()-1,0);
            jTable1.setValueAt(null,jTable1.getRowCount()-1,1);
            jTable1.setValueAt(null,jTable1.getRowCount()-1,2);
            calcularTotales();
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione un accesorio para eliminar", "Advertencia", JOptionPane.OK_OPTION);
        }
     }

}
