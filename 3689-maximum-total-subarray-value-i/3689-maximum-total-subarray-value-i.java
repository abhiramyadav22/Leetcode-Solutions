class Solution {
    public long maxTotalValue(int[] numbers, int k) {
        int smallest = numbers[0];
        int largest = numbers[0];
        for (int value : numbers) {
            if (value < smallest) {
                smallest = value;
            }
            if (value > largest) {
                largest = value;
            }
        }
        return (long)(largest - smallest) * k;
    }
}