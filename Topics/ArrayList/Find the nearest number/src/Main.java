import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> result = findNearestNumber(scanner.nextLine(), scanner.nextInt());
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> findNearestNumber(final String input, final int controlValue) {
        ArrayList<Integer> result = new ArrayList<>();
        String[] numbers = input.split(" ");
        int[] ints = new int[numbers.length];
        int difference = controlValue;
        for (int j = 0; j < numbers.length; j++) {
            int i = Integer.parseInt(numbers[j]);
            ints[j] = i;
            if (Math.abs(controlValue - i) < difference) {
                difference = Math.abs(controlValue - i);
            }
        }
        for (int number : ints) {
            if (Math.abs(controlValue - number) == difference) {
                result.add(number);
            }
        }
        result.sort(null);
        return result;
    }
}