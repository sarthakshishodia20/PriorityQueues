class Solution {
    static class Pair implements Comparable<Pair> {
        String word;
        int freq;
        Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
        public int compareTo(Pair other) {
            if (this.freq != other.freq) {
                return other.freq - this.freq;
            } else {
                return this.word.compareTo(other.word); 
            }
        }
    }
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> response : responses) {
            HashSet<String> set = new HashSet<>();
            for (String word : response) {
                set.add(word);
            }
            for (String word : set) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        return pq.peek().word; 
    }
}
