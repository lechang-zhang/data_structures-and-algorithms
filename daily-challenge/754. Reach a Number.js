var reachNumber = function(target) {
    // For targets which only need to move right, return the numMoves
    // For other targets, find the min sum that has even difference with the target
    // and they'll have same numMoves(change (difference / 2)th step to the right)
    target = Math.abs(target);
    let sum = 0, step = 0;
    while (sum < target) {
        step++;
        sum += step;
    }
    while ((sum - target) % 2 !== 0) {
        step++;
        sum += step;
    }
    return step;
};