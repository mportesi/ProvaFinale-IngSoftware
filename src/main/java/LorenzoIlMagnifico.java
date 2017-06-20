import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LorenzoIlMagnifico {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LorenzoIlMagnifico window = new LorenzoIlMagnifico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LorenzoIlMagnifico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/Chiara/Desktop/GB2.png"));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setIcon(new ImageIcon("/Users/Chiara/Desktop/plancina3.png"));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/Chiara/Desktop/punchh.jpg"));
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Value");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setBackground(Color.BLACK);
		
	}

}
