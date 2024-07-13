class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        double nd = n == Integer.MIN_VALUE ? (double) n * -1 : Math.abs(n);
        double[] arr = new double[33];
        double[] power = new double[33];
        double ans = x;
        double exp = 1;
        int idx = 0;
        power[0] = 0;
        arr[0] = 1;
        for (int i = 1; exp <= nd; i++) {
            arr[i] = arr[i - 1] * ans;
            ans = arr[i - 1] * ans;
            power[i] = exp;
            exp *= 2;
            if (exp >= nd)
                idx = i;
        }
        ans = arr[idx];
        exp = power[idx];
        for (int i = idx - 1; i >= 0; i--) {
            if (exp + power[i] <= nd) {
                exp += power[i];
                ans *= arr[i];
            }
        }
        return n > 0 ? ans : 1 / ans;
    }
}