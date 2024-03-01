import java.util.*;

class Solution {
    public String solution(String m, String[] musicInfos) {
        Integer maxDuration = Integer.MIN_VALUE;
        String theMusic = "(None)";
        String melody = getReplacedNotes(m);
        
        for (String musicInfo : musicInfos) {
            String[] musicInfoArr = musicInfo.split(",");
            int duration = getDuration(musicInfoArr[0], musicInfoArr[1]);
            String notes = getReplacedNotes(musicInfoArr[3]);            
            
            
            StringBuilder playedMusic = new StringBuilder();            
            for (int i = 0; i < duration; i++) {
                playedMusic.append(notes.charAt(i % notes.length()));
            }
            
            if (playedMusic.toString().contains(melody) && duration > maxDuration) {
                theMusic = musicInfoArr[2];
                maxDuration = duration;
            }
        }
        
        return theMusic;
    }
    
    private String getReplacedNotes(String notes) {
        StringBuilder replacedNotes = new StringBuilder();
        for (char note : notes.toCharArray()) {
            if (note == '#') {
                int targetIdx = replacedNotes.length() - 1;
                replacedNotes.setCharAt(targetIdx, Character.toLowerCase(replacedNotes.charAt(targetIdx)));
            }
            else replacedNotes.append(note);
            
        }
        
        return replacedNotes.toString();
    }
    
    private int getDuration(String startTime, String endTime) {
        String[] t1 = startTime.split(":");
        String[] t2 = endTime.split(":");
        
        return (Integer.parseInt(t2[0]) - Integer.parseInt(t1[0])) * 60 + Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]);
    }
}