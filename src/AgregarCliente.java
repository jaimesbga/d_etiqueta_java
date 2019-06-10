import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AgregarCliente {
    private JFrame ventana;
    private JPanel panel;
    private JLabel l_cedula, l_nombre, l_direccion, l_tlf1, l_tlf2, l_correo, l_rif, l_bcedula;
    private JTextField t_cedula, t_nombre, t_direccion, t_tlf1, t_tlf2, t_correo, t_rif, t_buscar;
    private JButton b_ok, b_cancelar, b_buscar, b_nuevo;
    private JLabel imagen;
    
    private String dirIP;
    private boolean soloAgregar;
    private JTextField retCedula;
    
    public AgregarCliente(String ip, boolean band, JTextField cedVentana) {
        dirIP = ip;
        soloAgregar = band;
        retCedula = cedVentana;
        
        iniciarComponentes();
        setVisible(soloAgregar);        
        
        ventana.setVisible(true);
    }
    
    public AgregarCliente(String ip, String cedu, JTextField cedVentana) {
        dirIP = ip;
        soloAgregar = true;
        retCedula = cedVentana;
        
        iniciarComponentes();
        setVisible(soloAgregar);
        
        buscar(cedu);
        
        ventana.setVisible(true);
    }
    
    
    
    public void iniciarComponentes(){
        ventana = new JFrame("D' Etiqueta - Clientes");
        ventana.setSize(530,580);
        ventana.setResizable(false);
        ventana.setLayout(null);
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setLocation((int)(d.getWidth()/2-265), (int)(d.getHeight()/2-290));
        
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        imagen = new JLabel();
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Contrato.gif")));
        imagen.setBounds(10,20,537,49);
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Cliente", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        panel.setBounds(20,140,485,350);
        panel.setLayout(null);
        
        Font font = new Font("Arial",Font.BOLD,14);
        
        l_cedula = new JLabel("* Cedula:");
        l_cedula.setBounds(52,40,120,20);
        l_cedula.setFont(font);
        
        t_cedula = new JTextField();
        t_cedula.setBounds(140,40,150,20);
        
        l_nombre = new JLabel("* Nombres:");
        l_nombre.setBounds(38,85,120,20);
        l_nombre.setFont(font);
        
        t_nombre = new JTextField();
        t_nombre.setBounds(140,85,310,20);
        
        l_direccion = new JLabel("* Direccion:");
        l_direccion.setBounds(36,130,120,20);
        l_direccion.setFont(font);
        
        t_direccion = new JTextField();
        t_direccion.setBounds(140,130,310,20);
        
        l_tlf1 = new JLabel("* Telefono 1:");
        l_tlf1.setBounds(30,175,120,20);
        l_tlf1.setFont(font);
        
        t_tlf1 = new JTextField();
        t_tlf1.setBounds(140,175,150,20);
        
        l_tlf2 = new JLabel("  Telefono 2:");
        l_tlf2.setBounds(30,220,120,20);  
        l_tlf2.setFont(font);
        
        t_tlf2 = new JTextField();
        t_tlf2.setBounds(140,220,150,20);
        
        l_correo= new JLabel("  Correo:");
        l_correo.setBounds(52,265,120,20);
        l_correo.setFont(font);
        
        t_correo = new JTextField();
        t_correo.setBounds(140,265,310,20);
        
        l_rif= new JLabel("  RIF:");
        l_rif.setBounds(77,310,120,20);
        l_rif.setFont(font);
        
        t_rif = new JTextField();
        t_rif.setBounds(140,310,150,20);
        
        b_ok = new JButton();
        b_ok.setText("Guardar");
        b_ok.setBounds(125,507,90,25);
        b_ok.setMnemonic('G');
        b_ok.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(t_cedula.getText().isEmpty() || t_nombre.getText().isEmpty() || t_direccion.getText().isEmpty() || (t_tlf1.getText().isEmpty() && t_tlf2.getText().isEmpty())){
                        JOptionPane.showMessageDialog(ventana,"Debe llenar toda la información", "Advertencia", JOptionPane.OK_OPTION);
                    }
                    else{
                        if(t_tlf1.getText().isEmpty() && !t_tlf2.getText().isEmpty()){
                            t_tlf1.setText(t_tlf2.getText());
                            t_tlf2.setText("");
                        }
                        String ced = t_cedula.getText();
                        String nom = t_nombre.getText();
                        String dir = t_direccion.getText();
                        String tlf1 = t_tlf1.getText();
                        String tlf2 = t_tlf2.getText();
                        String cor = t_correo.getText();
                        String rif = t_rif.getText();
                        
                        if(t_cedula.isEditable()){
                            try{
                                Conexion con = new Conexion(dirIP);
                                if(con.conectar() == 1){
                                    ResultSet res = con.consultar("select count(*) from CLIENTES where CEDULA='"+ced+"'");
                                    res.next();
                                    if(res.getString(1).compareTo("0") == 0){
                                        if(con.actualizar("insert into CLIENTES values('"+ced+"','"+nom+"','"+dir+"','"+tlf1+"','"+tlf2+"','"+cor+"','"+rif+"')") == 1){                                            
                                            if(soloAgregar){
                                                //JOptionPane.showMessageDialog(ventana,"Registro Exitoso", "Mensaje", JOptionPane.OK_OPTION);
                                                JOptionPane.showMessageDialog(ventana,"Registro Exitoso","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                                                limpiarCampos();
                                                t_buscar.setText("");
                                                setVisible(false);
                                                retCedula.setText(ced);
                                                ventana.setVisible(false);
                                                ventana.dispose();
                                            }
                                            else{
                                                int resp = JOptionPane.showConfirmDialog(ventana,"Registro Exitoso. Desea agregar otro Cliente?","Mensaje",JOptionPane.YES_NO_OPTION);            
                                                if(resp == 0){
                                                    limpiarCampos();
                                                    t_buscar.setText("");
                                                    setVisible(false);                                                    
                                                }
                                                else{
                                                    limpiarCampos();
                                                    t_buscar.setText("");
                                                    setVisible(false);
                                                    ventana.setVisible(false);
                                                    ventana.dispose();
                                                }
                                            }
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(ventana,"No se puedo registrar el Cliente", "Advertencia", JOptionPane.OK_OPTION);
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(ventana,"Ya existe la Cédula", "Advertencia", JOptionPane.OK_OPTION);
                                    }
                                    con.desconectar();
                                }                                
                                else{
                                    JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
                                }
                            }
                            catch(Exception er){ }
                        }
                        else{
                            try{
                                Conexion con = new Conexion(dirIP);
                                if(con.conectar() == 1){
                                    if(con.actualizar("update CLIENTES set NOMBRE='"+nom+"', DIRECCION='"+dir+"', TELEFONO1='"+tlf1+"', TELEFONO2='"+tlf2+"', CORREO='"+cor+"', RIF='"+rif+"' where CEDULA='"+ced+"'")==1){
                                        if(soloAgregar){
                                            JOptionPane.showMessageDialog(ventana,"Actualización Exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                            ventana.setVisible(false);
                                        }
                                        else{
                                            int resp = JOptionPane.showConfirmDialog(ventana,"Actualización Exitosa. Desea buscar otro Cliente?","Mensaje",JOptionPane.YES_NO_OPTION);            
                                            if(resp == 0){
                                                limpiarCampos();
                                                t_buscar.setText("");
                                                setVisible(false);
                                            }
                                            else{
                                                limpiarCampos();
                                                t_buscar.setText("");
                                                setVisible(false);
                                                ventana.setVisible(false);
                                                ventana.dispose();
                                            }
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(ventana,"Error al Actualizar", "Advertencia", JOptionPane.OK_OPTION);
                                    }
                                    con.desconectar();
                                }
                                else{
                                    JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
                                }
                            }
                            catch(Exception er){ }
                        }
                    }
                }
        });
        
        b_cancelar = new JButton();
        b_cancelar.setText("Cancelar");
        b_cancelar.setBounds(315,507,90,25);        
        b_cancelar.setMnemonic('C');
        b_cancelar.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    limpiarCampos();
                    setVisible(false);
                    ventana.setVisible(false);
                    ventana.dispose();                    
                }
        });
        
        panel.add(l_cedula);
        panel.add(t_cedula);
        panel.add(l_nombre);
        panel.add(t_nombre);
        panel.add(l_direccion);
        panel.add(t_direccion);
        panel.add(l_tlf1);
        panel.add(t_tlf1);
        panel.add(l_tlf2);
        panel.add(t_tlf2);
        panel.add(l_correo);
        panel.add(t_correo);
        panel.add(l_rif);
        panel.add(t_rif);
        
        l_bcedula = new JLabel("Cliente a Buscar:");
        l_bcedula.setBounds(30,103,120,20);
        l_bcedula.setFont(font);
        
        t_buscar = new JTextField();
        t_buscar.setBounds(160,103,150,20);
        
        b_buscar = new JButton("Buscar");
        b_buscar.setBounds(315,100,90,25);
        b_buscar.setMnemonic('B');
        b_buscar.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(t_buscar.getText().isEmpty()){
                        JOptionPane.showMessageDialog(ventana,"Ingrese un dato a buscar", "Advertencia", JOptionPane.OK_OPTION);
                    }
                    else{
                        buscar(t_buscar.getText());
                    }
                }
        });
        
        b_nuevo = new JButton("Nuevo");
        b_nuevo.setBounds(410,100,90,25);
        b_nuevo.setMnemonic('N');
        b_nuevo.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    t_buscar.setText("");
                    limpiarCampos();
                    setVisible(true);
                }
        });
        
        ventana.getContentPane().add(imagen);
        ventana.getContentPane().add(panel);
        ventana.getContentPane().add(b_ok);
        ventana.getContentPane().add(b_cancelar);
        ventana.getContentPane().add(l_bcedula);
        ventana.getContentPane().add(t_buscar);
        ventana.getContentPane().add(b_buscar);
        ventana.getContentPane().add(b_nuevo);
    }
    
    public void limpiarCampos(){
        t_cedula.setText("");
        t_nombre.setText("");
        t_direccion.setText("");
        t_tlf1.setText("");
        t_tlf2.setText("");
        t_correo.setText("");
        t_rif.setText("");
    }
    
    public void setVisible(boolean aflag){
        t_cedula.setEditable(true);
        panel.setVisible(aflag);
        b_ok.setVisible(aflag);
        b_cancelar.setVisible(aflag);
    }
    
    public void buscar(String cedula){
        Conexion con = new Conexion(dirIP);
        if(con.conectar() == 1){
            try{
                ResultSet res = con.consultar("select * from CLIENTES where cedula='"+cedula+"'");
                if(res.next()){
                    limpiarCampos();
                    t_cedula.setText(res.getString(1));
                    t_nombre.setText(res.getString(2));
                    t_direccion.setText(res.getString(3));
                    t_tlf1.setText(res.getString(4));
                    t_tlf2.setText(res.getString(5));
                    t_correo.setText(res.getString(6));
                    t_rif.setText(res.getString(7));                                    
                    setVisible(true);
                    t_cedula.setEditable(false);
                }
                else{
                    setVisible(false);
                    JOptionPane.showMessageDialog(ventana,"No se encontro el Cliente", "Advertencia", JOptionPane.OK_OPTION);
                }
                con.desconectar();
            }
            catch(Exception er){ /*er.printStackTrace();*/ }
        }
        else{
            JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
}
