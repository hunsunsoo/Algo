import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int[] list = new int[10];

        for (int i=0; i<N.length(); i++) {
            int num = N.charAt(i)-48;
            list[num]++;
        }

        int max = 0;
        if ((list[6]+list[9])%2 == 0) max = (list[6]+list[9])/2;
        else max = (list[6]+list[9])/2 + 1;

        for (int i=0; i<10; i++) {
            if (i != 6 && i != 9) {
                if (list[i] > max) max = list[i];
            }
        }

        System.out.println(max);
    }
}
