
public class Ciclo extends Thread{
   private boolean conti = false;          
    public void run(){
        int cont = 0;
            while(conti){
                System.out.println(cont++);
            }
    }//fin void run
    void detener(){    
    conti=false;
    }
}
