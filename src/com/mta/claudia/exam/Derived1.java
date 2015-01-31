package com.mta.claudia.exam;

public class Derived1 extends Base {
	private char ch;

	public Derived1(double d, char ch) {
		super(d);
		this.ch = ch;
	}
	
	@Override
	public void foo() {
		System.out.println("In Derived1::foo");
	}
}
