import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class RespaldoDatos {
    private JFrame ventana;
    private JPanel panel;
    private JButton b_iniciar, b_cancelar;
    private JTextArea memo;
    private JScrollPane scroll;
    private JLabel imagen;
    private BufferedWriter escribir;
    
    private String dirIP;
    private Conexion con;
    
    public RespaldoDatos(String ip) {
        dirIP = ip;
        
        iniciarVentana();       
        
        con = new Conexion(dirIP);
        
        ventana.setVisible(true);
    }
    
    public void iniciarVentana(){
        ventana = new JFrame();
        ventana.setTitle("D' Etiqueta - Respaldar Datos");
        ventana.setSize(500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(ventana.DISPOSE_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setLocation((int)(d.getWidth()/2-ventana.getWidth()/2), (int)(d.getHeight()/2-ventana.getHeight()/2));
        ventana.setResizable(false);
        
        imagen = new JLabel();
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo-Contrato.gif")));
        imagen.setBounds(0,20,537,49);
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Detalles", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        panel.setBounds(20,100,460,300);
        panel.setLayout(null);
        
        memo = new JTextArea();
        memo.setBounds(20,40,420,220);
        memo.setFont(new Font("Arial",Font.PLAIN,14));
        memo.setEditable(false);
        memo.append("Presione 'Iniciar' para comenzar con el Respaldo...");
        
        scroll = new JScrollPane(memo);
        scroll.setBounds(20,40,420,220);
        
        panel.add(scroll);
        
        b_iniciar = new JButton("Iniciar");
        b_iniciar.setMnemonic('I');
        b_iniciar.setBounds(100,415,100,30);
        b_iniciar.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    iniciar();
                }
        });
        b_cancelar = new JButton("Cerrar");
        b_cancelar.setMnemonic('C');
        b_cancelar.setBounds(300,415,100,30);
        b_cancelar.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ventana.setVisible(false);
                    con.desconectar();
                    ventana.dispose();
                }
        });
        
        ventana.add(imagen);
        ventana.add(panel);
        ventana.add(b_iniciar);
        ventana.add(b_cancelar);
    }
    
    public void iniciar(){
        int error = 0;
        try{
            JFileChooser seleccionador = new JFileChooser();
            seleccionador.setSelectedFile(new File("Respaldo.txt"));
            if(seleccionador.showSaveDialog(ventana)==0){
                String ruta = seleccionador.getSelectedFile().getPath();
                File archivoSalida= new File(ruta);
                escribir = new BufferedWriter(new FileWriter(archivoSalida));
            }
            else{
                error = 1;
            }
        }
        catch(Exception e){
            error = 1;
        }
        
        if(con.conectar() == 0){
            JOptionPane.showMessageDialog(ventana,"No se pudo conectar con el Servidor", "Advertencia", JOptionPane.OK_OPTION);
            error = 1;
        }
        if(error == 0){
            memo.append("\nIniciando Respaldo de Datos...");
            b_iniciar.setEnabled(false);
            guardar("TIENDAS", 7);
            guardar("CLIENTES", 7);
            guardar("TIPO_ACCESORIOS", 2);
            guardar("FORMA_ACCESORIOS", 2);
            guardar("COLOR_ACCESORIOS", 4);
            guardar("MARCA_ACCESORIOS", 2);
            guardar("UBICACIONES", 2);
            guardar("MOTIVOS", 2);
            guardar("TIPOS_PAGO", 2);
            guardar("ACCESORIOS", 8);
            guardar("CONTRATOS", 8);
            guardar("OBSERVACIONES", 3);
            guardar("ITEMS", 5);
            guardar("PAGOS", 7);
            
            try{
                escribir.close();
                con.desconectar();
                memo.append("\nFinalizado respaldo de Datos");
                memo.append("\nRespaldo Exitoso");
                b_iniciar.setEnabled(true);
            }
            catch(Exception e){
                //System.out.println("error");
            }
        }
    }
    
    public void guardar(String tabla, int campos){
        if(con.getEstado() == 1){
            memo.append("\nGuardando "+tabla+"...");
            String query = "select * from "+tabla;
            
            if(tabla.compareToIgnoreCase("CONTRATOS")==0){
                query = "select ID, to_char(FECHA_EMISION, 'DD/MM/YYYY'), to_char(FECHA_ENTREGA, 'DD/MM/YYYY'), to_char(FECHA_DEVOLUCION,'DD/MM/YYYY'), "
                        + "TOTAL_PAGAR, ESTADO, CTE_CEDULA, TDA_ID from CONTRATOS";
            }
            if(tabla.compareToIgnoreCase("PAGOS")==0){
                query = "select ID, OBSERVACION, MONTO, to_char(FECHA, 'DD/MM/YYYY'), CTO_ID, TPGO_ID, MVO_ID from PAGOS";
            }
            
            String order = " order by ";
            if(tabla.compareToIgnoreCase("CLIENTES") == 0){
                order = order + "CEDULA";
            }
            else{
                order = order + "ID";
            }
            query = query + order;
            try{                
                java.sql.ResultSet res = con.consultar(query);
                while(res.next()){
                    String linea = "insert into "+tabla+" values (";
                    for(int i=0;i<campos;i++){
                        if(i == campos-1){
                            if(res.getString(i+1)!=null){
                                linea = linea + "'"+res.getString(i+1)+"');";
                            }
                            else{
                                linea = linea + "'');";
                            }
                        }
                        else{
                            if(res.getString(i+1)!=null){
                                linea = linea + "'"+res.getString(i+1)+"', ";
                            }
                            else{
                                linea = linea + "'', ";
                            }
                        }
                    }
                    escribir.write(linea);
                    escribir.newLine();
                }
                memo.append("\nGuardado "+tabla+"...");
            }
            catch(Exception e){ System.out.println("error");
            }
        }
    }
}
