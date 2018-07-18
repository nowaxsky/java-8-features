package methodRef;

import builtInFunctionalInterface.User;

public class UserComparator {

	public int compareName(User a, User b) {
		return a.getName().compareTo(b.getName());
	}

	public static int compareId(User a, User b) {
		return a.getId().compareToIgnoreCase(b.getId());
	}
}
