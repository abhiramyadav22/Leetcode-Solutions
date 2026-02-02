class Solution {
    class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long baseCost = nums[0];
        Comparator<Pair> cmp = (a, b) -> {
            if(a.value == b.value) {
                return a.index - b.index;
            }
            return a.value - b.value;
        };
        TreeSet<Pair> small = new TreeSet<>(cmp);
        TreeSet<Pair> large = new TreeSet<>(cmp);


        long sum = 0;
        int i = 1;
        int rem = k - 1;

        while(i < dist + 1) {
            Pair pair = new Pair(nums[i], i);
            small.add(pair);
            sum += pair.value;

            if(small.size() > rem) {
                Pair largestPair = small.pollLast();
                sum -= largestPair.value;
                large.add(largestPair);
            }
            i++;
        }

        long ans = Long.MAX_VALUE;
        while(i < n) {
            Pair cur = new Pair(nums[i], i);
            small.add(cur);
            sum += cur.value;

            if(small.size() > rem) {
                Pair largestPair = small.pollLast();
                sum -= largestPair.value;
                large.add(largestPair);
            }

            ans = Math.min(ans, sum);


            int outIndex = i - dist;
            Pair outPair = new Pair(nums[outIndex], outIndex);

            if(small.remove(outPair)) {
                sum -= outPair.value;

                if(!large.isEmpty()) {
                    Pair toAdd = large.pollFirst();
                    small.add(toAdd);
                    sum += toAdd.value;
                }
            } else {
                large.remove(outPair);
            }
            i++;
        }
        return baseCost + ans;
    }
}