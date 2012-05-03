package myjava;

import myruby.MyAdderImpl;

public class MyJrubyCaller {
	public static void main(String[] args) {
		MyAdderImpl jrubyImpl = new MyAdderImpl();
		System.out.println("" + jrubyImpl.add(1, 2));
	}
}
