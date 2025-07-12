/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> visited = new HashMap<>();

        // Clone the first node and add to queue
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            
            // Process all neighbors
            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                // Add the cloned neighbor to current node's neighbors
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        return cloneNode;
    }
}