class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int i = queue.poll();
                if (i == n - 1) {
                    return steps;
                }
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    queue.add(i + 1);
                }
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    queue.add(i - 1);
                }
                if (map.containsKey(arr[i])) {
                    for (int j : map.get(arr[i])) {
                        if (!visited[j]) {
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                    map.get(arr[i]).clear();
                }
            }
            steps++;
        }
        return -1;
    }
}