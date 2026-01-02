public class nov18_25 {
    public static boolean isOneBitCharacter(int[] bits) {
        // int i = 0;
        // while(i < bits.length - 1){
        //     if(bits[i] == 1){
        //         i += 2;
        //     }
        //     else{
        //         i += 1;
        //     }
        // }
        // return i == bits.length - 1;

        int count = 0;
        int n = bits.length;
        for(int i = n - 2 ; i >= 0 ; i--){
            if(bits[i] == 1){
                count++;
            }
            else{
                break;
            }
        }
        return count % 2 == 0;
    }
    public static void main(String[] args) {
        int[] bits = {1,0,0}, bits2 = {1,1,1,0};
        System.out.println(isOneBitCharacter(bits) + " " + isOneBitCharacter(bits2));
    }
}
