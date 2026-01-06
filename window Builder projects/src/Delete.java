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

public class Delete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
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
		
		JLabel lblNewLabel = new JLabel("    Enter Employee ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 82, 153, 33);
		contentPane.add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(202, 82, 184, 33);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton b1 = new JButton("Delete");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				
				int eid = Integer.parseInt(id);
				
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				
				try {
					String sql = "com.mysql.cj.jdbc.Driver";
					String con = "jdbc:mysql://127.0.0.1:3306/ems";
					String root = "root";
					String pass = "roshan";
					String result = "Delete from employees where Employee_ID = ?";
					Class.forName(sql);
					conn = DriverManager.getConnection(con, root, pass);
					stmt = conn.prepareStatement(result);
					stmt.setInt(1, eid);
					
					int rows = stmt.executeUpdate();
					
			        if (rows > 0) {
			            JOptionPane.showMessageDialog(
			                    Delete.this,
			                    "Employee Deleted successfully!",
			                    "Success",
			                    JOptionPane.INFORMATION_MESSAGE
			            );

			            // CLEAR TEXT FIELDS AFTER OK
			            t1.setText("");
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
		b1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b1.setBounds(143, 143, 153, 33);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame1 fr = new Frame1();
				fr.setVisible(true);
				dispose();
			}
		});
		b2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b2.setBounds(143, 199, 153, 33);
		contentPane.add(b2);

	}

}
