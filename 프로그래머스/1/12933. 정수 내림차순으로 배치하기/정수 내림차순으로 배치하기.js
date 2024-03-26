function solution(n) {
    var answer = "";
    var list = [];
    for (var i=n.toString().length-1; i>=0; i--) {
        list.push(n.toString()[i]);
    }
    list.sort((a,b) => b-a);
    for (var i=0; i<list.length; i++) {
        answer += list[i];
    }
    return Number(answer);
}