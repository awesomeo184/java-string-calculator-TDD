package controller;

import domain.StringCalculator;
import view.InputView;

public class StringCalculatorController {

    private final InputView userInput;

    public StringCalculatorController(InputView userInput) {
        this.userInput = userInput;
    }

    public void run() {
        int result = StringCalculator.splitAndSum(userInput.inputExpression());
        System.out.println(result);
    }
}
