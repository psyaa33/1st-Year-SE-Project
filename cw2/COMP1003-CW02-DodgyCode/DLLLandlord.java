
public class DLLLandlord {
	private String landlordName;
	private String landlordEmailAddress;
	private double landlordCommsRating;
	private int numCommsRatings;
	private double landlordMaintenanceRating;
	private int numMaintenanceRatings;
	private boolean landlordNew;
	
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
	public void setlandlordName(String lName) {
		if (lName.contains(" ") && lName.length() >= 5) {
			landlordName = lName;
		}
	}
	
	public void setlandlordEmailAddress(String lEmail) {
		if (lEmail.contains("@")) {
			landlordEmailAddress = lEmail;
		}
	}
	
	public void addRatings(int cRating, int mRating) {
		landlordCommsRating = ((landlordCommsRating * numCommsRatings) + cRating) / (numCommsRatings++);
		landlordMaintenanceRating = ((landlordMaintenanceRating * numMaintenanceRatings) + cRating) / (numMaintenanceRatings++);
	}
	
	
	
	// OTHER METHODS
	@Override
	public String toString() {
		return landlordName + " - Communication: " + landlordCommsRating + ", Maintenance: " + landlordMaintenanceRating;
	}

	
	
}
