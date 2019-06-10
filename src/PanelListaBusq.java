import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class PanelListaBusq extends JPanel implements ActionListener{
    private int xpos;
    private int ypos;
    private JButton agregar;
    private JList tipo,forma,color,talla;
    private JScrollPane tp,foma,colo,tall;
    private Conexion conex;
    private String DirIP;
    private JLabel l_tipo,l_forma,l_color,l_talla;
    private Pre_Cant control_cod;
    
    private String formaSel, colorSel;
    
    /** Creates a new instance of PanelListaBusq */
    public PanelListaBusq(int x,int y,String Ip,Pre_Cant Control) {        
        super(true);
        control_cod = Control;
        xpos = x;
        ypos = y;
        DirIP = Ip;
        
        formaSel = "";
        colorSel = "";
        
        this.InicializarPanel();
    }
//*************************************************************////////    
    
     DefaultListModel getDatosForma(String shear){
            DefaultListModel datos = new DefaultListModel();
            //Vector a = new Vector();
            
             String query;            
              java.sql.ResultSet res = null;
        try {
           // res.next();        
            String aux = shear;
            //System.out.println(aux);            
            query = "select DESCRIPCION,ID from FORMA_ACCESORIOS  where id IN (select distinct FARO_ID from accesorios  where TARO_ID ="+aux+")";
            // System.out.println(query);
            res = conex.consultar(query);
            while(res.next()){
               datos.addElement(res.getString(2)+" - "+res.getString(1));                 
            }
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            return datos;
        
    }
  /////////////////////////////////////////////////////////////////////////////
     DefaultListModel getDatosColor(String tip,String form){
         DefaultListModel datos = new DefaultListModel();
         
         //String query = "select ID from tipo_accesorios where DESCRIPCION ='"+tip+"'";            
         String query;
         java.sql.ResultSet res = null; 
                 //conex.consultar(query);
        try {
           // res.next(); 
            String cod_t = tip;              
            //query = "select ID from forma_accesorios where DESCRIPCION ='"+form+"'";
            //res = conex.consultar(query);
            //res.next();
            String cod_f = form;
            /////Consult Powered
            query = "select COLOR1,COLOR2,COLOR3,ID from COLOR_ACCESORIOS where ID IN (select distinct a.CARO_ID from accesorios a where a.TARO_ID ="+cod_t+" AND a.FARO_ID ="+cod_f+")";
            res = conex.consultar(query);
            while(res.next()){
            String colores = res.getString(1);
                if(res.getString(2)!=null){colores = colores+"_"+res.getString(2);}
                if(res.getString(3)!=null){colores = colores+"_"+res.getString(3);}
            colores = res.getString(4)+" - "+colores; 
                datos.addElement(colores);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
        
         return datos;
     }
  /////////////////////////////////////////////////////////////////////////////  
     DefaultListModel getDatosTalla(String c_tipo,String c_forma,String c_color){
            DefaultListModel datos = new DefaultListModel();
            String query = "SELECT DISTINCT TALLA FROM ACCESORIOS WHERE TARO_ID = "+c_tipo+" AND FARO_ID = "+c_forma+" AND CARO_ID = "+c_color+" ORDER BY (TALLA) DESC";
            java.sql.ResultSet res = null;
            
            try {
                    res = conex.consultar(query);
                    while(res.next()){
                        datos.addElement(res.getString(1));
                    }
            } catch (Exception ex) {
                
            }
            
            return datos;     
     }
      /////////////////////////////////////////////////////////////////////////////
    void InicializarPanel(){
        this.setToolTipText("Busqueda de Accesorios");
        this.setBounds(xpos,ypos,500,240);  
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Seleccionar Articulo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        this.setVisible(true);
        conex = new Conexion(DirIP);
        conex.conectar();
        ///****Listas*****///              
        tp = new JScrollPane();
        tp.setBounds(10,40,120,180);        
        foma = new JScrollPane();
        foma.setBounds(140,40,110,180);
        colo = new JScrollPane();
        colo.setBounds(260,40,140,180);
        tall = new JScrollPane();
        tall.setBounds(410,40,80,180);
        tipo = new JList();
        tipo.setBounds(20,40,150,180);
        tipo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        forma = new JList();
        forma.setBounds(180,40,150,180);
        forma.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        forma.setForeground(Color.RED);
        color = new JList();
        color.setBounds(340,40,150,180);
        color.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       // color.setForeground(Color.GREEN);
        talla = new JList();
        talla.setBounds(500,40,80,180);
        talla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //talla.setForeground(Color.LIGHT_GRAY);
        tipo.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                   int value = getSelectIndex(tipo);    
                   
                   forma.setModel(new DefaultListModel());
                   color.setModel(new DefaultListModel());
                   talla.setModel(new DefaultListModel());
                if(e.getSource()==tipo){
                      String[] val = tipo.getModel().getElementAt(value).toString().split(" - "); 
                       forma.setModel(getDatosForma(val[0]));   
                }         
                if(formaSel!= null && !formaSel.isEmpty()){
                       forma.setSelectedValue(formaSel, true);
                }
                   
            }
        });
        
        forma.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged (ListSelectionEvent e){
            
                int val1 = getSelectIndex(tipo);
                int val2 = getSelectIndex(forma);
               // System.out.println(val1+"  "+val2);   
                color.setModel(new DefaultListModel());
                talla.setModel(new DefaultListModel());
                try {
                    String[] s1 = tipo.getModel().getElementAt(val1).toString().split(" - ");
                    String[] s2 = forma.getModel().getElementAt(val2).toString().split(" - ");
                        color.setModel(getDatosColor(s1[0],s2[0]));  
                } catch (Exception s) {
                    System.out.println("MEFORMA");
                }
                              
               try{
                   if(forma.getSelectedIndex()>=0){
                        formaSel = forma.getSelectedValue().toString();
                   }
               }
               catch(Exception ex){
                 formaSel = "";
               }
                
               if(colorSel!= null && !colorSel.isEmpty()){
                       color.setSelectedValue(colorSel, true);
                }            
            }
        });
        
        color.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                        int val1 = getSelectIndex(tipo);
                        int val2 = getSelectIndex(forma);
                        int val3 = getSelectIndex(color);
                        
                        
                        try {
                         String[] s1 = tipo.getModel().getElementAt(val1).toString().split(" - ");
                         String[] s2 = forma.getModel().getElementAt(val2).toString().split(" - ");
                         String[] s3 = color.getModel().getElementAt(val3).toString().split(" - ");
                         talla.setModel(getDatosTalla(s1[0],s2[0],s3[0]));   
                        } catch (Exception es) {
                            System.out.println("MECOLOR");
                        }
                        
                        try{
                            if(color.getSelectedIndex()>=0){
                                colorSel = color.getSelectedValue().toString();
                            }
                        }
                        catch(Exception ex){
                            colorSel = "";
                        }
            }
        });
        
        
        talla.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String cod = null;
                        int val1 = getSelectIndex(tipo);
                        int val2 = getSelectIndex(forma);
                        int val3 = getSelectIndex(color);
                        int val4 = getSelectIndex(talla);
                        
                        try {
                         String[] s1 = tipo.getModel().getElementAt(val1).toString().split(" - ");
                         s1[0] = validaCod(s1[0]);
                         String[] s2 = forma.getModel().getElementAt(val2).toString().split(" - ");
                         s2[0] = validaCod(s2[0]);
                         String[] s3 = color.getModel().getElementAt(val3).toString().split(" - ");
                         s3[0] = validaCod(s3[0]);
                         String[] s4 = talla.getModel().getElementAt(val4).toString().split(" - ");  
                         s4[0] = validaCod(s4[0]);
                         /*if(s4[0].compareTo("0")!=0){
                             s4[0] = validaCod(s4[0]);
                         }*/
                         cod = s1[0]+s2[0]+s3[0]+s4[0];
                         System.out.println(cod);
                         /////---------------------------/////Manejo se codigo para clase Pre_cant
                         control_cod.setDatabus(cod);
                         
                        } catch (Exception es) {
                            System.out.println("METALLA");
                        }
            
            }
        });
        
        l_tipo = new JLabel("TIPO:");
        l_tipo.setBounds(10,20,100,20);
        l_tipo.setForeground(Color.BLUE);
        l_forma = new JLabel("FORMA:");
        l_forma.setBounds(140,20,100,20);
        l_forma.setForeground(Color.BLUE);
        l_color = new JLabel("COLOR:");
        l_color.setBounds(260,20,100,20);
        l_color.setForeground(Color.BLUE);
        l_talla = new JLabel("TALLA:");
        l_talla.setBounds(410,20,100,20);
        l_talla.setForeground(Color.BLUE);
        this.add(l_tipo);
        this.add(l_forma);
        this.add(l_color);
        this.add(l_talla);
        
        tp.setViewportView(tipo);
        foma.setViewportView(forma);
        colo.setViewportView(color);
        //colo.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tall.setViewportView(talla);
        
        this.LoadlistPrin();
        ///****Listas*****///
        
        
        this.add(tp);
        this.add(foma);
        this.add(colo);
        this.add(tall);
      
        
    }
///////////////////////////////////////////////////////////////////////////////    
String validaCod(String cod){
        if(cod.length()==2 || cod.length()==3){
                return cod;
        }
        /*if(cod.length()==1 && cod.compareTo("0")==0){
                return "0";
        }*/
        if(cod.length()==1){
                cod = "0"+cod;
        }
        return cod;
}    
/////////////////////////////////////////////////////////
int getSelectIndex(JList lista){
            int minselec = lista.getMinSelectionIndex();
                            int maxselec = lista.getMaxSelectionIndex();
                    int value=0;
                for(int i = minselec; i<=maxselec;i++){
                    if(lista.isSelectedIndex(i)){
                        value = i;
                    }//fin if
           }//fin for   
                    
                    return value;
}

//////////////////////////////////////////////////////
    void LoadlistPrin(){
        DefaultListModel data = new DefaultListModel();
        
             String query = "select DESCRIPCION,ID from tipo_accesorios ";
              java.sql.ResultSet res = conex.consultar(query);
        try {
            while(res.next()){
                     data.addElement(res.getString(2)+" - "+res.getString(1));  
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tipo.setModel(data);
    }
    
//*************************************************************////////

///////////////////////////////////////////////////////////////////////    
    public void actionPerformed(ActionEvent e) {
    }
    
}
