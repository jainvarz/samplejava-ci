package com.travis.samplejava;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SimpleCalculatorParameterizedTest {
	
    @Parameters(name = "{index}: addition(input1-{0},input2-{1} | output - {2})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { 1,2,3 }, { 100,250,350 }, { -1,5,4 }  
           });
    }
    
    @Parameter
    public int input1;
    
    @Parameter(1)
    public int input2;

    @Parameter(2)
    public int expectedResult;

    
	@Test
	public void testAddition() {
		SimpleCalculator calc = new SimpleCalculator();
		assertEquals(calc.add(input1, input2), expectedResult);
	}
}
