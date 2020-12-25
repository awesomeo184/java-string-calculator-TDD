import java.util.ArrayList;

public class StringCalculator {

    public static int splitAndSum(String text) {
        int result;

        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] values = text.split(",");
        int[] ints = parseToInt(values);
        result = sum(ints);

        return result;
    }

    private static int[] parseToInt(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(values[i]);
        }
        return ints;
    }

    private static int sum(int[] ints) {
        int result = 0;
        for (int number : ints) {
            result += number;
        }
        return result;
    }
}
