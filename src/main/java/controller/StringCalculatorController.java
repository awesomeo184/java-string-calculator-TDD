package controller;

import domain.StringCalculator;
import java.util.Scanner;
import view.InputView;

public class StringCalculatorController {

    private final InputView userInput;

    public StringCalculatorController(InputView userInput) {
        this.userInput = userInput;
    }

    public void run() {
        StringCalculator.splitAndSum(userInput.inputExpression());
    }
}
