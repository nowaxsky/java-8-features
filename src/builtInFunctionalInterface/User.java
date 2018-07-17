package builtInFunctionalInterface;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String id;
	private String name;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public User() {
		super();
	}
	
	public User(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "ID=" + id + ", Name=" + name + ", Age=" + age;
	}
	
	public void printUser() {
		System.out.println(this);
	}
	
	public static List<User> createList() {
		List<User> users = new ArrayList<>();
		users.add(new User("A01", "Bob", 18));
		users.add(new User("A02", "Jane", 22));
		users.add(new User("B01", "John", 25));
		users.add(new User("B02", "Phil", 65));
		users.add(new User("B03", "Betty", 13));
		return users;
	}
	
}
