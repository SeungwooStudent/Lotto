package com.lorro.contoller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lorro.model.LottoManager;
import com.lorro.view.LottoConsoleUI;

public class LottoController {
	public void startLotto() {
		LottoConsoleUI lottoConsolUI = new LottoConsoleUI();
		LottoManager lottoManager = new LottoManager();
		Scanner sc = new Scanner(System.in);

		/*
		1. 6개의 숫자를 입력받기. (무조건 1 <= N <= 45  임을 가정한다.)
		2. 6개의 random 숫자 (담청번호) 를 생성한다.
		3. 최종적으로 몇개 일치하는지 보여준다.
		 */
		lottoConsolUI.inputnumberDisplay();

		// 1
		for (int i = 0; i < 6; i ++) {
			int num = sc.nextInt();
			lottoManager.addInputNumber(num);
		}

		// 2
		lottoManager.makesWinningNumbers();
		// 2) bonus 숫자 생성
		lottoManager.makeBonusNumber();

		// 3
		// 1) 너가 입력한 번호는 ~ 고,
		lottoManager.printInputNumbers();
		// 2) 당첨번호는 ~야.
		lottoManager.printWinningNumbers();
		// 3) 따라서, 결과는 몇개 맞았어!
		int resultCount = lottoManager.getLottoResult();
		boolean isCorrectWithBonus = lottoManager.isCorrectWithBonus();
		lottoConsolUI.printResultCount(resultCount);
		lottoConsolUI.printResult(resultCount, isCorrectWithBonus);
	}

}
