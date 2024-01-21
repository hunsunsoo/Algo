import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Double Ax = (double) Integer.parseInt(st.nextToken());
        Double Ay = (double) Integer.parseInt(st.nextToken());
        Double Az = (double) Integer.parseInt(st.nextToken());

        Double Bx = (double) Integer.parseInt(st.nextToken());
        Double By = (double) Integer.parseInt(st.nextToken());
        Double Bz = (double) Integer.parseInt(st.nextToken());

        Double Cx = (double) Integer.parseInt(st.nextToken());
        Double Cy = (double) Integer.parseInt(st.nextToken());
        Double Cz = (double) Integer.parseInt(st.nextToken());

        // 삼분탐색
        Double mid1 = (double) ((Cx-Ax)*(Cx-Ax) + (Cy-Ay)*(Cy-Ay) + (Cz-Az)*(Cz-Az));
        Double mid2 = (double) ((Cx-Bx)*(Cx-Bx) + (Cy-By)*(Cy-By) + (Cz-Bz)*(Cz-Bz));
        for (int i = 0; i < 1000000; i++) {
            Double x1 = (double) (Ax + (Bx-Ax)/3);
            Double y1 = (double) (Ay + (By-Ay)/3);
            Double z1 = (double) (Az + (Bz-Az)/3);

            Double x2 = (double) (Ax + 2*(Bx-Ax)/3);
            Double y2 = (double) (Ay + 2*(By-Ay)/3);
            Double z2 = (double) (Az + 2*(Bz-Az)/3);

            mid1 = (Cx-x1)*(Cx-x1) + (Cy-y1)*(Cy-y1) + (Cz-z1)*(Cz-z1);
            mid2 = (Cx-x2)*(Cx-x2) + (Cy-y2)*(Cy-y2) + (Cz-z2)*(Cz-z2);

            if (mid1 < mid2) {
                Bx = x2;
                By = y2;
                Bz = z2;
            } else {
                Ax = x1;
                Ay = y1;
                Az = z1;
            }
        }

        System.out.println(Math.min(Math.sqrt(mid1), Math.sqrt(mid2)));

    }
}