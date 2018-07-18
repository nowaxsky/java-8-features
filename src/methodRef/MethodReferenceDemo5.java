package methodRef;

import java.util.Arrays;
import java.util.function.Supplier;

import builtInFunctionalInterface.User;

public class MethodReferenceDemo5 {

	public static void main(String args[]) {
		test1();
		test2();
		test3();
		test4();
	}

	private static void show(Object[] arr) {
		for (Object u : arr) {
			System.out.println(u.toString());
		}
		System.out.println("------------------------------------");
	}

	// Reference to a Static Method
	public static void test1() {
		User[] users = User.createArray();
		Arrays.sort(users, User::compareName);
		// Arrays.sort(users, (a, b) -> Person.compareName(a, b));
		show(users);
		Arrays.sort(users, UserComparator::compareId);
		// Arrays.sort(users, (a, b) -> PersonComparator.compareEmail(a, b));
		show(users);
	}

	// Reference to an Instance Method of a Particular Object
	public static void test2() {
		User[] users = User.createArray();
		
		User u = new User();
		Arrays.sort(users, u::compareAge);
		// Arrays.sort(users, (a, b) -> p.compareAge(a, b));
		show(users);
		
		UserComparator uc = new UserComparator();
		Arrays.sort(users, uc::compareName);
		// Arrays.sort(users, (a, b) -> pc.compareName(a, b));
		show(users);
	}

	// Reference to an Instance Method of an Arbitrary Object of a Particular Type
	public static void test3() {
		User[] users = User.createArray();
		
		Arrays.sort(users, User::compareNameTo);
		// Arrays.sort(users, (a, b) -> a.compareNameTo(b));
		show(users);
		
		Arrays.sort(users, User::compareAgeTo);
		// Arrays.sort(users, (a, b) -> a.compareAgeTo(b));
		show(users);
		
	}

	// Reference to constructor
	public static void test4() {
		Supplier<MethodReferenceDemo5> supplier = MethodReferenceDemo5::new;
		// Supplier<MethodReferenceDemoE> supplier = () -> new MethodReferenceDemoE();
		System.out.println(supplier.get().getClass());
	}
}
