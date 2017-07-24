import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QACinemas extends JFrame {
	
	private static final long serialVersionUID = 1L;

	JLabel StandardLabel;
	JLabel OAPLabel;
	JLabel StudentLabel;
	JLabel ChildLabel;
	JLabel CheckoutLabel;
	JButton StandardButton;
	JButton OAPButton;
	JButton StudentButton;
	JButton ChildButton;
	JButton CheckoutButton;
	JButton ResetButton;
	
	//These integers refer to the number of tickets purchased
	int StudentTickets;
	int OAPTickets;
	int StandardTickets;
	int ChildTickets;
	
	
	public static int returnPrice(String inputType){
		Ticket myTicket =  ticketFactory.getType(inputType);
		int price = calculatePrice(myTicket);
		return price;
	}
	
	public QACinemas() {
		setLayout(new FlowLayout());
		

		StandardLabel = new JLabel(StandardTickets+"x");
		add(StandardLabel);
		
		StandardButton = new JButton("£" + returnPrice("Standard") + " Standard");
		add(StandardButton);
		StandardButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				StandardTickets++;
				StandardLabel.setText("x" + StandardTickets);
				//prices are updated
				StandardButton.setText("£" + returnPrice("Standard") + " Standard");
				OAPButton.setText("£" + returnPrice("OAP") + " OAP");
				StudentButton.setText("£" + returnPrice("Student") + " Student");
				ChildButton.setText("£" + returnPrice("Child") + " Child");
		}});
			
	
	OAPLabel = new JLabel(OAPTickets+"x");
	add(OAPLabel);
	
	OAPButton = new JButton("£" + returnPrice("OAP") + " OAP");
	add(OAPButton);
	OAPButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			OAPTickets++;
			OAPLabel.setText("x" + OAPTickets);
			//prices are updated
			StandardButton.setText("£" + returnPrice("Standard") + " Standard");
			OAPButton.setText("£" + returnPrice("OAP") + " OAP");
			StudentButton.setText("£" + returnPrice("Student") + " Student");
			ChildButton.setText("£" + returnPrice("Child") + " Child");
	}});
	
	StudentLabel = new JLabel(StudentTickets+"x");
	add(StudentLabel);
	
	StudentButton = new JButton("£" + returnPrice("Student") + " Student");
	add(StudentButton);
	StudentButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			StudentTickets++;
			StudentLabel.setText("x" + StudentTickets);
			//prices are updated
			StandardButton.setText("£" + returnPrice("Standard") + " Standard");
			OAPButton.setText("£" + returnPrice("OAP") + " OAP");
			StudentButton.setText("£" + returnPrice("Student") + " Student");
			ChildButton.setText("£" + returnPrice("Child") + " Child");
	}});
	
	ChildLabel = new JLabel(ChildTickets+"x");
	add(ChildLabel);
	
	ChildButton = new JButton("£" + returnPrice("Child") + " Child");
	add(ChildButton);
	ChildButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			ChildTickets++;
			ChildLabel.setText("x" + ChildTickets);
			//prices are updated
			StandardButton.setText("£" + returnPrice("Standard") + " Standard");
			OAPButton.setText("£" + returnPrice("OAP") + " OAP");
			StudentButton.setText("£" + returnPrice("Student") + " Student");
			ChildButton.setText("£" + returnPrice("Child") + " Child");
	}});
	
	CheckoutLabel = new JLabel("Press checkout when you have finished your selection.");
	CheckoutButton = new JButton("Checkout");
	add(CheckoutButton);
	add(CheckoutLabel);
	CheckoutButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			int total = StandardTickets*returnPrice("Standard")+OAPTickets*returnPrice("OAP")+StudentTickets*returnPrice("Student")+ChildTickets*returnPrice("Child");
			CheckoutLabel.setText("The sum of your tickets comes to £"+total);
			//prices are updated
			StandardButton.setText("£" + returnPrice("Standard") + " Standard");
			OAPButton.setText("£" + returnPrice("OAP") + " OAP");
			StudentButton.setText("£" + returnPrice("Student") + " Student");
			ChildButton.setText("£" + returnPrice("Child") + " Child");
			

		}});
	
	ResetButton = new JButton("Reset");
	add(ResetButton);
		ResetButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			repaint();
			StandardTickets=0;
			OAPTickets=0;
			StudentTickets=0;
			ChildTickets=0;
			StandardLabel.setText("x" + StandardTickets);
			OAPLabel.setText("x" + OAPTickets);
			StudentLabel.setText("x" + StudentTickets);
			ChildLabel.setText("x" + ChildTickets);
			CheckoutLabel.setText("Press checkout when you have finished your selection.");
			//prices are updated
			StandardButton.setText("£" + returnPrice("Standard") + " Standard");
			OAPButton.setText("£" + returnPrice("OAP") + " OAP");
			StudentButton.setText("£" + returnPrice("Student") + " Student");
			ChildButton.setText("£" + returnPrice("Child") + " Child");
		}});	
	}
	
	public static int calculatePrice(Ticket myTicket) {
		myTicket.setBasePrice();
		myTicket.discount();
		int price = myTicket.getPrice();
		return price;
	}
	
	public static void main(String[] args) {
		QACinemas GUI = new QACinemas();
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setSize(500, 100);
		GUI.setVisible(true);
		GUI.setTitle("QA Cinemas");
	}
	


}
