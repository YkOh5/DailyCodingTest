import java.util.*;

class Solution {
    public String solution(String m, String[] musicInfos) {
        String melody = getReplaced(m);
        String theMusic = "(None)";
        Integer maxDuration = Integer.MIN_VALUE;
        
        for (String musicInfo : musicInfos) {
            StringTokenizer st = new StringTokenizer(musicInfo, ",");
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            String title = st.nextToken();
            String music = getReplaced(st.nextToken());
            
            int duration = getDuration(startTime, endTime);
            StringBuilder playedMusic = new StringBuilder();
            
            for (int i = 0; i < duration; i++) {
                playedMusic.append(music.charAt(i % music.length()));
            }
            
            if (playedMusic.toString().contains(melody) && duration > maxDuration) {
                theMusic = title;
                maxDuration = duration;
            }
        }
        
        return theMusic;
    }
    
    private String getReplaced(String music) {
        StringBuilder replacedMusic = new StringBuilder();
        for (char note : music.toCharArray()) {
            if (note != '#') replacedMusic.append(note);
            else {
                int targetIdx = replacedMusic.length() - 1;
                replacedMusic.setCharAt(targetIdx, Character.toLowerCase(replacedMusic.charAt(targetIdx)));
            }
        }
        
        return replacedMusic.toString();
    }
    
    private int getDuration(String startTime, String endTime) {
        StringTokenizer t1 = new StringTokenizer(startTime, ":");
        StringTokenizer t2 = new StringTokenizer(endTime, ":");
        
        return (Integer.parseInt(t2.nextToken()) - Integer.parseInt(t1.nextToken())) * 60 + Integer.parseInt(t2.nextToken()) - Integer.parseInt(t1.nextToken());
    }
}