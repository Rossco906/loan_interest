package com.company;

import com.company.Calculation.DayResult;
import com.company.Calculation.InterestCalculator;
import com.company.Input.Processors.AbstractInputProcessor;
import com.company.Input.Processors.LoanCalculationInputProcessor;
import com.company.Input.Requests.LoanRequest;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    AbstractInputProcessor<LoanRequest> inputProcessor = new LoanCalculationInputProcessor(args);
	    inputProcessor.registerParsers();
	    LoanRequest request = inputProcessor.process();

	    InterestCalculator calculator = new InterestCalculator(request);
		calculator.calculate();
		List<DayResult> fullResult = calculator.getFullResult();
		for (DayResult result : fullResult){
			System.out.println(result);
		}
	}
}
