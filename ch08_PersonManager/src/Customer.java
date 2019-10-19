
public class Customer extends Person {
	private String customerNumber;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String customerNumber) {
		super(firstName, lastName);
		this.customerNumber = customerNumber;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public String toString() {
		return super.toString() + "\n"
				+ "Customer Number: " +customerNumber;
		
	}
	
	
	

	
	

}
