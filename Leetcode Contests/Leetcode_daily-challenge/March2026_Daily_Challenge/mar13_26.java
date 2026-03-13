public class mar13_26 {
    public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long)1e18;
        long ans = right;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(canFinish(mid, mountainHeight, workerTimes)){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public static boolean canFinish(long time, int mountainHeight, int[] workerTimes){
        long total = 0;
        for(int a : workerTimes){
            long val = (2 * time) / a;
            long x = (long)(Math.sqrt(1 + 4 * val) - 1) / 2;
            total += x;
            if(total >= mountainHeight) return true;
        }
        return total >= mountainHeight;
    }
    public static void main(String[] args) {
        int mountainHeight = 4;
        int[] workerTimes = {2,1,1};
        int mountainHeight2 = 10;
        int[] workerTimes2 = {3,2,2,4};
        System.out.println(minNumberOfSeconds(mountainHeight, workerTimes) + " " + minNumberOfSeconds(mountainHeight2, workerTimes2));
    }
}
