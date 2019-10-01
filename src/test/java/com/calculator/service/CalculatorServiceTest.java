package com.calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.calculator.model.Result;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {

	@InjectMocks
	private CalculatorService calculatorService;

	@Test
	public void shouldAddProperlyTwoValues() {
		// when
		Double val1 = 10.0;
		Double val2 = 2.0;

		// given
		Result result = calculatorService.add(val1, val2);

		// then
		assertThat(result).isNotNull();
		assertThat(result.getResult()).isEqualTo(12.0);
	}

	@Test
	public void shouldDivideProperlyTwoValues() {
		// when
		Double val1 = 10.0;
		Double val2 = 2.0;

		// given
		Result result = calculatorService.divide(val1, val2);

		// then
		assertThat(result).isNotNull();
		assertThat(result.getResult()).isEqualTo(5.0);
	}

	@Test
	public void shouldThrowException_whenDividingByZero() {
		// when
		Double val1 = 10.0;
		Double val2 = 0.0;

		// given
		Throwable thrown = catchThrowable(() -> {
			calculatorService.divide(val1, val2);
		});

		// then
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Cannot divide by zero!");
	}
}
