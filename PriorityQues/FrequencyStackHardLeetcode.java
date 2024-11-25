class FreqStack {
    // Take a heap and hashmap pair bnake pq mein add krte jao topmot element most frequent hoga kuki pq hi isi basis pr bna hua hai aur map ko check krte jaenge ki valuekitni bchi hai or hrr baar decrement ya zero krenge based on respective condition 
    HashMap<Integer, Integer> map;
    PriorityQueue<Pair> pq;
    int index;

    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>();
        index = 0;
    }

    static class Pair implements Comparable<Pair> {
        int element;
        int frequency;
        int index;
        
        public Pair(int element, int frequency, int idx) {
            this.element = element;
            this.frequency = frequency;
            this.index = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            if (this.frequency == p2.frequency) {
                return p2.index - this.index; 
            } else {
                return p2.frequency - this.frequency;
            }
        }
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        pq.add(new Pair(val, map.get(val), index++));
    }

    public int pop() {
        Pair current = pq.poll();
        int ans = current.element;
        
        if (map.get(current.element) > 1) {
            map.put(current.element, map.get(current.element) - 1);
        } else {
            map.remove(current.element);
        }
        
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
