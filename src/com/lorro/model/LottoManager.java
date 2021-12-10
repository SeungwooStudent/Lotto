package com.lorro.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.lorro.view.LottoConsoleUI;

public class LottoManager {

	LottoConsoleUI lottoConsolUI = new LottoConsoleUI();
	Set<Integer> winningNumbers = new HashSet<Integer>();
	ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
	Random random = new Random();

	public void addInputNumber(int number) {
		inputNumbers.add(number);
	}

	public void printAll() {
		for (int i = 0; i < inputNumbers.size(); i++) {
			System.out.print("[" + inputNumbers.get(i) + "]");
		}
	}

	public void winingNumber() {
		while (winningNumbers.size() != 6) {
			int result = random.nextInt(45) + 1;
			winningNumbers.add(result);
		}

		System.out.print("이번주 로또 당첨번호는 :" + winningNumbers + "입니다\n");
	}

	public boolean inputOverlapCheck(int hasNumber) {
			if (inputNumbers.contains(hasNumber)) {
				return true;
			}
		return false;
	}

	public void lottoNumbers(int number) {
		if(number < 1 || number > 45) {
			lottoConsolUI.lottoLimit();
			
		}
	}
	public void lottoResult() {
		int countplus = 0;
		for (int i = 0; i < winningNumbers.size(); i++) {
			if (winningNumbers.contains(inputNumbers.get(i))) {
				countplus++;
				System.out.println("총" + countplus + "개 맞았습니다");

				
				if (countplus == 6) {
					lottoConsolUI.firstPlace();
				} else if (countplus == 5) {
					lottoConsolUI.secondPlace();
				} else if (countplus == 4) {
					lottoConsolUI.thirdPlace();
				} else if (countplus == 3) {
					lottoConsolUI.notPlace();
				} 
			}
		}
	}

}
