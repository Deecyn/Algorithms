package datastructure.stack_queue;


/**
 * @Author: Deecyn
 * @Date: Created in 21:46 2019/4/3
 * @Description: 中缀表达式转换为后缀表达式, 然后计算后缀表达式的值
 */
public class ConvertedExpression {
    public static void main(String[] args) {
        String teststr="1+3*(9-2)+90";
        String teststr2 = "5+30*(15/3-2)+10/3";

        String postfix = infixToPostfix(teststr2);
        System.out.println("中缀表达式->expstr=  "+teststr2);
        System.out.println("后缀表达式->postfix= "+postfix);
        System.out.println("计算结果->value= "+calculatePostfix(postfix));
    }

    /**
     * 中缀表达式转换为后缀表达式
     * @param expstr
     * @return
     */
    public static String infixToPostfix(String expstr){
        StackOfArrayList<String> symbolStack = new StackOfArrayList<>();
        String postfix = "";

        int i = 0;
        while (i < expstr.length()){
            char ch = expstr.charAt(i);
            switch (ch){
                case '+':
                case '-':
                    while (!symbolStack.empty() && !symbolStack.peek().equals("(")){
                        // 将比遇到的 + 或 - 优先级高的运算符弹出栈（同级算高）
                        postfix += symbolStack.pop();
                    }
                    // 将遇到的 + 或 - 入栈
                    symbolStack.push(String.valueOf(ch));
                    i++;
                    break;
                case '*':
                case '/':
                    while (!symbolStack.empty() && (symbolStack.peek().equals("*")
                            || symbolStack.peek().equals("/"))){
                        postfix += symbolStack.pop();
                    }
                    symbolStack.push(String.valueOf(ch));
                    i++;
                    break;
                case '(':
                    symbolStack.push(String.valueOf(ch));
                    i++;
                    break;
                case ')':
                    String out = symbolStack.pop();
                    while (out != null && !out.equals("(")){
                        postfix += out;
                        out = symbolStack.pop();
                    }
                    i++;
                    break;
                default:
                    // 操作数直接入栈
                    while (ch >= '0' && ch<='9'){
                        postfix += ch;
                        i++;
                        if (i<expstr.length()){
                            ch = expstr.charAt(i);
                        }else {
                            ch = '=';
                        }
                    }
                    // 分隔符 -- 空格
                    postfix += " ";
                    break;
            }
        }
        while (!symbolStack.empty()){
            postfix += symbolStack.pop();
        }
        return postfix;
    }

    public static double calculatePostfix(String postfix){
        StackOfArrayList<Double> numberStack = new StackOfArrayList<>();
        double result = 0;
        int i = 0;
        while (i < postfix.length()){
            char ch = postfix.charAt(i);

            if (ch >= '0' && ch <= '9'){
                // 当 ch 为操作数时：

                result = 0;
                // 空格为数的分隔符，便于处理多位数
                while (ch != ' '){
                    result = result*10 + Integer.parseInt(String.valueOf(ch));
                    i++;
                    ch = postfix.charAt(i);
                }
                i++;
                numberStack.push(result);
            }else {
                // 当 ch 为操作符时：

                double y= numberStack.pop();
                double x= numberStack.pop();
                switch (ch) {
                    //根据情况进行计算
                    case '+': result=x+y; break;
                    case '-': result=x-y; break;
                    case '*': result=x*y; break;
                    //注意这里并没去判断除数是否为0的情况
                    case '/': result=x/y; break;
                    default:
                }
                //将运算结果入栈
                numberStack.push(result);
                i++;
            }
        }
        return numberStack.pop();
    }

}
