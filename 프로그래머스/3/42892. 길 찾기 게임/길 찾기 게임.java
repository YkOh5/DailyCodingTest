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
            public int compare(int[] info1, int[] info2) {
                return info2[1] - info1[1];
            }
        });
        
        for (int[] info : nodeinfo) {
            addNode(info[0], idxMap.get(info[0]));
        }
                        
        return new Integer[][]{preOrdTrav(root).toArray(new Integer[0]), postOrdTrav(root).toArray(new Integer[0])};
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
        else insertNode(root, node);
    }
    
    private Node insertNode(Node node, Node newNode) {
        if (node == null) return newNode;
        else if (node.key > newNode.key) node.left = insertNode(node.left, newNode);
        else if (node.key < newNode.key) node.right = insertNode(node.right, newNode);
        
        return node;
    }
    
    private ArrayList<Integer> preOrdTrav(Node node) {
        if (node != null) {
            preOrdTravList.add(node.data);
            preOrdTrav(node.left);
            preOrdTrav(node.right);
        }
        
        return preOrdTravList;
    }
    
    private ArrayList<Integer> postOrdTrav(Node node) {
        if (node != null) {
            postOrdTrav(node.left);
            postOrdTrav(node.right);
            postOrdTravList.add(node.data);
        }
        
        return postOrdTravList;
    }
}