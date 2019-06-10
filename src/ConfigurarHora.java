import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import javax.swing.*;

public class ConfigurarHora {
    private JDialog ventana;
    private JPanel panel;
    private JTextField t_hora, t_min;
    private JButton b_aceptar, b_cancelar, b_upHora, b_downHora, b_upMin, b_downMin;
    private int difHora, difMin;
    private Menu menu;
    
    public ConfigurarHora(Menu m) {
        menu = m;
        difHora = 0;
        difMin = 0;
        inicializar(m.getVentana());
        cargarHora();
    }
    
    public void inicializar(JFrame padre){
        ventana = new JDialog(padre, true);
        ventana.setTitle("D' Etiqueta - Configurar Hora");
        ventana.setResizable(false);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setSize(300, 300);
        Rectangle parentBounds = padre.getBounds();
        Dimension size = ventana.getSize();
        int xf = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int yf = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        ventana.setLocation(new Point(xf, yf));
        
        panel = new JPanel();
        panel.setBounds(40, 30, 220, 150);
        panel.setBorder(BorderFactory.createTitledBorder("Configuar Hora"));
        panel.setLayout(null);
        
        t_hora = new JTextField("12");
        t_hora.setBounds(20, 60, 50, 30);
        t_hora.setFont(new Font("Arial", Font.BOLD, 20));
        t_hora.setHorizontalAlignment(JTextField.CENTER);
        t_hora.setFocusable(false);
        t_hora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                evt.consume();
            }
        });
        
        b_upHora = new JButton();
        b_upHora.setIcon(new ImageIcon(getClass().getResource("/Imagenes/arriba.png")));
        b_upHora.setBounds(72, 60, 30, 15);
        b_upHora.setContentAreaFilled(false);
        b_upHora.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                int val = Integer.parseInt(t_hora.getText());
                if(val == 12){
                    val = 1;
                }
                else{
                    val++;
                }
                if(val<10){
                    t_hora.setText("0"+val);
                }
                else{
                    t_hora.setText(String.valueOf(val));
                }
            }
        });
        
        b_downHora = new JButton();
        b_downHora.setIcon(new ImageIcon(getClass().getResource("/Imagenes/abajo.png")));
        b_downHora.setBounds(72, 75, 30, 15);
        b_downHora.setContentAreaFilled(false);
        b_downHora.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                int val = Integer.parseInt(t_hora.getText());
                if(val == 1){
                    val = 12;
                }
                else{
                    val--;
                }
                if(val<10){
                    t_hora.setText("0"+val);
                }
                else{
                    t_hora.setText(String.valueOf(val));
                }
            }
        });
        
        t_min = new JTextField("00");
        t_min.setBounds(120, 60, 50, 30);
        t_min.setFont(new Font("Arial", Font.BOLD, 20));
        t_min.setHorizontalAlignment(JTextField.CENTER);
        t_min.setFocusable(false);
        t_min.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                evt.consume();
            }
        });
        
        b_upMin = new JButton();
        b_upMin.setIcon(new ImageIcon(getClass().getResource("/Imagenes/arriba.png")));
        b_upMin.setBounds(172, 60, 30, 15);
        b_upMin.setContentAreaFilled(false);
        b_upMin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                int val = Integer.parseInt(t_min.getText());
                if(val == 59){
                    val = 0;
                }
                else{
                    val++;
                }
                if(val<10){
                    t_min.setText("0"+val);
                }
                else{
                    t_min.setText(String.valueOf(val));
                }
            }
        });
        
        b_downMin = new JButton();
        b_downMin.setIcon(new ImageIcon(getClass().getResource("/Imagenes/abajo.png")));
        b_downMin.setBounds(172, 75, 30, 15);
        b_downMin.setContentAreaFilled(false);
        b_downMin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                int val = Integer.parseInt(t_min.getText());
                if(val == 0){
                    val = 59;
                }
                else{
                    val--;
                }
                if(val<10){
                    t_min.setText("0"+val);
                }
                else{
                    t_min.setText(String.valueOf(val));
                }
            }
        });
        
        panel.add(t_hora);
        panel.add(t_min);
        panel.add(b_upHora);
        panel.add(b_downHora);
        panel.add(b_upMin);
        panel.add(b_downMin);
        
        b_aceptar = new JButton("Guardar");
        b_aceptar.setBounds(50, 205, 90, 25);
        b_aceptar.setMnemonic('G');
        b_aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                int hora = Calendar.getInstance().get(Calendar.getInstance().HOUR_OF_DAY);
                int min = Calendar.getInstance().get(Calendar.getInstance().MINUTE);
                
                if(hora>12){
                    hora = hora - 12;
                }
                
                int dif1 = Integer.parseInt(t_hora.getText()) - hora;
                int dif2 = Integer.parseInt(t_min.getText()) - min;
                
                menu.setDiferenciaHora(dif1, dif2);
                menu.guardarVentana();
                JOptionPane.showMessageDialog(ventana, "Hora Actualizada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        b_cancelar = new JButton("Cerrar");
        b_cancelar.setBounds(160, 205, 90, 25);
        b_cancelar.setMnemonic('C');
        b_cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                ventana.dispose();
            }
        });
        
        ventana.getContentPane().add(panel);
        ventana.getContentPane().add(b_aceptar);
        ventana.getContentPane().add(b_cancelar);
    }
    
    public void cargarHora(){
        leerArchivo();
        String turno = "am";
        int hora = Calendar.getInstance().get(Calendar.getInstance().HOUR_OF_DAY)+difHora;
        int min = Calendar.getInstance().get(Calendar.getInstance().MINUTE)+difMin;
        
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
        
        t_hora.setText(h);
        t_min.setText(m);
    }
    
    public void leerArchivo(){
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
        }
        catch(Exception e){
        }
    }
    
    public void setVisible(boolean aFlag){
        ventana.setVisible(aFlag);
    }
    
    public void dispose(){
        ventana.dispose();
    }
    
}
