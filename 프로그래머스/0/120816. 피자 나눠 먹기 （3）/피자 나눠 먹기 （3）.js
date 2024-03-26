function solution(slice, n) {
    var answer = 1;
    while(true) {
        if (answer*slice >= n) {
            break;
        }
        answer++;
    }
    return answer;
}