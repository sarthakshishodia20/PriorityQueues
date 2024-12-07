class Solution {
    // Normal arrangement hai like previous ques's isme vegan or non vegan ko seperate or kia 
    // if veganfriendly nahi hai tb toh koi bhi restaurant utha lo agr veganFriendly hai toh sirf vegan walo ko uthana hai and price and distance toh compare krna hi hai hrr kisi mein
    // rating jyada chahiye agr same hai toh jiski bdi hia usko return krdo.....
    
    static class Pair implements Comparable<Pair> {
        int id;
        int rating;
        boolean vegan;
        int price;
        int distance;
        public Pair(int id, int rating, boolean vegan, int price, int distance) {
            this.id = id;
            this.rating = rating;
            this.vegan = vegan;
            this.price = price;
            this.distance = distance;
        }
        @Override
        public int compareTo(Pair p2) {
            if (this.rating == p2.rating) {
                return p2.id - this.id;
            } else {
                return p2.rating - this.rating;
            }
        }
    }
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int[] restaurant : restaurants) {
            int id = restaurant[0];
            int rating = restaurant[1];
            boolean vegan = restaurant[2] == 1;
            int price = restaurant[3];
            int distance = restaurant[4];
            if ((veganFriendly == 0 || vegan) && price <= maxPrice && distance <= maxDistance) {
                pq.add(new Pair(id, rating, vegan, price, distance));
            }
        }
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            ans.add(current.id);
        }
        return ans;
    }
}
