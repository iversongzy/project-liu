package com.lgt.datastructure.arraystack;

public class Calculator {
    public static int calculate(String expression) {
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        //开始while循环的扫描expression
        while (true) {
            //依次得到expression 的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //如果是运算符
            if (operStack.isOper(ch)) {
                //判断栈是否为空
                if (!operStack.isEmpty()) {
                    //关键：如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
                    //在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    //如果为空直接入符号栈..
                    operStack.push(ch);
                }
            } else {
                //如果是数字
                keepNum += ch;
                //如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈, 注意是看后一位，不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的!, keepNum清空
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕，顺序的从数栈和符号栈中pop出相应的数和符号
        while (true) {
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);//入栈
        }
        //将数栈的最后数，pop出，就是结果
        int res2 = numStack.pop();
        return res2;
    }

    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
        int res = Calculator.calculate(expression);
        System.out.printf("表达式 %s = %d", expression, res);
    }
}
