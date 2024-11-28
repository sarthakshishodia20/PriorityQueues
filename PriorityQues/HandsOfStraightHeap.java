class Solution {
    // Sorted Map se baari baari element uthaye or groupSize bnate gye elemment daalne ke liye
    // agr handlength is not matchable with groupSize means groups nahi bn skte false return krdo and at last sbki frequency remove krte jao on putting each and every elemtn into the groupSize 
    // .firstKey() return the first element of map
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        while (!map.isEmpty()) {
            int firstElement = map.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int next = firstElement + i;
                if (!map.containsKey(next)) {
                    return false;
                }
                int freq = map.get(next);
                if (freq == 1) {
                    map.remove(next);
                } else {
                    map.put(next, freq - 1);
                }
            }
        }
        return true;
    }
}
