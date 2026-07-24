public class july24_26 {
    public static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int maxEle = nums[0];
        for(int i = 1 ; i < n ; i++){
            maxEle = Math.max(maxEle, nums[i]);
        }
        int size = 1;
        while(size <= maxEle){
            size *= 2;
        }
        boolean[] pairXor = new boolean[size];
        for(int j = 0 ; j < n ; j++){
            for(int k = j ; k < n ; k++){
                int xor = nums[j] ^ nums[k];
                pairXor[xor] = true;
            }
        }
        boolean[] tripletXor = new boolean[size];
        for(int i = 0 ; i < size ; i++){
            if(pairXor[i]){
                for(int num : nums){
                    tripletXor[num ^ i] = true;
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i < size ; i++){
            if(tripletXor[i]){
                count++;
            }
        }
        return count;





        // BRUTE FORCE APPROACH
        // int n = nums.length;
        // Set<Integer> set = new HashSet<>();
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i ; j < n ; j++){
        //         for(int k = j ; k < n ; k++){
        //             int xor = nums[i] ^ nums[j] ^ nums[k];
        //             set.add(xor);
        //         }
        //     }
        // }
        // return set.size();
    }
    public static void main(String[] args) {
        int[] nums = {6,7,8,9};
        System.out.println(uniqueXorTriplets(nums));
    }
}
