package buisness;

public class Product {
	
	private int id;
	private int vendorId;
	private String partNumber;
	private String name;
	private double Price;
	private String unit;
	private String photoPath;
	
	public Product() {
		super();
	}

	public Product(int id, int vendorId, String partNumber, String name, double price, String unit, String photoPath) {
		super();
		this.id = id;
		this.vendorId = vendorId;
		this.partNumber = partNumber;
		this.name = name;
		Price = price;
		this.unit = unit;
		this.photoPath = photoPath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", vendorId=" + vendorId + ", partNumber=" + partNumber + ", name=" + name
				+ ", Price=" + Price + ", unit=" + unit + ", photoPath=" + photoPath + "]";
	}
	
}
