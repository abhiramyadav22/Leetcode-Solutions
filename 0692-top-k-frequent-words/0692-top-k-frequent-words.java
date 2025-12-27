class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
              if (!count.get(a).equals(count.get(b)))
                    return count.get(a) - count.get(b);
                return b.compareTo(a);
            }
        );
        for (String w : count.keySet()) {
            pq.add(w);
            if (pq.size() > k)
                pq.poll();
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty())
            result.add(pq.poll());

        Collections.reverse(result);
        return result;
    }
}
