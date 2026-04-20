public class april20_26 {
    public static int maxDistance(int[] colors) {
        // int n = colors.length;
        // int maxDist = Integer.MIN_VALUE;
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         if(i == j) continue;
        //         if(colors[i] == colors[j]) continue;
        //         maxDist = Math.max(maxDist, Math.abs(i - j));
        //     }
        // }
        // return maxDist;



        //O(n) SOLUTION
        int n = colors.length;
        int dist = 0;
        for(int i = 0 ; i < n - 1 ; i++){
            if(colors[i] != colors[n - 1]){
                dist = Math.max(dist, n - 1 - i);
                break;
            }
        }
        for(int i = n - 1 ; i >= 1 ; i--){
            if(colors[i] != colors[0]){
                dist = Math.max(dist, i);
                break;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[] colors = {1,1,1,6,1,1,1};
        int[] colors2 = {1,8,3,8,3};
        System.out.println(maxDistance(colors) + " " + maxDistance(colors2));
    }
}
