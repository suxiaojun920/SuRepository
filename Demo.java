package com.hellojava;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class Demo{
	public static void main(String[] args) {
		//lambda 表达式 针对接口 也就是说以前的匿名内部类实现接口创建接口的对象的方式可以直接使用lambd表达式
		//例如 
		// Consumer<Integer> con=new Consumer<Integer>(){
		// 	public void accept(Integer x){
		// 		System.out.println(x);
		// 	}
		// };
		//那么上面的代码可以直接使用lambda表达式
		// Consumer<Integer> consumer=(x)->System.out.println(x);
		// consumer.accept(20);
		//但是lambda表达式只能针对函数式接口使用(函数式接口就是当前接口只能拥有一个抽象方法的接口 
		//一般使用@FunctionalInterface注解描述)
		//所有那么函数式接口只能拥有一个方法 
		//那么一个方法只能最多出现几种形式 
		//1：有参数无返回值(针对Consumer消费式函数式接口)
		//2：无参数有返回值(针对Supplier提供者函数式接口)
		//3：有参数有返回值(针对Function函数的函数式接口)
		//4：特殊的断言式(针对Predicate断言式函数接口)

		//但是如果上面的lambda表达式的实现((x)->System.out::println) 
		//这种lambda 表达式的实现明确是借助System.out的println方法实现(也就是说当前Consumer接口的accept()
		//是借助System.out的println方法实现) 那么就可以直接使用 System.out::println
		//方法调用::形式
		//1：类::方法(这种形式方法必须是静态方法)
		//2:对象::方法(这种形式方法可以是静态也可以是非静态)
		//3:类::非静态方法(这种形式必须是调用参数1的方法，参数2是参数 也就是说参数1是方法实现的对象 
		//参数2是调用参数1对象方法的参数)

		//类::方法(静态方法)
		// Consumer<Integer> consumer1=System.out::println;
		// consumer1.accept(20);

		// Supplier<Integer> supplier=()-> new Random().nextInt(10);
		// System.out.println(supplier.get());

		//对象::方法
		// Supplier<Integer> supplier1=new Random()::nextInt;
		// System.out.println(supplier1.get());

		//类::方法(静态方法)
		// Function<String,Integer> num=Integer::parseInt;
		// System.out.println(num.apply("20")+20);

		//类::实例方法(这种形式内部必须是参数1.方法(参数2) 返回参数3定义的类型 
		//所以使用了BiFunction接口(这个接口可以定义三个参数)) 因为compareTo(int i)方法需要参数
		//所以调用Integer::compareTo; 就必须三个参数 因为 参数1默认是方法调用的宿主对象 
		//参数2才是传递给compareTo()方法的参数
		//参数3是定义返回值
		//隐含的操作是:自动把200封装成Integer  return new Integer(200).compareTo(100) 
		//所以必须是三个参数的函数式接口

		//UnaryOperator<Integer> == Function<Integer,Integer> 这两个是一样的
		// BiFunction<Integer,Integer,Integer> ff=Integer::compareTo;
		// System.out.println("Integer::compareTo:"+ff.apply(200,100));

		//Integer:doubleValue 因为doubleValue() 没有参数所有当前的lambda就只需要两个参数
		//return new Integer(200).doubleValue() 内部隐含的代码
		// Function<Integer,Double> ff1=Integer::doubleValue;
		// System.out.println("Integer::doubleValue:"+ff1.apply(200).getClass().getName());

		// Function<String,String> function=(str)-> str.substring(0,2);
		// System.out.println(function.apply("abcd"));

		//第一个String 以后指向"abcd" 第二个Integer 是substring方法的参数 第三个String是返回值类型
		//return "abcd".substring(2);
		// BiFunction<String,Integer,String> ss=String::substring;
		// System.out.println("String::substring:"+ss.apply("abcd",2));
		

		// Comparator<User> comparable=User::compareTo;


		// Predicate<String> predicate=(str)-> str.length() > 5;
		// System.out.println(predicate.test("abcd"));


		Function<String,String> str=String::new;

		String s=str.apply("abcd");

		System.out.println(s);
	}
}