package RealEstate;

import java.util.Random;
import java.util.Scanner;

public class REO {
	static Listings lst = new Listings();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String choice;
		while (true) {
			menu(in);
			in.nextLine();
		}

	}

	// main Menu method. Calls the other menu methods
	public static void menu(Scanner in) {
		boolean done = false;
		String choice;
		while (!done) {
			System.out.println("\n-----------------------------------------");
			System.out.printf("%26s", "Main Menu\n");
			System.out.println("-----------------------------------------");
			System.out.println("\n1: Listings");
			System.out.println("2: Bids");

			System.out.print("\nWhat would you like to do? (1–2): ");
			choice = in.nextLine();

			if (choice.equals("")) {
				done = true;
			} else {
				switch (choice) {
				case "1":
					listingMenu(in);
					break;
				case "2":
					bidsMenu(in);
					break;
				default:
					System.out.println("Invalid response:  Please enter a choice from the menu (1-2)");
					break;
				}
			}
		}
	}// End Main Menu method

	// Listing Menu calls other menus
	public static void listingMenu(Scanner in) {
		boolean done = false;
		String choice;
		while (!done) {
			System.out.println("\n-----------------------------------------");
			System.out.printf("%27s", "Listing Menu\n");
			System.out.println("-----------------------------------------");
			System.out.println("\n1: Add Listing");
			System.out.println("2: Show Listings");
			System.out.println("3: Auto Populate Listings (Dev tool)");
			System.out.println("ENTER: Exit back to the previous menu.");
			System.out.print("\nWhat would you like to do? (1–3): ");
			choice = in.nextLine();

			if (choice.equals("")) {
				done = true;
				return;
			} else {

				switch (choice) {
				case "1":
					addListingMenu(in);
					break;
				case "2":
					showListing();
					break;
				case "3":
					autoPopulateListing();
					break;
				default:
					System.out.println("Invalid response:  Please enter a choice from the menu (1-3)");
					break;
				}
			}

		}

	}// End Listing

	// Listing Menu
	private static void addListingMenu(Scanner in) {
		boolean done = false;
		String choice;
		while (!done) {
			System.out.println("\n-----------------------------------------");
			System.out.printf("%29s", "Add Listing Menu\n");
			System.out.println("-----------------------------------------");
			System.out.println("\n1: Add House");
			System.out.println("2: Add Condo");
			System.out.println("ENTER: Exit back to the previous menu.");
			System.out.print("\nWhat would you like to do? (1–2): ");
			choice = in.nextLine();
			if (choice.equals("")) {
				done = true;
				return;
			} else {
				switch (choice) {
				case "1":
					addHouse(in);
					break;
				case "2":
					addCondo(in);
					break;
				default:
					System.out.println("Invalid response:  Please enter a choice from the menu (1-2)");
					break;

				}
			}
		}

	}// End Add Listing

	// Bids Menu
	private static void bidsMenu(Scanner in) {
		boolean done = false;
		String choice;
		while (!done) {
			System.out.println("\n-----------------------------------------");
			System.out.printf("%26s", "Bids Menu\n");
			System.out.println("-----------------------------------------");
			System.out.println("\n1: Add New Bid");
			System.out.println("2: Show Existing Bids");
			System.out.println("3: Auto Populate Bids (Dev Tool)");
			System.out.println("ENTER: Exit back to the previous menu.");

			System.out.print("\nWhat would you like to do? (1–3): ");
			choice = in.nextLine();

			if (choice.equals("")) {
				done = true;
				return;
			} else {
				switch (choice) {
				case "1":
					addBids(in, done);
					break;
				case "2":
					showBids(in, done);
					break;
				case "3":
					autoPopBids(in, done);
					break;
				default:
					System.out.println("Invalid response:  Please enter a choice from the menu (1-3)");
					break;
				}
			}
		}

	}// End Bids

	// Add Bids 
	public static void addBids(Scanner in, boolean done) {
		while (!done) {
			System.out.println("\nCurrent Listings for REO:");
			System.out.println("No.      Property (bids)");
			System.out.println("---------------------------------------");

			String[] addresses = lst.getStreetAddresses().toArray(new String[0]);
			for (int i = 0; i < lst.getListingCount(); i++) {
				String key = addresses[i];
				Residential value = lst.getListing(key);
				System.out.printf("%d: %s (%d)%n", i + 1, key, value.getBidCount());
			}

			System.out.println("ENTER: Exit back to previous menu");

			int result = 0;
			boolean skip = false;
			while (!skip) {
				System.out.print("\nFor which property would you like to add a bid?: ");
				String choice = in.nextLine();

				if (choice.equals("")) {
					done = true;
					skip = true;

				} else {
					try {
						result = Integer.parseInt(choice);
						if (result > lst.getListingCount()) {
							System.out.println("\nNumber not an option, returning to previous menu.");
						} else {
							skip = true;
						}
					} catch (Exception e) {
						System.out.printf("%s%n%n", "Please, enter a valid number!");
					}
					String key = addresses[result - 1];

					Residential glove = lst.getListing(key);

					System.out.println(glove);

					System.out.print("Please enter the name of the bidder: ");
					String name = in.nextLine();

					double price = getValidDouble(in, "Please enter the new bid: $");

					glove.newBid(name, price);

					System.out.printf("%nNew bid for property '%s' added.%n", key);

				}
			}
			skip = false;
		}
	}// End Add Bids

	//Show Bids
	public static void showBids(Scanner in, boolean valid) {
		while (!valid) {
			System.out.println("\nCurrent Listings for REO:");
			System.out.println("No.      Property (bids)");
			System.out.println("---------------------------------------");

			String[] addresses = lst.getStreetAddresses().toArray(new String[0]);
			for (int i = 0; i < lst.getListingCount(); i++) {
				String key = addresses[i];
				Residential value = lst.getListing(key);
				System.out.printf("%d: %s (%d)%n", i + 1, key, value.getBidCount());
			}

			System.out.println("ENTER: Exit back to previous menu.\n");

			int result = 0;
			boolean skip = false;
			while (!skip) {
				System.out.print("\nFor which property would you like to see a bid?: ");
				String choice = in.nextLine();

				if (choice.equals("")) {
					valid = true;
					skip = true;

				} else {
					try {
						result = Integer.parseInt(choice);
						if (result > lst.getListingCount()) {
							System.out.println("\nNumber not an option, returning to previous menu.");
						} else {
							skip = true;
						}
					} catch (Exception e) {
						System.out.printf("%s%n%n", "Please, enter a valid number!");
					}
					String key = addresses[result - 1];

					Residential glove = lst.getListing(key);

					System.out.println(glove);

					System.out.println("\nCurrent bids for this listing:\n");
					System.out.println("---------------------------------------");
					System.out.println("Bidder              Bid");
					System.out.println("---------------------------------------");

					for (int i = 0; i < glove.getBidCount(); i++) {
						String person = (String) glove.getBidders().toArray()[i];
						double gotBid = glove.getBid(person);
						System.out.printf("%s\t$%,.2f\n", person, gotBid);
					}
					System.out.println("\n");
				}
			}
			skip = false;
		}
	}//End Show Bids

	//Auto Pop Bids
	public static void autoPopBids(Scanner in, boolean valid) {
		// Hard Coded set of names to be used as bidders

		String[] autoBidders = { "Patric Stewart", "Walter Koenig", "William Shatner", "Leonard Nimoy",
				"DeForect Kelley", "James Doohan", "George Takei", "Majel Barrett", "Nichelle Nichol", "Jonathan Frank",
				"Marina Sirtis", "Brent Spiner", "Gates McFadden", "Michael Dorn", "LeVar Burton", "Wil Wheaton",
				"Colm Meaney", "Michelle Forbes" };

		// Use the random index number to select a random bidder and use the appraisal
		// price * some percentage to generate a bid amount.
		int intMax = 7;
		int intMin = 2;

		for (int i = 0; i < lst.getResidences().size(); i++) {
			Random r = new Random();
			int intRandom17 = (int) (Math.random() * ((intMax - intMin) + 1)) + intMin;

			while (intRandom17 > 0) {
				int index = r.nextInt((autoBidders.length - 1) + 1);
				Residential res = (Residential) lst.getResidences().toArray()[i];

				double max = 0.17;
				double min = 0.01;
				res.newBid(autoBidders[index],
						res.calculateAppraisalPrice() * (1 + (Math.random() * ((max - min) + 1)) + min));
				intRandom17--;
			}

		}
		System.out.println("\n");

		String[] addressArray = lst.getStreetAddresses().toArray(new String[0]);
		for (int i = 0; i < lst.getListingCount(); i++) {
			String key = addressArray[i];
			Residential value = lst.getListings().get(key);

			System.out.printf("%d new bids have been added to listing %s.\n", value.getBidCount(), key);

		}

	}// End autoPopBids

	// add House Method
	private static void addHouse(Scanner in) {
		System.out.print("\nPlease enter the street address for the residence: ");
		String address = in.nextLine();

		System.out.print("Please enter the zip code for the residence: ");
		String zip = in.nextLine();

		int bed = getValidInt(in, "Please enter the number of bedrooms: ");
		int bath = getValidInt(in, "Please enter the number of bathrooms: ");
		double sq = getValidDouble(in, "Please enter the square footage of the residence: ");
		double acres = getValidDouble(in, "Please enter the size of the yard in acres: ");

		House house = new House(address, zip, bed, bath, sq, acres);

		System.out.printf("%nAppraisal Price for this property is: $%,.2f", house.calculateAppraisalPrice());
		house.setListPrice(getValidDouble(in, "\nPlease enter the List Price for the property: $"));

		lst.addListing(address, house);

		System.out.println("\nYou have created a new listing!");

		System.out.println(house);

	}// end Add House

	private static void addCondo(Scanner in) {
		System.out.print("\nPlease enter the street address for the residence: ");
		String address = in.nextLine();

		System.out.print("Please enter the zip code for the residence: ");
		String zip = in.nextLine();

		int bed = getValidInt(in, "Please enter the number of bedrooms: ");
		int bath = getValidInt(in, "Please enter the number of bathrooms: ");
		double sq = getValidDouble(in, "Please enter the square footage of the residence: ");
		int floor = getValidInt(in, "Please enter the floor level of the condo: ");

		Condo condo = new Condo(address, zip, bed, bath, sq, floor);

		System.out.printf("%nAppraisal Price for this property is: $%,.2f", condo.calculateAppraisalPrice());
		condo.setListPrice(getValidDouble(in, "\nPlease enter the List Price for the property: $"));

		lst.addListing(address, condo);

		System.out.println("\nYou have created a new listing!");

		System.out.println(condo);

	}

	private static void showListing() {
		int num = 1;

		System.out.print("\nCurrent Listings for REO:");
		for (Residential i : lst.getResidences()) {
			System.out.printf("%nListing No: %d%n", num);
			System.out.println(i);
			num++;
		}
	}

	private static void autoPopulateListing() {
		System.out.print("\n8 residences have been added to the listings for testing purposes.\n");
		House house1 = new House("34 Elm", "95129", 3, 2, 2200, .2);
		house1.setListPrice(house1.calculateAppraisalPrice() * 1.1);
		lst.addListing("34 Elm", house1);
		House house2 = new House("42 Hitchhikers", "95136", 4, 3, 2800, .3);
		house2.setListPrice(house2.calculateAppraisalPrice() * 1.1);
		lst.addListing("42 Hitchhikers", house2);
		Condo condo1 = new Condo("4876 Industrial", "95177", 3, 1, 1800, 3);
		condo1.setListPrice(condo1.calculateAppraisalPrice() * 1.1);
		lst.addListing("4876 Industrial", condo1);
		House house3 = new House("2654 Oak", "84062", 5, 53, 4200, .5);
		house3.setListPrice(house3.calculateAppraisalPrice() * 1.1);
		lst.addListing("2654 Oak", house3);
		Condo condo2 = new Condo("9875 Lexington", "84063", 2, 1, 1500, 1);
		condo2.setListPrice(condo2.calculateAppraisalPrice() * 1.1);
		lst.addListing("9875 Lexington", condo2);
		Condo condo3 = new Condo("3782 Market", "84066", 3, 1, 1800, 2);
		condo3.setListPrice(condo3.calculateAppraisalPrice() * 1.1);
		lst.addListing("3782 Market", condo3);
		House house4 = new House("7608 Glenwood", "84055", 6, 3, 3900, .4);
		house4.setListPrice(house4.calculateAppraisalPrice() * 1.1);
		lst.addListing("7608 Glenwood", house4);
		House house5 = new House("1220 Apple", "84057", 8, 7, 7900, 1);
		house5.setListPrice(house5.calculateAppraisalPrice() * 1.1);
		lst.addListing("1220 Apple", house5);
	}

	public static int getValidInt(Scanner in, String question) {
		boolean valid = false;
		int value = 0;
		String input = "";
		while (!valid) {
			System.out.print(question);
			input = in.nextLine();
			try {
				value = Integer.parseInt(input);
				valid = true;
			} catch (Exception e) {
				System.out.printf("%s%n%n", "Please, enter a valid number!");
			} // end try/catch
		} // end while(!valid)
		return value;
	} // end getValidInt()

	// FLOAT Validation
	public static double getValidDouble(Scanner in, String question) {
		boolean valid = false;
		double value = 0.0;
		String input = "";
		while (!valid) {
			System.out.print(question);
			input = in.nextLine();
			try {
				value = Double.parseDouble(input);
				valid = true;
			} catch (Exception e) {
				System.out.printf("%s%n%n", "Please, enter a valid number!");
			} // end try/catch
		} // end while (!valid)
		return value;
	} // getValidDouble()

}
