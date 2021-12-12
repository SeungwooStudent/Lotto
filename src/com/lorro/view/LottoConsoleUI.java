package com.lorro.view;

public class LottoConsoleUI {

	public void inputnumberDisplay() {
		System.out.println("Lotto 프로그램이 시작되었습니다");
		System.out.println("45이하의 원하시는 번호 6개를 입력하세요");
	}

	public void numberEnrollment() {
		System.out.println("등록되었습니다\n");
	}

	public void winningnumber() {
		System.out.println("당첨번호를 확인하시겠습니까? Y / N");
	}

	public void endLotto() {
		System.out.println("다음번에 꼭 확인해주세요!");
	}

	public void lottoResultConfirm() {
		System.out.println("\n당첨결과를 확인하시겠습니까? Y / N");
	}

	public void firstPlace() {
		System.out.println("1등 입니다 축하드립니다");
	}

	public void secondPlace() {
		System.out.println("2등 입니다 축하드립니다");
	}

	public void thirdPlace() {
		System.out.println("3등 입니다 축하드립니다");
	}

	public void notPlace() {
		System.out.println("아쉽지만 꽝 입니다\n");
	}

	public void continueLotto() {
		System.out.println("다시 시도 하시겠습니까?");
	}

	public void printInputMistmatchError() {
		System.out.println("반드시 숫자를 입력해주세요\n");
	}

	public void lottoTry() {
		System.out.println("잘못 입력하셨습니다 다시 시도해주세요");
	}

	public void overlapNumber() {
		System.out.println("중복된 값 입니다 다시 입력해주세요");
	}

	public void lottoLimit() {
		System.out.println("1이상 45이하의 숫자만 입력해주세요");
	}

	public void printResultCount(int count) {
		System.out.println("당첨 갯수는 : " + count + "개 입니다!!");
	}

	public void printResult(int count, boolean isCorrectWithBonus) {
		// 3개 맞으면 5등, 4개->4등 5->3등 6개 -> 1등
		if (count == 3) {
			System.out.println("5등 입니다");
		} else if (count == 4) {
			System.out.println("4등 입니다");
		} else if (count == 5 && !isCorrectWithBonus) {
			System.out.println("3등 입니다");
		} else if (count == 5 && isCorrectWithBonus) {
			System.out.println("2등 입니다");
		} else if (count == 6) {
			System.out.println("1등 입니다");
		} else if (count <= 2) {
			System.out.println("꽝입니다. ");
		}
	}
}
