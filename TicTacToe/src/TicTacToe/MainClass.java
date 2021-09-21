package TicTacToe;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainClass {
	
	public static String start[] = {"X", "O"};
	public static Integer turn = 0;
	
	public static Boolean gameover = false;
			
	public static void main(String[] args) {
		
		start();
		
	}
	
	public static void start() {
		JFrame frame = new JFrame("TicTacToe");
		frame.setResizable(false);
		frame.setBounds(new Rectangle(615, 620));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setCursor(new Cursor(1));
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(frame.getBounds());
		panel.setBackground(Color.black);
		
		JButton[][] buttons = new JButton[3][3];
		
		create_buttons(buttons);
		add_func(buttons);
		
		for(JButton[] onedimensionbuttons: buttons) {
			for(JButton button : onedimensionbuttons) {
				add_functionality(button);
				panel.add(button);
			}
		}
		
		frame.add(panel);
		frame.setVisible(true);
	}	
	
	public static void create_buttons(JButton[][] buttons) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				JButton button = new JButton("");
				button.setBounds(new Rectangle(200, 200));
				button.setBackground(Color.WHITE);
				
				button.setLocation(new Point(j * 200, i * 200));
				
				buttons[i][j] = button;
			}
		}
	}
	
	public static void add_functionality(JButton button) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button.setEnabled(false);
				button.setText(start[turn].toString());
				button.setFont(new Font("Times New Roman", Font.BOLD, 100));
				button.setForeground(Color.BLACK);
				if(turn == 0) {
					turn = 1; 
				} else {
					turn = 0;
				}
			}
			
		});
	}
	
	public static void add_func(JButton[][] button) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				button[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
							if(button[0][0].getText() == button[0][1].getText() && button[0][1].getText() == button[0][2].getText() && button[0][0].getText() != "" && button[0][1].getText() != "" && button[0][2].getText() != "") {
								gameover = true;
							} else if(button[1][0].getText() == button[1][1].getText() && button[1][1].getText() == button[1][2].getText() && button[1][0].getText() != "" && button[1][1].getText() != "" && button[1][2].getText() != "") {
								gameover = true;
							} else if(button[2][0].getText() == button[2][1].getText() && button[2][1].getText() == button[2][2].getText() && button[2][0].getText() != "" && button[2][1].getText() != "" && button[2][2].getText() != "") {
								gameover = true;
							} else if(button[0][0].getText() == button[1][0].getText() && button[1][0].getText() == button[2][0].getText() && button[0][0].getText() != "" && button[1][0].getText() != "" && button[2][0].getText() != "") {
								gameover = true;
							} else if(button[0][1].getText() == button[1][1].getText() && button[1][1].getText() == button[2][1].getText() && button[0][1].getText() != "" && button[1][1].getText() != "" && button[2][1].getText() != "") {
								gameover = true;
							} else if(button[0][2].getText() == button[1][2].getText() && button[1][2].getText() == button[2][2].getText() && button[0][2].getText() != "" && button[1][2].getText() != "" && button[2][2].getText() != "") {
								gameover = true;
							} else if(button[0][0].getText() == button[1][1].getText() && button[1][1].getText() == button[2][2].getText() && button[0][0].getText() != "" && button[1][1].getText() != "" && button[2][2].getText() != "") {
								gameover = true;
							} else if(button[0][2].getText() == button[1][1].getText() && button[1][1].getText() == button[2][1].getText() && button[2][1].getText() != "" && button[1][1].getText() != "" && button[0][2].getText() != "") {
								gameover = true;
							}
							
							if(gameover) {
								if(turn == 1)	turn = 0;
								else			turn = 1;
								JOptionPane.showMessageDialog(null, start[turn] + " WON THIS GAME\nCONGRATULATIONS!", "CONGRATS", JOptionPane.PLAIN_MESSAGE);
								System.exit(1);
							}

					}
				});
			}
		}
	}
}