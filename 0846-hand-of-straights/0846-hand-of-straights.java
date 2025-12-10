import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int handNumber : hand) {
            mp.put(handNumber, mp.getOrDefault(handNumber, 0) + 1);
        }

        while (!mp.isEmpty()) {
            int curr = mp.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int key = curr + i;
                if (!mp.containsKey(key)) {
                    return false;
                }
                int val = mp.get(key) - 1;
                if (val == 0) {
                    mp.remove(key);
                } else {
                    mp.put(key, val);
                }
            }
        }
        return true;
    }
}
