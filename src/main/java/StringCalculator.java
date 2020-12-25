import java.util.ArrayList;

public class StringCalculator {

    public static final String SEPARATOR = "[,:]";

    public static int splitAndSum(String text) {
        int result;

        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] values = text.split(SEPARATOR);
        int[] ints = parseToInt(values);
        result = sum(ints);

        return result;
    }

    private static int[] parseToInt(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < ints.length; i++) {
            int value = Integer.parseInt(values[i]);
            if (value < 0) {
                throw new RuntimeException();
            }
            ints[i] = value;
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
