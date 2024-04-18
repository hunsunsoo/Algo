import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int t=0; t<N; t++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<Character>();

            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (stack.isEmpty()) stack.add(c);
                else {
                    if (stack.peek() != c) {
                        stack.add(c);
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}
