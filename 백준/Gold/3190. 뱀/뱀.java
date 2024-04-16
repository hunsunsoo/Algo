import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        int K = Integer.parseInt(br.readLine()); // 사과
        int[][] apple = new int[K][2];
        for (int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            apple[i][0] = Integer.parseInt(st.nextToken());
            apple[i][1] = Integer.parseInt(st.nextToken());
        }

        int L = Integer.parseInt(br.readLine());
        int[][] snake = new int[L][2];
        for (int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            snake[i][0] = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            if (s.equals("D")) snake[i][1] = 1;
            else if (s.equals("L")) snake[i][1] = -1;
        }

        int[] vx = {0, 1, 0, -1}; // 우 하 좌 상
        int[] vy = {1, 0, -1, 0};

        // 시작 좌표, 방향값
        int x = 1;
        int y = 1;
        int dir = 0;
        int cnt = 0;

        // 뱀 좌표 담을 덱
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {1,1});

        outer : while (true) {
//            System.out.println(x+" "+y+ "    "+dir);
            // 방향대로 머리 한칸 이동
            if (dir < 0) dir += 4;
            x += vx[dir%4];
            y += vy[dir%4];
            cnt++;

            // 벽에 박거나 꼬리 먹으면 break;
            if (x <= 0 || x > N || y <= 0 || y > N) {
                break;
            }
            for (int[] xy : deque) {
                if (Arrays.equals(xy, new int[]{x, y})) break outer;
            }

            deque.offer(new int[]{x, y});

            // 사과 있나 검증
            boolean apple_chk = false;
            for (int i=0; i<K; i++) {
                if (x == apple[i][0] && y == apple[i][1]) {
                    apple_chk = true;
                    apple[i][0] = 1000;
                    apple[i][1] = 1000;
                }
            }
            if (!apple_chk) deque.removeFirst();

            // 방향 전환 검증
            for (int i=0; i<L; i++) {
                if (cnt == snake[i][0]) {
                    if (snake[i][1] == 1) dir++;
                    else dir--;
                }
            }
        }
        System.out.println(cnt);
    }
}
// 11  12  13  14  24  34  44  54  64  74
