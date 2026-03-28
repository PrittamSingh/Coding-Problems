public class mar28_26 {
    public static String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        for (int i = 0; i < n; i++) {
            word[i] = '$';
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (lcp[j][i] != 0) {
                    word[i] = word[j];
                    break;
                }
            }
            if (word[i] == '$') {
                boolean[] forbidden = new boolean[26];
                for (int j = 0; j < i; j++) {
                    if (lcp[j][i] == 0) {
                        forbidden[word[j] - 'a'] = true;
                    }
                }
                for (int c = 0; c < 26; c++) {
                    if (!forbidden[c]) {
                        word[i] = (char) ('a' + c);
                        break;
                    }
                }
                if (word[i] == '$') {
                    return "";
                }
            }
        }

        String result = new String(word);
        int[][] computed = checkLCP(result);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computed[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return result;
    }
    private static int[][] checkLCP(String word) {
        int n = word.length();
        int[][] lcp = new int[n][n];
        for (int i = 0; i < n; i++) {
            lcp[i][n - 1] = (word.charAt(i) == word.charAt(n - 1)) ? 1 : 0;
        }
        for (int j = 0; j < n; j++) {
            lcp[n - 1][j] = (word.charAt(n - 1) == word.charAt(j)) ? 1 : 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (word.charAt(i) == word.charAt(j)) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                } else {
                    lcp[i][j] = 0;
                }
            }
        }
        return lcp;
    }
    public static void main(String[] args) {
        int[][] lcp = {{4,0,2,0},{0,3,0,1},{2,0,2,0},{0,1,0,1}};
        System.out.println(findTheString(lcp));
    }
}
