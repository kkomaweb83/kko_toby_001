package com.kko.test2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CalcSumTest {
	
	Calculator2 calculator2 = null;
	String numFilepath = "";
	
	@Before
	public void setUp(){
		this.calculator2 = new Calculator2();
		this.numFilepath = getClass().getResource("numbers.txt").getPath();
	}
	
	@Test
	public void sumOfNumbers() throws IOException {
		int sum = calculator2.calcuSum(this.numFilepath);
		assertThat(sum, is(15));
	}
	
	@Test
	public void multiplyOfNumbers() throws IOException {
		int sum = calculator2.calcuMultiply(this.numFilepath);
		assertThat(sum, is(120));
	}

}
