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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToe implements MouseListener, Runnable{


BufferedImage player1image;
BufferedImage player2image;

JFrame frame = new JFrame();
JPanel panel = new JPanel();
GridLayout layout = new GridLayout(3,3);
JButton [] buttons = new JButton[9];

int imageselection;
int turn = 0;
int playerturn = 0;

public TicTacToe(BufferedImage player1image, BufferedImage player2image) {
	this.player1image = player1image;
	this.player2image = player2image;
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	ImageIcon icon;
	System.out.println(turn);
	if(turn%2 == 0) {
		panel.setBackground(Color.green);
		playerturn = 0;
		icon = new ImageIcon(player1image);
	}
	else {
		panel.setBackground(Color.red);
		playerturn = 1;
		icon = new ImageIcon(player2image);
	}
	JButton button = (JButton)e.getSource();
	button.setIcon(icon);
	turn++;}
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
	for(int i=0; i<9; i++) {
		JButton button = new JButton();
		button.setBackground(Color.white);
		button.addMouseListener(this);
		buttons[i]=button;
		//button.setText("button"+i);
		panel.add(button);
	}
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


}
