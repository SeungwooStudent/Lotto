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

		boolean isFinished = true;
		while (isFinished) {
			lottoConsolUI.inputnumberDisplay();
			try {
				int inputnum = 0;
				for (int i = 0; i < 6; i++) {					
					inputnum = sc.nextInt();
					lottoManager.addInputNumber(inputnum);
					lottoManager.lottoNumbers(inputnum);
					boolean hasNumber = lottoManager.inputOverlapCheck(inputnum);
					if(hasNumber) {
						lottoConsolUI.overlapNumber();
					}
					isFinished = false;
				}
			} catch (InputMismatchException ime) {
				lottoConsolUI.printInputMistmatchError();
				sc = new Scanner(System.in);
				continue;
			}

			lottoManager.printAll();

			lottoConsolUI.numberEnrollment();

			lottoConsolUI.winningnumber();
			String answer = sc.next();
			isFinished = true;
			if (answer.equals("Y") || answer.equals("y")) {
				lottoManager.winingNumber();
				lottoConsolUI.lottoResultConfirm();
				answer = sc.next();
				if (answer.equals("Y") || answer.equals("y")) {
					lottoManager.lottoResult();
				} else if (answer.equals("N") || answer.equals("n")) {
					lottoConsolUI.endLotto();
					break;
				} else {
					lottoConsolUI.lottoTry();
				}
			} else if (answer.equals("N") || answer.equals("n")) {
				lottoConsolUI.endLotto();
				break;
			} else {
				lottoConsolUI.lottoTry();
			}
		}

	}

}
