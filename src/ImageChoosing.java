import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImageChoosing implements ActionListener{
	
	public static void main(String[] args) {
		ImageChoosing imagechoosing = new ImageChoosing();
		String player1 = JOptionPane.showInputDialog("What is the first player's name? This player's color will be red.");
		String player2 = JOptionPane.showInputDialog("What is the second player's name? This player's color will be green.");	
		imagechoosing.setup();
	}
	
	int image;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	GridLayout layout = new GridLayout(2,2);
	JButton xo = new JButton();
	JButton catdog = new JButton();
	JButton sports = new JButton();
	JButton music = new JButton();
	
	void setup() {
		frame.setSize(500, 500);
		panel.setBackground(Color.gray);
		frame.add(panel);
		layout.setHgap(10);
		layout.setVgap(10);
		panel.setLayout(layout);
		panel.add(xo);
		panel.add(catdog);
		panel.add(sports);
		panel.add(music);
		xo.setText("X vs O");
		xo.addActionListener(this);
		catdog.setText("Cat vs Dog");
		catdog.addActionListener(this);
		sports.setText("Football vs Basketball");
		sports.addActionListener(this);
		music.setText("Violin vs Trumpet");
		music.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void getxoimages() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(xo)) {
			System.out.println("xo");
			image = TicTacToe.XO;
		}
		if(e.getSource().equals(catdog)) {
			System.out.println("catDog");
			image = TicTacToe.CATDOG;
		}
		if(e.getSource().equals(sports)) {
			System.out.println("sports");
			image = TicTacToe.SPORTS;
		}
		if(e.getSource().equals(music)) {
			System.out.println("music");
			image = TicTacToe.MUSIC;
		}
		new TicTacToe(image).setup();
	}
	

}
