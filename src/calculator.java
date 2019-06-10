import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame implements ActionListener  {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5094080882968528426L;
	boolean nuevo = true;
    float   resultado_total = 0.0f;
    String  ultimo = "=";
    JTextField pantalla = null;
    JButton b;
    JPanel panel, panel2;

    public calculator(JFrame parent) {
    
      //super(parent,true);
       setBounds(0,0,315,250);
                setLayout(null);
                setTitle("Calculadora");
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                setResizable(false);
                 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                 Dimension frameSize = getSize(); 
                 setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.width) / 2));
        Pantalla();

        Teclado();
        setVisible(true);
   }

   private void Pantalla() {

      
        pantalla = new JTextField();

        pantalla.setText("0");
        pantalla.setAlignmentY(JLabel.LEFT_ALIGNMENT);
        pantalla.setBounds(5,5,300,20);
        
        pantalla.setEditable(false);
        pantalla.setForeground(Color.black);
        pantalla.setBackground(Color.white);
        add(pantalla);
       
   }

    public void Teclado () {
        
       // panel2.setLayout(new GridLayout(4, 4));
       
        addBoton("7", Color.blue,5,30);
        addBoton("8", Color.blue,65,30);
        addBoton("9", Color.blue,125,30);
        addBoton("/", Color.red,185,30);
        addBoton("C", Color.red,245,30);

        addBoton("4", Color.blue,5,75);
        addBoton("5", Color.blue,65,75);
        addBoton("6", Color.blue,125,75);
        addBoton("*", Color.red,185,75);
        addBoton("sqrt", Color.red,245,75);

        addBoton("1", Color.blue,5,120);
        addBoton("2", Color.blue,65,120);
        addBoton("3", Color.blue,125,120);
        addBoton("-", Color.red,185,120);
        addBoton("AC", Color.red,245,120);

        addBoton("0", Color.blue,5,165);
        addBoton("+/-", Color.red,65,165);
        addBoton(".", Color.red,125,165);
        addBoton("+", Color.red,185,165);
        addBoton("=", Color.YELLOW,245,165);

        
  }

  private void addBoton(String n, Color color,int x,int y) {
       b = new JButton(n);

       b.setForeground(color);
       b.setBackground(Color.LIGHT_GRAY);
      
       b.setBounds(x,y,60,45);
       b.addActionListener( this );
         add(b);
  }


  public void actionPerformed(ActionEvent event) {

        String digit   = event.getActionCommand();
        String s     = pantalla.getText();

        // Logic based in a source of Santiago Pavón

        float  valor = 0;
        try {
            valor = new Float(s).floatValue();
        } catch (Exception e) {
            if (!digit.equals("C")) return;
        }

        if ("0123456789".indexOf(digit) != -1) {

            if (nuevo) {
                nuevo = false;
                pantalla.setText(digit);
            } else {
                pantalla.setText(s + digit);
            }

        } else if (digit.equals(".")) {

            if (nuevo) {
                nuevo = false;
                pantalla.setText("0.");
            } else {
                pantalla.setText(s + digit);
            }

        } else if (digit.equals("sqrt")) {

            valor = (float)Math.sqrt(valor);
            pantalla.setText(String.valueOf(valor));
            nuevo = true;

        } else if (digit.equals("+/-")) {

            valor = -valor;
            pantalla.setText(String.valueOf(valor));
            nuevo = true;

        } else if (digit.equals("C")) {

            resultado_total  = 0;
            pantalla.setText("0");
            ultimo = "=";
            nuevo = true;

        } else {

            char c = ultimo.charAt(0);

            switch (c) {
                case '=': resultado_total  = valor; break;
                case '+': resultado_total += valor; break;
                case '-': resultado_total -= valor; break;
                case '*': resultado_total *= valor; break;
                case '/': resultado_total /= valor; break;
            }
      ultimo = digit;
      nuevo = true;
      pantalla.setText(String.valueOf(resultado_total));
  }
}
}
