import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] case1 = {1, 2, 3};
        int[] case2 = {4, 3, 2, 1};
        int[] case3 = {9};
        int[] case4 = {9, 9, 9, 9};
        int[] case5 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] case6 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] case7 = {0, 1, 2, 3, 0};
        int[] case8 = {1, 0};
        int[] case9 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};

        System.out.println(Arrays.toString(plusOne(case9)));
    }

    public static int[] plusOne(int[] digits) {
        if (digits.length >= 9) {
            boolean onlyNines = true;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] != 9) {
                    onlyNines = false;
                }
            }

            if (onlyNines) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                for (int i = 1; i < digits.length; i++) {
                    newDigits[i] = 0;
                }
                return newDigits;
            }

            if (digits[digits.length - 1] == 9) {
                digits[digits.length - 2] += 1;
                digits[digits.length - 1] = 0;
            } else {
                digits[digits.length - 1] += 1;
            }
            return digits;
        }

        int digit = 0;
        int sum = 0;
        int count = 0;
        int countNines = 0;
        for (int i = 0; i < digits.length; i++) {
            digit = digits[i];
            for (int j = i + 1; j < digits.length; j++) {
                digit *= 10;
            }
            sum += digit;
            count++;
            if (digits[i] == 9) countNines++;
        }
        sum += 1;

        if (count == countNines) count += 1;

        int[] newDigits = new int[count];

        for (int i = count - 1; i > -1; i--) {
            int d = sum % 10;
            newDigits[i] = d;
            sum /= 10;
        }
        return newDigits;
    }
}
