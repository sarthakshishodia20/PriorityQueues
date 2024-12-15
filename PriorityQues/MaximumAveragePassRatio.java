class Solution {
    static class Pair implements Comparable<Pair> {
        double benefit;
        int passedStudent;
        int totalStudent;

        public Pair(int passedStudent, int totalStudent) {
            this.passedStudent = passedStudent;
            this.totalStudent = totalStudent;
            this.benefit = calculate(passedStudent, totalStudent);
        }

        public static double calculate(int pass, int total) {
            return ((double)(pass + 1) / (total + 1)) - ((double)pass / total);
        }

        @Override
        public int compareTo(Pair p2) {
            return Double.compare(p2.benefit, this.benefit); 
        }
        public void addStudent() {
            passedStudent++;
            totalStudent++;
            benefit = calculate(passedStudent, totalStudent); 
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int[] cls : classes) {
            pq.add(new Pair(cls[0], cls[1]));
        }
        while (extraStudents > 0) {
            Pair current = pq.poll(); 
            current.addStudent();  
            pq.add(current); 
            extraStudents--;
        }
        double ans = 0.0;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            ans += (double) current.passedStudent / current.totalStudent;
        }
        return ans / classes.length;
    }
}
