
public class Contact {

	//instance variables
	private String FirstName;
	private String LastName;
	private String Email;
	private String Phone;
	
	//Constructor with fields
	public Contact(String firstName, String lastName, String email, String phone) {
		super();
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.Phone = phone;
	}

	//empty Constructor
	public Contact() {
		super();
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		this.LastName = lastName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		this.Email = email;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		this.Phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", Phone=" + Phone
				+ "]";
	}
	
	//TODO format display of contact here
	public String displaycontact() {
		String str = "--------------------------------------------\n";
		str += "---- Current Contact -----------------------\n";
		str += "--------------------------------------------\n";
		str += "Name: " +FirstName+ " " + LastName+ "\n";
		str += "Email Address: " +Email+ "\n";
		str += "Phone Number: " +Phone+ "\n";
		str += "--------------------------------------------";
		return str;
		
	}


	}
	
	