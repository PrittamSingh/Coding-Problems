import java.util.ArrayList;
import java.util.List;

class Fancy {
    int MOD = 1000000007;
    List<Long> seq = new ArrayList<>();
    long add = 0;
    long mult = 1;

    long power(long a, long b) {
        if (b == 0) return 1;

        long half = power(a, b / 2);
        long result = (half * half) % MOD;

        if (b % 2 == 1) {
            result = (result * a) % MOD;
        }

        return result;
    }

    public Fancy() {

    }

    public void append(int val) {
        long x = ((val - add) % MOD + MOD) * power(mult, MOD - 2) % MOD;
        seq.add(x);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        add = (add * m) % MOD;
        mult = (mult * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= seq.size()) return -1;

        return (int)((seq.get(idx) * mult + add) % MOD);
    }
}
public class mar15_26 {
    public static void main(String[] args) {
        Fancy obj = new Fancy();
        List<Object> result = new ArrayList<>();

        result.add(null);

        obj.append(2);
        result.add(null);

        obj.addAll(3);
        result.add(null);

        obj.append(7);
        result.add(null);

        obj.multAll(2);
        result.add(null);

        result.add(obj.getIndex(0));

        obj.addAll(3);
        result.add(null);

        obj.append(10);
        result.add(null);

        obj.multAll(2);
        result.add(null);

        result.add(obj.getIndex(0));
        result.add(obj.getIndex(1));
        result.add(obj.getIndex(2));

        System.out.println(result);
    }
}
