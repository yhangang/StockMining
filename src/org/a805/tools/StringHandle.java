package org.a805.tools;

public class StringHandle {
	
	public static Object nullToSpace(Object o) {
		if (o == null) {
			return "";
		} else {
			return o;
		}
	}

}
