package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UnsupportedMathOperationExcepetion;

import converter.NumberConverter;

@RestController
public class MathController {
	
	private static final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
			method= RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo	) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExcepetion("Please set a numeric value!");
		}
		return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/times/{numberOne}/{numberTwo}",
			method= RequestMethod.GET)
	public Double times(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo	) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExcepetion("Please set a numeric value!");
		}
		return (NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/minus/{numberOne}/{numberTwo}",
			method= RequestMethod.GET)
	public Double minus(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo	) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExcepetion("Please set a numeric value!");
		}
		return (NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/divided/{numberOne}/{numberTwo}",
			method= RequestMethod.GET)
	public Double divided(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo	) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExcepetion("Please set a numeric value!");
		}
		return (NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value= "/sqr/{number}", method= RequestMethod.GET)
	public Double square(@PathVariable(value= "number") String number
			) throws Exception{
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationExcepetion("Please set a numeric value!");
		}
		return Math.sqrt(NumberConverter.convertToDouble(number));
		}

	
}