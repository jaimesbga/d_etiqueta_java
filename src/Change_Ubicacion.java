import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;



public class Change_Ubicacion extends JDialog{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Conexion chan; 
    private JComboBox c_op;
    private JPanel p_prin;
    private JButton b_bus,b_save,b_close;
    private JLabel l_cod,l_ubicacion;
    private JTextField t_cod;
    private JTable tab_p;
    private JScrollPane s_prin;
    private DefaultTableModel_M tabla = null;   
    /** Creates a new instance of Change_Ubicacion */
    public Change_Ubicacion(JFrame parent,String IpServer) {
          super(parent,true); 
          chan = new Conexion(IpServer);  
          Inicializar();
       
      }
      public Change_Ubicacion(JDialog parent,String IpServer) {
              super(parent,true); 
              chan = new Conexion(IpServer);  
              Inicializar();
       
      }
      void Inicializar(){
                 setBounds(0,0,600,390);
                setLayout(null);
                setTitle("Mover Accesorio");
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                setResizable(false);
                 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                 Dimension frameSize = getSize(); 
                 setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.height) / 2));
                 tabla = new DefaultTableModel_M(new Object [][] {
                {null,null ,null ,null },
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},               
                {null, null, null, null}    
            },
            new String [] {
                "Codigo", "Descripcion", "Ejemplar", "Ubicacion"
            });
                 add(Panel_prin());                 
                 setVisible(true);
      }//fin inicializar 
          
       JPanel Panel_prin(){
            p_prin =  new JPanel();
            p_prin.setBounds(10,10,575,340);
            p_prin.setLayout(null);
            p_prin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Mover Ubicacion de Articulo.", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
            t_cod = new JTextField();
            t_cod.setBounds(210,50,150,20);
            t_cod.setEditable(false);
            b_bus = new JButton("...");
            b_bus.setBounds(360,50,20,20);
            
            //evento del Boton
            b_bus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   event_bus(1);
                   c_op.setEnabled(true);
                }
            });
            
            b_bus.setToolTipText("Buscar Codigo de Articulo...");
            b_close = new JButton("Cerrar");
            b_close.setMnemonic('C');
            b_close.setBounds(290,300,150,20);
            b_close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        //    String[] item ={"01-Tienda","02-Tintoreria","03-Sastreria"}; 
            chan.conectar();
            ResultSet dat = chan.consultar("select count(*) from ubicaciones");
       int auc = 0;
            try {
            dat.next();
             auc = Integer.parseInt(dat.getString(1));
        } catch (Exception ex) {         
        }
          String[] item = new String[auc];  
          
          dat = chan.consultar("select descripcion from ubicaciones order by id asc ");  
          int conta = 0;
          try {
              while(dat!=null&&dat.next()){
                  String g = "";
                  if(conta<10){
                    g = "0";
                  }else{
                  g = "";
                  }
                   item[conta] = g+(conta+1)+" - "+dat.getString(1);
                   conta++;
              }//fin while
          } catch (Exception e) {             
          }
          
          chan.desconectar();
            c_op = new JComboBox(item);
            c_op.setBounds(250,250,150,20);
            l_ubicacion = new JLabel("Ubicacion: ");            
            l_ubicacion.setBounds(180,250,150,20);
            b_save = new JButton("Guardar Cambios");
            b_save.setMnemonic('G');
            b_save.setBounds(130,300,150,20);
            b_save.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        event_save();
                }
            });
            l_cod = new JLabel("Nº de Codigo: ");            
            l_cod.setBounds(130,50,150,20);
            tab_p = new JTable();
            tab_p.setBounds(10,10,540,200);
            tab_p.setModel(tabla);
            tab_p.setDefaultRenderer(Object.class,new Render());
            tab_p.setSelectionMode(0); 
            tab_p.getTableHeader().setReorderingAllowed(false);  
            
           tama_colum();             
            c_op.setEnabled(false);
            
            s_prin = new JScrollPane();
            s_prin.setBounds(20,80,540,147);
            s_prin.setViewportView(tab_p);
            p_prin.add(c_op);
            p_prin.add(s_prin);
            p_prin.add(t_cod);
             p_prin.add(l_ubicacion);
            p_prin.add(l_cod);
            p_prin.add(b_bus);
            p_prin.add(b_close);
            p_prin.add(b_save);
            return p_prin;    
       }//fin pane
       void event_bus(int op){
          String[] c=null;
          
        if(op==1){
       Busca_Acces aux = new Busca_Acces(new JDialog(),"127.0.0.1");
        c =  Sep_Cod(aux.Cod_back()); 
       t_cod.setText(aux.Cod_back()); 
           }else{
            c = Sep_Cod(t_cod.getText());   
           }//fin else
       Object[][] dat = null; 
             
       chan.conectar();
     if(t_cod.getText().isEmpty()==false){  
      ResultSet d = null;
      int cont = 0;
      
      try {
            d = chan.consultar("select count(*) from accesorios d where d.taro_id="+c[0]+" and d.faro_id="+c[1]+" and d.caro_id="+c[2]+" and d.talla='"+c[3]+"'");
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
              String Consulta = "select a.descripcion,a.id,b.descripcion,b.id,c.color1,c.color2,c.color3,c.id,d.talla,f.id,f.descripcion,d.num_ejemplar,e.descripcion from tipo_accesorios a, forma_accesorios b,color_accesorios c, accesorios d, ubicaciones e,marca_accesorios f where f.id=d.maro_id and a.id=d.taro_id and b.id=d.faro_id and c.id=d.caro_id and e.id=d.ubn_id and d.taro_id="+c[0]+" and d.faro_id="+c[1]+" and d.caro_id="+c[2]+" and d.talla='"+c[3]+"' order by(d.num_ejemplar)";
               d = chan.consultar(Consulta);
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
                "Codigo", "Descripcion", "Ejemplar", "Ubicacion"
            });  
          tama_colum();
          tab_p.setDefaultRenderer(Object.class,new Render()); 
               } //fin if cont > 0
     }//fin if general
       chan.desconectar();
     }//fin event bus
       
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
        }//fin if
        return null;
     }//fin funcion
        
     String verifi_4(String cod_t){
           String a1,a2;
           String a3="";
          if(cod_t.length()==2||cod_t.length()==3){
               
               if(cod_t.compareTo("00")==0){return cod_t; }
               
                a1 = cod_t.substring(0,1);
                a2 = cod_t.substring(1,2);         
                a2 = a2.toUpperCase();
                if(cod_t.length()==3){
                  a3 = cod_t.substring(2,3);
                  a3 = a3.toUpperCase();
                }//fin if
                if(a1.charAt(0)=='0'){
                   return a2; 
                }else{
                    return a1.toUpperCase() + a2+a3;
                }
           }//fin if general
        
            return null;
      }//fin funcion   
   void tama_colum(){
  int anchoColumna=0;
  int ancho=540; 
  TableColumnModel model = tab_p.getColumnModel();
  TableColumn t;
  
  for (int i = 0; i <tab_p.getColumnCount(); i++) {
            t = model.getColumn(i);
            switch (i){
                case 0:anchoColumna=(20*ancho)/100;break;
                case 1:anchoColumna=(55*ancho)/100;break;
                case 2:anchoColumna=(10*ancho)/100;break;    
                case 3:anchoColumna=(15*ancho)/100;break;               
            }//fin switch
            t.setPreferredWidth(anchoColumna);
            t.setResizable(false);
            
  }//fin for
  }//fin tama colum
   
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
   
   @SuppressWarnings("unused")
   void event_save(){
       String cod=null;
       boolean vali=false;
       try {
           cod = tabla.getValueAt(tab_p.getSelectedRow(),0).toString();
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Debe seleccionar un articulo.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
            vali=true;
       }
       
       if(!vali){
                String[] data = cod.split("-");
                String[] aux = this.Sep_Cod(data[0]);                
                String[] aux1 = this.sep_two(data[1]);
                String ubi=null;
                chan.conectar();
               
			String consul="update accesorios  set ubn_id="+String.valueOf(c_op.getSelectedIndex())+" where taro_id="+aux[0]+" and faro_id="+aux[1]+" and caro_id="+aux[2]+" and talla='"+aux[3]+"' and maro_id="+aux1[0]+" and num_ejemplar="+aux1[1];
                       
               String[] d = c_op.getSelectedItem().toString().split("-");
               
               ubi = d[0];
               
               int row = tab_p.getSelectedRow();
               if(row>=0){
               String xx = tabla.getValueAt(row,3).toString();
                            if(xx.compareToIgnoreCase("Cliente")==0){
                             JOptionPane.showMessageDialog(null,"No puede modificar la ubicacion Cliente desde esta aplicacion.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
                              }   else{
                                 if(ubi.indexOf("04")>=0){
                                JOptionPane.showMessageDialog(null,"No puede modificar la ubicacion Cliente desde esta aplicacion.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
                                  chan.desconectar();
                               }else{
                               int bol = chan.actualizar("update accesorios  set ubn_id="+ubi+" where taro_id="+aux[0]+" and faro_id="+aux[1]+" and caro_id="+aux[2]+" and talla='"+aux[3]+"' and maro_id="+aux1[0]+" and num_ejemplar="+aux1[1]);
                               event_bus(0);
                               }//fin else 
                               }//fin if
                              
                              
                              }//fin else            
               
               
               }//fin if              
               
               
               
             
   }//fin funcion
}

