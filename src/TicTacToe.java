import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe {


public static void main(String[] args) {
	TicTacToe tictactoe = new TicTacToe();
	//tictactoe.setup();
}
JFrame frame = new JFrame();
JPanel panel = new JPanel();
GridLayout layout = new GridLayout(3,3);

void setup() {
	frame.setSize(500, 500);
	panel.setBackground(Color.gray);
	frame.add(panel);
	layout.setHgap(10);
	layout.setVgap(10);
	panel.setLayout(layout);
	for(int i=0; i<9; i++) {
		JButton button = new JButton();
		button.setBackground(Color.white);
		button.setText("button"+i);
		panel.add(button);
	}
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}
