class Solution {
    // Saare bracket ki value nikalo new String me add krdo agr map mein hai ya nahi hai toh ?append krdo
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        for(List<String> list:knowledge){
            map.put(list.get(0),list.get(1));
        }
        int i=0;
        StringBuilder Sb=new StringBuilder();
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch=='('){
                i++;
                StringBuilder sb=new StringBuilder();
                while(i<s.length() && s.charAt(i)!=')'){
                    sb.append(s.charAt(i));
                    i++;
                }
                Sb.append(map.containsKey(sb.toString())?map.get(sb.toString()):"?");
                i++;
                continue;
            }
            Sb.append(ch);
            i++;
        }
        return Sb.toString();
    }
}
