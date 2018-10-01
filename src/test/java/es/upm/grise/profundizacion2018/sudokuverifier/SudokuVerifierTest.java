import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class SudokuVerifierTest {
    
	@Test
	public void test() {
    		fail("Not yet implemented");
    }
	@Test
	public void rule1_oneChar() {
		assertEquals(-1, SudokuVerifier.verify("0"));
	}
	@Test
	public void rule1_manyChars() {
		assertEquals(-1, SudokuVerifier.verify("asdfghjklñ"));
	}
	@Test
	public void rule1_5numbers() {
		assertEquals(-1, SudokuVerifier.verify("12345"));
	}
	@Test
	public void rule_is_not1_9() {
		assertEquals(-1, SudokuVerifier.verify("103456789912345678891234567789123456678912345567891234456789123345678912234567891"));
	}
	@Test
	public void oneNumberInEachMatriz()	{
		assertEquals(-2, SudokuVerifier.verify("123456789912345678891234567789123456678912345567891234456789123345678912234567891"));
	}
	@Test
	public void numbersOnly1InARow() {
		assertEquals(-3, SudokuVerifier.verify("417369825632158947958724316825437169791586432346912758289643571573295684164871293"));
	}
	@Test
	public void goodSudoku() {
		assertEquals(0, SudokuVerifier.verify("147369825632158947958724316825437169791586432346912758289643571573291684164875293"));
	}
	
	
	
}
