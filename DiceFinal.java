/*********************************
 * Author: Micah L
 * Final Code Dice - CSIS 1410
 **********************************/

package diceFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class DiceFinal extends JFrame 
{
	/**
	 * Private fields for JPanel and text fields
	 */
	private JPanel contentPane;
	private JTextField txtOne;
	private JTextField txtTwo;
	private JTextField txtThree;
	private JTextField txtFour;
	private JTextField txtFive;
	private JTextField txtSix;
	private JTextField txtBatch;
	
	/**
	 * Creating random object for batch roll
	 */
	Random rand = new Random();
	
	/**
	 * Private int fields for counting dice rolls
	 */
	private int uno = 0;
	private int dos = 0;
	private int tres = 0;
	private int quatro = 0;
	private int cinco = 0;
	private int seis = 0;

	/**
	 * Launching the application.
	 */
	public static void main(String[] args) 
	{	
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					DiceFinal frame = new DiceFinal();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creating the frame.
	 */
	public DiceFinal() 
	{
		/**
		 * Method to set up JFrame
		 */
		JCheckBox chckbxBatch = setUpJFrame();
		
		/**
		 * Creation of Buttons - refactoring was not allowed due to ambiguous return value
		 */
		JPanel pnlButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlButtons.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(20);
		pnlButtons.setBackground(Color.BLACK);
		contentPane.add(pnlButtons, BorderLayout.SOUTH);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setOpaque(true);
		btnReset.setBorder(new EmptyBorder(20, 30, 20, 30));
		btnReset.setFont(new Font("Stencil", Font.BOLD, 20));
		pnlButtons.add(btnReset);
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.setBorder(new EmptyBorder(20, 30, 20, 30));
		btnRoll.setOpaque(true);
		btnRoll.setFont(new Font("Stencil", Font.BOLD, 20));
		pnlButtons.add(btnRoll);
		
		/**
		 * Method to create label for dice images
		 */
		JLabel lblDice = createDiceLabel();
		
		/**
		 * Item Listener for "Batch" check box
		 */
		chckbxBatch.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{	
				if(chckbxBatch.isSelected())
				{
					txtBatch.setEnabled(true);
					txtBatch.setEditable(true);
				} else
				{
					txtBatch.setEnabled(false);
					txtBatch.setEditable(false);
				}
			}
		});
		
		/**
		 * Action Listener for "Roll" button
		 */
		btnRoll.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int roll = rand.nextInt(6)+1;
				
				if(chckbxBatch.isSelected())
				{		
					String num = txtBatch.getText();
					int numRoll = Integer.parseInt(num);
					
					/**
					 * For loop to count batch roll and die faces
					 */
					for(int i = 0; i < numRoll; i++)
					{
						int multiRoll = rand.nextInt(6)+1; //would not work if random object was not inside loop
						
						if(multiRoll == 1) 
						{
							uno++;
						}
						if(multiRoll == 2) 
						{
							dos++;
						}
						if(multiRoll == 3) 
						{
							tres++;
						}
						if(multiRoll == 4) 
						{
							quatro++;
						}
						if(multiRoll == 5) 
						{
							cinco++;
						}
						if(multiRoll == 6) 
						{
							seis++;
						}
					}					
					txtOne.setText(String.valueOf(uno));
					txtTwo.setText(String.valueOf(dos));
					txtThree.setText(String.valueOf(tres));
					txtFour.setText(String.valueOf(quatro));
					txtFive.setText(String.valueOf(cinco));
					txtSix.setText(String.valueOf(seis));			
				} else
					{
					if(roll == 1) 
					{
						uno++;
						lblDice.setIcon(new ImageIcon(DiceFinal.class.getResource("/diceFinal/die-black-1.png")));
						txtOne.setText(String.valueOf(uno));
					}
					if(roll == 2) 
					{
						dos++;
						lblDice.setIcon(new ImageIcon(DiceFinal.class.getResource("/diceFinal/die-black-2.png")));
						txtTwo.setText(String.valueOf(dos));
					}
					if(roll == 3) 
					{
						tres++;
						lblDice.setIcon(new ImageIcon(DiceFinal.class.getResource("/diceFinal/die-black-3.png")));
						txtThree.setText(String.valueOf(tres));
					}
					if(roll == 4) 
					{
						quatro++;
						lblDice.setIcon(new ImageIcon(DiceFinal.class.getResource("/diceFinal/die-black-4.png")));
						txtFour.setText(String.valueOf(quatro));
					}
					if(roll == 5) 
					{
						cinco++;
						lblDice.setIcon(new ImageIcon(DiceFinal.class.getResource("/diceFinal/die-black-5.png")));
						txtFive.setText(String.valueOf(cinco));
					}
					if(roll == 6) 
					{
						seis++;
						lblDice.setIcon(new ImageIcon(DiceFinal.class.getResource("/diceFinal/die-black-6.png")));
						txtSix.setText(String.valueOf(seis));	
					}
				}	
			}
		});
		
		/**
		 * Action Listener for "Reset" button - sets everything back to default value
		 */
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				txtOne.setText(String.valueOf("0"));
				txtTwo.setText(String.valueOf("0"));
				txtThree.setText(String.valueOf("0"));
				txtFour.setText(String.valueOf("0"));
				txtFive.setText(String.valueOf("0"));
				txtSix.setText(String.valueOf("0"));
				
				txtBatch.setEnabled(false);
				txtBatch.setEditable(false);
				txtBatch.setText("100");
				
				lblDice.setIcon(new ImageIcon(DiceFinal.class.getResource("/diceFinal/bunch-of-dice.png")));
				chckbxBatch.setSelected(false);			
			}
		});
	}
	
	/**
	 * Creating the dice images label
	 * @return
	 */
	private JLabel createDiceLabel() {
		JLabel lblDice = new JLabel("");
		lblDice.setBorder(null);
		lblDice.setOpaque(true);
		lblDice.setBackground(Color.BLACK);
		lblDice.setHorizontalAlignment(SwingConstants.CENTER);
		lblDice.setIcon(new ImageIcon(DiceFinal.class.getResource("/diceFinal/bunch-of-dice.png")));
		contentPane.add(lblDice, BorderLayout.CENTER);
		return lblDice;
	}
	
	/**
	 * Setting up the frame
	 * @return
	 */
	private JCheckBox setUpJFrame() {
		setTitle("Dice Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblDiceStatistics = new JLabel("Dice Statistics");
		lblDiceStatistics.setBorder(new EmptyBorder(10, 0, 0, 0));
		lblDiceStatistics.setAlignmentY(Component.TOP_ALIGNMENT);
		lblDiceStatistics.setOpaque(true);
		lblDiceStatistics.setBackground(Color.BLACK);
		lblDiceStatistics.setForeground(Color.WHITE);
		lblDiceStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceStatistics.setFont(new Font("Stencil", Font.BOLD, 45));
		lblDiceStatistics.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(lblDiceStatistics, BorderLayout.NORTH);
		
		JPanel pnlRolls = new JPanel();
		pnlRolls.setBorder(null);
		pnlRolls.setMinimumSize(new Dimension(350, 500));
		pnlRolls.setBackground(Color.BLACK);
		contentPane.add(pnlRolls, BorderLayout.WEST);
		GridBagLayout gbl_pnlRolls = new GridBagLayout();
		gbl_pnlRolls.columnWidths = new int[] {120, 110, 0};
		gbl_pnlRolls.rowHeights = new int[]{57, 57, 57, 57, 57, 57, 57, 0};
		gbl_pnlRolls.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlRolls.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlRolls.setLayout(gbl_pnlRolls);
		
		JLabel lblOne = new JLabel("1");
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setFont(new Font("Stencil", Font.BOLD, 30));
		lblOne.setForeground(Color.WHITE);
		lblOne.setBackground(Color.BLACK);
		GridBagConstraints gbc_lblOne = new GridBagConstraints();
		gbc_lblOne.fill = GridBagConstraints.BOTH;
		gbc_lblOne.insets = new Insets(0, 0, 5, 5);
		gbc_lblOne.gridx = 0;
		gbc_lblOne.gridy = 0;
		pnlRolls.add(lblOne, gbc_lblOne);
		
		txtOne = new JTextField();
		txtOne.setEditable(false);
		txtOne.setHorizontalAlignment(SwingConstants.CENTER);
		txtOne.setText("0");
		txtOne.setFont(new Font("Stencil", Font.BOLD, 20));
		GridBagConstraints gbc_txtOne = new GridBagConstraints();
		gbc_txtOne.gridwidth = 0;
		gbc_txtOne.fill = GridBagConstraints.BOTH;
		gbc_txtOne.insets = new Insets(0, 0, 5, 0);
		gbc_txtOne.gridx = 1;
		gbc_txtOne.gridy = 0;
		pnlRolls.add(txtOne, gbc_txtOne);
		txtOne.setColumns(10);
		
		JLabel lblTwo = new JLabel("2");
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwo.setFont(new Font("Stencil", Font.BOLD, 30));
		lblTwo.setForeground(Color.WHITE);
		lblTwo.setBackground(Color.BLACK);
		GridBagConstraints gbc_lblTwo = new GridBagConstraints();
		gbc_lblTwo.fill = GridBagConstraints.BOTH;
		gbc_lblTwo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTwo.gridx = 0;
		gbc_lblTwo.gridy = 1;
		pnlRolls.add(lblTwo, gbc_lblTwo);
		
		txtTwo = new JTextField();
		txtTwo.setEditable(false);
		txtTwo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTwo.setText("0");
		txtTwo.setFont(new Font("Stencil", Font.BOLD, 20));
		GridBagConstraints gbc_txtTwo = new GridBagConstraints();
		gbc_txtTwo.fill = GridBagConstraints.BOTH;
		gbc_txtTwo.insets = new Insets(0, 0, 5, 0);
		gbc_txtTwo.gridx = 1;
		gbc_txtTwo.gridy = 1;
		pnlRolls.add(txtTwo, gbc_txtTwo);
		txtTwo.setColumns(10);
		
		JLabel lblThree = new JLabel("3");
		lblThree.setHorizontalAlignment(SwingConstants.CENTER);
		lblThree.setForeground(Color.WHITE);
		lblThree.setFont(new Font("Stencil", Font.BOLD, 30));
		GridBagConstraints gbc_lblThree = new GridBagConstraints();
		gbc_lblThree.fill = GridBagConstraints.BOTH;
		gbc_lblThree.insets = new Insets(0, 0, 5, 5);
		gbc_lblThree.gridx = 0;
		gbc_lblThree.gridy = 2;
		pnlRolls.add(lblThree, gbc_lblThree);
		
		txtThree = new JTextField();
		txtThree.setEditable(false);
		txtThree.setHorizontalAlignment(SwingConstants.CENTER);
		txtThree.setText("0");
		txtThree.setFont(new Font("Stencil", Font.BOLD, 20));
		GridBagConstraints gbc_txtThree = new GridBagConstraints();
		gbc_txtThree.fill = GridBagConstraints.BOTH;
		gbc_txtThree.insets = new Insets(0, 0, 5, 0);
		gbc_txtThree.gridx = 1;
		gbc_txtThree.gridy = 2;
		pnlRolls.add(txtThree, gbc_txtThree);
		txtThree.setColumns(10);
		
		JLabel lblFour = new JLabel("4");
		lblFour.setFont(new Font("Stencil", Font.BOLD, 30));
		lblFour.setHorizontalAlignment(SwingConstants.CENTER);
		lblFour.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblFour = new GridBagConstraints();
		gbc_lblFour.fill = GridBagConstraints.BOTH;
		gbc_lblFour.insets = new Insets(0, 0, 5, 5);
		gbc_lblFour.gridx = 0;
		gbc_lblFour.gridy = 3;
		pnlRolls.add(lblFour, gbc_lblFour);
		
		txtFour = new JTextField();
		txtFour.setEditable(false);
		txtFour.setHorizontalAlignment(SwingConstants.CENTER);
		txtFour.setText("0");
		txtFour.setFont(new Font("Stencil", Font.BOLD, 20));
		GridBagConstraints gbc_txtFour = new GridBagConstraints();
		gbc_txtFour.fill = GridBagConstraints.BOTH;
		gbc_txtFour.insets = new Insets(0, 0, 5, 0);
		gbc_txtFour.gridx = 1;
		gbc_txtFour.gridy = 3;
		pnlRolls.add(txtFour, gbc_txtFour);
		txtFour.setColumns(10);
		
		JLabel lblFive = new JLabel("5");
		lblFive.setForeground(Color.WHITE);
		lblFive.setFont(new Font("Stencil", Font.BOLD, 30));
		lblFive.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblFive = new GridBagConstraints();
		gbc_lblFive.fill = GridBagConstraints.BOTH;
		gbc_lblFive.insets = new Insets(0, 0, 5, 5);
		gbc_lblFive.gridx = 0;
		gbc_lblFive.gridy = 4;
		pnlRolls.add(lblFive, gbc_lblFive);
		
		txtFive = new JTextField();
		txtFive.setEditable(false);
		txtFive.setHorizontalAlignment(SwingConstants.CENTER);
		txtFive.setText("0");
		txtFive.setFont(new Font("Stencil", Font.BOLD, 20));
		GridBagConstraints gbc_txtFive = new GridBagConstraints();
		gbc_txtFive.fill = GridBagConstraints.BOTH;
		gbc_txtFive.insets = new Insets(0, 0, 5, 0);
		gbc_txtFive.gridx = 1;
		gbc_txtFive.gridy = 4;
		pnlRolls.add(txtFive, gbc_txtFive);
		txtFive.setColumns(10);
		
		JLabel lblSix = new JLabel("6");
		lblSix.setForeground(Color.WHITE);
		lblSix.setFont(new Font("Stencil", Font.BOLD, 30));
		lblSix.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSix = new GridBagConstraints();
		gbc_lblSix.fill = GridBagConstraints.BOTH;
		gbc_lblSix.insets = new Insets(0, 0, 5, 5);
		gbc_lblSix.gridx = 0;
		gbc_lblSix.gridy = 5;
		pnlRolls.add(lblSix, gbc_lblSix);
		
		txtSix = new JTextField();
		txtSix.setEditable(false);
		txtSix.setHorizontalAlignment(SwingConstants.CENTER);
		txtSix.setText("0");
		txtSix.setFont(new Font("Stencil", Font.BOLD, 20));
		GridBagConstraints gbc_txtSix = new GridBagConstraints();
		gbc_txtSix.fill = GridBagConstraints.BOTH;
		gbc_txtSix.insets = new Insets(0, 0, 5, 0);
		gbc_txtSix.gridx = 1;
		gbc_txtSix.gridy = 5;
		pnlRolls.add(txtSix, gbc_txtSix);
		txtSix.setColumns(10);
		
		JCheckBox chckbxBatch = new JCheckBox("Batch");
		chckbxBatch.setBackground(Color.BLACK);
		chckbxBatch.setOpaque(true);
		chckbxBatch.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxBatch.setForeground(Color.WHITE);
		chckbxBatch.setFont(new Font("Stencil", Font.PLAIN, 15));
		GridBagConstraints gbc_chckbxBatch = new GridBagConstraints();
		gbc_chckbxBatch.fill = GridBagConstraints.BOTH;
		gbc_chckbxBatch.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxBatch.gridx = 0;
		gbc_chckbxBatch.gridy = 6;
		pnlRolls.add(chckbxBatch, gbc_chckbxBatch);
		
		txtBatch = new JTextField();
		txtBatch.setHorizontalAlignment(SwingConstants.CENTER);
		txtBatch.setEnabled(false);
		txtBatch.setEditable(false);
		txtBatch.setText("100");
		txtBatch.setFont(new Font("Stencil", Font.BOLD, 20));
		GridBagConstraints gbc_txtBatch = new GridBagConstraints();
		gbc_txtBatch.fill = GridBagConstraints.BOTH;
		gbc_txtBatch.gridx = 1;
		gbc_txtBatch.gridy = 6;
		pnlRolls.add(txtBatch, gbc_txtBatch);
		txtBatch.setColumns(10);
		return chckbxBatch;
	}
}