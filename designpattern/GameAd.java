package com.jspider.designpattern;

public class GameAd extends Student implements Game{

	@Override
	public void Cricket() {
		setId(1);
		setName("Dhoni");
		setEmail("dhoni@gmail.123");
		System.out.println(getName()+" is a Cricket  captain  ");
	}

	@Override
	public void FootBall() {
		setId(2);
		setName("Ronaldo");
		setEmail("ronaldo@gmail.com");
		System.out.println(getName()+" is football a captain");
	}

}
