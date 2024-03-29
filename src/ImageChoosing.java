import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageChoosing implements ActionListener{
	
	public static void main(String[] args) {
		ImageChoosing imagechoosing = new ImageChoosing();
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
	
	BufferedImage player1image;
	BufferedImage player2image;
	
	static String player1name;
	static String player2name;
	
	static boolean firstPlay = true;
	
	void setup() {
		if(firstPlay==true) {
		player1name = JOptionPane.showInputDialog("What is the first player's name? This player's color will be red.");
		player2name = JOptionPane.showInputDialog("What is the second player's name? This player's color will be green.");
		}
		firstPlay = false;
		JOptionPane.showMessageDialog(null, "The aim of the game is to get 3 in a row. When it is your turn, click on a button to put your marker there. \n When the background is red, it is "+player1name+"'s turn. When the background is green, it is "+player2name+"'s turn.");
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
	void loadXOImages() {
		try {
	        player1Image("x.png");
	        player2Image("o.png");
		} catch (Exception e) {
	        
	    }
	}
	
	void loadCatDogImages() {
		try {
	        player1Image("cat.jpeg");
	        player2Image("dog.jpg");
		} catch (Exception e) {
	        
	    }
	}
	
	void loadSportsImages() {
		try {
	        player1Image("football.png");
	        player2Image("basketball.jpeg");
		} catch (Exception e) {
	        
	    }
	}
	
	void loadMusicImages() {
		try {
	        player1Image("trumpet.jpg");
	        player2Image("violin.png");
		} catch (Exception e) {
	        
	    }
	}
	
	void player1Image(String fileName) {
		try {
			player1image = ImageIO.read(this.getClass().getResourceAsStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void player2Image(String fileName) {
		try {
			player2image = ImageIO.read(this.getClass().getResourceAsStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(xo)) {
			loadXOImages();
		}
		if(e.getSource().equals(catdog)) {
			loadCatDogImages();
		}
		if(e.getSource().equals(sports)) {
			loadSportsImages();
		}
		if(e.getSource().equals(music)) {
			loadMusicImages();
		}
		SwingUtilities.invokeLater(new TicTacToe(player1image, player2image, player1name, player2name));
	}

}
