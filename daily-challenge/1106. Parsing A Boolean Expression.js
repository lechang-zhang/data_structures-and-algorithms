var parseBoolExpr = function(expression) {
    // Loop through the expression and find the smallest unit
    // turn every unit into a string 't' or 'f'
    let stack = [];
    for (let i = 0; i < expression.length; i++) {
        if (expression[i] === ')') {
            // Hold each unit in a set
            let set = new Set();
            while (stack[stack.length - 1] !== '(') set.add(stack.pop());
            stack.pop(); // pop '('
            let operation = stack.pop();
            if (operation === '&') {
                stack.push(set.has('f') ? 'f' : 't');
            } else if (operation === '|') {
                stack.push(set.has('t') ? 't' : 'f');
            } else { // operation === '!'
                stack.push(set.has('t') ? 'f' : 't');
            }
        } else if (expression[i] !== ',') {
            stack.push(expression[i]);
        }
    }
    return stack[0] === 't';
};