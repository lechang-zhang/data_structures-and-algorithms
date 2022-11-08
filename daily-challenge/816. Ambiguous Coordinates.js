var ambiguousCoordinates = function(s) {
    // enumeration: List all the possible combinations
    let res = [];
    // Delete the '(' an ')' in s
    s = s.replace('(', '');
    s = s.replace(')', '');
    for (let i = 1; i < s.length; i++) {
        // slice s into two valid parts
        let x = s.slice(0, i), y = s.slice(i);
        // find all the possible combinations in x
        for (let j = 0; j < x.length; j++) {
            const xl = j ? x.slice(0, j) + '.' + x.slice(j) : x;
            // for each x, find all the possible combinations in y
            for (let k = 0; k < y.length; k++) {
                const yl = k ? y.slice(0, k) + '.' + y.slice(k) : y;
                // test if xl & yl are valid integers
                if (xl === xl * 1 + '' && yl === yl * 1 + '') res.push(`(${xl}, ${yl})`);
            }
        }
    }
    return res;
};