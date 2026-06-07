class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            children.add(child);
        }

        for (int[] desc : descriptions) {
            int parent = desc[0];
            if (!children.contains(parent)) {
                return map.get(parent);
            }
        }

        return null;
    }
}