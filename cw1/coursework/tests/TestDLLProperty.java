import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

class TestDLLProperty {
	
	/*Author: Abdulla Al-Ali
	 * Default Constructor
	 * Initializes a property with default values: "X" for number and "XXXX XXX" for postcode, all counts set to 0, and status set to under review.
	 */
	
	@Test
	public void testP1() {
	    DLLProperty property = new DLLProperty();
	    assertFalse(property.getVisibleStatus(), "Property should not be visible when under review");
	}

	/*Author: Abdulla Al-Ali
	 * Main Constructor
	 * Initializes a property with specified number and postcode if valid, applies default settings for all other values.
	 */
	
	@Test
	public void testP2() {
	    DLLProperty property = new DLLProperty("123", "AB1 2CD");
	    assertFalse(property.getVisibleStatus(), "Status should still make property not visible when under review");
	}

	/*Author: Abdulla Al-Ali
	 * getPropertyNumber
	 * Returns the property number as a string.
	 */
	
	@Test
	public void testP3() {
	    DLLProperty property = new DLLProperty("123", "AB1 2CD");
	    assertEquals("123", property.propertyNumber(), "Getting property number should return '123'");
	}

	/*Author: Abdulla Al-Ali
	 * getPropertyPostCode
	 * Returns the property postcode as a string.
	 */
	
	@Test
	public void testP4() {
	    DLLProperty property = new DLLProperty("123", "AB1 2CD");
	    assertEquals("AB1 2CD", property.propertyPostCode(), "Getting property postcode should return 'AB1 2CD'");
	}

	

	/*Author: Muhammad Saad
	* Combine ToLet/Toilet ratio with occupant rating
	*/
	
	@Test
	void testP5() {
    DLLProperty property = new DLLProperty();
    property.addTTRating(true, true);
    property.addTTRating(true, true);
    property.addOccRating(4);
    int expectedRating = 4;
    System.out.println("Start of test");
    System.out.println(property.getRating());
    assertEquals(expectedRating, property.getRating());
    System.out.println("End of test");
    
  }

	/*Author: Muhammad Saad
	* Converts TT balance to a star rating out of 5
	*/
  // Review by: Nicholas Rutherfoord
  	@Test
  	void testP6() {
    DLLProperty property = new DLLProperty();
    property.addTTRating(true, true);
    property.addTTRating(true, true);
    int expectedRating = 3;
    assertEquals(expectedRating, property.getTTRating());
  }

  	/*Author: Muhammad Saad
	* Return the raw double for the occupant rating
	*/
  // Reviewed by: Nicholas Rutherfoord
  	@Test
  	void testP7() {
    DLLProperty property = new DLLProperty();
    property.addOccRating(4);
    double expectedTTRating = 4.0;
    assertEquals(expectedTTRating, property.getOccRating());
  }

  	/*Author: Muhammad Saad
	* Return true if the property is under review
	*/
  // Reviewed by: Nicholas Rutherfoord
  	@Test
  	void testP8()throws NoSuchFieldException, IllegalAccessException {
	  final DLLProperty property = new DLLProperty();
	  
	  final Field field = property.getClass().getDeclaredField("propertyStatus");
	  field.setAccessible(true);
	  
	  field.set(property, 1);
	  boolean underReview = property.isUnderReview();
	  field.set(property, 3);
	  boolean notUnderReview = property.isUnderReview();
	  assertTrue(underReview);
	  assertFalse(notUnderReview);
  }

  	
  	/*Author: Muhammad Saad
	* Check if property is visible when active and not visible when under review
	*/

  	@Test
  	void testP9() throws NoSuchFieldException, IllegalAccessException {
	  final DLLProperty property = new DLLProperty();
	  
	  final Field field = property.getClass().getDeclaredField("propertyStatus");
	  field.setAccessible(true);
	  field.set(property, 2);
	  
	  assertTrue(property.getVisibleStatus());
	  
	  //test for decativated
	  field.set(property, 0);
	  assertFalse(property.getVisibleStatus());
	  
	  //test for under review
	  field.set(property, 1);
	  assertFalse(property.getVisibleStatus());
	  
	  //test for rented
	  field.set(property, 3);
	  assertFalse(property.getVisibleStatus());
  }

    @Test
    /*Author: Dante Chandler
     * Test checks that the setPropertyAddress() function works correctly when given a valid input 
     */ 
    public void testp10() throws NoSuchFieldException, IllegalAccessException {
        DLLProperty property = new DLLProperty();

        property.setPropertyAddress("6", "NG1 8HY");

        Field propertyNumberField = property.getClass().getDeclaredField("propertyNumber");
        propertyNumberField.setAccessible(true);
        int propertyNumberValue = (int) propertyNumberField.get(property);

        Field propertyPostCodeField = property.getClass().getDeclaredField("propertyPostCode");
        propertyPostCodeField.setAccessible(true);
        String propertyPostCodeValue = (String) propertyPostCodeField.get(property);

        assertEquals(6, propertyNumberValue);
        assertEquals("NG1 8HY", propertyPostCodeValue);
    }
    
    @Test
    /* Author: Dante Chandler
     * Test checks that the setPropertyAddress() function produces an error when given an invalid input 
     */
    public void testp11() {
        DLLProperty property = new DLLProperty();

        try {
            property.setPropertyAddress("C", "NGH76H");
            fail("Expected NumberFormatException was not thrown");
        } catch (NumberFormatException e) {
        } catch (Exception e) {
            fail("Unexpected exception: " + e);
        }
        
        assertEquals("0", property.propertyNumber());
        
        assertNull(property.propertyPostCode());
    }
    
    @Test
    /* Test completed by Dante Chandler
     * Test checks whether adding a valid input to occupant rating would correctly 
     * update the occupant rating average as well as the rating count   
     */
    public void testp12() throws NoSuchFieldException, IllegalAccessException {	
    	DLLProperty property = new DLLProperty();
    	
        Field initialOccupantRatingField = DLLProperty.class.getDeclaredField("occupantRating");
        initialOccupantRatingField.setAccessible(true);
        double initialOccupantRating = (double) initialOccupantRatingField.get(property);

        Field initialRatingCountField = DLLProperty.class.getDeclaredField("occRatingCount");
        initialRatingCountField.setAccessible(true);
        int initialRatingCount = (int) initialRatingCountField.get(property);

        property.addOccRating(4);

        double expectedOccupantRating = ((initialOccupantRating * initialRatingCount) + 4) / (initialRatingCount + 1);

        assertEquals(expectedOccupantRating, property.getOccRating(), 0.001);
        assertEquals(initialRatingCount + 1, initialRatingCountField.get(property));
    }
    
    @Test
    /* Test completed by Dante Chandler
     * Test checks whether adding a invalid input to occupant rating, because the input 
     * is out of range of the valid response, would correctly update the occupant rating 
     * average as well as the rating count   
     */
    public void testp13() throws NoSuchFieldException, IllegalAccessException {
    	DLLProperty property = new DLLProperty();

        double initialOccupantRating = property.getOccRating();

        Field ratingCountField = DLLProperty.class.getDeclaredField("occRatingCount");
        ratingCountField.setAccessible(true);
        int initialRatingCount = (int) ratingCountField.get(property);

        try {
            property.addOccRating(9); 
        } catch (IllegalArgumentException ignored) {
        }

        int finalRatingCount = (int) ratingCountField.get(property);
        assertEquals(initialRatingCount, finalRatingCount);

        assertEquals(initialOccupantRating, property.getOccRating());
    }

  /*Author: Nicholas Rutherfoord
   * adding a valid tolet vote
   */
  @Test
  public void testP14() throws NoSuchFieldException, IllegalAccessException {
    final DLLProperty property = new DLLProperty();
    property.addTTRating(true, false);
    final Field field = property.getClass().getDeclaredField("toletCount");
    field.setAccessible(true);

    // making sure that the toilet rating stays as 0
    final Field fieldOther = property
      .getClass()
      .getDeclaredField("toiletCount");
    fieldOther.setAccessible(true);

    assertEquals(field.get(property), 1);
    assertEquals(fieldOther.get(property), 0);
  }

  /*Author: Nicholas Rutherfoord
   * adding a valid toilet vote
   * takes a true input only for toilet
   */
  @Test
  public void testP15() throws NoSuchFieldException, IllegalAccessException {
    final DLLProperty property = new DLLProperty();
    property.addTTRating(false, true);

    final Field field = property.getClass().getDeclaredField("toiletCount");
    field.setAccessible(true);

    // making sure that the tolet rating stays as 0
    final Field fieldOther = property.getClass().getDeclaredField("toletCount");
    fieldOther.setAccessible(true);

    assertEquals(field.get(property), 1);
    assertEquals(fieldOther.get(property), 0);
  }

  /*Author: Nicholas Rutherfoord
   * Set Under review
   * takes a boolean for whether the property is under review
   */
  @Test
  void testP16() throws NoSuchFieldException, IllegalAccessException {
    final DLLProperty property = new DLLProperty();

    final Field field = property.getClass().getDeclaredField("propertyStatus");
    field.setAccessible(true);

    property.setUnderReview(false);
    //should be 2 = deactivated
    assertEquals(field.get(property), 2);

    property.setUnderReview(true);
    //should be 1 = Under review
    assertEquals(field.get(property), 1);
  }

  /*Author: Nicholas Rutherfoord
   * Set deactivated
   * takes a boolean for whether the property is under decativated
   * Starts with true because the default value is false
   */
  @Test
  void testP17() throws NoSuchFieldException, IllegalAccessException {
    final DLLProperty property = new DLLProperty();

    final Field field = property.getClass().getDeclaredField("propertyStatus");
    field.setAccessible(true);

    property.setDeactivated(true);
    //should be 0 = Under review
    assertEquals(field.get(property), 0);
    property.setDeactivated(false);
    //should be 1 = Under review
    assertEquals(field.get(property), 1);
  }

  /*Author: Nicholas Rutherfoord
   * Set rented
   * takes a boolean for whether the property is rented
   * Starts with true because the default value is false
   */
  @Test
  void testP18() throws NoSuchFieldException, IllegalAccessException {
    final DLLProperty property = new DLLProperty();

    final Field field = property.getClass().getDeclaredField("propertyStatus");
    field.setAccessible(true);

    property.setRented(true);
    //should be 3 = Rented
    assertEquals(field.get(property), 3);
    property.setRented(false);
    //should be 2 = active
    assertEquals(field.get(property), 2);
  }

  /*Author: Nicholas Rutherfoord
   * toString()	override
   * Should produce a custom String representation for this object
   * As this test is the final test of the class, all the other methods should have been tested
   * thus, this test will use those getters and setters
   */
  @Test
  void testP19a() {
    final DLLProperty property = new DLLProperty();

    property.addOccRating(2);
    property.addTTRating(true, false);

    String propertyNum = "1";
    String propertyAdr = "NG8 1BB";

    property.setPropertyAddress(propertyNum, propertyAdr);
    property.setRented(true);

    String expectedString = propertyNum + " " + propertyAdr;
    expectedString += " (Rented) - Rating: 4/5";
    assertEquals(expectedString, property.toString());
  }

  /*Author: Nicholas Rutherfoord
   * toString() - for under review
   */
  @Test
  void testP19b() {
    final DLLProperty property = new DLLProperty();

    property.addOccRating(3);
    property.addTTRating(false, true);
    property.addTTRating(true, false);

    String propertyNum = "1";
    String propertyAdr = "NG8 1BB";

    property.setPropertyAddress(propertyNum, propertyAdr);
    property.setUnderReview(true);

    String expectedString = propertyNum + " " + propertyAdr;
    expectedString += " (Under Review) - Rating: 3/5";
    assertEquals(expectedString, property.toString());
  }

  /*Author: Nicholas Rutherfoord
   * toString() - for deactivated
   */
  @Test
  void testP19c() {
    final DLLProperty property = new DLLProperty();

    property.addOccRating(5);
    property.addTTRating(false, true);

    String propertyNum = "1";
    String propertyAdr = "NG8 1BB";

    property.setPropertyAddress(propertyNum, propertyAdr);
    property.setDeactivated(true);

    String expectedString = propertyNum + " " + propertyAdr;
    expectedString += " (Deactivated) - Rating: 3/5";
    assertEquals(expectedString, property.toString());
  }

  /*Author: Nicholas Rutherfoord
   * toString() - for active
   */
  @Test
  void testP19d() {
    final DLLProperty property = new DLLProperty();

    property.addTTRating(true, false);
    property.addTTRating(true, false);
    property.addTTRating(true, false);
    property.addTTRating(false, true);
    property.addOccRating(4);

    String propertyNum = "1";
    String propertyAdr = "NG8 1BB";

    property.setPropertyAddress(propertyNum, propertyAdr);
    property.setRented(false);

    String expectedString = propertyNum + " " + propertyAdr;
    expectedString += " (Active) - Rating: 4/5";
    assertEquals(expectedString, property.toString());
  }
}
