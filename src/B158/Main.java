package B158;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] room = new int[N][N];

        // Nhập ma trận hiện tại
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                room[i][j] = sc.nextInt();
            }
        }

        int totalRemoved = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Xác định "lớp" của ô (i, j): lớp ngoài cùng là 1
                int layer = Math.min(Math.min(i, j), Math.min(N - 1 - i, N - 1 - j));
                int expected = layer + 1;
                totalRemoved += room[i][j] - expected;
            }
        }

        System.out.println(totalRemoved);
    }
}

