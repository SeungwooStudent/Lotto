package com.lorro.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lorro.model.LottoManager;

public class LottoUI extends JFrame {
//    private MainProcess main;
//    private TestFrm testFrm;
	private LottoManager lottoManager;
	private LottoConsoleUI lottoConsolUI;
	private JButton btnStart;
	private JButton btnInit;
	private JButton btnExit;
	private JTextField winningText[] = new JTextField[6];
	private JTextField inputText[] = new JTextField[6];
	private JTextField bonusText = new JTextField();
	private JTextField resultText = new JTextField();

	public LottoUI() {
		lottoManager = new LottoManager();
		lottoConsolUI = new LottoConsoleUI();
		// setting
		setTitle("lotto");
		setSize(1080, 720);
		setResizable(false);
		setLocation(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// panel
		JPanel panel = new JPanel();
		placeLoginPanel(panel);

		// add
		add(panel);

		// visiible
		setVisible(true);
	}

	public void placeLoginPanel(JPanel panel) {
		panel.setLayout(null);

		// input numbers
		JLabel inputLabel = new JLabel("Input Numbers");
		inputLabel.setBounds(10, 10, 120, 25);
		panel.add(inputLabel);
		for (int i = 0; i < inputText.length; i++) {
			inputText[i] = new JTextField(2);
			inputText[i].setBounds(i * 50 + 10, 40, 40, 40);
			panel.add(inputText[i]);
		}

		// winning numbers
		JLabel winningLabel = new JLabel("Winning Numbers");
		winningLabel.setBounds(10, 100, 120, 25);
		panel.add(winningLabel);
		for (int i = 0; i < winningText.length; i++) {
			winningText[i] = new JTextField(2);
			winningText[i].setBounds(i * 50 + 10, 130, 40, 40);
			panel.add(winningText[i]);
		}

		// bonus number
		JLabel bonusLabel = new JLabel("Bonus Number");
		bonusLabel.setBounds(10, 190, 120, 25);
		panel.add(bonusLabel);
		bonusText = new JTextField(2);
		bonusText.setBounds(10, 220, 40, 40);
		panel.add(bonusText);

		// result
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setBounds(10, 280, 120, 25);
		panel.add(resultLabel);
		resultText = new JTextField(50);
		resultText.setBounds(10, 310, 500, 40);
		panel.add(resultText);

//        winningText.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

		btnInit = new JButton("Reset");
		btnInit.setBounds(10, 400, 100, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < inputText.length; i++) {
					inputText[i].setText("");
				}
				for (int i = 0; i < winningText.length; i++) {
					winningText[i].setText("");
				}
				bonusText.setText("");
				resultText.setText("");

				lottoManager.init();
			}
		});

		btnStart = new JButton("Start");
		btnStart.setBounds(160, 400, 100, 25);
		panel.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lottoManager.init();
				for (int i = 0; i < inputText.length; i++) {
					lottoManager.addInputNumber(Integer.parseInt(inputText[i].getText()));
				}
				lottoManager.printInputNumbers();
				lottoManager.makesWinningNumbers();

				ArrayList<Integer> numbers = lottoManager.getWinningNumbers();
				for (int i = 0; i < numbers.size(); i++) {
					winningText[i].setText("" + numbers.get(i));
				}

				lottoManager.printWinningNumbers();

				lottoManager.makeBonusNumber();
				int bonusNumber = lottoManager.getBonusNumber();
				bonusText.setText("" + bonusNumber);

				int resultCount = lottoManager.getLottoResult();
				boolean isCorrectWithBonus = lottoManager.isCorrectWithBonus();
				String result = lottoConsolUI.printResultCount(resultCount);
				String ranking = lottoConsolUI.printResult(resultCount, isCorrectWithBonus); // @등 입니다
				resultText.setText("" + result + ranking);

			}
		});

		btnExit = new JButton("Exit");
		btnExit.setBounds(310, 400, 100, 25);
		panel.add(btnExit);

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
