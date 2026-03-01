public class mar01_26 {
    public static int minPartitions(String n) {
        // Approach - 1 Trick
        // int maxChar = 0;
        // for(char ch : n.toCharArray()){
        //     maxChar = Math.max(maxChar, ch - '0');
        // }
        // return maxChar;


        // Approach - 2 Brute-Force Approach
        char[] arr = n.toCharArray();
        int count = 0;
        while(true){
            boolean changed = false;
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] != '0'){
                    arr[i]--;
                    changed = true;
                }
            }
            if(!changed){
                break;
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String n = "32";
        String n2 = "82734";
        System.out.println(minPartitions(n) + " " + minPartitions(n2));
    }
}
