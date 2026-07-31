import java.util.Arrays;

public class july31_26 {
    public static int minimumPushes(String word) {
        int[] freq = new int[26];
        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int k = 0;
        int j = freq.length - 1;
        while(k <= j){
            int temp = freq[k];
            freq[k] = freq[j];
            freq[j] = temp;
            k++;
            j--;
        }
        int ans = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(i < 8){
                ans += (freq[i] * 1);
            }
            else if(i >= 8 && i < 16){
                ans += (freq[i] * 2);
            }
            else if(i >= 16 && i < 24){
                ans += (freq[i] * 3);
            }
            else{
                ans += (freq[i] * 4);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String word = "xyzxyzxyzxyz";
        System.out.println(minimumPushes(word));
    }
}
