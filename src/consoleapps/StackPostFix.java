/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleapps;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Tarc
 */
public class StackPostFix {

    Stack<Character> charStack = new Stack<>();
    Stack<String> stringStack = new Stack<>();

    public boolean check(String expression) {
        Boolean isBalanced = true;
        char nextCharacter = ' ';
        char openDelimiter = ' ';
        char left;
        char right;
        char output;
        // Returns true if the parentheses, brackets, and braces in an
        // expression are paired correctly.
        Scanner sc = new Scanner(expression);
        Stack<Integer> stack = new Stack<Integer>();

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                stack.push(sc.nextInt());
                continue;
            }
            int b = stack.pop();
            int a = stack.pop();
            char op = sc.next().charAt(0);
            if (op == '+') {
                stack.push(a + b);
            } else if (op == '-') {
                stack.push(a - b);
            } else if (op == '*') {
                stack.push(a * b);
            } else if (op == '/') {
                stack.push(a / b);
            } else if (op == '%') {
                stack.push(a % b);
            }
        }

        sc.close();
        //return stack.pop();

        return true;
    }

    public static void main(String[] args) {
        String expression = "62+53*/";
    }
}
