import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] king = new char[2];
        char[] pawn = new char[2];
        String temp = st.nextToken();
        king[0] = temp.charAt(0);
        king[1] = temp.charAt(1);

        temp = st.nextToken();
        pawn[0] = temp.charAt(0);
        pawn[1] = temp.charAt(1);

        int N = Integer.parseInt(st.nextToken());

        String[] v = {"B", "T", "L", "R", "LB", "RB", "LT", "RT"};
        int[] vx = {0, 0, -1, 1, -1, 1, -1, 1};
        int[] vy = {-1, 1, 0, 0, -1, -1, 1, 1};

        for (int i=0; i<N; i++) {
            String dir = br.readLine();
            if (dir.equals("B")) {
                if (king[1] != '1') king[1]--;
            } else if (dir.equals("T")) {
                if (king[1] != '8')  king[1]++;
            } else if (dir.equals("L")) {
                if (king[0] != 'A') king[0]--;
            } else if (dir.equals("R")) {
                if (king[0] != 'H') king[0]++;
            } else if (dir.equals("LB")) {
                if (king[1] != '1' && king[0] != 'A')  {
                    king[1]--;
                    king[0]--;
                }
            } else if (dir.equals("RB")) {
                if (king[1] != '1' && king[0] != 'H')  {
                    king[1]--;
                    king[0]++;
                }
            } else if (dir.equals("LT")) {
                if (king[1] != '8' && king[0] != 'A')  {
                    king[1]++;
                    king[0]--;
                }
            } else if (dir.equals("RT")) {
                if (king[1] != '8' && king[0] != 'H')  {
                    king[1]++;
                    king[0]++;
                }
            }

            if (king[0] == pawn[0] && king[1] == pawn[1]) {
                for (int a=0; a<8; a++) {
                    if (dir.equals(v[a])) {
                        pawn[0] += vx[a];
                        pawn[1] += vy[a];

                        if (pawn[0] < 'A' || pawn[0] > 'H' || pawn[1] < '1' || pawn[1] > '8') {
                            pawn[0] -= vx[a];
                            pawn[1] -= vy[a];
                            king[0] -= vx[a];
                            king[1] -= vy[a];
                        }
                    }
                }
            }
        }
        System.out.print(king[0]);
        System.out.println(king[1]);
        System.out.print(pawn[0]);
        System.out.println(pawn[1]);
    }
}
