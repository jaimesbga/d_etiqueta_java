import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class Menu {
    private JFrame ventana;
    private JMenuBar menuBar;
    private JMenu m_contratos, m_clientes, m_accesorios, m_informes, m_reportes, m_mantener, m_ayuda, m_ventana, m_salir;
    private JMenuItem i_nuevoCto, i_buscarCto;
    private JMenuItem i_nuevoCte;
    private JMenuItem i_nuevoAro, i_buscarAro, i_moverAro, i_verDisponibilidad;
    private JMenuItem i_buscarPedidos, i_buscarEntregas, i_buscarMorosos;
    private JMenuItem i_totalDiario, i_totalMensual, i_graficaAnual, i_ejemplo1, i_ejemplo2;
    private JMenuItem i_nuevoCaract, i_agregarUbicacion, i_respaldarDatos, i_editarTerminos, i_editarDireccion, i_impTerminos;
    private JMenuItem i_acerca, i_manual, i_ayuda;
    private JMenuItem i_fondo, i_reloj1, i_reloj2, i_configurar;
    private JMenuItem i_salir;
    private JButton b_nuevoCto, b_nuevoCte, b_buscarCto, b_entregas, b_devoluciones, b_estadisticas, b_minimizar;
    private SystemTray tray;
    private final TrayIcon trayIcon;
    private javax.swing.JMenuItem menuItemRestore;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JPopupMenu popupContextual;
    private javax.swing.JSeparator separator, separadorConf;
    private JLabel fondo, reloj1, reloj2;
    private Timer reloj;
    private int difHora, difMin;
    private String dirIP;
    private String idSucursal;
    
    public Menu(String ip, String suc) {
        dirIP = ip;
        idSucursal = suc;
        
        ventana = new JFrame("D' Etiqueta - Menú");
        ventana.setSize(774,600);
        ventana.setLayout(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(ventana.DO_NOTHING_ON_CLOSE);        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setLocation((int)(d.getWidth()/2-ventana.getWidth()/2), (int)(d.getHeight()/2-ventana.getHeight()/2));
        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                if(JOptionPane.showConfirmDialog(ventana, "Seguro que desea Salir?", "Mensaje", JOptionPane.YES_NO_OPTION) == 0){
                    System.exit(0);
                }
            }
        });
        
        //-----------------MenuBar----------------------------
        menuBar = new JMenuBar();
        
        m_contratos = new JMenu("  Contratos  ");
        m_contratos.setMnemonic('C');        
        i_nuevoCto = new JMenuItem("Nuevo Contrato");
        i_nuevoCto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                //CrearContrato obj = new CrearContrato(dirIP, idSucursal);
                CrearNuevoContrato obj = new CrearNuevoContrato(dirIP, idSucursal);
            }
        });
        i_buscarCto = new JMenuItem("Buscar Contrato");
        i_buscarCto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                BuscarContrato obj = new BuscarContrato(ventana, dirIP);               
            }
        });
        m_contratos.add(i_nuevoCto);
        m_contratos.add(i_buscarCto);
        
        m_clientes = new JMenu("  Clientes  ");   
        m_clientes.setMnemonic('e');
        i_nuevoCte = new JMenuItem("Gestionar Clientes");
        i_nuevoCte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                AgregarCliente2 obj = new AgregarCliente2(dirIP, false, null);
            }
        });
        m_clientes.add(i_nuevoCte);
        
        m_accesorios = new JMenu(" Accesorios ");
        m_accesorios.setMnemonic('A');        
        i_nuevoAro = new JMenuItem("Agregar Accesorio");
        i_nuevoAro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                AgregarAccesorio obj = new AgregarAccesorio(dirIP);
            }
        });
        i_buscarAro = new JMenuItem("Buscar Accesorio");
        i_buscarAro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                Busca_Acces obj = new Busca_Acces(new JFrame(),dirIP);
            }
        });
        i_verDisponibilidad = new JMenuItem("Ver Disponibilidad");
        i_verDisponibilidad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                Disponi_fut obj = new Disponi_fut(ventana,dirIP);
            }
        });
        i_moverAro = new JMenuItem("Mover Accesorio");
        i_moverAro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                Change_Ubicacion a = new Change_Ubicacion(ventana,"127.0.0.1"); 
            }
        });
        m_accesorios.add(i_nuevoAro);
        m_accesorios.add(i_buscarAro);
        m_accesorios.add(i_verDisponibilidad);
        m_accesorios.add(i_moverAro);
        
        m_informes = new JMenu("  Informes  ");
        m_informes.setMnemonic('I');
        i_buscarPedidos = new JMenuItem("Buscar Entregas y Devoluciones");
        i_buscarPedidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
               BuscarPedidos obj = new BuscarPedidos(dirIP);
            }
        });
        i_buscarEntregas = new JMenuItem("Buscar Entregas - Semana en Curso");
        i_buscarEntregas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
               BuscarProximasEntregas obj = new BuscarProximasEntregas(dirIP);
            }
        });
        i_buscarMorosos = new JMenuItem("Ver Devoluciones Morosas");
        i_buscarMorosos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
               VerMorosos obj = new VerMorosos(dirIP);
            }
        });
        m_informes.add(i_buscarEntregas);
        m_informes.add(i_buscarPedidos);        
        m_informes.add(i_buscarMorosos);
        
        m_reportes = new JMenu("  Reportes  ");
        m_reportes.setMnemonic('R');
        i_totalDiario = new JMenuItem("Resumen Diario");
        i_totalDiario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                InformeDiario obj = new InformeDiario(dirIP);
            }
        });
        i_totalMensual = new JMenuItem("Resumen Mensual");
        i_totalMensual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                InformeMensual obj = new InformeMensual(dirIP);
            }
        });
        i_graficaAnual = new JMenuItem("Estadística Anual");
        i_graficaAnual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                GraficaAnual obj = new GraficaAnual(dirIP);
            }
        });
        i_ejemplo1 = new JMenuItem("Estadística de Trajes");
        i_ejemplo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                GraficaAccesorios obj = new GraficaAccesorios(dirIP);
            }
        });
        /*i_ejemplo2 = new JMenuItem("Ejemplo 3");
        i_ejemplo2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                TimeSeriesChartDemo1 demo = new TimeSeriesChartDemo1();
            }
        });*/
        m_reportes.add(i_totalDiario);
        m_reportes.add(i_totalMensual);
        m_reportes.add(i_graficaAnual);
        m_reportes.add(i_ejemplo1);
      //  m_reportes.add(i_ejemplo2);        
        
        m_mantener = new JMenu("Mantener Sistema");
        m_mantener.setMnemonic('M');
        i_nuevoCaract = new JMenuItem("Agregar Características");
        i_nuevoCaract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                Caracter obj = new Caracter(ventana, dirIP);
            }
        });
        i_agregarUbicacion = new JMenuItem("Agregar Ubicaciones");
        i_agregarUbicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                AgregarUbicacion obj = new AgregarUbicacion(dirIP);
            }
        });
        i_respaldarDatos = new JMenuItem("Respaldar Datos");
        i_respaldarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
               RespaldoDatos obj = new RespaldoDatos(dirIP);
            }
        });
        i_editarTerminos = new JMenuItem("Editar Términos y Condiciones");
        i_editarTerminos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                Edit_Term a = new Edit_Term(ventana);
            }
        });
        i_editarDireccion = new JMenuItem("Editar Dirección Principal");
        i_editarDireccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                Edit_Dirprin obj = new Edit_Dirprin(ventana);
            }
        });
        i_impTerminos = new JMenuItem("Imprimir Términos y Condiciones");
        i_impTerminos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
               Term_Cond x = new Term_Cond();
               PrintJob mip = ventana.getToolkit().getPrintJob(ventana,"Términos y Condiciones", null);            
               if(mip!=null){
                   Graphics imp = mip.getGraphics();
                   if(imp!=null){
                       x.PanelTerm().printAll(imp);                    
                       imp.dispose();
                   }
               }
               if(mip!=null){
                    mip.end();
               }
            }
        });
        m_mantener.add(i_nuevoCaract);
        m_mantener.add(i_agregarUbicacion);
        m_mantener.add(i_editarTerminos);
        m_mantener.add(i_impTerminos);
        m_mantener.add(i_editarDireccion);
        m_mantener.add(i_respaldarDatos);
        
        m_ayuda = new JMenu("  Ayuda  ");
        m_ayuda.setMnemonic('y');
        
        i_acerca = new JMenuItem("Acerca de");
        i_acerca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                AcercaDe obj = new AcercaDe(ventana);
                obj.setVisible(true);
                obj.dispose();
            }
        });
        //i_manual = new JMenuItem("Manual");
        i_ayuda = new JMenuItem("Manual");
        i_ayuda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                try{
                    URI n = null;
                    String  url = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
                    try {
                        File aux = new File(new URL(url).toURI());
                        n = aux.getParentFile().toURI();         
                    }
                    catch (Exception ex) {
                    }
                    url = n.toString();
                    int val = url.indexOf("build");
                    if(val>0){
                        url = url+"classes/Imagenes/Manual.pdf";                        
                    }
                    else{
                        url = url+"Files/Manual.pdf";
                    }
                    n = new URI(url);
                    File path = new File (n);
                    Desktop.getDesktop().open(path);
                }
                catch(Exception ex){
                    System.out.println("errrr");
                    ex.printStackTrace();
                }
            }
        });
        
        //m_ayuda.add(i_manual);
        m_ayuda.add(i_ayuda);
        m_ayuda.add(i_acerca);
        
        m_salir = new JMenu("   Salir   ");
        m_salir.setMnemonic('S');
        i_salir = new JMenuItem("  Salir  ");
        i_salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                if(JOptionPane.showConfirmDialog(ventana, "Seguro que desea Salir?", "Mensaje", JOptionPane.YES_NO_OPTION) == 0){
                    System.exit(0);
                }
            }
        });
        m_salir.add(i_salir);
        
        m_ventana = new JMenu("  Ventana  ");
        m_ventana.setMnemonic('V');
        i_fondo = new JMenuItem(" Fondo ");
        i_fondo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                if(i_fondo.getText().compareTo(" Fondo ")==0){
                    i_fondo.setText(" x Fondo ");
                    i_reloj1.setText(" Reloj1 ");
                    fondo.setVisible(true);
                    reloj1.setVisible(false);
                    reloj.stop();
                }
                else{
                    i_fondo.setText(" Fondo ");
                    fondo.setVisible(false);
                }
                guardarVentana();
            }
        });
        i_reloj1 = new JMenuItem(" Reloj1 ");
        i_reloj1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                if(i_reloj1.getText().compareTo(" Reloj1 ")==0){                    
                    i_fondo.setText(" Fondo ");
                    i_reloj1.setText(" x Reloj1 ");
                    i_reloj2.setText(" Reloj2 ");
                    fondo.setVisible(false);
                    reloj1.setVisible(true);
                    reloj2.setVisible(false);
                    cargarHora();
                    reloj.stop();
                    reloj.start();
                }
                else{
                    i_reloj1.setText(" Reloj1 ");   
                    reloj1.setVisible(false);
                    reloj.stop();
                }
                guardarVentana();
            }
        });
        i_reloj2 = new JMenuItem(" Reloj2 ");
        i_reloj2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                if(i_reloj2.getText().compareTo(" Reloj2 ")==0){
                    i_reloj1.setText(" Reloj1 ");
                    i_reloj2.setText(" x Reloj2 ");
                    reloj1.setVisible(false);
                    reloj2.setVisible(true);
                    cargarHora();
                    reloj.stop();
                    reloj.start();                    
                }
                else{
                    i_reloj2.setText(" Reloj2 ");
                    reloj2.setVisible(false);
                    reloj.stop();
                }
                guardarVentana();
            }
        });
        i_configurar = new JMenuItem("Configurar Hora");
        i_configurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                configurarHora();
            }
        });
        separadorConf = new JSeparator();
        m_ventana.add(i_fondo);
        m_ventana.add(i_reloj1);
        m_ventana.add(i_reloj2);
        m_ventana.add(separadorConf);
        m_ventana.add(i_configurar);
        
        fondo = new JLabel();
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/init2.png")));
        fondo.setSize(755, 355);
        fondo.setLocation(20, 130);
        fondo.setVisible(false);
        
        reloj1 = new JLabel();
        reloj1.setFont(new Font("Arial", Font.BOLD, 100));
        reloj1.setSize(600,300);
        reloj1.setLocation(180, 140);
        reloj1.setVisible(false);
        
        reloj2 = new JLabel();
        reloj2.setFont(new Font("Arial", Font.BOLD, 40));
        reloj2.setSize(200,200);
        reloj2.setLocation(50, 420);
        reloj2.setVisible(false);
        
        reloj = new Timer(2000 , new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                cargarHora();
           }
        });        
        
        menuBar.add(m_contratos);
        menuBar.add(m_clientes);
        menuBar.add(m_accesorios);
        menuBar.add(m_informes);
        menuBar.add(m_reportes);
        menuBar.add(m_mantener);
        menuBar.add(m_ayuda);
        menuBar.add(m_ventana);
        menuBar.add(m_salir);        
        //------------------Fin MenuBar-----------------------
        
        //------------------Botones--------------------------
        
        b_nuevoCto = new JButton(new ImageIcon(getClass().getResource("Imagenes/crear_contrato.png")));
        b_nuevoCto.setBounds(0,0,128,128);
        b_nuevoCto.setBackground(Color.WHITE);
        b_nuevoCto.setToolTipText("Crear Contrato");
        b_nuevoCto.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //CrearContrato obj = new CrearContrato(dirIP, idSucursal);
                    CrearNuevoContrato obj = new CrearNuevoContrato(dirIP, idSucursal);
                }
        });
        
        b_buscarCto = new JButton(new ImageIcon(getClass().getResource("Imagenes/buscar_contrato.png")));
        b_buscarCto.setBounds(128,0,128,128);
        b_buscarCto.setBackground(Color.WHITE);
        b_buscarCto.setToolTipText("Buscar Contrato");
        b_buscarCto.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    BuscarContrato obj = new BuscarContrato(ventana, dirIP);
                }
        });
        
        b_nuevoCte = new JButton(new ImageIcon(getClass().getResource("Imagenes/buscar_cliente.png")));
        b_nuevoCte.setBounds(256,0,128,128);
        b_nuevoCte.setBackground(Color.WHITE);
        b_nuevoCte.setToolTipText("Buscar Cliente");
        b_nuevoCte.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    AgregarCliente2 obj = new AgregarCliente2(dirIP, false, null);
                }
        });
        
        b_entregas = new JButton(new ImageIcon(getClass().getResource("Imagenes/entregas_devoluciones.png")));
        b_entregas.setBounds(384,0,128,128);
        b_entregas.setBackground(Color.WHITE);
        b_entregas.setToolTipText("Buscar Entregas y Devoluciones");
        b_entregas.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   BuscarPedidos obj = new BuscarPedidos(dirIP);
                }
        }); 
        
        b_estadisticas = new JButton(new ImageIcon(getClass().getResource("Imagenes/buscar_calendario.png")));
        b_estadisticas.setBounds(512,0,128,128);//640
        b_estadisticas.setBackground(Color.WHITE);
        b_estadisticas.setToolTipText("Ver Informe Diario");
        b_estadisticas.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InformeDiario obj = new InformeDiario(dirIP);
            }
        });
        
        b_devoluciones = new JButton(new ImageIcon(getClass().getResource("Imagenes/calc.png")));
        b_devoluciones.setBounds(640,0,128,128);
        b_devoluciones.setBackground(Color.WHITE);
        b_devoluciones.setToolTipText("Calculadora");
        b_devoluciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    calculator wx = new calculator(ventana);
            }
        });
        //------------------Fin Botones----------------------
        //-----------Minimizar a Bandeja Sistema-------------        
        Image image = new ImageIcon(getClass().getResource("Imagenes/Icono.png")).getImage();
        //ventana.setIconImage(image);
        trayIcon = new TrayIcon(image, "D' Etiqueta", null);
        trayIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupContextual.setLocation(e.getX(), e.getY());
                    popupContextual.setInvoker(popupContextual);
                    popupContextual.setVisible(true);
                }     
            }
        });
        trayIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    ventana.setVisible(true);                                               
                    ventana.toFront();
                    tray.remove(trayIcon);
                }
            }
        });
        
        popupContextual = new javax.swing.JPopupMenu();
        menuItemRestore = new javax.swing.JMenuItem();
        separator = new javax.swing.JSeparator();
        menuItemSalir = new javax.swing.JMenuItem();

        menuItemRestore.setText("Restaurar");
        menuItemRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventana.setVisible(true);                                               
                ventana.toFront();
                tray.remove(trayIcon);
            }
        });
        popupContextual.add(menuItemRestore);
        popupContextual.add(separator);

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        popupContextual.add(menuItemSalir);
        
        b_minimizar = new JButton(new ImageIcon(getClass().getResource("Imagenes/minimizar.png")));
        b_minimizar.setToolTipText("Minimizar a Bandeja de Sistema");
        b_minimizar.setSize(50,50);
        b_minimizar.setLocation(700,480);
        b_minimizar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                EstadoCambiado();
                trayIcon.displayMessage("D' Etiqueta", "El programa se está ejecutando...",TrayIcon.MessageType.INFO);
            }
        });
        //-------------------
        ventana.setJMenuBar(menuBar);
        ventana.add(b_nuevoCto);
        ventana.add(b_buscarCto);
        ventana.add(b_nuevoCte);
        ventana.add(b_entregas);        
        ventana.add(b_estadisticas);
        ventana.add(b_devoluciones);
        ventana.add(b_minimizar);
        
        
        ventana.add(fondo);
        ventana.add(reloj1);
        ventana.add(reloj2);
        
        cargarVentana();
        
        ventana.setVisible(true);
    }    
    
    public void cargarVentana(){
        int bfondo = 0;     //1 -> Fondo
                            //2 -> Reloj1
                            //3 -> Reloj2
                            //4 -> Fondo y Reloj2
        difHora = 0;
        difMin = 0;
        try{
            String url = null;
            url = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
            File aux = new File(new URL(url).toURI());
            URI n = aux.getParentFile().toURI();
            url = n.toString();
            int val = url.indexOf("build");
            if(val>=0){
                url = url+"classes/Imagenes/config.txt"; 
            }
            else{
                url = url+"Files/config.txt";
            }
            File f = null;
            f = new File(new URL(url).toURI());
            
            if(f.exists()){
                BufferedReader lee = new BufferedReader(new FileReader(f));
                while(lee.ready()){
                    String txt = lee.readLine();
                    if(txt.compareTo("fondo = 1")==0){
                        bfondo = 1;
                    }
                    if(txt.compareTo("reloj1 = 1")==0){
                        bfondo = 2;
                    }
                    if(txt.compareTo("reloj2 = 1")==0){
                        if(bfondo == 1){
                            bfondo = 4;
                        }
                        else{
                            bfondo = 3;
                        }
                    }
                    if(txt.indexOf("hora")>=0){
                        String cad = txt.replaceAll("hora ", "");
                        String sig = cad.substring(0, 1);
                        cad = cad.substring(1, cad.length());
                        int dif = Integer.parseInt(cad);
                        if(sig.compareTo("-")==0){
                            dif = dif*(-1);
                        }
                        difHora = dif;
                    }
                    if(txt.indexOf("minutos")>=0){
                        String cad = txt.replaceAll("minutos ", "");
                        String sig = cad.substring(0, 1);
                        cad = cad.substring(1, cad.length());
                        int dif = Integer.parseInt(cad);
                        if(sig.compareTo("-")==0){
                            dif = dif*(-1);
                        }
                        difMin = dif;
                    }
                }
            }   
            else{
                guardarVentana();
            }
        }
        catch(Exception e){ }
        
        if(bfondo == 1 || bfondo == 4){
            i_fondo.setText(" x Fondo ");
            fondo.setVisible(true);
        }
        if(bfondo == 2){
            i_reloj1.setText(" x Reloj1 ");
            reloj1.setVisible(true);
            cargarHora();
            reloj.start();
        }
        if(bfondo == 3 || bfondo == 4){
            i_reloj2.setText(" x Reloj2 ");
            reloj2.setVisible(true);
            cargarHora();
            reloj.start();
        }
    }
    
    public void setDiferenciaHora(int dif1, int dif2){
        difHora = dif1;
        difMin = dif2;
    }
    
    public JFrame getVentana(){
        return ventana;
    }
    
    public void guardarVentana(){
        try{
            String url = null;
            url = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
            File aux = new File(new URL(url).toURI());
            URI n = aux.getParentFile().toURI();
            url = n.toString();
            int val = url.indexOf("build");
            if(val>=0){
                url = url+"classes/Imagenes/config.txt"; 
            }
            else{
                url = url+"Files/config.txt";
            }
            File f = null;
            f = new File(new URL(url).toURI());
            
            BufferedWriter escribir = new BufferedWriter(new FileWriter(f));
            if(i_fondo.getText().compareTo(" Fondo ")==0){
                escribir.write("fondo = 0");
            }
            else{
                escribir.write("fondo = 1");
            }
            escribir.newLine();
            
            if(i_reloj1.getText().compareTo(" Reloj1 ")==0){
                escribir.write("reloj1 = 0");
            }
            else{
                escribir.write("reloj1 = 1");
            }
            escribir.newLine();
            
            if(i_reloj2.getText().compareTo(" Reloj2 ")==0){
                escribir.write("reloj2 = 0");
            }
            else{
                escribir.write("reloj2 = 1");
            }
            
            escribir.newLine();
            String dif1 = String.valueOf(difHora);
            if(dif1.indexOf("-") == -1){
                dif1 = "+" + dif1;
            }
            escribir.write("hora " + dif1);
            
            escribir.newLine();
            String dif2 = String.valueOf(difMin);
            if(dif2.indexOf("-") == -1){
                dif2 = "+" + dif2;
            }
            escribir.write("minutos " + dif2);
            
            escribir.close();
        }
        catch(Exception e){  }
    }
    
    public void cargarHora(){
        String turno = "am";
        int hora = Calendar.getInstance().get(Calendar.getInstance().HOUR_OF_DAY)+difHora;
        int min = Calendar.getInstance().get(Calendar.getInstance().MINUTE)+difMin;
        //int sec = Calendar.getInstance().get(Calendar.getInstance().SECOND);
        
        if(hora > 12 && hora != 24){
            hora = hora - 12;
            turno = "pm";
        }
        if(hora == 24){
            hora = 12;
            turno = "am";
        }
        
        if(min >= 60){
            min = min - 60;
        }
        
        if(hora < 0){
            hora = hora * (-1);
        }
        if(min < 0){
            min = min * (-1);
        }
        
        String h, m, s;
        
        if(hora<10){
            h = "0"+hora;
        }
        else{
            h = String.valueOf(hora);
        }
        
        if(min<10){
            m = "0"+min;
        }
        else{
           m = String.valueOf(min);
        }  
        
        /*if(sec<10){
            s = "0"+sec;
        }
        else{
           s = String.valueOf(sec);
        } */     
        
        if(reloj1.isVisible()){            
            //reloj1.setText(h+":"+m+":"+s+" "+turno);
            reloj1.setText(h+":"+m+" "+turno);
        }
        if(reloj2.isVisible()){
            reloj2.setText(h+":"+m+" "+turno);
        }
    }
    
    public void configurarHora(){
        ConfigurarHora obj = new ConfigurarHora(this);
        obj.setVisible(true);
        obj.dispose();
    }
    
     private void EstadoCambiado() { 
       ventana.setState(ventana.NORMAL);  
       if (SystemTray.isSupported()) {  
            ventana.setVisible(false);
            tray = SystemTray.getSystemTray();
            trayIcon.setImageAutoSize(true);
            
             try {
                tray.add(trayIcon);
             }
             catch (Exception e) {                
                ventana.setVisible(true);
             }  
       }
    }
}
