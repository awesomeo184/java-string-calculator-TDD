import controller.StringCalculatorController;
import java.util.Scanner;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView userInput = new InputView(scanner);
        StringCalculatorController controller = new StringCalculatorController(userInput);
        controller.run();

    }

}
