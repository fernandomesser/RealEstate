package RealEstate;

public class House extends Residential {
	// Attributes

	private double yardAcres;

	// Constructors

	public House() {
		super();
		yardAcres = 0;
	}

	public House(String ad, String z, int a, int b, double f, double y) {
		super(ad, z, a, b, f);
		yardAcres = y;
	}

	// Methods

	public double getYardAcres() {
		return yardAcres;
	}

	public void setYardAcres(double y) {
		yardAcres = y;

	}

	@Override
	public double calculateAppraisalPrice() {
		double squareFoot = 97;
		double bedroom = 10000;
		double bathroom = 12000;
		double acreP = 460000;
		double price = squareFoot * getSize() + bedroom * getBeds() + bathroom * getBaths() + acreP * getYardAcres();
		setAppraisalPrice(price);
		return price;
	}

	public String toString() {
		String line1 = String.format(
				"\n-------------------------------------------------------------------------------------------------------\n");
		String line2 = String.format("Residence Type: %-20s Address: %-32s Zip Code: %-12s", "House", getStreetAddress(), getZip());
		String line3 = String.format(
				"\n-------------------------------------------------------------------------------------------------------\n");
		String line4 = String.format("Sq Footage: %.0f\nBedrooms: %d\nBathrooms: %d\nYard Size (Acres): %.2f",
				getSize(), getBeds(), getBaths(), getYardAcres());
		String line5 = String.format("\n------------------------------------------\n");
		String line6 = String.format("Appraisal Price: $%,.2f\nList Price: $%,.2f", calculateAppraisalPrice(),
				getListPrice());
		String line7 = String.format("\n------------------------------------------");
		String output = line1 + line2 + line3 + line4 + line5 + line6 + line7;
		return output;

	}

}
