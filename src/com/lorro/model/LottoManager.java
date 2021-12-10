package com.lorro.model;

import java.util.*;

import com.lorro.view.LottoConsoleUI;
import sun.jvm.hotspot.tools.SysPropsDumper;

public class LottoManager {

	LottoConsoleUI lottoConsolUI = new LottoConsoleUI();
	Set<Integer> winningNumbers = new HashSet<Integer>();
	ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
	int bonusNumber;
	Random random = new Random();

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

//		System.out.print("이번주 로또 당첨번호는 :" + winningNumbers + "입니다\n");
	}

	public void makeBonusNumber() {
		do {
			bonusNumber = random.nextInt(45)+1;
		} while (winningNumbers.contains(bonusNumber));
		System.out.println("bonusNumber : " + bonusNumber);
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
		//
		if(number < 1 || number > 45) {
			lottoConsolUI.lottoLimit();
			
		}
	}

	//
	public int getLottoResult() {
		int countplus = 0;
		for (int num : inputNumbers) {
			if (winningNumbers.contains(num)) {
				countplus ++;
			}

		}


		return countplus;
	}

	public boolean isCorrectWithBonus() {
		//
		return false;
	}



}
