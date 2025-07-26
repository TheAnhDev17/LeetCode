package B157;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // số siêu thị
        int K = sc.nextInt(); // số loại rau

        int[][] prices = new int[N][K];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < K; j++)
                prices[i][j] = sc.nextInt();

        // Ghi nhớ: rau j lấy ở siêu thị nào có giá thấp nhất
        int[] minPrice = new int[K];
        List<Set<Integer>> storeOptions = new ArrayList<>();

        for (int j = 0; j < K; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++)
                min = Math.min(min, prices[i][j]);

            minPrice[j] = min;

            Set<Integer> stores = new HashSet<>();
            for (int i = 0; i < N; i++)
                if (prices[i][j] == min)
                    stores.add(i);
            storeOptions.add(stores);
        }

        // Duyệt tất cả tổ hợp chọn cửa hàng rẻ nhất cho từng rau
        // Mỗi rau có thể lấy ở nhiều cửa hàng → tổ hợp

        Set<Set<Integer>> allCombinations = new HashSet<>();
        generate(storeOptions, 0, new HashSet<>(), allCombinations);

        // Tìm tổ hợp có ít siêu thị nhất
        int minShops = N;
        for (Set<Integer> combo : allCombinations)
            minShops = Math.min(minShops, combo.size());

        System.out.println(minShops);
    }

    // DFS tổ hợp cửa hàng
    static void generate(List<Set<Integer>> options, int index, Set<Integer> current, Set<Set<Integer>> result) {
        if (index == options.size()) {
            result.add(new HashSet<>(current));
            return;
        }

        for (int store : options.get(index)) {
            current.add(store);
            generate(options, index + 1, current, result);
            current.remove(store);
        }
    }
}
