package business.control;


public class ReportProxy extends ClientReport{
    protected String user, password;

    public ReportProxy(String user, String password) {
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

	private boolean hasAccessPermission() {
		return (user.equals("admin") && password.equals("admin")) || (user.equals("danillo") && password.equals("123"));
	}
}
