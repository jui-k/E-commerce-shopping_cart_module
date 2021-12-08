import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame implements ActionListener
{
JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8;
JTextField tf1, tf2, tf5, tf6, tf7;
JButton btn1, btn2;
JPasswordField p1, p2;


Registration()  {
		setVisible(true);
		setSize(700, 700);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registration Form");
	
		lab1 = new JLabel("Registration Form");
		lab1.setForeground(Color.blue);
		lab1.setFont(new Font("Serif", Font.BOLD, 20));
		lab2 = new JLabel("Name:");
		lab3 = new JLabel("Email-ID:");
		lab4 = new JLabel("Create Passowrd:");
		lab5 = new JLabel("Confirm Password:");
		lab6 = new JLabel("Country:");
		lab7 = new JLabel("State:");
		lab8 = new JLabel("Phone No:");
		tf1 = new JTextField();
		tf2 = new JTextField();
		p1 = new JPasswordField();
		p2 = new JPasswordField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		tf7 = new JTextField();

		btn1 = new JButton("Submit");
		btn2 = new JButton("Clear");

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		lab1.setBounds(100, 30, 400, 30);
		lab2.setBounds(80, 70, 200, 30);
		lab3.setBounds(80, 110, 200, 30);
		lab4.setBounds(80, 150, 200, 30);
		lab5.setBounds(80, 190, 200, 30);
		lab6.setBounds(80, 230, 200, 30);
		lab7.setBounds(80, 270, 200, 30);
		lab8.setBounds(80, 310, 200, 30);
		tf1.setBounds(300, 70, 200, 30);
		tf2.setBounds(300, 110, 200, 30);
		p1.setBounds(300, 150, 200, 30);
		p2.setBounds(300, 190, 200, 30);
		tf5.setBounds(300, 230, 200, 30);
		tf6.setBounds(300, 270, 200, 30);
		tf7.setBounds(300, 310, 200, 30);
		btn1.setBounds(50, 350, 100, 30);
		btn2.setBounds(170, 350, 100, 30);

		add(lab1);
		add(lab2);
		add(tf1);
		add(lab3);
		add(tf2);
		add(lab4);
		add(p1);
		add(lab5);
		add(p2);
		add(lab6);
		add(tf5);
		add(lab7);
		add(tf6);
		add(lab8);
		add(tf7);
		add(btn1);
		add(btn2);
}

public void actionPerformed(ActionEvent e) {
	if (e.getSource() == btn1)
	{
	int x = 0;
	String s1 = tf1.getText();
	String s2 = tf2.getText();

	char[] s3 = p1.getPassword();
	char[] s4 = p2.getPassword();
	String s8 = new String(s3);
	String s9 = new String(s4);

	String s5 = tf5.getText();
	String s6 = tf6.getText();
	String s7 = tf7.getText();
		if (s8.equals(s9))
		{
			try
			{

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","");
			PreparedStatement ps = con.prepareStatement("insert into test1 values(?,?,?,?,?,?)");
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s8);
			ps.setString(4, s5);
			ps.setString(5, s6);
			ps.setString(6, s7);
			int i = ps.executeUpdate();
			x++;
			if (x > 0)
			{
			JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
			Login login = new Login();
			}
	}
			catch (Exception ex)
			{
			System.out.println(ex);
			}
		}
		else
		{
		JOptionPane.showMessageDialog(btn1, "Data not Saved");
		}
	}
	
	else {
	tf1.setText("");
	tf2.setText("");
	p1.setText("");
	p2.setText("");
	tf5.setText("");
	tf6.setText("");
	tf7.setText("");
	}
}


public static void main(String args[]) {
new Registration();
	}
}

