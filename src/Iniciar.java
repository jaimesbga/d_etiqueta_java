import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;

public class Iniciar {
    private JFrame ventana;
    private JLabel imagen, l_ipServer, l_tienda;
    private JTextField t_ipServer;
    private JComboBox c_tienda;
    private JButton b_ok, b_cancelar;;
    
    public Iniciar() {
        iniciarComponentes();
        
        ventana.setVisible(true);
    }
    
    public void iniciarComponentes(){
        ventana = new JFrame("D' Etiqueta - Iniciar");
        ventana.setSize(400,200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);  
        ventana.setLayout(null);
        //ventana.getContentPane().setBackground(Color.WHITE);
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setLocation((int)(d.getWidth()/2-200), (int)(d.getHeight()/2-90));
        
        Font font = new Font("Arial",Font.BOLD,14);
        
        imagen = new JLabel();
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/conectar.png")));
        imagen.setBounds(0,20,120,120);
        
        l_ipServer = new JLabel("IP SERVIDOR:");
        l_ipServer.setFont(font);
        l_ipServer.setBounds(110,40,100,40);
        
        t_ipServer = new JTextField("localhost");
        t_ipServer.setBounds(220,50,150,20);
        
        l_tienda = new JLabel("SUCURSAL:");
        l_tienda.setFont(font);
        l_tienda.setBounds(125,80,100,40);
        l_tienda.setVisible(false);
        
        c_tienda = new JComboBox();
        c_tienda.setBounds(220,90,150,20);  
        c_tienda.setVisible(false);
        
        b_ok = new JButton();
        b_ok.setText("CONECTAR");
        b_ok.setMnemonic('C');
        b_ok.setBounds(250,130,120,25);
        b_ok.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {  
                    if(l_tienda.isVisible() == false){
                       if(t_ipServer.getText().isEmpty()){
                            JOptionPane.showMessageDialog(ventana,"Ingrese la dirección del Servidor", "Advertencia", JOptionPane.OK_OPTION);
                        }
                        else{
                            Conexion con = new Conexion(t_ipServer.getText());
                            if(con.conectar() == 1){
                                try{
                                    ResultSet res = con.consultar("select NOMBRE from TIENDAS");
                                    while(res != null && res.next()){
                                        c_tienda.addItem(res.getString(1));
                                    }                                    
                                    l_tienda.setVisible(true);
                                    c_tienda.setVisible(true);
                                    b_ok.setText("ENTRAR>>>");
                                    b_ok.setMnemonic('E');
                                    t_ipServer.setEditable(false);
                                    con.desconectar();                                    
                                }
                                catch(Exception r){ }
                            }
                            else{
                                JOptionPane.showMessageDialog(ventana,"No se encontro el Servidor", "Advertencia", JOptionPane.OK_OPTION);
                            }
                        }
                    }
                    else{
                        int id = c_tienda.getSelectedIndex();
                        if(id>=0){
                            Menu obj = new Menu(t_ipServer.getText(), String.valueOf(id+1));
                            ventana.dispose();
                        }
                    }
                }
        });
        
        b_cancelar = new JButton();
        b_cancelar.setText("SALIR");
        b_cancelar.setMnemonic('S');
        b_cancelar.setBounds(110,130,120,25);
        b_cancelar.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
        });
        
        ventana.getContentPane().add(imagen);
        ventana.getContentPane().add(l_ipServer);
        ventana.getContentPane().add(t_ipServer);
        ventana.getContentPane().add(l_tienda);
        ventana.getContentPane().add(c_tienda);
        ventana.getContentPane().add(b_ok);
        ventana.getContentPane().add(b_cancelar);
    }
    
}
