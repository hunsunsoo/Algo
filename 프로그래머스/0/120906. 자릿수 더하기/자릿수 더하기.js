function solution(n) {
    var answer = 0;
    var leng = n.toString().length;
    for (var i=1; i<=leng; i++) {
        answer += n%10;
        n = Math.floor(n/10);
    }
    return answer;
}