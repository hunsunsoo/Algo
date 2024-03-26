function solution(str1, str2) {
    var answer = 2;
    // 0 1 2 3 4
    for (var i=0; i<=str1.length-str2.length; i++) {
        var chk = 0;
        for (var j=0; j<str2.length; j++) {
            if (str1[i+j] == str2[j]) chk++;
        }
        if (chk == str2.length) {
            answer = 1;
            break;
        } else chk = 0;
    }
    return answer;
}