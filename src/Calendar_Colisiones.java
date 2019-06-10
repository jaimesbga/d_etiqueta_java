import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.*;


public class Calendar_Colisiones extends JPanel implements ActionListener{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JButton b_i,b_d;   
 private JLabel mes; 
 private DefaultTableModel_M tabla;
 private Date dina;
 private GregorianCalendar calendar;
 private String entry;
 private int mm;
private int yy;
private String vecMes[];
private  JLabel[][] fech2;
private Conexion dis = null;
@SuppressWarnings("unused")
private String hoy;
private String[]  fecha=null;
private String Gen_code = null;
private String f_e=null;
private String f_d=null;
 private boolean band;
    public Calendar_Colisiones(int x,int y, int ancho,int Largo,String IpServer,String f_en,String f_de) {
             super();    
             setBounds(x,y,ancho,Largo);
             setLayout(null);
             setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Calendario", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
             dis = new Conexion(IpServer);
             tabla = new DefaultTableModel_M();
      String[] dias = {"Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"};
            Object[][] day = {{null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}};
             String meses = "Enero Febrero Marzo Abril Mayo Junio Julio Agosto Septiembre Octubre Noviembre Diciembre";
             vecMes = meses.split(" ");  
     tabla.setDataVector(day,dias);
    InitComponent();
    getHoy();
    load();
    InitDays();
    setDateCompare(f_en,f_de);
    cargarTabla();
    }
    
    public void InitComponent(){
            b_i = new JButton("<<");
            b_i.setBounds(10,25,50,20);
            b_d = new JButton(">>");
            b_d.setBounds(170,25,50,20);
            mes = new JLabel("");
            mes.setBounds(70,25,100,20);
            b_i.addActionListener(this);
            b_d.addActionListener(this);
            this.add(b_i);
            this.add(b_d);
            this.add(mes);
    
    }
    
    JPanel getPanel(){
            return this;                
    }

    public void actionPerformed(ActionEvent e) {
        
            if(e.getSource() == b_i){
            entry = "1/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR);
          
            cargarTabla();
       if(Gen_code!=null){
           Pinta_Fecha(Gen_code);
        }  
          
	}
	if(e.getSource() == b_d){
            entry = "1/"+(calendar.get(Calendar.MONTH)+2)+"/"+calendar.get(Calendar.YEAR);
          
            cargarTabla();
        if(Gen_code!=null){
           Pinta_Fecha(Gen_code);
          }
            
          
	}
    }//fin action performed
    
    void load_tabla(){
    cargarTabla();            
 }//fin load 

    public void cargarTabla(){
        
      String[] f_aux = f_e.split("/");  
      
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
                int mmm = Integer.parseInt(f_aux[1]);   
                int yyy = Integer.parseInt(f_aux[2]);/*****+2000*****/   
                entry = "01/"+(mmm)+"/"+yyy;
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
                fech2[i][j].setBounds(j*30+10,i*30+80,30,30);
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
                
                
                add(fech2[i][j]);
                repaint();
                
      }//fin for
      }//fin for
      
    }//fin cargar tabla
    
     void load(){
         fech2 = new JLabel[6][7]; 
       for (int i = 0; i < 6; i++) {
           for (int j = 0; j < 7; j++) {
           fech2[i][j]= new JLabel("");
          fech2[i][j].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
          fech2[i][j].setOpaque(true);
          //fech2[i][j].set
           }}
   
   }//fin load
     
void getHoy(){
  dis.conectar();
  ResultSet res = dis.consultar("select TO_CHAR(sysdate,'DD/MONTH/YYYY') from dual");
   try {
            res.next();
            fecha = res.getString(1).split("/"); 
        } catch (Exception ex) {
            
        } //catch
  dis.desconectar();
}

void InitDays(){
    String[] day = {"Do","Lu","Ma","Mi","Ju","Vi","Sa"};
      String[] day2 = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
       JLabel[] days = new JLabel[7];
        
        for (int i = 0; i < day.length; i++) {
            days[i] = new JLabel();
            days[i].setText(day[i]);
            days[i].setFont(new Font("Times New Roman",Font.BOLD,11));
            days[i].setBackground(Color.LIGHT_GRAY);
            days[i].setToolTipText(day2[i]);
            days[i].setBounds(i*30+10,50,30,30);
            days[i].setOpaque(true);
            days[i].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
            this.add(days[i]);
        }
}//fin

 void Pinta_Fecha(String code){
     Gen_code = code;
                dis.conectar();
                String[] sx = code.split("-");
                int can=0;
                Tool_Code ax = new Tool_Code();
                String[] cod = ax.Sep_Cod(sx[0]);
                String[] id_cont = null;
                String[] cod2 = ax.sep_two(sx[1]);
                String ejem = cod2[1]; 
                String query2 = "select count(*) from items a,contratos b where a.cto_id=b.id and a.aro_id=(select id from accesorios where taro_id="+cod[0]+" and faro_id="+cod[1]+" and caro_id="+cod[2]+" and talla='"+cod[3]+"' and num_ejemplar="+ejem+") and (b.estado='ACTIVO' or b.estado='PENDIENTE')"
                              +" order by (b.fecha_entrega)";
                ResultSet a = dis.consultar(query2);
                try {
                   a.next();
                   can = 2*Integer.parseInt(a.getString(1));
                } catch (Exception e) {System.out.println("error linea 268");} // /fin catch             
                
                String query="select TO_CHAR(b.fecha_entrega,'DD/MM/YY'),TO_CHAR(b.fecha_devolucion,'DD/MM/YY'),b.id from items a,contratos b where a.cto_id=b.id and a.aro_id=(select id from accesorios where taro_id="+cod[0]+" and faro_id="+cod[1]+" and caro_id="+cod[2]+" and talla='"+cod[3]+"' and num_ejemplar="+ejem+") and (b.estado='ACTIVO' or b.estado='PENDIENTE')"
                              +" order by (b.fecha_entrega)";
                 a = dis.consultar(query);
        String[] fechas = new String[can];
        id_cont = new String[can/2];
            try {
                int con=0,con2=0;
             
            while(a!=null&&a.next()){
            fechas[con] = a.getString(1);con++;
            fechas[con] = a.getString(2);con++;
            id_cont[con2] = a.getString(3);
             
            
            con2++;
            System.out.println(a.getString(1)+"--"+a.getString(2)+"  "+code);//////////
            
            }//fin while
        } catch (Exception ex) {
            System.out.println("error linea 289");
        }//fin catch
      
       dis.desconectar();
       Pintando(fechas,id_cont);
   }//fin funcion
   
   void Pintando(String[] fech,String[] ID){
        @SuppressWarnings("unused")
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
        Colisiones();
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

void setDateCompare(String Fech_e, String Fech_d){
    this.f_e = Fech_e;
    this.f_d = Fech_d;    

}//fin setdatecompare

void Colisiones(){
    band = false;
    String[] fe = f_e.split("/");
    String[] fd = f_d.split("/");
    int fee = Integer.parseInt(fe[0]);
    int mee = Integer.parseInt(fe[1]);
    int mdd = Integer.parseInt(fd[1]);
    int fdd = Integer.parseInt(fd[0]);
    int yee = Integer.parseInt(fe[2]);
    int ydd = Integer.parseInt(fd[2]);        
    int days = fdd - fee;
     int con = 0; 
    if(days<0&&mdd==fech_pa()){
    days = fdd-1;
    fee=1;
    mee=mdd; 
    yee=ydd;
    }  
    if(days<0&&mee==fech_pa()){
    days = InterFech()-fee;
   
    }   
    boolean val = false;
    for (int i = 0; i < 6; i++) {
        if(val){
                break;
        }
        for (int j = 0; j < 7; j++) {
            
            if(fech2[i][j].getText()!=""){
                if(Integer.parseInt(fech2[i][j].getText())==fee+con&&fech_pa()==mee&&getYear()==yee){
                        if(fech2[i][j].getBackground()==Color.WHITE||fech2[i][j].getBackground()==Color.PINK){
                           fech2[i][j].setBackground(Color.GREEN);         
                        }else{
                        fech2[i][j].setBackground(Color.RED);
                        band=true;
                        }
                        con++;
                        if(con-1==days){
                            val=true;
                            break;
                              
                        }
                }//fin if validacion de fecha
            }//fin if del diferente a ""
            
        }
    }
            
}
boolean getBan(){
        return band;
}

public void setHoy(String hoy) {
	this.hoy = hoy;
}
}//fin class
