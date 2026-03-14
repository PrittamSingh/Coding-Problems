public class mar14_26 {
    // public boolean isHappy(String curr){
    //     if(curr.length() == 1) return true;
    //     for(int i = 0 ; i < curr.length() ; i++){
    //         if(curr.charAt(i) != curr.charAt(i = 1)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public void generate(int n, String curr, List<String> list){
    //     if(curr.length() == n){
    //         if(isHappy(curr)){
    //             list.add(curr);
    //         }
    //         return;
    //     }
    //     char[] arr = {'a', 'b', 'c'};
    //     for(char ch : arr){
    //         generate(n, curr + ch, list);
    //     }
    // }
    // public String getHappyString(int n, int k) {
    //     List<String> list = new ArrayList<>();
    //     generate(n, "", list);
    //     Collections.sort(list);
    //     if(k > list.size()) return "";
    //     return list.get(k - 1);
    // }



    // public void backtrack(int n, String curr, List<String> list){
    //     if(curr.length() == n){
    //         list.add(curr);
    //         return;
    //     }
    //     char[] arr = {'a', 'b', 'c'};
    //     for(char ch : arr){
    //         if(curr.length() > 0 && curr.charAt(curr.length() - 1) == ch){
    //             continue;
    //         }
    //         backtrack(n, curr + ch, list);
    //     }
    // }
    // public String getHappyString(int n, int k){
    //     List<String> list = new ArrayList<>();
    //     backtrack(n, "", list);
    //     if(k > list.size()) return "";
    //     return list.get(k - 1);
    // }



    static int count = 0;
    static String ans = "";
    public static void dfs(int n, int k, String curr){
        if(curr.length() == n){
            count++;
            if(count == k){
                ans = curr;
            }
            return;
        }
        char[] arr = {'a', 'b', 'c'};
        for(char ch : arr){
            if(curr.length() > 0 && curr.charAt(curr.length() - 1) == ch){
                continue;
            }
            dfs(n, k, curr + ch);
        }
    }
    public static String getHappyString(int n, int k){
        dfs(n, k, "");
        return ans;
    }
    public static void main(String[] args) {
        int n = 1, k = 3;
        int n2 = 3, k2 = 9;
        System.out.println(getHappyString(n, k) + " " + getHappyString(n2, k2));
    }
}
