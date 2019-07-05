package ParsingABooleanExpression;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    class ExprTree {
        public boolean value;
        public char ch;
        public String childExpr;
        public List<ExprTree> childs;

        public ExprTree(char value, String childExpr, List<ExprTree> childs) {
            this.ch = value;
            this.childExpr = childExpr;
            this.childs = childs;
        }
    }

    public boolean parseBoolExpr(String expression) {
        ExprTree exprTree = new ExprTree(' ', expression, null);

        buildExprTree(exprTree);
        calExprTree(exprTree);

        return exprTree.value;
    }

    private void calExprTree(ExprTree exprTree) {
        if (exprTree == null) return;

        if (exprTree.childs != null) {
            for (int i = 0; i < exprTree.childs.size(); i++) {
                calExprTree(exprTree.childs.get(i));
            }
        }

        if (exprTree.ch == 'f') {
            exprTree.value = false;
        } else if (exprTree.ch == 't') {
            exprTree.value = true;
        } else if (exprTree.ch == '&') {
            exprTree.value = true;
            for (int i = 0; i < exprTree.childs.size(); i++) {
                ExprTree child = exprTree.childs.get(i);
                if (child.value == false) {
                    exprTree.value = false;
                }
            }
        } else if (exprTree.ch == '|') {
            exprTree.value = false;
            for (int i = 0; i < exprTree.childs.size(); i++) {
                ExprTree child = exprTree.childs.get(i);
                if (child.value == true) {
                    exprTree.value = true;
                }
            }
        } else if (exprTree.ch == '!') {
            ExprTree child = exprTree.childs.get(0);
            exprTree.value = !child.value;
        }
    }

    private void buildExprTree(ExprTree exprTree) {
        if (exprTree.childExpr.length() > 0) {
            char firstChar = exprTree.childExpr.charAt(0);

            exprTree.ch = firstChar;

            if (exprTree.childExpr.length() == 1 && (firstChar == 'f' || firstChar == 't')) {
                return;
            }

            List<ExprTree> childs = new ArrayList<>();
            for (int i = 2; i < exprTree.childExpr.length() - 1; i++) {
                char tmp = exprTree.childExpr.charAt(i);
                if (tmp == 'f' || tmp == 't') {
                    ExprTree tree = new ExprTree(' ', "" + tmp, null);
                    buildExprTree(tree);
                    childs.add(tree);
                } else if (tmp == '&' || tmp == '|' || tmp == '!') {
                    StringBuilder expr = new StringBuilder("" + tmp);
                    int bracCount = 0;
                    for (i = i + 1; i < exprTree.childExpr.length() - 1; i++) {
                        char tmp_ = exprTree.childExpr.charAt(i);
                        expr.append(tmp_);
                        if (tmp_ == '('){
                            bracCount++;
                        } else if (tmp_ == ')') {
                            bracCount--;
                        }
                        if (bracCount == 0) {
                            break;
                        }
                    }
                    ExprTree tree = new ExprTree(' ', expr.toString(), null);
                    buildExprTree(tree);
                    childs.add(tree);
                }
            }
            exprTree.childs = childs;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().parseBoolExpr("!(&(!(t),&(f),|(f)))"));
    }
}