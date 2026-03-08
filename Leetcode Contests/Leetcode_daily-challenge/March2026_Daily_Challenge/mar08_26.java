import java.util.HashSet;

public class mar08_26 {
    public static String findDifferentBinaryString(String[] nums) {
        //T.C : O(n^2) - Iterating on each string and converting each character to integer
        //S.C : O(n) - Using set
        HashSet<Integer> set = new HashSet<>();
        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }
        int n = nums.length;
        String result = "";
        for (int number = 0; number <= n; number++) {
            if (!set.contains(number)) {
                result = Integer.toBinaryString(number);
                while (result.length() < n) {
                    result = "0" + result;
                }
                return result;
            }
        }
        return "";




        //T.C : O(n^2) - Iterating on each string and converting each character to integer
        //S.C : O(n) - Using set
        // HashSet<Integer> set = new HashSet<>();
        // for (String num : nums) {
        //     set.add(Integer.parseInt(num, 2));
        // }
        // int n = nums.length;
        // String result = "";
        // for (int number = 0; number <= 65536; number++) {
        //     if (!set.contains(number)) {
        //         result = Integer.toBinaryString(number);
        //         while (result.length() < n) {
        //             result = "0" + result;
        //         }
        //         return result;
        //     }
        // }
        // return "";
    }
    public static void main(String[] args) {
        String[] nums = {"01","10"};
        String[] nums2 = {"00","01"};
        System.out.println(findDifferentBinaryString(nums) + " " + findDifferentBinaryString(nums2));
    }
}
