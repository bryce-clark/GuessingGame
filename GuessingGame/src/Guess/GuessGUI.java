package Guess;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

@SuppressWarnings("serial")
public class GuessGUI extends JFrame {

	private JPanel contentPane;
	private static JTextField userinput;
	
	JLabel lblguesses, lbltitle;
	static JLabel guesscount;
	static JLabel lblhint;
	JButton btnsubmit, btnreset;
	static int count = 0;
	static int guess = 0;
	static int randomNum;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessGUI frame = new GuessGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		RandomNumber();
	}

	/**
	 * Create the frame.
	 */
	public GuessGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userinput = new JTextField();
		userinput.setBounds(166, 100, 86, 20);
		contentPane.add(userinput);
		userinput.setColumns(10);
		userinput.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    
				  GetGuess();
			  } 
			} );
		
		btnsubmit = new JButton("Submit");
		btnsubmit.setBounds(108, 149, 89, 23);
		contentPane.add(btnsubmit);
		btnsubmit.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    
				  GetGuess();
			  } 
			} );
		
		
		btnreset = new JButton("New Number");
		btnreset.setBounds(224, 149, 112, 23);
		contentPane.add(btnreset);
		btnreset.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) 
			  { 
				    
				    RandomNumber();
				    count = 0;
				    guesscount.setText("0");
				    lblhint.setText("Pick A Number 1 - 100");
				  } 
				} );
		
		lblguesses = new JLabel("Guesses: ");
		lblguesses.setBounds(337, 233, 56, 17);
		contentPane.add(lblguesses);
		
		lbltitle = new JLabel("Guess The Number");
		lbltitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setBounds(68, 21, 280, 37);
		contentPane.add(lbltitle);
		
		lblhint = new JLabel("Pick A Number 1-100");
		lblhint.setHorizontalAlignment(SwingConstants.CENTER);
		lblhint.setBounds(78, 75, 270, 14);
		contentPane.add(lblhint);
		
		guesscount = new JLabel("0");
		guesscount.setHorizontalAlignment(SwingConstants.CENTER);
		guesscount.setBounds(391, 233, 22, 16);
		contentPane.add(guesscount);
	}
	
	public static void RandomNumber()
	{
		Random rand = new Random();
		randomNum = 1 + rand.nextInt(100);
		System.out.println(randomNum);
	}
	
	public static void GetGuess()
	{
		guess = Integer.parseInt(userinput.getText());
		count++;
		userinput.setText("");
		String amount = Integer.toString(count);
		guesscount.setText(amount);
		AnswerCheck();
	}
	
	public static void AnswerCheck()
	{
		if(guess == randomNum)
		{
			lblhint.setText("YOU GUESSED CORRECT");
			
		}
		else if(guess > randomNum)
		{
			lblhint.setText("TRY AGAIN: YOUR GUESS WAS TOO HIGH");
			
		}
		else
		{
			lblhint.setText("TRY AGAIN: YOUR GUESS WAS TOO LOW");
			
		}
	}
}
