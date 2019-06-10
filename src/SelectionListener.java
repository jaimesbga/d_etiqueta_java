import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class SelectionListener implements ListSelectionListener {
    JTable table;
    private String Ban=null;
    private Calendar_Colisiones aux;
    public SelectionListener(JTable table,Calendar_Colisiones aux) {
        this.aux=aux;        
        this.table = table;
    }

    public void valueChanged(ListSelectionEvent e) {
   
        try{
         if(Ban!=table.getModel().getValueAt(table.getSelectedRow(),0).toString()){
         aux.load_tabla();
        System.out.println(table.getModel().getValueAt(table.getSelectedRow(),0));        
        Ban = table.getModel().getValueAt(table.getSelectedRow(),0).toString();
        aux.Pinta_Fecha(Ban);
         }//fin if
         }catch(Exception ex){        
        }
   
    }//fin value Change
    
}//fin class
