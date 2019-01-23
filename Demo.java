package com.hellojava;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class Demo{
	public static void main(String[] args) {

		Consumer<Integer> consumer=(x)->System.out.println(x);
		consumer.accept(20);

		Supplier<Integer> supplier=()-> new Random().nextInt(10);
		System.out.println(supplier.get());

		Function<String,String> function=(str)-> str.substring(0,2);
		System.out.println(function.apply("abcd"));

		Predicate<String> predicate=(str)-> str.length() > 5;
		System.out.println(predicate.test("abcd"));
	}
}