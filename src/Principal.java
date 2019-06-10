import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JTextField;

public class Principal {    
   
    public Principal() {
    }
    
    public static void main(String[] args) throws Exception{   
        
        //CrearNuevoContrato obj = new CrearNuevoContrato("127.0.0.1", "01");
        
        //EditarNuevoContrato obj = new EditarNuevoContrato("127.0.0.1", 1);
        
        /*Conexion con = new Conexion("localhost", "d_etiqueta", "detiqueta");
        con.conectar();
        ResultSet resp = con.consultar("select * from COLOR_ACCESORIOS");
        while(resp != null && resp.next()){
            System.out.println(resp.getString("id")+"-"+resp.getString(2));
        }        
        //con.actualizar("insert into clientes values('187626410','aa','aa','aa','','','')");        
        con.desconectar();*/
        
        //Iniciar ini = new Iniciar();
        
        //AgregarAccesorio obj = new AgregarAccesorio("127.0.0.1");        
        
        //JTextField texto = new JTextField();
        //AgregarCliente obj = new AgregarCliente("127.0.0.1", false, null);
        //AgregarCliente obj = new AgregarCliente("127.0.0.1", "18000000", texto);
        
        //AgregarCliente2 obj = new AgregarCliente2("127.0.0.1", true, texto);
        //AgregarCliente2 obj = new AgregarCliente2("127.0.0.1", "18762641", texto);
        //System.out.println(texto.getText());
        
        //CrearContrato obj = new CrearContrato("127.0.0.1","01");        
        
        //Menu obj = new Menu("127.0.0.1", "01");
        
        //BuscarContrato obj = new BuscarContrato(new javax.swing.JFrame(), "127.0.0.1");
        
        //EditarContrato obj = new EditarContrato("127.0.0.1", 5);
        
        //BuscarPedidos obj = new BuscarPedidos("127.0.0.1");
        
        //RespaldoDatos obj = new RespaldoDatos("127.0.0.1");
        
        Inicio obj = new Inicio();
        
        //Factura obj = new Factura(new javax.swing.JFrame(),"5","127.0.0.1");
        
        //InformeDiario obj = new InformeDiario("127.0.0.1");
        
        //InformeMensual obj = new InformeMensual("127.0.0.1");
        
        //TimeSeriesChartDemo1 demo = new TimeSeriesChartDemo1();
        
        //PieChartDemo1 demo = new PieChartDemo1();
        
        //GraficaAnual obj = new GraficaAnual("127.0.0.1");
        
        //GraficaAccesorios obj = new GraficaAccesorios("127.0.0.1");
        
        /*DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ROOT);
        Date d1 = df.parse("03/01/09");     //d1>d2 -> 1
        Date d2 = df.parse("02/01/09");     //d1<d2 -> -1
        System.out.println(d1.compareTo(d2));*/
        
        /*Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(a.getHeight());
        System.out.println(a.getWidth());*/
        
    }
    
}
