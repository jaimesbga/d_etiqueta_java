import javax.swing.JOptionPane;

public class Tool_Code {
    
  
    public Tool_Code() {
    }
    
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
                }
                if(a1.charAt(0)=='0'){
                   return a2; 
                }else{
                    return a1.toUpperCase() + a2 + a3;
                }
           }//fin if general
        
            return null;
      }//fin funcion
    
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
