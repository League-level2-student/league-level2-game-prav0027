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

public class TicTacToe implements MouseListener{

static final int XO = 0;
static final int CATDOG = 1;
static final int SPORTS = 2;
static final int MUSIC = 3;
	
ArrayList<BufferedImage> player1images = new ArrayList<BufferedImage>();
ArrayList<BufferedImage> player2images = new ArrayList<BufferedImage>();

JFrame frame = new JFrame();
JPanel panel = new JPanel();
GridLayout layout = new GridLayout(3,3);
JButton [] buttons = new JButton[9];

int imageselection;
int turn = 0;
int playerturn = 0;

public TicTacToe(int image) {
	imageselection = image;
	loadImages();
}
void setup() {
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

void loadImages() {
	try {
        BufferedImage image = ImageIO.read(this.getClass().getResourceAsStream("x.png"));
        player1images.add(image);
        image = ImageIO.read(this.getClass().getResourceAsStream("o.png"));
        player2images.add(image);
	} catch (Exception e) {
        
    }
}

int convertXYtoIndex(int x, int y) {
//	if(x>10 && x<160)
	return 0;
	
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(turn%2 == 0) {
		panel.setBackground(Color.red);
		playerturn = 0;
	}
	else if(turn%2==1) {
		panel.setBackground(Color.green);
		playerturn = 1;
	}
	ImageIcon icon = new ImageIcon(player1images.get(imageselection));
	if(playerturn == 0) {
		buttons[convertXYtoIndex(e.getX(), e.getY())].setIcon(icon);
	}
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


}
