import java.util.*;
public class feb27_26 {
    public static int minOperations(String s, int k) {

        int n = s.length();

        int startZeros = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '0')
                startZeros++;
        }

        if(startZeros == 0)
            return 0;

        int[] operations = new int[n+1];
        Arrays.fill(operations, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startZeros);

        operations[startZeros] = 0;

        while(!queue.isEmpty()) {

            int z = queue.poll();

            int minF = Math.max(0, k - n + z);
            int maxF = Math.min(k, z);

            for(int f = minF; f <= maxF; f++) {

                int newZ = z + k - 2*f;

                if(operations[newZ] == -1) {

                    operations[newZ] = operations[z] + 1;

                    if(newZ == 0)
                        return operations[newZ];

                    queue.offer(newZ);
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        String s = "1010";
        int k = 3;
        System.out.println(minOperations(s, 3));
    }
}
