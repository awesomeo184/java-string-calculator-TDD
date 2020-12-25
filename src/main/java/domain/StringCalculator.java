package domain;

public class StringCalculator {

    public static final String SEPARATOR = "[,:]";

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }
        String[] values = text.split(SEPARATOR);
        Positive[] numbers = parseToPositives(values);
        return sum(numbers);
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static Positive[] parseToPositives(String[] values) {
        Positive[] numbers = new Positive[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Positive(values[i]);
        }
        return numbers;
    }

    private static int sum(Positive[] numbers) {
        Positive result = new Positive(0);
        for (Positive number : numbers) {
            result = result.add(number);
        }
        return result.getNumber();
    }
}
