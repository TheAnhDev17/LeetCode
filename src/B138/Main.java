package B138;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập chiều cao và chiều rộng
        int H = sc.nextInt();
        int W = sc.nextInt();
        sc.nextLine(); // Bỏ qua ký tự newline sau khi nhập số

        // Khởi tạo mảng 2 chiều để lưu bản đồ
        char[][] grid = new char[H][W];

        // Đọc từng dòng và gán vào mảng 2 chiều
        for (int i = 0; i < H; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < W; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int donutCount = 0;

        // Duyệt tất cả các khối 3x3 có thể trong mảng
        for (int i = 0; i <= H - 3; i++) {
            for (int j = 0; j <= W - 3; j++) {
                if (isDonut(grid, i, j)) {
                    donutCount++;
                }
            }
        }

        // In kết quả
        System.out.println(donutCount);
    }

    // Kiểm tra khối 3x3 bắt đầu tại (x, y) có phải là donut không
    private static boolean isDonut(char[][] g, int x, int y) {
        return g[x][y]     == '#' && g[x][y+1] == '#' && g[x][y+2] == '#' &&
                g[x+1][y]   == '#' && g[x+1][y+1] == '.' && g[x+1][y+2] == '#' &&
                g[x+2][y]   == '#' && g[x+2][y+1] == '#' && g[x+2][y+2] == '#';
    }
}