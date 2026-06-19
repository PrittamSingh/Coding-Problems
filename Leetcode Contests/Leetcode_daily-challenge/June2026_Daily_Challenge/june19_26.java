public class june19_26 {
    public static int largestAltitude(int[] gain) {
        int n = gain.length;
        int altitude = 0;
        int maxAltitude = 0;
        for(int i = 0 ; i < n ; i++){
            altitude += gain[i];
            maxAltitude = Math.max(maxAltitude, altitude);
        }
        return maxAltitude;
    }
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }
}
