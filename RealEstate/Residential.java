package RealEstate;

import java.util.HashMap;
import java.util.Set;

public abstract class Residential extends Property implements Bidable {
	// Attributes
	private int bedCount;
	private int bathCount;
	private double sqFootage;
	private HashMap<String, Double> bids;

	// Constructors
	public Residential() {
		super();
		bedCount = 0;
		bathCount = 0;
		sqFootage = 0;
		bids = new HashMap<String, Double>();
	}

	public Residential(String ad, String z, int a, int b, double f) {
		super(ad, z);
		bedCount = a;
		bathCount = b;
		sqFootage = f;
		bids = new HashMap<String, Double>();
	}

	// Methods
	public int getBeds() {
		return bedCount;
	}

	public void setBeds(int a) {
		bedCount = a;
	}

	public int getBaths() {
		return bathCount;
	}

	public void setBaths(int b) {
		bathCount = b;
	}

	public double getSize() {
		return sqFootage;
	}

	public void setSize(double f) {
		sqFootage = f;
	}

	public abstract double calculateAppraisalPrice();

	@Override
	public HashMap<String, Double> getBids() {
		return bids;
	}

	@Override
	public Double getBid(String key) {
		return bids.get(key);
	}

	@Override
	public Set<String> getBidders() {
		return bids.keySet();
	}

	@Override
	public int getBidCount() {
		return bids.size();
	}

	@Override
	public void newBid(String key, Double value) {
		bids.put(key, value);
	}

}
