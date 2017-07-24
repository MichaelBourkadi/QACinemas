import java.util.Calendar;

abstract class Ticket implements ticketType {
	int basePrice;
	public abstract void setBasePrice();
	private int price;
	
	public void discount() {
		Calendar now = Calendar.getInstance();
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK); 
		if (dayOfWeek == 4) {	
			price = basePrice - 2;
		}
		
		else {
			price = basePrice;}
		}
		
	public int getPrice() {
		return price;
	}
}