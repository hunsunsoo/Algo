import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i=1; i<s.length()-1; i++) {
            for (int j=i+1; j<s.length(); j++) {
                StringBuilder a = new StringBuilder(s.substring(0, i));
                StringBuilder b = new StringBuilder(s.substring(i, j));
                StringBuilder c = new StringBuilder(s.substring(j));

                StringBuilder sb = new StringBuilder();
                sb.append(a.reverse()).append(b.reverse()).append(c.reverse());
                list.add(String.valueOf(sb));
//                System.out.println(sb);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
