import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class Inicio extends JWindow{
   private JLabel l_image,l_load;
   private JProgressBar progres; 
   private String url=null;
    
    public Inicio() {
        super();
        Inicializar();        
    }
    void Inicializar(){
                  /*URI n = null;
                  url =  url = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
                   try {
            File aux = new File(new URL(url).toURI());
            n = aux.getParentFile().toURI();         
        } catch (Exception ex) {
          
        }
           url = n.toString();
           int val = url.indexOf("build");
           if(val>0){
           url = url+"classes/Imagenes/init.png"; 
           }else{
           url = url+"Files/init.png";
           }   */ 
                 setBounds(0,0,565,290);  
                 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                 Dimension frameSize = getSize(); 
                 setLocation(new Point((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2)); 
                 setLayout(null);
                 
                 l_image = new JLabel();
                 l_image.setBounds(0,0,565,290);
                 l_load = new JLabel("Cargango : 0%");
                 l_load.setBounds(10,230,260,20);
                 
                 l_load.setFont(new Font("arial bold",Font.ITALIC,12));
                 l_load.setForeground(Color.WHITE);
        try {
       
                  // l_image.setIcon(new ImageIcon(getClass().getResource("\\Imagenes\\init.png")));
            //url = new URL(url).toURI();
           
        } catch (Exception ex) {
            
        }
        try {
            //l_image.setIcon(new ImageIcon(new URL(url)));
            l_image.setIcon(new ImageIcon(getClass().getResource("/Imagenes/init.png")));
        } catch (Exception ex) {
            
        }
      

                 progres = new JProgressBar();
                 progres.setBounds(0,255,565,6);                
                 progres.setValue(0);
                 progres.setMaximum(100);
                 progres.setMinimum(0);
                 progres.setForeground(Color.ORANGE);
                 add(progres);
                 add(l_load);  
                 add(l_image);
                              
                 setVisible(true);                
                 String[] mos = {".","..","...","....",".....","....","...","..","."};
                 Thread c = new Thread();
                 int aux=0;
                 for (int i = 0; i <= 25; i++) {
                    progres.setValue(i*4);
                    try {
                        c.sleep(100);
                        l_load.setText("Cargando: "+String.valueOf(i*4)+"% Inicializando"+mos[aux] );
                        aux++;
                        if(aux==8){
                        aux=0;
                        }
                        if((i*4)>=100){
                                this.dispose();
                                Iniciar ini = new Iniciar();
                        }
                    }
                    catch (InterruptedException ex) {
                    }
                    this.repaint();

                 }
                 c=null;
    }
}//fin clase
