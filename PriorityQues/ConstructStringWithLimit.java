class Pair {
    char character;
    int frequency;

    public Pair(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
}

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.character - a.character);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new Pair((char) (i + 'a'), freq[i])); 
            }
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Pair first = maxHeap.poll();
            char char1 = first.character;
            int freq1 = first.frequency;
            int useCount = Math.min(freq1, repeatLimit);
            for (int i = 0; i < useCount; i++) {
                result.append(char1);
            }
            freq1 -= useCount;
            if (freq1 > 0) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                Pair second = maxHeap.poll();
                char char2 = second.character;
                int freq2 = second.frequency;
                result.append(char2);
                if (freq2 > 1) {
                    maxHeap.offer(new Pair(char2, freq2 - 1));
                }
                maxHeap.offer(new Pair(char1, freq1));
            }
        }
           return result.toString();
    }
}
