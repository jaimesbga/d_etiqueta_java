import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.PrintJob;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import org.omg.SendingContext.RunTime;


public class Factura extends JDialog{
    private int con;  
    private String idCto;
    private String dirIP;
    private JFrame aux = null;
    private JPanel p_op,p_imp;
    private JButton imprin,b_zoom,b_close;
    private JDialog p_zoom;
    private JLabel image,i_letras,l_title,l_congra,l_t_tien,l_rif,l_nomb,l_apell,l_tel,l_ced,l_cant,l_descr,l_pre,l_cod,l_can,l_des, l_prec,l_bs,l_bs2,l_t_pa,l_con_pa,l_f_p,l_gara,l_gar_n,l_obser,l_f_en,l_f_dev,l_firma,l_f_emi,l_num_con;
    /** Creates a new instance of Factura */
    public Factura(JFrame parent,String cod, String ip) {       
        super(parent,true);  
        aux=parent;        
        idCto = " 000000"+cod;
        idCto = idCto.substring(idCto.length()-6, idCto.length());
        dirIP = ip;
        setTitle("Vista Previa del Contrato");
        setBounds(0,0,370,540);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false); 
        Dimension size = getSize();
        Rectangle parentBounds = parent.getBounds();
        int xf = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int yf = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(xf, yf));
        this.Inicit(cod);
        add(p_op);
        add(p_imp);
        setVisible(true);
    }

 void Inicit(String cod){
        String datos[] = new String[10];
        String fechas[] =new String[4];
        String descrip[]=new String[10];
        String codi[]=new String[10];//8
        String can[] = new String[10];
        String pay[]= new String[5];
        String Garant[]= new String[4];
        String precio[] = new String[10];
        String abono ="";
        //Inicio de Consultas
        Conexion fac = new Conexion(dirIP);
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
          
         String p[]={"","Efect.","Cheque","Targ.C","Targ.D","Otro"}; 
         
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
            System.out.println("Error en La Consulta");
            e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error al Consultar Base de Datos","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        //Fin de Consultas
        
        Font letra = new Font("Arial",Font.ITALIC,9);
        Font letra2 = new Font("Arial",Font.BOLD,9);
        Font letra3 = new Font("Arial",Font.BOLD,10);        
        p_op = new JPanel();
        p_op.setBounds(20,420,320,80);
        p_op.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "OPCIONES", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        p_op.setLayout(null);        
        p_imp = new JPanel();
        p_imp.setBounds(20,20,320,400);
        p_imp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        p_imp.setLayout(null);
        p_imp.setBackground(Color.WHITE);        
        imprin = new JButton(new ImageIcon(getClass().getResource("Imagenes/impresora.png")));
        imprin.setBounds(70,20,52,52);
        //imprin.setIcon(new ImageIcon(getClass().getResource(new ImageIcon(getClass().getResource("Imagenes/impresora.png")));    
        imprin.setBackground(Color.WHITE);
        imprin.setToolTipText("Imprimir Contrato");
        b_zoom = new JButton(new ImageIcon(getClass().getResource("Imagenes/access.png")));
        //System.out.println(getClass().getResource("Imagenes/access.png"));
        b_zoom.setBounds(170,20,52,52);        
        //b_zoom.setIcon(new ImageIcon(getClass().getResource("\\Imagenes\\access.png")));
        b_zoom.setBackground(Color.WHITE);
        b_zoom.setToolTipText("Imprimir Terminos y Condiciones");
        b_zoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {              
               
              Term_Cond x = new Term_Cond();
               //PrintJob mip = getToolkit().getPrintJob(aux,"Contrato de Etiqueta "+idCto,null); 
              PrintJob mip = getToolkit().getPrintJob(aux,"Términos y Condiciones",null); 
           
               if(mip!=null){
               Graphics imp = mip.getGraphics();
               
               if(imp!=null){
                   x.PanelTerm().printAll(imp);                    
                    imp.dispose();
                    
               }
               }
               if(mip!=null){
               mip.end();
               }
              
            }
        });
        
        imprin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               PrintJob mip = getToolkit().getPrintJob(aux,"Contrato de Etiqueta "+idCto,null); 
             
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
        });
        /////Inicializaciones////////////
        image = new JLabel(new ImageIcon(getClass().getResource("Imagenes/L_Etiqueta.png")));     
       
        image.setBounds(10,10,50,50);
        
      //  i_letras = new JLabel(new ImageIcon(getClass().getResource("Imagenes/Letras.png")));       
        i_letras = new JLabel("D'Etiqueta y algo más C.A.");
        i_letras.setFont(new Font("Edwardian Script ITC",Font.BOLD,22));
        i_letras.setBounds(60,10,250,60);
        
        l_t_tien = new JLabel("~Alquiler Y Venta de Trajes Para Caballeros y Niños~");
        l_t_tien.setBounds(30,60,350,30);
        l_t_tien.setFont(new Font("Lucida Console",Font.BOLD,8));
        
        l_rif = new JLabel("RIF. J-29401378-3");
        l_rif.setBounds(200,50,100,30);
        
        l_rif.setFont(new Font("Lucida Console",Font.BOLD,8));
        l_title = new JLabel("CONTRATO Y CONTROL DE ALQUILER");
        l_title.setBounds(60,120,200,30);
        l_title.setFont(letra2);
        
        l_apell=new JLabel("Nombre o Razon Social: "+datos[1]);
        l_apell.setBounds(10,130,200,30);
        
        int gol=190,ref=70;
    boolean intro = false;    
  /////////////////////////////////////////////////////////////////////////////     
        if(datos[2].length()>=45){
                   intro = true;
                String d1 = "Direccion:"+datos[2].substring(0,45);
                String d2 = datos[2].substring(45,datos[2].length());
                gol = 140;
                l_nomb = new JLabel(d1);
                l_nomb.setBounds(10,gol,270,30);  
                gol+=10;
                JLabel ds = new JLabel(d2);
                ds.setBounds(10,gol,270,30);
                ds.setFont(letra);
                p_imp.add(ds);
        }else{
            gol = 140;
        l_nomb = new JLabel("Direccion: "+datos[2]);
        l_nomb.setBounds(10,gol,250,30);        
        }
        
        
        
        gol+=10;  
  /////////////////////////////////////////////////////////////////////////////      
        l_ced = new JLabel("RiF/Ced: "+datos[0]);
        l_ced.setBounds(10,gol,250,30);
        gol+=10;
        l_tel = new JLabel("Telefono:" + datos[3]);
        l_tel.setBounds(10,gol,250,30);
        gol+=20;
        l_descr = new JLabel("DESCRIPCION");
        l_descr.setBounds(70,gol,250,30);
        l_cod = new JLabel("CODIGO");
        l_cod.setBounds(10,gol,200,30);   
        gol+=10; 
        l_f_emi = new JLabel("Fecha de Emision:"+fechas[1]);
        l_f_emi.setBounds(150,110,220,30);
        l_f_emi.setFont(letra);
        
        l_num_con = new JLabel("Nº NF-"+idCto);
        l_num_con.setBounds(180,100,200,30);
        l_num_con.setFont(letra3);
        /////Inicializaciones////////////
        
                 
       
        java.net.URI n = null;
        String url = this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
       /////Manejo de Excepcion de Convesion TOURI//////    
        try {
                File aux = new File(new java.net.URL(url).toURI());
                n = aux.getParentFile().toURI();         
        }catch (Exception ex) {             
        }
        /////Manejo de Excepcion de Convesion TOURI//////  
            url = n.toString();        
            int val = url.indexOf("build");
            if(val>0){
                url = url+"classes/Imagenes/d_p.txt"; 
            }else{
                url = url+"Files/d_p.txt";
            }
            
     //////Abriendo Archivos///////      
            File dir=null;
            try{
                dir= new File(new java.net.URL(url).toURI());
            }
            catch(Exception e){ }
        if(dir.exists()){
               
            try {
                    BufferedReader entrada = new BufferedReader( new FileReader( dir ) ); 
                    while(entrada.ready()){
                    JLabel l_dir = new JLabel(entrada.readLine());
                     l_dir.setBounds(10,ref,250,30);
                     l_dir.setFont(new Font("Arial",Font.PLAIN,8));
                     p_imp.add(l_dir);
                     ref=ref+10;
                    }entrada.close();
                } catch (Exception e) {
                    
                }//fin catch
           
        }//fin if        
    //////Abriendo Archivos///////  
          
          
          
          /////MAXIMO 10 ARTICULOS POR FACTURA//////////////
        for (int i = 0; i < con; i++) {
     
       
         if(descrip[0].length()>30){
         l_des = new JLabel(descrip[i].substring(0,29)+"-");
         l_des.setBounds(70,gol,250,30);         
         l_des.setFont(letra);
         p_imp.add(l_des); 
         gol=gol+10;
         l_des = new JLabel(descrip[i].substring(29,descrip[i].length()));
         l_des.setBounds(70,gol,250,30);         
         l_des.setFont(letra);
         p_imp.add(l_des); 
       
         }else{
         l_des = new JLabel(descrip[i]);
         l_des.setBounds(70,gol,250,30);         
         l_des.setFont(letra);
         p_imp.add(l_des);   
         }//fin else
                     
         JLabel codes = new JLabel(codi[i]);
         codes.setBounds(10,gol,200,30);
         codes.setFont(letra);
         p_imp.add(codes);
         gol=gol+10;
                                }
            
                        
  
  gol=290;
 
        
        //parte inferior de la factura depende de gol
        l_t_pa = new JLabel("Total a Pagar(Bs.F): "+datos[5]);
        l_t_pa.setBounds(130,gol,250,30);
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
        if(pay[0]==null){
            pay[0]="";
        }
        if(pay[1]==null){
            pay[1]="";
        }
        if(pay[2]==null){
            pay[2]="";
        }
        if(pay[3]==null){
            pay[3]="";
        }
        if(pay[4]==null){
            pay[4]="";
        }
        //l_f_p = new JLabel("Forma de Pago: "+pay[0]+" "+pay[1]+" "+pay[2]);
        //l_f_p.setBounds(10,gol+20,350,30);
        l_gara = new JLabel("Garantia: "+Garant[0]+" "+Garant[1]+" "+Garant[2]);
        l_gara.setBounds(10,gol+20,350,30);   
        JLabel nota = new JLabel("Nota:");
        nota.setBounds(10,gol+30,350,30);
        if(datos[4]!=null){
        if(datos[4].length()>50){
        l_obser = new JLabel("Observaciones:"+datos[4].substring(0,45));//MAX 45 Caracteres
        l_obser.setBounds(10,gol+40,350,30);
        l_obser.setFont(letra);
        p_imp.add(l_obser);
        gol=gol+10;
        l_obser = new JLabel(datos[4].substring(45,datos[4].length()));//MAX 45 Caracteres
        l_obser.setBounds(10,gol+40,350,30);
        l_obser.setFont(letra);
        p_imp.add(l_obser);
        }else{
        
        l_obser = new JLabel("Observaciones:"+datos[4]);//MAX 45 Caracteres
        l_obser.setBounds(10,gol+40,350,30);
        l_obser.setFont(letra); 
        p_imp.add(l_obser);
        }}
        //fin else
        String spa = " ";
        l_f_en =  new JLabel("Fecha de Entrega:"+fechas[0]);
        l_f_en.setBounds(10,gol+50,260,30);
        l_f_dev = new JLabel("Fecha  de Devolucion: "+fechas[2]);
        l_f_dev.setBounds(145,gol+50,260,30);
        //l_congra = new JLabel("!!!Gracias por Preferirnos!!!");
       /// l_congra.setBounds(80,gol+70,250,30);
        //inicializando fuentes   
       /// l_congra.setFont(letra);
        l_con_pa.setFont(letra);
        l_f_dev.setFont(letra);
        l_f_en.setFont(letra);
        nota.setFont(letra);
        l_gara.setFont(letra);
        l_cod.setFont(letra2);       
        l_t_pa.setFont(letra2);      
                   
        l_apell.setFont(letra);
        l_nomb.setFont(letra);
        l_ced.setFont(letra);
        l_tel.setFont(letra);       
        l_descr.setFont(letra2);        
        p_op.add(imprin);        
        p_op.add(b_zoom);
       /// p_imp.add(l_congra);
        p_imp.add(l_num_con);
        p_imp.add(l_con_pa);
        p_imp.add(l_f_dev);
        p_imp.add(l_f_en);
     //   p_imp.add(l_f_p);      
        p_imp.add(nota);
        p_imp.add(l_gara);        
        p_imp.add(l_t_pa);
        p_imp.add(l_t_tien);
        p_imp.add(l_rif);
      ///  p_imp.add(l_bs);
        p_imp.add(l_cod);  
        p_imp.add(l_apell);
        p_imp.add(l_descr);        
       /// p_imp.add(l_pre);
       // p_imp.add(l_cant);
        p_imp.add(l_ced);
        p_imp.add(l_tel);        
        p_imp.add(l_nomb);
        p_imp.add(image);
        p_imp.add(l_f_emi);
        p_imp.add(l_title);
         p_imp.add(i_letras);
        //ventana.add(image);
        //ventana.add(imprin);
       
 }//fin     
    
}
