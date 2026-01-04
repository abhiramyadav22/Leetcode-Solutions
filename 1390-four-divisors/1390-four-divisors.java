class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            int count = 0;
            int divSum = 0;
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    int d1 = i;
                    int d2 = n / i;
                    if (d1 == d2) {
                        count++;
                        divSum += d1;
                    } else {
                        count += 2;
                        divSum += d1 + d2;
                    }
                }
            }
            if (count == 4) {
                sum += divSum;
            }
        }

        return sum;
    }
}
