var halvesAreAlike = function(s) {
    // Loop through the string from (start, mid) and (mid, end), 
    // count the vowels' numbers of each substring
    let mid = s.length / 2, checker = 'aeiouAEIOU'; 
    let count1 = 0, count2 = 0;
    for (let i = 0; i < s.length; i++) {
        if ((i >= 0 && i < mid) && checker.includes(s[i])) count1++;
        if (i >= mid && checker.includes(s[i])) count2++;
    }
    console.log(count1, count2);
    return count1 === count2;
};