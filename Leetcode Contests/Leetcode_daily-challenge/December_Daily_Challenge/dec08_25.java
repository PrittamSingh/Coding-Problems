public class dec08_25 {
    public static int countTriples(int n) {
        // int count = 0;
        // for(int i = 1 ; i <= n ; i++){
        //     for(int j = 1 ; j <= n ; j++){
        //         int lhs = (i * i) + (j * j);
        //         double root = Math.sqrt(lhs);
        //         if(root == (int)root && root <= n){
        //             count++;
        //         }
        //     }
        // }
        // return count;

        // int count = 0;
        // for(int i = 1 ; i < n ; i++){
        //     for(int j = i + 1 ; j <= n ; j++){
        //         int lhs = (i * i) + (j * j);
        //         double root = Math.sqrt(lhs);
        //         if(root == (int)root && root <= n){
        //             count += 2;
        //         }
        //     }
        // }
        // return count;

        // int count = 0;
        // for(int c = 1 ; c <= n ; c++){
        //     int target = c * c;
        //     int left = 1;
        //     int right = c - 1;
        //     while(left <= right){
        //         int sum = (left * left) + (right * right);
        //         if(sum == target){
        //             count += 2;
        //             left++;
        //             right--;
        //         }
        //         else if(sum < target){
        //             left++;
        //         }
        //         else{
        //             right--;
        //         }
        //     }
        // }
        // return count;



        int[] sq = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sq[i] = i * i;
        }

        int count = 0;
        for(int c = 1 ; c <= n ; c++){
            int target = sq[c];
            int left = 1;
            int right = c - 1;
            while(left <= right){
                int sum = sq[left] + sq[right];
                if(sum == target){
                    count += 2;
                    left++;
                    right--;
                }
                else if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 10;
        System.out.println(countTriples(n1) + " " + countTriples(n2));
    }
}
