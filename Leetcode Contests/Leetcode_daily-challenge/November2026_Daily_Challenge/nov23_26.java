import java.util.ArrayList;
import java.util.List;

public class nov23_26 {
    // private List<Integer> nums;
    // private int n;
    // public ProductOfNumbers() {
    //     nums = new ArrayList<>();
    //     n = 0;
    // }
    // public void add(int num) {
    //     nums.add(num);
    // }
    // public int getProduct(int k) {
    //     int prod = 1;
    //     int n = nums.size();
    //     for(int i = n - k ; i < n ; i++){
    //         prod *= nums.get(i);
    //     }
    //     return prod;
    // }


    private List<Integer> nums;
    private int n;
    public nov23_26() {
        nums = new ArrayList<>();
        n = 0;
    }
    public void add(int num) {
        if(num == 0){
            nums.clear();
            n = 0;
        }
        else{
            if(nums.isEmpty()){
                nums.add(num);
            }
            else{
                nums.add(nums.get(n-1) * num);
            }
            n++;
        }
    }
    public int getProduct(int k) {
        if(k > n){
            return 0;
        }
        else if(k == n){
            return nums.get(n-1);
        }
        return nums.get(n-1) / nums.get(n-k-1);
    }
    public static void main(String[] args) {
        nov23_26 obj = new nov23_26();
        obj.add(3);
        obj.add(0);
        obj.add(2);
        obj.add(5);
        obj.add(4);

        System.out.println(obj.getProduct(2)); // 20
        System.out.println(obj.getProduct(3)); // 40
        System.out.println(obj.getProduct(4)); // 0

        obj.add(8);

        System.out.println(obj.getProduct(2)); // 32
    }
}
