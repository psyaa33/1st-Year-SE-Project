import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestDLLApp {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

	String menuMessage = "\nWhat do you want to do? L = List [L]andlords, P = List [P]roperties, B = [B]ad Properties, A = [A]dd TT Rating, R = Add Landlord [R]ating, C = [C]hange Landlord Status,  X = E[x]it"+System.lineSeparator();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent)); // Redirect System.out to capture output
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(originalOut); // Reset System.out to original
    }
    
    
    /*Author: Abdulla Al-Ali
     * TestListLandlordsFunction
     * Tests the main loop's response to input 'L', which should trigger the ListLandlords function to display all landlords.
     */
    
    @Test 
    public void testA1() {
    	// Redirecting standard input
    	String input = "L";
		InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    	DLLApp.main(null);
    	assertTrue(outContent.toString().contains("1) Wax Milson"));
        assertTrue(outContent.toString().contains("2) Tammie Jycross"));
    	
    }
    
    /*Author: Abdulla Al-Ali
     * TestListPropertiesFunction
     * Tests the main loop's response to input 'P', which should trigger the ListProperties function to display all properties.
     */
    
    @Test
    public void testA2() {
        DLLApp.AllProperties.add(new DLLProperty("1", "NG8 1BB"));
        DLLApp.AllProperties.add(new DLLProperty("2", "NG8 1CC"));

        DLLApp.ListProperties(false); // List all properties

        assertTrue(outContent.toString().contains("1) 1 NG8 1BB"));
        assertTrue(outContent.toString().contains("2) 2 NG8 1CC"));
    }

    /*Author: Abdulla Al-Ali
     * TestListBadPropertiesFunction
     * Tests the main loop's response to input 'B', which should trigger the ListProperties function with the showBad parameter set to true to display only properties with bad ratings.
     */
    
    @Test
    public void testA3() {
    	// Redirecting standard input
    	String input = "B";
		InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    	DLLApp.main(null);

        String output = outContent.toString();
        System.out.println("Output: " + output); // Debug 

        //List Properties function is called with showBad parameter to true
        assertTrue(output.contains("2 NG8 1CC"), "Output should only contain the bad property.");
        assertFalse(output.contains("1 NG8 1BB"), "Output should not contain the good property.");
    }

    /*Author: Abdulla Al-Ali
     * TestAddPropertyRatingFunction
     * Tests the main loop's response to input 'A', which should call the function to add a property rating.
     */
    
    @Test
    public void testA4() {
    	// Redirecting standard input
    	String input = "A";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    	DLLApp.main(null);

        String output = outContent.toString();
        System.out.println("Output: " + output); // Debug 

        //testing to see if the ListProperties function was called which is within the addTTRating function
        assertTrue(output.contains("2 NG8 1CC"), "Output should contain the bad property.");
        assertTrue(output.contains("1 NG8 1BB"), "Output should contain the good property.");
    }


    /*Author: Abdulla Al-Ali
     * TestAddLandlordRatingFunction
     * Tests the main loop's response to input 'R', which should call the function to add a rating to a landlord.
     */

    @Test
    public void testA5() {
    	// Redirecting standard input
    	String input = "R";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    	DLLApp.main(null);

        String output = outContent.toString();
        System.out.println("Output: " + output); // Debug 

        //testing to see if the ListLandlord function was called which is within the addLandlordRating function
        assertTrue(outContent.toString().contains("1) Wax Milson"));
        assertTrue(outContent.toString().contains("2) Tammie Jycross"));
    }


    /*Author: Abdulla Al-Ali
     * TestExitFunction
     * Tests the main loop's response to input 'X', which should print "Goodbye!" and stop the program.
     */

    @Test
    public void testA6() {

        // Simulate user input 'X' to exit
        String input = "X\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the main method, which should capture the input and process it
        DLLApp.main(null);

        // Assertions to verify the correct behavior
        String output = outContent.toString();
        assertTrue(output.contains("Goodbye!"), "Output should contain 'Goodbye!'");
        
    }

    /*Author: Abdulla Al-Ali
     * TestCommandNotRecognizedFunction
     * Tests the main loop's response to unrecognizable commands like '1' or 'g', verifying that the output is "command not recognized".
     */
    
    @Test
    public void testA7() {
        String[] inputs = {"1","g"}; 
        for(int i =0;i<2;i++) {
	        InputStream in = new ByteArrayInputStream(inputs[i].getBytes());
	        System.setIn(in);
	
	        DLLApp.main(null);
	
	        // Assertions to verify the correct behavior
	        String errorMessage = "Command not recognised"+System.lineSeparator();
	        
	        
	        assertEquals(menuMessage+errorMessage+menuMessage, outContent.toString());
	   
	        outContent.reset(); // Reset outContent after each test
        }
        
    }

    /*Author: Muhammad Saad
     * List only properties below the 2.5 threshold
     * tests to make sure only properties below 2.5 are listed when input is set as true
     * debugged by: Nicholas Rutherfoord
     */ 
    @Test
    public void testA8() {
        // setup input data
        ArrayList<DLLProperty> properties = new ArrayList<>();
        DLLProperty p1 = new DLLProperty("1", "NG8 1BB");
        p1.addTTRating(true, false);
        p1.addTTRating(true, false);
        p1.addTTRating(false, true);
        p1.addOccRating(4);
        properties.add(p1);

        DLLProperty p2 = new DLLProperty("2", "NG8 1CC");
        p2.addTTRating(false, true);
        p2.addOccRating(2);
        properties.add(p2);

        DLLApp.AllProperties = properties;

        DLLApp.ListProperties(true);
        String output = outContent.toString().trim();

        String expectedOutput = "2) 2 NG8 1CC (Under Review) - Rating: 1/5";
        assertEquals(expectedOutput, output);
    }
    /*Author: Muhammad Saad
     * List all properties 
     * tests to make sure all the properties are listed when input is set as false
     *  debugged by: Nicholas Rutherfoord
     */
    @Test
    public void testA9() {
         // setup input data
         ArrayList<DLLProperty> properties = new ArrayList<>();
         DLLProperty p1 = new DLLProperty("1", "NG8 1BB");
         p1.addTTRating(true, false);
         p1.addTTRating(true, false);
         p1.addTTRating(false, true);
         p1.addOccRating(4);
         properties.add(p1);
 
         DLLProperty p2 = new DLLProperty("2", "NG8 1CC");
         p2.addTTRating(false, true);
         p2.addOccRating(2);
         properties.add(p2);
 
         DLLApp.AllProperties = properties;

        DLLApp.ListProperties(false);
        String output = outContent.toString().trim();
        String expectedOutput = "1) 1 NG8 1BB (Under Review) - Rating: 4/5"+System.lineSeparator()+"2) 2 NG8 1CC (Under Review) - Rating: 1/5";
        assertEquals(expectedOutput, output);
    }

    @Test
    /* Author: Dante Chandler
        * Testing to see if the ListLandlords() function works as expected when called
        */
    public void testA10() {
        /* Initialise test data, or else lists would be empty (could run whole main() 
            * function but wouldn't be efficient
            */
        DLLLandlord d1 = new DLLLandlord("Wax Milson","max@dll.com");
        DLLLandlord d2 = new DLLLandlord("Tammie Jycross","tammie@dll.com");
        DLLProperty p1 = new DLLProperty("1","NG8 1BB");
        p1.addTTRating(true, false);
        p1.addTTRating(true, false);
        p1.addTTRating(false, true);
        p1.addOccRating(4);
        DLLProperty p2 = new DLLProperty("2","NG8 1CC");
        p2.addTTRating(false,true);
        ArrayList<DLLLandlord> AllLandlords = new ArrayList<>();
        AllLandlords.add(d1);
        AllLandlords.add(d2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DLLApp app = new DLLApp();
        app.AllLandlords = AllLandlords;

        app.ListLandlords();

        String output = outContent.toString();

        String[] lines = output.split("\\r?\\n");

        for (int i = 0; i < lines.length; i++) {
            assertTrue(lines[i].matches("\\d+\\) .+ \\(New Landlord\\)"));
        }
    }



	@Test
	/* Author: Dante Chandler
     * Testing to see if the addTTRating() function works as expected when a valid input is entered to it
     */
    public void testA11() {
        DLLProperty property = new DLLProperty("1", "NG8 1BB");

        property.addTTRating(true, false);
        property.addTTRating(false, true);
        
        // Created new function called getTTRatingCount() in DLLProperty
        assertEquals(3, property.getTTRating());
    }
	
	@Test
	/* Author: Dante Chandler
     * Testing to see if the addTTRating() function works as expected when an input out of range is entered
     */
	public void testA12() {
	    String[] inputs = {"A\n100", "A\n-1"};
	    
	    for(String input:inputs) {
	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outContent));

	        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);
	            
	        DLLApp.main(null);
	        
	        // Update expected output to match the exact output from the code
	        String expectedOutput = "1) 1 NG8 1BB (Under Review) - Rating: 4/5"+System.lineSeparator()+"2) 2 NG8 1CC (Under Review) - Rating: 0/5" + System.lineSeparator()+"Which Property?" + System.lineSeparator()+"Property ID is out of range." + System.lineSeparator();
				                    

	        assertEquals(menuMessage+expectedOutput+menuMessage, outContent.toString());
	        outContent.reset();    
	    }
	}

	
	@Test
	/* Author: Dante Chandler
     * Testing to see if the addTTRating() function works as expected when a erroneous input is entered to it
     */
	public void testA13() {
	    DLLApp app = new DLLApp();
	    String[] inputs = {"A\np", "A\n2\n3"};
	    
	    for(int i = 0; i<inputs.length ;i++) {
	    	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		    System.setOut(new PrintStream(outContent));
	
		    ByteArrayInputStream in = new ByteArrayInputStream(inputs[i].getBytes());
		    System.setIn(in);
	
		    DLLApp.main(null);	    	
		   		   
		    if(i==0) {
		    	String expectedOutput = menuMessage
										+ "1) 1 NG8 1BB (Under Review) - Rating: 4/5" + System.lineSeparator()
									    + "2) 2 NG8 1CC (Under Review) - Rating: 0/5" + System.lineSeparator()
							    		+ "Which Property?" + System.lineSeparator()
										+ "Invalid input. Please enter a valid property number." + System.lineSeparator()
										+ menuMessage;
		    	assertEquals(expectedOutput, outContent.toString());
		    } else {
		    	String expectedOutput = menuMessage
										+ "1) 1 NG8 1BB (Under Review) - Rating: 4/5" + System.lineSeparator()
									    + "2) 2 NG8 1CC (Under Review) - Rating: 0/5" + System.lineSeparator()
							    		+ "Which Property?" + System.lineSeparator()
									    + "[T]oLet or To[I]let?" + System.lineSeparator()
										+ "Command not recognised."
										+ menuMessage;
		    	assertEquals(expectedOutput, outContent.toString());
		    }
		    outContent.reset();
	    }
	}
    /* Author Nicholas Rutherfoord	
     * Function test: addLandlordRatings
     * test type: Normal data
     */
    @Test
    public void testA14() {
    	String[] inputs = {"R\n1\n5\n1","R\n1\n3\n3","R\n2\n1\n5"};
    
    	
    	
    	for(String input:inputs) {
    		
    		// changing the standard input for test
    		InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            
            // call the main method in static way
            DLLApp.main(null);
            
            // Output messages expected
            String functionOutput = "1) Wax Milson (New Landlord)"+System.lineSeparator()+"2) Tammie Jycross (New Landlord)"+System.lineSeparator()+"Which Landlord?"+System.lineSeparator()+"What is the comms rating?"+System.lineSeparator()+"What is the maintenance rating?"+System.lineSeparator()+"Ratings added!"+System.lineSeparator();
            
            
            // Asserting output messages
            assertEquals( menuMessage+functionOutput+menuMessage,outContent.toString() );
            outContent.reset(); // Reset outContent after each test
    	}
        
        
    }
    
    /* Author Nicholas Rutherfoord	
     * Function test: addLandlordRatings
     * test type: out of range rating value
     * add an invalid rating for both comms and maintenance
     */
    @Test
    public void testA15() {
    	//first two are invalid comms, second two are invalid maintenance
    	String[] inputs = {"R\n1\n6\n1","R\n1\n-1\n3","R\n2\n1\n6","R\n1\n3\n-1"};
    
    	for(String input:inputs) {
    		
    		// Redirecting standard input
    		InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            
         // call the main method in static way
            DLLApp.main(null);
            
            
            String standardMessage = "1) Wax Milson (New Landlord)"+System.lineSeparator()+"2) Tammie Jycross (New Landlord)"+System.lineSeparator()+"Which Landlord?"+System.lineSeparator()+"What is the comms rating?"+System.lineSeparator()+"What is the maintenance rating?"+System.lineSeparator()+"Didnt recognise those values..."+System.lineSeparator();
            
            // Assert output
            assertEquals( menuMessage+standardMessage+menuMessage,outContent.toString() );
            
            
            outContent.reset(); // Reset outContent after each test
    	}
    	
    }
    
    /* Author Nicholas Rutherfoord	
     * Function test: addLandlordRatings
     * test type: out of range landlord selection
     * add an invalid landlord selection
     */
    @Test
    public void testA16() {
    	String[] inputs = {"R\n9","R\n0"};
    	
    	for(String input:inputs) {
    		
    		// Redirecting standard input
    		InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            
         // call the main method in static way
            DLLApp.main(null);
            
            String standardMessage = "1) Wax Milson (New Landlord)"+System.lineSeparator()+"2) Tammie Jycross (New Landlord)"+System.lineSeparator()+"Which Landlord?"+System.lineSeparator()+"Didnt recognise those values..."+System.lineSeparator();
            
            // Assert output
            assertEquals( menuMessage+standardMessage+menuMessage,outContent.toString() );
            
            
            outContent.reset(); // Reset outContent after each test
    	}
    	
    }
    /* Author Nicholas Rutherfoord	
     * Function test: addLandlordRatings
     * test type: erronous 
     * add an invalid landlord selection
     */
    @Test
    public void testA17() {
    
    	String[] inputs = {"R\na","R\n1\n!","R\n1\n3\ng"};
    
    	
    	
    	for(int i = 0; i<inputs.length;i++) {
    		
    		
            // Redirecting standard input
            InputStream in = new ByteArrayInputStream(inputs[i].getBytes());
            System.setIn(in);
            
            // call the main method in static way
            DLLApp.main(null);
            
            
            String standardMessage = "1) Wax Milson (New Landlord)"+System.lineSeparator()+"2) Tammie Jycross (New Landlord)"+System.lineSeparator()+"Which Landlord?"+System.lineSeparator();
            
            //shouldn't ask for any landlord ratings as there is an invalid landlord selection
            if(i != 0){
            	standardMessage += "What is the comms rating?"+System.lineSeparator();
		        if(i == 2) {
		        	standardMessage +="What is the maintenance rating?"+System.lineSeparator();
		        }
            }
            // this occurs in all 3 error cases
            standardMessage += "Didnt recognise those values..."+System.lineSeparator();
            
            
            // Assert output
            assertEquals( menuMessage+standardMessage+menuMessage,outContent.toString() );
            
            
            outContent.reset(); // Reset outContent after each test
    	}
    	
    }
    
    /* Author Nicholas Rutherfoord	
     * Function test: changePropertyStatus 
     * test type: normal data 
     * tests for house status being changed
     * new menu option has to be added for this test to pass - '[C]hange Property Status' 
     */
    @Test
    public void testA18()throws NoSuchFieldException, IllegalAccessException {
    	DLLApp app = new DLLApp();
    	
    	String[] inputs = {"C\n1\nD","C\n1\nA","C\n1\nU","C\n1\nR"};
    	for(int i =0;i<inputs.length;i++) {
	    	InputStream in = new ByteArrayInputStream(inputs[i].getBytes());
	        System.setIn(in);
	        
	     // call the main method in static way
	        app.main(null);
	        
	        //needed to access the property object to check the updated status
	        Field propertiesField = app.getClass().getDeclaredField("AllProperties");
	        propertiesField.setAccessible(true);
	        @SuppressWarnings("unchecked")
			ArrayList<DLLProperty> allProperties = (ArrayList<DLLProperty>) propertiesField.get(app);
	        DLLProperty property = allProperties.get(0);
	     
	        String properties = "1) 1 NG8 1BB (Under Review) - Rating: 4/5"+System.lineSeparator()+"2) 2 NG8 1CC (Under Review) - Rating: 0/5"+System.lineSeparator()+"Which Property?"+System.lineSeparator()+"What status would you like to set it to? D = Deactivated, A = Active, U = Under Review, R = Rented"+System.lineSeparator();
	        
	        String extra = "";
	        switch(i){
			case 0:
				extra = "Deactivated";
				break;
			case 1:
				extra = "Active";
				break;
			case 2:
				extra = "Under Review";
				break;
			case 3:
				extra = "Rented";
				break;
	        }
	        String test ="1 NG8 1BB ("+extra+") - Rating: 4/5"; 
	        assertEquals(menuMessage+properties+menuMessage ,outContent.toString());
	        assertEquals(property.toString(),test);
            outContent.reset(); // Reset outContent after each test

    	}
	}
    
    
    /* Author Nicholas Rutherfoord	
     * Function test: changePropertyStatus 
     * test type: Erronous Test 
     * tests for invalid house status selection
     */
    @Test
    public void testA19()throws NoSuchFieldException, IllegalAccessException {
    	DLLApp app = new DLLApp();
    	
    	String[] inputs = {"C\n1\nX","C\n1\n1"};
    	for(int i =0;i<inputs.length;i++) {
	    	InputStream in = new ByteArrayInputStream(inputs[i].getBytes());
	        System.setIn(in);
	        
	     // call the main method in static way
	        app.main(null);
	        
	        //needed to access the property object to check the updated status
	        Field propertiesField = app.getClass().getDeclaredField("AllProperties");
	        propertiesField.setAccessible(true);
	        @SuppressWarnings("unchecked")
			ArrayList<DLLProperty> allProperties = (ArrayList<DLLProperty>) propertiesField.get(app);
	        DLLProperty property = allProperties.get(0);
	     
	        String properties = "1) 1 NG8 1BB (Under Review) - Rating: 4/5"+System.lineSeparator()+"2) 2 NG8 1CC (Under Review) - Rating: 0/5"+System.lineSeparator()+"Which Property?"+System.lineSeparator()+"What status would you like to set it to? D = Deactivated, A = Active, U = Under Review, R = Rented"+System.lineSeparator();
	        String errorMessage = "Didnt recognise those values..."+System.lineSeparator();
	        //check that no changes were made to it
	        assertTrue(allProperties.get(0).isUnderReview());
	        assertTrue(allProperties.get(1).isUnderReview());

	       
	        assertEquals(menuMessage+properties+errorMessage+menuMessage ,outContent.toString());
            outContent.reset(); // Reset outContent after each test

    	}
	}
    

    /* Author Nicholas Rutherfoord	
     * Function test: changePropertyStatus 
     * test type: Out of range and erroneuos test for property selection 
     * tests for invalid property selection
     */
    @Test
    public void testA20()throws NoSuchFieldException, IllegalAccessException {
    	DLLApp app = new DLLApp();
    	
    	String[] inputs = {"C\n9","C\n-1","C\n!"};
    	for(int i =0;i<inputs.length;i++) {
	    	InputStream in = new ByteArrayInputStream(inputs[i].getBytes());
	        System.setIn(in);
	        
	     // call the main method in static way
	        app.main(null);
	        
	        //needed to access the property object to check the updated status
	        Field propertiesField = app.getClass().getDeclaredField("AllProperties");
	        propertiesField.setAccessible(true);
	        @SuppressWarnings("unchecked")
			ArrayList<DLLProperty> allProperties = (ArrayList<DLLProperty>) propertiesField.get(app);
	        DLLProperty property = allProperties.get(0);
	     
	        String properties = "1) 1 NG8 1BB (Under Review) - Rating: 4/5"+System.lineSeparator()+"2) 2 NG8 1CC (Under Review) - Rating: 0/5"+System.lineSeparator()+"Which Property?"+System.lineSeparator();
	        String errorMessage = "Didnt recognise those values..."+System.lineSeparator();
	        //check that no changes were made to it
	        assertTrue(allProperties.get(0).isUnderReview());
	        assertTrue(allProperties.get(1).isUnderReview());

	       
	        assertEquals(menuMessage+properties+errorMessage+menuMessage ,outContent.toString());
            outContent.reset(); // Reset outContent after each test

    	}
	}
}
