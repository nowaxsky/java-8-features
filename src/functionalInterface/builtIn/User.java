package functionalInterface.builtIn;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String id;
	private String name;
	private int age;
	private Gender gender;
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public User() {
		super();
	}
	
	public User(String id, String name, int age, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "ID=" + id + ", Name=" + name + ", Age=" + age + ", Gender=" + gender;
	}
	
	public void printUser() {
		System.out.println(this);
	}
	
	public static List<User> createList() {
		List<User> users = new ArrayList<>();
		users.add(new User("A01", "Bob", 19, Gender.M));
		users.add(new User("A02", "Jane", 22, Gender.F));
		users.add(new User("B01", "Bob", 25, Gender.M));
		users.add(new User("B02", "Annie", 31, Gender.F));
		users.add(new User("B03", "Betty", 13, Gender.F));
		return users;
	}
	
	public static User[] createArray() {
		List<User> users = createList();
		return users.toArray(new User[users.size()]);
	}
	
	// similar to Comparator method
	public static int compareName(User a, User b) {
		return a.getName().compareTo(b.getName());
	}
	// similar to Comparator method
	public int compareAge(User a, User b) {
		return new Integer(a.getAge()).compareTo(b.getAge());
	}

	// similar to Comparable method
	public int compareNameTo(User a) {
		return this.getName().compareTo(a.getName());
	}
	// similar to Comparable method
	public int compareAgeTo(User a) {
		return new Integer(this.getAge()).compareTo(a.getAge());
	}
}
