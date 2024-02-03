import java.io.*;
import java.util.*;

class Shark {
    int s; // 속력
    int d; // 방향   상 하 우 좌
    int z; // 크기
}

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();

        Shark[][] sharks = new Shark[R][C];

        for (int i=0; i<M; i++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();

            Shark shark = new Shark();
            shark.s = s;
            shark.d = d;
            shark.z = z;

            sharks[r][c] = shark;
        }

        int ans = 0;
        for (int i=0; i<C; i++) { // 낚시왕의 이동
            // 먼저 땅에서 가까운거 잡음
            for (int j=0; j<R; j++) {
                if (sharks[j][i] != null) {
                    ans += sharks[j][i].z;
                    sharks[j][i] = null;
                    break;
                }
            }

            // 임시 배열
            Shark[][] temp = new Shark[R][C];

            // 1초 뒤 상어들의 위치조정
            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    if (sharks[r][c] != null) { // 상어가 있으면 움직임
                        if (sharks[r][c].d == 1 || sharks[r][c].d == 2) { // 상하
                            int x = r;
                            // 속도만큼 이동
//                            for (int k=0; k<sharks[r][c].s; k++) {
//                                if (sharks[r][c].d == 2) { // 아래
//                                    if (x < R-1) x++;
//                                    else {
//                                        sharks[r][c].d = 1;
//                                        x--;
//                                    }
//                                } else if (sharks[r][c].d == 1) { // 위
//                                    if (x > 0) x--;
//                                    else {
//                                        sharks[r][c].d = 2;
//                                        x++;
//                                    }
//                                }
//                            }

                            // 속도만큼 이동 2222222
                            for (int k=0; k<sharks[r][c].s%(2*(R-1)); k++) {
                                if (sharks[r][c].d == 2) { // 아래
                                    if (x < R-1) x++;
                                    else {
                                        sharks[r][c].d = 1;
                                        x--;
                                    }
                                } else if (sharks[r][c].d == 1) { // 위
                                    if (x > 0) x--;
                                    else {
                                        sharks[r][c].d = 2;
                                        x++;
                                    }
                                }
                            }

                            if (temp[x][c] == null) {
                                temp[x][c] = sharks[r][c];
                            } else {
                                if (temp[x][c].z <= sharks[r][c].z) {
                                    temp[x][c] = sharks[r][c];
                                }
                            }
                        } else if (sharks[r][c].d == 3 || sharks[r][c].d == 4) { // 좌우
                            int y = c;
                            // 속도만큼 이동
//                            for (int k=0; k<sharks[r][c].s; k++) {
//                                if (sharks[r][c].d == 3) { // 오른쪽
//                                    if (y < C-1) y++;
//                                    else {
//                                        sharks[r][c].d = 4;
//                                        y--;
//                                    }
//                                } else if (sharks[r][c].d == 4) { // 왼쪽
//                                    if (y > 0) y--;
//                                    else {
//                                        sharks[r][c].d = 3;
//                                        y++;
//                                    }
//                                }
//                            }

                            // 속도만큼 이동 2222
                            for (int k=0; k<sharks[r][c].s%(2*(C-1)); k++) {
                                if (sharks[r][c].d == 3) { // 오른쪽
                                    if (y < C-1) y++;
                                    else {
                                        sharks[r][c].d = 4;
                                        y--;
                                    }
                                } else if (sharks[r][c].d == 4) { // 왼쪽
                                    if (y > 0) y--;
                                    else {
                                        sharks[r][c].d = 3;
                                        y++;
                                    }
                                }
                            }

                            if (temp[r][y] == null) {
                                temp[r][y] = sharks[r][c];
                            } else {
                                if (temp[r][y].z < sharks[r][c].z) {
                                    temp[r][y] = sharks[r][c];
                                }
                            }
                        }
                    } // 상어가 있으면 움직임
                }
            } // 1초 뒤 상어들의 위치조정

            sharks = temp;

//            for (int a=0; a<R; a++) {
//                for (int b=0; b<C; b++) {
//                    if (sharks[a][b] == null) System.out.print("NULL   ");
//                    else System.out.print(sharks[a][b].d + " " + sharks[a][b].s + " " + sharks[a][b].z + "  ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        System.out.println(ans);
    }
}