import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;



public class Render extends DefaultTableCellRenderer
{
   public Component getTableCellRendererComponent(JTable table,
      Object value,
      boolean isSelected,
      boolean hasFocus,
      int row,
      int column)
   {
      super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
      if(table.getModel().getValueAt(row,column)!=null){  
      boolean ban = true;    
      if (table.getModel().getValueAt(row,3).toString().indexOf("Tienda")>=0)
      {
         
         this.setOpaque(true);
         this.setBackground(Color.YELLOW);
         this.setForeground(Color.black);
         ban = false;
      }   
      if (table.getModel().getValueAt(row,3).toString().indexOf("Cliente")>=0)
      {
         this.setOpaque(true);
         this.setBackground(Color.orange);
         this.setForeground(Color.black);
         ban = false;
      }
         if (ban)
      {
         this.setOpaque(true);
         //this.setBackground(Color.ORANGE);
         this.setBackground(Color.black);
         this.setForeground(Color.YELLOW);
      }
      }//fin if global
      if(isSelected==true){
           this.setOpaque(true); 
         setBackground(null); 
          this.setForeground(Color.black);
      }
      return this;
   }
}