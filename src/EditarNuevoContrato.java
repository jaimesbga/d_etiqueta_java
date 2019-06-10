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

public class EditarNuevoContrato {
    private JFrame ventana;
    private JPanel panelVentana, panelCliente, panelEntrega, panelPedido, panelPagos, panelGarantias, panelObservaciones, panelEstado;
    private JScrollPane scrollVentana, scrollPedido, scrollPagos, scrollGarantias, scrollObservaciones;
    private JLabel l_fondo, l_idContrato, l_fechaEmision;
    private JButton b_procesar, b_cancelar, b_imprimir;;
    private JTextField t_ced, t_nom, t_dir, t_tlf1, t_tlf2, t_correo, t_rif;
    private JLabel l_ced, l_nom, l_dir, l_tlf1, l_tlf2, l_correo, l_rif;
    private JLabel l_fechaEntrega, l_fechaDevolucion, l_cantidadProductos, l_totalPagar, l_totalPagado, l_resta, l_caracteres;
    private JTextField t_fechaEntrega, t_fechaDevolucion, t_totalPagar, t_totalPagado, t_resta;
    private JTable tablaPedido, tablaPagos, tablaGarantias;
    private DefaultTableModel_M modeloPedido, modeloPagos, modeloGarantias;
    private JButton b_agregarProducto, b_agregarPago, b_eliminarPago, b_agregarGarantia, b_eliminarGarantia;
    private JTextArea area;
    private JComboBox c_estado;
    
    private int c1, c2;
    private boolean modifica;
    
    private String estadoContrato;    
    private String dirIP;
    private int idContrato;
    
    public EditarNuevoContrato(String ip, int contrato) {
        dirIP = ip;
        idContrato = contrato;
        modifica = false;
        
        inicializar();
        cargarVentana();
        
        ventana.setVisible(true);
    }
    
    public void inicializar(){
        ventana = new JFrame("D' Etiqueta - Editar Contrato");        
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
        
        panelCliente = new JPanel();
        panelCliente.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
        panelCliente.setLayout(null);
        panelCliente.setBounds(10, 100, 570, 150);
        
        l_ced = new JLabel("Cédula:");
        l_ced.setBounds(25, 15, 100, 30);        
        t_ced = new JTextField();
        t_ced.setBounds(90, 20, 180, 20);
        t_ced.setEditable(false);        
        
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
        
        panelCliente.add(l_ced);
        panelCliente.add(t_ced);
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
                if(t_fechaEntrega.isEditable()){
                    ingresarFecha(t_fechaEntrega);
                }
            }
        });
        
        l_fechaDevolucion = new JLabel("Fecha de Devolución: ");
        l_fechaDevolucion.setBounds(285, 20, 150, 30);        
        t_fechaDevolucion = new JTextField();
        t_fechaDevolucion.setBounds(420, 25, 130, 20);
        t_fechaDevolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(t_fechaDevolucion.isEditable()){
                    ingresarFecha(t_fechaDevolucion);
                }
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
                {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null},
                {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}
            }, new String [] {"Tipo de Pago", "Monto", "Fecha"});        
        tablaPagos = new JTable();
        tablaPagos.setModel(modeloPagos);
        tablaPagos.setSize(240, 140);
        tablaPagos.getTableHeader().setReorderingAllowed(false);
        tablaPagos.getColumnModel().getColumn(0).setPreferredWidth( (int)(35*tablaPagos.getWidth()/100));
        tablaPagos.getColumnModel().getColumn(1).setPreferredWidth(35*tablaPagos.getWidth()/100);
        tablaPagos.getColumnModel().getColumn(2).setPreferredWidth(30*tablaPagos.getWidth()/100);
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
        
        panelEstado = new JPanel();
        panelEstado.setBorder(BorderFactory.createTitledBorder("Estado del Contrato"));
        panelEstado.setLayout(null);
        panelEstado.setBounds(280, 710, 300, 80);
        
        c_estado = new JComboBox();
        c_estado.setFont(new Font("Arial", Font.BOLD, 16));
        c_estado.setBounds(80, 25, 150, 30);
        c_estado.setModel(new DefaultComboBoxModel(new String[] { "ACTIVO", "CANCELADO", "PENDIENTE", "FINALIZADO" }));
        
        panelEstado.add(c_estado);
        
        b_procesar = new JButton();
        b_procesar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/guardar.png")));
        b_procesar.setToolTipText("Procesar");
        b_procesar.setOpaque(false);
        b_procesar.setBackground(Color.CYAN);
        b_procesar.setBounds(280, 800, 100, 100);
        b_procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //if(validarCampos() && JOptionPane.showConfirmDialog(ventana, "Seguro que desea procesar el contrato?", "Mensaje", JOptionPane.YES_NO_OPTION) == 0){
                    procesar();
                //}
            }
        });
        
        b_cancelar = new JButton();
        b_cancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/cancelar.png")));
        b_cancelar.setToolTipText("Cancelar");
        b_cancelar.setOpaque(false);
        b_cancelar.setBackground(Color.CYAN);
        b_cancelar.setBounds(480, 800, 100, 100);
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar();
            }
        });
        
        b_imprimir = new JButton();
        b_imprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/imprimir.png")));
        b_imprimir.setToolTipText("Imprimir");
        b_imprimir.setOpaque(false);
        b_imprimir.setBackground(Color.CYAN);
        b_imprimir.setBounds(380, 800, 100, 100);
        b_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimir();
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
        panelVentana.add(panelEstado);
        panelVentana.add(b_procesar);
        panelVentana.add(b_cancelar);
        panelVentana.add(b_imprimir);
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
                    modifica = true;
                    tablaPedido.getColumnModel().getColumn(0).setPreferredWidth( (int)(20*tablaPedido.getWidth()/100));
                    tablaPedido.getColumnModel().getColumn(1).setPreferredWidth(80*tablaPedido.getWidth()/100);    
                }                        
            }                    
        }
        catch (Exception e) {            
        }        
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
    
    public void ingresarPago(){        
        IngresarPago obj = new IngresarPago(ventana);
        String agrega = obj.getAgrega();
        obj.dispose();        
        if(!agrega.isEmpty()){
            for(int i=0; i<tablaPagos.getRowCount(); i++){
                if(tablaPagos.getValueAt(i,0) == null){                    
                    String dia = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                    String mes = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);                    
                    if(Integer.parseInt(mes)<10){
                        mes = "0"+mes;
                    }
                    String anho = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).substring(2,4);
                    String fecha = dia+"/"+mes+"/"+anho;
                    
                    String palab[];
                    palab = agrega.split("-");
                    tablaPagos.setValueAt(palab[0],i,0);
                    tablaPagos.setValueAt(palab[1],i,1);
                    tablaPagos.setValueAt(fecha,i,2);
                    break;
                }
            }            
            calcularTotales();
        }
    }
    
    public void eliminarPago(){
        int index = tablaPagos.getSelectedRow();
        if(index != -1 && tablaPagos.getValueAt(index,0)!=null){
            if(index+1 > c1){
                for(int i=index; i<tablaPagos.getRowCount()-1;i++){
                    tablaPagos.setValueAt(tablaPagos.getValueAt(i+1, 0),i,0);
                    tablaPagos.setValueAt(tablaPagos.getValueAt(i+1, 1),i,1);
                    tablaPagos.setValueAt(tablaPagos.getValueAt(i+1, 1),i,2);
                }
                tablaPagos.setValueAt(null, tablaPagos.getRowCount()-1,0);
                tablaPagos.setValueAt(null, tablaPagos.getRowCount()-1,1);
                tablaPagos.setValueAt(null, tablaPagos.getRowCount()-1,2);
                calcularTotales();
            }
            else{
                JOptionPane.showMessageDialog(ventana, "No se pueden eliminar pagos anteriores", "Advertencia", JOptionPane.OK_OPTION);
            }
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
    }
    
    public void eliminarGarantia(){
        int index = tablaGarantias.getSelectedRow();
        if(index != -1 && tablaGarantias.getValueAt(index,0)!=null){
            if(index+1 > c2){
                for(int i=index; i<tablaGarantias.getRowCount()-1;i++){
                    tablaGarantias.setValueAt(tablaGarantias.getValueAt(i+1, 0),i,0);
                    tablaGarantias.setValueAt(tablaGarantias.getValueAt(i+1, 1),i,1);
                }
                tablaGarantias.setValueAt(null,tablaGarantias.getRowCount()-1,0);
                tablaGarantias.setValueAt(null,tablaGarantias.getRowCount()-1,1);
            }
            else{
                JOptionPane.showMessageDialog(ventana,"No se pueden eliminar garantías anteriores", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
        else{
            JOptionPane.showMessageDialog(ventana,"Seleccione la garantía a eliminar", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
    
    public void cancelar(){
        ventana.setVisible(false);
        ventana.dispose();
    }
    
    public void procesar(){        
        if(c_estado.isEnabled()){
            String dia = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
            String mes = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
            if(Integer.parseInt(mes)<10){
                mes = "0"+mes;
            }
            String anho = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
            String fecha = dia+"/"+mes+"/"+anho;
            
            Conexion con = new Conexion(dirIP);
            String query;
            try{
                con.conectar();
                for(int ii=c1; ii<tablaPagos.getRowCount(); ii++){
                    if(tablaPagos.getValueAt(ii,1) != null){
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

                        java.sql.ResultSet res = con.consultar("select nvl(max(ID)+1,1) from PAGOS");
                        res.next();
                        String mon = String.valueOf(montPgo);
                        mon = mon.replaceAll("\\.", ",");
                        idpago = res.getString(1);
                        query = "insert into PAGOS values('"+idpago+"','','"+mon+"', TO_DATE('"+fecha+"', 'DD/MM/YYYY'),'"+idContrato+"','"+tipPgo+"','"+motiv+"')";
                        con.actualizar(query);
                    }
                    else{
                        break;
                    }
                }//fin de insertar pagos
                
                for(int ii=c2;ii<tablaGarantias.getRowCount();ii++){
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
                                
                        java.sql.ResultSet res = con.consultar("select nvl(max(ID)+1,1) from PAGOS");
                        res.next();
                        idgarant = res.getString(1);
                                
                        con.actualizar("insert into PAGOS values('"+idgarant+"','"+desc+"','', TO_DATE('"+fecha+"'. 'DD/MM/YYYY'),'"+idContrato+"','"+tipGta+"','"+motiv+"')");
                    }
                    else{
                        break;
                    }
                }//fin insertar garantias
                
                if(modifica){
                    String ids[] = new String[10];
                    int ci = 0, ca = 0;;
                    query = "select ID from ITEMS where CTO_ID='"+idContrato+"' order by ID";
                    java.sql.ResultSet res = con.consultar(query);
                    while(res.next()){
                        ids[ci] = res.getString(1);
                        ci++;
                    }
                    query = "delete from ITEMS where CTO_ID='"+idContrato+"'";
                    con.actualizar(query);
                    for(int ii=0;ii<tablaPedido.getRowCount();ii++){
                        if(tablaPedido.getValueAt(ii,0) != null){
                            String codigos[] = new String[6];
                            String codigo = tablaPedido.getValueAt(ii,0).toString();
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
                            
                            String idAccesorio, idItem;
                            if(res.next()){
                                idAccesorio = res.getString(1);
                                if(ii<ci){
                                    idItem = ids[ii];
                                }
                                else{
                                    query = "select nvl(max(ID)+1, 1) from ITEMS";
                                    res = con.consultar(query);
                                    res.next();
                                    idItem = res.getString(1);
                                }
                                    
                                query = "insert into ITEMS values('"+idItem+"', '1', '0', '"+idContrato+"', '"+idAccesorio+"')";
                                //query = "insert into ITEMS values('"+idItem+"', '1', '0', '"+idContrato+"', '"+idAccesorio+"')";
                                con.actualizar(query);
                            }
                        }
                        else{
                            break;
                        }
                    }
                }//fin insertar productos
                
                if(area.getText().length()>0){
                    query = "select count(id) from OBSERVACIONES where CTO_ID = '"+idContrato+"'";
                    java.sql.ResultSet res = con.consultar(query);
                    res.next();
                    if(res.getString(1).compareTo("0") == 0){
                        String observac = area.getText();
                        String idObs = "";

                        res = con.consultar("select nvl(max(ID)+1,1) from OBSERVACIONES");
                        res.next();
                        idObs = res.getString(1);

                        con.actualizar("insert into OBSERVACIONES values('"+idObs+"','"+observac+"','"+idContrato+"')");
                        //System.out.println("OBN insert into OBSERVACIONES values('"+idObs+"','"+observac+"','"+idContrato+"')");
                    }
                    else{
                        con.consultar("update OBSERVACIONES set DESCRIPCION = '"+area.getText()+"' where CTO_ID='"+idContrato+"'");
                        //System.out.println("OBN update OBSERVACIONES set DESCRIPCION = '"+jTextArea1.getText()+"' where CTO_ID='"+idContrato+"'");
                    }
                }//fin actualizar observaciones
                String totPag = t_totalPagar.getText();
                if(totPag.isEmpty()){
                    totPag = "0";
                }
                totPag = totPag.replaceAll("\\.", ",");
                con.actualizar("update CONTRATOS set FECHA_ENTREGA = '"+t_fechaEntrega.getText()+"', FECHA_DEVOLUCION = '"+t_fechaDevolucion.getText()+"', TOTAL_PAGAR = '"+totPag+"' where ID = '"+idContrato+"'");
                                        
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
                
                JOptionPane.showMessageDialog(ventana, "Contrato Actualizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                
                con.desconectar();
                cargarVentana();
            }
            catch(Exception e){
                System.out.println("error");
                e.printStackTrace();
            }
        }
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
                l_idContrato.setText("Contrato Nº: "+id_cto);
                
                t_ced.setText(res.getString(1));
                t_nom.setText(res.getString(2));
                t_dir.setText(res.getString(3));
                t_tlf1.setText(res.getString(4));
                t_tlf2.setText(res.getString(5));
                t_correo.setText(res.getString(6));
                t_rif.setText(res.getString(7));
                
                res = con.consultar("select to_char(FECHA_EMISION,'DD/MM/YYYY'), to_char(FECHA_ENTREGA,'DD/MM/YYYY'), to_char(FECHA_DEVOLUCION,'DD/MM/YYYY'), TOTAL_PAGAR, ESTADO from CONTRATOS where ID = '"+idContrato+"'");
                res.next();
                
                l_fechaEmision.setText("Fecha Emisión: "+res.getString(1));
                l_fechaEmision.setText(l_fechaEmision.getText().replaceAll("/", " / "));
                t_fechaEntrega.setText(res.getString(2));
                t_fechaDevolucion.setText(res.getString(3));
                t_totalPagar.setText(res.getString(4));
                estado = res.getString(5);
                c_estado.setSelectedItem(estado);
                ventana.setTitle("D' Etiqueta - Contrato Nº "+id_cto+" - "+estado);
                                
                if(estado.compareToIgnoreCase("Finalizado") == 0 || estado.compareToIgnoreCase("Cancelado") == 0){
                    t_fechaEntrega.setEditable(false);
                    t_fechaDevolucion.setEditable(false);
                    b_agregarPago.setEnabled(false);
                    b_eliminarPago.setEnabled(false);
                    b_agregarGarantia.setEnabled(false);
                    b_eliminarGarantia.setEnabled(false);
                    b_agregarProducto.setEnabled(false);
                    b_procesar.setEnabled(false);                    
                    t_totalPagar.setEditable(false);
                    c_estado.setEnabled(false);                    
                    area.setEditable(false);                   
                }
                if(estado.compareToIgnoreCase("Finalizado") == 0){
                    b_agregarPago.setEnabled(true);
                    b_eliminarPago.setEnabled(true);
                }
                
                estadoContrato = estado;
                
                res = con.consultar("select DESCRIPCION from OBSERVACIONES where CTO_ID = '"+idContrato+"'");
                if(res.next()){
                    area.setText(res.getString(1));
                }
                l_caracteres.setText("Caracteres: "+area.getText().length()+" / 100");
                
                res = con.consultar("select TPGO_ID, MONTO, to_char(FECHA,'DD/MM/YY') from PAGOS where CTO_ID = '"+idContrato+"' and MVO_ID = '01' order by ID");
                c1 = 0;               
                while (res.next() && c1<tablaPagos.getRowCount()){
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
                    
                    tablaPagos.setValueAt(tipo, c1, 0);
                    tablaPagos.setValueAt(monto, c1, 1);
                    tablaPagos.setValueAt(fecha, c1, 2);
                    c1++;
                }
                res = con.consultar("select TPGO_ID, OBSERVACION from PAGOS where CTO_ID = '"+idContrato+"' and MVO_ID = '02' order by ID");
                c2 = 0 ;
                while (res.next() && c2<tablaGarantias.getRowCount()){
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
                    
                    tablaGarantias.setValueAt(tipo, c2, 0);
                    tablaGarantias.setValueAt(observacion, c2, 1);
                    
                    c2++;
                }
                
                //res = con.consultar("select i.CANTIDAD, i.PRECIO, i.CANTIDAD*i.PRECIO, a.TARO_ID, a.FARO_ID, a.CARO_ID, A.TALLA from ITEMS i, ACCESORIOS a where i.ARO_ID = a.ID and i.CTO_ID = '"+idContrato+"' order by i.ID");                
                res = con.consultar("select i.CANTIDAD, i.PRECIO, a.TARO_ID, a.FARO_ID, a.CARO_ID, a.TALLA, "
                                    +"ta.DESCRIPCION, fa.DESCRIPCION, ca.COLOR1, ca.COLOR2, ca.COLOR3, ma.DESCRIPCION, a.MARO_ID, a.NUM_EJEMPLAR "
                                    +"from ITEMS i, ACCESORIOS a, TIPO_ACCESORIOS ta, FORMA_ACCESORIOS fa, COLOR_ACCESORIOS ca, MARCA_ACCESORIOS ma "
                                    +"where i.ARO_ID = a.ID AND a.TARO_ID = ta.ID and a.FARO_ID = fa.ID and a.CARO_ID = ca.id and a.MARO_ID = ma.ID and i.CTO_ID = '"+idContrato+"' order by i.ID");
                int c3 = 0 ;                
                while (res.next() && c3<tablaPedido.getRowCount()){
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
                                        
                    tablaPedido.setValueAt(cod, c3, 0);
                    tablaPedido.setValueAt(desc, c3, 1);
                    
                    c3++;
                }
                calcularTotales();                
                l_cantidadProductos.setText("Cantidad: "+c3);
                con.desconectar();
            }
            else{
                JOptionPane.showMessageDialog(ventana, "No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
            }
        }
        catch(Exception e){e.printStackTrace();}    
        tablaPedido.getColumnModel().getColumn(0).setPreferredWidth( (int)(20*tablaPedido.getWidth()/100));
        tablaPedido.getColumnModel().getColumn(1).setPreferredWidth(80*tablaPedido.getWidth()/100);
    }
    
    public void imprimir(){
        //Factura obj = new Factura(ventana, String.valueOf(idContrato), dirIP);
        Impresion obj = new Impresion(dirIP, String.valueOf(idContrato));
    }
}
