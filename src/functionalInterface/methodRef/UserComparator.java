package functionalInterface.methodRef;

import functionalInterface.builtIn.User;

public class UserComparator {

	public int compareName(User a, User b) {
		return a.getName().compareTo(b.getName());
	}

	public static int compareId(User a, User b) {
		return a.getId().compareToIgnoreCase(b.getId());
	}
}
