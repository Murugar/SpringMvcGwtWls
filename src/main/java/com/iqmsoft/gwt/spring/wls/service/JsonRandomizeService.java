package com.iqmsoft.gwt.spring.wls.service;

import java.util.Random;

public class JsonRandomizeService
{
	public Integer getRandomNumber()
	{
		Random rand = new Random();
		return rand.nextInt();
	}
}
