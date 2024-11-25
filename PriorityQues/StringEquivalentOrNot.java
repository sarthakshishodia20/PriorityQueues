class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(char c:word1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(char c:word2.toCharArray()){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        for(char c='a';c<='z';c++){
            int ans1=0;
            int ans2=0;
            if(map1.containsKey(c)){
                ans1=map1.get(c);
            }
            if(map2.containsKey(c)){
                ans2=map2.get(c);
            }
            int diff=Math.abs(ans1-ans2);
            if(diff>3){
                return false;
            }
        }
        return true;
    }
}
