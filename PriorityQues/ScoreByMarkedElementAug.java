class Solution {
    static class Pair {
        int num;
        int index;

        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
    public long findScore(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.num == p2.num) {
                return p1.index - p2.index;
            } else {
                return p1.num - p2.num;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }

        long ans = 0;
        boolean[] marked = new boolean[nums.length];

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int index = current.index;
            int element = current.num;

            if (marked[index]) continue;

            ans += element;
            marked[index] = true;

            if (index - 1 >= 0) marked[index - 1] = true;
            if (index + 1 < nums.length) marked[index + 1] = true;
        }
        return ans;
    }
}
