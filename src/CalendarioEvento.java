import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CalendarioEvento implements ListSelectionListener{
    private JTable tabla;
    private Calendario calendario;
    
    public CalendarioEvento(JTable t, Calendario c) {
        tabla = t;
        calendario = c;
    }

    public void valueChanged(ListSelectionEvent e) {
        int fila = tabla.getSelectedRow();
        int columna = tabla.getSelectedColumn();
        if(fila >-1 && columna >-1){
            if(tabla.getValueAt(fila, columna)!=null && tabla.getValueAt(fila, columna).toString().compareTo("")!=0){
                calendario.aceptar();
            }
        }
    }
    
}
