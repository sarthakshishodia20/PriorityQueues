import java.util.*;
public class PriorityQueues {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }
    static class Heap {
        static ArrayList<Integer> list = new ArrayList<>();

        public void add(int data) {
            list.add(data);
            int x = list.size() - 1; // child index
            int par = (x - 1) / 2; // parent index

            while (x > 0 && list.get(x) < list.get(par)) {
                // swap
                int temp = list.get(x);
                list.set(x, list.get(par));
                list.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            if (list.size() > 0) {
                return list.get(0);
            }
            return -1;
        }

        private static void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < list.size() && list.get(left) < list.get(minIdx)) {
                minIdx = left;
            }
            if (right < list.size() && list.get(right) < list.get(minIdx)) {
                minIdx = right;
            }

            // swap
            if (minIdx != i) {
                int temp = list.get(i);
                list.set(i, list.get(minIdx));
                list.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            if (list.size() == 0) {
                return -1;
            }

            int data = list.get(0);

            // swap
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            if (list.size() > 0) {
                heapify(0);
            }
            return data;
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }
    public static void heapSort(int[] arr){
        // /Convert into maxHeap
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        // push largest at the end
        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }

    }
    public static void heapify(int[] arr,int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;

        if(left<size && arr[left]>arr[maxIdx]){
            maxIdx=left;
        }
        if(right<size && arr[right]>arr[maxIdx]){
            maxIdx=right;
        }
        if(maxIdx!=i){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            heapify(arr, maxIdx, size);
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq=new PriorityQueue<>();
        // pq.add(10);
        // pq.add(2);
        // pq.add(3);
        // pq.add(5);
        // while(!pq.isEmpty()){
        //     System.out.print(pq.peek()+" ");
        //     pq.remove();
        // }
        // Heap h=new Heap();
        // h.add(2);
        // h.add(3);
        // h.add(5);
        // while(!h.isEmpty()){
        //     System.out.print(h.peek()+" ");
        //     System.out.println();
        //     h.remove();
        // }
        // int[] arr={1,2,3,4,53,90,86,89,39,23,543,5,6,7};
        // heapSort(arr);
        // System.out.print(Arrays.toString(arr));
        // System.out.println();
        // PriorityQueue<Student> pq=new PriorityQueue<>();
        // pq.add(new Student("Abhnav", 1));
        // pq.add(new Student("jkl", 2));
        // pq.add(new Student("def", 11));
        // pq.add(new Student("ghi", 10));
        // while(!pq.isEmpty()){
        //     System.out.print(pq.peek().name+" -> "+pq.peek().rank);
        //     System.out.println();
        //     pq.remove();
        // }
        int[][] pts={{3,3},{5,-1},{-2,4}};
        PriorityQueue<Cars> pq=new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int dist=pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
            pq.add(new Cars(pts[i][0], pts[i][1], dist, i));
        }
        for(int i=0;i<pq.size();i++){
            System.out.println("C"+pq.remove().idx);
        }

        
    }
    static class Cars implements Comparable<Cars>{
        int x;
        int y;
        int dist;
        int idx;
        public Cars(int x,int y,int dist,int idx){
            this.x=x;
            this.y=y;
            this.dist=dist;
            this.idx=idx;
        }
        @Override
        public int compareTo(Cars p){
            return this.dist-p.dist;
        }
    }

    public static int minimumCostConnectingRopes(int[] arr){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int cost=0;
        while(pq.size()>1){
            int min1=pq.remove();
            int min2=pq.remove();
            cost+=min1+min2;
            pq.add(min1+min2);
        }
        return cost;
    }
    public static int findKthSmallest(int[] arr,int k){
        // for smallest element make max heap 
        // for largest element make min heap
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            p.add(arr[i]);
        }
        for(int i=k;i<=arr.length;i++){
            if(arr[i]<p.peek()){
                p.remove();
                p.add(arr[i]);
            }
        }
        return p.peek();
    }

    public static int KthSumSubarrayLargest(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(pq.size()<k){
                    pq.add(sum);
                }
                else{
                    if(sum>pq.peek());
                    pq.remove();
                    pq.add(sum);
                }
            }
        }
        return pq.peek();
    }
    static class Element{
        int value;
        int arrayIndex;
        int elementIndex;
        public Element(int value,int arrayIndex,int elementIndex){
            this.value=value;
            this.arrayIndex=arrayIndex;
            this.elementIndex=elementIndex;
        }
    }
    public static ArrayList<Integer> mergeKSortedArray(ArrayList<ArrayList<Integer>> kArrays){
        ArrayList<Integer> result=new ArrayList<>();
        PriorityQueue<Element> pq=new PriorityQueue<>((a,b)->a.value-b.value);
        for(int i=0;i<kArrays.size();i++){
            if(kArrays.get(i).size()>0){
                pq.add(new Element(kArrays.get(i).get(0), i, 0));
            }
        }
        while(!pq.isEmpty()){
            Element current=pq.poll();
            result.add(current.value);
            int nextElementIndex=current.elementIndex+1;
            if(nextElementIndex<kArrays.get(current.arrayIndex).size()){
                pq.add(new Element(kArrays.get(current.arrayIndex).get(nextElementIndex), current.arrayIndex, nextElementIndex));
            }
        }
        return result;
    }

        // Function to merge k sorted arrays.
        // static class Element {
        //     int value;
        //     int arrayIndex;
        //     int elementIndex;
    
        //     public Element(int value, int arrayIndex, int elementIndex) {
        //         this.value = value;
        //         this.arrayIndex = arrayIndex;
        //         this.elementIndex = elementIndex;
        //     }
        // }
    
        // public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        //     ArrayList<Integer> result = new ArrayList<>();
        //     PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
    
        //     // Initialize the priority queue with the first element of each array
        //     for (int i = 0; i < arr.length; i++) {
        //         if (arr[i].length > 0) {
        //             pq.add(new Element(arr[i][0], i, 0));
        //         }
        //     }
    
        //     // Extract elements from the priority queue and add the next element from the same array
        //     while (!pq.isEmpty()) {
        //         Element current = pq.poll();
        //         result.add(current.value);
        //         int nextElementIndex = current.elementIndex + 1;
        //         if (nextElementIndex < arr[current.arrayIndex].length) {
        //             pq.add(new Element(arr[current.arrayIndex][nextElementIndex], current.arrayIndex, nextElementIndex));
        //         }
        //     }
    
        //     return result;
        // }
        public static ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        ArrayList<Integer> list=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                list.add(pq.remove());
            }
        }
        while(!pq.isEmpty()){
            list.add(pq.remove());
        }
        return list;
    }




    static class Pair implements Comparable<Pair> {
        int diff;
        int element;
        
        public Pair(int diff, int elem) {
            this.diff = diff;
            this.element = elem;
        }
        
        @Override
        public int compareTo(Pair p2) {
            if (this.diff == p2.diff) {
                return this.element - p2.element;
            }
            return this.diff - p2.diff;
        }
    }

    static class Hello implements Comparable<Hello>{
        int frequency;
        int element;
        public Hello(int frequency,int element){
            this.frequency=frequency;
            this.element=element;
        }
        @Override
        public int compareTo(Hello h2){
            if(this.frequency==h2.frequency){
                return h2.element-this.element;
            }
            else{
                return this.frequency-h2.frequency;
            }
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int value:nums){
            map.put(value,map.getOrDefault(value,0)+1);
        }

        PriorityQueue<Hello> pq=new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int frequency=entry.getValue();
            int element=entry.getKey();
            pq.add(new Hello(frequency,element));
        }
        int p=0;
        int[] ans=new int[nums.length];
        while(!pq.isEmpty()){
            Hello current=pq.poll();
            int freq=current.frequency;
            int elem=current.element;
            for(int i=0;i<freq;i++){
                ans[p++]=elem;
            }
        }
        return ans;
        
    }

    public static long kthSmallest(long[] A, long k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for (long num : A) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static long sumBetweenTwoKth(long[] A, long N, long K1, long K2) {
        long ko1 = kthSmallest(A, K1);
        long ko2 = kthSmallest(A, K2);
        long sum = 0;
        for (long num : A) {
            if (num > ko1 && num < ko2) {
                sum += num;
            }
        }
        return sum;
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            int element = arr[i];
            pq.add(new Pair(diff, element));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            list.add(current.element);
        }
        
        Collections.sort(list);
        return list;
    }


    // static class Pair implements Comparable<Pair> {
    //     int frequency;
    //     int element;
    //     public Pair(int frequency,int element){
    //         this.frequency=frequency;
    //         this.element=element;
    //     }
    //     @Override
    //     public int compareTo(Pair p2){
    //         if(this.frequency==p2.frequency){
    //             return this.element-p2.element;
    //         }
    //         return this.frequency-p2.frequency;
    //     }
    // }
    // public int[] topKFrequent(int[] nums, int k) {
    //     HashMap<Integer,Integer> map=new HashMap<>();
    //     for(int value:nums){
    //         map.put(value,map.getOrDefault(value,0)+1);
    //     }

    //     PriorityQueue<Pair> pq=new PriorityQueue<>();
    //     for(Map.Entry<Integer,Integer> entry:map.entrySet()){
    //         int frequency=entry.getValue();
    //         int element=entry.getKey();
    //         pq.add(new Pair(frequency,element));
    //         if(pq.size()>k){
    //             pq.poll();
    //         }
    //     }
    //     int[] ans=new int[k];
    //     int h=0;
    //     while(!pq.isEmpty()){
    //         Pair current=pq.poll();
    //         ans[h++]=current.element;
    //     }
    //     return ans;

    // }
    //     static class Pair implements Comparable<Pair> {
    //         int frequency;
    //         char element;
    //         public Pair(int frequency,char element){
    //             this.frequency=frequency;
    //             this.element=element;
    //         }
    //         @Override
    //         public int compareTo(Pair p2){
    //             if(this.frequency==p2.frequency){
    //                 return this.element-p2.element;
    //             }
    //             return this.frequency-p2.frequency;
    //         }
    //     }
    //     public String frequencySort(String s) {
    //         HashMap<Character,Integer> map=new HashMap<>();
    //         char[] array=s.toCharArray();
    //         for(int i=0;i<array.length;i++){
    //             map.put(array[i],map.getOrDefault(array[i],0)+1);
    //         }
    //         PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
    //         for(Map.Entry<Character,Integer> entry:map.entrySet()){
    //             int frequency=entry.getValue();
    //             char element=entry.getKey();
    //             pq.add(new Pair(frequency,element));
    //         }
    //         StringBuilder sb=new StringBuilder();
    //         while(!pq.isEmpty()){
    //             Pair current=pq.poll();
    //             int frequent=current.frequency;
    //             char elem=current.element;
    //             for(int i=0;i<frequent;i++){
    //                 sb.append(elem);
    //             }
    //         }
    //         return sb.toString();
    //     }


    // static class Pair implements Comparable<Pair>{
	// 	int frequency;
	// 	String word;
	// 	public Pair(int frequency,String word){
	// 		this.frequency=frequency;
	// 		this.word=word;
	// 	}
	// 	@Override
	// 	public int compareTo(Pair p2){
	// 		if(this.frequency==p2.frequency){
	// 			return this.word.compareTo(p2.word);
	// 		}
	// 		return p2.frequency-this.frequency;// Decreasing order
	// 	}
	// }
	
	// public static List<String> kMostFreqWords(String[] words, int K) {
	// 	// Write your code here.
	// 	List<String> list=new ArrayList<>();
	// 	HashMap<String,Integer> map=new HashMap<>();
	// 	for(int i=0;i<words.length;i++){
	// 		map.put(words[i],map.getOrDefault(words[i], 0)+1);
	// 	}
	// 	PriorityQueue<Pair> pq=new PriorityQueue<>();
	// 	for(Map.Entry<String,Integer> entry:map.entrySet()){
	// 		int frequency=entry.getValue();
	// 		String word=entry.getKey();
	// 		pq.add(new Pair(frequency,word));
	// 	}
	// 	for(int i=0;i<K;i++){
	// 		list.add(pq.poll().word);
	// 	}
	// 	return list;
		
	// }



    public static int[] kthLargestInStream(int[] arr,int k,int n){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            addToHeap(pq,arr[i],k);
            if(pq.size()<k){
                result[i]=-1;
            }
            else{
                result[i]=pq.peek();
            }
        }
        return result;
    }
    public static void addToHeap(PriorityQueue<Integer> pq,int num,int k){
        pq.add(num);
        if(pq.size()>k){
            pq.poll();
        }
    }
    public static int[] medianInArrayStream(int[] arr,int n){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int median=-1;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            median=callMedian(arr[i],maxHeap,minHeap,median);
            list.add(median);
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    public static int signum(int a,int b){
        if(a==b){
            return 0;
        }
        if(a<b){
            return -1;
        }
        else{
            return 1;
        }
    }
    public static int callMedian(int element,PriorityQueue<Integer> maxHeap,PriorityQueue<Integer> minHeap,int median){
        switch (signum(maxHeap.size(),minHeap.size())) {
            case 0:
            if(element>median){
                minHeap.add(element);
                median=minHeap.peek();
            }
            else{
                maxHeap.add(element);
                median=maxHeap.peek();
            }
            break;
            case 1:
            if(element>median){
                minHeap.add(element);
                median=(minHeap.peek()+maxHeap.peek())/2;
            }
            else{
                minHeap.add(maxHeap.peek());
                maxHeap.poll();
                maxHeap.add(element);
                median=(minHeap.peek()+maxHeap.peek())/2;
            }
            break;
            case -1:
            if(element>median){
                maxHeap.add(minHeap.peek());
                minHeap.poll();
                minHeap.add(element);
                median=(minHeap.peek()+maxHeap.peek())/2;
            }
            else{
                maxHeap.add(element);
                median=(minHeap.peek()+maxHeap.peek())/2;
            }
            break;
        }
        return median;
    }
}
