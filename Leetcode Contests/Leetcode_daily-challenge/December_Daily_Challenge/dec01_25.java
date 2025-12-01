public class dec01_25{
    // public static long maxRunTime(int n, int[] batteries) {
    //     long total = 0;
    //     for(int b : batteries){
    //         total += b;
    //     }
    //     long limit = total / n;
    //     for(long t = limit ; t >= 1 ; t--){
    //         if(canRun(n, batteries, t)) return t;
    //     }
    //     return 0;
    // }
    // private boolean canRun(int n, int[] batteries, long t){
    //     long available = 0;
    //     for(int b : batteries){
    //         available += Math.min((long)b, t);
    //     }
    //     return available >= n * t;
    // }

    // Approach-2 Greedy Approach - this approach works because we have to run the computers simultaneously 
    // so we will have to distribute the batteries to the all computers so, if the runtime of any battery will be 
    // greater than the average of all the runtime then the loop will end and we will return that time.

    // public long maxRunTime(int n, int[] batteries) {
    //     Arrays.sort(batteries);
    //     long total = 0;
    //     for(int b : batteries){
    //         total += b;
    //     }
    //     int m = batteries.length;
    //     int i = m - 1;
    //     while(i >= 0 && batteries[i] > total / n){
    //         total -= batteries[i];
    //         i--;
    //         n--;
    //     }
    //     return total / n;
    // }

    // Approach-3 Binary Search + Feasibility Check
    public static long maxRunTime(int n, int[] batteries){
        long total = 0;
        for(int b : batteries) total += b;
        long low = 0, high = total / n, ans = 0;

        while(low <= high){
            long mid = low + (high - low) / 2;
            if(canRun(mid, n, batteries)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    private static boolean canRun(long t, int n, int[] batteries){
        long sum = 0;
        for(int b : batteries){
            sum += Math.min((long)b, t);
        }
        return sum >= (long)n * t;
    }
    public static void main(String[] args) {
        int n = 2;
        int[] batteries = {3,3,3};
        int n2 = 2;
        int[] batteries2 = {1,1,1,1};
        System.out.println(maxRunTime(n, batteries) + " " + maxRunTime(n2, batteries2));
    }
}