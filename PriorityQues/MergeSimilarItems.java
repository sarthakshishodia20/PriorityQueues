class Solution {
    static class Pair implements Comparable<Pair> {
        int value;
        int weight;
        public Pair(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.value - p2.value; 
        }
    }
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(current.value);
            list.add(current.weight);
            result.add(list);
        }
        return result;
    }
}
