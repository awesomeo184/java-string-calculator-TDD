package domain;

import java.util.Arrays;

public class StringCalculator {

    public static final String COMMA = ",";
    public static final String COLON = ":";
    private static final int INDEX_OF_SEPARATOR = 2;
    private static final int START_INDEX_OF_EXPRESSION = 4;

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        if (hasCustomSeparator(text)) {
            String separator = findSeparator(text);
            text = getExpression(text);
            text = text.replaceAll(separator, COMMA);
        }

        text = text.replaceAll(COLON, COMMA);
        String[] values = text.split(COMMA);
        System.out.println(Arrays.toString(values));
        Positive[] numbers = parseToPositives(values);
        return sum(numbers);
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }

    public static boolean hasCustomSeparator(String text) {
        String pattern = "//./.+";
        return text.matches(pattern);
    }

    public static String findSeparator(String text) {
        return String.valueOf(text.trim().charAt(INDEX_OF_SEPARATOR));
    }

    public static String getExpression(String text) {
        return text.substring(START_INDEX_OF_EXPRESSION);
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
