function solution(x) {
    var answer = false;
    var num = 0;
    var xx = x;
    for (var i=0; i<x.toString().length; i++) {
        num += xx%10;
        xx = Math.floor(xx/10);
    }
    if (x%num == 0) {
        answer = true;
        console.log(123)
    }
    return answer;
}