import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

public class Edit_Term extends JDialog{
    private JTextArea condi;
    private JPanel p_text,p_op;
    private JButton b_ok,b_cancel;
    private String url = null ;        
    /** Creates a new instance of Edit_Term */
    public Edit_Term(JFrame parent) {
        super(parent,true);
        Start();
    }
    public Edit_Term(JDialog parent) {
        super(parent,true);
        Start();
    }
    
    void Start(){
        URI n = null;
        setBounds(0,0,490,700);
        setLayout(null);
        setTitle("Editar Terminos y Condiciones de Contrato");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize(); 
        setLocation(new Point((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2));
        url = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
        try {
            File aux = new File(new URL(url).toURI());
            n = aux.getParentFile().toURI();         
        } catch (Exception ex) {       }
        
        url = n.toString();
           int val = url.indexOf("build");
           if(val>0){
           url = url+"classes/Imagenes/t_c.txt"; 
           }else{
           url = url+"Files/t_c.txt";
           }    
                 Editan();
                 opciones();
                 add(p_text);
                 add(p_op);
                 setVisible(true);
    }
    void Editan() { 
        p_text = new JPanel();
        p_text.setBounds(10,10,460,580);
        p_text.setLayout(null);
        p_text.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Terminos Y Condiciones", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        String info=""; 
            condi = new JTextArea();
            condi.setBounds(15,20,430,540);
        File f=null;
        try {
            f = new File(new URL(url).toURI());
        } catch (Exception ex) {
            
        }
        if(f.exists()){
            try {
                BufferedReader a = new BufferedReader(new FileReader(f));
                try {
                    int i = 0;
                    while(a.ready()){
                    info= info+ a.readLine();
                    info= info + "\n";
                    i++;
                    }
                    a.close();
                } catch (IOException ex) {
                   JOptionPane.showMessageDialog(null,"Error al Leer Archivo Terminos y Condiciones.","Error",JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Error al Leer Archivo Terminos y Condiciones.","Error",JOptionPane.ERROR_MESSAGE);
            }         
    
            }else{
            JOptionPane.showMessageDialog(null,"El archivo fue movido de su directorio.","Error",JOptionPane.ERROR_MESSAGE);
            }
            
          condi.setText(info);
          condi.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
          condi.setFont(new Font("Arial",Font.PLAIN,12));
          p_text.add(condi);
    }
    void opciones(){
        p_op= new JPanel();
        p_op.setBounds(10,590,460,70);
        p_op.setLayout(null);
        p_op.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Acciones", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
       b_ok = new JButton("Guardar");
       b_ok.setMnemonic('G');
       b_ok.setBounds(100,30,100,20);
       b_cancel = new JButton("Cancelar");
       b_cancel.setMnemonic('C');
       b_cancel.setBounds(250,30,100,20);
       b_ok.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        
               Save();
           
           }
       });
       b_cancel.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               dispose();
           }
       });
       p_op.add(b_ok);       
       p_op.add(b_cancel);
    }
   void Save(){
        File f=null;
        try {
            f = new File(new URL(url).toURI());
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        if(f.exists()){    
        f.delete();
           String[] vec;
        try {
            int i=35;
            f.createNewFile();
            BufferedWriter a = new BufferedWriter(new FileWriter(f));
           vec = condi.getText().split("\\n");
           for (int j = 0; j < vec.length; j++) {
             if(vec[j].length()>=67){
                    vec[j]=vec[j].substring(0,67);
              } 
               if(j<=34){
               if(vec[j].isEmpty()){
                    a.newLine();                  
               }else{  
               a.write(vec[j]);
               a.newLine();
               }
              }
           }
          
            a.close();
           JOptionPane.showMessageDialog(null,"El Archivo se actualizo Correctamente...","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (IOException ex) {
           
        }}//fin if global
   }
}
