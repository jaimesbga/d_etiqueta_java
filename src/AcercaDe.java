import java.awt.Dimension;
import java.awt.Toolkit;

public class AcercaDe extends javax.swing.JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2550359234796843556L;
	private javax.swing.JLabel jLabel1;
    
    public AcercaDe(javax.swing.JFrame parent) {
        super(parent, true);
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int)(d.getWidth()/2-this.getWidth()/2), (int)(d.getHeight()/2-this.getHeight()/2));
    }
                           
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("D' Etiqueta - Acerca de");
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/init.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        pack();
    }   
}