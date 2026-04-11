import java.util.*;
public class C {
    static int maxPasses = 0;
    static int N;
    static long[] L;
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    L = new long[N];
	    for(int i = 0 ; i < N ; i++){
	        L[i] = sc.nextLong();
	    }
	    dfs(0, 0.5, 0);
        System.out.println(maxPasses);
        sc.close();
	}
	static void dfs(int index, double curr, int count){
        if(index == N){
            maxPasses = Math.max(maxPasses, count);
            return;
        }
        double nextPos = curr + L[index];
        int newCount = count;
        if((curr > 0 && nextPos < 0) || (curr < 0 && nextPos > 0)){
            newCount++;
        }
        dfs(index + 1, nextPos, newCount);
        nextPos = curr - L[index];
        newCount = count;
        if((curr > 0 && nextPos < 0) || (curr < 0 && nextPos > 0)){
            newCount++;
        }
        dfs(index + 1, nextPos, newCount);
    }
}
