import java.util.*;

public class Main {
    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        char[] numberOfSymbols = text.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();


        for (char symbol : numberOfSymbols) {

            if (!map.containsKey(symbol) && Character.isLetter(symbol) == true) {
                map.put(symbol, 1);
            } else if (Character.isLetter(symbol) == true) {
                map.put(symbol, map.get(symbol) + 1);
            }
        }
        Collection<Integer> values = map.values();

        int max = getMaximum(values);
        int min = getMinimum(values);

        List<Character> maxValues = new ArrayList<>();
        List<Character> minValues = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                maxValues.add(entry.getKey());
            } else if (entry.getValue() == min) {
                minValues.add(entry.getKey());
            }
        }
        System.out.println("Чаще всего встречается символ " + maxValues + ", он встречается " + getMaximum(values) + " раз(а)");
        System.out.println("Реже всего встречается символ " + minValues + ", он встречается " + getMinimum(values) + " раз(а)");
    }

    private static int getMaximum(Collection<Integer> values) {
        List<Integer> numbers = new ArrayList<>(values);
        int max = numbers.get(0);

        for (Integer number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static int getMinimum(Collection<Integer> values) {
        List<Integer> numbers = new ArrayList<>(values);
        int min = Integer.MAX_VALUE;

        for (Integer number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}
