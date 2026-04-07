import java.util.*;

class Robot {
    int idx = 0;
    boolean moved = false;
    List<int[]> pos = new ArrayList<>();

    public Robot(int width, int height) {
        for (int x = 0; x < width; x++) {
            pos.add(new int[]{x, 0, 0});
        }
        for (int y = 1; y < height; y++) {
            pos.add(new int[]{width - 1, y, 1});
        }
        for (int x = width - 2; x >= 0; x--) {
            pos.add(new int[]{x, height - 1, 2});
        }
        for (int y = height - 2; y > 0; y--) {
            pos.add(new int[]{0, y, 3});
        }
        pos.get(0)[2] = 3;
    }

    public void step(int num) {
        moved = true;
        idx = (idx + num) % pos.size();
    }

    public int[] getPos() {
        return new int[]{pos.get(idx)[0], pos.get(idx)[1]};
    }

    public String getDir() {
        if (!moved) return "East";

        int d = pos.get(idx)[2];
        if (d == 0) return "East";
        else if (d == 1) return "North";
        else if (d == 2) return "West";
        return "South";
    }
}
public class april07_26 {
    public static void main(String[] args) {
        Robot obj = new Robot(6, 3);

        obj.step(2);
        obj.step(2);

        int[] pos1 = obj.getPos();
        System.out.println("[" + pos1[0] + ", " + pos1[1] + "]");
        System.out.println("[" + obj.getDir() + "]");

        obj.step(2);
        obj.step(1);
        obj.step(4);

        int[] pos2 = obj.getPos();
        System.out.println("[" + pos2[0] + ", " + pos2[1] + "]");
        System.out.println("[" + obj.getDir() + "]");
    }
}
