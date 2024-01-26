import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] list = new int[number+1];
        
        for (int i=1; i<=number; i++) {
            list[i] = hun(i);
        }
        
        for (int i=1; i<=number; i++) {
            if (list[i] <= limit) answer += list[i];
            else answer += power;
        }
        
        return answer;
    }
    public int hun(int n) {
        if (n == 1) {
            return 1;
        }
        
        int num = 0;
        for (int i=1; i<Math.sqrt(n); i++) {
            if (n%i == 0) num += 2;
        }
        
        if (Math.sqrt(n)%1 == 0) num++;
        
        return num;
    }
}