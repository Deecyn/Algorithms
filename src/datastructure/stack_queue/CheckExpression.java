package datastructure.stack_queue;

/**
 * @Author: Deecyn
 * @Date: Created in 18:25 2019/4/3
 * @Description: 栈的应用 -- 平衡符号
 */
public class CheckExpression {
    public static void main(String[] args) {
        String teststr = "(5+3)*(2/(4+2))";
        System.out.println("检测结果："+checkExpression(teststr));
    }

    /**
     * 检验字符串式子的平衡符号
     * 返回检查结果
     */
    public static String checkExpression(String expstr){
        String checkResult;
        StackOfArrayList<String> stack = new StackOfArrayList<>();

        int i=0;
        while (i<expstr.length()){
            char ch = expstr.charAt(i);
            switch (ch){
                case '(':
                    // 如果字符是一个开放符号，则压入栈中
                    stack.push(String.valueOf(ch));
                    break;
                case ')':
                    // 如果字符是一个封闭符号：

                    if (stack.empty()){
                        // 栈空时报错
                        checkResult = "error empty";
                        return checkResult;
                    }else if (!stack.pop().equals("(")){
                        // 弹出栈的符号不是对应的开放符号时报错
                        checkResult = "error open char";
                        return checkResult;
                    }
                    default:
            }
            i++;
        }

        if (!stack.empty()){
            // 栈非空时报错
            checkResult = "error end";
        }else {
            checkResult = "check success pass";
        }
        return checkResult;
    }
}
