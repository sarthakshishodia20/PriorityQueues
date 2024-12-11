class Solution {
    public int buyChoco(int[] prices, int money) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int price:prices){
            pq.add(price);
        }
        int Money=money;
        while(!pq.isEmpty()){
            int price1=pq.poll();
            int price2=pq.poll();
            int totalRequired=price1+price2;
            Money=Money-totalRequired;
            break;
        }
        int ans=Money;
        if(ans>=0){
            return ans;
        }
        return money;
    }
}
