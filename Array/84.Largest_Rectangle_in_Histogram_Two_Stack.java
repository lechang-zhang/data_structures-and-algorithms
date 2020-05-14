class Solution {
    public int largestRectangleArea(int[] heights) {
        //Corner case
        if(heights == null || heights.length == 0) return 0;
        
        //Two stacks O(n)
        int len = heights.length, maxarea = 0, size = 0, i;
        Stack<Integer> position = new Stack<>();
        Stack<Integer> height = new Stack<>();
        position.push(0);
        height.push(heights[0]);
        for(i = 1; i < len; i++) {
            if(heights[i] > height.peek()) {
                position.push(i);
                height.push(heights[i]);
            } else if (heights[i] < height.peek()) {
                int lastpos = 0, localsize;
                while(!height.isEmpty() && heights[i] < height.peek()) {
                    localsize = height.peek() * (i - position.peek());
                    height.pop();
                    lastpos = position.pop();
                    
                    if(localsize > size) {
                        size = localsize;
                    }
                }
                height.push(heights[i]);
                position.push(lastpos);
            }
            if(size > maxarea) {
                maxarea = size;
            }
        }
        while(!position.isEmpty() && !height.isEmpty()) {
            size = height.peek() * (i - position.peek());
            position.pop();
            height.pop();
            
            if(size > maxarea) {
                maxarea = size;
            }
        }
        return maxarea;
    }
}