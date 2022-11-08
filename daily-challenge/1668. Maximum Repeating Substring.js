var maxRepeating = function(sequence, word) {
    // KEYWORD: "concatenated!"
    let res = 1;
    while (sequence.includes(word.repeat(res))) res++;
    return res - 1;
};