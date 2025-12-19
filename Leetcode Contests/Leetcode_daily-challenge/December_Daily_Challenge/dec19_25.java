import java.util.*;
public class dec19_25 {
    static int[] parent, rank;
    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return;
        if(rank[pa] < rank[pb]){
            parent[pa] = pb;
            rank[pb]++;
        }
        else if(rank[pa] > rank[pb]){
            parent[pb] = pa;
            rank[pa]++;
        }
        else{
            parent[pb] = pa;
            rank[pa]++;
        }
    }
    public static void reset(int x){
        parent[x] = x;
        rank[x] = 0;
    }
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        union(0, firstPerson);
        int i = 0;
        int m = meetings.length;
        while(i < m){
            int time = meetings[i][2];
            List<Integer> list = new ArrayList<>();
            while(i < m && meetings[i][2] == time){
                union(meetings[i][0] , meetings[i][1]);
                list.add(meetings[i][0]);
                list.add(meetings[i][1]);
                i++;
            }
            for(int p : list){
                if(find(0) != find(p)){
                    reset(p);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int p = 0 ; p < n ; p++){
            if(find(0) == find(p)){
                ans.add(p);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 6; int[][] meetings = {{1,2,5},{2,3,8},{1,5,10}}; int firstPerson = 1;
        System.out.println(findAllPeople(n, meetings, firstPerson));
        int n2 = 4; int[][] meetings2 = {{3,1,3},{1,2,2},{0,3,3}}; int firstPerson2 = 3;
        System.out.println(findAllPeople(n2, meetings2, firstPerson2));
    }
}
