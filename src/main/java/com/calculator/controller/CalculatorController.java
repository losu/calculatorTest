package com.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.model.Result;
import com.calculator.service.CalculatorService;

@RestController
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	@PostMapping(value = "/add")
	public Result add(@RequestParam("val1") Double val1, @RequestParam("val2") Double val2) {
		return calculatorService.add(val1, val2);
	}

	@GetMapping(value = "/divide")
	public Result divide(@RequestParam("val1") Double val1, @RequestParam("val2") Double val2)
			throws IllegalArgumentException {
		return calculatorService.divide(val1, val2);
	}

}
