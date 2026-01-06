import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
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
	public Frame1() {
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
		
		JButton b1 = new JButton("Fetch Employee");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetch f = new fetch();
				f.setVisible(true);
				dispose();
			}
		});
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b1.setBounds(21, 79, 168, 40);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Fetch All Employees");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetchAll fe = new fetchAll();
				fe.setVisible(true);
				dispose();
			}
		});
		b2.setForeground(Color.BLACK);
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b2.setBounds(258, 79, 168, 40);
		contentPane.add(b2);
		
		JButton b3 = new JButton("Add Employee");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ems em = new Ems();
				em.setVisible(true);
				dispose();
			}
		});
		b3.setForeground(Color.BLACK);
		b3.setBackground(Color.LIGHT_GRAY);
		b3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b3.setBounds(21, 145, 168, 40);
		contentPane.add(b3);
		
		JButton b4 = new JButton("Delete Employee");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete dlt = new Delete();
				dlt.setVisible(true);
				dispose();
			}
		});
		b4.setForeground(Color.BLACK);
		b4.setBackground(Color.LIGHT_GRAY);
		b4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b4.setBounds(258, 145, 168, 40);
		contentPane.add(b4);
		
		JButton b5 = new JButton("Update Employee");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upd up = new upd();
				up.setVisible(true);
				dispose();
			}
		});
		b5.setForeground(Color.BLACK);
		b5.setBackground(Color.LIGHT_GRAY);
		b5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b5.setBounds(135, 207, 186, 46);
		contentPane.add(b5);

	}
}
