/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleapps;

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
        char  left;
        char right;
        char output;
        // Returns true if the parentheses, brackets, and braces in an
        // expression are paired correctly.
        for (int i = 0; i < expression.length(); i++) {
            //nextCharacter = next character in expression
            nextCharacter = expression.charAt(i);

            switch (nextCharacter) {
                case '+':
                case '-':
                case '*':
                case '/':{
                    charStack.push(nextCharacter);                    
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
                        //openDelimiter = myStack.peek();
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
            return true;
        }
    }

    public static void main(String[] args) {
        String expression = "62+53*/";
    }
}
