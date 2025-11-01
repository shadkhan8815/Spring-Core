package com.rays.autowire.byannotation;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImp implements UserDAOInt {

	public void add() {
         System.out.println("Annotation Add() * Method..!!");		
	}

}
