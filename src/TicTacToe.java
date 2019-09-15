import java.applet.AudioClip;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe implements MouseListener, Runnable {

	BufferedImage player1image;
	BufferedImage player2image;
	String player1name;
	String player2name;
	String clapping = "clap3.wav";
	AudioClip sound;

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	GridLayout layout = new GridLayout(3, 3);
	JButton[] buttons = new JButton[9];

	int[] turns = new int[9];

	int imageselection;
	int turn = 0;
	int playerturn = 0;
	int whowon;

	public TicTacToe(BufferedImage player1image, BufferedImage player2image, String player1name, String player2name) {
		this.player1image = player1image;
		this.player2image = player2image;
		this.player1name = player1name;
		this.player2name = player2name;
	}

	int getButtonIndex(JButton button) {
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == button) {
				return i;
			}
		}
		return -1;
	}

	private void playSound(String fileName) {
		sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ImageIcon icon;
		JButton button = (JButton) e.getSource();
		int index = getButtonIndex(button);

		if (turn % 2 == 0) {
			panel.setBackground(Color.green);
			icon = new ImageIcon(player1image);
			turns[index] = 1;
		} else {
			panel.setBackground(Color.red);
			icon = new ImageIcon(player2image);
			turns[index] = 2;
		}
		button.setIcon(icon);
		turn++;
		whowon = TicTacToeRules.checkForWinner(turns);
		if (whowon > 0) {
			if (whowon == 1) {
				JOptionPane.showMessageDialog(null, "Congratulations! " + player1name + " won!!!");
			} else {
				JOptionPane.showMessageDialog(null, "Congratulations! " + player2name + " won!!!");
			}
			playSound(clapping);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		frame.setSize(510, 510);
		panel.setBackground(Color.red);
		frame.add(panel);
		layout.setHgap(10);
		layout.setVgap(10);
		panel.setLayout(layout);
		for (int i = 0; i < 9; i++) {
			JButton button = new JButton();
			button.setBackground(Color.white);
			button.addMouseListener(this);
			buttons[i] = button;
			panel.add(button);
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
