import java.util.ArrayList;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> unfinishedTaskList = new ArrayList<>();
        for (int i = 0; i < finished.length; i++) {
            if (finished[i] == false) unfinishedTaskList.add(todo_list[i]);
        }        
        
        return unfinishedTaskList.toArray(new String[0]);
    }
}