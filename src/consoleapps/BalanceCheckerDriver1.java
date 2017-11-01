/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleapps;

import java.util.Stack;

/**
 *
 * @author LOO JIA WEI
 */
public class BalanceCheckerDriver1 {

    Stack<Character> myStack = new Stack<>();

    public static void main(String[] args) {
        String expression = "{()[]}";
        BalanceCheckerDriver1 BCD = new BalanceCheckerDriver1();
        System.out.println("String :" + expression + "are " + BCD.checkBalance(expression));
    }

    public boolean checkBalance(String expression) {
        Boolean isBalanced = true;
        char nextCharacter = ' ';
        char openDelimiter = ' ';
        // Returns true if the parentheses, brackets, and braces in an
        // expression are paired correctly.
        for (int i = 0; i < expression.length(); i++) {
            //nextCharacter = next character in expression
            nextCharacter = expression.charAt(i);

            switch (nextCharacter) {
                case '(':
                case '[':
                case '{': {
                    myStack.push(nextCharacter);
                    //isBalanced = false;
                    break;
                }
                case ')':
                case ']':
                case '}':
                    if (myStack.isEmpty()) {
                        isBalanced = false;
                        break;
                    } else {
                        //openDelimiter = top entry of stack
                        //Pop stack
                        openDelimiter = myStack.peek();
                        //isBalanced = true or false according to whether
                        //openDelimiter and nextCharacter are
                        //a pair of delimiters
                        if ((openDelimiter == '(' && nextCharacter == ')')
                                || (openDelimiter == '{' && nextCharacter == '}')
                                || (openDelimiter == '[' && nextCharacter == ']')) {
                            isBalanced = true;
                            myStack.pop();
                            break;
                        } else {
                            isBalanced = false;
                            break;
                        }
                    }
                default:
                    isBalanced = false;
                    break;

            }//end of switch loop

            /* */
            if (isBalanced == false) {
                break;
            }

        }//end of for loop
        
        /*if stack is still not empty */
        if (!myStack.isEmpty()) {
            isBalanced = false;
        }

        return isBalanced;
    }
}
