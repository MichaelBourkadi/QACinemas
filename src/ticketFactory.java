public class ticketFactory {
	 public static Ticket getType(String ticketType){	
	Ticket myTicket = new StandardTicket(); //this line is the initialise myTicket

switch (ticketType) {
case "Standard": myTicket = new StandardTicket();
break;
case "OAP": myTicket = new OAPTicket();
break;
case "Student": myTicket = new StudentTicket();
break;
case "Child": myTicket = new ChildTicket();
break;
}
	      return myTicket;
}}
