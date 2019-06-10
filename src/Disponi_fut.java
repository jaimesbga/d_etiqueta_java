import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class Disponi_fut extends JDialog implements ActionListener{
private Conexion dis = null; 
private JTable lis_fec;
private JScrollPane s_lis;
private JPanel p_op,p_look,p_prin,p_list;
private JTextField t_cod;
private JLabel l_fe,l_fd,articulo,ejem;
private JComboBox c_ejem;
private JButton b_cod,b_bus,b_d,b_i;
private String ip;
private DefaultTableModel_M tabla,tabla2;
private int mm;
private int yy;
private Date dina;
private String entry;
private String[] hoy=null;
private GregorianCalendar calendar;
private String agrega;
private JLabel mes;
private String vecMes[];
private  JButton[][] fech2;
private  JButton[] days;
private JTabbedPane ta_panel;
private   String[]  fecha=null;
    public Disponi_fut(JFrame parent,String IpServer) {
            super(parent,true);
            Start(IpServer);
    }
     public Disponi_fut(JDialog parent,String IpServer) {
            super(parent,true);
            Start(IpServer);
    }
     
 void Start(String IpServer){
      tabla = new DefaultTableModel_M();
      String[] dias = {"Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"};
            Object[][] day = {{null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}};
            
     tabla.setDataVector(day,dias);
     String meses = "Enero Febrero Marzo Abril Mayo Junio Julio Agosto Septiembre Octubre Noviembre Diciembre";
      vecMes = meses.split(" ");  
     ip=IpServer;
         dis = new Conexion(IpServer);
          setBounds(0,0,480,590);
                setLayout(null);
                setTitle("Ver Disponibilidad de Articulos");
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                setResizable(false);
                 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                 Dimension frameSize = getSize(); 
                 setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.width) / 2));
                 
                 getHoy();
                 load();
                 this.getContentPane().add(Opciones());
                 this.getContentPane().add(this.Princi2());
                 setVisible(true);
 }   
 JPanel Princi2(){
            p_prin = new JPanel();
            p_prin.setBounds(12,110,450,430);
            p_prin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
            p_prin.setLayout(null);   
            ta_panel = new JTabbedPane();
            ta_panel.setBounds(12,110,450,430);
            ta_panel.addTab("Vista por Calendario",Look());
            ta_panel.addTab("Lista de Fechas",this.List_look());
            add(ta_panel);
            return p_prin;
 }
 JPanel Opciones(){
            p_op = new JPanel();
            p_op.setBounds(12,10,450,100);
            p_op.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Seleccione el Articulo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
            p_op.setLayout(null);           
            t_cod = new JTextField();
            t_cod.setBounds(100,30,150,20);
            t_cod.setEditable(false);
            
            t_cod.setBackground(Color.WHITE);
          
            b_cod = new JButton("...");
            b_cod.setBounds(250,30,20,20);
            c_ejem = new JComboBox();
            c_ejem.setBounds(350,30,80,20);
            b_bus = new JButton("Ver Disponibilidad");
            b_bus.setBounds(135,60,180,20);
            
            articulo = new JLabel("Cod. Articulo: ");
            articulo.setBounds(20,30,130,20);
            
            ejem = new JLabel("Nº Ejemplar:");
            ejem.setBounds(280,30,130,20);
            //eventos
                  
                        
                        b_cod.addActionListener(this);
                        
                        b_bus.addActionListener(this);
            //fin eventos            
            p_op.add(ejem);
            p_op.add(articulo);
            p_op.add(b_cod);
            p_op.add(b_bus);
           
            p_op.add(t_cod);
            p_op.add(c_ejem);
            return p_op;

 }//fin opciones
 
 JPanel Look(){
            p_look= new JPanel();
            p_look.setBounds(12,110,450,350);
            p_look.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Resultados", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
            p_look.setLayout(null);
            
            mes = new JLabel("");
            mes.setBounds(180,20,100,20);
            
           
            load_tabla();
            b_i = new JButton("<<");
            b_i.setBounds(90,20,80,20);
            b_d = new JButton(">>");
            b_d.setBounds(280,20,80,20);
            b_i.addActionListener(this);
            b_d.addActionListener(this);
            this.InitDays();
            p_look.add(b_d);
            p_look.add(b_i);            
            p_look.add(mes);
            return p_look;
 }
 
 void Consul(String[] cod){
        c_ejem.removeAllItems();
         if(!t_cod.getText().toString().isEmpty()){  
             dis.conectar();
        ResultSet dat = dis.consultar("select num_ejemplar from accesorios where taro_id="+cod[0]+" and faro_id="+cod[1]+" and caro_id="+cod[2]+" and talla='"+cod[3]+"' order by (num_ejemplar)");
        System.out.println("select num_ejemplar from accesorios where taro_id="+cod[0]+" and faro_id="+cod[1]+" and caro_id="+cod[2]+" and talla='"+cod[3]+"' order by (num_ejemplar)");
        try {
            while(dat!=null&&dat.next()){
                    c_ejem.addItem(dat.getString(1));                
            }//fin while
        } catch (Exception ex) {
            
        }//fin catch
         }//finif
        
 }//fin consul
 
 void load_tabla(){
    cargarTabla();
            
 }//fin load 

 
 public void cargarTabla(){
        
        for(int ii=0;ii<6;ii++){
            for(int jj=0;jj<7;jj++){
                tabla.setValueAt(null,ii,jj);
            }
        }
        
        try{
            if (dina==null){
                dina = new Date();
                calendar = new java.util.GregorianCalendar();
                calendar.setTime(dina);
                int mmm = calendar.get(java.util.Calendar.MONTH) ;   
                int yyy = calendar.get(java.util.Calendar.YEAR) ;   
                entry = "01/"+(mmm+1)+"/"+yyy;
            }
            dina = DateFormat.getDateInstance
            (DateFormat.SHORT,Locale.FRANCE).parse(entry);
            calendar = new GregorianCalendar();
            calendar.setTime(dina);            
        }
        catch(Exception er){ }        
        
        mm = calendar.get(Calendar.MONTH) ;   
        yy = calendar.get(Calendar.YEAR) ;   
        int px = calendar.get(Calendar.DAY_OF_WEEK)-1; 

        mes.setText(vecMes[mm]+"-"+yy);
        
        int num;
        switch(mm){
            case 0: case 2: case 4: case 6: case 7: case 9: case 11:
                num=31;
                break;
            case 1:
                if((calendar.isLeapYear(yy))&&(yy%1000!=0))
                    num=29;
                else
                    num=28;
                break;
            default:
                num=30;
        }
        
        int cont=1;
        int x, y;
        x = px;
        y = 0;
        for(int ii=0;ii<num;ii++){
            tabla.setValueAt(cont, y, x);
            cont++;
            x++;
            if(x == 7){
                x=0;
                y++;
            }
        }
        
    
 
      
    String[] aux =  mes.getText().split("-");
    boolean pinta=false;
    if(fecha[1].indexOf(aux[0].toUpperCase())>=0&&fecha[2].indexOf(aux[1])>=0){
    pinta=true;
    }//fin if  
    
      for (int i = 0; i < 6; i++) {
           for (int j = 0; j < 7; j++) {
               String vali = "";
               if(tabla.getValueAt(i,j)!=null){
                        vali=tabla.getValueAt(i,j).toString();;                        
               }else{
                        vali="";
               }//fin else
                fech2[i][j].setText(vali);   
                fech2[i][j].setFont(new Font("Times New Roman",Font.BOLD,16));  
                fech2[i][j].setBounds(j*50+50,i*50+80,50,50);
                fech2[i][j].setBackground(Color.WHITE);
               
                  if(pinta){  
                    if(vali!=""){ 
                        if(Integer.parseInt(fecha[0])==Integer.parseInt(vali)){
                    fech2[i][j].setBackground(Color.PINK);
                    fech2[i][j].setToolTipText("Fecha Actual");
                        }
                      }else{
                        fech2[i][j].setBackground(Color.WHITE);
                      }
                  }
                
                
                p_look.add(fech2[i][j]);
                p_look.repaint();
                
      }//fin for
      }//fin for
      
    }//fin cargar tabla
 
    public void actionPerformed(ActionEvent e) {
        boolean ver=false;
        if(e.getSource() == b_i){
            entry = "1/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR);
          
            cargarTabla();
          if(!t_cod.getText().isEmpty()){
            Pinta_Fecha();
          }  
          
            ver=true;
	}
	if(e.getSource() == b_d){
            entry = "1/"+(calendar.get(Calendar.MONTH)+2)+"/"+calendar.get(Calendar.YEAR);
          
            cargarTabla();
          if(!t_cod.getText().isEmpty()){
            Pinta_Fecha();
          }
            
            ver=true;
	}
         if(e.getSource()==b_bus){
          cargarTabla();
         this.Pinta_Fecha();
         }  
               
       
        if(e.getSource()==b_cod){
                                Busca_Acces a = new Busca_Acces(new JDialog(),ip);
                                Tool_Code b = new Tool_Code();                           
                                t_cod.setText(a.Cod_back());
                                Consul(b.Sep_Cod(a.Cod_back()));
        }
    }//fin action

   int[] getFuente_Evento(ActionEvent e){
       int a=0,b=0;
       for (int i = 0; i < 6; i++) {
           for (int j = 0; j < 7; j++) {
        if(e.getSource()==fech2[i][j]){
                a=i;
                b=j;
        }
           }}
       int[] coor={a,b};
       return coor;
   }//fin clear
   
   void load(){
         fech2 = new JButton[6][7]; 
       for (int i = 0; i < 6; i++) {
           for (int j = 0; j < 7; j++) {
           fech2[i][j]= new JButton("");
           fech2[i][j].addActionListener(this);
           }}
   
   }//fin load
   
   void Pinta_Fecha(){
                dis.conectar();
                
                int can=0;
                Tool_Code ax = new Tool_Code();
                String[] cod = ax.Sep_Cod(t_cod.getText());
                String[] id_cont = null;
                ResultSet a = null;
              try {
                String ejem = c_ejem.getSelectedItem().toString();
                
                
                String query2 = "select count(*) from items a,contratos b where a.cto_id=b.id and a.aro_id=(select id from accesorios where taro_id="+cod[0]+" and faro_id="+cod[1]+" and caro_id="+cod[2]+" and talla='"+cod[3]+"' and num_ejemplar="+ejem+") and (b.estado='ACTIVO' or b.estado='PENDIENTE')"
                              +" order by (b.fecha_entrega)";
                 a = dis.consultar(query2);
                
                
                   a.next();
                   can = 2*Integer.parseInt(a.getString(1));
                } catch (Exception e) {System.err.println("Error al seleccionar codigo.");} // /fin catch             
                
                String query="select DATE_FORMAT(b.fecha_entrega,'%d/%m/%Y'),DATE_FORMAT(b.fecha_devolucion,'%d/%m/%Y'),b.id from items a,contratos b where a.cto_id=b.id and a.aro_id=(select id from accesorios where taro_id="+cod[0]+" and faro_id="+cod[1]+" and caro_id="+cod[2]+" and talla='"+cod[3]+"' and num_ejemplar="+ejem+") and (b.estado='ACTIVO' or b.estado='PENDIENTE')"
                              +" order by (b.fecha_entrega)";
                 a = dis.consultar(query);
        String[] fechas = new String[can];
        id_cont = new String[can/2];
            try {
                int con=0,con2=0;
               this.Init_tabla2(); 
            while(a!=null&&a.next()){
            fechas[con] = a.getString(1);con++;
            fechas[con] = a.getString(2);con++;
            id_cont[con2] = a.getString(3);
             tabla2.setValueAt(a.getString(1),con2,0);
             tabla2.setValueAt(a.getString(2),con2,1);
            con2++;
          //  System.out.println(a.getString(1)+"--"+a.getString(2));//////////
            
            }//fin while
        } catch (SQLException ex) {
            
        }//fin catch
      
       dis.desconectar();
       Pintando(fechas,id_cont);
   }//fin funcion
   
   void Pintando(String[] fech,String[] ID){
        int fini=0,ffi=0,dias=0,fil=0,col=0,mss=0,yy=0,msf=0,ysf=0;
        int cont=0,co=0;
    
        String[] aux=null;
        System.out.println(this.fech_pa());
    for(int t = 0 ; t<(fech.length/2); t++){ 
        aux = fech[t+co].split("/");//0---2
        fini = Integer.parseInt(aux[0]);
        mss = Integer.parseInt(aux[1]);
        yy = Integer.parseInt(aux[2]);
        aux = fech[t+co+1].split("/");//1---3
        ffi = Integer.parseInt(aux[0]);
        msf=Integer.parseInt(aux[1]);
        ysf=Integer.parseInt(aux[2]);
        dias = ffi - fini;
        
        if(dias<0&&mss==fech_pa()){
        dias= InterFech() - fini;
        }
        if(dias<0&&msf==fech_pa()){
        dias = ffi-1;
        fini = 1;
                if(ysf>yy){
                        yy=ysf;
                }
        }
       
    if(yy==this.getYear()){    
        for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    String val = fech2[i][j].getText();
                    if(val!=""){
                            if(Integer.parseInt(val)==fini+cont&&(mss==fech_pa()||msf==fech_pa())){
                                if(co%2==0){ 
                                fech2[i][j].setBackground(Color.ORANGE);
                                } else{
                                fech2[i][j].setBackground(Color.YELLOW);
                                }
                                 fech2[i][j].setToolTipText("Contrato Nº : "+ID[co]);
                                        if(cont==dias){
                                                break;
                                        }
                                 cont++;
                            }//fin if
                    }//fin if
                }
        }//fin for
     cont=0;   
     
    }//fin if
        co++;
    }//fin for
   }//fin void pintando
   
   int fech_pa(){
         String meses = "Enero Febrero Marzo Abril Mayo Junio Julio Agosto Septiembre Octubre Noviembre Diciembre";
         String[] mess = meses.split(" ");
         for (int i = 0; i < mess.length; i++) {
             mess[i].toUpperCase();
         }
         String[] p = mes.getText().split("-");
         for (int i = 0; i < mess.length; i++) {
             if(mess[i].indexOf(p[0])>=0){
                            return i+1;
             }
         }
         return 22;
   }//fin funcion
   
   int getYear(){
           String[] c =  mes.getText().split("-");
           int year = Integer.parseInt(c[1].substring(1,c[1].length()));
           return year;
   }//fin funcion
int InterFech(){
   int cont = 0;
         for (int i = 0; i < 6; i++) {
           for (int j = 0; j < 7; j++) {
               cont++;
          boolean val = false;
           if(fech2[i][j].getText()==""&&cont>10){
                            val=true;
                            return Integer.parseInt(fech2[i][j-1].getText());
                        
           }//fin if
           if(!val&&j==6&&i==4){
                return Integer.parseInt(fech2[i][j].getText());
           }    
           }} 
            return 100;
}//fin Funcion
void InitDays(){
    String[] day = {"Do","Lu","Ma","Mi","Ju","Vi","Sa"};
      String[] day2 = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        days = new JButton[7];
        
        for (int i = 0; i < day.length; i++) {
            days[i] = new JButton();
            days[i].setText(day[i]);
            days[i].setFont(new Font("Times New Roman",Font.BOLD,11));
            days[i].setBackground(Color.LIGHT_GRAY);
            days[i].setToolTipText(day2[i]);
            days[i].setBounds(i*50+50,50,50,30);
            p_look.add(days[i]);
        }
}//fin

JPanel List_look(){
        p_list= new JPanel();
        p_list.setBounds(12,110,450,350);
        p_list.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Resultados", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        p_list.setLayout(null);
        lis_fec = new JTable(new Object[][]{{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null}},new String[]{"Fecha de Entrega","Fecha de Devolucion"});
        lis_fec.setBounds(50,10,300,310);
         lis_fec.setSelectionMode(0);
         lis_fec.getTableHeader().setReorderingAllowed(false); 
         tabla2 = new DefaultTableModel_M(new Object[][]{{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null}},new String[]{"Fecha de Entrega","Fecha de Devolucion"});
         lis_fec.setModel(tabla2);
        s_lis =  new JScrollPane();
        s_lis.setBounds(70,30,300,307);
        s_lis.setViewportView(lis_fec);
        p_list.add(s_lis);
            return p_list;
}
void Init_tabla2(){
    tabla2.setDataVector(new Object[][]{{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null},{null,null}},new String[]{"Fecha de Entrega","Fecha de Devolucion"});

}
void getHoy(){
  dis.conectar();
  ResultSet res = dis.consultar("select DATE_FORMAT(SYSDATE(),'%d/%m/%Y')");
   try {
            res.next();
            fecha = res.getString(1).split("/"); 
        } catch (Exception ex) {
            
        } //catch
  dis.desconectar();
}


}
