package B136;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // số bước
        int H = sc.nextInt(); // số hàng
        int W = sc.nextInt(); // số cột

        int sy = sc.nextInt() - 1; // dòng bắt đầu (1-index => 0-index)
        int sx = sc.nextInt() - 1; // cột bắt đầu (1-index => 0-index)

        String s = sc.next(); // chuỗi điều hướng

        int[][] grid = new int[H][W];
        boolean[][] visited = new boolean[H][W]; // theo dõi các ô đã ăn

        // Nhập socola
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int y = sy;
        int x = sx;

        // Không ăn ô ban đầu!
        for (int i = 0; i < N; i++) {
            char move = s.charAt(i);
            int ny = y;
            int nx = x;

            if (move == 'F') ny--;
            else if (move == 'B') ny++;
            else if (move == 'L') nx--;
            else if (move == 'R') nx++;

            if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
                y = ny;
                x = nx;

                if (!visited[y][x]) {
                    System.out.println(grid[y][x]);
                    visited[y][x] = true;
                }
            }
        }
    }
}

