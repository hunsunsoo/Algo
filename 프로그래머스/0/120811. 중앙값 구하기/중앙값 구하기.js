function solution(array) {
    var answer = 0;
    const sort_array = array.sort((a,b) => a-b);
    answer = sort_array[Math.floor(array.length / 2)];
    return answer;
}