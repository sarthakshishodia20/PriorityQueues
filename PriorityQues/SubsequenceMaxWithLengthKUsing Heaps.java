class Solution {
    static class Pairs implements Comparable<Pairs> {
        // ye class hai index ko sort krne ke liye in increasing order
        int newElement;
        int newIndex;
        public Pairs(int newElement, int newIndex) {
            this.newElement = newElement;
            this.newIndex = newIndex;
        }
        @Override
        public int compareTo(Pairs p2) {
            return this.newIndex - p2.newIndex;
        }
    }
    static class Pair implements Comparable<Pair> {
        // ye class hai elements ko sort krne ke liye in descending order thus making a subsequence in the given array of nums
        int element;
        int index;

        public Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }
        @Override
        public int compareTo(Pair p2) {
            return p2.element - this.element; 
        }
    }
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }
        List<Pair> list = new ArrayList<>();
        while (k-- > 0) {
            list.add(pq.poll());
        }
        PriorityQueue<Pairs> newPq = new PriorityQueue<>();
        for (Pair p : list) {
            newPq.add(new Pairs(p.element, p.index));
        }
        int[] ans = new int[newPq.size()];
        int index = 0;
        while (!newPq.isEmpty()) {
            ans[index++] = newPq.poll().newElement;
        }

        return ans;
    }
}
