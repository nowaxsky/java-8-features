package streamApi.basic;

import java.util.List;
import java.util.stream.Collectors;

import functionalInterface.builtIn.User;

public class BasicStreamApi {

	public static void forLoop() {
		List<User> users = User.createList();
		
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
	}
	
	public static void forLoop2() {
		List<User> users = User.createList();
		
		for(User u: users) {
			System.out.println(u);
		}
	}
	
	public static void streamForEach() {
		List<User> users = User.createList();
		
//		users.forEach(u -> System.out.println(u));
		users.stream().forEach(u -> System.out.println(u));
	}
	
	public static void streamForEach2() {
		List<User> users = User.createList();
		
		users.stream().forEach(u -> System.out.println(u.getName()));
	}
	
	public static void streamMap() {
		List<User> users = User.createList();
		
		users.stream().map(u -> u.getName()).forEach(n -> System.out.println(n));
	}
	
	public static void streamFilter() {
		List<User> users = User.createList();
		
		users.stream().filter(u -> u.getAge() >= 18).map(u -> u.getName()).forEach(n -> System.out.println(n));
	}
	
	public static void streamCollect() {
		List<User> users = User.createList();
		
		List<String> names = users.stream().map(u -> u.getName()).collect(Collectors.toList());
		names.stream().forEach(n -> System.out.println(n));
	}
	
	public static void main(String[] args) {
		System.out.println("1. for loop");
		forLoop();
		
		System.out.println("\n2. for loop 2");
		forLoop2();
		
		System.out.println("\n3. stream forEach");
		streamForEach();
		
		System.out.println("\n4. stream forEach 2");
		streamForEach2();
		
		System.out.println("\n5. stream map");
		streamMap();
		
		System.out.println("\n5. stream filter");
		streamFilter();
		
		System.out.println("\n5. stream collect");
		streamCollect();
	}
}
