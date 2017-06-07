package business.control;


public class ClientReportProxy extends ClientReport{
    protected String user, password;

    public ClientReportProxy(String user, String password) {
	this.user = user;
	this.password = password;
    }

    @Override
    public String getUserQuantity() {
        if (hasAccessPermission()) {
            return super.getUserQuantity();
	}
        return null;
    }

    @Override
    public String getConectedUsers() {
	if (hasAccessPermission()) {
            return super.getConectedUsers();
	}
	return null;
    }
    
    @Override
    public String getPurchaseQuantity() {
	if (hasAccessPermission()) {
            return super.getPurchaseQuantity();
	}
	return null;
    }

    private boolean hasAccessPermission() {
	return (user.equals("admin") && password.equals("admin")) || (user.equals("danillo") && password.equals("123"));
    }
}
