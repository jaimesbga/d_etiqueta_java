import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.xml.ws.handler.MessageContext;

public class PanelPedido extends JPanel{
    private JButton elimina;
    private JTable tabla;
    private DefaultTableModel_M tablamodel;
    private JScrollPane scroll1;
    private Object[][] obj = null;
    private int contador =0;
    /** Creates a new instance of PanelPedido */
    public PanelPedido(int x,int y,DefaultTableModel tablax) {
        super();
        this.setToolTipText("Articulos Agregados");
        this.setBounds(x,y,500,270);  
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Articulos Seleccionados", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)));
        this.setVisible(true);
        Inicializar(tablax);
        //tablamodel = (DefaultTableModel_M) tablax;
    }
    
///////////////////////////////////////////////    
void setTablamodelo(DefaultTableModel_M Modelo){
        tablamodel = Modelo;
        //tabla.setModel(Modelo);
        tama_colum(tabla);
}    
void Inicializar(DefaultTableModel tablax){
            elimina = new JButton("Eliminar Pieza");
            elimina.setBounds(175,230,150,20);
            elimina.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {                            
                   if(tabla.getSelectedRow()>=0){
                   
                    
                          for (int i = tabla.getSelectedRow(); i < 13; i++) {
                                    obj[i][0] = obj[i+1][0];
                                    obj[i][1] = obj[i+1][1];       
                          }
                            contador--;
                              tablamodel.removeRow(tabla.getSelectedRow());
                              tablamodel.setDataVector(obj,new String [] {
                "Código", "Descripción"
        });
                 tama_colum(tabla);
                    } 
                }
            });
            tablamodel = new DefaultTableModel_M();
            tablamodel = (DefaultTableModel_M) tablax;
            InicializaCarga();
            /*tablamodel = new DefaultTableModel_M(new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}    
            },
            new String [] {
                "Código", "Descripción"
        });*/
       scroll1 = new JScrollPane();  
       scroll1.setBounds(20,20,460,200);
        tabla = new JTable(tablamodel);     
        tabla.setBounds(20,20,460,90);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setSelectionMode(0);
        tama_colum(tabla);
        scroll1.setViewportView(tabla);
        this.add(elimina);
        this.add(scroll1);
}  

////setdatos////////////
void InicializaCarga(){
    obj = new Object[14][2];
    for (int i = 0; i < 14; i++) {
            obj[i][0] = tablamodel.getValueAt(i,0);
            obj[i][1] = tablamodel.getValueAt(i,1);
                if(obj[i][0]!=null&&obj[i][1]!=null){
                        contador++;
                }
    }
}
////////////////////////
void setdata(String d1,String d2){    
   if(!validaCodRepeat(d1,d1)){
          if(obj == null){
                obj = new Object[14][2];
                obj[0][0] = d1;
                obj[0][1] = d2;
                contador++;
          }else{
            obj[contador][0] = d1;
            obj[contador][1] = d2;
            contador++;
          }  
          tablamodel.setDataVector(obj,new String [] {
                "Código", "Descripción"
        });
        tama_colum(tabla);
   }else{
   JOptionPane.showMessageDialog(this,"Articulo Repetido... Ingrese Otro!!!!","Advertencia",JOptionPane.INFORMATION_MESSAGE);
           }
}
///////////////////////////////////////////////
boolean validaCodRepeat(String d1,String d2){
        for (int i = 0; i < contador; i++) {
                if(tablamodel.getValueAt(i,0).toString().compareTo(d1)==0){
                        return true;
                }
               
        }
         return false;
}

void tama_colum(JTable tab_p){
  int anchoColumna=0;
  int ancho=460;
  TableColumnModel model = tab_p.getColumnModel();
  TableColumn t;
  for (int i = 0; i <tab_p.getColumnCount(); i++) {
            t = model.getColumn(i);
            switch (i){
                case 0:anchoColumna=(25*ancho)/100;break;
                case 1:anchoColumna=(75*ancho)/100;break;                             
            }//fin switch
            t.setPreferredWidth(anchoColumna);
            t.setResizable(false);
  }//fin for
  }//fin tama colum
  
///////////////////////////////////////////////
DefaultTableModel_M getTablaModel(){
           return tablamodel;
}
///////////////////////////////////////////////

}
