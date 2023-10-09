package RealEstate;

public abstract class Property {
	// Attributes

	private double listPrice;
	private double appraisalPrice;
	private String streetAddress;
	private String zip;

	// Constructors

	public Property() {
		listPrice = 0;
		appraisalPrice = 0;
		streetAddress = "";
		zip = "";
	}

	public Property(String ad, String z) {
		streetAddress = ad;
		zip = z;
	}
	// Methods

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String ad) {
		streetAddress = ad;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String z) {
		zip = z;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double l) {
		listPrice = l;
	}

	public double getApraisalPrice() {
		return appraisalPrice;
	}

	protected void setAppraisalPrice(double x) {
		appraisalPrice = x;
	}

	public abstract double calculateAppraisalPrice();

}
