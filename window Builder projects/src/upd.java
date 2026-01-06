import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class upd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t3;
	private JTextField t4;
	private JTextField t2;
	private JTextField t5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					upd frame = new upd();
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
	public upd() {
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
		
		JLabel j1 = new JLabel("     New Name :");
		j1.setBackground(Color.LIGHT_GRAY);
		j1.setOpaque(true);
		j1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		j1.setBounds(50, 91, 127, 25);
		contentPane.add(j1);
		
		JLabel j2 = new JLabel("    New Department :");
		j2.setBackground(Color.LIGHT_GRAY);
		j2.setOpaque(true);
		j2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		j2.setBounds(50, 126, 127, 22);
		contentPane.add(j2);
		
		JLabel j3 = new JLabel("     New Gender :");
		j3.setBackground(Color.LIGHT_GRAY);
		j3.setOpaque(true);
		j3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		j3.setBounds(50, 158, 127, 22);
		contentPane.add(j3);
		
		t1 = new JTextField();
		t1.setBounds(187, 91, 216, 25);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(187, 127, 216, 22);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(187, 157, 216, 25);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel j4 = new JLabel("       New Salary :");
		j4.setBackground(Color.LIGHT_GRAY);
		j4.setOpaque(true);
		j4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		j4.setBounds(50, 190, 127, 22);
		contentPane.add(j4);
		
		t4 = new JTextField();
		t4.setBounds(187, 191, 216, 22);
		contentPane.add(t4);
		t4.setColumns(10);
		
		
		
		JButton b1 = new JButton("Update");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = t1.getText();
				String d = t2.getText();
				String g = t3.getText();
				String s = t4.getText();
				int sal = Integer.parseInt(s);
				
				String st = t5.getText();
				int eid = Integer.parseInt(st);
				
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				
				try {
					String sql = "com.mysql.cj.jdbc.Driver";
					String con = "jdbc:mysql://127.0.0.1:3306/ems";
					String root = "root";
					String pass = "roshan";
					String result = "update employees set Employee_name = ?, Department = ?, Gender = ?, salary = ? where Employee_ID = ?";
					Class.forName(sql);
					conn = DriverManager.getConnection(con, root, pass);
					stmt = conn.prepareStatement(result);
					
					stmt.setString(1, n);
					stmt.setString(2, d);
					stmt.setString(3, g);
					stmt.setInt(4, sal);
					stmt.setInt(5, eid);
					
					int rows = stmt.executeUpdate();
					
					if (rows > 0) {   // rows = executeUpdate()
						
						JOptionPane.showMessageDialog(
								upd.this,
			                    
			                    "Data inserted successfully!",
			                    "Success",
			                    JOptionPane.INFORMATION_MESSAGE
			            );
					} else {
						JOptionPane.showMessageDialog(
			                    upd.this,
			                    "Invalid Employee ID!",
			                    "Success",
			                    JOptionPane.INFORMATION_MESSAGE
			            );
					}
					
					t1.setText("");
		            t2.setText("");
		            t3.setText("");
		            t4.setText("");
		            t5.setText("");
					
				
				
				}
				catch (Exception x) {
					x.printStackTrace();
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
				
		
		
				
			}
		});
		b1.setBackground(Color.ORANGE);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		b1.setBounds(61, 222, 152, 31);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame1 fr = new Frame1();
				fr.setVisible(true);
				dispose();
			}
		});
		b2.setBackground(Color.ORANGE);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		b2.setBounds(223, 222, 164, 31);
		contentPane.add(b2);
		
		JLabel j5 = new JLabel("  Enter Employee ID:");
		j5.setOpaque(true);
		j5.setBackground(Color.LIGHT_GRAY);
		j5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		j5.setBounds(50, 60, 127, 21);
		contentPane.add(j5);
		
		t5 = new JTextField();
		t5.setBounds(187, 60, 216, 21);
		contentPane.add(t5);
		t5.setColumns(10);
		
		
		
		

	}
}
