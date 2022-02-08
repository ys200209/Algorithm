import java.util.*;

public class Main2_6 {
    static Queue<File> pq;
    
    public static void main(String[] args) {

        System.out.println(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
        // ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]

        // System.out.println(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}));
        // "A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"

    }

    public static String[] solution(String[] files) {
        String[] answer;
        pq = new PriorityQueue<>();

        for(int i=0; i<files.length; i++) {
            String head = "";
            String number = "";
            String tail = "";

            for(int j=0; j<files[i].length(); j++) {
                if (files[i].charAt(j) - '0' >= 0 && files[i].charAt(j) - '0' <= 9) {
                    number += files[i].substring(j, j+1);
                } else {
                    if (number.equals("")) { // ���� number�� ä������ ����. ��, head �κ�
                        head += files[i].substring(j, j+1);
                    } else {
                        tail += files[i].substring(j, files[i].length()); // tail�κк��� ���������� ��� break
                        break;
                    }
                }
            }
            pq.offer(new File(head, number, tail, i+1));

        }

        answer = new String[pq.size()];
        int j=0;
        while(!pq.isEmpty()) {
            File f = pq.poll();
            System.out.println(f.getHead() + ", " + f.getNumber() + ", " + f.getTail() + ", " + f.getRank());
            answer[j] = f.getHead() + f.getNumber() + f.getTail();
            j++;
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

}

class File implements Comparable<File> {

    private String head;
    private String number;
    private String tail;
    private int rank;

    public File(String head, String number, String tail, int rank) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.rank = rank;
    }

    public String getHead() {
        return head;
    }

    public String getNumber() {
        return number;
    }

    public String getTail() {
        return tail;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public int compareTo(File f1) {
        if (this.getHead().toUpperCase().equals(f1.getHead().toUpperCase())) { // ����� ��ҹ��ڰ� ���ٸ�
            if (Integer.parseInt(this.getNumber()) == Integer.parseInt(f1.getNumber())) { // ���ڱ����� ���ٸ�
                return this.getRank() - f1.getRank(); // RANK�� ������ �������.
            } else { // ���ڰ� �ٸ��ٸ�
                return Integer.parseInt(this.getNumber()) - Integer.parseInt(f1.getNumber());
            }
        } else { // ����� ��ҹ��ڰ� �ٸ��ٸ�
            return this.getHead().toUpperCase().compareTo(f1.getHead().toUpperCase());
        }
        
    }

}