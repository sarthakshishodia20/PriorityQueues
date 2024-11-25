class Solution {
    // Baari baari pair bnakke daalte jao heap ke andr and check krte jao kiski freq high haia kiski nahi 
    // agr frequency of last char >1 toh reurn "" else return sb baari baari character add hote jaenge heap se aate hue
    static class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        public Pair(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }
        @Override
        public int compareTo(Pair p2){
            if(this.freq==p2.freq){
                return p2.ch-this.ch;
            }
            else{
                return p2.freq-this.freq;
            }
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        StringBuilder sb=new StringBuilder();
        while(pq.size()>1){
            Pair first=pq.poll();
            Pair second=pq.poll();
            sb.append(first.ch);
            sb.append(second.ch);

            if(--first.freq>0){
                pq.add(first);
            }
            if(--second.freq>0){
                pq.add(second);
            }
        }
        if(!pq.isEmpty()){
            char ch=pq.peek().ch;
            int lastFreq=pq.poll().freq;
            if(lastFreq>1){
                return "";
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
