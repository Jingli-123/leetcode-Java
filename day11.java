/**150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * You are given an array of strings tokens that represents an arithmetic expression in 
 * a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < tokens.length; i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                int m = stack.pop();
                int n = stack.pop();
                result = mathOp(tokens[i], m, n);
                System.out.print(result);
                stack.push(result);
                
                
            }
            
        }
        return stack.pop();
    }
    public int mathOp(String s, int n, int m){
        if(s.equals("+")){
            return m + n;
                }else if(s.equals("-")){
               return m - n;     
                }else if(s.equals("*")){
               return m * n;     
                }else{
                    return m / n;
                }
    }
}