public class DLLLandlord {

  /* Code edited by Dante Chandler
   * Added the variable nameHasBeenSet to monitor whether a lanlord's
   * name has been set already
   */
  private String landlordName;
  private String landlordEmailAddress;
  private double landlordCommsRating;
  private int numCommsRatings;
  private double landlordMaintenanceRating;
  private int numMaintenanceRatings;
  private boolean landlordNew;
  private boolean nameHasBeenSet = false;

  public DLLLandlord() {
    landlordName = null;
    landlordEmailAddress = null;
    landlordCommsRating = 0.0;
    numCommsRatings = 0;
    landlordMaintenanceRating = 0.0;
    numMaintenanceRatings = 0;
    landlordNew = true;
  }

  public DLLLandlord(String lName, String lEmail) {
    landlordName = lName;
    landlordEmailAddress = lEmail;
    landlordCommsRating = 0.0;
    numCommsRatings = 0;
    landlordMaintenanceRating = 0.0;
    numMaintenanceRatings = 0;
    landlordNew = true;
  }

  //GETTERS

  public String landlordName() {
    return landlordName;
  }

  public String landlordEmailAddress() {
    return landlordEmailAddress;
  }

  public double landlordCommsRating() {
    return landlordCommsRating;
  }

  public double landlordMaintenanceRating() {
    return landlordMaintenanceRating;
  }

  public boolean landlordNew() {
    return landlordNew;
  }

  //SETTERS
  
  /* Code edited by Dante Chandler
   * Added an if statement to check prior to anything being changed whether
   * a Landlord name had already been entered and if so, it would throw an error
   * at them, if not code would continue as normal
   */
  public void setlandlordName(String lName) {
	    if (nameHasBeenSet) {
	      throw new IllegalStateException("Landlord name has already been set");
	    }
	    if (lName.contains(" ") && lName.length() >= 5) {
	      landlordName = lName;
	      nameHasBeenSet = true; 
	    }
	  }

  /* Code edited by Dante Chandler
   * Using the class I made at the bottom of the page, I used an if statement
   * to check whether the email being input was valid and if it was valid then 
   * landlordEmailAddress would be updated, if not a error message would be output
   */
  public void setlandlordEmailAddress(String lEmail) {
	    if (!isValidEmail(lEmail)) {
	      throw new IllegalArgumentException("Invalid email address provided");
	    }
	    landlordEmailAddress = lEmail;
	  }

  /*code edited by Nicholas Rutherfoord
   * maintenanceRating had logic error of adding cRating insread or mRating
   * needs to throw error if cRating or mRating is less than 1 or greater than 5
   * also num rating variables need to use pre-increment
   */
  /* Code edited by Dante Chandler
   * Added an if statement at end to check whether there have been 10 of each rating 
   * , if so, landlordNew is set to false
   */
  public void addRatings(int cRating, int mRating) {
	    if (cRating < 1 || mRating < 1 || cRating > 5 || mRating > 5) {
	      throw new IllegalArgumentException("Rating is out of range");
	    } else {
	      landlordCommsRating =
	        ((landlordCommsRating * numCommsRatings) + cRating) /
	        (++numCommsRatings);
	      landlordMaintenanceRating =
	        ((landlordMaintenanceRating * numMaintenanceRatings) + mRating) /
	        (++numMaintenanceRatings);
	      
	      if (numCommsRatings + numMaintenanceRatings >= 20) {
	        landlordNew = false;
	      }
	    }
	  }

  // OTHER METHODS
 
  /*Code edited by Nicholas Rutherfoord
   * needs an if statement to determine if landlord is new or not and different output if so
   * needs the out of '/5' for rating values and rating needs to be casted to int
   */
  @Override
  public String toString() {
    if (landlordNew) {
      return landlordName + " (New Landlord)";
    }
    return (
      landlordName +
      " - Communication: " +
      (int) landlordCommsRating +
      "/5, Maintenance: " +
      (int) landlordMaintenanceRating +
      "/5"
    );
  }

  /* Code edited by Dante Chandler
   * Made new class which checks to see if the email is in a valid form, this is a very standard
   * model which allows uppercase, lowercase, numbers and other characters
   * It checks whether there's an at symbol, but not at the start or end
   */
  private boolean isValidEmail(String email) {
    String modelEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    return email.matches(modelEmail);
  }
}