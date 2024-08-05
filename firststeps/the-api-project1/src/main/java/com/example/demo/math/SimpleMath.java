package com.example.demo.math;

/*import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.exceptions.UnsupportedMathOperationExcepetion;

import converter.NumberConverter;*/

public class SimpleMath {
	
	public Double sum(Double numberOne, Double numberTwo	) {
		
		return numberOne + numberTwo;
	}
	
	
	public Double times(Double numberOne, Double numberTwo	) {
		return numberOne * numberTwo;
	}
	
	
	public Double minus(Double numberOne, Double numberTwo	) {
		
		return numberOne - numberTwo;
	}
	
	
	public Double divided(Double numberOne, Double numberTwo	) {
		
		return numberOne / numberTwo;
	}
	
	
	public Double square( Double number) {
		
		return Math.sqrt(number);
		}
}
