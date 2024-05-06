import java.util.*;

class Solution {
    private Node root;
    private ArrayList<Integer> preOrdTravList = new ArrayList<>();
    private ArrayList<Integer> postOrdTravList = new ArrayList<>();
        
    public Integer[][] solution(int[][] nodeinfo) {
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        int len = nodeinfo.length;
        for (int i = 0; i < len; i++) {
            idxMap.put(nodeinfo[i][0], i + 1);
        }
        
        Arrays.sort(nodeinfo, new Comparator<int[]>() {
            @Override
            public int compare(int[] node1, int[] node2) {
                return node2[1] - node1[1];
            }
        });
        
        for (int[] info : nodeinfo) {
            addNode(info[0], idxMap.get(info[0]));
        }
                        
        return new Integer[][]{preOrdTrav(root), postOrdTrav(root)};
    }
    
    private class Node {
        int key;
        int data;
        Node left;
        Node right;
        
        Node(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }
    
    private void addNode(int key, int data) {
        Node node = new Node(key, data);
        
        if (root == null) root = node;
        else locateNode(root, node);
    }
    
    private Node locateNode(Node node, Node newNode) {
        if (node == null) return newNode;
        else if (node.key > newNode.key) node.left = locateNode(node.left, newNode);
        else if (node.key < newNode.key) node.right = locateNode(node.right, newNode);
        
        return node;
    }
    
    private Integer[] preOrdTrav(Node node) {
        if (node != null) {
            preOrdTravList.add(node.data);
            preOrdTrav(node.left);
            preOrdTrav(node.right);
        }
        
        return preOrdTravList.toArray(new Integer[0]);
    }
    
    private Integer[] postOrdTrav(Node node) {
        if (node != null) {
            postOrdTrav(node.left);
            postOrdTrav(node.right);
            postOrdTravList.add(node.data);
        }
        
        return postOrdTravList.toArray(new Integer[0]);
    }
}