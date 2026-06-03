public class june03_26 {
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        // for land -> water
        int minLand = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            minLand = Math.min(minLand, landStartTime[i] + landDuration[i]);
        }
        int landToWater = Integer.MAX_VALUE;
        for(int i = 0 ; i < m ; i++){
            int finishWater = Math.max(minLand, waterStartTime[i]) + waterDuration[i];
            landToWater = Math.min(landToWater, finishWater);
        }
        // for Water -> land
        int minWater = Integer.MAX_VALUE;
        for(int i = 0 ; i < m ; i++){
            minWater = Math.min(minWater, waterStartTime[i] + waterDuration[i]);
        }
        int waterToLand = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int finishLand = Math.max(minWater, landStartTime[i]) + landDuration[i];
            waterToLand = Math.min(waterToLand, finishLand);
        }
        return Math.min(landToWater, waterToLand);
    }
    public static void main(String[] args) {
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }
}
