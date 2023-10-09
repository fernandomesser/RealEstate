package RealEstate;

import java.util.HashMap;
import java.util.Set;

public interface Bidable {

	public abstract HashMap<String, Double> getBids();

	public abstract Double getBid(String x);

	public abstract Set<String> getBidders();

	public abstract int getBidCount();

	public abstract void newBid(String key, Double value);

}
