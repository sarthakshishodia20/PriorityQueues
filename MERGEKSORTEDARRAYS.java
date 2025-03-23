import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution 
{
    static class Element {
        int value;
        int arrayIndex;
        int elementIndex;

        public Element(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (int i = 0; i < kArrays.size(); i++) {
            if (kArrays.get(i).size() > 0) {
                pq.add(new Element(kArrays.get(i).get(0), i, 0));
            }
        }
        while (!pq.isEmpty()) {
            Element current = pq.poll();
            result.add(current.value);
            int nextElementIndex = current.elementIndex + 1;
            if (nextElementIndex < kArrays.get(current.arrayIndex).size()) {
                pq.add(new Element(kArrays.get(current.arrayIndex).get(nextElementIndex), current.arrayIndex, nextElementIndex));
            }
        }
        return result;
    }
}
