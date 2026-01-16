import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class jan16_26 {
    public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        if(m == n){
            return (m -1) * (n - 1);
        }
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];
        h[0] = 1;
        v[0] = 1;
        h[h.length - 1] = m;
        v[v.length - 1] = n;
        for(int i = 0 ; i < hFences.length ; i++){
            h[i + 1] = hFences[i];
        }
        for(int i = 0 ; i < vFences.length ; i++){
            v[i + 1] = vFences[i];
        }
        Arrays.sort(h);
        Arrays.sort(v);
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < h.length ; i++){
            for(int j = i + 1 ; j < h.length ; j++){
                set.add(h[j] - h[i]);
            }
        }
        int maxSide = Integer.MIN_VALUE;
        for(int i = 0 ; i < v.length ; i++){
            for(int j = i + 1 ; j < v.length ; j++){
                if(set.contains(v[j] - v[i])){
                    maxSide = Math.max(maxSide, v[j] - v[i]);
                }
            }
        }
        if(maxSide == Integer.MIN_VALUE) return -1;
        long MOD = 1000000007;
        return (int)((1L * maxSide * maxSide) % MOD);
    }
    public static void main(String[] args) {
        int m = 4, n = 3;
        int[] hFences = {2,3}, vFences = {2};
        int m2 = 6, n2 = 7;
        int[] hFences2 = {2}, vFences2 = {4};
        System.out.println(maximizeSquareArea(m, n, hFences, vFences) + " " + maximizeSquareArea(m2, n2, hFences2, vFences2));
    }
}
