// 데이터의 크기가 크고, 요소의 삽입/삭제가 매우 빈번할 경우에는 연결리스트를 사용하는 것이 적합
// 이 때 시간복잡도는 O(1)이며 전체 시간복잡도는 O(1 * N) = O(200000)
// 커서를 전후로 이동할 필요가 있으므로 이중 연결리스트 사용
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


// 남겨진 원소들의 인덱스에 "O"를 집어넣는 방식이 아니라
// 삭제된 원소의 인덱스에 "X"를 집어넣는 방식으로 구현하면
// 링크드리스트조차 구현할 필요없이 스택만으로 해결이 가능

// import java.util.*;

// class Solution {    
//     public String solution(int n, int k, String[] cmds) {
//         Stack<Integer> stack = new Stack<>();
//         for (String cmd: cmds) {
//             StringTokenizer st = new StringTokenizer(cmd);
//             String cmdType = st.nextToken();
//             int d = 0;
//             if (st.hasMoreTokens()) d = Integer.parseInt(st.nextToken());
            
//             switch (cmdType) {
//                     case "U" -> k -= d;
//                     case "D" -> k += d;
//                     case "C" -> { 
//                         stack.push(k);
//                         n--;
//                         if (k >= n) k--;
//                     }
//                     case "Z" -> {
//                         if (stack.pop() <= k) k++;
//                         n++;                        
//                     }
//             }            
//         }
                
//         StringBuilder sb = new StringBuilder("O".repeat(n));
//         while (!stack.isEmpty()) {
//             sb.insert(stack.pop(), "X");
//         }
        
//         return sb.toString();
//     }
// }



// 아래와 같은 방식으로 인덱스를 통해서 내장된 연결리스트를 조작하면 
// 매번 head부터 인덱스까지 차례대로 이동하여 추가/삭제하여
// 시간복잡도는 O(M * N) = O(1,000,000 * 200,000) 이 되어 
// 조 단위의 계산을 수행하므로 매우 비효율적

// import java.util.*;

// class Solution {
//     public String solution(int n, int k, String[] cmds) {
//         LinkedList<Integer> numList = new LinkedList<>();
//         for (int i = 0; i < n; i++) numList.add(i);
        
//         int cursor = k;
//         Stack<int[]> stack = new Stack<>();
//         for (String cmd : cmds) {
//             StringTokenizer st = new StringTokenizer(cmd);
//             String cmdType = st.nextToken();
//             int d = 0;
//             if (st.hasMoreTokens()) d = Integer.parseInt(st.nextToken());
                        
//             switch (cmdType) {
//                 case "U" -> cursor -= d;
//                 case "D" -> cursor += d;
//                 case "C" -> {
//                     stack.push(new int[]{cursor, numList.remove(cursor)});
//                     if (cursor > numList.size() - 1) cursor = numList.size() - 1;
//                 }
//                 case "Z" -> {
//                     int[] temp = stack.pop();
//                     numList.add(temp[0], temp[1]);
//                     if (temp[0] <= cursor) cursor++;
//                 }
//             }
//         }
        
//         boolean[] check = new boolean[n];
//         for (int num : numList) check[num] = true;
        
//         StringBuilder sb = new StringBuilder();
//         for (boolean b : check) {
//             if (b) sb.append("O");
//             else sb.append("X");
//         }
        
//         return sb.toString();
//     }
// }