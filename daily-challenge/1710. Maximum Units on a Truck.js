var maximumUnits = function(boxTypes, truckSize) {
    // Greedy
    // Sort the boxTypes array by numberOfUnitsPerBox in descending order
    // as long as the sum of boxes number is less than truckSize
    // put the maximum boxes with the maxium units
    let sortedBoxTypes = quickSortArr(boxTypes), unitsNum = 0;
    for (let i = 0; i < boxTypes.length && truckSize > 0; i++) {
        if (truckSize >= sortedBoxTypes[i][0]) {
            unitsNum += sortedBoxTypes[i][0] * sortedBoxTypes[i][1];
            truckSize -= sortedBoxTypes[i][0];
        } else {
            unitsNum += truckSize * sortedBoxTypes[i][1];
            truckSize = 0;
        }
    }
    return unitsNum;
};
// Sort the boxTypes array by numberOfUnitsPerBox in descending order
const quickSortArr = (arr) => {
    // recursion border
    if (arr.length <= 1) return arr;
    // recursion body
    let left = [], right = [];
    for (let i = 1; i < arr.length; i++) {
        if (arr[i][1] > arr[0][1]) {
            left.push(arr[i]);
        } else {
            right.push(arr[i]);
        }
    }
    left = quickSortArr(left);
    right = quickSortArr(right);
    left.push(arr[0]);
    return left.concat(right);
};