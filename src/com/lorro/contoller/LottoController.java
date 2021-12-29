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

		while (true) {

			lottoConsolUI.lottoProgramStart();
			int choice = sc.nextInt();
			if (choice == 1) {
				// 1
				lottoManager.init();
				boolean isFinished = true;
				while (isFinished) {

					lottoConsolUI.inputnumberDisplay();
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
					}
					// 2
					lottoManager.makesWinningNumbers();
					// 2) bonus 숫자 생성
					// 3
					// 1) 너가 입력한 번호는 ~ 고,
					lottoManager.printInputNumbers();
					// 2) 당첨번호는 ~야.
					lottoManager.printWinningNumbers();
					// 이건 보너스번호
					lottoManager.makeBonusNumber();
					// 3) 따라서, 결과는 몇개 맞았어!
					int resultCount = lottoManager.getLottoResult();

					boolean isCorrectWithBonus = lottoManager.isCorrectWithBonus();

					lottoConsolUI.printResultCount(resultCount); // 당첨개수는 +@개 입니다

					lottoConsolUI.printResult(resultCount, isCorrectWithBonus); // @등 입니다
					isFinished = false;

				}

			} else if (choice == 2) {
				lottoConsolUI.EndLottoProgram();
				break;
			}
		}
	}

}
