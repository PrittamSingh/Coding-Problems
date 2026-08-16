public class aug16_26 {
    public static boolean stoneGameIX(int[] stones) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i : stones){
            int x = i % 3;
            if(x == 0){
                count0++;
            }
            else if(x == 1){
                count1++;
            }
            else{
                count2++;
            }
        }
        if(count0 % 2 == 0){
            return count1 >= 1 && count2 >= 1;
        }
        return count1 - count2 > 2 || count2 - count1 > 2;
    }
    public static void main(String[] args) {
        int[] stones = {2,1};
        int[] stones1 = {5,1,2,4,3};
        System.out.println(stoneGameIX(stones) + " " + stoneGameIX(stones1));
    }
}
