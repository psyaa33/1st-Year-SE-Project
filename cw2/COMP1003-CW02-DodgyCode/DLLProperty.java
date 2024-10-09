
public class DLLProperty {
	private int propertyNumber;
	private String propertyPostCode;
	private int toletCount;
	private int toiletCount;
	private double occupantRating;
	private int occRatingCount;
	private boolean underReview;
	private boolean deactivated;
	private boolean rented;
	
	public DLLProperty() {
		propertyNumber = 0;
		propertyPostCode = null;
		toletCount = 0;
		toiletCount = 0;
		occupantRating = 0.0;
		occRatingCount = 0;
		underReview = true;
		deactivated = false;
		rented = false;
	}
	
	public DLLProperty(String pNumber, String pPC) {
		propertyNumber = Integer.parseInt(pNumber);
		propertyPostCode = pPC;
		toletCount = 0;
		toiletCount = 0;
		occupantRating = 0.0;
		occRatingCount = 0;
		underReview = true;
		deactivated = false;
		rented = false;
	}
	
	//GETTERS
	public String propertyNumber() {
		return String.valueOf(propertyNumber);
	}
	
	public String propertyPostCode() {
		return propertyPostCode;
	}
	
	public int getRating() {
		double TTScore = (((double)toletCount / (toletCount+toiletCount)) * 100)/20;
		double combinedRating = (occupantRating + TTScore)/2;
		return (int) Math.round(combinedRating);
	}
	
	public double getTTRating() {
		double TTpercentage = ((double)toletCount / (toletCount+toiletCount)) *100;
		return Math.round(TTpercentage / 20);
	}
	
	public double getOccRating() {
		return occupantRating;
	}
	
	public boolean isUnderReview() {
		return underReview;
	}
	
	public boolean getVisibleStatus() {
		return (!underReview && !deactivated && !rented);
	}
	
	//SETTERS
	public void setPropertyAddress(String pNumber, String pPC) {
		propertyNumber = Integer.parseInt(pNumber);
		if (pPC.length() < 8) {
			propertyPostCode = pPC;
		}
	}
	
	public void addTTRating(boolean tolet, boolean toilet) {
		if (tolet) {
			toletCount++;
		}
		if (toilet) { 
			toiletCount++;
		}
	}
	
	public void addOccRating(int oRating) {
		occupantRating = ((occupantRating * occRatingCount) + oRating) / (++occRatingCount);
	}
	
	public void setUnderReview(boolean newStatus) {
		underReview = newStatus;
	}
	
	public void setDeactivated(boolean newStatus) {
		deactivated = newStatus;
	}
	
	public void setRented(boolean newStatus) {
		rented = newStatus;
	}
	
	//OTHER METHODS
	@Override
	public String toString() {
		String tempStatus = "";
		if (rented) {
			tempStatus = "Rented";
		} else if (underReview) {
			tempStatus = "Under Review";
		} else if (deactivated) {
			tempStatus = "Deactivated";
		} else {
			tempStatus = "Active";
		}
		return propertyNumber + " " + propertyPostCode + " (" + tempStatus + ") - Rating: " + getTTRating();
	}
	

	
}
