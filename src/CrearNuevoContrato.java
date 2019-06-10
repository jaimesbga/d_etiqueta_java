import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class CrearNuevoContrato {
    private JFrame ventana;
    private JPanel panelVentana, panelCliente, panelEntrega, panelPedido, panelPagos, panelGarantias, panelObservaciones;
    private JScrollPane scrollVentana, scrollPedido, scrollPagos, scrollGarantias, scrollObservaciones;
    private JLabel l_fondo, l_idContrato, l_fechaEmision;
    private JButton b_buscar, b_editar, b_nuevo, b_procesar, b_cancelar;
    private JTextField t_ced, t_nom, t_dir, t_tlf1, t_tlf2, t_correo, t_rif;
    private JLabel l_ced, l_nom, l_dir, l_tlf1, l_tlf2, l_correo, l_rif;
    private JLabel l_fechaEntrega, l_fechaDevolucion, l_cantidadProductos, l_totalPagar, l_totalPagado, l_resta, l_caracteres;
    private JTextField t_fechaEntrega, t_fechaDevolucion, t_totalPagar, t_totalPagado, t_resta;
    private JTable tablaPedido, tablaPagos, tablaGarantias;
    private DefaultTableModel_M modeloPedido, modeloPagos, modeloGarantias;
    private JButton b_agregarProducto, b_agregarPago, b_eliminarPago, b_agregarGarantia, b_eliminarGarantia;
    private JTextArea area;
    
    private String dirIP;
    private String idSucursal;
    
    public CrearNuevoContrato(String ip, String suc) {
        dirIP = ip;
        idSucursal = suc;
        
        inicializar();
        ventana.setVisible(true);
    }
    
    public void inicializar(){
        ventana = new JFrame("D' Etiqueta - Crear Contrato");        
        ventana.setDefaultCloseOperation(ventana.DISPOSE_ON_CLOSE);
        ventana.setResizable(false);
        
        scrollVentana = new JScrollPane(); 
        panelVentana = new JPanel();  
        GroupLayout jPanel1Layout = new GroupLayout(panelVentana);
        panelVentana.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        scrollVentana.setViewportView(panelVentana);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(ventana.getContentPane());
        ventana.getContentPane().setLayout(layout);        
        ventana.getContentPane().add(scrollVentana);
        ventana.pack();
        ventana.setSize(615, 525);
        scrollVentana.setSize(610, 512);
        scrollVentana.getVerticalScrollBar().setUnitIncrement(20);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setLocation((int)(d.getWidth()/2-ventana.getWidth()/2), (int)(d.getHeight()/2-ventana.getHeight()/2)); 
        
        l_fondo = new JLabel();
        l_fondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Logo-Contrato.gif")));
        l_fondo.setBounds(10, 10, 537, 49);
        
        l_idContrato = new JLabel("Contrato Nº: ");
        l_idContrato.setFont(new Font("Arial", Font.BOLD, 14));
        l_idContrato.setBounds(15, 60, 300, 50);
        
        l_fechaEmision = new JLabel("Fecha de Emisión: ");
        l_fechaEmision.setFont(new Font("Arial", Font.BOLD, 14));
        l_fechaEmision.setBounds(330, 60, 300, 50);
        String dia = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
        if(Integer.parseInt(mes)<10){
            mes = "0"+mes;
        }
        String anho = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        l_fechaEmision.setText("Fecha de Emisión: "+dia+" / "+mes+" / "+anho);
        
        panelCliente = new JPanel();
        panelCliente.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
        panelCliente.setLayout(null);
        panelCliente.setBounds(10, 100, 570, 150);
        
        l_ced = new JLabel("Cédula:");
        l_ced.setBounds(25, 15, 100, 30);        
        t_ced = new JTextField();
        t_ced.setBounds(90, 20, 180, 20);
        t_ced.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode()==10){
                    limpiarCamposCliente();
                    buscarCliente();
                }
            }
        });
        
        l_nom = new JLabel("Nombre: ");        
        l_nom.setBounds(20, 40, 100, 30);        
        t_nom = new JTextField();
        t_nom.setBounds(90, 45, 460, 20);
        t_nom.setEditable(false);
        
        l_dir = new JLabel("Dirección:");
        l_dir.setBounds(11, 65, 100, 30);        
        t_dir = new JTextField();
        t_dir.setBounds(90, 70, 460, 20);
        t_dir.setEditable(false);
        
        l_tlf1 = new JLabel("Teléfono 1:");
        l_tlf1.setBounds(6, 90, 100, 30);        
        t_tlf1 = new JTextField();
        t_tlf1.setBounds(90, 95, 180, 20);
        t_tlf1.setEditable(false);
        
        l_tlf2 = new JLabel("Teléfono 2:");
        l_tlf2.setBounds(290, 90, 100, 30);        
        t_tlf2 = new JTextField();
        t_tlf2.setBounds(370, 95, 180, 20);
        t_tlf2.setEditable(false);
        
        l_correo = new JLabel("Correo:");
        l_correo.setBounds(25, 115, 100, 30);        
        t_correo = new JTextField();
        t_correo.setBounds(90, 120, 180, 20);
        t_correo.setEditable(false);
        
        l_rif = new JLabel("R.I.F.:");
        l_rif.setBounds(322, 115, 100, 30);
        t_rif = new JTextField();
        t_rif.setBounds(370, 120, 180, 20);
        t_rif.setEditable(false);
        
        b_buscar = new JButton("Buscar");
        b_buscar.setMnemonic('B');
        b_buscar.setBounds(290, 17, 80, 25);
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCamposCliente();
                buscarCliente();
            }
        });
        
        b_editar = new JButton("Editar");
        b_editar.setMnemonic('E');
        b_editar.setBounds(380, 17, 80, 25);
        b_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCamposCliente();
                editarCliente();
            }
        });
        
        b_nuevo = new JButton("Nuevo");
        b_nuevo.setMnemonic('N');
        b_nuevo.setBounds(470, 17, 80, 25);
        b_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCamposCliente();
                AgregarCliente2 obj = new AgregarCliente2(dirIP, true, t_ced);
            }
        });
        
        panelCliente.add(l_ced);
        panelCliente.add(t_ced);
        panelCliente.add(b_buscar);
        panelCliente.add(b_editar);
        panelCliente.add(b_nuevo);
        panelCliente.add(l_nom);
        panelCliente.add(t_nom);
        panelCliente.add(l_dir);
        panelCliente.add(t_dir);
        panelCliente.add(l_tlf1);        
        panelCliente.add(t_tlf1);
        panelCliente.add(l_tlf2);
        panelCliente.add(t_tlf2);
        panelCliente.add(l_correo);
        panelCliente.add(t_correo);
        panelCliente.add(l_rif);
        panelCliente.add(t_rif);
        
        panelEntrega = new JPanel();
        panelEntrega.setBorder(BorderFactory.createTitledBorder("Datos de la Entrega"));
        panelEntrega.setLayout(null);
        panelEntrega.setBounds(10, 250, 570, 60);
        
        l_fechaEntrega = new JLabel("Fecha de Entrega: ");
        l_fechaEntrega.setBounds(30, 20, 150, 30);
        t_fechaEntrega = new JTextField();
        t_fechaEntrega.setBounds(140, 25, 130, 20);
        t_fechaEntrega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ingresarFecha(t_fechaEntrega);
                evt.consume();
            }
        });
        t_fechaEntrega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarFecha(t_fechaEntrega);
            }
        });
        
        l_fechaDevolucion = new JLabel("Fecha de Devolución: ");
        l_fechaDevolucion.setBounds(285, 20, 150, 30);        
        t_fechaDevolucion = new JTextField();
        t_fechaDevolucion.setBounds(420, 25, 130, 20);
        t_fechaDevolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarFecha(t_fechaDevolucion);
            }
        });
        t_fechaDevolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ingresarFecha(t_fechaDevolucion);
                evt.consume();
            }
        });        
        
        panelEntrega.add(l_fechaEntrega);
        panelEntrega.add(t_fechaEntrega);
        panelEntrega.add(l_fechaDevolucion);
        panelEntrega.add(t_fechaDevolucion);
        
        panelPedido = new JPanel();
        panelPedido.setBorder(BorderFactory.createTitledBorder("Datos del Pedido"));
        panelPedido.setLayout(null);
        panelPedido.setBounds(10, 320, 570, 170);
        
        modeloPedido = new DefaultTableModel_M( new Object [][] {
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}
            }, new String [] {"Código", "Descripción"});
        
        tablaPedido = new JTable();
        tablaPedido.setSize(540, 110);
        tablaPedido.setModel(modeloPedido);
        tablaPedido.getTableHeader().setReorderingAllowed(false);
        tablaPedido.getColumnModel().getColumn(0).setPreferredWidth( (int)(20*tablaPedido.getWidth()/100));
        tablaPedido.getColumnModel().getColumn(1).setPreferredWidth(80*tablaPedido.getWidth()/100);
        
        scrollPedido = new JScrollPane(tablaPedido);
        scrollPedido.setBounds(15, 20, 540, 110);
        
        b_agregarProducto = new JButton("+");
        b_agregarProducto.setBounds(15, 135, 45, 25);
        b_agregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarProducto();
            }
        });
        
        l_cantidadProductos = new JLabel("Cantidad: 0");
        l_cantidadProductos.setBounds(100, 132, 150, 30);
        
        l_totalPagar = new JLabel("Total a Pagar: ");
        l_totalPagar.setBounds(350, 132, 150, 30);
        
        t_totalPagar = new JTextField("0.0");
        t_totalPagar.setBounds(435, 138, 120, 20);
        t_totalPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editaTotalPagar(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt){
                calcularTotales();
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode()==10){
                    scrollVentana.getVerticalScrollBar().setValue(500);
                    ingresarPago();
                }
            }
        });
        t_totalPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_totalPagar.setSelectionStart(0);
                t_totalPagar.setSelectionEnd(t_totalPagar.getText().length());
            }
        });
                
        panelPedido.add(scrollPedido);
        panelPedido.add(b_agregarProducto);
        panelPedido.add(l_cantidadProductos);
        panelPedido.add(l_totalPagar);
        panelPedido.add(t_totalPagar);
        
        panelPagos = new JPanel();
        panelPagos.setBorder(BorderFactory.createTitledBorder("Pagos"));
        panelPagos.setLayout(null);
        panelPagos.setBounds(10, 500, 260, 200);
        
        modeloPagos = new DefaultTableModel_M( new Object [][] {
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null},
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}
            }, new String [] {"Tipo de Pago", "Monto"});        
        tablaPagos = new JTable();
        tablaPagos.setModel(modeloPagos);
        tablaPagos.setSize(240, 140);
        tablaPagos.getTableHeader().setReorderingAllowed(false);
        tablaPagos.getColumnModel().getColumn(0).setPreferredWidth( (int)(45*tablaPagos.getWidth()/100));
        tablaPagos.getColumnModel().getColumn(1).setPreferredWidth(55*tablaPagos.getWidth()/100);        
        scrollPagos = new JScrollPane(tablaPagos);
        scrollPagos.setBounds(15, 20, 230, 90);
        
        l_totalPagado = new JLabel("Total:");
        l_totalPagado.setBounds(70, 110, 100, 30);        
        t_totalPagado = new JTextField("0.0");
        t_totalPagado.setBounds(112, 115, 120, 20);
        t_totalPagado.setEditable(false);
        
        
        l_resta = new JLabel("Resta:");
        l_resta.setBounds(65, 135, 100, 30);        
        t_resta = new JTextField("0.0");
        t_resta.setBounds(112, 140, 120, 20);
        t_resta.setEditable(false);
        
        b_agregarPago = new JButton("+");
        b_agregarPago.setBounds(50, 165, 45, 25);
        b_agregarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarPago();
            }
        });
        
        b_eliminarPago = new JButton("-");
        b_eliminarPago.setBounds(140, 165, 45, 25);
        b_eliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPago();
            }
        });
        
        panelPagos.add(scrollPagos);
        panelPagos.add(l_totalPagado);
        panelPagos.add(t_totalPagado);
        panelPagos.add(l_resta);
        panelPagos.add(t_resta);
        panelPagos.add(b_agregarPago);
        panelPagos.add(b_eliminarPago);
        
        panelGarantias = new JPanel();
        panelGarantias.setBorder(BorderFactory.createTitledBorder("Garantías"));
        panelGarantias.setLayout(null);
        panelGarantias.setBounds(280, 500, 300, 200);
        
        modeloGarantias = new DefaultTableModel_M( new Object [][] {
                {null, null}, {null, null}, {null, null}, {null, null}, {null, null}
            }, new String [] {"Tipo", "Descripción"});
        tablaGarantias = new JTable();
        tablaGarantias.setModel(modeloGarantias);
        tablaGarantias.setSize(280, 150);
        tablaGarantias.getTableHeader().setReorderingAllowed(false);
        tablaGarantias.getColumnModel().getColumn(0).setPreferredWidth( (int)(25*tablaPagos.getWidth()/100));
        tablaGarantias.getColumnModel().getColumn(1).setPreferredWidth(75*tablaPagos.getWidth()/100);        
        scrollGarantias = new JScrollPane(tablaGarantias);
        scrollGarantias.setBounds(15, 20, 270, 100);
        
        b_agregarGarantia = new JButton("+");
        b_agregarGarantia.setBounds(85, 165, 45, 25);
        b_agregarGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarGarantia();
            }
        });
        
        b_eliminarGarantia = new JButton("-");
        b_eliminarGarantia.setBounds(175, 165, 45, 25);
        b_eliminarGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarGarantia();
            }
        });
                
        panelGarantias.add(scrollGarantias);
        panelGarantias.add(b_agregarGarantia);
        panelGarantias.add(b_eliminarGarantia);
        
        panelObservaciones = new JPanel();
        panelObservaciones.setBorder(BorderFactory.createTitledBorder("Observaciones"));
        panelObservaciones.setLayout(null);
        panelObservaciones.setBounds(10, 710, 260, 200);
        
        l_caracteres = new JLabel("Caracteres: 0 / 100");
        l_caracteres.setBounds(15, 160, 200, 30);
        
        area = new JTextArea();
        area.setSize(240, 180);
        area.setWrapStyleWord(true);
        area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt){
                if(area.getText().length()>99){
                    evt.consume();
                }
            }
            public void keyReleased(java.awt.event.KeyEvent evt) { 
                l_caracteres.setText("Caracteres: "+area.getText().length()+" / 100");
            }
        });     
        scrollObservaciones = new JScrollPane(area);
        scrollObservaciones.setBounds(15, 30, 230, 130);        
        
        panelObservaciones.add(scrollObservaciones);
        panelObservaciones.add(l_caracteres);
        
        b_procesar = new JButton();
        b_procesar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/procesar.png")));
        b_procesar.setOpaque(false);
        b_procesar.setBackground(Color.CYAN);
        b_procesar.setBounds(300, 750, 100, 100);
        b_procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(validarCampos() && JOptionPane.showConfirmDialog(ventana, "Seguro que desea procesar el contrato?", "Mensaje", JOptionPane.YES_NO_OPTION) == 0){
                    procesar();
                }
            }
        });
        
        b_cancelar = new JButton();
        b_cancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/cancelar.png")));
        b_cancelar.setOpaque(false);
        b_cancelar.setBackground(Color.CYAN);
        b_cancelar.setBounds(460, 750, 100, 100);
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar();
            }
        });
        
        panelVentana.add(l_fondo);
        panelVentana.add(l_idContrato);
        panelVentana.add(l_fechaEmision);
        panelVentana.add(panelCliente);
        panelVentana.add(panelEntrega);
        panelVentana.add(panelPedido);
        panelVentana.add(panelPagos);
        panelVentana.add(panelGarantias);
        panelVentana.add(panelObservaciones);
        panelVentana.add(b_procesar);
        panelVentana.add(b_cancelar);
    }
    
    public void buscarCliente(){
        if(t_ced.getText().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Ingrese un número de Cédula", "Advertencia", JOptionPane.OK_OPTION);
        }
        else{
            Conexion con = new Conexion(dirIP);
            String cedula = t_ced.getText();
            if(con.conectar() == 1){
                try{
                    java.sql.ResultSet res = con.consultar("select * from CLIENTES where cedula='"+cedula+"'");
                    if(res.next()){
                        limpiarCamposCliente();
                        t_ced.setText(res.getString(1));
                        t_nom.setText(res.getString(2));
                        t_dir.setText(res.getString(3));
                        t_tlf1.setText(res.getString(4));
                        t_tlf2.setText(res.getString(5));
                        t_correo.setText(res.getString(6));
                        t_rif.setText(res.getString(7));
                        ingresarFecha(t_fechaEntrega);
                    }
                    else{
                        JOptionPane.showMessageDialog(ventana, "No se encontro el Cliente", "Advertencia", JOptionPane.OK_OPTION);
                    }
                    con.desconectar();
                }
                catch(Exception er){
                }
            }
            else{
                JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
            }
        }        
    }
    
    public void editarCliente(){
        if(t_ced.getText().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Ingrese un número de Cédula", "Advertencia", JOptionPane.OK_OPTION);
        }
        else{
            limpiarCamposCliente();
            AgregarCliente2 obj = new AgregarCliente2(dirIP, t_ced.getText(), t_ced);
        }
    }
    
    public void nuevoCliente(){
        limpiarCamposCliente();
        AgregarCliente2 obj = new AgregarCliente2(dirIP, true, t_ced);
    }
    
    public void limpiarCamposCliente(){
        t_nom.setText("");
        t_dir.setText("");
        t_tlf1.setText("");;
        t_tlf2.setText("");
        t_correo.setText("");
        t_rif.setText("");
    }
    
    public void editaTotalPagar(KeyEvent evt){
        String cad = t_totalPagar.getText()+evt.getKeyChar();        
        if(!t_totalPagar.getText().isEmpty()){
            try{
                float f = Float.parseFloat(cad);
                if(String.valueOf(evt.getKeyChar()).compareToIgnoreCase("d")==0
                        || String.valueOf(evt.getKeyChar()).compareToIgnoreCase("f")==0){
                    f = Float.parseFloat("ffff");
                }
                /*else{
                    calcularTotales();
                }*/
            }
            catch(Exception ex){
                evt.consume();
            }
        }  
        //calcularTotales();
    }
    
    public void ingresarFecha(JTextField txt){
        String titulo = "";
        Calendario obj;
        if(txt == t_fechaEntrega){
            obj = new Calendario(ventana, "Fecha de Entrega");
        }
        else{
            obj = new Calendario(ventana, "Fecha de Devolución");
        }        
        String agrega = obj.getAgrega();
        GregorianCalendar selec = obj.getFechaAgrega();
        obj.dispose();
        if(!agrega.isEmpty()){
            GregorianCalendar actual = (GregorianCalendar) GregorianCalendar.getInstance();
            //actual.set(actual.MONTH, actual.get(actual.MONTH)+1);            
            if(actual.compareTo(selec)<=0 || (actual.get(actual.DAY_OF_MONTH)==selec.get(selec.DAY_OF_MONTH)
                        && actual.get(actual.MONTH)==selec.get(selec.MONTH) && actual.get(actual.YEAR)==selec.get(selec.YEAR))){
                txt.setText(agrega);
                if(txt == t_fechaEntrega && t_fechaDevolucion.getText().isEmpty()){
                    ingresarFecha(t_fechaDevolucion);
                }
                else{
                    if(txt == t_fechaDevolucion && !t_fechaEntrega.getText().isEmpty()){
                        scrollVentana.getVerticalScrollBar().setValue(250);
                        ingresarProducto();
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(ventana, "La fecha ya paso, seleccione otra", "Advertencia", JOptionPane.OK_OPTION);
                ingresarFecha(txt);
            }            
        }
    }
    
    public void ingresarProducto(){
        try {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
            Date d1;     //d1>d2 -> 1
            Date d2;     //d1<d2 -> -1
            if(t_fechaEntrega.getText().isEmpty() || t_fechaDevolucion.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Seleccione fecha de entrega y devolución", "Advertencia", JOptionPane.OK_OPTION);
            }
            else{
                d1 = df.parse(t_fechaEntrega.getText());
                d2 = df.parse(t_fechaDevolucion.getText());
                if(d1.compareTo(d2) > 0){
                    JOptionPane.showMessageDialog(null,"La fecha de entrega debe ser menor a la fecha de devolución", "Advertencia", JOptionPane.OK_OPTION);
                }
                else{
                    String fecha1 = t_fechaEntrega.getText();
                    String fecha2 = t_fechaDevolucion.getText();
                    
                    String aux = fecha1;
                    int pos = fecha1.indexOf("/");
                    pos = fecha1.indexOf("/", pos+1);
                    fecha1 = aux.substring(0, pos);
                    fecha1 = fecha1 + "/";
                    fecha1 = fecha1 + aux.substring(pos+3, aux.length());
                    
                    aux = fecha2;
                    pos = fecha2.indexOf("/");
                    pos = fecha2.indexOf("/", pos+1);
                    fecha2 = aux.substring(0, pos);
                    fecha2 = fecha2 + "/";
                    fecha2 = fecha2 + aux.substring(pos+3, aux.length());
                    
                    
                    Pre_Cant obj = new Pre_Cant(ventana, dirIP, fecha1, fecha2, modeloPedido);
                    obj.dispose();
                    int cont = 0;
                    for(int i=0;i<tablaPedido.getRowCount();i++){
                        if(tablaPedido.getValueAt(i, 0) != null){
                            cont++;
                        }
                        else{
                            break;
                        }
                    }
                    l_cantidadProductos.setText("Cantidad: "+cont);
                    t_totalPagar.requestFocus();
                    t_totalPagar.setSelectionStart(0);
                    t_totalPagar.setSelectionEnd(t_totalPagar.getText().length());
                    tablaPedido.getColumnModel().getColumn(0).setPreferredWidth( (int)(20*tablaPedido.getWidth()/100));
                    tablaPedido.getColumnModel().getColumn(1).setPreferredWidth(80*tablaPedido.getWidth()/100);
                }                        
            }                    
        }
        catch (Exception e) {            
        }        
    }
    
    public void ingresarPago(){
        IngresarPago obj = new IngresarPago(ventana);
        String agrega = obj.getAgrega();
        obj.dispose();  
        if(!agrega.isEmpty()){
            for(int i=0;i<tablaPagos.getRowCount();i++){
                if(tablaPagos.getValueAt(i,0) == null){
                    String palab[];
                    palab = agrega.split("-");
                    tablaPagos.setValueAt(palab[0],i,0);
                    tablaPagos.setValueAt(palab[1],i,1);
                    break;
                }
            }            
            calcularTotales();
            ingresarGarantia();
        }
    }
    
    public void eliminarPago(){
        int index = tablaPagos.getSelectedRow();
        if(index != -1 && tablaPagos.getValueAt(index,0)!=null){
            for(int i=index;i<tablaPagos.getRowCount()-1;i++){
                tablaPagos.setValueAt(tablaPagos.getValueAt(i+1, 0),i,0);
                tablaPagos.setValueAt(tablaPagos.getValueAt(i+1, 1),i,1);
            }
            tablaPagos.setValueAt(null, tablaPagos.getRowCount()-1,0);
            tablaPagos.setValueAt(null, tablaPagos.getRowCount()-1,1);
            calcularTotales();
        }
        else{
            JOptionPane.showMessageDialog(ventana, "Seleccione el pago a eliminar", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
    
    public void calcularTotales(){
        float total = 0;
        for(int i=0;i<tablaPagos.getRowCount();i++){
            if(tablaPagos.getValueAt(i,0) != null){
                total = total + Float.parseFloat(tablaPagos.getValueAt(i,1).toString());
            }
        }
        t_totalPagado.setText(String.valueOf(total));
        float precio = 0;
        try{
            precio = Float.parseFloat(t_totalPagar.getText());
        }
        catch(Exception e){
        }
        float resta = precio - total;
        t_resta.setText(String.valueOf(resta));
    }
    
    public void ingresarGarantia(){
        IngresarGarantia obj = new IngresarGarantia(ventana);
        String agrega = obj.getAgrega();
        obj.dispose();  
        if(!agrega.isEmpty()){
            for(int i=0;i<tablaGarantias.getRowCount();i++){
                if(tablaGarantias.getValueAt(i,0) == null){
                    String palab[];
                    palab = agrega.split("@");
                    tablaGarantias.setValueAt(palab[0],i,0);
                    tablaGarantias.setValueAt(palab[1],i,1);                    
                    break;
                }
            }
        }
        area.requestFocus();
    }
    
    public void eliminarGarantia(){
        int index = tablaGarantias.getSelectedRow();
        if(index != -1 && tablaGarantias.getValueAt(index,0)!=null){
            for(int i=index;i<tablaGarantias.getRowCount()-1;i++){
                tablaGarantias.setValueAt(tablaGarantias.getValueAt(i+1, 0),i,0);
                tablaGarantias.setValueAt(tablaGarantias.getValueAt(i+1, 1),i,1);
            }
            tablaGarantias.setValueAt(null, tablaGarantias.getRowCount()-1,0);
            tablaGarantias.setValueAt(null, tablaGarantias.getRowCount()-1,1);
        }
        else{
            JOptionPane.showMessageDialog(ventana, "Seleccione la garantía a eliminar", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
    
    public void cancelar(){
        ventana.setVisible(false);
        ventana.dispose();
    }
    
    public void procesar(){
        try{
            String fecEmision = l_fechaEmision.getText().replaceAll("Fecha de Emisión:", "").replaceAll(" ", "");
            String fecEntrega = t_fechaEntrega.getText();
            String fecDevolucion = t_fechaDevolucion.getText();
            String ced = t_ced.getText();
            String totPag = t_totalPagar.getText();
            String idCto = "";
            String edo = "PENDIENTE";
            
            Conexion con = new Conexion(dirIP);
            String query;
            if(con.conectar() == 1){
                query = "select nvl(max(ID)+1,1) from CONTRATOS";
                java.sql.ResultSet res = con.consultar(query);
                res.next();
                idCto = res.getString(1);
                
                query = "insert into CONTRATOS values('"+idCto+"', TO_DATE('"+fecEmision+"', 'DD/MM/YYYY'), TO_DATE('"+fecEntrega+"', 'DD/MM/YYYY'), TO_DATE('"+fecDevolucion+"', 'DD/MM/YYYY'),"+totPag+",'"+edo+"','"+ced+"','"+idSucursal+"')";
                if(con.actualizar(query) == 1){
                    l_idContrato.setText("Contrato Nº: "+idCto);
                    
                    for(int ii=0;ii<tablaPagos.getRowCount();ii++){
                        if(tablaPagos.getValueAt(ii,0) != null){
                            String tipPgo = tablaPagos.getValueAt(ii,0).toString();
                            String montPgo = tablaPagos.getValueAt(ii,1).toString();
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
                            
                            query = "select nvl(max(ID)+1,1) from PAGOS";
                            res = con.consultar(query);
                            res.next();
                            idpago = res.getString(1);
                               
                            query = "insert into PAGOS values('"+idpago+"','',"+montPgo+", TO_DATE('"+fecEmision+"', 'DD/MM/YYYY'), '"+idCto+"','"+tipPgo+"','"+motiv+"')";                                
                            con.actualizar(query);
                        }
                        else{
                            break;
                        }                            
                    }//Fin for insertar pagos
                    for(int ii=0;ii<tablaGarantias.getRowCount();ii++){
                        if(tablaGarantias.getValueAt(ii,0) != null){
                            String tipGta = tablaGarantias.getValueAt(ii,0).toString();
                            String desc = tablaGarantias.getValueAt(ii,1).toString();
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
                                
                            query = "select nvl(max(ID)+1,1) from PAGOS";
                            res = con.consultar(query);
                            res.next();
                            idgarant = res.getString(1);
                            
                            query = "insert into PAGOS values('"+idgarant+"','"+desc+"','',TO_DATE('"+fecEmision+"', 'DD/MM/YYYY'),'"+idCto+"','"+tipGta+"','"+motiv+"')";
                            con.actualizar(query);
                        }
                        else{
                            break;
                        }
                    }//Fin for insertar garantías
                    if(area.getText().length()>0){
                        String observac = area.getText();
                        String idObs = "";

                        query = "select nvl(max(ID)+1,1) from OBSERVACIONES";
                        res = con.consultar(query);
                        res.next();
                        idObs = res.getString(1);

                        query = "insert into OBSERVACIONES values('"+idObs+"','"+observac+"','"+idCto+"')";
                        con.actualizar(query);
                    }
                    
                    for(int ii=0; ii<tablaPedido.getRowCount(); ii++){
                        if(tablaPedido.getValueAt(ii,0) != null){
                            String codigos[] = new String[6];
                            String codigo = tablaPedido.getValueAt(ii,0).toString();
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
                            
                            query = "select ID from ACCESORIOS where "
                                                +"TARO_ID='"+codigos[0]+"' and FARO_ID='"+codigos[1]+"' and CARO_ID='"+codigos[2]+"' and MARO_ID='"+codigos[4]+"' and NUM_EJEMPLAR='"+codigos[5]+"' and TALLA='"+codigos[3]+"'";
                            res = con.consultar(query);                                
                            if(res.next()){
                                String idAccesorio = res.getString(1);
                                query = "select nvl(max(ID)+1,1) from ITEMS";/////Porblema solucionado
                                res = con.consultar(query);
                                res.next();
                                String idItem = res.getString(1);
                                query = "insert into ITEMS values('"+idItem+"', '1', '0', '"+idCto+"', '"+idAccesorio+"')";
                                con.actualizar(query);
                                }
                            }
                            else{
                                break;
                            }
                        }
                    
                    JOptionPane.showMessageDialog(ventana, "Contrato Procesado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    ventana.dispose();
                    EditarNuevoContrato ec = new EditarNuevoContrato(dirIP, Integer.parseInt(idCto));
                    con.desconectar();
                }
            }            
        }
        catch(Exception e){            
        }
    }
    
    public boolean validarCampos(){        
        if(t_nom.getText().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Falta los datos del Cliente", "Advertencia", JOptionPane.OK_OPTION);
            return false;
        }
        if(t_fechaEntrega.getText().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Falta la fecha de entrega", "Advertencia", JOptionPane.OK_OPTION);
            return false;
        }
        if(t_fechaDevolucion.getText().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Falta la fecha de devolución", "Advertencia", JOptionPane.OK_OPTION);
            return false;
        }
        if(tablaPedido.getValueAt(0,0) == null){
            JOptionPane.showMessageDialog(ventana, "No hay Accesorios Registrados", "Advertencia", JOptionPane.OK_OPTION);
            return false;
        }
        if(area.getText().length()>100){
            JOptionPane.showMessageDialog(ventana, "Máx 100 caracteres en Observaciones", "Advertencia", JOptionPane.OK_OPTION);
            return false;
        }
        try{
            float f = Float.parseFloat(t_totalPagar.getText());
            if(f == 0){
                JOptionPane.showMessageDialog(ventana, "Total a pagar es CERO", "Advertencia", JOptionPane.OK_OPTION);
                return false;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "El total a pagar debe ser un valor numérico", "Advertencia", JOptionPane.OK_OPTION);
            return false;
        }
        return true;
    }
}
