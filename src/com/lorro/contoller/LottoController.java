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

		lottoConsolUI.inputnumberDisplay();

		// 1
		boolean isFind = true;
		while (isFind) {
			try {
				for (int i = 0; i < 6; i++) {
					int num = sc.nextInt();
					boolean inputOberlapCheck = lottoManager.inputOverlapCheck(num);
					if (inputOberlapCheck) {
						lottoConsolUI.overlapNumber();
						i--;
					} else {
						lottoManager.addInputNumber(num);
					}
				}
			} catch (InputMismatchException ime) {
				lottoConsolUI.printInputMistmatchError();
				sc = new Scanner(System.in);
				continue;
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

			lottoConsolUI.printResultCount(resultCount); // 당첨개수는 +@개 입니다

			lottoConsolUI.printResult(resultCount, isCorrectWithBonus); // @등 입니다
		}

	}

}
