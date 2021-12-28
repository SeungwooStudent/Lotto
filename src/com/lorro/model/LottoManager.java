package com.lorro.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.lorro.view.LottoConsoleUI;

public class LottoManager {

	LottoConsoleUI lottoConsolUI = new LottoConsoleUI();
	Set<Integer> winningNumbers = new HashSet<Integer>();
	ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
	int bonusNumber;
	Random random = new Random();

	public void init() {
		inputNumbers = new ArrayList<>();
		winningNumbers = new HashSet<>();
		//
//		while (!inputNumbers.isEmpty()) {
//			inputNumbers.remove(0);
//		}
	}

	public void addInputNumber(int number) {
		inputNumbers.add(number);
	}

	public void printInputNumbers() {
		System.out.println("당신이 입력한 번호는 : ");
		for (int i = 0; i < inputNumbers.size(); i++) {
			System.out.print("[" + inputNumbers.get(i) + "]");
		}
		System.out.println(" 입니다.");
	}

	public void makesWinningNumbers() {
		while (winningNumbers.size() != 6) {
			int result = 0;
			// 중복체크
			do {
				result = random.nextInt(45) + 1;
			} while (winningNumbers.contains(result));
			winningNumbers.add(result);
		}

	}

	public void makeBonusNumber() {
		do {
			bonusNumber = random.nextInt(45) + 1;
		} while (winningNumbers.contains(bonusNumber));
		System.out.println("bonusNumber : " + bonusNumber);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public ArrayList<Integer> getWinningNumbers() {
		ArrayList<Integer> numbers = new ArrayList<>();

		Iterator<Integer> it = winningNumbers.iterator();
		while (it.hasNext()) {
			int num = it.next();
			numbers.add(num);
		}

		return numbers;
	}

	public void printWinningNumbers() {
		Iterator<Integer> it = winningNumbers.iterator();
		System.out.println("당첨번호는 : ");
		while (it.hasNext()) {
			int num = it.next();
			System.out.print(num + " ");

		}
		System.out.println();
	}

	public boolean inputOverlapCheck(int hasNumber) {
		if (inputNumbers.contains(hasNumber)) {
			return true;
		}
		return false;
	}

	public void lottoNumbers(int number) {
		if (number < 1 || number > 45) {
			lottoConsolUI.lottoLimit();
		}
	}

	public int getLottoResult() {
		int countplus = 0;
		for (int num : inputNumbers) {
			if (winningNumbers.contains(num)) {
				countplus++;
			}

		}

		return countplus;
	}

	public boolean isCorrectWithBonus() {
		for (int number : inputNumbers) {
			if (inputNumbers.contains(number)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * 1. 입력한 숫자는 총 6개이고 보너스 숫자는 1개이다 입력한 숫자와 보너스 숫자를 비교해라. 2. 입력한 숫자 6개랑 보너스숫자 1개랑
	 * 비교하면 최대 1개가 일치하는 것이다.
	 */

}
