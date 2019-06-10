import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Busca_Acces extends JDialog{
 /**
	 * 
	 */
	private static final long serialVersionUID = 2003083745545611816L;

private JButton b_bus1,b_bus2,b_clear,b_ok;  

 private JPanel p_busc,p_buslis,p_look;
 private JCheckBox ch_busc,ch_buslis,ch_t_a,ch_f,ch_c,ch_t;
 private JTextField t_cod;
 private JComboBox c_t_a,c_f,c_c,c_t;
 private JList list;
 private JLabel l_cod,l_t_a,l_f,l_c,l_t;
 private Conexion bus;
 private JTable resul;
 private DefaultListModel lista; 
 private DefaultTableModel_M tabla = null;
 private JScrollPane s_lis;
 private String codigo=null;
 private ResultSet vali=null;
 
    public Busca_Acces(JFrame parent,String IpServer){        
       super(parent,true); 
       
       bus = new Conexion(IpServer);   
       
       Comen();
    }
     public Busca_Acces(JDialog parent,String IpServer){        
        super(parent,true); 
       bus = new Conexion(IpServer);   
       Comen();
    }
    void Comen(){
                vali=null;
                codigo="";
                setBounds(0,0,550,570);
                setLayout(null);
                setTitle("Busqueda de Accesorios");
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                setResizable(false);
                 /*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                 Dimension frameSize = getSize(); 
                 setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.width-50) / 2));*/
                
                /*Rectangle parentBounds = super.getParent().getBounds();
                Dimension size = getSize();
                int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
                int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
                setLocation(new Point(x, y));*/
                
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                setLocation((int)(d.getWidth()/2-getWidth()/2), (int)(d.getHeight()/2-getHeight()/2));
                
                 tabla = new DefaultTableModel_M(new Object [][] {
                {null,null ,null ,null ,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null}
                
            }, new String [] {
                "Codigo", "T. de Acces", "Forma", "Color","Talla","Marca","Disp"
            });
                 add(Busc_Cod());
                 add(Busc_Opc());
                 add(Look());
                 setVisible(true);  
    }
    
    JPanel Busc_Cod(){
            p_busc = new JPanel();
            p_busc.setBounds(60,10,420,70);
            p_busc.setLayout(null);
            p_busc.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Busqueda por Codigo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
            t_cod = new JTextField("");
            t_cod.setBounds(180,30,100,20);
            l_cod = new JLabel("Ingrese Codigo:");
            l_cod.setBounds(80,30,100,20);
            b_bus1 = new JButton("Buscar");
            b_bus1.setMnemonic('B');
            b_bus1.setBounds(290,30,90,20);
            
            //evento buscar 1 
            b_bus1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                       int vali = Veri_Cod();
                    if(vali==0){   
                       switch(t_cod.getText().length()){
                           case 2:{Consul_Cod(2,t_cod.getText());};break;
                           case 4:{Consul_Cod(4,t_cod.getText());};break;
                           case 6:{Consul_Cod(6,t_cod.getText());};break;
                           case 8:{Consul_Cod(8,t_cod.getText());};break;
                           case 9:{Consul_Cod(9,t_cod.getText());};break;
                       }// fin switch                      
                    }//fin if
                       if(t_cod.getText().isEmpty()){
                        Sqlc_cod("select a.descripcion,a.id,b.descripcion,b.id,c.color1,c.color2,c.color3,c.id,d.talla,(select count(id) from accesorios h where h.taro_id =a.id and h.faro_id=b.id and h.caro_id=c.id and h.talla=d.talla),(select count(id) from accesorios g where g.taro_id =a.id and g.faro_id=b.id and g.caro_id=c.id and g.talla=d.talla and g.ubn_id=1),f.id,f.descripcion from tipo_accesorios a, forma_accesorios b,color_accesorios c, accesorios d, ubicaciones e,marca_accesorios f where f.id=d.maro_id and a.id=d.taro_id and b.id=d.faro_id and c.id=d.caro_id and e.id=d.ubn_id and d.num_ejemplar='1' order by (a.id)","select count(*) from accesorios where num_ejemplar=1");
                       }                      
                }
            });
           //fin evento bucar 1 
            
            ch_busc = new JCheckBox();
            ch_busc.setBounds(10,30,20,20);
            ch_busc.setSelected(true);
            
            ch_busc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ChangeValue(e);
                }
            });
            
            p_busc.add(ch_busc);
            p_busc.add(b_bus1);
            p_busc.add(l_cod);
            p_busc.add(t_cod);
            return p_busc;
    }
     JPanel Busc_Opc(){
            p_buslis = new JPanel();
            p_buslis.setBounds(60,80,420,200);
            p_buslis.setLayout(null);
            p_buslis.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Busqueda por Filtros", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
            c_t_a = new JComboBox();
            c_t_a.setBounds(200,30,150,20);
            c_f = new JComboBox();
            c_f.setBounds(200,60,150,20);
            c_c= new JComboBox();
            c_c.setBounds(200,90,150,20);
            c_t = new JComboBox();
            c_t.setBounds(200,120,150,20);                      
            c_c.setEnabled(false);
            c_f.setEnabled(false);
            c_t.setEnabled(false);
            c_t_a.setEnabled(false);
            //cargando combobox
            this.Load_Combo();
            //fin carga
            b_bus2 = new JButton("Buscar");
            b_bus2.setMnemonic('B');
            b_bus2.setBounds(165,160,90,20);
            l_t_a = new JLabel("Tipo de Accesorios:");
            l_t_a.setBounds(70,30,150,20);
            l_f = new JLabel("Forma de Accesorios:");
            l_f.setBounds(70,60,150,20);
            l_c = new JLabel("Color de Accesorios:");
            l_c.setBounds(70,90,150,20);
            l_t = new JLabel("Talla de Accesorios:");
            l_t.setBounds(70,120,150,20);
            ch_t_a = new JCheckBox();
            ch_t_a.setBounds(40,30,20,20);
            ch_f = new JCheckBox();
            ch_f.setBounds(40,60,20,20);
            ch_c = new JCheckBox();
            ch_c.setBounds(40,90,20,20);
            ch_t = new JCheckBox();
            ch_t.setBounds(40,120,20,20);
            ch_buslis = new JCheckBox();
            ch_buslis.setBounds(10,75,20,20);
            ch_buslis.setSelected(false);
            ch_c.setEnabled(false);
            ch_f.setEnabled(false);
            ch_t.setEnabled(false);
            ch_t_a.setEnabled(false);
            b_bus2.setEnabled(false);
            
            b_bus2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Busc_Op();
                }
            });
            //evento
            ch_buslis.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ChangeValue(e);
                }
            });
            ch_t_a.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ChangeValue(e);
                }
            });
            ch_f.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ChangeValue(e);
                }
            });
            ch_c.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ChangeValue(e);
                }
            });
            ch_t.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ChangeValue(e);
                }
            });
            //fin evento
            p_buslis.add(ch_buslis);
            p_buslis.add(ch_t_a);
            p_buslis.add(ch_f);
            p_buslis.add(ch_c);
            p_buslis.add(ch_t);
            p_buslis.add(l_t_a);
            p_buslis.add(l_f);
            p_buslis.add(l_c);
            p_buslis.add(l_t);
            p_buslis.add(b_bus2);
            p_buslis.add(c_t_a);
             p_buslis.add(c_t);
              p_buslis.add(c_f);
               p_buslis.add(c_c);
            return p_buslis;
    }
        JPanel Look(){
            p_look = new JPanel();
            p_look.setBounds(10,280,525,250);
            p_look.setLayout(null);
            p_look.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Resultados", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
            b_clear = new JButton("Limpiar");
            b_clear.setMnemonic('L');
            b_clear.setBounds(330,210,90,20);
            b_ok = new JButton("Aceptar");
            b_ok.setMnemonic('A');
            b_ok.setBounds(100,210,90,20);
            //evento de botones
            b_ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try{
                   codigo = tabla.getValueAt(resul.getSelectedRow(),0).toString();
                   if(codigo==""){
                        JOptionPane.showMessageDialog(null,"Debe Realizar una busqueda.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
                   }else{
                    if(bus!=null){
                                    bus.desconectar();
                             }
                    System.out.println(codigo);
                             dispose();
                   }
                    }catch(Exception s){
                     JOptionPane.showMessageDialog(null,"Debe seleccionar un articulo.","Advertencia",JOptionPane.INFORMATION_MESSAGE);
                    }
                             
                        
                }
            });
            
            b_clear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                      tabla.setDataVector(new Object [][] {
                {null,null ,null ,null ,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null}
                
            }, new String [] {
                "Codigo", "T. de Acces", "Forma", "Color","Talla","Marca","Disp"
            });
                      
                       tama_colum();
                }
            }          
           
            
            );
            
            list = new JList();
            list.setBounds(15,20,495,160);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            //tabla
            resul = new JTable();
            resul.setBounds(15,20,495,180);
            resul.setSelectionMode(0);
            resul.getTableHeader().setReorderingAllowed(false);           
            resul.setModel(tabla);
             tama_colum();
            //
            s_lis = new JScrollPane();
            s_lis.setBounds(15,20,495,179);
            s_lis.setViewportView(resul);
            p_look.add(s_lis);
            p_look.add(b_ok);
            p_look.add(b_clear);
            return p_look;
    }
        void Load_Combo(){
         String a = "";
           if(bus.conectar()==1){
           try {
                ResultSet data = bus.consultar("select id,descripcion from tipo_accesorios order by id");
                
                while(data!=null && data.next()){
                    if(Integer.parseInt(data.getString(1))<10){
                            a="0";
                    }else{
                        a="";
                    }
                    c_t_a.addItem(a+data.getString(1)+" "+data.getString(2));
                }
                
                data = bus.consultar("select id,descripcion from FORMA_ACCESORIOS order by id");
               
                
                 while(data!=null && data.next()){
                    if(Integer.parseInt(data.getString(1))<10){
                            a="0";
                    }else{
                        a="";
                    }
                    c_f.addItem(a+data.getString(1)+" "+data.getString(2));
                }
                data = bus.consultar("select id,color1,color2,color3 from COLOR_ACCESORIOS order by id");
               
                 while(data!=null && data.next()){
                    if(Integer.parseInt(data.getString(1))<10){
                            a="0";
                    }else{
                        a="";
                    }
                    if(data.getString(3)==null&&data.getString(4)==null){
                    c_c.addItem(a+data.getString(1)+" "+data.getString(2));
                    }//fin if
                    if(data.getString(3)!=null&&data.getString(4)==null){
                    c_c.addItem(a+data.getString(1)+" "+data.getString(2)+"_"+data.getString(3));
                    }//fin if
                    if(data.getString(3)!=null&&data.getString(4)!=null){
                    c_c.addItem(a+data.getString(1)+" "+data.getString(2)+"_"+data.getString(3)+"_"+data.getString(4));
                    }//fin if
                    }//fin while
                 
                data = bus.consultar("select distinct talla from accesorios order by (talla) desc");
                while(data!=null&&data.next()){
                        c_t.addItem(data.getString(1));
                }//fin while
                bus.desconectar();
                
                
           } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error en Conexion de Base de Datos","Advertencia",JOptionPane.WARNING_MESSAGE);
                   
           }
           }else{
                    JOptionPane.showMessageDialog(null,"Error en Conexion de Base de Datos","Advertencia",JOptionPane.WARNING_MESSAGE);
           }//fin load combo
           }
        
          int Veri_Cod(){
               
                       
                        if(t_cod.getText().length()==1||t_cod.getText().length()==3||t_cod.getText().length()==5||t_cod.getText().length()==7){
                            JOptionPane.showMessageDialog(null,"El Codigo debe ser de cantidad par (01,0102,020302)","Error",JOptionPane.ERROR_MESSAGE);
                                return 1;
                        }
                        if(t_cod.getText().length()>9){
                            JOptionPane.showMessageDialog(null,"El Codigo esta compuesto por Ocho(9) digitos." ,"Error",JOptionPane.ERROR_MESSAGE);
                                return 1;
                        }
                        
                        return 0;
           }//Veri_Cod
        
     void Consul_Cod(int n,String cod){
        String codes[] = new String[5];   
        String query = "select a.descripcion,a.id,b.descripcion,b.id,c.color1,c.color2,c.color3,c.id,d.talla,(select count(id) from accesorios h where h.taro_id =a.id and h.faro_id=b.id and h.caro_id=c.id and h.talla=d.talla),(select count(id) from accesorios g where g.taro_id =a.id and g.faro_id=b.id and g.caro_id=c.id and g.talla=d.talla and g.ubn_id=1),f.id,f.descripcion from tipo_accesorios a, forma_accesorios b,color_accesorios c, accesorios d, ubicaciones e,marca_accesorios f where f.id=d.maro_id and a.id=d.taro_id and b.id=d.faro_id and c.id=d.caro_id and e.id=d.ubn_id and d.num_ejemplar='1'";
         String adic = "select count(*) from accesorios d where d.num_ejemplar=1 ";      
        if(n==2){
                        codes[0] = cod.substring(0,2);
                       Sqlc_cod(query+" and d.TARO_ID="+codes[0],adic+" and d.TARO_ID="+codes[0]);
                }//fin if
                if(n==4){
                        codes[0] = cod.substring(0,2);
                        codes[1] = cod.substring(2,4);
                        Sqlc_cod(query+" and d.TARO_ID="+codes[0]+" and d.FARO_ID="+codes[1],adic+" and d.TARO_ID="+codes[0]+" and d.FARO_ID="+codes[1]);
                }//fin if
                if(n==6){
                        codes[0] = cod.substring(0,2);
                        codes[1] = cod.substring(2,4);
                        codes[2] = cod.substring(4,6);
                        Sqlc_cod(query+" and d.TARO_ID="+codes[0]+" and d.FARO_ID="+codes[1]+" and d.CARO_ID="+codes[2],adic+" and d.TARO_ID="+codes[0]+" and d.FARO_ID="+codes[1]+" and d.CARO_ID="+codes[2]);
                }//fin if
                 if(n==8||n==9){
                        codes[0] = cod.substring(0,2);
                        codes[1] = cod.substring(2,4);
                        codes[2] = cod.substring(4,6);
                        if(n==8){
                        codes[3] = cod.substring(6,8);
                        codes[3] = verifi_talla(codes[3]);
                        }else{
                        codes[3] = cod.substring(6,9);
                        codes[3] = verifi_talla(codes[3]);
 
                        }
                        if(codes[3] == null){
                                JOptionPane.showMessageDialog(null,"Error al Evaluar Talla en codigo.","Error",JOptionPane.ERROR_MESSAGE);
                        }
                       Sqlc_cod(query+" and d.TARO_ID="+codes[0]+" and d.FARO_ID="+codes[1]+" and d.CARO_ID="+codes[2]+" and d.talla='"+codes[3]+"'",adic+" and d.TARO_ID="+codes[0]+" and d.FARO_ID="+codes[1]+" and d.CARO_ID="+codes[2]+" and d.talla='"+codes[3]+"'");
                }//fin if
     }//fin void consulta  
     
     void Sqlc_cod(String consulta,String consulta2){
            setLista(new DefaultListModel());
            int value = 0;
            Object[][] data = null;
            ResultSet dat = null;
            try {
                bus.conectar();
                try {
                     dat = bus.consultar(consulta2);
                     dat.next();
                     value = Integer.parseInt(dat.getString(1));
                     dat = bus.consultar(consulta);                  
                 
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null,"Error en Codigo Introducido","Error",JOptionPane.ERROR_MESSAGE);
                }
             
            data = new Object[value][6];
            int conta=0;
              while(dat!=null&&dat.next()){  
                  
                    String color = "";
                    String ceros[] = {"","","",""};
                    if(Integer.parseInt(dat.getString(2))<10){
                            ceros[0] = "0";
                    }
                    if(Integer.parseInt(dat.getString(4))<10){
                            ceros[1] = "0";
                    }
                    if(Integer.parseInt(dat.getString(8))<10){
                            ceros[2] = "0";
                    }
                    if(dat.getString(9).length()<3&&dat.getString(9).length()<2){
                            ceros[3] = "0";
                    }
                    
                    if(dat.getString(6)!=null){
                        color=color+" "+dat.getString(6);
                    }
                    if(dat.getString(7)!=null){
                        color=color+" "+dat.getString(7);
                    }
                    data[conta][0] = ceros[0]+dat.getString(2)+ceros[1]+dat.getString(4)+ceros[2]+dat.getString(8)+ceros[3]+dat.getString(9);
                    data[conta][1]=dat.getString(1);
                    data[conta][2]=dat.getString(3);
                    data[conta][3]=dat.getString(5)+color;
                    data[conta][4]=dat.getString(9);  
                    data[conta][5]=dat.getString(11)+"("+dat.getString(10)+")";  
              
           conta++;
              }//fin while 
              System.out.println(conta);
             
             tabla.setDataVector(data,new String [] {
                "Codigo", "T. de Acces.", "Forma", "Color","Talla","Disp."
            });
             tama_colum();
              bus.desconectar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error en Codigo Introducido","Error",JOptionPane.ERROR_MESSAGE);
            }//fin Try
            
     }
     void ChangeValue(ActionEvent e){
            if(e.getSource()==ch_buslis){
                    if(ch_buslis.isSelected()==true){
                            ch_busc.setSelected(false);
                            CambioVal(true);
                            ch_t_a.setSelected(true);
                            c_t_a.setEnabled(true);
                    }
                    if(ch_busc.isSelected()!=true){
                        ch_buslis.setSelected(true);
                    }
            }//fin if
            if(e.getSource()==ch_busc){
                    if(ch_busc.isSelected()==true){
                            ch_buslis.setSelected(false);
                            CambioVal(false);
                             ch_t_a.setSelected(false);
                             ch_t.setSelected(false);
                             ch_f.setSelected(false);
                             ch_c.setSelected(false);
                             c_t_a.setEnabled(false);
                             c_c.setEnabled(false);
                            c_f.setEnabled(false);
                            c_t.setEnabled(false);
                            c_t_a.setEnabled(false);
                    }
                    if(ch_buslis.isSelected()!=true){
                        ch_busc.setSelected(true);
                    }
            }//fin if
            if(e.getSource()==ch_t_a){
                
                if(ch_t_a.isSelected()==true){
                        c_t_a.setEnabled(true);
                }else{
                        c_t_a.setEnabled(false);
                }   
                
              if(ch_t_a.isSelected()==false){
                    ch_c.setSelected(false);
                    ch_f.setSelected(false);
                    ch_t.setSelected(false);
                    c_c.setEnabled(false);
                    c_f.setEnabled(false);
                    c_t.setEnabled(false);
                    
              }
            }//fin if
            if(e.getSource()==ch_f){
                 if(ch_t_a.isSelected()==false){
                        ch_f.setSelected(false);
                }else{
                if(ch_f.isSelected()==true){
                        c_f.setEnabled(true);
                }else{
                        c_f.setEnabled(false);
                }
                if(ch_t_a.isSelected()==false){
                        ch_f.setSelected(false);
                }
                }//fin else
            }//fin if
            if(e.getSource()==ch_c){
                if(ch_t_a.isSelected()==false){
                        ch_c.setSelected(false);
                }else{
                if(ch_c.isSelected()==true){
                        c_c.setEnabled(true);
                }else{
                        c_c.setEnabled(false);
                }}//fin else
            }//fin if
            if(e.getSource()==ch_t){
                if(ch_t_a.isSelected()==false){
                        ch_t.setSelected(false);
                }else{
                if(ch_t.isSelected()==true){
                        c_t.setEnabled(true);
                }else{
                        c_t.setEnabled(false);
                }}//fin else
            }//fin if
     }//fin funcion
      void CambioVal(boolean en){
            
            ch_c.setEnabled(en);
            ch_f.setEnabled(en);
            ch_t.setEnabled(en);
            ch_t_a.setEnabled(en);
           
            c_t_a.setEnabled(en);
            b_bus2.setEnabled(en);
            b_bus1.setEnabled(!en);
            l_cod.setEnabled(!en);
            t_cod.setEnabled(!en);
      }//fin funcion
      String verifi_talla(String cod_t){
           String a1,a2;
           String a3="";
          if(cod_t.length()==2||cod_t.length()==3){
                a1 = cod_t.substring(0,1);
                a2 = cod_t.substring(1,2);
                if(cod_t.length()==3){
                  a3 = cod_t.substring(2,3);
                  a3 = a3.toUpperCase();
                }//fin if
                a2 = a2.toUpperCase();
                if(a1.charAt(0)=='0'){
                   return a2; 
                }else{
                    return a1.toUpperCase() + a2 + a3;
                }
           }//fin if general
        
            return null;
      }//fin funcion
      
   void Busc_Op(){
      String code[] = new String[4];
      String aux[]=new String[3];
      String consul = "select a.descripcion,a.id,b.descripcion,b.id,c.color1,c.color2,c.color3,c.id,d.talla,(select count(id) from accesorios h where h.taro_id =a.id and h.faro_id=b.id and h.caro_id=c.id and h.talla=d.talla),(select count(id) from accesorios g where g.taro_id =a.id and g.faro_id=b.id and g.caro_id=c.id and g.talla=d.talla and g.ubn_id=1),f.id,f.descripcion from tipo_accesorios a, forma_accesorios b,color_accesorios c, accesorios d, ubicaciones e,marca_accesorios f where f.id=d.maro_id and a.id=d.taro_id and b.id=d.faro_id and c.id=d.caro_id and e.id=d.ubn_id and d.num_ejemplar='1' "; 
        if(ch_t_a.isSelected()==true&&ch_t.isSelected()==false&&ch_f.isSelected()==false&&ch_c.isSelected()==false){
            code = c_t_a.getSelectedItem().toString().split(" ");
            System.out.println(code[0]);
           Consul_Cod(code[0].length(),code[0]);
        }else{
        if(ch_t_a.isSelected()==true){
            aux = c_t_a.getSelectedItem().toString().split(" ");
            code[0] = " and d.TARO_ID="+aux[0];
        }else{
            code[0]="";
        }//fin if-else  
          
        if(ch_f.isSelected()==true){
            aux = c_f.getSelectedItem().toString().split(" ");
            code[1] = " and d.FARO_ID="+aux[0];
        }else{
            code[1]="";
        }//fin if-else
        
        if(ch_c.isSelected()==true){
            aux = c_c.getSelectedItem().toString().split(" ");
            code[2] = " and d.CARO_ID="+aux[0];
        }else{
            code[2]="";
        }//fin if-else
        
        if(ch_t.isSelected()==true){
            aux[0] = c_t.getSelectedItem().toString();
            
            if(aux[0].length()<2){
                aux[0]="0"+aux[0];
            }
            
            aux[0] =verifi_talla(aux[0]); 
            code[3] = " and d.talla='"+aux[0]+"'";
        }else{
            code[3]="";
        }//fin if-else
                 
            consul = consul+code[0]+code[1]+code[2]+code[3];
          
           Sqlc_cod(consul,"select count(*) from accesorios d where d.num_ejemplar=1 "+code[0]+code[1]+code[2]+code[3]);
            
        }//fin else
   }//fin funcion
   String Cod_back(){
    return codigo;
   }
   ResultSet get_resul(){
            return vali;
   }
   
  void tama_colum(){
  int anchoColumna=0;
  int ancho=495;
  TableColumnModel model = resul.getColumnModel();
  TableColumn t;
  for (int i = 0; i <resul.getColumnCount(); i++) {
            t = model.getColumn(i);
            switch (i){
                case 0:anchoColumna=(15*ancho)/100;break;
                case 1:anchoColumna=(15*ancho)/100;break;
                case 2:anchoColumna=(23*ancho)/100;break;    
                case 3:anchoColumna=(23*ancho)/100;break;
                case 4:anchoColumna=(10*ancho)/100;break;
                case 5:anchoColumna=(14*ancho)/100;break;
            }//fin switch
            t.setPreferredWidth(anchoColumna);
            t.setResizable(false);
  }//fin for
  }//fin tama colum
public void setLista(DefaultListModel lista) {
	this.lista = lista;
}
public DefaultListModel getLista() {
	return lista;
}
   
}
//Arreglar de que no se introduzcan letras
//d/at2 = bus.consultar("select (select count(id) from accesorios h where h.taro_id =a.id and h.faro_id=b.id and caro_id=c.id and h.talla=d.talla),(select count(id) from accesorios where taro_id =" + dat.getString(2) + " and faro_id=" + dat.getString(4) + " and caro_id=" + dat.getString(8) + " and talla='" + dat.getString(9) + "'and ubn_id=1 ) from dual");
    //        dat2.next(); 