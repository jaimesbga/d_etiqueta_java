import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Caracter extends JDialog {    
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel p_t_acces,p_color,p_f_acces,p_m_acces;
private JTabbedPane ta_panel;
private JList lis_acces,lis_color,lis_forma, lis_marca;
private JScrollPane s_acces,s_color,s_forma, s_marca;
private Conexion c_car;
private DefaultListModel l_acc,l_color,l_forma,l_marca;
private JTextField t_id_acc,t_des_acc,t_id_color,t_c1_color,t_c2_color,t_c3_color,t_id_marca,t_des_marca,t_id_forma,t_des_forma;
private JLabel l_id_acc,l_des_acc,l_id_color,l_c1_color,l_c2_color,l_c3_color,l_id_marca,l_id_forma,l_des_marca,l_des_forma;
private JButton b_acces,b_color,b_forma,b_marca;
private JCheckBox ch1_color,ch2_color;

    public Caracter(JFrame parent,String Ip_Server) {
        super(parent,true);
        l_acc = new DefaultListModel();
        c_car = new Conexion(Ip_Server);        
        setTitle("~Caracteristicas de Accesorios~");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);        
        setBounds(0,0,370,410);
        setResizable(false); 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.width) / 2));
        
                     ta_panel = new JTabbedPane();
                    ta_panel.addTab("Accesorio",T_Accesorio());
                    ta_panel.addTab("Color",T_Color());
                    ta_panel.addTab("Forma",T_Form_Access());
                    ta_panel.addTab("Marca",T_Marca_Acess());
         
            add(ta_panel); 
        setVisible(true); 
    }
    
     JPanel T_Accesorio(){        
        b_acces = new JButton("Guardar");
        b_acces.setBounds(210,260,80,30);      
        p_t_acces = new JPanel();         
        t_id_acc = new JTextField();
        t_id_acc.setBounds(150,170,200,20);
        t_des_acc = new JTextField();
        t_des_acc.setBounds(150,220,200,20);
        l_id_acc = new JLabel("Numero de Identificacion:");
        l_id_acc.setBounds(180,130,150,50);
        l_des_acc = new JLabel("Descripcion:");
        l_des_acc.setBounds(210,180,150,50);
        t_id_acc.setEditable(false);
        t_id_acc.setVisible(false);
        l_id_acc.setVisible(false);
        //evento del Boton
        b_acces.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    if(c_car.conectar()==1){
                    if(l_id_acc.isVisible()){    
                    int verifi = c_car.actualizar("UPDATE TIPO_ACCESORIOS SET DESCRIPCION ='"+t_des_acc.getText()+"' WHERE ID="+t_id_acc.getText());
                         if(verifi==1){
                         JOptionPane.showMessageDialog(null,"Dato Actualizado con Exito!!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
                         }else{
                         JOptionPane.showMessageDialog(null,"Error Al Actualizar Datos en BD","Advertencia",JOptionPane.WARNING_MESSAGE);
                         }                 
                    }//fin if
                    else{
                        if(c_car!=null&&(t_des_acc.getText()!=null||t_des_acc.getText()!="")){
                            try{
                            int veri=0;
                            ResultSet resul = c_car.consultar("SELECT nvl(MAX(ID)+1,1) FROM TIPO_ACCESORIOS");
                            //////OJO AQUI/////
                            resul.next();                            
                            veri = c_car.actualizar("INSERT INTO TIPO_ACCESORIOS VALUES('"+resul.getString(1)+"','"+t_des_acc.getText()+"')");
                            if(veri==0){                                
                            JOptionPane.showMessageDialog(null,"Error Al Inserta Datos en BD","Advertencia",JOptionPane.WARNING_MESSAGE);
                            } //fin if  
                            else{
                            JOptionPane.showMessageDialog(null,t_des_acc.getText()+" Insertado con Exito!!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
                            t_des_acc.setText("");
                            }
                             }//fin try
                            catch(Exception e2){
                                JOptionPane.showMessageDialog(null,"Error Al Inserta Datos en BD","Advertencia",JOptionPane.WARNING_MESSAGE);
                            }//fin catch
                        }
                    }//fin else
                    l_acc.clear(); 
                    l_acc = LoadyActualiList("TIPO_ACCESORIOS");
                    lis_acces.setModel(l_acc);
                    }
            }
        });
        //fin evento del boton
         l_acc = LoadyActualiList("TIPO_ACCESORIOS");  
        lis_acces = new JList(l_acc);     
        
                   //Evento de la Lista            
        
        lis_acces.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int minselec = lis_acces.getMinSelectionIndex();
                int maxselec = lis_acces.getMaxSelectionIndex();
                int value=0;
                for(int i = minselec; i<=maxselec;i++){
                    if(lis_acces.isSelectedIndex(i)){
                        value = i;
                       // System.out.println(l_acc.getElementAt(i).toString().substring(0,2));                              
                               
                    }//fin if
           }//fin for                
              if(value!=0){      
                   
               t_id_acc.setVisible(true);
               l_id_acc.setVisible(true);
              }
              if(value==0){
                    t_id_acc.setVisible(false);
                    l_id_acc.setVisible(false); 
                    t_des_acc.setText("");
              }
              
                
                if(value!=0){
                        String[] val = l_acc.getElementAt(value).toString().split("--");                        
                        t_id_acc.setText(String.valueOf(Integer.parseInt(val[0])));
                        t_des_acc.setText(val[1]);
                }//fin if
        
            }
        });        
        //Fin evento
        
        s_acces = new JScrollPane();              
        ta_panel.setBounds(0,0,350,400);        
        p_t_acces.setBounds(0,0,350,400);
        p_t_acces.setLayout(null);        
        lis_acces.setBounds(0,0,150,300);
        s_acces.setBounds(10,10,130,330);
        s_acces.setViewportView(lis_acces);
        p_t_acces.add(b_acces);
        p_t_acces.add(l_des_acc);
        p_t_acces.add(l_id_acc);
        p_t_acces.add(t_id_acc);
        p_t_acces.add(t_des_acc);
        p_t_acces.add(s_acces);         
        return p_t_acces;
    }//Fin Inicializar
    
  DefaultListModel LoadyActualiList(String Tabla){
      DefaultListModel aux = new DefaultListModel();
   if(c_car.conectar()==1){
                try {
                    ResultSet res = c_car.consultar("select * from "+Tabla+" order by id");
                    aux.addElement("Nuevo...");
                    while(res != null && res.next()){
                        String add = "";
                        if(Integer.parseInt(res.getString(1))<=9){
                            add = "0";
                        }//fin if
                        else{
                            add = "";
                        }//fin else
                            if(Tabla=="TIPO_ACCESORIOS"||Tabla=="FORMA_ACCESORIOS"||Tabla=="MARCA_ACCESORIOS"){
                        aux.addElement(add+res.getString(1)+"--"+res.getString(2)+"\n");
                            }//fin if
                            if(Tabla=="COLOR_ACCESORIOS"){
                                    if(res.getString(3)==null && res.getString(4)==null){
                                            aux.addElement(add+res.getString(1)+"_"+res.getString(2)+"\n");
                                    }//fin if
                                    if(res.getString(3)!=null && res.getString(4)==null){
                                            aux.addElement(add+res.getString(1)+"_"+res.getString(2)+"--"+res.getString(3)+"\n");    
                                    }//fin if
                                    if(res.getString(3)!=null && res.getString(4)!=null){
                                            aux.addElement(add+res.getString(1)+"_"+res.getString(2)+"--"+res.getString(3)+"--"+res.getString(4)+"\n");
                                    }//fin if
                            }//fin if
                    }//fin while
                   if(c_car.desconectar()==1){
                        System.out.print("Desconexion Satisfactoria");
                    }
                } catch (Exception e) {
                   //excepcion
                }//fin catch
            }//fin if
   
            return aux;
  
  }
  
  JPanel T_Color(){
  p_color = new JPanel();
  p_color.setBounds(0,0,350,400);
  p_color.setLayout(null);
        t_id_color = new JTextField();
        t_id_color.setBounds(180,70,150,20);
        t_c1_color = new JTextField();
        t_c1_color.setBounds(180,120,150,20);
        t_c2_color = new JTextField();
        t_c2_color.setBounds(180,170,150,20);
        t_c3_color = new JTextField();
        t_c3_color.setBounds(180,220,150,20);
                l_id_color = new JLabel("Numero de Identificacion:");
                l_id_color.setBounds(180,30,150,50);
                l_c1_color = new JLabel("Descripcion Nº 1: ");
                l_c1_color.setBounds(200,80,150,50);             
                l_c2_color = new JLabel("Descripcion Nº 2: ");
                l_c2_color.setBounds(200,130,150,50);    
                l_c3_color = new JLabel("Descripcion Nº 3: ");
                l_c3_color.setBounds(200,180,150,50);    
                 b_color = new JButton("Guardar");
                 b_color.setBounds(210,260,80,30); 
                 ch1_color = new JCheckBox();//PENDIENTE JCHECKBOX
                 ch1_color.setBounds(150,165,30,30); 
                 ch2_color = new JCheckBox();//PENDIENTE JCHECKBOX
                 ch2_color.setBounds(150,215,30,30);
                 t_id_color.setEditable(false);
                 t_c3_color.setEditable(false);
                 t_c2_color.setEditable(false);
                 t_id_color.setVisible(false);
                 l_id_color.setVisible(false);
                 
                 //Eventos Check Box
                 ch1_color.addChangeListener(new ChangeListener() {
                     public void stateChanged(ChangeEvent e) {
                            if(ch1_color.isSelected()==true){
                                   t_c2_color.setEditable(true);
                            }else{
                            
                             t_c2_color.setEditable(false);
                             
                            }//fin if-else
                           
  
                     }
                 });
                 
                   ch2_color.addChangeListener(new ChangeListener() {
                     public void stateChanged(ChangeEvent e) {
                            if(ch2_color.isSelected()==true&&ch1_color.isSelected()==true){
                                   t_c3_color.setEditable(true);
                            }else{
                             ch2_color.setSelected(false);   
                             t_c3_color.setEditable(false);
                            }//fin if-else
                            
                     }
                 });
                //Fin Eventos Check Box
                 //evento de boton
                 b_color.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                         int val=0;
                            if(c_car.conectar()==1&&t_id_color.isVisible()!=false){
                            int retor=0;
                                    if(ch1_color.isSelected()==false&&t_c1_color.getText()!=""){
                                          retor =  c_car.actualizar("UPDATE COLOR_ACCESORIOS SET COLOR1='"+t_c1_color.getText()+"',COLOR2 = null,COLOR3=null WHERE ID="+t_id_color.getText());
                                    }//fin if
                                    if(ch1_color.isSelected()==true&&ch2_color.isSelected()==false&&t_c1_color.getText()!=""&&t_c2_color.getText()!=""){
                                          retor =  c_car.actualizar("UPDATE COLOR_ACCESORIOS SET COLOR1='"+t_c1_color.getText()+"',COLOR2 ='"+t_c2_color.getText()+"',COLOR3=null WHERE ID="+t_id_color.getText());
                                    }//fin if
                                    if(ch1_color.isSelected()==true&&ch2_color.isSelected()==true&&t_c1_color.getText()!=""&&t_c2_color.getText()!=""&&t_c3_color.getText()!=""){
                                          retor =  c_car.actualizar("UPDATE COLOR_ACCESORIOS SET COLOR1='"+t_c1_color.getText()+"',COLOR2 ='"+t_c2_color.getText()+"',COLOR3='"+t_c3_color.getText()+"' WHERE ID="+t_id_color.getText());
                                    }//fin if
                                    if(retor==1){
                                   JOptionPane.showMessageDialog(null,"Dato Actualizado con Exito!!!","Informacion",JOptionPane.INFORMATION_MESSAGE); 
                                    }else{
                                JOptionPane.showMessageDialog(null,"Error Al Actualizar Dato!!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
                                    }//fin else
                            }//fin if global
                            
                           else{
                                 if(t_id_color.isVisible()==false){
                                     try{
                                         
                                     ResultSet resul = c_car.consultar("SELECT nvl(MAX(ID)+1,1) FROM COLOR_ACCESORIOS order by id");
                                       resul.next();
                                     if(ch1_color.isSelected()==false&&t_c1_color.getText()!=""){
                                            val=c_car.actualizar("INSERT INTO COLOR_ACCESORIOS VALUES('"+resul.getString(1)+"','"+t_c1_color.getText()+"',null,null)");
                                    }//fin if
                                    if(ch1_color.isSelected()==true&&ch2_color.isSelected()==false&&t_c1_color.getText()!=""&&t_c2_color.getText()!=""){
                                            val=c_car.actualizar("INSERT INTO COLOR_ACCESORIOS VALUES('"+resul.getString(1)+"','"+t_c1_color.getText()+"','"+t_c2_color.getText()+"',null)");
                                    }//fin if
                                    if(ch1_color.isSelected()==true&&ch2_color.isSelected()==true&&t_c1_color.getText()!=""&&t_c2_color.getText()!=""&&t_c3_color.getText()!=""){
                                          val=c_car.actualizar("INSERT INTO COLOR_ACCESORIOS VALUES('"+resul.getString(1)+"','"+t_c1_color.getText()+"','"+t_c2_color.getText()+"','"+t_c3_color.getText()+"')");
                                    }//fin if 
                                        if(val==1){
                            JOptionPane.showMessageDialog(null,"Color Insertado con Exito!!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
                            t_c1_color.setText("");
                            t_c2_color.setText("");
                            t_c3_color.setText("");
                            }else{
                            JOptionPane.showMessageDialog(null,"Error Al Insertar color en la BD!!!","Advertencia",JOptionPane.INFORMATION_MESSAGE);
                            t_c1_color.setText("");
                            t_c2_color.setText("");
                            t_c3_color.setText("");
                            }//fin else
                                     }//fin try
                                     catch(Exception d){
                                     System.out.println(d);
                                     }//fin catch
                                }
                            }//fin else
                            
                        
                            
                            l_color.clear();
                            l_color = LoadyActualiList("COLOR_ACCESORIOS");
                            lis_color.setModel(l_color);
                     }
                 });
                 //fin evento de boton
  l_color = new DefaultListModel();
  l_color = LoadyActualiList("COLOR_ACCESORIOS");
  lis_color = new JList(l_color);
  lis_color.setBounds(10,10,150,330);
  s_color = new JScrollPane();
  s_color.setBounds(10,10,130,330);
  s_color.setViewportView(lis_color);
  
  //Evento de Lista de Color
  lis_color.addListSelectionListener(new ListSelectionListener() {
                        public void valueChanged(ListSelectionEvent e) {
                                                   
                            int minselec = lis_color.getMinSelectionIndex();
                            int maxselec = lis_color.getMaxSelectionIndex();
                            int value=0;
                             
                            for(int i = minselec; i<=maxselec;i++){
                                if(lis_color.isSelectedIndex(i)){
                             value = i;
                                }//fin if
                        }//fin for  
                            
                            if(value!=0){
                                    l_id_color.setVisible(true);
                                    t_id_color.setVisible(true);
                            }//fin if
                            if(value==0){
                                    t_c2_color.setEditable(false);
                                    ch1_color.setSelected(false);
                                    t_c3_color.setEditable(false);
                                    ch2_color.setSelected(false);
                                    l_id_color.setVisible(false);
                                    t_id_color.setVisible(false);
                                    t_c1_color.setText("");
                                    t_c2_color.setText("");
                                    t_c3_color.setText("");
                            }//fin if   
                                                                        
                if(c_car.conectar()==1){
                  
                  try {
                  ResultSet res = c_car.consultar("select * from COLOR_ACCESORIOS order by id");
                  int cont=0;
                    while(res != null && res.next()){   
                     cont++;
                      if(value==cont){                                   
                                    t_c1_color.setText("");
                                    t_c2_color.setText("");
                                    t_c3_color.setText("");
                                t_id_color.setText(res.getString(1));
                                t_c1_color.setText(res.getString(2));
                                        if(res.getString(3)!=null){
                                            ch1_color.setSelected(true);
                                            t_c2_color.setEditable(true);
                                            t_c2_color.setText(res.getString(3));
                                        }else{
                                            ch1_color.setSelected(false);
                                            t_c2_color.setEditable(false);
                                        }
                                         if(res.getString(4)!=null){
                                            ch2_color.setSelected(true);
                                            t_c3_color.setEditable(true);
                                            t_c3_color.setText(res.getString(4));
                                        }else{
                                            ch2_color.setSelected(false);
                                            t_c3_color.setEditable(false);
                                        }
                      }//fin if
                    }//fin while 
                  
                  }//fin try
                  catch (Exception e2) {
                    
                  }//fin catch                
                    }//fin if
                         c_car.desconectar();   
                        }//fin funcion Change Value
                    });
                    
                 //Fin evento de lista de Color
  
  p_color.add(s_color);
  p_color.add(t_id_color);
  p_color.add(t_c1_color);
  p_color.add(t_c2_color);
  p_color.add(t_c3_color);
  p_color.add(l_id_color);
  p_color.add(l_c1_color);
  p_color.add(l_c2_color);
  p_color.add(l_c3_color);
  p_color.add(b_color);
  p_color.add(ch1_color);
  p_color.add(ch2_color);
  return p_color;
 }//fin Color*/
  
 JPanel T_Form_Access(){
 p_f_acces=new JPanel();
 p_f_acces.setBounds(0,0,350,400);
 p_f_acces.setLayout(null);
                l_id_forma = new JLabel("Numero de Identificacion:");
                l_id_forma.setBounds(180,130,150,50);  
                l_des_forma = new JLabel("Descripcion:");
                l_des_forma.setBounds(210,180,150,50);
                t_id_forma = new JTextField();
                t_id_forma.setBounds(150,170,200,20);
                t_des_forma = new JTextField();
                t_des_forma.setBounds(150,220,200,20);
                b_forma = new JButton("Guardar");
                b_forma.setBounds(210,260,80,30);
 l_forma = new DefaultListModel();
 l_forma = LoadyActualiList("FORMA_ACCESORIOS");
 lis_forma = new JList(l_forma);
 lis_forma.setBounds(10,10,150,330);
 s_forma = new JScrollPane();
 s_forma.setBounds(10,10,130,330);
 s_forma.setViewportView(lis_forma);
        t_id_forma.setEditable(false);
        t_id_forma.setVisible(false);
        l_id_forma.setVisible(false);
        //Inicio de Evento Lista
 
                lis_forma.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                            int minselec = lis_forma.getMinSelectionIndex();
                    int maxselec = lis_forma.getMaxSelectionIndex();
                    int value=0;
                for(int i = minselec; i<=maxselec;i++){
                    if(lis_forma.isSelectedIndex(i)){
                        value = i;
                    }//fin if
           }//fin for                
              if(value!=0){      
                   
               t_id_forma.setVisible(true);
               l_id_forma.setVisible(true);
              }
              if(value==0){
                    t_id_forma.setVisible(false);
                    l_id_forma.setVisible(false); 
                    t_des_forma.setText("");
              }
              
              if(value!=0){
                        String[] val = l_forma.getElementAt(value).toString().split("--");                    
                        t_id_forma.setText(String.valueOf(Integer.parseInt(val[0])));
                        t_des_forma.setText(val[1]);
                }//fin if
                    
                    }
                });                    
                
        //Fin de Evento Lista 
                //evento boton
                b_forma.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    if(c_car.conectar()==1){
                    if(l_id_forma.isVisible()){ 
                        
                    int verifi = c_car.actualizar("UPDATE FORMA_ACCESORIOS SET DESCRIPCION ='"+t_des_forma.getText()+"' WHERE ID="+t_id_forma.getText());
                     if(verifi==1){
                     JOptionPane.showMessageDialog(null,"Dato Actualizado con Exito!!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
                     }//fin if   
                     else{
                     JOptionPane.showMessageDialog(null,"Error Al Actualizar Datos en BD!!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
                     }
                    }//fin if
                    else{
                            if(c_car!=null&&(t_des_forma.getText()!=null||t_des_forma.getText()!="")){
                           
                            try{
                            int veri=0;
                            ResultSet resul = c_car.consultar("SELECT nvl(MAX(ID)+1,1) FROM FORMA_ACCESORIOS");
                            //////OJO AQUI/////
                            resul.next();                            
                            veri = c_car.actualizar("INSERT INTO FORMA_ACCESORIOS VALUES('"+resul.getString(1)+"','"+t_des_forma.getText()+"')");
                            if(veri==0){                                
                            JOptionPane.showMessageDialog(null,"Error Al Inserta Datos en BD","Advertencia",JOptionPane.WARNING_MESSAGE);
                            } //fin if 
                            else{
                            JOptionPane.showMessageDialog(null,t_des_forma.getText()+" Insertado con Exito!!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
                            t_des_forma.setText("");
                            }
                             }//fin try
                            catch(Exception e2){
                                JOptionPane.showMessageDialog(null,"Error Al Inserta Datos en BD"+e2,"Advertencia",JOptionPane.WARNING_MESSAGE);
                            }//fin catch
                                    
                            }//fin if
                    }//fin else
                    }//fin if global
                    c_car.desconectar();
                    l_forma.clear(); 
                    l_forma = LoadyActualiList("FORMA_ACCESORIOS");
                    lis_forma.setModel(l_forma);
                    }
                    
                });
                //fin evento boton
                
 p_f_acces.add(s_forma);
 p_f_acces.add(t_id_forma);
 p_f_acces.add(t_des_forma);
 p_f_acces.add(l_id_forma);
 p_f_acces.add(l_des_forma); 
 p_f_acces.add(b_forma);
 return p_f_acces;
 }//fin metodo T_Form_Access() 
 
 JPanel T_Marca_Acess(){
    p_m_acces = new JPanel();
    p_m_acces.setBounds(0,0,350,400);
    p_m_acces.setLayout(null);
                l_id_marca = new JLabel("Numero de Identificacion:");
                l_id_marca.setBounds(180,130,150,50);  
                l_des_marca = new JLabel("Descripcion:");
                l_des_marca.setBounds(210,180,150,50);
                t_id_marca = new JTextField();
                t_id_marca.setBounds(150,170,200,20);
                t_des_marca = new JTextField();
                t_des_marca.setBounds(150,220,200,20);
                b_marca = new JButton("Guardar");
                b_marca.setBounds(210,260,80,30);
    l_marca = new DefaultListModel();
    l_marca = LoadyActualiList("MARCA_ACCESORIOS");
    lis_marca = new JList(l_marca);
    lis_marca.setBounds(10,10,150,330);
    s_marca = new JScrollPane();
    s_marca.setBounds(10,10,130,330);
    s_marca.setViewportView(lis_marca);
        t_id_marca.setEditable(false);
        t_id_marca.setVisible(false);
        l_id_marca.setVisible(false);
                //evento de listas
                    lis_marca.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                            int minselec = lis_marca.getMinSelectionIndex();
                            int maxselec = lis_marca.getMaxSelectionIndex();
                    int value=0;
                for(int i = minselec; i<=maxselec;i++){
                    if(lis_marca.isSelectedIndex(i)){
                        value = i;
                    }//fin if
           }//fin for                
              if(value!=0){      
                   
               t_id_marca.setVisible(true);
               l_id_marca.setVisible(true);
              }
              if(value==0){
                    t_id_marca.setVisible(false);
                    l_id_marca.setVisible(false); 
                    t_des_marca.setText("");
              }
              
               if(value!=0){
                        String[] val = l_marca.getElementAt(value).toString().split("--");                     
                        t_id_marca.setText(String.valueOf(Integer.parseInt(val[0])));
                        t_des_marca.setText(val[1]);
                }//fin if
                    
                    }
                });  
    
                //fin evento listas
                
                //evento boton
                b_marca.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    if(c_car.conectar()==1){
                    if(l_id_marca.isVisible()){ 
                        
                    int verifi = c_car.actualizar("UPDATE MARCA_ACCESORIOS SET DESCRIPCION ='"+t_des_marca.getText()+"' WHERE ID="+t_id_marca.getText());
                    if(verifi==1){
                    JOptionPane.showMessageDialog(null," Dato Actualizado con Exito!!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
                    }//fin if                 
                    }//fin if
                            else{
                            if(c_car!=null&&(t_des_marca.getText()!=null||t_des_marca.getText()!="")){
                           
                            try{
                            int veri=0;
                            ResultSet resul = c_car.consultar("SELECT nvl(MAX(ID)+1,1) FROM MARCA_ACCESORIOS");
                            //////OJO AQUI/////
                             resul.next();                            
                            veri = c_car.actualizar("INSERT INTO MARCA_ACCESORIOS VALUES('"+resul.getString(1)+"','"+t_des_marca.getText()+"')");
                            if(veri==0){                                
                            JOptionPane.showMessageDialog(null,"Error Al Inserta Datos en BD","Advertencia",JOptionPane.WARNING_MESSAGE);
                            } //fin if      
                            else{
                            JOptionPane.showMessageDialog(null,t_des_marca.getText()+" Insertado con Exito!!!","Informacion",JOptionPane.INFORMATION_MESSAGE);
                            t_des_marca.setText("");
                            }//fin else
                             }//fin try
                            catch(Exception e2){
                                JOptionPane.showMessageDialog(null,"Error Al Inserta Datos en BD"+e2,"Advertencia",JOptionPane.WARNING_MESSAGE);
                            }//fin catch
                                    
                            }//fin if
                    }//fin else
                    }//fin if global
                    c_car.desconectar();
                    l_marca.clear(); 
                    l_marca = LoadyActualiList("MARCA_ACCESORIOS");
                    lis_marca.setModel(l_marca);
                    }
                    
                });
                //fin evento boton
 p_m_acces.add(s_marca);
 p_m_acces.add(t_id_marca);
 p_m_acces.add(t_des_marca);
 p_m_acces.add(l_id_marca);
 p_m_acces.add(l_des_marca); 
 p_m_acces.add(b_marca);
    return p_m_acces;
 } 
}
