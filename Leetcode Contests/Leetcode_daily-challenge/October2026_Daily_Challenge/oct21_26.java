import java.util.Arrays;

public class oct21_26 {
    public static int minOperations(String s) {
        int n = s.length();
        if(n == 1) return 0;
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        if(s.equals(sorted)) return 0;
        if(n == 2) return -1;
        if(s.charAt(0) == sorted.charAt(0) || s.charAt(n - 1) == sorted.charAt(n - 1)){
            return 1;
        }
        int a = s.indexOf(arr[0]);
        int b = s.lastIndexOf(arr[n - 1]);
        if(b == 0 && a == n - 1){
            return 3;
        }
        return 2;
        



        // int n = s.length();
        // if(n == 1) return 0;
        // char[] arr = s.toCharArray();
        // Arrays.sort(arr);
        // String sorted = new String(arr);
        // if(s.equals(sorted)) return 0;
        // if(n == 2) return -1;
        // if(s.charAt(0) == sorted.charAt(0) || s.charAt(n - 1) == sorted.charAt(n - 1)){
        //     return 1;
        // }
        // else{
        //     // int a = -1, b = -1;
        //     // for(int i = 0; i < n ; i++){
        //     //     if(a == -1 && s.charAt(i) == sorted.charAt(0)){
        //     //         a = i;
        //     //     }
        //     //     if(s.charAt(i) == sorted.charAt(n - 1)){
        //     //         b = i;
        //     //     }
        //     // }
        //     int a = s.indexOf(arr[0]);
        //     int b = s.lastIndexOf(arr[n - 1]);
        //     if(b == 0 && a == n - 1){
        //         return 3;
        //     }
        //     else{
        //         return 2;
        //     }
        // }
    }
    public static void main(String[] args) {
        String s = "dog";
        System.out.println(minOperations(s));
    }
}
