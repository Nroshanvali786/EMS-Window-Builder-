import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class fetchAll extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fetchAll frame = new fetchAll();
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
	public fetchAll() {
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
		
		String sql = "select * from employees";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textArea.setText("");
		textArea.setBounds(52, 78, 357, 132);
		contentPane.add(textArea);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems","root", "roshan");
			
			
			stmt = conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				textArea.append(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getInt(5) + "\n");
			}
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if(conn!=null) conn.close();
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();
			}
			catch (Exception y) {
				y.printStackTrace();
			}
		}
		
		
		
		JButton btn = new JButton("Back");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame1 fr = new Frame1();
				fr.setVisible(true);
				dispose();
			}
		});
		btn.setBackground(Color.ORANGE);
		btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn.setBounds(172, 220, 122, 33);
		contentPane.add(btn);

	}

}
