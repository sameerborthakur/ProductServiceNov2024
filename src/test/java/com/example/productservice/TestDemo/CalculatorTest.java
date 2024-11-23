package com.example.productservice.TestDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class CalculatorTest
{
	@Test
	void whenAdditionIsPerformed()
	{
		Calculator calculator = new Calculator();
		int result = calculator.add(10, 20);
		assertEquals(30, result);
	}

	@Test
	void whenSubtractionIsPerformed()
	{
		Calculator calculator = new Calculator();
		int result = calculator.sub(20, 10);
		assertEquals(10, result);
	}

	@Test
	void whenDivideByZeroThrowArithmeticException()
	{
		Calculator calculator = new Calculator();
		assertThrows(ArithmeticException.class, () -> calculator.div(10, 0));
	}
}
