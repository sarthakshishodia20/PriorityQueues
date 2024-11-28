class Solution {
    // Class bnai pair ki
    // minHeap mein capital wise ascending order mein push krdie 
    // maxHeap mein profit wise push krdie
    // phle saare pairs ko minHeap ke andr add kr denge 
    //uske baad inheap se nikal kr vo saar pair maxHeap mein daalene jiska capital hmare w means
    // current capital se chota hai uske baad jb tk k khtm nahi ho jaata saare maxHeap ke pair ko use
    // krkre profit nikalenge or agr maxheap empty ho jata hai toh break kr denge 
    static class Pair{
        int profit;
        int capital;
        public Pair(int profit,int capital){
            this.profit=profit;
            this.capital=capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> minHeap=new PriorityQueue<>((a,b)->a.capital-b.capital);
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((a,b)->b.profit-a.profit);

        for(int i=0;i<profits.length;i++){
            minHeap.add(new Pair(profits[i],capital[i]));
        }
        for(int i=0;i<k;i++){
            while(!minHeap.isEmpty() && minHeap.peek().capital<=w){
                maxHeap.add(minHeap.poll());
            }
            if(maxHeap.isEmpty()){
                break;
            }
            w+=maxHeap.poll().profit;
        }
        return w;
    }
}
