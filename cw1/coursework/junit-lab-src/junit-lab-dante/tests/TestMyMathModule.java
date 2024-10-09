import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TestMyMathModule {
	private static int input1;
	private static int input2;
	private static int input3;
	private static int input4;
	private static int input5;
	@BeforeAll
	static void setup(){
		input1 = 3;
		input2 = 6;
		input3 = 2000000000;
		input4 = -2000000000;
		input5 = 0;
	}

	@Test
	
	@Disabled
	void test() {
		fail("Not yet implemented");
	}
	
	void test1() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myMultiply(input1,input2);
		} catch(Exception e){
		}
		assertEquals(18, myanswer);
	}
	
	void testError1() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myMultiply(input2,input3);
		} catch (Exception e) {
			if (e.getClass()==Exception.class) {
				return; //it passed – acted correctly.
			}
		}
		fail("no error thrown, hashtag sadface");
	}
	
	void test2() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myDivision(input2,input1);
		} catch(Exception e){
		}
		assertEquals(2, myanswer);
	}
	
	void testError2() {
		int myanswer = 0;
		try {
			myanswer = MathModule.myDivision(input2,input5);
		} catch (Exception e) {
			if (e.getClass()==Exception.class) {
				return; //it passed – acted correctly.
			}
		}
		fail("no error thrown, hashtag sadface");
	}
	
	

}
