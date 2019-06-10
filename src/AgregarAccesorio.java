import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AgregarAccesorio {
    private JFrame ventana;
    private JPanel panel,panel2;
    private JLabel l_tipo, l_forma, l_color, l_marca, l_talla, l_cantidad; 
    private JComboBox c_tipo, c_forma, c_color, c_marca;
    private JTextField t_talla, t_cantidad;
    private JButton b_ok, b_cancelar, b_caracter;
    private String dirIP;
    
    public AgregarAccesorio(String ip) {
        dirIP = ip;
        
        iniciarComponentes();
        llenarCampos();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                 Dimension frameSize = ventana.getSize(); 
                 ventana.setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.width-50) / 2));
        ventana.setVisible(true);
    }
    
    public void iniciarComponentes(){
        ventana = new JFrame("D' Etiqueta - Accesorios");
        ventana.setSize(430,430);
        ventana.setResizable(false);
        ventana.setLayout(null);
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setLocation((int)(d.getWidth()/2-265), (int)(d.getHeight()/2-290));
        
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Agregar Accesorios", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        panel.setBounds(13,10,400,320);
        panel.setLayout(null);
        
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Opciones", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        panel2.setBounds(13,330,400,60);
        panel2.setLayout(null);
        Font font = new Font("Arial",Font.BOLD,14);
        
        l_tipo = new JLabel("Tipo:");
        l_tipo.setBounds(10,50,120,20);
        
        c_tipo = new JComboBox();
        c_tipo.setBounds(70, 50, 250,20);
        
        l_forma = new JLabel("Forma:");
        l_forma.setBounds(10,95,120,20);
        
        c_forma = new JComboBox();
        c_forma.setBounds(70, 95, 250,20);
        
        l_color = new JLabel("Color:");
        l_color.setBounds(10,140,120,20);
        
        c_color = new JComboBox();
        c_color.setBounds(70, 140, 250,20);
                
        l_marca = new JLabel("Marca:");
        l_marca.setBounds(10,185,120,20);
        
        c_marca = new JComboBox();
        c_marca.setBounds(70, 185, 250,20);
        
        l_talla = new JLabel("Talla:");
        l_talla.setBounds(10,230,120,20);
        
        t_talla = new JTextField();
        t_talla.setBounds(70,230,250,20);
        
        l_cantidad = new JLabel("Cantidad:");
        l_cantidad.setBounds(10,275,150,20);
        
        t_cantidad = new JTextField();
        t_cantidad.setBounds(70,275,250,20); 
        
        b_ok = new JButton();
        b_ok.setText("Guardar");
        b_ok.setBounds(80,20,90,25);
        b_ok.setMnemonic('G');
        b_ok.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(t_talla.getText().isEmpty() || t_cantidad.getText().isEmpty()){
                        JOptionPane.showMessageDialog(ventana,"Debe llenar todos los datos", "Advertencia", JOptionPane.OK_OPTION);
                    }
                    else{                        
                        try{
                            int cant = Integer.parseInt(t_cantidad.getText());
                            if(cant<=0){
                                cant = Integer.parseInt("a");
                            }
                            else{
                                Conexion con = new Conexion(dirIP);
                                if(con.conectar() == 1){
                                    int tipo = Integer.parseInt(c_tipo.getSelectedItem().toString().substring(0,2));
                                    int forma = Integer.parseInt(c_forma.getSelectedItem().toString().substring(0,2));
                                    int color = Integer.parseInt(c_color.getSelectedItem().toString().substring(0,2));
                                    int marca = Integer.parseInt(c_marca.getSelectedItem().toString().substring(0,2));
                                    String talla = t_talla.getText().toString().toUpperCase();
                                    System.out.println(talla);
                                    int id = 0;
                                    int numEjemp = 0;
                                    try{
                                        ResultSet res = con.consultar("select IFNULL(max(id)+1,1) from ACCESORIOS");
                                        res.next();
                                        id = Integer.parseInt(res.getString(1));
                                        
                                        res = con.consultar("select count(*) from ACCESORIOS where TALLA='"+talla+"' and TARO_ID ='"+tipo+"' and FARO_ID='"+forma+"' and CARO_ID='"+color+"' and maro_ID='"+marca+"'");
                                        res.next();
                                        numEjemp = Integer.parseInt(res.getString(1))+1;
                                    }
                                    catch(Exception ex){ }  
                                    
                                    for(int i=0; i<cant;i++){                                        
                                        con.actualizar("insert into ACCESORIOS values('"+(id+i)+"','"+(numEjemp+i)+"','"+talla+"','"+tipo+"','"+forma+"','"+color+"','"+marca+"','01')");
                                    }                                                                       
                                    con.desconectar();
                                    
                                    int resp = JOptionPane.showConfirmDialog(ventana,"Operacion Exitosa. Desea Agregar otra Accesorio?","Operacion Exitosa",JOptionPane.YES_NO_OPTION);
            
                                    if(resp == 1){
                                        ventana.setVisible(false);
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
                                }
                            }
                        }
                        catch(NumberFormatException er){
                            JOptionPane.showMessageDialog(ventana,"La cantidad no es valida", "Advertencia", JOptionPane.OK_OPTION);
                        }
                    }
                }
        });
        
        b_cancelar = new JButton();
        b_cancelar.setText("Cancelar");
        b_cancelar.setBounds(250,20,90,25);        
        b_cancelar.setMnemonic('C');
        b_cancelar.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ventana.setVisible(false);
                    ventana.dispose();
                }
        });
        
        b_caracter = new JButton("+"); 
        b_caracter.setBounds(340,150,42,42);  
        b_caracter.setFont(font);
        b_caracter.setToolTipText("Editar Características");
        b_caracter.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Caracter(ventana,dirIP);
                    llenarCampos();
                }
        });
        
        panel.add(l_tipo);
        panel.add(c_tipo);
        panel.add(l_forma);
        panel.add(c_forma);
        panel.add(l_color);
        panel.add(c_color);
        panel.add(l_marca);
        panel.add(c_marca);
        panel.add(l_talla);
        panel.add(t_talla);
        panel.add(l_cantidad);
        panel.add(t_cantidad);
        panel.add(b_caracter);
        ventana.getContentPane().add(panel2);
        ventana.getContentPane().add(panel);
       panel2.add(b_ok);
       panel2.add(b_cancelar);
    }
    
    public void llenarCampos(){
        c_tipo.removeAllItems();
        c_forma.removeAllItems();
        c_color.removeAllItems();
        c_marca.removeAllItems();
        t_talla.setText("");
        t_cantidad.setText("");
        
        Conexion con = new Conexion(dirIP);
        if(con.conectar() == 1){
            try{
                ResultSet res = con.consultar("select ID, DESCRIPCION from TIPO_ACCESORIOS order by ID");
                while(res != null && res.next()){
                    String cadena = "";
                    if(Integer.parseInt(res.getString(1))<10){
                        cadena = "0";
                    }
                    c_tipo.addItem(cadena+res.getString(1)+" "+res.getString(2));
                }
                
                res = con.consultar("select ID, DESCRIPCION from FORMA_ACCESORIOS order by ID");
                while(res != null && res.next()){
                    String cadena = "";
                    if(Integer.parseInt(res.getString(1))<10){
                        cadena = "0";
                    }
                    c_forma.addItem(cadena+res.getString(1)+" "+res.getString(2));
                }
                
                res = con.consultar("select ID, COLOR1, COLOR2, COLOR3 from COLOR_ACCESORIOS order by ID");
                //res = con.consultar("select ID, concat(COLOR1, concat('-', IFNULL(COLOR2,''))) from COLOR_ACCESORIOS");
                while(res != null && res.next()){
                    String cadena = "", col2 = "", col3 = "";
                    if(Integer.parseInt(res.getString(1))<10){
                        cadena = "0";
                    }
                    if(res.getString(3) != null){
                        col2 = " --- "+res.getString(3);
                    }
                    if(res.getString(4) != null){
                        col3 = " --- "+res.getString(4);
                    }
                    c_color.addItem(cadena+res.getString(1)+" "+res.getString(2)+col2+""+col3);
                }
                
                res = con.consultar("select ID, DESCRIPCION from MARCA_ACCESORIOS order by ID");
                while(res != null && res.next()){
                    String cadena = "";
                    if(Integer.parseInt(res.getString(1))<10){
                        cadena = "0";
                    }
                    c_marca.addItem(cadena+res.getString(1)+" "+res.getString(2));
                }
                
                con.desconectar();
            }
            catch(Exception r){ }
        }
        else{
            JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
        }
    }
}
