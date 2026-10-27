import java.util.Arrays;

public class oct27_26 {
    public static String[] createGrid(int m, int n) {
        // String[] res = new String[m];
        // for(int i = 0 ; i < m ; i++){
        //     StringBuilder sb = new StringBuilder();
        //     for(int j = 0 ; j < n ; j++){
        //         if(i == 0){
        //             sb.append('.');
        //         }
        //         else if(j == n - 1){
        //             sb.append('.');
        //         }
        //         else{
        //             sb.append('#');
        //         }
        //     }
        //     res[i] = sb.toString();
        // }
        // return res;




        String[] res = new String[m];
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            sb.append('.');
        }
        res[0] = sb.toString();
        sb = new StringBuilder();
        for(int i = 0 ; i < n - 1 ; i++){
            sb.append('#');
        }
        sb.append('.');
        for(int i = 1 ; i < m ; i++){
            res[i] = sb.toString();
        }
        return res;
    }
    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println(Arrays.asList(createGrid(m, n)));
    }
}
