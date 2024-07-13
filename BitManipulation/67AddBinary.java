class Solution {
    public String addBinary(String a, String b) {
        while (a.length() < b.length())
            a = "0" + a;
        while (b.length() < a.length())
            b = "0" + b;
        StringBuilder x = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int bitA = a.charAt(i) - '0';
            int bitB = b.charAt(i) - '0';
            x.append(bitA ^ bitB ^ carry);
            carry = (bitA & bitB) | (bitA & carry) | (bitB & carry);
        }
        if (carry == 1)
            x.append('1');
        StringBuilder ans = new StringBuilder();
        for (int i = x.length() - 1; i >= 0; i--)
            ans.append(x.charAt(i));
        return ans.toString();
    }
}