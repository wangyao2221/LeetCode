package ParsingABooleanExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// TODO 看能不能简化代码，另外考虑实际情况的这种表达式解析，也就是存在表达式不合法的情况
class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        int currentIndex = 0;

        do {
            char currentChar = expression.charAt(currentIndex);
            if (currentChar == '&'
                    || currentChar == '|'
                    || currentChar == '!') {
                stack.push(currentChar);
            } else if (currentChar == 't' || currentChar == 'f') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                List<Character> list = new ArrayList<>();
                while (!stack.empty()) {
                    char tmp = stack.pop();

                    if (tmp != '&' && tmp != '|' && tmp != '!') {
                        list.add(tmp);
                    } else if (tmp == '&') {
                        boolean result = true;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) == 'f') result = false;
                        }
                        stack.push(result ? 't' : 'f');
                        if (stack.size() == 1) return stack.pop() == 't' ? true : false;
                        break;
                    } else if (tmp == '|') {
                        boolean result = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) == 't') result = true;
                        }
                        stack.push(result ? 't' : 'f');
                        if (stack.size() == 1) return stack.pop() == 't' ? true : false;
                        break;
                    } else if (tmp == '!') {
                        boolean result = list.get(0) == 'f' ? true : false;
                        stack.push(result ? 't' : 'f');
                        if (stack.size() == 1) return stack.pop() == 't' ? true : false;
                        break;
                    }
                }
            }

            currentIndex++;
        } while (!stack.empty());

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().parseBoolExpr("&(t,t,t)"));
    }
}