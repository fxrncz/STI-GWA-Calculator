package oneSTI;

import java.awt.EventQueue;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private oneSTI.Button addbtn;
	private oneSTI.Button delbtn;
	private oneSTI.Container[] panel;
	private int panelCount = 0;
	
	public MainFrame() {
		super("GWA Calculator");
		initComponents();
		add(new JScrollPane(contentPane));
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 517);
		setResizable(false);
		getContentPane().add(new JScrollPane(contentPane));
		contentPane = new JPanel(null);
		contentPane.setBackground(new Color(255, 255, 255));
		getContentPane().add(contentPane);
		
		addbtn = new oneSTI.Button();
		addbtn.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		
		delbtn = new oneSTI.Button();
		delbtn.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		
		panel = new oneSTI.Container[10];
		panelCount = 0;

		contentPane.add(addbtn);
		addbtn.setBounds(37, 25, 130, 29);
		addbtn.setColor(new Color(0, 126, 167));
		addbtn.setBorderColor(new Color(0, 23, 31));
		addbtn.setForeground(Color.WHITE);
		addbtn.setText("Add Panel");
		addbtn.setFocusable(false);
		addbtn.setRadius(10);
		addbtn.setBorderPainted(false);
		
		addbtn.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				addbtn.setBackground(new Color(14, 121, 178));
				addbtn.setForeground(new Color(251, 254, 249));
				addbtn.setFont(new Font("Lucida Fax", Font.BOLD, 15));
			}
			
			public void mouseExited(MouseEvent e) {
				addbtn.setBackground(Color.WHITE);
				addbtn.setForeground(Color.BLACK);
				addbtn.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
			}
			
			public void mouseClicked(MouseEvent e) {
				addTextField();
			}
			
		});
		
		contentPane.add(delbtn);
		delbtn.setBounds(180, 25, 145, 29);
		delbtn.setColor(new Color(0, 126, 167));
		delbtn.setBorderColor(new Color(0, 23, 31));
		delbtn.setForeground(Color.WHITE);
		delbtn.setText("Delete Panel");
		delbtn.setFocusable(false);
		delbtn.setRadius(10);
		delbtn.setBorderPainted(false);
		
		delbtn.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				delbtn.setBackground(new Color(14, 121, 178));
				delbtn.setForeground(new Color(251, 254, 249));
				delbtn.setFont(new Font("Lucida Fax", Font.BOLD, 15));
			}
			
			public void mouseExited(MouseEvent e) {
				delbtn.setBackground(Color.WHITE);
				delbtn.setForeground(Color.BLACK);
				delbtn.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
			}
			
			public void mouseClicked(MouseEvent e) {
				deleteCurrentPanel();
			}
			
		});

		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	private void deleteCurrentPanel() {
		if (panelCount > 0) {
			panelCount--;
			contentPane.remove(panel[panelCount]);
			contentPane.setPreferredSize(new Dimension(contentPane.getWidth(), 50 + panelCount * 120));
			revalidate();
			repaint();
		} else {
			JOptionPane.showMessageDialog(this, "No panels to delete.");
		}
	}
	
	private void addTextField() {
		
		if (panelCount < panel.length) {
			
			panel[panelCount] = new oneSTI.Container();
			
			oneSTI.Container con = new oneSTI.Container();
			oneSTI.TextField txt1 = new oneSTI.TextField();
			oneSTI.TextField input1 = new oneSTI.TextField();
			oneSTI.TextField input2 = new oneSTI.TextField();
			oneSTI.TextField input3 = new oneSTI.TextField();
			oneSTI.TextField input4 = new oneSTI.TextField();
			oneSTI.Button calculate = new oneSTI.Button();
		    JLabel midterm = new JLabel("MIDTERM");
		    JLabel prefinals = new JLabel("PREFINALS");
			JLabel finals = new JLabel("FINALS");
		    JLabel prelim = new JLabel("PRELIM");
			
			panel[panelCount].setBackground(new Color(241, 241, 241));
	        panel[panelCount].setRoundBotLeft(20);
	        panel[panelCount].setRoundBotRight(20);
	        panel[panelCount].setRoundTopLeft(20);
	        panel[panelCount].setRoundTopRight(20);
			panel[panelCount].setLayout(null);
			JLabel titleset = new JLabel("Title here");;
			JLabel avrg = new JLabel("(GWA)");
			
			
			txt1.setFont(new Font("Roboto", Font.PLAIN, 13));
			txt1.setText("Set Title");
			txt1.setBounds(10, 11, 245, 38);
			txt1.setColumns(10);
			
			titleset.setBounds(260, 10, 245, 38);
			titleset.setFont(new Font("Roboto", 0, 13));
			
			txt1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String op = txt1.getText();
					titleset.setFont(new Font("Roboto", Font.BOLD, 14));
					titleset.setText(op);
				}
				
			});

			avrg.setBounds(480, 10, 245, 38);
			avrg.setFont(new Font("Roboto", 0, 20));
			
			
			con = new oneSTI.Container();
			con.setBackground(new java.awt.Color(51, 102, 255));
			con.setBounds(15, 57, 567, 29);
			con.setRoundBotLeft(10);
			con.setRoundBotRight(10);
			con.setRoundTopLeft(10);
			con.setRoundTopRight(10);
			con.setLayout(null);
			
			prelim = new JLabel("PRELIM");
	        prelim.setBounds(35, -11, 50, 50);
	        prelim.setFont(new Font("Roboto", 0, 13)); 
	        prelim.setForeground(new Color(255, 255, 255));
	        
	        midterm = new JLabel("MIDTERM");
	        midterm.setBounds(160, -11, 60, 50);
	        midterm.setFont(new Font("Roboto", 0, 13)); 
	        midterm.setForeground(new Color(255, 255, 255));
	        
	        prefinals = new JLabel("PREFINALS");
	        prefinals.setBounds(290, -11, 70, 50);
	        prefinals.setFont(new Font("Roboto", 0, 13)); 
	        prefinals.setForeground(new Color(255, 255, 255));
	        
	        finals = new JLabel("FINALS");
	        finals.setBounds(435, -11, 60, 50);
	        finals.setFont(new Font("Roboto", 0, 13)); 
	        finals.setForeground(new Color(255, 255, 255));
	        
	        input1.setFont(new Font("Roboto", Font.PLAIN, 13));
			input1.setText(null);
			input1.setBounds(35, 95, 84, 42);
			input1.setColumns(10);
			
	        input2.setFont(new Font("Roboto", Font.PLAIN, 13));
			input2.setText(null);
			input2.setBounds(160, 95, 84, 42);
			input2.setColumns(10);
			
	        input3.setFont(new Font("Roboto", Font.PLAIN, 13));
			input3.setText(null);
			input3.setBounds(290, 95, 84, 42);
			input3.setColumns(10);
			
	        input4.setFont(new Font("Roboto", Font.PLAIN, 13));
			input4.setText(null);
			input4.setBounds(435, 95, 84, 42);
			input4.setColumns(10);
	        
			calculate.setColor(new Color(0, 126, 167));
			calculate.setBorderColor(new Color(0, 23, 31));
			calculate.setForeground(Color.WHITE);
			calculate.setFont(new Font("Lucida Fax", Font.PLAIN, 13));
			calculate.setBounds(14, 148, 120, 28);
			calculate.setText("Calculate");
			calculate.setFocusable(false);
			calculate.setRadius(10);
			calculate.setBorderPainted(false);
			
			calculate.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						double txtprelim = Double.parseDouble(input1.getText());
						double txtmid = Double.parseDouble(input2.getText());
						double txtprefinal = Double.parseDouble(input3.getText());
						double txtfinals = Double.parseDouble(input4.getText());
						
						float prelimavrg = (float) (txtprelim * .20);
						float midavrg = (float) (txtmid * .20);
						float prefinalavrg = (float) (txtprefinal * .20);
						float finalavrg = (float) (txtfinals * .40);
						
						float gwares = prelimavrg + midavrg + prefinalavrg + finalavrg;
						
						avrg.setText("GWA: (" + gwares + ")");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(MainFrame.this, "Invalid input. Please enter valid numbers.");
					}
				}			
			});
			
			calculate.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent e) {
					calculate.setBackground(Color.WHITE);
					calculate.setForeground(Color.BLACK);
				}
				
				public void mouseExited(MouseEvent e) {
					calculate.setBackground(new Color(0, 126, 167));
					calculate.setForeground(Color.WHITE);
				}
				
				public void mousePressed(MouseEvent e) {
					calculate.setBackground(new Color(0, 178, 255));
				}
				
				public void mouseReleased(MouseEvent e) {
					calculate.setBackground(new Color(0, 37, 53));
					calculate.setForeground(Color.WHITE);
				}
				
				public void mouseClicked(MouseEvent e) {
					try {
						if(e.getSource() == calculate) {
							if(input1.getText().isEmpty() || input2.getText().isEmpty() || input3.getText().isEmpty() || input4.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Please, input information!", "WARNING", JOptionPane.YES_OPTION);
							}
						}
					} catch (Exception ex) {
						ex.getMessage();
					}
				}
			});
			
			panel[panelCount].add(txt1);
		    panel[panelCount].add(titleset);
		    panel[panelCount].add(avrg);
		    panel[panelCount].add(con);
		    con.add(prelim);
		    con.add(midterm);
		    con.add(prefinals);
		    con.add(finals);
		    panel[panelCount].add(input1);
		    panel[panelCount].add(input2);
		    panel[panelCount].add(input3);
		    panel[panelCount].add(input4);
		    panel[panelCount].add(calculate);
		      
		    panel[panelCount].setBounds(37, 75 + panelCount * 225, 630, 185);
		    contentPane.add(panel[panelCount]);
		    panelCount++;
		    contentPane.setPreferredSize(new Dimension(contentPane.getWidth(), 50 + panelCount * 250));

		    revalidate();
		    repaint();
	
		} else {
            JOptionPane.showMessageDialog(this, "Cannot add more panels. Array limit reached.");
        }
		
		
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
	        new MainFrame();
	    });
	}
}
