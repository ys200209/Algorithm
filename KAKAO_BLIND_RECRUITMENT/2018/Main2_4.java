import java.util.*;

public class Main2_4 {
    static int time=0;
    static Music[] musicList;
    static ArrayList<Music> answerList = new ArrayList<>();
    
    public static void main(String[] args) {

        // System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        // HELLO

        // System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        // WORLD

        System.out.println(solution("ABC", new String[]{"00:00,00:01,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        // WORLD
    }

    public static String solution(String m, String[] musicinfos) {
        Music answer = new Music(0, "", "");

        musicList = new Music[musicinfos.length];

        for(int i=0; i<musicinfos.length; i++) {
            String start = musicinfos[i].split(",")[0];
            String finish = musicinfos[i].split(",")[1];
            String musicName = musicinfos[i].split(",")[2];
            String melody = musicinfos[i].split(",")[3];

            int HH1;
            int HH2;

            if (Integer.parseInt(start.split(":")[0]) > Integer.parseInt(finish.split(":")[0])) { // 종료가 00시
                HH1 = Integer.parseInt(start.split(":")[0]);
                HH2 = 24;
            } else {
                HH1 = Integer.parseInt(start.split(":")[0]);
                HH2 = Integer.parseInt(finish.split(":")[0]);
            }

            int time1 = HH1*60 + Integer.parseInt(start.split(":")[1]);
            int time2 = HH2*60 + Integer.parseInt(finish.split(":")[1]);

            int playTime = time2 - time1; // 뮤직 플레이 타임 전처리

            ArrayList<String> mel = new ArrayList<>();
            for(String s : melody.split("")) {
                if (s.equals("#")) {
                    mel.add(mel.remove(mel.size()-1) + s);
                } else {
                    mel.add(s);
                }
            }

            int index=0;
            int time=1;
            melody = "";
            while(time <= playTime) {
                if (index == mel.size()) index=0;
                melody += mel.get(index);
                index++;
                time++;
            }

            melody = melody.replace(m+"#", "X");
            if (melody.contains(m)) {
                if (answer.getPlayTime() < playTime) answer = new Music(playTime, musicName, melody);
                    
                /*
                for(int j=m.length(); j<melody.length(); j++) {
                    if (m.equals(melody.substring(j-m.length(), j)) && melody.charAt(j) - 'A' >= 0 && melody.charAt(j) - 'A' <= 25) {
                        answer = new Music(playTime, musicName, melody);
                        break;
                    }
                }*/
            }
        }

        return answer.getPlayTime() == 0 ? "(None)" : answer.getMusicName();
    }

}

class Music {

    private int playTime;
    private String musicName;
    private String melody;

    public Music(int playTime, String musicName, String melody) {
        this.playTime = playTime;
        this.musicName = musicName;
        this.melody = melody;
    }

    public int getPlayTime() {
        return playTime;
    }

    public String getMusicName() {
        return musicName;
    }

    public String getMelody() {
        return melody;
    }

}