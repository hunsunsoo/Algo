import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> heap = new ArrayList<>();
        heap.add(0);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (heap.size() < 2) sb.append(0).append('\n');
                else { // 제일 작은거 출력
                    sb.append(heap.get(1)).append('\n');
                    heap.set(1, heap.get(heap.size()-1)); // 맨 끝값을 1번으로 가져옴
                    heap.remove(heap.size()-1); // 맨끝 지움
                    int p = 1; // (1번으로 옮긴)끝값의 인덱스
                    while (p*2 < heap.size()) { // 최소 왼쪽자식이 있으면..
                        int min = heap.get(p*2);
                        int minp = p*2;
                        if ((p*2+1) < heap.size() && min > heap.get(p*2+1)) { // 오른쪽 자식도 있고.. 오른쪽이 더 작아
                            min = heap.get(p*2+1);
                            minp = p*2 + 1;
                        }

                        if (heap.get(p) < min) {
                            break;
                        }

                        int temp = heap.get(p);
                        heap.set(p, heap.get(minp));
                        heap.set(minp, temp);
                        p = minp;
                    }
                }
            } else { // 숫자 add
                heap.add(num);
                int idx = heap.size()-1; // 일단 맨 끝값부터 인덱스

                while (idx > 1) {
                    // 인덱스값이 부모(idx/2)보다 크면 할거없음
                    if (heap.get(idx) > heap.get(idx/2)) break;

                    int temp = heap.get(idx); // 인덱스값 저장
                    heap.set(idx, heap.get(idx/2)); // 인덱스값을 그 부모로 바꿔줌
                    heap.set(idx/2, temp); // 부모에는 temp 값
                    idx = idx/2;
                }
            }
        }
        System.out.println(sb);
    }
}