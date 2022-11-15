var customSortString = function(order, s) {
    // Find every letter of order that is also included in s
    // Place them in order and sort the rest of s
    let res = '';
    for (let i = 0; i < order.length; i++) {
        for (let j = 0; j < s.length; j++) {
            if (order[i] === s[j]) {
                res += s[j];
            }
        }
        s = s.replaceAll(order[i], '');
    }
    res += s.split('').sort().join('');
    return res;
};