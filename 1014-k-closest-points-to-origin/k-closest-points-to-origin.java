class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Double, List<int[]>> map = new HashMap<>();

        for (int[] cord : points) {
            int x = cord[0], y = cord[1];
            double euDis = Math.sqrt(x * x + y * y);

            map.computeIfAbsent(euDis, p -> new ArrayList<>()).add(cord);
            maxHeap.offer(euDis);
            
            if (maxHeap.size() > k) {
                double removed = maxHeap.poll();
                List<int[]> list = map.get(removed);
                list.remove(list.size() - 1);
                if (list.isEmpty()) {
                    map.remove(removed);
                }
            }
        }

        List<int[]> ans = new ArrayList<>();
        for (List<int[]> group : map.values()) {
            ans.addAll(group);
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
