package com.lorro.contoller;

import java.util.Scanner;

import com.lorro.model.LottoManager;
import com.lorro.view.LottoConsoleUI;

public class LottoController {
	public void startLotto() {
		LottoConsoleUI lottoConsolUI = new LottoConsoleUI();
		LottoManager lottoManager = new LottoManager();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			lottoConsolUI.inputnumberDisplay();
			for(int i = 0; i < 6; i++) {
				int num = sc.nextInt();
				lottoManager.addInputNumber(num);
			}
			
		}
	}

}
