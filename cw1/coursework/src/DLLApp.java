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
		
		String menuMessage = "\nWhat do you want to do? L = List [L]andlords, P = List [P]roperties, B = [B]ad Properties, A = [A]dd TT Rating, R = Add Landlord [R]ating, C = [C]hange Landlord Status,  X = E[x]it";
		////// MAIN FUNCTION LOOP /////////
		System.out.println(menuMessage);
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
				//added extra menu option for Change Property Status
				}else if(s.equals("C")) {
					changePropertyStatus(in);
				}
				else {
					System.out.println("Command not recognised");
				}
			} catch (Exception e) {
				System.out.println("Something went wrong: "+e.toString() + "\n");
			}

			// output statement correct as it didn't include 'R = Add Landlord [R]ating'
			System.out.println(menuMessage);
			
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
	
	/* edited by Dante Chandler
	   * Added validation to check whether the input was a string
	   * Checks to see if inputs are in range
	   * Now produces error messages when an incorrect input is given and doesn't allow
	   * these erroneous inputs to be saved/used
	   */
	public static void addTTRating(Scanner in) {
	    ListProperties(false);
	    System.out.println("Which Property?");
	    in.nextLine(); 
	    String input = in.nextLine(); 

	    try {
	        int whichProperty = Integer.parseInt(input); 
	        if (whichProperty >= 1 && whichProperty <= AllProperties.size()) {  
	            DLLProperty temp = AllProperties.get(whichProperty - 1);
	            System.out.println("[T]oLet or To[I]let?");
	            String answer = in.nextLine();
	            if (answer.equals("T")) {
	                temp.addTTRating(true, false);
	                System.out.println("Rating added!");
	            } else if (answer.equals("I")) {
	                temp.addTTRating(false, true);
	                System.out.println("Rating added!");
	            } else {
	                System.out.print("Command not recognised.");
	            }
	        } else {
	            System.out.println("Property ID is out of range.");
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid input. Please enter a valid property number.");
	    }
	}



	
	/*
	 * function edited by: Nicholas Rutherfoord
	 */
	public static void addLandlordRatings(Scanner in) {
		ListLandlords();
		System.out.println("Which Landlord?");
		in.nextLine(); // for Read in bug.
		int lID = 0;
		try{
		 	lID = Integer.parseInt(in.nextLine());
			if(lID<1 || lID >AllLandlords.size()+1) {
				throw new IllegalArgumentException("Value is out of range");
			}
			DLLLandlord temp = AllLandlords.get(lID-1);
			System.out.println("What is the comms rating?");
			int cRating = Integer.parseInt(in.nextLine());
			System.out.println("What is the maintenance rating?");
			int mRating = Integer.parseInt(in.nextLine());
			

			/* as per the specification document it needs to catch an error froom addRatings.
			* addRatings method has validation testing for inputs 
			* adding this try and catch causesw testA14 and testA15 to pass
			*/
			temp.addRatings(cRating, mRating);
			System.out.println("Ratings added!");
			
		//Added catch within function,to catch all invalid inputs by the user and give standard error output
		}catch(Exception e){
			System.out.println("Didnt recognise those values...");
			return;

		}
		
		
	}
	
	
			
	/*Function created by: Nicholas Rutherfoord	
	 * its a function that allows a user to change the property status 
	 */
	public static void changePropertyStatus(Scanner in) {
		// not using ListProperties function as it would need to be called twice, to show good and bad properties in numerical order, which is less effecient
		for (int x=0; x<AllProperties.size(); x++) {
			DLLProperty temp = AllProperties.get(x);
			System.out.println((x+1)+") "+temp.toString());
		}
		
		
		System.out.println("Which Property?");
		in.nextLine(); // for Read in bug.
		
		try {
			int pID = Integer.parseInt(in.nextLine());
			if(pID<1 || pID >AllProperties.size()+1) {
				throw new IllegalArgumentException("Value is out of range");
			}
			DLLProperty temp = AllProperties.get(pID-1);
			System.out.println("What status would you like to set it to? D = Deactivated, A = Active, U = Under Review, R = Rented");
			String input = in.nextLine();

			switch(input){
				case "D":
					temp.setDeactivated(true);
					break;
				case "A":
					/*setting rented to false causes it be set to active*/
					temp.setRented(false);
					break;
				case "U":
					temp.setUnderReview(true);
					break;
				case "R":
					temp.setRented(true);
					break;
					
				default:
					throw new IllegalArgumentException("Value is out of range");
			}
		}catch(Exception e) {		
			System.out.println("Didnt recognise those values...");
			return;
		}
		
		
		
	}
}
