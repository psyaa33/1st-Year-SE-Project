import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

class TestDLLLandlord {
	
	/*Author: Abdulla Al-Ali
	 * Default Constructor
	 * Initializes a landlord with null values for name and email, and sets all numeric values to 0 with new landlord status as true.
	 */
	
	@Test
	public void testL1() {
	    DLLLandlord landlord = new DLLLandlord();
	    assertNull(landlord.landlordName(), "Landlord name should initially be null");
	    assertNull(landlord.landlordEmailAddress(), "Landlord email should initially be null");
	    assertEquals(0.0, landlord.landlordCommsRating(), 0.01, "Initial communications rating should be 0.0");
	    assertEquals(0.0, landlord.landlordMaintenanceRating(), 0.01, "Initial maintenance rating should be 0.0");
	    assertTrue(landlord.landlordNew(), "Landlord should be marked as new");
	}

	/*Author: Abdulla Al-Ali
	 * Main Constructor
	 * Initializes a landlord with provided name and email, sets all ratings to 0, and marks as a new landlord.
	 */
	
	@Test
	public void testL2() {
	    DLLLandlord landlord = new DLLLandlord("John Doe", "john.doe@example.com");
	    assertEquals("John Doe", landlord.landlordName(), "Landlord name should be set");
	    assertEquals("john.doe@example.com", landlord.landlordEmailAddress(), "Landlord email should be set");
	    assertEquals(0.0, landlord.landlordCommsRating(), 0.01, "Initial communications rating should be 0.0");
	    assertEquals(0.0, landlord.landlordMaintenanceRating(), 0.01, "Initial maintenance rating should be 0.0");
	    assertTrue(landlord.landlordNew(), "Landlord should be marked as new");
	}

	/*Author: Abdulla Al-Ali
	 * getLandlordName
	 * Returns the landlord's name or an empty string if null.
	 */
	
	@Test
	public void testL3() {
	    DLLLandlord landlord = new DLLLandlord();
	    assertEquals(null, landlord.landlordName(), "Getter for landlord name should return null if not set");
	}

	/*Author: Abdulla Al-Ali
	 * getLandlordEmailAddress
	 * Returns the landlord's email address or an empty string if null.
	 */
	
	@Test
	public void testL4() {
	    DLLLandlord landlord = new DLLLandlord();
	    assertEquals(null, landlord.landlordEmailAddress(), "Getter for email address should return null if not set");
	}


  /*Author: Muhammad Saad
   * Get the Landlord Email
   */
	@Test
	void testL5() 
	{
		String landlordName = "John Adam";
		String landlordEmail = "johnad@gmail.com";
		DLLLandlord landlord = new DLLLandlord(landlordName, landlordEmail);
    String returnedEmail = landlord.landlordEmailAddress();
    assertEquals(landlordEmail, returnedEmail);
  }

	
  /*Author: Muhammad Saad
   * Should return the comms rating as a double
   */
	@Test
	void testL6() 
	{
		String landlordName = "John Adam";
    String landlordEmail = "johnad@gmail.com";
    int commsRating = 4;
    DLLLandlord landlord = new DLLLandlord(landlordName, landlordEmail);
    landlord.addRatings(4, 1); 
        double returnedCommsRating = landlord.landlordCommsRating();
    assertEquals(commsRating, returnedCommsRating, 0.01);
  }
	
  /*Author: Muhammad Saad
   * Return the maintenance rating as a double
   */
	@Test
	void testL7() 
	{
		String landlordName = "John Adam";
		String landlordEmail = "johnad@gmail.com";
		int maintenanceRating = 4;
		
		DLLLandlord landlord = new DLLLandlord(landlordName, landlordEmail);
    landlord.addRatings(1, 4);
    
    double returnedMmaintenanceRating = landlord.landlordMaintenanceRating();
    assertEquals(maintenanceRating, returnedMmaintenanceRating, 0.01);
  }
	
  /*Author: Muhammad Saad
   * Check new landlord status with less than 10 ratings
   */
	@Test
	void testL8() {
		String landlordName = "John Adam";
    String landlordEmail = "johnad@gmail.com";
    DLLLandlord landlord = new DLLLandlord(landlordName, landlordEmail);
    for (int i = 0; i < 9; i++) {
      landlord.addRatings(5, 5);
    }

    boolean isNewLandlord = landlord.landlordNew();
    assertTrue(isNewLandlord);
  }

  @Test
  /*Author: Dante Chandler
   * Checking new landlord status is updated to false with 10 or more ratings for the landlord
   */
  public void testL9() {
    DLLLandlord landlord = new DLLLandlord();

    for (int i = 0; i < 10; i++) {
      landlord.addRatings(5, 5);
    }

    assertFalse(landlord.landlordNew());
  }

  @Test
  /*Author: Dante Chandler
   * Testing the setlandlordName() function with a valid input to check whether it updates the variable correctly
   */
  public void testLl0() {
    DLLLandlord landlord = new DLLLandlord();

    landlord.setlandlordName("John Adam");

    assertEquals("John Adam", landlord.landlordName());
  }

  @Test
  /*Author: Dante Chandler
   * Testing the setlandlordName() function with a second valid input, after the landlord name has already been updated to check it 
   * throws an error
   */
  public void testL11() {
    DLLLandlord landlord = new DLLLandlord();

    landlord.setlandlordName("John Adam");

    assertThrows(
      IllegalStateException.class,
      () -> landlord.setlandlordName("Joe James")
    );
  }

  @Test
  /* Author: Dante Chandler
   * Testing the setlandlordEmailAddress() function with with a valid input to check whether it updates the variable correctly
   */
  public void testL12() {
    DLLLandlord landlord = new DLLLandlord();

    landlord.setlandlordEmailAddress("johnad@gmail.com");

    assertEquals("johnad@gmail.com", landlord.landlordEmailAddress());
  }

  @Test
  /*Author: Dante Chandler
   * Testing the setlandlordEmailAddress() function with with an invalid email address input to check whether it throws an error
   * indicating that email provided is not correct
   */
  public void testl13() {
    DLLLandlord landlord = new DLLLandlord();

    assertThrows(
      IllegalArgumentException.class,
      () -> landlord.setlandlordEmailAddress("johnad.com")
    );
  }

  /*Author: Nicholas Rutherfoord
   * addRatings function
   * Add valid ratings for comms and maintanence
   */
  @Test
  public void testL14() {
    final DLLLandlord landlord = new DLLLandlord();
    int commsR = 3;
    int maintR = 4;
    landlord.addRatings(commsR, maintR);
    assertEquals(landlord.landlordCommsRating(), (double) commsR);
    assertEquals(landlord.landlordMaintenanceRating(), (double) maintR);
  }

  /*Author: Nicholas Rutherfoord
   * addRatings function
   * testing adding an invalid ratings for comms and maintanence
   */
  @Test
  public void testL15() {
    final DLLLandlord landlord = new DLLLandlord();

    int commsR = 0;
    int maintR = 9;

    try {
      landlord.addRatings(commsR, maintR);
    } catch (IllegalArgumentException e) {
      // if an error was thrown it will pass the test
      return;
    }

    fail("No error thrown");
  }

  /*Author: Nicholas Rutherfoord
   * toString() - new landlord
   * testing the output of the toString() functions
   * using setFunctions as they would have already been fixed by this point
   * As there is an empty constructor landlord new is defined as true by default
   */
  @Test
  public void testL16() {
    final DLLLandlord landlord = new DLLLandlord();
    String name = "John Adam";
    landlord.setlandlordName(name);

    String expectedOutput = name + " (New Landlord)";
    assertEquals(expectedOutput, landlord.toString());
  }

  /*Author: Nicholas Rutherfoord
   * toString() - established landlord
   * testing the output of the toString() functions
   *
   */
  @Test
  public void testL17() throws NoSuchFieldException, IllegalAccessException {
    final DLLLandlord landlord = new DLLLandlord();
    final Field field = landlord.getClass().getDeclaredField("landlordNew");
    field.setAccessible(true);
    //sets the landlordNew to false
    field.set(landlord, false);

    String name = "Tammie Jycross";
    landlord.setlandlordName(name);
    landlord.addRatings(3, 4);

    String expectedOutput = name + " - Communication: 3/5, Maintenance: 4/5";

    assertEquals(expectedOutput, landlord.toString());
  }
}
