public class DLLProperty {

  private int propertyNumber;
  private String propertyPostCode;
  private int toletCount;
  private int toiletCount;
  private double occupantRating;
  private int occRatingCount;
  private int propertyStatus;

  public DLLProperty() {
    propertyNumber = 0;
    propertyPostCode = null;
    toletCount = 0;
    toiletCount = 0;
    occupantRating = 0.0;
    occRatingCount = 0;
    setUnderReview(true);
  }

  public DLLProperty(String pNumber, String pPC) {
    propertyNumber = Integer.parseInt(pNumber);
    propertyPostCode = pPC;
    toletCount = 0;
    toiletCount = 0;
    occupantRating = 0.0;
    occRatingCount = 0;
    setUnderReview(true);
  }

  //GETTERS
  public String propertyNumber() {
    return String.valueOf(propertyNumber);
  }

  public String propertyPostCode() {
    return propertyPostCode;
  }
  /*code edited by Nicholas Rutherfoord
   * changed from Math.round to Math.ceil
   */
  public int getRating() {
    double TTScore = (((double) toletCount / (toletCount + toiletCount)) * 100) / 20;
    double combinedRating = (occupantRating + TTScore) / 2;
    return (int) Math.ceil(combinedRating);
  }
  /*code edited by Nicholas Rutherfoord
   * changed from Math.round to Math.ceil
   */
  public double getTTRating() {
    double TTpercentage =
      ((double) toletCount / (toletCount + toiletCount)) * 100;
    return Math.ceil(TTpercentage / 20);
  }
  
  /* edited by Dante Chandler
   * Created new function that returns the total number of ToLet/Toilet reviews left
   * on a property
   */
  public int getTTRatingCount() {
	    return toletCount + toiletCount;
	}


  public double getOccRating() {
	  return occupantRating;
  }

  /*edited by Muhammad Saad
   * checks if propertyStatus = 1, the method returns true, indicating that the property is under review
   * Otherwise, it returns false
   */
  public boolean isUnderReview() {
	  return propertyStatus == 1;
  }

  /*edited by Muhammad Saad
   * Additional condition propertyStatus == 2 to check if the property status is "active".
   * Ensures property is only considered visible if it both active and meets other requirements with it. 
   */
  public boolean getVisibleStatus() {
	  return propertyStatus == 2;
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

  /*edited by Dante Chandler
   * Added an if statement to check whether the integer being input was in range of 1-5 
   */
  public void addOccRating(int oRating) {
	    if (oRating >= 1 && oRating <= 5) {
	      occupantRating = ((occupantRating * occRatingCount) + oRating) / (++occRatingCount);
	    } else {
	      throw new IllegalArgumentException("Invalid rating provided: " + oRating);
	    }
	  }
  /*edited by Nicholas Rutherfoord
   * using propertyStatus to be set to 1 instead of underReview = true
   */
  public void setUnderReview(boolean newStatus) {
    if (newStatus) {
      propertyStatus = 1;
    } else {
      propertyStatus = 2;
    }
  }

  /*edited by Nicholas Rutherfoord
   * using propertyStatus to be set to 0 instead of decativated = true
   */
  public void setDeactivated(boolean newStatus) {
    if (newStatus) {
      propertyStatus = 0;
    } else {
      propertyStatus = 1;
    }
  }

  /*edited by Nicholas Rutherfoord
   * using propertyStatus to be set to 3 instead of rented = trues
   */
  public void setRented(boolean newStatus) {
    if (newStatus) {
      propertyStatus = 3;
    } else {
      propertyStatus = 2;
    }
  }

  //OTHER METHODS

  /*edited by Nicholas Rutherfoord
   * should use getRating() and not getTTRating()
   * if statements should use propertyStatus to determine tempStatus
   * used a switch case instead as more effecient and legible
   */
  @Override
  public String toString() {
    String tempStatus = "";

    switch (propertyStatus) {
      case 0:
        tempStatus = "Deactivated";
        break;
      case 1:
        tempStatus = "Under Review";
        break;
      case 2:
        tempStatus = "Active";
        break;
      case 3:
        tempStatus = "Rented";
        break;
    }

    return (
      propertyNumber +
      " " +
      propertyPostCode +
      " (" +
      tempStatus +
      ") - Rating: " +
      getRating() +
      "/5"
    );
  }
}
