public static List<List<List<Integer>>> allCombinations(int[] arr, int maxK) {
    List<List<List<Integer>>> allLevels = new ArrayList<>();
    for (int k = 1; k <= Math.min(maxK, arr.length); k++) {
        List<List<Integer>> level = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(arr, 0, current, k, level);
        allLevels.add(level);
    }
    return allLevels;
}

private static void backtrack(int[] arr, int start, List<Integer> current, int k, List<List<Integer>> result) {
    if (current.size() == k) {
        result.add(new ArrayList<>(current));
        return;
    }
    for (int i = start; i < arr.length; i++) {
        current.add(arr[i]);
        backtrack(arr, i + 1, current, k, result);
        current.removeLast();
    }
}

void main() {
    int[] arr = {1, 2, 3, 4};
    int maxK = 4;
    List<List<List<Integer>>> allCombs = allCombinations(arr, maxK);

    for (int k = 0; k < allCombs.size(); k++) {
        IO.println("k=" + (k + 1) + ":");
        allCombs.get(k).forEach(System.out::println);
        IO.println();
    }
}
