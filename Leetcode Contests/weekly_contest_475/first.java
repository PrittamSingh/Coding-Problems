public class first {
    public static int minimumDistance(int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                for(int k=j+1;k<nums.length;k++)
                {
                    if(nums[i]==nums[j] && nums[j]==nums[k])
                    {
                        sum = (j-i) + (k-j) + (k-i);
                        res = Math.min(res,sum); 
                    }
                }
            }
        }
        if(res == Integer.MAX_VALUE) 
        {
            return -1;
        }
        return res;  
    }
    public static void main(String args[]){
        int[] nums = {1,2,1,1,3};
        System.out.println(minimumDistance(nums));

        int[] nums2 = {1,1,2,3,2,1,2};
        System.out.println(minimumDistance(nums2));
    }
}

