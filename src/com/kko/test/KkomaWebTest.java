package com.kko.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class KkomaWebTest {
	Calculator calculator;
	String numFilepath;
	
	@Before
	public void setup(){
		calculator = new Calculator();
		numFilepath = getClass().getResource("numbers.txt").getPath();
	}

	@Test
	public void sumOfNumbers() throws IOException{
		assertEquals(10, calculator.calSum(numFilepath));
	}
	@Test
	public void sumOfNumbersLine() throws IOException{
		assertEquals(10, calculator.calSumLine(numFilepath));
	}
	
	@Test
	public void multiplyOfNumbers() throws IOException{
		assertEquals(24, calculator.calMult(numFilepath));
	}
	@Test
	public void multiplyOfNumbersLine() throws IOException{
		assertEquals(24, calculator.calMultLine(numFilepath));
	}
	
	@Test
	public void concatLine() throws IOException{
		assertEquals("1234", calculator.concatenate(numFilepath));
	}

}
