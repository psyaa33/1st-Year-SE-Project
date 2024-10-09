import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TestMyMathModule {
	
	private static int input1;
	private static int input2;
	private static int input3;
	@BeforeAll
	static void setup(){
		input1 = 3;
		input2 = 6;
		input3 = 2000000000;
		}

	@Test
	
	void test1() {
		int myanswer = 0;
		try {
		myanswer = MathModule.myMultiply(input1,input2);
		} catch(Exception e){
		}
		assertEquals(18, myanswer);
	}
	@Disabled
	void test() {
		fail("Not yet implemented");
	}
	
	void testError() {
		int myanswer = 0;
		try {
		myanswer = MathModule.myMultiply(input2,input3);
		} catch (Exception e) {
		if (e.getClass()==Exception.class) {
		return; //it passed – acted correctly.
		}
		}
		fail(“no error thrown, hashtag sadface”);
		}
	

	
	
	
	
	
	
	
}
