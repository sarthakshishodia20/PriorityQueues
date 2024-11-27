class Solution {
    static class Pair implements Comparable<Pair> {
        int element;
        int frequency;
        public Pair(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }
        @Override
        public int compareTo(Pair p2) {
            return p2.frequency - this.frequency; 
        }
    }
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int n = arr.length;
        int count = 0;
        int setSize = 0;
        while (!pq.isEmpty() && count < n / 2) {
            Pair pair = pq.poll(); 
            count += pair.frequency; 
            setSize++;
        }
        return setSize;
    }
}
