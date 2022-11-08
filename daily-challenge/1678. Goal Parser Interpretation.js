var interpret = function(command) {
    // Loop over command and interprete each unit to its meaning
    let res = '';
    for (let i = 0; i < command.length; i++) {
        if (command[i] === 'G') {
            res += 'G';
        } 
        if (command[i] === '(') {
            if (command[i + 1] === ')') {
                res += 'o';
                i++;
                continue;
            }
            if (command[i + 1] === 'a') {
                res += 'al';
                i += 3;
                continue;
            }
        }
    }
    return res;
};