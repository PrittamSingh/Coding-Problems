public class dec04_25 {
    public static int countCollisions(String directions) {
        // Approach-1 Three conditions of collision R->L, R->S, S->L
        // int n = directions.length();
        // Stack<Character> stk = new Stack<>();
        // stk.push(directions.charAt(0));
        // int count = 0;
        // for(int i = 1 ; i < n ; i++){
        //     char ch = directions.charAt(i);
        //     if(stk.peek() == 'R' && ch == 'L'){
        //         count += 2;
        //         stk.pop();
        //         ch = 'S';
        //     }
        //     else if(stk.peek() == 'S' && ch == 'L'){
        //         count += 1;
        //         ch = 'S';
        //     }
        //     while(!stk.isEmpty() && ch == 'S' && stk.peek() == 'R'){
        //         count += 1;
        //         stk.pop();
        //     }
        //     stk.push(ch);
        // }
        // return count;



        // Approach-2 Each moving car is contributing for 1 collision
        int n = directions.length();
        int l = 0;
        int r = n - 1;
        int count = 0;
        while(l < n && directions.charAt(l) == 'L'){
            l++;
        }
        while(r >= 0 && directions.charAt(r) == 'R'){
            r--;
        }
        for(int i = l ; i <= r ; i++){
            if(directions.charAt(i) != 'S'){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String directions = "RLRSLL";
        String directions2 = "LLRR";
        System.out.println(countCollisions(directions) + " " + countCollisions(directions2));
    }
}
