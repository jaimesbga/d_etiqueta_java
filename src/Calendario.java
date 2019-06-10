import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Calendario extends javax.swing.JDialog implements ActionListener{    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton anoMay;
    private javax.swing.JButton anoMen;
    private javax.swing.JButton b_aceptar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mesMay;
    private javax.swing.JButton mesMen;
    private javax.swing.JTable tabla;  
    private DefaultTableModel_M modeloTabla = null;
    private CalendarioEvento evento;
    
    private String vecMes[];
    private GregorianCalendar calendar;
    private Date dina;
    private String entry;
    private int mm;
    private int yy;
    private String agrega;
    private GregorianCalendar fechaAgrega;
    
    public Calendario(javax.swing.JFrame parent) {
        super(parent, true); 
        
        calendar = null;
        dina = null;
        agrega = "";
        
        initComponents();    
        cargarTabla();
        evento = new CalendarioEvento(tabla, this);
        tabla.getColumnModel().getSelectionModel().addListSelectionListener(evento);
        b_aceptar.setVisible(false);
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        int xf = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int yf = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(xf, yf));
        setVisible(true);
    }
    
     public Calendario(javax.swing.JFrame parent, String titulo) {
        super(parent, true); 
        
        calendar = null;
        dina = null;
        agrega = "";
        
        initComponents();    
        setTitle(titulo);
        setResizable(false);
        cargarTabla();
        evento = new CalendarioEvento(tabla, this);
        tabla.getColumnModel().getSelectionModel().addListSelectionListener(evento);
        b_aceptar.setVisible(false);
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        int xf = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int yf = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(xf, yf));
        setVisible(true);
    }
     
     public Calendario(javax.swing.JDialog parent, String titulo) {
        super(parent, true); 
        
        calendar = null;
        dina = null;
        agrega = "";
        
        initComponents();    
        setTitle(titulo);
        setResizable(false);
        cargarTabla();
        evento = new CalendarioEvento(tabla, this);
        tabla.getColumnModel().getSelectionModel().addListSelectionListener(evento);
        b_aceptar.setVisible(false);
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        int xf = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int yf = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(xf, yf));
        setVisible(true);
    }
    
    public Calendario(javax.swing.JDialog parent) {
        super(parent, true);
        
        calendar = null;
        dina = null;
        agrega = "";
        
        initComponents();  
        
        cargarTabla();
        
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
        setVisible(true);
    }
     
    private void initComponents() {
        fechaAgrega = (GregorianCalendar) GregorianCalendar.getInstance();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        mesMen = new javax.swing.JButton();
        mesMay = new javax.swing.JButton();
        anoMen = new javax.swing.JButton();
        anoMay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        b_aceptar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        b_cancelar.setMnemonic('C');

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fecha");
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione Fecha"));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"
            }
        ));
        tabla.setAutoscrolls(false);
        tabla.setColumnSelectionAllowed(true);
        tabla.setDoubleBuffered(true);
        jScrollPane1.setViewportView(tabla);

        mesMen.setText("<");

        mesMay.setText(">");

        anoMen.setText("<<");

        anoMay.setText(">>");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(anoMen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mesMen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mesMay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anoMay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anoMen)
                    .addComponent(mesMen)
                    .addComponent(mesMay)
                    .addComponent(anoMay))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        b_cancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(b_cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_cancelar)
                .addContainerGap())
        );
        pack();
        
        String meses = "Enero Febrero Marzo Abril Mayo Junio Julio Agosto Septiembre Octubre Noviembe Diciembre";
        vecMes = meses.split(" ");        
        
        mesMen.addActionListener(this);
        mesMay.addActionListener(this);
        anoMen.addActionListener(this);
        anoMay.addActionListener(this);
        b_aceptar.addActionListener(this);
        b_cancelar.addActionListener(this);
    }// </editor-fold>   
    
    public void cargarTabla(){
        for(int ii=0;ii<6;ii++){
            for(int jj=0;jj<7;jj++){
                tabla.setValueAt(null,ii,jj);
            }
        }
        try{
            if (dina==null){
                dina = new Date();
                calendar = new java.util.GregorianCalendar();
                calendar.setTime(dina);
                int mmm = calendar.get(java.util.Calendar.MONTH) ;   
                int yyy = calendar.get(java.util.Calendar.YEAR) ;   
                entry = "01/"+(mmm+1)+"/"+yyy;
            }
            dina = DateFormat.getDateInstance
            (DateFormat.SHORT,Locale.FRANCE).parse(entry);
            calendar = new GregorianCalendar();
            calendar.setTime(dina);            
        }
        catch(Exception er){ }        
        
        mm = calendar.get(Calendar.MONTH) ;   
        yy = calendar.get(Calendar.YEAR) ;   
        int px = calendar.get(Calendar.DAY_OF_WEEK)-1; 

        jLabel1.setText(vecMes[mm]+" - "+yy);
        
        int num;
        switch(mm){
            case 0: case 2: case 4: case 6: case 7: case 9: case 11:
                num=31;
                break;
            case 1:
                if((calendar.isLeapYear(yy))&&(yy%1000!=0))
                    num=29;
                else
                    num=28;
                break;
            default:
                num=30;
        }
        
        int cont=1;
        int x, y;
        x = px;
        y = 0;
        for(int ii=0;ii<num;ii++){
            tabla.setValueAt(cont, y, x);
            cont++;
            x++;
            if(x == 7){
                x=0;
                y++;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
	if(e.getSource() == anoMen){
            entry = "1/"+(calendar.get(Calendar.MONTH)+1)+"/"+(calendar.get(Calendar.YEAR)-1);
            cargarTabla();
	}
	if(e.getSource() == anoMay){
            entry = "1/"+(calendar.get(Calendar.MONTH)+1)+"/"+(calendar.get(Calendar.YEAR)+1);
            cargarTabla();
	}
	if(e.getSource() == mesMen){
            entry = "1/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR);
            cargarTabla();
	}
	if(e.getSource() == mesMay){
            entry = "1/"+(calendar.get(Calendar.MONTH)+2)+"/"+calendar.get(Calendar.YEAR);
            cargarTabla();
        }
        if(e.getSource() == b_aceptar){
            aceptar();
        }
        if(e.getSource() == b_cancelar){
            agrega = "";
            dispose();
        }
    }
    
    public void aceptar(){
        int xt = tabla.getSelectedColumn();
        int yt = tabla.getSelectedRow();
        if(xt>-1 && yt>-1 &&tabla.getValueAt(yt, xt) != null){
            if(mm<9){
                agrega = tabla.getValueAt(yt, xt).toString()+"/0"+(mm+1)+"/"+yy;
                fechaAgrega.set(yy, mm, Integer.parseInt(tabla.getValueAt(yt, xt).toString()));
            }
            else{
                agrega = tabla.getValueAt(yt, xt).toString()+"/"+(mm+1)+"/"+yy;
                fechaAgrega.set(yy, mm, Integer.parseInt(tabla.getValueAt(yt, xt).toString()));
            }
        }
        else{
            agrega = "";
        }
        dispose();
    }
    
    public String getAgrega(){
        return agrega;
    }    
    
    public GregorianCalendar getFechaAgrega(){
        return fechaAgrega;
    }

	public void setModeloTabla(DefaultTableModel_M modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public DefaultTableModel_M getModeloTabla() {
		return modeloTabla;
	}
}