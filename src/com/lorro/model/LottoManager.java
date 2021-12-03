package com.lorro.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LottoManager {
	
	
	ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
	Set<Integer> winningNumbers = new HashSet<Integer>();
	
	public void addInputNumber(int number) {
		inputNumbers.add(number);
	}
	public void printAll() {
		
		for(int i = 0; i < inputNumbers.size(); i++) {
			inputNumbers.get(i);
			System.out.println();
		}
	}
	
	
	
	
	
}
