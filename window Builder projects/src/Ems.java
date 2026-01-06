import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.*;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Ems extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Heading;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ems frame = new Ems();
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
	public Ems() {
		setForeground(Color.DARK_GRAY);
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Heading = new JPanel();
		Heading.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Heading);
		Heading.setLayout(null);
		
		JLabel h1 = new JLabel(" Employee Management System");
		h1.setForeground(SystemColor.text);
		h1.setOpaque(true);
		h1.setBackground(SystemColor.activeCaptionBorder);
		h1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		h1.setBounds(113, 10, 220, 28);
		Heading.add(h1);
		
		JLabel e1 = new JLabel("   Employee ID :");
		e1.setOpaque(true);		e1.setForeground(Color.WHITE);
		e1.setBackground(Color.GRAY);
		e1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		e1.setBounds(40, 65, 107, 21);
		Heading.add(e1);
		
		t1 = new JTextField();
		t1.setBounds(164, 66, 209, 18);
		Heading.add(t1);
		t1.setColumns(10);
		
		JLabel e2 = new JLabel("  Employee Name :");
		e2.setOpaque(true);
		e2.setBackground(Color.GRAY);
		e2.setForeground(Color.WHITE);
		e2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		e2.setBounds(40, 96, 107, 21);
		Heading.add(e2);
		
		t2 = new JTextField();
		t2.setBounds(164, 97, 209, 18);
		Heading.add(t2);
		t2.setColumns(10);
		
		JLabel e3 = new JLabel("      Department :");
		e3.setBackground(Color.GRAY);
		e3.setForeground(Color.WHITE);
		e3.setOpaque(true);
		e3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		e3.setBounds(40, 127, 107, 21);
		Heading.add(e3);
		
		t3 = new JTextField();
		t3.setBounds(164, 128, 209, 18);
		Heading.add(t3);
		t3.setColumns(10);
		
		JLabel e4 = new JLabel("         Gender :");
		e4.setBackground(Color.GRAY);
		e4.setForeground(Color.WHITE);
		e4.setOpaque(true);
		e4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		e4.setBounds(40, 158, 107, 21);
		Heading.add(e4);
		
		t4 = new JTextField();
		t4.setBounds(163, 159, 210, 18);
		Heading.add(t4);
		t4.setColumns(10);
		
		JLabel e5 = new JLabel("         Salary :");
		e5.setForeground(Color.WHITE);
		e5.setBackground(Color.GRAY);
		e5.setOpaque(true);
		e5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		e5.setBounds(40, 189, 107, 21);
		Heading.add(e5);
		
		t5 = new JTextField();
		t5.setBounds(164, 190, 209, 18);
		Heading.add(t5);
		t5.setColumns(10);
		
		JButton b1 = new JButton("Add Details");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eid = t1.getText();
				String name = t2.getText();
				String dep = t3.getText();
				String gen = t4.getText();
				String sal = t5.getText();
				int id = Integer.parseInt(eid);
				int salary= Integer.parseInt(sal); 
				
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				
				try {
					String sql = "com.mysql.cj.jdbc.Driver";
					String con = "jdbc:mysql://127.0.0.1:3306/ems";
					String root = "root";
					String pass = "roshan";
					String result = "insert into employees values (?,?,?,?,?)";
					Class.forName(sql);
					conn = DriverManager.getConnection(con, root, pass);
					stmt = conn.prepareStatement(result);
					stmt.setInt(1, id);
					stmt.setString(2, name);
					stmt.setString(3, dep);
					stmt.setString(4, gen);
					stmt.setInt(5, salary);
					
					int rows = stmt.executeUpdate();
					
			        if (rows > 0) {
			            JOptionPane.showMessageDialog(
			                    Ems.this,
			                    "Data inserted successfully!",
			                    "Success",
			                    JOptionPane.INFORMATION_MESSAGE
			            );

			            // CLEAR TEXT FIELDS AFTER OK
			            t1.setText("");
			            t2.setText("");
			            t3.setText("");
			            t4.setText("");
			            t5.setText("");
			        }
//					
					
				
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
		b1.setOpaque(true);
		b1.setBackground(Color.ORANGE);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		b1.setBounds(40, 220, 168, 33);
		
		Heading.add(b1);
		
		JButton b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame1 fr = new Frame1();
				fr.setVisible(true);
			}
		});
		b2.setOpaque(true);
		b2.setBackground(Color.ORANGE);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		b2.setBounds(218, 219, 155, 33);
		Heading.add(b2);

	}
}
