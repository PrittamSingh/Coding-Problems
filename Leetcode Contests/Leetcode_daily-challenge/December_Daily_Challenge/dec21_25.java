public class dec21_25 {
    public static int minDeletionSize(String[] strs) {
        int count = 0;
        int n = strs.length;
        boolean[] fixed = new boolean[n];
        for(int i = 0 ; i < strs[0].length() ; i++){
            boolean flag = false;
            int j = 0;
            while(j < n - 1){
                //Unsorted milega 
                if(!fixed[j] && strs[j].charAt(i) > strs[j + 1].charAt(i)){
                    flag = true;
                    break;
                }
                j++;
            }
            //Unsorted remove kar rhe hain
            if(flag){
                count++;
                continue;
            }
            j = 0;
            while(j < n - 1){
                if(!fixed[j] && strs[j].charAt(i) < strs[j + 1].charAt(i)){
                    fixed[j] = true;
                }
                j++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String[] strs1 = {"ca","bb","ac"};
        String[] strs2 = {"xc","yb","za"};
        String[] strs3 = {"zyx","wvu","tsr"};
        System.out.println(minDeletionSize(strs1) + " " + minDeletionSize(strs2) + " " + minDeletionSize(strs3));
    }
}
