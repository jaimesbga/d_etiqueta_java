import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Sample_Es extends JFrame{
    static private String SITIO_1 = "D'Etiqueta";
    /** Creates a new instance of Sample_Es */
    public Sample_Es() {
        super("Estadisticas - 2009");
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                 Dimension frameSize = getSize(); 
                 setLocation(new Point(150,100));
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(100, SITIO_1, "Ene");
        dataset.setValue(120, SITIO_1, "Feb");
        dataset.setValue(110, SITIO_1, "Mar");
        dataset.setValue(103, SITIO_1, "Abr");
        dataset.setValue(106, SITIO_1, "May");
        dataset.setValue(50, SITIO_1, "Jun");
        dataset.setValue(16, SITIO_1, "Jul");
        dataset.setValue(166, SITIO_1, "Ago");
        dataset.setValue(106, SITIO_1, "Sep");
        dataset.setValue(176, SITIO_1, "Octe");
        dataset.setValue(86, SITIO_1, "Nov");
        dataset.setValue(206, SITIO_1, "Dic");
        JFreeChart chart = ChartFactory.createBarChart3D("Ingresos - 2009", "Meses",
   "Bs.F.", dataset, PlotOrientation.VERTICAL, true,
   true, false);
     
    ChartPanel panel = new ChartPanel(chart);
    
    getContentPane().add(panel);
    pack();    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation((int)(d.getWidth()/2-this.getWidth()/2), (int)(d.getHeight()/2-this.getHeight()/2));
    
    setVisible(true);
    }
    
}
