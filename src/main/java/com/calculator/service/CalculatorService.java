package com.calculator.service;

import org.springframework.stereotype.Service;

import com.calculator.model.Result;

@Service
public class CalculatorService {

	/**
	 * mathematical operation for addition
	 * 
	 * @param val1 - first value
	 * @param val2 - second value
	 * @return result
	 */
	public Result add(Double val1, Double val2) {

		return new Result(val1 + val2);
	}

	/**
	 * mathematical operation for division
	 * 
	 * @param val1 - first value
	 * @param val2 - second value
	 * @return result
	 */
	public Result divide(Double val1, Double val2) {
		if (val2.equals(Double.valueOf(0))) {
			throw new IllegalArgumentException("Cannot divide by zero!");
		}
		return new Result(val1 / val2);
	}
}
