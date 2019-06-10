import java.sql.*;

public class Conexion {    
    private String ip;
    private String usuario;
    private String clave;
    private int estado;
    
    private Connection con;
    
    public Conexion(String dirIP) {
        ip = dirIP;
        usuario = "root";
        clave = "123456";
        estado = 0;
    }
    
    public int conectar(){
    	
    		try {
                Class.forName("com.mysql.jdbc.Driver");            
                con = DriverManager.getConnection("jdbc:mysql://" + ip + "/sistematrajes", usuario, clave);            
                con.setAutoCommit(true);
                System.out.println("Conexion Establecida");
                return 1;
            }
            catch (Exception e) {
            	System.out.println("Conexion Fallida");
            	e.printStackTrace();
                return 0;
            }
	
    }
    
    public int _conectar(){
        String url = "jdbc:oracle:thin:@"+ip+":1521:XE";
        con = null;

        try {
            // Definicion del nombre COMPLETO de la clase que sirve como driver
        	Class.forName("com.mysql.jdbc.Driver"); 
            String driver = "oracle.jdbc.driver.OracleDriver";
            // Aqui se registra el driver de la base de datos
            Class.forName(driver).newInstance();
        }
        catch (Exception e) {
            // Ocurrio un error al registrar el driver
            System.out.println("Conexion: No se pudo cargar el driver Oracle");
            //e.printStackTrace();
            estado = 0;
            return 0;
        }
        
        try {
            // De esta forma se obtiene la conexion
            con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexion establecida.");
            estado = 1;
            return 1;
            //------------------------------------------------------------------
            // Aqui ir¡an las operaciones con la base de datos
            // ...
            /*Statement consulta = con.createStatement();
            String query = "select * from new";
            ResultSet rsl = consulta.executeQuery(query);       
            while(rsl.next()){
                System.out.println(rsl.getString("cedula")+" "+rsl.getString("nombre"));
            }*/
            //------------------------------------------------------------------
        }
        catch (SQLException sqle) {
            // Ocurrio un error con la conexion
            System.out.println("Conexion: Error con la conexion a la base de datos:");
            //sqle.printStackTrace();
            estado = 0;
            return 0;
        }  
    }
    
    public ResultSet consultar(String query){
        if (con != null) {
            try{
                Statement consulta = con.createStatement();
                return consulta.executeQuery(query); 
            }
            catch(SQLException sqle){
                System.out.println("Conexion: Error en la consulta.");
                sqle.printStackTrace();
                return null;
            }
            catch(Exception er){
                return null;
            }
        }
        else{
            return null;
        }
    }
    
    public int actualizar(String query){
        if (con != null) {
            try{
                Statement consulta = con.createStatement();
                consulta.executeUpdate(query); 
                return 1;
            }
            catch(SQLException sqle){
                System.out.println("Conexion: Error en la actualizacion.");
                //sqle.printStackTrace();
                return 0;
            }
        }
        else{
            return 0;
        }
    }
    
    public int desconectar(){
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexion terminada.");
            }
            catch (SQLException sqle) {
                System.out.println("Conexion: Error al desconectar");
                //sqle.printStackTrace();
                return 1;
            }
        }
        return 0;
    }
    
    public int getEstado(){
        return estado;
    }
}
