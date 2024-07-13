class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 <= 9) {
                digits[i] += 1;
                carry = false;
                break;
            } else {
                digits[i] = 0;
                carry = true;
            }
        }
        if (carry == false)
            return digits;
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        for (int i = 0; i < digits.length; i++)
            newDigits[i + 1] = digits[i];
        return newDigits;
    }
}