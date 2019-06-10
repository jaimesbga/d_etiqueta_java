import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.io.*;
import java.lang.String;
import java.lang.String;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

    
public class Impresion {
    
    private String DirIp;
    private String idCto;
    private JPanel p_imp;
    private JLabel image,i_letras,l_title,l_congra,l_t_tien,l_rif,l_nomb,l_apell,l_tel,l_ced,l_cant,l_descr,l_pre,l_cod,l_can,l_des, l_prec,l_bs,l_bs2,l_t_pa,l_con_pa,l_f_p,l_gara,l_gar_n,l_obser,l_f_en,l_f_dev,l_firma,l_f_emi,l_num_con;
    private JLabel l_aux_title,l_aux_apell,l_aux_dir,l_aux_ci,l_aux_tel,l_aux_desc,l_aux_cod,l_aux_f_emi,l_aux_num_con,l_aux_des,l_aux_t_pa,l_aux_con_pa,l_aux_gar,l_aux_obser,l_aux_f_en,l_aux_f_dev;
    private String datos[] = new String[10];
     private String fechas[] =new String[4];
     private String descrip[]=new String[10];
     private String codi[]=new String[10];//8
     private String can[] = new String[10];
     private String pay[]= new String[5];
     private String Garant[]= new String[4];
     private String precio[] = new String[10];
     private String abono ="";
     private String cod ;
     private int con;
     
    public Impresion(String dirIp,String cod){
            this.DirIp=dirIp;
            this.idCto = cod;
            this.Load_Panel();
    }
    
    void Load_Panel(){
        this.Consultas();
     ////inicializacion del panel////
        p_imp = new JPanel();
        p_imp.setBounds(20,20,640,400);        
        p_imp.setLayout(null);
        p_imp.setBackground(Color.WHITE);
     ////inicializacion del panel//// 
        
        ///letras
        Font letra = new Font("Arial",Font.ITALIC,9);
        Font letra2 = new Font("Arial",Font.BOLD,9);
        Font letra3 = new Font("Arial",Font.BOLD,10); 
        ///letras
       
       
      ////Label basicos////  
       l_title = new JLabel("CONTRATO Y CONTROL DE ALQUILER");
       l_title.setBounds(60,110,200,30);
       l_title.setFont(letra2);
       l_aux_title = new JLabel("CONTRATO Y CONTROL DE ALQUILER");
       l_aux_title.setBounds(370,110,200,30);
       l_aux_title.setFont(letra2);
       
                ///Agregar 
                ///l_title, l_aux_title
       
       l_apell=new JLabel("Nombre o Razon Social: "+datos[1]);
       l_apell.setBounds(10,130,200,30);
       l_aux_apell=new JLabel("Nombre o Razon Social: "+datos[1]);
       l_aux_apell.setBounds(320,130,200,30);
       
     
                    ///Agregar
                    ////l_apell, l_aux_apell       
       
       int gol=130,ref=70;
       
       boolean intro = false;
       
       ////Datos de Direccion       
         if(datos[2].length()>=45){
                intro = true;
                String d1 = "Direccion:"+datos[2].substring(0,45);
                String d2 = datos[2].substring(45,datos[2].length());
                gol = 140;
                l_nomb = new JLabel(d1);
                l_nomb.setBounds(10,gol,270,30);  
                        l_aux_dir = new JLabel(d1);
                        l_aux_dir.setBounds(330,gol,270,30);
                gol+=10;
                JLabel ds = new JLabel(d2);
                ds.setBounds(10,gol,270,30);
                ds.setFont(letra);
                        JLabel ds2 = new JLabel(d2);
                        ds2.setBounds(320,gol,270,30);
                        ds2.setFont(letra);
                        p_imp.add(ds);
                        p_imp.add(ds2);
                   ///agregar
                        ///l_nomb, l_aux_dir
                        
                        
        }else{
            gol = 140;
        l_nomb = new JLabel("Direccion: "+datos[2]);
        l_nomb.setBounds(10,gol,250,30); 
                        l_aux_dir = new JLabel("Direccion: "+datos[2]);
                        l_aux_dir.setBounds(320,gol,270,30);
                        ///agregar
                        ///l_nomb, l_aux_dir
        }
        gol+=10; 
       
        l_ced = new JLabel("RiF/Ced: "+datos[0]);
        l_ced.setBounds(10,gol,250,30);        
        l_aux_ci = new JLabel("RiF/Ced: "+datos[0]);
        l_aux_ci.setBounds(320,gol,250,30);
            ///agrega: l_ced, l_aux_ci
        gol+=10;
        l_tel = new JLabel("Telefono:" + datos[3]);
        l_tel.setBounds(10,gol,250,30);
        l_aux_tel = new JLabel("Telefono:" + datos[3]);
        l_aux_tel.setBounds(320,gol,250,30);
            ///agregar l_tel,l_aux_tel
        gol+=20;
        l_descr = new JLabel("DESCRIPCION");
        l_descr.setBounds(70,gol,250,30);
        l_aux_desc = new JLabel("DESCRIPCION");
        l_aux_desc.setBounds(390,gol,250,30);
            ///l_descr,l_aux_desc
        
        l_cod = new JLabel("CODIGO");
        l_cod.setBounds(10,gol,200,30);   
        l_aux_cod = new JLabel("CODIGO");
        l_aux_cod.setBounds(320,gol,200,30);
            ///l_cod,l_aux_cod
        
        gol+=10; 
        l_f_emi = new JLabel("Fecha de Emision:"+fechas[1]);
        l_f_emi.setBounds(150,90,220,30);
        l_f_emi.setFont(letra);
        l_aux_f_emi = new JLabel("Fecha de Emision:"+fechas[1]);
        l_aux_f_emi.setBounds(460,90,220,30);
        l_aux_f_emi.setFont(letra);
            ///l_f_emi, l_aux_f_emi
        
        String id_cto = " 000000"+idCto;
        id_cto = id_cto.substring(id_cto.length()-6, id_cto.length());
                
        //l_num_con = new JLabel("Nº C-"+idCto);
        l_num_con = new JLabel("Nº C-"+id_cto);
        l_num_con.setBounds(180,80,200,30);
        l_num_con.setFont(letra3);
        l_aux_num_con = new JLabel("Nº C-"+id_cto);
        l_aux_num_con.setBounds(490,80,200,30);
        l_aux_num_con.setFont(letra3);
        ///l_aux_num_con, l_num_con
       ////Datos de Direccion
       
     ////Label basicos////
      
////////////////////////////////////////////////////////////////////
        //////////////////IMPRESIONES CICLICAS///////////////////////////
        for (int i = 0; i < con; i++) {          
         if(descrip[0].length()>30){
         l_des = new JLabel(descrip[i].substring(0,29)+"-");
         l_des.setBounds(70,gol,250,30);         
         l_des.setFont(letra);         
         l_aux_des = new JLabel(descrip[i].substring(0,29)+"-");
         l_aux_des.setBounds(380,gol,250,30);         
         l_aux_des.setFont(letra);
         p_imp.add(l_aux_des);         
         p_imp.add(l_des); 
         gol=gol+10;
         
         
         l_des = new JLabel(descrip[i].substring(29,descrip[i].length()));
         l_des.setBounds(70,gol,250,30);         
         l_des.setFont(letra);
         l_aux_des = new JLabel(descrip[i].substring(29,descrip[i].length()));
         l_aux_des.setBounds(380,gol,250,30);         
         l_aux_des.setFont(letra);
         p_imp.add(l_aux_des);
         p_imp.add(l_des); 
       
         }else{
         l_des = new JLabel(descrip[i]);
         l_des.setBounds(70,gol,250,30);         
         l_des.setFont(letra);
         l_aux_des = new JLabel(descrip[i]);
         l_aux_des.setBounds(380,gol,250,30);         
         l_aux_des.setFont(letra);
         p_imp.add(l_aux_des);
         p_imp.add(l_des);   
         }//fin else
                     
         JLabel codes = new JLabel(codi[i]);
         codes.setBounds(10,gol,200,30);
         codes.setFont(letra);
         JLabel codes_aux = new JLabel(codi[i]);
         codes_aux.setBounds(320,gol,200,30);
         codes_aux.setFont(letra);
         p_imp.add(codes_aux);
         p_imp.add(codes);
         gol=gol+10;
        }                        
  gol=290;              
           
        ////////////////////////////////////////////////////////////////////
        //////////////////IMPRESIONES CICLICAS///////////////////////////
        
  
  ///-------------------Datos Finales------------------------/////////
   //parte inferior de la factura depende de gol
        l_t_pa = new JLabel("Total a Pagar(Bs.F): "+datos[5]);
        l_t_pa.setBounds(130,gol,250,30);
        l_aux_t_pa = new JLabel("Total a Pagar(Bs.F): "+datos[5]);
        l_aux_t_pa.setBounds(440,gol,250,30);
            ///l_t_pa  , l_aux_t_pa
        
        String estado=""; 
        int valor=0;                
        if(abono!=null&&datos[5]!=null){
        valor=Integer.parseInt(datos[5])-Integer.parseInt(abono);
        if(valor==0){
        estado="CANCELADO";        
        }else{
        estado="ABONADO";
        }}//fin if global
        if(abono==null){
            abono="";
        }
        l_con_pa = new JLabel("Total: "+datos[5]+",Abono:"+abono+",Resta:"+String.valueOf(valor)+",Estado:"+estado);
        l_con_pa.setBounds(10,gol+10,250,30);
        l_aux_con_pa = new JLabel("Total: "+datos[5]+",Abono:"+abono+",Resta:"+String.valueOf(valor)+",Estado:"+estado);
        l_aux_con_pa.setBounds(320,gol+10,250,30);
                ////l_con_pa , l_aux_con_pa
        
        
        l_gara = new JLabel("Garantia: "+Garant[0]+" "+Garant[1]+" "+Garant[2]);
        l_gara.setBounds(10,gol+20,350,30); 
        l_aux_gar = new JLabel("Garantia: "+Garant[0]+" "+Garant[1]+" "+Garant[2]);
        l_aux_gar.setBounds(320,gol+20,350,30);
            ///l_gara , l_ aux_gar
        
        JLabel nota = new JLabel("Nota:");
        nota.setBounds(10,gol+30,350,30);
        JLabel nota2 = new JLabel("Nota:");
        nota2.setBounds(320,gol+30,350,30);
                    /// nota, nota2
        
        
        if(datos[4]!=null){
        if(datos[4].length()>50){
        l_obser = new JLabel("Observaciones:"+datos[4].substring(0,45));//MAX 45 Caracteres
        l_obser.setBounds(10,gol+40,350,30);
        l_obser.setFont(letra);
        l_aux_obser = new JLabel("Observaciones:"+datos[4].substring(0,45));//MAX 45 Caracteres
        l_aux_obser.setBounds(320,gol+40,350,30);
        l_aux_obser.setFont(letra);
        p_imp.add(l_aux_obser);
        p_imp.add(l_obser);        
        gol=gol+10;
        
        l_obser = new JLabel(datos[4].substring(45,datos[4].length()));//MAX 45 Caracteres
        l_obser.setBounds(10,gol+40,350,30);
        l_obser.setFont(letra);
        l_aux_obser = new JLabel(datos[4].substring(45,datos[4].length()));//MAX 45 Caracteres
        l_aux_obser.setBounds(320,gol+40,350,30);
        l_aux_obser.setFont(letra);
        p_imp.add(l_aux_obser);
        p_imp.add(l_obser);
        
        }else{        
        l_obser = new JLabel("Observaciones:"+datos[4]);//MAX 45 Caracteres
        l_obser.setBounds(10,gol+40,350,30);
        l_obser.setFont(letra); 
        l_aux_obser = new JLabel("Observaciones:"+datos[4]);//MAX 45 Caracteres
        l_aux_obser.setBounds(320,gol+40,350,30);
        l_aux_obser.setFont(letra); 
        p_imp.add(l_aux_obser);
        p_imp.add(l_obser);
        }}
        //fin else            
        String spa = " ";
        l_f_en =  new JLabel("Entrega:"+fechas[0]);
        l_f_en.setBounds(10,gol+50,260,30);
        l_f_dev = new JLabel("Devolucion: "+fechas[2]);
        l_f_dev.setBounds(145,gol+50,260,30);
        l_aux_f_en =  new JLabel("Entrega:"+fechas[0]);
        l_aux_f_en.setBounds(320,gol+50,260,30);
        l_aux_f_dev = new JLabel("Devolucion: "+fechas[2]);
        l_aux_f_dev.setBounds(465,gol+50,270,30);
        
        ///l_f_en,l_aux_f_en,l_aux_f_dev,l_f_dev
        
        
   ///-------------------Datos Finales------------------------/////////
        l_f_en.setFont(letra);
        l_aux_f_en.setFont(letra);
        l_aux_f_dev.setFont(letra);
        l_f_dev.setFont(letra);
        p_imp.add(l_f_en);        
        p_imp.add(l_aux_f_en);        
        p_imp.add(l_aux_f_dev);        
        p_imp.add(l_f_dev);
        
      ///  ------------------------------
        nota.setFont(letra);
        nota2.setFont(letra);
        p_imp.add(nota);        
        p_imp.add(nota2);
        
        ///-------------------------------
        l_aux_gar.setFont(letra);
        l_gara.setFont(letra);
         p_imp.add(l_gara);         
          p_imp.add(l_aux_gar);
          
          ////----------------------------
         l_aux_con_pa.setFont(letra); 
         l_con_pa.setFont(letra); 
         p_imp.add(l_con_pa);         
          p_imp.add(l_aux_con_pa);
          
          ///////////////-----------------
          l_t_pa.setFont(letra2);
          l_aux_t_pa.setFont(letra2);
          p_imp.add(l_t_pa);          
          p_imp.add(l_aux_t_pa);
          
          //////////-------------
          l_aux_num_con.setFont(letra2);
          l_num_con.setFont(letra2);
          p_imp.add(l_num_con);          
          p_imp.add(l_aux_num_con);
          
          //----------------
          //l_aux_f_emi.setFont(letra);
          ///l_f_emi.setFont(letra);
          p_imp.add(l_f_emi);          
          p_imp.add(l_aux_f_emi);
          
          //-------------------
          l_cod.setFont(letra3);
          l_aux_cod.setFont(letra3);
          p_imp.add(l_cod);          
          p_imp.add(l_aux_cod);
          
          ///-----------------
          ///l_des.setFont(letra3);
          l_descr.setFont(letra3);
          l_aux_desc.setFont(letra3);
          p_imp.add(l_descr);
          p_imp.add(l_aux_desc);
          
          ///-------------
          l_tel.setFont(letra);
          l_aux_tel.setFont(letra);
          p_imp.add(l_tel);          
          p_imp.add(l_aux_tel);
          
          ///--------------
          l_ced.setFont(letra);
           l_aux_ci.setFont(letra);
          p_imp.add(l_ced);          
          p_imp.add(l_aux_ci);
         
          //----------------------------
         l_nomb.setFont(letra);
         l_aux_dir.setFont(letra);
          p_imp.add(l_nomb);          
           p_imp.add(l_aux_dir);        
           
           //--------------------------------
           l_aux_apell.setFont(letra);
            l_apell.setFont(letra);
           p_imp.add(l_aux_apell);
            p_imp.add(l_apell);
            
            ///-------------------------------------
            l_title.setFont(letra3);
            l_aux_title.setFont(letra3);
            p_imp.add(l_title);    
            p_imp.add(l_aux_title);
            
            
        Impirmir();
    }////Fin panel
    
    
    void Consultas(){
     cod = this.idCto;
        //Inicio de Consultas
        Conexion fac = new Conexion(this.DirIp);
        fac.conectar();        
        try {
            ResultSet resul = fac.consultar("select c.cedula,c.nombre,c.direccion,c.telefono1,c.telefono2,co.total_pagar from clientes c,contratos co" +
                    "                                            where c.cedula=co.cte_cedula and" +
                    "                                            co.id='"+cod+"'");
            resul.next();
          datos[0]=resul.getString(1);
          datos[1]=resul.getString(2);
          datos[2]=resul.getString(3);
          
          if(resul.getString(5)!=null){
          datos[3]=resul.getString(4)+" , "+resul.getString(5);
          }else{
          datos[3]=resul.getString(4);
          } 
          datos[5]=resul.getString(6);
          //validaciones para observaciones
          resul = fac.consultar("select count(*) from observaciones where CTO_ID="+cod);
          resul.next();
          
          if(Integer.parseInt(resul.getString(1))>0){
          resul = fac.consultar("select descripcion from observaciones where CTO_ID="+cod);
          resul.next();
          
                 
          if(resul.getString(1)==null){
          datos[4]="";
          }else{
           datos[4]=resul.getString(1);
          }//fin else
          }else{
          datos[4]="";
          }//fin else
          
          
          resul = fac.consultar("select a.DESCRIPCION,a.id, b.color1,b.color2,b.color3,b.id, c.DESCRIPCION,c.id, d.DESCRIPCION,d.id, f.talla,f.id,e.cantidad,e.precio from tipo_accesorios a, color_accesorios b, forma_accesorios c,marca_accesorios d,items e,accesorios f where e.cto_id="+cod+" and e.aro_id =f.id and f.taro_id = a.id"+ 
                               " and f.faro_id = c.id and f.caro_id = b.id and f.maro_id = d.id and f.maro_id = d.id ORDER BY e.ID");
         con=0;
          while(resul!=null&&resul.next()){
              descrip[con] = resul.getString(1)+" "+resul.getString(3)+" "+resul.getString(7)+" T_"+resul.getString(11);  
              String[] adde = new String[4];
              ///condicion para ceros a la izquierda

              if(Integer.parseInt(resul.getString(2))<10){
              adde[0]="0";
              }else{
              adde[0]="";
              }//fin else

              if(Integer.parseInt(resul.getString(8))<10){
              adde[1]="0";
              }else{
              adde[1]="";
              }//fin else

              if(Integer.parseInt(resul.getString(6))<10){
              adde[2]="0";
              }else{
              adde[2]="";
              }//fin else

              if(resul.getString(11).length()<2){
              adde[3]="0";
              }else{
              adde[3]="";
              }//fin else
              ///FIN condicion para ceros a la izquierda
              can[con]=resul.getString(13);
              codi[con]=adde[0]+resul.getString(2)+adde[1]+resul.getString(8)+adde[2]+resul.getString(6)+adde[3]+resul.getString(11); 
              precio[con] = resul.getString(14);
              con++;
          }//fin while
           
          resul = fac.consultar("select TO_CHAR(ct.fecha_entrega,'DD/MM/YYYY'),TO_CHAR(ct.fecha_emision,'DD/MM/YYYY'),TO_CHAR(ct.fecha_devolucion,'DD/MM/YYYY') from contratos ct where ID="+cod);
          resul.next();
          fechas[0]=resul.getString(1).substring(0,10);
          fechas[1]=resul.getString(2).substring(0,10);
          fechas[2]=resul.getString(3).substring(0,10);
          
         String p[]={"","Efect.","Cheque","Tarj. C","Tarj. D","Otro"}; 
         
         int load=1,c_pay=0;
         while(load!=6){
         resul = fac.consultar("select count(id) from pagos where TPGO_ID="+String.valueOf(load) +" and CTO_ID="+cod+" and MVO_ID = '1'");
         resul.next();
         if(Integer.parseInt(resul.getString(1))>0){
                int can_p= Integer.parseInt(resul.getString(1));
                resul = fac.consultar("select sum(monto) from pagos where TPGO_ID="+String.valueOf(load)+"and CTO_ID="+cod+" and MVO_ID = '1'");
                resul.next();
                pay[c_pay] = p[load]+"_"+String.valueOf(can_p)+"("+resul.getString(1)+")";
                c_pay++;
         }
         load++;
         }//fin while
         load=1;
            int c_garan=0;      
                         
            
         String query = "select p.OBSERVACION, tp.DESCRIPCION from PAGOS p, TIPOS_PAGO tp where p.TPGO_ID = tp.ID and p.CTO_ID='"+cod+"' and p.MVO_ID='02'";
         resul = fac.consultar(query);
         try {
             while(resul.next()){
                 Garant[c_garan] = resul.getString(2) + " " + resul.getString(1);
                 c_garan++;
             }
         }
         catch (Exception e) {  }
            
         if(Garant[0]==null){
                Garant[0]="";
         }
         if(Garant[1]==null){
                Garant[1]="";
         }
         if(Garant[2]==null){
                Garant[2]="";
         }
         resul = fac.consultar("select sum(monto) from pagos where CTO_ID="+cod+" and MVO_ID=1");
         resul.next();
         abono = resul.getString(1);
         
         fac.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
                    }
    
    }
    
    void Impirmir(){
       JFrame x = new JFrame();
        x.add(p_imp);
        String id_cto = " 000000"+idCto;
        id_cto = id_cto.substring(id_cto.length()-6, id_cto.length());
             PrintJob mip = x.getToolkit().getPrintJob(x,"Contrato de Etiqueta "+id_cto,null); 
                      
               if(mip!=null){
               Graphics imp = mip.getGraphics();
               
               if(imp!=null){
                   
                    p_imp.printAll(imp);
                    imp.dispose();
                    
               }
               }
               if(mip!=null){
               mip.end();
               }
    }
}

     