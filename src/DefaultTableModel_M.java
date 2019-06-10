import javax.swing.table.DefaultTableModel;

public class DefaultTableModel_M extends DefaultTableModel{
    public DefaultTableModel_M(){
        super();   
    }
    
    public DefaultTableModel_M(Object[][] data,Object[] ColumnNames){
      super(data,ColumnNames);        
    }
 
    public boolean isCellEditable (int row, int column){
        return false;
    }//fin funcion

 
    
}
