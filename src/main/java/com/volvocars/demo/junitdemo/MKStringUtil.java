package com.volvocars.demo.junitdemo;

/**
 * Utility class for various {@link String} manipulations.
 */
public class MKStringUtil {

    /**
     * Repeats the given {@link String} {@code repetitions} number of times.
     * 
     * @param stringToRepeat
     *            The {@link String} to repeat.
     * @param repetitions
     *            Number of times to repeat it.
     * @return A {@link String} holding the repetitions.
     */
    public static String repeater(String stringToRepeat, int repetitions) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            result.append(stringToRepeat);
        }
        return result.toString();
    }

    /**
     * Filters out all occurrences of {@code filter} from {@code stringToFilter}.
     * 
     * @param stringToFilter
     *            The {@link String} to perform the filtering on.
     * @param filter
     *            The {@link String} to filter out.
     * @return A new {@link String} with the filtered content.
     */
    public static String filter(String stringToFilter, String filter) {
        return stringToFilter.replace(filter, "");
    }

    /**
     * Checks if a {@link String} contains a valid numeric, in this definition either
     * <ul>
     * <li>1 or more digits <i>or</i></li>
     * <li>0 or more digits, followed by a dot (.), followed by 1 or more digits.
     * </ul>
     * 
     * @param string
     *            The {@link String} to test.
     * @return {@code true} if it is a valid numeric, {@code false} otherwise.
     */
    public static boolean isNumeric(String string) {
        return string.matches("([0-9]*\\.)?[0-9]+");
    }
}
