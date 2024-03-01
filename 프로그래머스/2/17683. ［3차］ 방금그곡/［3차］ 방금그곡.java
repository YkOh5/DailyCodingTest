import java.util.*;

class Solution {
    public String solution(String m, String[] musicInfos) {
        String melody = getReplacedNotes(m);
        String theMusic = "(None)";
        Integer maxDuration = Integer.MIN_VALUE;
        
        for (String musicInfo : musicInfos) {
            StringTokenizer st = new StringTokenizer(musicInfo, ",");
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            String title = st.nextToken();
            String notes = getReplacedNotes(st.nextToken());
            
            int duration = getDuration(startTime, endTime);
            StringBuilder playedMusic = new StringBuilder();
            
            for (int i = 0; i < duration; i++) {
                playedMusic.append(notes.charAt(i % notes.length()));
            }
            
            if (playedMusic.toString().contains(melody) && duration > maxDuration) {
                theMusic = title;
                maxDuration = duration;
            }
        }
        
        return theMusic;
    }
    
    private String getReplacedNotes(String notes) {
        StringBuilder replacedNotes = new StringBuilder();
        for (char note : notes.toCharArray()) {
            if (note != '#') replacedNotes.append(note);
            else {
                int targetIdx = replacedNotes.length() - 1;
                replacedNotes.setCharAt(targetIdx, Character.toLowerCase(replacedNotes.charAt(targetIdx)));
            }
        }
        
        return replacedNotes.toString();
    }
    
    private int getDuration(String startTime, String endTime) {
        StringTokenizer t1 = new StringTokenizer(startTime, ":");
        StringTokenizer t2 = new StringTokenizer(endTime, ":");
        
        return (Integer.parseInt(t2.nextToken()) - Integer.parseInt(t1.nextToken())) * 60 + Integer.parseInt(t2.nextToken()) - Integer.parseInt(t1.nextToken());
    }
}