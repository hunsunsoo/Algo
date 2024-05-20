import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = new String(br.readLine());
        String[] list = new String[s.length()];

        for (int i=0; i<s.length(); i++) {
            list[i] = s.substring(i);
        }

        Arrays.sort(list);

        for (int i=0; i<s.length(); i++) {
            System.out.println(list[i]);
        }
    }
}
