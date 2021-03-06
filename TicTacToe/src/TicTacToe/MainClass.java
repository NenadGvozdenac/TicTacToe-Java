package TicTacToe;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		panel.setBackground(Color.gray);
		
		JButton[][] buttons = new JButton[3][3];
		
		create_buttons(buttons);
		add_functionality(buttons);
		
		for(JButton[] onedimensionbuttons: buttons) {
			for(JButton button : onedimensionbuttons) {
				add_text_to_buttons(button);
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
	
	public static void add_text_to_buttons(JButton button) {
		
		button.setFont(new Font("Arial", Font.BOLD, 100));
		button.setForeground(Color.BLACK);
		
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(button.isEnabled()) {
					button.setEnabled(false);
					button.setText(start[turn].toString());
					if(turn == 0) {
						turn = 1; 
					} else {
						turn = 0;
					}
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(button.isEnabled()) {
					button.setText(start[turn].toString());
					button.setBackground(new Color(204, 255, 204));
				} else {
					button.setBackground(new Color(255, 80, 80));
				}
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(button.isEnabled()) {
					button.setText("");
				}
				button.setBackground(Color.white);
				
			}
			
		});
		
	}
	
	public static void add_functionality(JButton[][] button) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				button[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
							int popunjen = 0;
						
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
							} else if(button[0][2].getText() == button[1][1].getText() && button[1][1].getText() == button[2][0].getText() && button[2][0].getText() != "" && button[1][1].getText() != "" && button[0][2].getText() != "") {
								gameover = true;
							}
							
							for(int i = 0; i < 3; i++) {
								for(int j = 0; j < 3; j++) {
									if(button[i][j].getText() != "")
										popunjen += 1;
								}
							}
							
							if(gameover) {
								JOptionPane.showMessageDialog(null, start[turn] + " WON THIS GAME\nCONGRATULATIONS!\nMADE BY NENAD GVOZDENAC, FTN 2021", "CONGRATS", JOptionPane.PLAIN_MESSAGE);
								System.exit(1);
							}
							
							if(popunjen == 9) {
								JOptionPane.showMessageDialog(null, "THERE WERE NO WINNERS THIS ROUND!\nMADE BY NENAD GVOZDENAC, FTN 2021", "NO WINNERS", JOptionPane.PLAIN_MESSAGE); 
								System.exit(1);
							}
							
							popunjen = 0;

					}
				});
			}
		}
	}
}
