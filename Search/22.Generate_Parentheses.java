//It's really amazing to draw a picture to help us understand
//e.g. n = 2
//Make a tree
//Root is '(' because we can't start with a ')' if we want well-formed parentheses
//Every left child of a parent is parent+(, and every right child of a parent is parent+)

//                                 ( 
                            //l = 1, r = 2
//             ((                                          ()
        //l = 0, r = 2                              //l = 1, r = 1

//    (((                (()                   ()(                     ())
  //l=-1, r=2         //l=0, r=1           //l=0,r=1               //l=1,r=0

//                 (()(      (())       ()(()      ()()           ())(      ()))
               //l=-1,r=1  //l=0,r=0  //l=-1,r=1 //l=0,r=0     //l=0,r=0  //l=1,r=-1

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);
        return res;
    }
    
    //Recursion
    private void dfs(int l, int r, String s, List<String> res) {
        //Recursion Boundary
        if(l == 0 && r == 0) {
            res.add(s);
            return;
        }
        //Recursion part
        if(l > 0) {
            dfs(l - 1, r, s + '(', res);
        }
        if(r > 0 && l < r) {
            dfs(l, r - 1, s + ')', res);
        }
    }
}