import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oracle.sql.JAVA_STRUCT;
public class EditarContrato extends javax.swing.JFrame {
    private javax.swing.JComboBox c_estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JPanel jPanel4;
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
   
    private int c1, c2;
    private boolean modifica;
    
    private String estadoContrato;    
    private String dirIP;
    private int idContrato;
    
    public EditarContrato(String ip, int contrato) {
        dirIP = ip;
        idContrato = contrato;
        
        initComponents();
        init2();
        cargarVentana();
        
        this.setVisible(true);
    }
    
    private void initComponents() {
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        l_logo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        p_cliente = new javax.swing.JPanel();
        t_cedula = new javax.swing.JTextField();
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
        t_total = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        p_pagos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        t_totalPagado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        t_totalRestante = new javax.swing.JTextField();
        p_observaciones = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        c_estado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        t_FechaEntrega = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        t_FechaDevolucion = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("D' Etiqueta - Editar Contrato");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        l_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Contrato.gif")));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel5.setText("Contrato N\u00ba:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel10.setText("Fecha Emisi\u00f3n:");

        p_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));
        t_cedula.setEditable(false);

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
                    .addComponent(t_direccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addGroup(p_clienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(t_nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addGroup(p_clienteLayout.createSequentialGroup()
                        .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_tlf1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(t_correo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(14, 14, 14)
                        .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_tlf2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(t_rif, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))))
                .addContainerGap())
        );
        p_clienteLayout.setVerticalGroup(
            p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_clienteLayout.createSequentialGroup()
                .addGroup(p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
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
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p_pedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Pedido"));
        p_pedido.setAutoscrolls(true);
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
        jScrollPane1.setViewportView(jTable1);

        jButton14.setText("+");

        jButton15.setText("-");

        javax.swing.GroupLayout p_pedidoLayout = new javax.swing.GroupLayout(p_pedido);
        p_pedido.setLayout(p_pedidoLayout);
        p_pedidoLayout.setHorizontalGroup(
            p_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_pedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_pedidoLayout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(32, 32, 32)
                        .addComponent(t_total, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        p_pedidoLayout.setVerticalGroup(
            p_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_pedidoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton5.setMnemonic('G');
        jButton5.setText("Guardar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesar(evt);
            }
        });

        jButton6.setMnemonic('I');
        jButton6.setText("Imprimir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimir(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Garant\u00edas"));
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

        jButton12.setText("+");

        jButton13.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        p_pagos.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagos"));
        modeloPagos = new DefaultTableModel_M( new Object [][] {
                {null, null, null},
                {null, null, null},
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
                "Tipo", "Monto", "Fecha"
        });
        jTable2.setModel(modeloPagos);
        jTable2.getTableHeader().setReorderingAllowed(false);
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

        p_observaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout p_observacionesLayout = new javax.swing.GroupLayout(p_observaciones);
        p_observaciones.setLayout(p_observacionesLayout);
        p_observacionesLayout.setHorizontalGroup(
            p_observacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_observacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_observacionesLayout.setVerticalGroup(
            p_observacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_observacionesLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));
        c_estado.setFont(new java.awt.Font("Arial", 0, 14));
        c_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "CANCELADO", "PENDIENTE", "FINALIZADO" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(c_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(c_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jButton1.setMnemonic('C');
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Entrega"));
        jLabel13.setText("Fecha de Entrega:");

        t_FechaEntrega.setEditable(false);

        jLabel14.setText("Fecha de Devoluci\u00f3n:");

        t_FechaDevolucion.setEditable(false);

        jButton10.setText("+");

        jButton11.setText("+");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(t_FechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
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
                    .addComponent(t_FechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_FechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(l_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addGap(2758, 2758, 2758))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jButton5)
                .addGap(46, 46, 46)
                .addComponent(jButton6)
                .addGap(54, 54, 54)
                .addComponent(jButton1)
                .addContainerGap(2902, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p_pagos, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(2773, 2773, 2773))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(p_pagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_observaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jScrollPane4.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }

    public void init2(){     
        //Boton '+' Accesorios
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println("+ Accesorios");
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
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println("- Accesorios");
                eliminarAccesorio(evt);
            }
        });
        
        //Boton '+' Pagos
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println("+ Pagos");
                ingresarPago(evt);
            }
        });
        
        //Boton '-' Pagos
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println("- Pagos");
                eliminarPago(evt);
            }
        });
        
        //Boton '+' Fecha Entrega
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println("+ Fecha entrega");
                ingresarFecha(evt, t_FechaEntrega);               
            }
        });
        
        //fecha devolucion
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println("+ fecha devolucion");
                ingresarFecha(evt, t_FechaDevolucion);
            }
        });
        
        //Boton '+' Garantia
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 ingresarGarantia(evt);
            }
        });
        
        //Boton '-' Garantia
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {                
                eliminarGarantia(evt);
            }
        });
        
        
        java.awt.Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(d.getWidth()/2-this.getWidth()/2), (int)(d.getHeight()/2-this.getHeight()/2));
                
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
    }
    
   public void cargarVentana(){
       modifica = false;
        try{
            Conexion con = new Conexion(dirIP);
            if(con.conectar() == 1){
                java.sql.ResultSet res = con.consultar("select cte.CEDULA, cte.NOMBRE, cte.DIRECCION, cte.TELEFONO1, cte.TELEFONO2, cte.CORREO, cte.RIF  from CLIENTES cte, CONTRATOS cto where cte.CEDULA = cto.CTE_CEDULA and cto.ID = '"+idContrato+"'");
                res.next();
                
                String estado = "";
                String id_cto = " 000000"+idContrato;
                id_cto = id_cto.substring(id_cto.length()-6, id_cto.length());
                jLabel5.setText("Contrato Nº: "+id_cto);
                
                t_cedula.setText(res.getString(1));
                t_nombre.setText(res.getString(2));
                t_direccion.setText(res.getString(3));
                t_tlf1.setText(res.getString(4));
                t_tlf2.setText(res.getString(5));
                t_correo.setText(res.getString(6));
                t_rif.setText(res.getString(7));
                
                res = con.consultar("select to_char(FECHA_EMISION,'DD/MM/YYYY'), to_char(FECHA_ENTREGA,'DD/MM/YYYY'), to_char(FECHA_DEVOLUCION,'DD/MM/YYYY'), TOTAL_PAGAR, ESTADO from CONTRATOS where ID = '"+idContrato+"'");
                res.next();
                
                jLabel10.setText("Fecha Emisión: "+res.getString(1));
                t_FechaEntrega.setText(res.getString(2));
                t_FechaDevolucion.setText(res.getString(3));
                t_total.setText(res.getString(4));
                estado = res.getString(5);
                c_estado.setSelectedItem(estado);
                this.setTitle("D' Etiqueta - Contrato "+id_cto+" - "+estado);
                
                /*if(estado.compareToIgnoreCase("PENDIENTE") == 0){
                    t_FechaEntrega.setEditable(true);
                }
                if(estado.compareToIgnoreCase("ACTIVO") == 0){
                    jButton10.setEnabled(false);
                }*/
                if(estado.compareToIgnoreCase("Finalizado") == 0 || estado.compareToIgnoreCase("Cancelado") == 0){
                    jButton5.setEnabled(false);
                    jButton8.setEnabled(false);
                    jButton9.setEnabled(false);
                    jButton10.setEnabled(false);
                    jButton11.setEnabled(false);
                    jButton12.setEnabled(false);
                    jButton13.setEnabled(false);
                    jButton14.setEnabled(false);
                    jButton15.setEnabled(false);
                    c_estado.setEnabled(false);                    
                    jTextArea1.setEditable(false);
                   
                }
                if(estado.compareToIgnoreCase("Finalizado") == 0){
                    jButton8.setEnabled(true);
                    jButton9.setEnabled(true);
                }
                
                estadoContrato = estado;
                
                res = con.consultar("select DESCRIPCION from OBSERVACIONES where CTO_ID = '"+idContrato+"'");
                if(res.next()){
                    jTextArea1.setText(res.getString(1));
                }
                
                res = con.consultar("select TPGO_ID, MONTO, to_char(FECHA,'DD/MM/YY') from PAGOS where CTO_ID = '"+idContrato+"' and MVO_ID = '01' order by ID");
                c1 = 0;               
                while (res.next() && c1<jTable2.getRowCount()){
                    int t_pago = Integer.parseInt(res.getString(1));
                    String monto = res.getString(2);
                    String fecha = res.getString(3);
                    String tipo="";
                    
                    if(t_pago == 1){
                        tipo =  "Efectivo";
                    }
                    if(t_pago == 2){
                        tipo =  "Cheque";
                    }
                    if(t_pago == 3){
                        tipo =  "Tarj. Créd.";
                    }
                    if(t_pago == 4){
                        tipo =  "Tarj. Déb.";
                    }
                    if(t_pago == 5){
                        tipo =  "Otro";
                    }
                    
                    jTable2.setValueAt(tipo, c1, 0);
                    jTable2.setValueAt(monto, c1, 1);
                    jTable2.setValueAt(fecha, c1, 2);
                    c1++;
                }
               //******************
                res = con.consultar("select TPGO_ID, OBSERVACION from PAGOS where CTO_ID = '"+idContrato+"' and MVO_ID = '02' order by ID");
                c2 = 0 ;
                while (res.next() && c2<jTable3.getRowCount()){
                    int t_pago = Integer.parseInt(res.getString(1));
                    String observacion = res.getString(2);
                    String tipo="";
                    
                    if(t_pago == 1){
                        tipo =  "Efectivo";
                    }
                    if(t_pago == 2){
                        tipo =  "Cheque";
                    }                   
                    if(t_pago == 5){
                        tipo =  "Otro";
                    }
                    
                    jTable3.setValueAt(tipo, c2, 0);
                    jTable3.setValueAt(observacion, c2, 1);
                    
                    c2++;
                }
                
                //res = con.consultar("select i.CANTIDAD, i.PRECIO, i.CANTIDAD*i.PRECIO, a.TARO_ID, a.FARO_ID, a.CARO_ID, A.TALLA from ITEMS i, ACCESORIOS a where i.ARO_ID = a.ID and i.CTO_ID = '"+idContrato+"' order by i.ID");                
                res = con.consultar("select i.CANTIDAD, i.PRECIO, a.TARO_ID, a.FARO_ID, a.CARO_ID, a.TALLA, "
                                    +"ta.DESCRIPCION, fa.DESCRIPCION, ca.COLOR1, ca.COLOR2, ca.COLOR3, ma.DESCRIPCION, a.MARO_ID, a.NUM_EJEMPLAR "
                                    +"from ITEMS i, ACCESORIOS a, TIPO_ACCESORIOS ta, FORMA_ACCESORIOS fa, COLOR_ACCESORIOS ca, MARCA_ACCESORIOS ma "
                                    +"where i.ARO_ID = a.ID AND a.TARO_ID = ta.ID and a.FARO_ID = fa.ID and a.CARO_ID = ca.id and a.MARO_ID = ma.ID and i.CTO_ID = '"+idContrato+"' order by i.ID");
                int c3 = 0 ;                
                while (res.next() && c3<jTable1.getRowCount()){
                    String cant = res.getString(1);
                    String prec = res.getString(2);                    
                    String codTip = res.getString(3);
                    String codFor = res.getString(4);
                    String codCol = res.getString(5);
                    String codTal = res.getString(6);
                    String talla = codTal;
                    String descTip = res.getString(7);
                    String descFor = res.getString(8);
                    String descCol1 = res.getString(9);
                    String descCol2 = res.getString(10);
                    String descCol3 = res.getString(11);
                    String marca = res.getString(12);
                    String idMarca = res.getString(13);
                    String numEjem = res.getString(14);
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
                    
                    if(codTip.length()==1){
                        codTip = "0"+codTip;
                    }
                    if(codFor.length()==1){
                        codFor = "0"+codFor;
                    }
                    if(codCol.length()==1){
                        codCol = "0"+codCol;
                    }
                    if(codTal.length()==1){
                        codTal = "0"+codTal;
                    }
                    if(idMarca.length()==1){
                        idMarca = "0"+idMarca;
                    }
                    if(numEjem.length()==1){
                        numEjem = "0"+numEjem;
                    }
                    
                    String cod = codTip + codFor + codCol + codTal + "-" + idMarca + numEjem;
                    String desc = descTip + " " + descFor + " " + descCol + "Talla " + talla + " (" + marca + ")";
                    
                    /*jTable1.setValueAt(cod, c3, 0);
                    jTable1.setValueAt(cant, c3, 1);
                    jTable1.setValueAt(desc, c3, 2);
                    jTable1.setValueAt(prec, c3, 3);
                    jTable1.setValueAt(tot2, c3, 4);*/
                    jTable1.setValueAt(cod, c3, 0);
                    jTable1.setValueAt(desc, c3, 1);
                    jTable1.setValueAt(prec, c3, 2);
                    
                    c3++;
                }
                calcularTotales();                
                
                con.desconectar();
            }
            else{
                JOptionPane.showMessageDialog(this,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
        catch(Exception e){e.printStackTrace(); }
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
   
    private void ingresarPago(java.awt.event.ActionEvent evt) {
        IngresarPago obj = new IngresarPago(this);
        String agrega = obj.getAgrega();
        obj.dispose();        
        if(!agrega.isEmpty()){
            for(int i=0;i<jTable2.getRowCount();i++){
                if(jTable2.getValueAt(i,0) == null){                    
                    String dia = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                    String mes = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);                    
                    if(Integer.parseInt(mes)<10){
                        mes = "0"+mes;
                    }
                    String anho = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).substring(2,4);
                    String fecha = dia+"/"+mes+"/"+anho;
                    
                    String palab[];
                    palab = agrega.split("-");
                    jTable2.setValueAt(palab[0],i,0);
                    jTable2.setValueAt(palab[1],i,1);
                    jTable2.setValueAt(fecha,i,2);
                    break;
                }
            }            
            calcularTotales();
        }
    }
    
    public void eliminarAccesorio(java.awt.event.ActionEvent evt){ 
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
            modifica = true;
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione un accesorio para eliminar", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
    
    public void eliminarPago(java.awt.event.ActionEvent evt){
        int index = jTable2.getSelectedRow();
        if(index != -1 && jTable2.getValueAt(index,0)!=null){
            if(index+1 > c1){
                for(int i=index;i<jTable2.getRowCount()-1;i++){
                    jTable2.setValueAt(jTable2.getValueAt(i+1, 0),i,0);
                    jTable2.setValueAt(jTable2.getValueAt(i+1, 1),i,1);
                    jTable2.setValueAt(jTable2.getValueAt(i+1, 1),i,2);
                }
                jTable2.setValueAt(null,jTable2.getRowCount()-1,0);
                jTable2.setValueAt(null,jTable2.getRowCount()-1,1);
                jTable2.setValueAt(null,jTable2.getRowCount()-1,2);
                calcularTotales();
            }
            else{
                JOptionPane.showMessageDialog(this,"No se pueden eliminar pagos anteriores", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione el pago a eliminar", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
    
    public void eliminarGarantia(java.awt.event.ActionEvent evt){
        int index = jTable3.getSelectedRow();
        if(index != -1 && jTable3.getValueAt(index,0)!=null){
            if(index+1 > c2){
                for(int i=index;i<jTable3.getRowCount()-1;i++){
                    jTable3.setValueAt(jTable3.getValueAt(i+1, 0),i,0);
                    jTable3.setValueAt(jTable3.getValueAt(i+1, 1),i,1);
                }
                jTable3.setValueAt(null,jTable3.getRowCount()-1,0);
                jTable3.setValueAt(null,jTable3.getRowCount()-1,1);
            }
            else{
                JOptionPane.showMessageDialog(this,"No se pueden eliminar garantías anteriores", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione la garantía a eliminar", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
    
    public void ingresarFecha(java.awt.event.ActionEvent evt, javax.swing.JTextField txt){
        Calendario obj = new Calendario(this);
        String agrega = obj.getAgrega();
        obj.dispose();
        if(!agrega.isEmpty()){
            txt.setText(agrega);
        }
    }
    
    public  void cancelar(java.awt.event.ActionEvent evt) {                          
        this.dispose();
    }                         

    public void imprimir(java.awt.event.ActionEvent evt) {
        //Factura obj = new Factura(this, String.valueOf(idContrato),dirIP);
        Impresion obj = new Impresion(dirIP, String.valueOf(idContrato));
    }
    
    public void procesar(java.awt.event.ActionEvent evt) {
        String dia = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
        if(Integer.parseInt(mes)<10){
            mes = "0"+mes;
        }
        String anho = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        String fecha = dia+"/"+mes+"/"+anho;
        int error = 0;
        
        if(c_estado.isEnabled()){   
            Conexion con = new Conexion(dirIP);
            if(jTextArea1.getText().length()>100){
                error = 1;
            }
            try{
                if(error == 0 && con.conectar() == 1){                    
                    for(int ii=c1; ii<jTable2.getRowCount(); ii++){
                        if(jTable2.getValueAt(ii,1) != null){
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

                            java.sql.ResultSet res = con.consultar("select nvl(max(ID)+1,1) from PAGOS");
                            res.next();
                            idpago = res.getString(1);

                            con.actualizar("insert into PAGOS values('"+idpago+"','','"+montPgo+"','"+fecha+"','"+idContrato+"','"+tipPgo+"','"+motiv+"')");
                            //System.out.println("PGO insert into PAGOS values('"+idpago+"','','"+montPgo+"','"+fecha+"','"+idContrato+"','"+tipPgo+"','"+motiv+"')");
                        }
                        else{
                            break;
                        }
                    }
                    
                    //---------------Garantias-----------                    
                    for(int ii=c2;ii<jTable3.getRowCount();ii++){
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
                                
                                java.sql.ResultSet res = con.consultar("select nvl(max(ID)+1,1) from PAGOS");
                                res.next();
                                idgarant = res.getString(1);
                                
                                con.actualizar("insert into PAGOS values('"+idgarant+"','"+desc+"','','"+fecha+"','"+idContrato+"','"+tipGta+"','"+motiv+"')");
                                //System.out.println("GTA insert into PAGOS values('"+idgarant+"','"+desc+"','','"+fecEmision+"','"+idCto+"','"+tipGta+"','"+motiv+"')");
                            }
                            else{
                                break;
                            }
                        }
                    //-----------------------------------
                    
                    if(modifica){
                        String ids[] = new String[10];
                        int ci = 0, ca = 0;;
                        String query = "select ID from ITEMS where CTO_ID='"+idContrato+"' order by ID";
                        java.sql.ResultSet res = con.consultar(query);
                        while(res.next()){
                            ids[ci] = res.getString(1);
                            ci++;
                        }
                        query = "delete from ITEMS where CTO_ID='"+idContrato+"'";
                        con.actualizar(query);
                        for(int ii=0;ii<jTable1.getRowCount();ii++){
                            if(jTable1.getValueAt(ii,0) != null){
                                String codigos[] = new String[6];
                                String codigo = jTable1.getValueAt(ii,0).toString();
                                codigos[0] = codigo.substring(0,2);
                                codigos[1] = codigo.substring(2,4);
                                codigos[2] = codigo.substring(4,6);
                                codigos[3] = codigo.substring(6,8);
                                if(codigos[3].charAt(0) == '0' && codigos[3].length()>1){
                                    codigos[3] = codigos[3].substring(1,codigos[3].length());
                                }
                                codigos[4] = codigo.substring(9,11);
                                codigos[5] = codigo.substring(11,13);
                                
                                
                                query = "select ID from ACCESORIOS where "
                                                +"TARO_ID='"+codigos[0]+"' and FARO_ID='"+codigos[1]+"' and CARO_ID='"+codigos[2]+"' and MARO_ID='"+codigos[4]+"' and NUM_EJEMPLAR='"+codigos[5]+"' and TALLA='"+codigos[3]+"'";
                                res = con.consultar(query);                                
                                if(res.next()){
                                    String idAccesorio = res.getString(1);
                                    String idItem;
                                    if(ii<ci){
                                        idItem = ids[ii];
                                    }
                                    else{
                                        query = "select max(ID)+1 from ITEMS";
                                        res = con.consultar(query);
                                        res.next();
                                        idItem = res.getString(1);
                                    }
                                    
                                    query = "insert into ITEMS values('"+idItem+"', '1', "+jTable1.getValueAt(ii,2).toString()+", '"+idContrato+"', '"+idAccesorio+"')";
                                    con.actualizar(query);
                                    System.out.println("ITM "+query);
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
                    }
                    
                    //-----------------------------------
                    if(jTextArea1.getText().length()>0){
                        java.sql.ResultSet res = con.consultar("select count(id) from OBSERVACIONES where CTO_ID = '"+idContrato+"'");
                        res.next();
                        if(res.getString(1).compareTo("0") == 0){
                            String observac = jTextArea1.getText();
                            String idObs = "";

                            res = con.consultar("select nvl(max(ID)+1,1) from OBSERVACIONES");
                            res.next();
                            idObs = res.getString(1);

                            con.actualizar("insert into OBSERVACIONES values('"+idObs+"','"+observac+"','"+idContrato+"')");
                            //System.out.println("OBN insert into OBSERVACIONES values('"+idObs+"','"+observac+"','"+idContrato+"')");
                        }
                        else{
                            con.consultar("update OBSERVACIONES set DESCRIPCION = '"+jTextArea1.getText()+"' where CTO_ID='"+idContrato+"'");
                            //System.out.println("OBN update OBSERVACIONES set DESCRIPCION = '"+jTextArea1.getText()+"' where CTO_ID='"+idContrato+"'");
                        }
                    }
                    /////******************Error 2-*****************
                    con.actualizar("update CONTRATOS set FECHA_ENTREGA = '"+t_FechaEntrega.getText()+"', FECHA_DEVOLUCION = '"+t_FechaDevolucion.getText()+"' where ID = '"+idContrato+"'");
                                        
                    con.actualizar("update CONTRATOS set ESTADO = '"+c_estado.getSelectedItem().toString().toUpperCase()+"' where ID = '"+idContrato+"'");
                    //System.out.println("EDO update CONTRATOS set ESTADO = '"+c_estado.getSelectedItem().toString().toUpperCase()+"' where ID = '"+idContrato+"'");
                    
                    //estaba Pendiente y ahora esta Activo
                    if(c_estado.getSelectedItem().toString().compareToIgnoreCase("Activo") == 0 && estadoContrato.compareToIgnoreCase("Pendiente")==0){                        
                        con.actualizar("update ACCESORIOS set UBN_ID = '04' where ID in (select i.ARO_ID from ITEMS i, CONTRATOS c where i.CTO_ID = c.ID and c.ID='"+idContrato+"')");
                        //System.out.println("EDO update ACCESORIOS set UBN_ID = '04' where ID in (select i.ARO_ID from ITEMS i, CONTRATOS c where i.CTO_ID = c.ID and c.ID='"+idContrato+"')");
                    }
                    //estaba Activo y ahora esta Finalizado
                    if(c_estado.getSelectedItem().toString().compareToIgnoreCase("Finalizado") == 0 && estadoContrato.compareToIgnoreCase("Activo")==0){
                        con.actualizar("update ACCESORIOS set UBN_ID = '01' where ID in (select i.ARO_ID from ITEMS i, CONTRATOS c where i.CTO_ID = c.ID and c.ID='"+idContrato+"')");
                        //System.out.println("EDO update ACCESORIOS set UBN_ID = '01' where ID in (select i.ARO_ID from ITEMS i, CONTRATOS c where i.CTO_ID = c.ID and c.ID='"+idContrato+"')");
                    }
                    //estaba Activo y ahora esta Cancelado
                    if(c_estado.getSelectedItem().toString().compareToIgnoreCase("Cancelado") == 0 && estadoContrato.compareToIgnoreCase("Activo")==0){
                        con.actualizar("update ACCESORIOS set UBN_ID = '01' where ID in (select i.ARO_ID from ITEMS i, CONTRATOS c where i.CTO_ID = c.ID and c.ID='"+idContrato+"')");
                        //System.out.println("EDO update ACCESORIOS set UBN_ID = '01' where ID in (select i.ARO_ID from ITEMS i, CONTRATOS c where i.CTO_ID = c.ID and c.ID='"+idContrato+"')");
                    }
                    //estaba Activo y ahora esta Pendiente
                    if(c_estado.getSelectedItem().toString().compareToIgnoreCase("Cancelado") == 0 && estadoContrato.compareToIgnoreCase("Activo")==0){
                        con.actualizar("update ACCESORIOS set UBN_ID = '01' where ID in (select i.ARO_ID from ITEMS i, CONTRATOS c where i.CTO_ID = c.ID and c.ID='"+idContrato+"')");
                        //System.out.println("EDO update ACCESORIOS set UBN_ID = '01' where ID in (select i.ARO_ID from ITEMS i, CONTRATOS c where i.CTO_ID = c.ID and c.ID='"+idContrato+"')");
                    }
                    //estaba Pendiente y ahora esta Finalizado
                    //No hacer nada  
                    
                    
                    con.desconectar();
                    JOptionPane.showMessageDialog(this,"Contrato Actualizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    cargarVentana();
                }
            }
            catch(Exception er){}
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
             
             Pre_Cant obj = null;//new Pre_Cant(this,dirIP,d1, d2);
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
                         
                         modifica = true;
                         
                         break;
                     }
                 }
             }
        }
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
}
