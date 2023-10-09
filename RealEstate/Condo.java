package RealEstate;

public class Condo extends Residential {
	// Attributes
	private double floorLvl;

	// Constructors
	public Condo() {
		super();
		floorLvl = 0;
	}

	public Condo(String ad, String z, int a, int b, double f, double l) {
		super(ad, z, a, b, f);
		floorLvl = l;
	}

	// Methods

	public double getFloorLvl() {
		return floorLvl;
	}

	public void setFloorLvl(double l) {
		floorLvl = l;
	}

	@Override
	public double calculateAppraisalPrice() {
		double squareFoot = 88;
		double bedroom = 8000;
		double bathroom = 10000;
		double floor = 5000;
		double price = squareFoot * getSize() + bedroom * getBeds() + bathroom * getBaths() + floor * (getFloorLvl()-1);
		setAppraisalPrice(price);
		return price;
	}
	
	public String toString() {
		String line1 = String.format(
				"\n-------------------------------------------------------------------------------------------------------\n");
		String line2 = String.format("Residence Type: %-20s Address: %-32s Zip Code: %-12s", "Condo", getStreetAddress(), getZip());
		String line3 = String.format(
				"\n-------------------------------------------------------------------------------------------------------\n");
		String line4 = String.format("Sq Footage: %.0f\nBedrooms: %d\nBathrooms: %d\nFloor: %.0f",
				getSize(), getBeds(), getBaths(), getFloorLvl());
		String line5 = String.format("\n------------------------------------------\n");
		String line6 = String.format("Appraisal Price: $%,.2f\nList Price: $%,.2f", calculateAppraisalPrice(),
				getListPrice());
		String line7 = String.format("\n------------------------------------------");
		String output = line1 + line2 + line3 + line4 + line5 + line6 + line7;
		return output;

	}

}
