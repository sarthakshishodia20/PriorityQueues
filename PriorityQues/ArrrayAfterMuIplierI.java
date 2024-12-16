class Solution {
    static class Pair implements Comparable<Pair>{
        int element;
        int index;
        public Pair(int element,int index){
            this.element=element;
            this.index=index;

        }
        @Override
        public int compareTo(Pair p2){
            if(this.element==p2.element){
                return this.index-p2.index;
            }
            return this.element-p2.element;
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
        }
        while(k-->0){
            Pair current=pq.poll();
            int element=current.element;
            int index=current.index;
            element=element*multiplier;
            pq.add(new Pair(element,index));
        }
        List<Pair> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            Pair current=list.get(i);
            int index=current.index;
            int element=current.element;
            ans[index]=element;
        }
        return ans;
    }

}
