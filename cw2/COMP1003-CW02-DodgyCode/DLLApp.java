import java.util.ArrayList;
import java.util.Scanner;

public class DLLApp {

	public static ArrayList<DLLLandlord> AllLandlords;
	public static ArrayList<DLLProperty> AllProperties;
	
	public static void main(String[] args) {
		AllLandlords = new ArrayList<DLLLandlord>();
		AllProperties = new ArrayList<DLLProperty>();
		
		//////TEST DATA//////
		DLLLandlord d1 = new DLLLandlord("Wax Milson","max@dll.com");
		AllLandlords.add(d1);
		DLLLandlord d2 = new DLLLandlord("Tammie Jycross","tammie@dll.com");
		AllLandlords.add(d2);
		DLLProperty p1 = new DLLProperty("1","NG8 1BB");
		p1.addTTRating(true, false);
		p1.addTTRating(true, false);
		p1.addTTRating(false, true);
		p1.addOccRating(4);
		AllProperties.add(p1);
		DLLProperty p2 = new DLLProperty("2","NG8 1CC");
		p2.addTTRating(false,true);
		AllProperties.add(p2);
		

		////// MAIN FUNCTION LOOP /////////
		System.out.println("\nWhat do you want to do? L = List [L]andlords, P = List [P]roperties, B = [B]ad Properties, A = [A]dd TT Rating, R = Add Landlord [R]ating, X = E[x]it");
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()) {
			String s = in.next();
			try {
				if (s.equals("X")) {
					System.out.println("Goodbye!");
					break;
				} else if (s.equals("P")) {
					ListProperties(false);
				} else if (s.equals("L")) {
					ListLandlords();
				} else if (s.equals("B")) {
					ListProperties(true);
				} else if (s.equals("A")) {
					addTTRating(in);
				} else if (s.equals("R")) {
					addLandlordRatings(in);
				}
				else {
					System.out.println("Command not recognised");
				}
			} catch (Exception e) {
				System.out.println("Something went wrong: "+e.toString() + "\n");
			}
			System.out.println("\nWhat do you want to do? L = List [L]andlords, P = List [P]roperties, B = [B]ad Properties, A = [A]dd TT Rating, X = E[x]it");
		}
		in.close();
	}
	
	public static void ListProperties(boolean showBad) {
		for (int x=0; x<AllProperties.size(); x++) {
			DLLProperty temp = AllProperties.get(x);
			if (showBad == false || (showBad & temp.getRating() < 2.5)) {
				System.out.println((x+1)+") "+temp.toString());
			}
		}
	}
	
	public static void ListLandlords() {
		for (int x=0; x<AllLandlords.size(); x++) {
			DLLLandlord temp = AllLandlords.get(x);
			System.out.println((x+1)+") "+temp.toString());
		}
	}
	
	public static void addTTRating(Scanner in) {
		ListProperties(false);
		System.out.println("Which Property?");
		in.nextLine(); // for Read in bug.
		int pID = Integer.parseInt(in.nextLine());
		DLLProperty temp = AllProperties.get(pID);
		System.out.println("[T]oLet or To[I]let?");
		String answer = in.nextLine();
		if (answer.equals("T")) {
			temp.addTTRating(true, false);
			System.out.println("Rating added!");
		} else if (answer.equals("I")) {
			temp.addTTRating(false, true);
			System.out.println("Rating added!");
		} else {
			System.out.print("Sorry, didnt get that choice...");
		}
	}
	
	public static void addLandlordRatings(Scanner in) {
		ListLandlords();
		System.out.println("Which Landlord?");
		in.nextLine(); // for Read in bug.
		int lID = Integer.parseInt(in.nextLine());
		DLLLandlord temp = AllLandlords.get(lID-1);
		System.out.println("What is the comms rating?");
		int cRating = Integer.parseInt(in.nextLine());
		System.out.println("What is the maintenance rating?");
		int mRating = Integer.parseInt(in.nextLine());
		if (mRating < 5 && cRating < 5) {
			temp.addRatings(cRating, mRating);
			System.out.println("Ratings added!");
		} else {
			System.out.println("Didnt recognise those values...");
		}
	}
	
	
	
	


}
