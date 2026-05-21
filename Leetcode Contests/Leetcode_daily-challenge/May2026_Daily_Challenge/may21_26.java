import java.util.HashSet;

public class may21_26 {
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for(int num : arr1){
            String s = String.valueOf(num);
            for(int i = 1; i <= s.length(); i++){
                set.add(s.substring(0, i));
            }
        }
        int maxLen = 0;
        for(int num : arr2){
            String s = String.valueOf(num);
            for(int i = 1 ; i <= s.length() ; i++){
                String prefix = s.substring(0, i);
                if(set.contains(prefix)){
                    maxLen = Math.max(maxLen, i);
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,10,100};
        int[] arr2 = {1000};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }
}
