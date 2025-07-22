package B167;

import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // UP, DOWN, LEFT, RIGHT
    static Map<Integer, Set<Integer>> pipeDirs = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        grid = new int[n][n];

        // Read input
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        // ROTATED pipe definitions based on error pattern: 4→3, 5→4, 3→5
        pipeDirs.put(1, Set.of(2, 3)); // Horizontal: LEFT-RIGHT
        pipeDirs.put(2, Set.of(0, 1)); // Vertical: UP-DOWN
        pipeDirs.put(3, Set.of(0, 3)); // UP-RIGHT (rotated from old pipe 5)
        pipeDirs.put(4, Set.of(1, 3)); // DOWN-RIGHT (rotated from old pipe 3)
        pipeDirs.put(5, Set.of(1, 2)); // DOWN-LEFT (rotated from old pipe 4)
        pipeDirs.put(6, Set.of(0, 2)); // UP-LEFT

        int[] priority = {4, 1, 6, 2, 3, 5};

        // Simple approach: keep trying until no more changes
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 7) {
                        for (int pipe : priority) {
                            if (isValidReplacement(i, j, pipe)) {
                                grid[i][j] = pipe;
                                changed = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Print output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    static boolean isValidReplacement(int x, int y, int pipeType) {
        Set<Integer> currentDirs = pipeDirs.get(pipeType);

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];

            if (!inBounds(nx, ny)) continue;

            int neighbor = grid[nx][ny];
            if (neighbor == 0 || neighbor == 7) continue;

            Set<Integer> neighborDirs = pipeDirs.get(neighbor);
            if (neighborDirs == null) continue;

            // If neighbor connects to us, we must connect back
            if (neighborDirs.contains(opposite(dir)) && !currentDirs.contains(dir)) {
                return false;
            }

            // If we connect to neighbor, neighbor must connect back
            if (currentDirs.contains(dir) && !neighborDirs.contains(opposite(dir))) {
                return false;
            }
        }

        return true;
    }

    static int opposite(int dir) {
        return switch (dir) {
            case 0 -> 1; case 1 -> 0; case 2 -> 3; case 3 -> 2;
            default -> -1;
        };
    }

    static boolean inBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}