function solution(numbers) {
    var answer = 0;
    const sort_numbers = numbers.sort((a,b) => a-b);
    answer = sort_numbers[numbers.length - 1] * sort_numbers[numbers.length - 2]
    return answer;
}