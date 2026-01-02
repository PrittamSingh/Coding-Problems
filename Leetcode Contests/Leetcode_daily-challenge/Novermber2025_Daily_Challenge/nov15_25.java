public class nov15_25 {
    public static int numberOfSubstrings(String s) {
        // Approach-1 => Brute-Force O(n^3)
        // int n = s.length();
        // int ans = 0;
        // for(int i = 0 ; i < n ; i++){
        // for(int j = i ; j < n ; j++){
        // int ones = 0 , zeros = 0;
        // for(int k = i ; k <= j ; k++){
        // if(s.charAt(k) == '0') zeros++;
        // else ones++;
        // }
        // if(ones >= (zeros * zeros)) ans++;
        // }
        // }
        // return ans;

        // Approach-2 => Better Brute-Force O(n^2)
        // int n = s.length();
        // int ans = 0;
        // for(int i = 0 ; i < n ; i++){
        // int zeros = 0 , ones = 0;
        // for(int j = i ; j < n ; j++){
        // if(s.charAt(j) == '0') zeros++;
        // else ones++;

        // if(ones >= (zeros * zeros)) ans++;
        // }
        // }
        // return ans;

        // Approach-3 => optimal solution
        int n = s.length();
        int[] cumCountOne = new int[n];

        // Build prefix sum of ones
        cumCountOne[0] = (s.charAt(0) == '1') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            cumCountOne[i] = cumCountOne[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int oneCount = cumCountOne[j] - (i > 0 ? cumCountOne[i - 1] : 0);
                int zeroCount = (j - i + 1) - oneCount;

                int z2 = zeroCount * zeroCount;

                if (z2 > oneCount) {
                    int waste = z2 - oneCount;
                    j += waste - 1;
                }

                else if (z2 == oneCount) {
                    result++;
                }

                else {
                    result++;
                    int k = (int) Math.sqrt(oneCount) - zeroCount;
                    int next = j + k;

                    if (next >= n) {
                        result += (n - j - 1);
                        break;
                    } else {
                        result += k;
                    }
                    j = next;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        String s = "00011";
        String s2 = "101101";
        int ans = numberOfSubstrings(s);
        int ans2 = numberOfSubstrings(s2);
        System.out.println(ans + " " + ans2);
    }
}
