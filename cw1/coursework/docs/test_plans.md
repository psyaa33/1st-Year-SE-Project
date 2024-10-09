# Test Plan (and eventually Test Report)

|Contents|
|--------|
|[Team Management](#team-management)|
|[Test Plan](#test-plan)|
|[Jump to Class:DLL App](#class-dllapp)|
|[Jump to Class:](#class)|
|[Jump to Class:](#class)|

- [Planning](../assets/Coursework_2/coursework2_planning.md)
## Team Management
Report here, by the end of the assignment, how the team has managed the project, e.g.: used version control, organised meetings, divided work, used labels, milestones, issues, etc.

### Meetings
| Meeting Date        | Meeting Topic and goal |
|---------------------|------------------------|
| 21/03/2024          | CW2 kickoff - decide labels, initial milestones, coding conventions and start test plan |
| 27/03/2024          | Test plans - Ensure test plans are complete prior to labs and everyone set up with JUnit test folders, maybe start with unit tests | 
| 28/03/2024          | Unit tests - divide up all unit tests, create relevant git issues and branches. Ensure good understanding of what to do next. Also complete advanced junit lab work| 
|30/04/2024|Catch up on whats been completed over the break. Rescheduling of internal deadlines in time for the final deadline. New milestone created for Saturday 4th of May, all unit tests completed. Integration testing milestone, be completed by Monday 6th May. Dodgy code needs to be completed at least one day before final labs on the 9th of May. 2nd of May labs time will be utilised to ensure the standard of unit tests is high and understand where to begin on integration testing before weekend|
|02/04/2024| We were running slightly behind schedule but most of us had finished test for DLLProperty class and were in the process of getting all tests to pass. Spent this time to also ensure we had also started with DLLLandlord and were ready to merge all unit tests as soon as possible| 
|09/05/2024| Due to Git labs issues we got a 1 day extension. We spent this session and meeting to ensure progress in integration tests and documentation was up to speed to prior to final due date on the 10th of May.|

### Labels
| Label name          | label color |
|---------------------|-------------|
| Test plans          | blue        |
| Documentation       | purple      |
| Unit tests          | green       |
| Integration testing | pink        |

### Milestones
| Milestone          |Description| Date Due |
|--------------------|-----------|-------------|
| Test Plans Completed and begin Unit Testing - prior to easter break|Test Plans need to be completed. This needs to be done prior to the easter break to ensure the work to be done during the break is understood and will be complete.  Everyone should be setup with the Junit testing folder and unit testing should have begun, before or during labs, to ensure finishing of unit testing in the first week back.| 29/03/2024  |
|Unit tests completed |All unit tests need to be completed and merged into 'unit_test branch'. All unit tests need to be approved be everyone in the group, and once done will be merged back into the dev branch | 04/05/2024 (planned data - cant be any later) |
|Integration tests completed| All integration tests need to be completed, merged and approved by the data due. Needs to be completed by the to ensure the dodgy code can be completed and tested using created tests| 06/05/2024|

### Coding convetion
| Convention Type      | Convention Standards for Our Work |
|:---------------------|-----------------------------------|
| Style of Code        | Variable names and method names should be: <br> - camel cased <br>- start with lower case                   |
| Content of Comments  |Note who authored each test, when it was authored, name of test, brief description of test| 
| Structure of Java Files |The structure of each file should be as follows: <br>- Package declaration (if any)<br>- Import statements<br>- Class or interface definitions. Within a class or interface, the order should be:<br>  - Variables<br>  - Constructors<br>  - Methods                                |
| Naming of Tests      | should be prefixed with `test` and then the name of the test                 |


#### Git issues
- they will be assigned when test plan is complete 
- will match the unit tests required to complete as per test plan

    ##### Review Process of issue:
    - should ensure all test cases pass / fail if the current code is still broken


## Test Plan
**You should add rows and even columns, and indeed more tables, freely as you think will improve the report.**

### DLL Property Class

| Test ID | Description                                               | Input                                                              | Expected Outcome                                                    | Test creator | Date Test Completed | Date Code was Fixed and Passed |
|---------|-----------------------------------------------------------|--------------------------------------------------------------------|--------------------------------------------------------------|-------------|---------------|---------------|
| P1      | Instantiate with default constructor                      | None                                                               | Property number: "X", Postcode: "XXXX XXX", All counts and ratings set to 0, Status: Under Review | Abdullah Al-Ali | 1/5 | 3/5 |
| P2      | Takes two parameters: number and postcode                 | "5A", "NG8 1BB"                                                    | Property number set to "5A", Postcode set to "NG8 1BB"             | Abdullah Al-Ali | 1/5 | 3/5 |
| P3      | Returns property number as string                         | Constructor with “5A” “NG2 5FY”                                    | Property number “5A” is returned                                    | Abdullah Al-Ali | 1/5 | 3/5 |
| P4      | Returns postcode as a string                              | Constructor with “5A” “NG2 5FY”                                    | Postcode “NG2 5FY” is returned                                      | Abdullah Al-Ali | 1/5 | 3/5 |
| P5      | Combine ToLet/Toilet ratio with occupant rating           | To Let Count: 2, Toilet Count: 2, Occupant Rating: 4 (with 1 rating received) | The overall rating rounds to nearest integer 4                 | Muhammad Saad | 27/4 | 27/4 
| P6      | Converts TT balance to a star rating out of 5             | ToLet Count: 2, Toilet Count: 2                                    | TT Ratio Score is 3 (mid-point, rounded to nearest integer)        | Muhammad Saad | 28/4 | N/A
| P7      | Return the raw double for the occupant rating             | Occupant Rating: 4                                                 | Occupant rating is 4.0                                              | Muhammad Saad | 28/4 | 30/4
| P8      | Return true if the property is under review               | None                                                               | Returns “True”                                                      | Muhammad Saad | 01/5 | 01/5
| P9      | Check if property is visible when active and not visible when under review | Status set to “Active” / Status set to “Under Review”               | Return “True” / Return “False”                                      | Muhammad Saad | 01/5  | 01/5
| P10     | Set address with valid inputs                             | “6” “NG1 8HY”                                                     | Address is set/updated to “6” “NG1 8HY”                            | Dante Chandler | 30/4 | 2/5 |
| P11     | An attempt to set address with invalid inputs            | “C” “NGH76H”                                                      | Throws an error for incorrect inputs                                | Dante Chandler | 30/4 | 2/5 |
| P12     | Add Valid Occupant rating                                 | 4                                                                  | Updated average occupant rating, Rating count incremented          | Dante Chandler | 30/4 | 2/5 |
| P13     | Add invalid occupant rating (out of range)                | 9                                                                  | Error for not rating within the range of 1-5                        | Dante Chandler | 30/4 | 2/5 |
| P14     | Add valid Tolet vote                                      | Takes boolean (true if it's only for Tolet)                        | Increment ToLet count by 1                                          | Nick Rutherfoord |30/4|3/5|
| P15     | Add valid Toilet vote                                     | Takes boolean (true if it's only for Toilet)                       | Increment Toilet count by 1                                         | Nick Rutherfoord |30/4|3/5|
| P16     | Takes a boolean whether the property is now under review  | “True” for under review                                            | Status set to under review                                          | Nick Rutherfoord |30/4|3/5|
| P17     | Deactivate the property                                   | “True” for deactivate                                              | Status is set to deactivated                                        | Nick Rutherfoord |30/4|3/5|
| P18     | Set property status to rented                             | “True” for rented                                                  | Status is set to rented                                             | Nick Rutherfoord |30/4|3/5|
| P19     | String representation of the property                     | Property Number: "1A", Postcode: "NG8 1BB", Status: Under Review, Occupant Rating: 4 | String format: "1A NG8 1BB (Under Review) - Rating 4/5"        | Nick Rutherfoord |30/4|3/5|

### DLL Landlord Class

| Test ID | Description                                               | Input                                                              | Expected Outcome       | Test creator | Date Test Completed | Date Code was Fixed and Passed |
|---------|-----------------------------------------------------------|--------------------------------------------------------------------|------------------------|-------------|----------------------|--------------------------------|
| L1      | Create default landlord                               | None                                                | Name and email: null, All ratings and counts: 0, New landlord status: true | Abdullah Al-Ali | 4/5 | 6/5 |
| L2      | Creates landlords profile with valid inputs           | “John Adam”, “johnad@gmail.com”                     | Name: John Adam, Email: johnad@gmail.com             | Abdullah Al-Ali | 4/5 | 6/5 |
| L3      | Landlords with invalid inputs                         | “John Adam”, “johnad.com”                           | Throws an error                                      | Abdullah Al-Ali | 4/5 | 6/5 |
| L4      | Get the Landlord name                                 | “John Adam”, “johnad@gmail.com”                     | Returns “John Adam”                                  | Abdullah Al-Ali | 4/5 | 6/5 |
| L5      | Get the Landlord Email                                | “John Adam”, “johnad@gmail.com”                     | Returns “johnad@gmail.com”                           | Muhammad Saad | 3/5 | N/A
| L6      | Should return the comms rating as a double            | Comms Rating: 4.0                                   | Comms Rating is 4.0                                  | Muhammad Saad | 3/5 | N/A
| L7      | Return the maintenance rating as a double             | Maintenance Rating: 4.0                             | Maintenance rating is 4.0                            | Muhammad Saad | 4/5 | N/A
| L8      | Check new landlord status with less than 10 ratings   | Total ratings received: 9                           | Returns “True”                                       | Muhammad Saad | 4/5 | N/A
| L9      | Check new landlord status with 10 or more ratings     | Total Rating Received: 10                           | Returns “False”                                      | Dante Chandler | 3/5 | 6/5 |
| L10     | Setting the name when the name is currently null      | “John Adam”                                         | The name is now set to “John Adam”                   | Dante Chandler | 3/5 | 6/5 |
| L11     | Attempt to set the name when it has already been set  | First input: “John Adam”, Second input: "Joe James"                                          | Throws an error indicating names can only be set once| Dante Chandler |  3/5 | 6/5 |
| L12     | Setting up the email with valid format                | “johnad@gmail.com”                                  | Email has now been set to “johnad@gmail.com”         | Dante Chandler |  3/5 | 6/5 |
| L13     | Setting up the email with the wrong format            | “johnad.com”                                        | Throws an error indicating that email provided is not correct | Dante Chandler | 3/5 | 6/5 |
| L14     | Add valid ratings for comms and maintenance           | Comms: 3, Maintenance: 4                            | Updated average ratings, Rating counts incremented   | Nick Rutherfoord |1/5|3/5|
| L15     | Invalid rating given (outside the range)              | Comms: 0, Maintenance: 9                            | Throws an error for not rating in the given range    | Nick Rutherfoord |1/5|3/5|
| L16     | Representation of a new landlord in a string          | Name: “John Adam” new landlord status true          | String Format: “John Adam (New Landlord)”            | Nick Rutherfoord |1/5|3/5|
| L17     | Representation of an established landlord in a string | Name: “Steve Bagley” Comms: 3, Maintenance: 4       | String Format: “Steve Bagley - Comms: 3, Maintenance: 4" | Nick Rutherfoord |1/5|3/5|


### Class: DLLApp

#### Function: Main Loop Method
|Test ID |Inputs|Expected Outcome|
|----|------|----------------|
|A1| 'L'| should call the ListProperties function|
|A2|'P'|should call ListLandlords function|
|A3|'B'|should call the List Properties with show bad set to true|
|A4|'A'|should call the add property rating function|
|A5|'R'|should call the add rating to a landlord
|A6  |'X'| Should print "Goodbye!" and then stop running the program |   
|A7| '1', 'g'|Should output command not recognised|

##### Test creator: Abdullah Al-Ali
##### Date Test Completed: 8/5
##### Date Code was Fixed: 9/5

#### Function: ListProperties

|Test ID|Inputs|Expected Outcome|
|----|------|----------------|
|A8 | true| Print a list of all the properties with ID's including the bad properties, should be of type DLLProperty|
| A9| false | Print a list of all the properties with ID's excluding the bad properties (below 2.5 rating), should be of type DLLProperty|

##### Test creator: Muhammad Saad
##### Date Test Completed: 8/5
##### Date Code was Fixed and Passed: 10/5

#### Function: ListLandlords

|Test ID|Inputs|Expected Outcome|
|----|------|----------------|
|A10 | no input | should output a list of strings of the IDs of the Landlord, should start from 1|

##### Test creator: Dante Chandler
##### Date Test Completed: 8/5
##### Date Code was Fixed and Passed: 9/5

#### Function: Add ToLet/Toilet Rating for a property  

|Test ID|Inputs|Test Type|Expected Outcome|Notes|
|----|------------|---|----------------|---------------|
|A11|(1,T),(1,I) |Normal data|Tolet/toilet rating should be added to selected house and should output 'Rating Added!'|assuming 2 is current length of list|
|A12|(100,I),(-1,I)|Out of range|Should return 'Sorry, didn't get that choice...' and then return to the start of this action |assuming 2 is current length of list|
|A13|(p,I),(2,3)|Erronous input|Should return 'Sorry, didn't get that choice...' and then return to the start of this action ||

##### Test creator: Dante Chandler
##### Date Test Completed: 8/5
##### Date Code was Fixed and Passed: 9/5

#### Function: addLandlordRatings

|Test ID|Inputs|Test Type|Expected Outcome|Notes|When test completed? Notes about it|When test passed|
|-------|---------|------|----------------|-----|------------------------------|----------------|
|A14|(1,5,1),(1,3,3),(2,1,5)|Normal Data|should add a rating for the selected landlord|add a landlord rating from a valid landlord selection (assuming there are 2 landlord entries from start)- list starts at 1 and not 0|09/05/24 - test was failing due to bug in code| Test passed 10/05/24 - changed code to catch error from addRating function instead of validate again, and validation in other function had already passed unit test|
|A15| (1,6,1),(1,-1,3),(2,1,6),(2,3,-1) |Out of range rating value |should return an error saying rating is invalid and then return back to the loop prompt |add an invalid landlord rating from a valid landlord selection|test completed 10/05/24 - similar to A14 wasnt catching out of range values and would cause errors |Test passed 10/05/24 - changed code to catch error from addRating function instead of validate again, which caught the invalid ratings|
|A16| (9),(0)|Out of range landlord selection |should return an error to say select a valid landlord as the one selected does not exist|select an invalid landlord (landlord number testing higher out of range should be greater than number of landlords)|Test completed 10/05/24 - wasnt passing as there was no validation on the number of landlords|test completed - 10/05/24 - took a bit longer to solve as there was an error being thrown that was then caught in main|
|A17|(a), (1,!), (1,3,g)|Erronous Data |should return an error message saying invalid data entry | tests for data types that aren't int data types|



#### Function: change propertystatus

|Test ID|Inputs|Test Type |Expected Outcome|Notes|
|-------|------|----------|----------------|-----|
|A18| (1,D)(1,A),(1,U),(1,R)|Normal Data|Test for chaning house status -> Decactivated, Active, Under Review, Rented|
|A19|(1,X),(1,1) | Erronuous Test | Test for invalid house status selection | 
|A19| (9),(-1),(!) |Out of range test/ Erronuous| Test for out of range house selection | 

##### Test creator: Nicholas Rutherfoord
##### Date Test Completed: 09/05
##### Date Code was Fixed and Passed: 10/05

#### Additional Info: this function didnt exist prior to testing. Therfore, the test was made and the function was changePropertyStatus was desgiend based on the integration test. All 3 tests pass.
