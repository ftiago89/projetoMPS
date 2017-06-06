package business.control;

//Class to simulate users and purchases quantities for a report.
public class ClientReport {
    private int usersQuantity;
    private int conectedUsers;
    private int PurchasesQuantity;

	public ClientReport() {
		this.usersQuantity = (int) (Math.random() * 100);
		this.conectedUsers = (int) (Math.random() * 10);
		this.PurchasesQuantity = (int) (Math.random() * 50);
	}

	public String getUserQuantity() {
		return new String("Users total number: " + this.usersQuantity);
	}

	public String getConectedUsers() {
		return new String("Conected users: " + this.conectedUsers);
	}
	
	public String getPurchaseQuantity() {
		return new String("Purchases: " + this.PurchasesQuantity);
	}
}
