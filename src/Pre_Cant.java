import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import javax.crypto.NullCipher;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.TableModelEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.w3c.dom.events.MouseEvent;


public class Pre_Cant extends JDialog{
 private JTextField t_cod,t_prec;  
 private JLabel l_cod,l_prec;  
 private JButton b_ok,b_find,process;
 private JPanel p_prin;
 private Conexion con;
 private JScrollPane s_prin;
 private DefaultTableModel_M tabla = null;
 private String f_s,f_e;
 private JTable tab_p;
 private String IpS;
 private String[] datos;
 private  Calendar_Colisiones p = null;
 private String f_en;
 private String f_de;
 private PanelListaBusq panelbus;
 private PanelPedido panelpedi;
 private DefaultTableModel_M tablaaux;
 
 private String forma, color;
 
    public Pre_Cant(JFrame parent,String IpServer,String Fech_e,String Fech_d,DefaultTableModel tablax) {
            super(parent,true);
            f_en = Fech_e;
            f_de = Fech_d;            
            Inicio(IpServer,tablax);
            ///setTableModel((DefaultTableModel_M) tablax);
            forma = "";
            color = "";
    }
     public Pre_Cant(JDialog parent,String IpServer,String Fech_e,String Fech_d,DefaultTableModel tablax) {
            super(parent,true);
            Inicio(IpServer,tablax);
            f_en = Fech_e;
            f_de = Fech_d;
            ///setTableModel((DefaultTableModel_M) tablax);
            forma = "";
            color = "";
    }
     
     void Inicio(String Ip,DefaultTableModel tablax){
         datos=null;
         IpS = Ip;
            con = new Conexion(Ip);  
                setBounds(0,0,1004,560);
                setLayout(null);
                setTitle("Agregar Articulo a Contrato");
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                setResizable(false);
                 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                 Dimension frameSize = getSize(); 
                 setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.height) / 2));
                 
             //process = new JButton("Procesar");
            process = new JButton(new ImageIcon(getClass().getResource("Imagenes/process.png")));
            process.setBackground(Color.WHITE);
            process.setToolTipText("Procesar Carga de Articulos");
             process.setBounds(750,255,240,265);
             process.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                            dispose();
                 }
             });
           
             this.getContentPane().add(process);
                 tabla = new DefaultTableModel_M(new Object [][] {
                {null,null ,null ,null },
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
                
            }, new String [] {
                "Codigo", "Descripcion", "Ejem.", "Lugar"
            });
                 
                 p = new Calendar_Colisiones(510,250,230,270,IpS,f_en,f_de);
                 panelbus = new PanelListaBusq(10,10,Ip,this);
                 panelpedi = new PanelPedido(10,250,tablax);     
                 ////panelpedi.setTablamodelo(tablaaux);
                 add(panelpedi); 
                 add(panelbus);
                 add(p.getPanel());
                 add(Load_Inter());
                 setVisible(true);
     }//fin inicio
     
     JPanel Load_Inter(){
             p_prin = new JPanel();
             p_prin.setBounds(510,10,485,240);
             p_prin.setLayout(null);
             p_prin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Contratar Articulo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
             l_cod = new JLabel("Codigo:");
             l_cod.setBounds(140,20,150,20);    
             
             l_prec = new JLabel("Precio:");
             l_prec.setBounds(140,240,150,20);
            
             t_cod = new JTextField("");
             t_cod.setBounds(190,20,120,20);
             t_cod.setEnabled(false);     
             t_cod.setFont(new Font("Lucida Console",Font.BOLD,11));          
            
             t_prec = new JTextField("");
             t_prec.setBounds(190,240,150,20);
            
                  
            //////Panel de Pedido//////                             
             //////Panel de Pedido//////  
             ///b_find = new JButton("...");
             ////b_find.setBounds(310,20,30,20);
             ///b_find.setToolTipText("Buscar Codigo...");
             //evento de boton
       //////////////////----------------------------------------------------////////////////////////      
            /* b_find.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                        Busca_Acces x = new Busca_Acces(new JDialog(),"127.0.0.1");
                       tabla.setDataVector(new Object [][] {
                {null,null ,null ,null },
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
                
            }, new String [] {
                "Codigo", "Descripcion", "Ejem.", "Lugar"
            });
                        t_cod.setText(x.Cod_back());      
                         event_bus(x.Cod_back());
                       p.load_tabla();
                 }});*/
//////////////////----------------------------------------------------////////////////////////     
             b_ok = new JButton("Agregar");
             b_ok.setBounds(183,210,150,20); 
             b_ok.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                    boolean conid = false;                    
                    
                    String data=null;
                        try{  
                    data =tabla.getValueAt(tab_p.getSelectedRow(),0).toString();  
                      }catch(Exception g){
                          if(conid==false){
                            JOptionPane.showMessageDialog(null,"Debe seleccionar un articulo.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
                            conid=true;    
                          }
                      }
                    if(conid==false&&p.getBan()){
                       if(JOptionPane.showConfirmDialog(null, "Desea agregar con choque?", "Mensaje", JOptionPane.YES_NO_OPTION) == 1){
                    conid=true;
                }     
                    }
                    if(conid==false){                     
                    System.out.println(data);
                    String[] aux2 = data.split("-");
                    String[] aux3 = sep_two(aux2[1]);
                    datos = new String[7];
                    String[] aux= Sep_Cod(aux2[0]);
                    datos[0]=aux[0];
                    datos[1]=aux[1];
                    datos[2]=aux[2];
                    datos[3]=aux[3];
                    datos[4] =aux3[0];
                    datos[5] =aux3[1];
                    datos[6]= t_prec.getText();
                   //Finalizar();
                    cargaArt();
                    }//fin if
                 }
             });
               //evento de boton
            t_prec.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {                   
                    if(e.getKeyCode()==10&&t_prec.getText().isEmpty()==false){
                    try {
                         float resul = Float.parseFloat(t_prec.getText());                        
                       
                     } catch (Exception a) {
                         JOptionPane.showMessageDialog(null,"El Precio solo debe poseer numeros.","Advetencia",JOptionPane.WARNING_MESSAGE);
                          
                     }
                }
                
                }
            });       
            tab_p = new JTable();
            tab_p.setBounds(10,10,470,200);
            tab_p.setModel(tabla);
            tab_p.setSelectionMode(0);
                        s_prin = new JScrollPane();
            
            s_prin.setBounds(10,20,460,180);
            s_prin.setViewportView(tab_p);
            
            //comando para no mover las columnas            
            tab_p.getTableHeader().setReorderingAllowed(false);
              tab_p.setSelectionMode(0);
              
          SelectionListener lis = new SelectionListener(tab_p,p);
            tab_p.getSelectionModel().addListSelectionListener(lis);
            tab_p.getColumnModel().getSelectionModel()
        .addListSelectionListener(lis);
     
            
            //
             
        
            
            //fija tamaño de las columnas de la tabla
           tama_colum();
            // Ancho_columnas();
            //
             p_prin.add(s_prin);
             p_prin.add(b_ok);
              b_ok.setVisible(true);
                           
           
             t_prec.setText("10");  
                                  
             return p_prin;
     }//fin load_Inter
     
     String[] Sep_Cod(String cod){
         String aux[] = new String[4];
        if(cod.length()==8||cod.length()==9){
                        aux[0] = cod.substring(0,2);
                        aux[1] = cod.substring(2,4);
                        aux[2] = cod.substring(4,6);
                        if(cod.length()==8){
                        aux[3] = cod.substring(6,8);                        
                        }else{
                        aux[3] = cod.substring(6,9);
                        }
                        aux[3] = verifi_4(aux[3]);
                        if(aux[3]==null){
                        JOptionPane.showMessageDialog(null,"Error En Codigo de Articulo","Error",JOptionPane.ERROR_MESSAGE);
                        
                        }else{
                                return aux;
                        }
        }else{
                JOptionPane.showMessageDialog(null,"Error En Codigo de Articulo","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
     }//fin funcion
     
     String verifi_4(String cod_t){
           String a1,a2;
           String a3="";
          if(cod_t.length()==2||cod_t.length()==3){
               
               if(cod_t.compareTo("00")==0){return cod_t;}
               
                a1 = cod_t.substring(0,1);
                a2 = cod_t.substring(1,2);         
                a2 = a2.toUpperCase();
                if(cod_t.length()==3){
                a3 = cod_t.substring(2,3);         
                a3 = a3.toUpperCase();
                }
                if(a1.charAt(0)=='0'){
                   return a2; 
                }else{
                    return a1.toUpperCase() + a2 + a3;
                }
           }//fin if general
        
            return null;
      }//fin funcion
     
   
     String[] Retorna_Cad(){
            return datos; 
     }
     
     void Finalizar(){
        dispose();
     }
 ////////////////////////////////////////////////////////////////
     void cargaArt(){
                    
                   //System.out.println(tab_p.getSelectedRow());
                   //System.out.println(tabla.getValueAt(tab_p.getSelectedRow(),0) );
                   //System.out.println(tabla.getValueAt(tab_p.getSelectedRow(),1) );                    
                   panelpedi.setdata(tabla.getValueAt(tab_p.getSelectedRow(),0).toString(),tabla.getValueAt(tab_p.getSelectedRow(),1).toString());
     
     }
 ///////////////////////////////////////////////////////////////    
          void event_bus(String code){
     
       String[] c =  Sep_Cod(code);   
       Object[][] dat = null;              
       con.conectar();
     if(t_cod.getText().isEmpty()==false){  
      ResultSet d = null;
      int cont = 0;
      
      try {
            if(c[3].compareTo("00")==0){
                d =con.consultar("select count(*) from accesorios d where d.taro_id="+c[0]+" and d.faro_id="+c[1]+" and d.caro_id="+c[2]+" and d.talla='0'");
            }
            else{
                d =con.consultar("select count(*) from accesorios d where d.taro_id="+c[0]+" and d.faro_id="+c[1]+" and d.caro_id="+c[2]+" and d.talla='"+c[3]+"'");
            }
            
            if(d!=null){
            d.next(); 
            cont =Integer.parseInt(d.getString(1)); 
            }//fin if
            } catch (Exception ex) {
           ex.printStackTrace();
        } 
      //inicializando objeto
      dat = new Object[cont][4];
               if(cont > 0){
          try {
              int cont2 = 0;
              String Consulta;
              if(c[3].compareTo("00")==0){
                Consulta = "select a.descripcion,a.id,b.descripcion,b.id,c.color1,c.color2,c.color3,c.id,d.talla,f.id,f.descripcion,d.num_ejemplar,e.descripcion from tipo_accesorios a, forma_accesorios b,color_accesorios c, accesorios d, ubicaciones e,marca_accesorios f where f.id=d.maro_id and a.id=d.taro_id and b.id=d.faro_id and c.id=d.caro_id and e.id=d.ubn_id and d.taro_id="+c[0]+" and d.faro_id="+c[1]+" and d.caro_id="+c[2]+" and d.talla='0' order by (d.num_ejemplar)";
              }
              else{
                  Consulta = "select a.descripcion,a.id,b.descripcion,b.id,c.color1,c.color2,c.color3,c.id,d.talla,f.id,f.descripcion,d.num_ejemplar,e.descripcion from tipo_accesorios a, forma_accesorios b,color_accesorios c, accesorios d, ubicaciones e,marca_accesorios f where f.id=d.maro_id and a.id=d.taro_id and b.id=d.faro_id and c.id=d.caro_id and e.id=d.ubn_id and d.taro_id="+c[0]+" and d.faro_id="+c[1]+" and d.caro_id="+c[2]+" and d.talla='"+c[3]+"' order by (d.num_ejemplar)";
              }
               d = con.consultar(Consulta);
              while(d!=null&&d.next()){    
              String cod2 = "-";
              
              if(d.getString(10).length()<2){
                    cod2=cod2+"0"+d.getString(10);
              }else{
              cod2=cod2+d.getString(10);
              }
              
              if(d.getString(12).length()<2){
                    cod2=cod2+"0"+d.getString(12);
              }else{
              cod2=cod2+d.getString(12);
              }
              
              dat[cont2][0] =t_cod.getText()+cod2;
              String colo="";
                     if(d.getString(5)!=null){
                        colo= colo+" "+d.getString(5);
                    }
                     if(d.getString(6)!=null){
                        colo= colo+" "+d.getString(6);
                    }
                     if(d.getString(7)!=null){
                        colo= colo+" "+d.getString(7);
                     }
                dat[cont2][1] = d.getString(1)+" "+d.getString(3)+" "+colo+" T_"+d.getString(9)+" "+d.getString(11);
                dat[cont2][2] = d.getString(12);
                dat[cont2][3] = d.getString(13);
                cont2++;
              }//fin while
          } catch (Exception e) {
             e.printStackTrace(); 
          }
          
           tabla.setDataVector(dat,new String [] {
                "Codigo", "Descripcion", "Ejem.", "Lugar"
            });  
          
          tama_colum();
          tab_p.setModel(tabla);
          tab_p.setDefaultRenderer(Object.class,new Render());
          tab_p.repaint();
          
               } //fin if cont > 0
     }//fin if general
       con.desconectar();
       //tab_p.setColumnSelectionInterval(0,0);
     }//fin event bus
          
  void tama_colum(){
  int anchoColumna=0;
  int ancho=460;
  TableColumnModel model = tab_p.getColumnModel();
  TableColumn t;
  for (int i = 0; i <tab_p.getColumnCount(); i++) {
            t = model.getColumn(i);
            switch (i){
                case 0:anchoColumna=(25*ancho)/100;break;
                case 1:anchoColumna=(50*ancho)/100;break;
                case 2:anchoColumna=(10*ancho)/100;break;    
                case 3:anchoColumna=(15*ancho)/100;break;                
            }//fin switch
            t.setPreferredWidth(anchoColumna);
            t.setResizable(false);
  }//fin for
  }//fin tama colum
  
  ////////////////////////////
  void setDatabus(String code){
  
                       tabla.setDataVector(new Object [][] {
                {null,null ,null ,null },
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
                
            }, new String [] {
                "Codigo", "Descripcion", "Ejem.", "Lugar"
            });
                        t_cod.setText(code);      
                         event_bus(code);
                         p.load_tabla();
  
  }
  ////////////////////////////
 DefaultTableModel_M getTablaModel(){
           return panelpedi.getTablaModel();
}
void setTableModel(DefaultTableModel_M t){
            panelpedi.setTablamodelo(t);
} 
  ////////////////////////////
  String[] sep_two(String dat){
      String[] vec = new String[2];   
      if(dat.length()==4){
            vec[0] = dat.substring(0,2);
            vec[1] = dat.substring(2,4);    
      }else{
      if(dat.length()==5){
            vec[0] = dat.substring(0,2);
            vec[1] = dat.substring(2,5);    

      }     
      }//fin else
 return vec;
  }
}