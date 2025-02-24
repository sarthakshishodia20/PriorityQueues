class Solution {
    public int[][] sortMatrix(int[][] grid) {
        // (i-j) hrr diagonal element ke liye unique hoga 
        int[][] ans = new int[grid.length][grid[0].length];
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int key = i - j;
                if (map.containsKey(key)) {
                    map.get(key).add(grid[i][j]);
                } else {
                    if (key < 0) {
                        PriorityQueue<Integer> pq = new PriorityQueue<>();
                        pq.add(grid[i][j]);
                        map.put(key, pq);
                    } else {
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                        pq.add(grid[i][j]);
                        map.put(key, pq);
                    }
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                int key = i - j;
                ans[i][j] = map.get(key).poll();
            }
        }
        return ans;
    }
}
