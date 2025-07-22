package B132;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int c = sc.nextInt();
        int[] times = new int[N];

        for (int i = 0; i < N; i++) {
            times[i] = sc.nextInt();
        }

        int maxDuration = 0;
        int start = times[0];

        for (int i = 1; i < N; i++) {
            if (times[i] > times[i - 1] + c) {
                int end = times[i - 1] + c;
                maxDuration = Math.max(maxDuration, end - start);
                start = times[i];
            }
        }

        int end = times[N - 1] + c;
        maxDuration = Math.max(maxDuration, end - start);

        System.out.println(maxDuration);
    }
}