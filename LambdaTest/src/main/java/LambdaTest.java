/**
 * Created by ScorpionOrange on 2016/06/12.
 */
public class LambdaTest {
    public static void main(String[] args){
        LambdaTest tester = new LambdaTest();

        //带有类型声明的表达式
        LambdaMath addition = (int a, int b) -> a + b;

        //没有类型声明的表达式
        LambdaMath subtraction = (a, b) -> a - b;

        //带有大括号、返回语句的表达式
        LambdaMath multiplication = (int a, int b) -> {return a * b;};

        //没有大括号和返回语句的表达式
        LambdaMath division = (int a, int b) -> a / b;

        //测试函数式接口，使用带有类型声明、大括号、返回语句的表达式
        LambdaCube cube = (int a) -> a * a * a;

        //输出结果
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        //测试方法：平方(square)
        System.out.println("10 's Square = " + tester.square(10));

        //测试方法：立方(cube)，函数式接口
        System.out.println("10 's Cube = " + tester.operatePlus(10, cube));

        //没有括号的表达式
        GreetingService greetingService1 = message -> System.out.println("Hello " + message);

        //有括号的表达式
        GreetingService greetingService2 = (message) -> System.out.println("Hello " + message);

        //调用sayMessage方法输出结果
        greetingService1.sayMessage(" LambdaTesting ");
        greetingService2.sayMessage(" LambdaTester ");
    }

    //自定义的接口和方法
    //自定义接口
    interface LambdaMath{
        int operation(int a, int b);
    }

    //自定义接口
    interface GreetingService{
        void sayMessage(String message);
    }

    //测试自定义接口
    interface LambdaCube{
        int operationPlus(int a);
    }

    //自定义方法
    private int operate(int a, int b, LambdaMath lambdaMath){
        return lambdaMath.operation(a, b);
    }

    //测试自定义方法：平方(square)，普通式方法定义
    private int square(int a) { return a * a;}

    //测试方法：立方(cube) 函数式方法定义，实测错误
    //private int cube = (int a) -> {return a * a * a;}

    //测试自定义方法：立方(cube)，使用函数式接口
    private int operatePlus(int a, LambdaCube lambdaCube) { return lambdaCube.operationPlus(a);}
}
