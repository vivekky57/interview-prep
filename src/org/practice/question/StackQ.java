package org.practice.question;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.practice.question.utils.print;

public class StackQ {
    public static String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch != ']'){
                stack.push(ch);
            }else{
//                stack.pop();
                StringBuilder str = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())){
                    str.append(stack.pop());
                }
                stack.pop();
                str.reverse();
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num.append(stack.pop());
                }
                int temp = Integer.parseInt(num.toString());
                while(temp>0){
                    res.append(str);
                    temp--;
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
