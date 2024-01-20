import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        StringBuilder sb = new StringBuilder();

        boolean check = true;
        int num = 1; // 스택에 넣을 숫자
        for (int i=0; i<N; i++) {
            int a = Integer.parseInt(br.readLine());
            while (stack.peek() < a) {
                stack.push(num);
                num++;
                sb.append("+").append('\n');
            }
            if (stack.peek() == a) {
                stack.pop();
                sb.append("-").append('\n');
            }
            if (stack.peek() > a) {
                check = false;
                break;
            }
        }

        if (check) System.out.println(sb);
        else System.out.println("NO");
    }
}