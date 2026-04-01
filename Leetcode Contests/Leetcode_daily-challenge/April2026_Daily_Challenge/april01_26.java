import java.util.*;
public class april01_26 {
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] idx = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(positions[a], positions[b]));
        Stack<Integer> stack = new Stack<>();
        for(int i : idx){
            if(directions.charAt(i) == 'R'){
                stack.push(i);
                continue;
            }
            else{
                while(!stack.isEmpty() && healths[i] > 0){
                    int j = stack.peek();
                    if(healths[i] > healths[j]){
                        stack.pop();
                        healths[i]--;
                        healths[j] = 0;
                    }
                    else if(healths[i] < healths[j]){
                        healths[i] = 0;
                        healths[j]--;
                        break;
                    }
                    else{
                        healths[i] = 0;
                        healths[j] = 0;
                        stack.pop();
                        break;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(healths[i] > 0){
                result.add(healths[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] positions = {5,4,3,2,1}, healths = {2,17,9,15,10};
        String directions = "RRRRR";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }
}
