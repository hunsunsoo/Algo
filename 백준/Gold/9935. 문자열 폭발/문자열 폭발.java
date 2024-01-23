import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String C4 = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) { // 문자열만큼 for
            stack.add(s.charAt(i));

            int cnt = 0;
            if (stack.size() >= C4.length()) {
                for (int j=0; j<C4.length(); j++) { // 폭탄만큼 for
                    // 스택에 새로 넣은거랑 폭탄 j번째랑 비교
                    if (stack.get(stack.size()-C4.length()+j) == C4.charAt(j)) {
                        cnt++;
                    }

                    // 폭탄이랑 똑같으면
                    if (cnt == C4.length()) {
                        for (int k=0; k<C4.length(); k++) {
                            stack.pop();
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            for (char ch : stack) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}