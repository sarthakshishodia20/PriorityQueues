class Solution {
    // Same as  handof straight leetcode 846 ek dm same hai 
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0){
            return false;
        }
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        while(!map.isEmpty()){
            int firstElement=map.firstKey();
            for(int i=0;i<k;i++){
                int next=firstElement+i;
                if(!map.containsKey(next)){
                    return false;
                }
                int frequency=map.get(next);
                if(frequency==1){
                    map.remove(next);
                }
                else{
                    map.put(next,frequency-1);
                }
            }
        }
        return true;
    }
}
