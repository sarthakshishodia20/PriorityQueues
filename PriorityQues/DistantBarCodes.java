class Solution {
    //Same Approach use hui hai just like in question of Organize String sabko Heap ke andr add kia agr second wala empty nahi hai usko add krte chle gaye and frequency dekhte chle gye
    // Exact Copy of Organise String 
    static class Pair implements Comparable<Pair> {
        int element;
        int frequency;
        public Pair(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }
        @Override
        public int compareTo(Pair p2) {
            if (this.frequency == p2.frequency) {
                return this.element - p2.element;
            } else {
                return p2.frequency - this.frequency;
            }
        }
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : barcodes) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int frequency = entry.getValue();
            pq.add(new Pair(element, frequency));
        }
        while (!pq.isEmpty()) {
            Pair first = pq.poll();
            list.add(first.element);
            if (!pq.isEmpty()) {
                Pair second = pq.poll();
                list.add(second.element);
                if (--second.frequency > 0) {
                    pq.add(second);
                }
            }
            if (--first.frequency > 0) {
                pq.add(first);
            }
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for (int ele : list) {
            ans[index++] = ele;
        }
        return ans;
    }
}
