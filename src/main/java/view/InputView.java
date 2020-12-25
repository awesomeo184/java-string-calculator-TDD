package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputExpression() {
        System.out.println("숫자를 입력해주세요(구분자는 , or :)");
        return input();
    }

    private String input() {
        return scanner.nextLine().trim();
    }

}
