public class nov22_25 {
    public static int minimumOperations(int[] nums) {
        // int operation = 0;
        // for(int num : nums){
        //     if(num == 1){
        //         num--;
        //         operation += 1;
        //     }
        //     else if(num % 3 == 1){
        //         num--;
        //         operation += 1;
        //     }
        //      else if(num % 3 == 2){
        //         num++;
        //         operation += 1;
        //      }
        // }
        // return operation;
        

        int operation = 0;
        for(int num : nums){
            if(num % 3 != 0){
                operation++;
            }
        }
        return operation;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4} , nums2 = {3,6,9};
        System.out.println(minimumOperations(nums) + " " + minimumOperations(nums2));
    }
}
