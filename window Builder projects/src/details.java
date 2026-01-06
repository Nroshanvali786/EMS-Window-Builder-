import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class details extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details frame = new details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public details(String rq) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel h1 = new JLabel(" Employee Management System");
		h1.setForeground(SystemColor.text);
		h1.setOpaque(true);
		h1.setBackground(Color.GRAY);
		h1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		h1.setBounds(113, 10, 220, 40);
		contentPane.add(h1);
		
		JTextArea ta = new JTextArea();
		
		ta.setFont(new Font("Monospaced", Font.BOLD, 15));
		ta.setBounds(49, 86, 365, 107);
		String[] str = rq.split(" ");
		ta.setText("");
		ta.append("Employee ID: " + str[0] + "\n");
		ta.append("Employee Name: " + str[1] + "\n");
		ta.append("Employee Department: " + str[2] + "\n");
		ta.append("Employee Gender: " + str[3] + "\n");
		ta.append("Employee Salary: " + str[4]);
		contentPane.add(ta);
		
		JButton btn = new JButton("Back");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetch fe = new fetch();
				fe.setVisible(true);
				dispose();
			}
		});
		btn.setBackground(Color.ORANGE);
		btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn.setBounds(160, 217, 128, 36);
		contentPane.add(btn);

	}

}
