import java.util.*;

public class AvgCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Enter numbers (type 'done' to finish):");
        while (true) {
            String input = sc.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }
        try {
            if (numbers.size() == 0) {
                throw new ArithmeticException("Cannot calculate average of empty list.");
            }
            double sum = 0;
            for (int num : numbers) {
                sum += num;
            }
            double avg = sum / numbers.size();
            System.out.println("Average: " + avg);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}