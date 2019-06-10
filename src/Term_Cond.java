import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class Term_Cond {
    private JPanel p_prin;
    private JLabel term_1,condi;
   
    public Term_Cond() {
    }
    
    JPanel PanelTerm(){
            p_prin = new JPanel();
            p_prin.setBounds(0,0,320,400);
            p_prin.setLayout(null);
            p_prin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
            p_prin.setBackground(Color.WHITE);
            term_1 = new JLabel("Terminos y Condiciones");
            //term_1 = new JLabel("");
            term_1.setBounds(80,10,400,30);
            
            int y = 30;
            
            java.net.URI n = null;
            String url = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
            try {
                File aux = new File(new java.net.URL(url).toURI());
                n = aux.getParentFile().toURI();         
            }
            catch (Exception ex) {            }
            url = n.toString();
            int val = url.indexOf("build");
            if(val>0){
                url = url+"classes/Imagenes/t_c.txt"; 
            }else{
                url = url+"Files/t_c.txt";
            }
            
            //File f = new File( "D:\\UNET\\JAVA\\d_boutique\\src\\d_boutique\\Imagenes\\Terminos y Condiciones.txt" );
            File f=null;
            try{
                f= new File(new java.net.URL(url).toURI());
            }
            catch(Exception e){ }
            String data = null;
            if(f.exists()){
                try {
                   BufferedReader entrada = new BufferedReader( new FileReader( f ) ); 
                   while (entrada.ready()){
                condi = new JLabel(entrada.readLine());
                condi.setBounds(15,y,400,30);
                condi.setFont(new Font("Lucida Console",Font.ITALIC,7));
                y=y+10;
                p_prin.add(condi);
                
            }entrada.close(); } //fin while             
                    catch (Exception e) {
                    System.out.println("Error en Lectura de Archivo");
                }    
            
            }
                   
           
            
            p_prin.add(term_1);
            return p_prin;
    }//Fin PanelTerm
}
