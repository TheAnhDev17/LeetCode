import java.util.*;

public class Main {

    static class Point {
        int x, y, p;
        double distance;

        Point(int x, int y, int p, int targetX, int targetY) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.distance = Math.sqrt(Math.pow(x - targetX, 2) + Math.pow(y - targetY, 2));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int targetX = sc.nextInt();
        int targetY = sc.nextInt();

        int k = sc.nextInt();

        int n = sc.nextInt();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int p = sc.nextInt();

            points.add(new Point(x, y, p, targetX, targetY));
        }

        Collections.sort(points, Comparator.comparingDouble((Point pt) -> pt.distance).thenComparing(pt -> pt.p));

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += points.get(i).p;
        }

        int result = (int) Math.round(sum / (double)k);

        System.out.println(result);
    }
}