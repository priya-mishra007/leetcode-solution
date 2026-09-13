class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        int jumps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                if (i == n - 1) return jumps;
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.add(i + 1);
                }
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.add(i - 1);
                }
                if (map.containsKey(arr[i])) {
                    for (int j : map.get(arr[i])) {
                        if (!visited[j]) {
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                    map.remove(arr[i]);
                }
            }
            jumps++;
        }
        return -1;
    }
}