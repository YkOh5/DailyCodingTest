import java.util.*;

class Solution {
    private class Node {
        int data;
        Node prev;
        Node next;
        
        public Node(int data) {
            this.data = data;
        }
    }
    
    public String solution(int n, int k, String[] cmds) {
        Node[] nodeArr = new Node[n];
        for (int i = 0; i < n; i++) {
            nodeArr[i] = new Node(i);
            if (i > 0) {
                nodeArr[i - 1].next = nodeArr[i];
                nodeArr[i].prev = nodeArr[i - 1];
            }
        }
        
        Node head = nodeArr[0];
        Node tail = nodeArr[n - 1];
        Node cursor = nodeArr[k];
        
        Stack<Node> stack = new Stack<>();
        for (String cmd: cmds) {
            StringTokenizer st = new StringTokenizer(cmd);
            String cmdType = st.nextToken();
            int d = 0;
            if (st.hasMoreTokens()) d = Integer.parseInt(st.nextToken());
            
            switch (cmdType) {
                    case "U" -> { for (int i = 0; i < d; i++) cursor = cursor.prev; }
                    case "D" -> { for (int i = 0; i < d; i++) cursor = cursor.next; }
                    case "C" -> { 
                        stack.push(cursor);
                        if (cursor == head) {
                            cursor = cursor.next;
                            cursor.prev = null;
                            head = cursor;
                        } else if (cursor == tail) {
                            cursor = cursor.prev;
                            cursor.next = null;
                            tail = cursor;
                        } else {
                            cursor.prev.next = cursor.next;
                            cursor.next.prev = cursor.prev;
                            cursor = cursor.next;
                        }
                    }
                    case "Z" -> {
                        Node node = stack.pop();
                        if (node.prev == null) head = node;
                        else node.prev.next = node;
                        if (node.next == null) tail = node;
                        else node.next.prev = node;
                    }
            }            
        }
                
        StringBuilder sb = new StringBuilder("X".repeat(n));
        cursor = head;
        while (cursor != null) {
            sb.setCharAt(cursor.data, 'O');
            cursor = cursor.next;
        }
        
        return sb.toString();
    }
}