var countConsistentStrings = function(allowed, words) {
    // Loop over words array, 
    // for each word, check its letter 
    // from start to end to see if they're all contained in allowed
    let res = 0;
    for (const word of words) {
        let flag = 1;
        for (let i = 0; i < word.length; i++) {
            if (!allowed.includes(word[i])) {
                flag = 0;
                break;
            }
        }
        if (flag) res++;
    }
    return res;
};