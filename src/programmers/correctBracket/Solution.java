package programmers.correctBracket;

// "()()"	true
// "(())()"	true
// ")()("	false
// "(()("	false

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        solution("(())()");
    }
    static boolean solution(String s) {
        // s길이가 홀수이면 return false;
        if(s.length() % 2 != 0) { return false; }
        // 닫힌 bracket으로 시작하면 return false;
        if(s.startsWith(")")) { return false; }

        Stack<Character> stack = new Stack<>();

        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            switch (c) {
                case '(' : {
                    stack.push(c);
                    break;
                }
                case ')' : {
                    if(stack.empty()) { return false; }
                    stack.pop();
                }
            }
        }

        if(stack.empty()) {
            return true;
        }

        return false;
    }
}