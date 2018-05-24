package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import utils.PrintHandlerUtils;
import utils.Validator;
import data.PaddingData;

import javax.swing.UIManager;

public class GuiMain extends JFrame implements KeyListener{

	private static final String BUG_LINK = "http://www.wildcrest.com/Software/J2PrinterWorks/documentation/J2TextPrinterProblems.html";
	/**
	 * 
	 */
	private static final long serialVersionUID = -2340627578940684863L;
	private JPanel contentPane;
    private JTextPane inputTextArea;
    private JTextPane outPutTextArea;
    private JLabel lblLeftPadding;
    private JLabel lblRightPadding;
    private JLabel lblTopPadding;
    private JLabel lblBottomPadding;
    private JTextField lpTx;
    private JTextField rpTx;
    private JTextField tpTx;
    private JTextField bpTx;
    private JLabel lblInput;
    private JLabel lblOutput;
    private JTextField bugLinkTextField;
    
    private boolean processed = false;
    private boolean errorEncountered = false;
    PaddingData mPaddingData;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain frame = new GuiMain();
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
	public GuiMain() {
		
		mPaddingData = new PaddingData();
		
		setTitle("Inbox your header text just like mysql or command line tool does with the header");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInputTextTo = new JLabel("Input Text to be inboxed like Command Line does");
		lblInputTextTo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblInputTextTo.setBounds(26, 24, 332, 31);
		contentPane.add(lblInputTextTo);
		
		inputTextArea = new JTextPane();
		JScrollPane  scrollPaneInput = new JScrollPane(inputTextArea);
		scrollPaneInput.setBounds(26, 141, 807, 70);
		contentPane.add(scrollPaneInput);
		
		outPutTextArea = new JTextPane();
		outPutTextArea.setMargin(new Insets(0, 1, 0, 1));
		JScrollPane  scrollPane= new JScrollPane(outPutTextArea);
		scrollPane.setBounds(26, 241, 807, 107);
		contentPane.add(scrollPane);
		
		JButton btnInbox = new JButton("In-Box");
		btnInbox.setBounds(323, 29, 86, 23);
		contentPane.add(btnInbox);
		
		lblLeftPadding = new JLabel("left Padding");
		lblLeftPadding.setBounds(26, 68, 89, 14);
		contentPane.add(lblLeftPadding);
		
		lblRightPadding = new JLabel("Right Padding");
		lblRightPadding.setBounds(26, 93, 110, 14);
		contentPane.add(lblRightPadding);
		
		lblTopPadding = new JLabel("Top Padding");
		lblTopPadding.setBounds(242, 66, 76, 14);
		contentPane.add(lblTopPadding);
		
		lblBottomPadding = new JLabel("Bottom Padding");
		lblBottomPadding.setBounds(242, 93, 78, 14);
		contentPane.add(lblBottomPadding);
		
		lpTx = new JTextField();
		lpTx.setBounds(125, 65, 86, 20);
		contentPane.add(lpTx);
		lpTx.setColumns(10);
		lpTx.setText("" + mPaddingData.getLp() + "");
		
		rpTx = new JTextField();
		rpTx.setBounds(125, 90, 86, 20);
		contentPane.add(rpTx);
		rpTx.setColumns(10);
		rpTx.setText("" + mPaddingData.getRp() + "");
		
		tpTx = new JTextField();
		tpTx.setBounds(323, 66, 86, 20);
		contentPane.add(tpTx);
		tpTx.setColumns(10);
		tpTx.setText("" + mPaddingData.getTp() + "");
		
		bpTx = new JTextField();
		bpTx.setBounds(323, 93, 86, 20);
		contentPane.add(bpTx);
		bpTx.setColumns(10);
		bpTx.setText("" + mPaddingData.getBp() + "");
		
		lblInput = new JLabel("Input");
		lblInput.setBounds(26, 118, 46, 14);
		contentPane.add(lblInput);
		
		lblOutput = new JLabel("Output");
		lblOutput.setBounds(26, 222, 46, 14);
		contentPane.add(lblOutput);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Bug in JDK related to character spacing", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("ToolBar.dockingForeground")));
		
		panel.setBounds(419, 11, 414, 117);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCharacterSpacingRelated = new JLabel("Character spacing related bug is there in JDK 1.5 and above version");
		lblCharacterSpacingRelated.setBounds(10, 26, 382, 20);
		panel.add(lblCharacterSpacingRelated);
		
		JLabel lblJustCopyThe = new JLabel("Just Copy the output irrespective of the formatting here and paste in notepad++");
		lblJustCopyThe.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblJustCopyThe.setForeground(new Color(0, 128, 0));
		lblJustCopyThe.setBounds(10, 46, 394, 14);
		panel.add(lblJustCopyThe);
		
		JLabel lblMoreInfoAt = new JLabel("More info at Below Link");
		lblMoreInfoAt.setBounds(10, 64, 170, 14);
		panel.add(lblMoreInfoAt);
		
		bugLinkTextField = new JTextField();
		bugLinkTextField.setBounds(10, 86, 394, 20);
		bugLinkTextField.setText(BUG_LINK);
		panel.add(bugLinkTextField);
		bugLinkTextField.setColumns(10);
		
		btnInbox.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  String inputTextHeader = inputTextArea.getText();
				  inputTextHeader = inputTextHeader!=null ? inputTextHeader.trim(): "";
				  if(validateInput())
					  return;
				  String result = format(inputTextHeader);
				  print(result);
				  processed = false;
				  } 
				} 
		);
	}

	protected void print(String result) {
		/*
		 * Print on Console
		 */
		System.out.println(result);
		
		
		/*
		 * Print on GUI
		 */
		outPutTextArea.setText(result);
	}

	protected boolean validateInput() {
		errorEncountered = false;
		try{
			mPaddingData.setLp(Integer.parseInt(lpTx.getText().trim()));
			mPaddingData.setRp(Integer.parseInt(rpTx.getText().trim()));
			mPaddingData.setTp(Integer.parseInt(tpTx.getText().trim()));
			mPaddingData.setBp(Integer.parseInt(bpTx.getText().trim()));
			//System.out.println(mPaddingData);
			errorEncountered = Validator.isErrorEncountered(mPaddingData);
		}
		catch(NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null, "Please input valid padding values.");
			errorEncountered = true;
		}
		//System.out.println("error: " + errorEncountered);
		return errorEncountered ;
	}
	
	

	protected String format(String inputTextHeader) {
		if(inputTextHeader.length()==0)
		{
			outPutTextArea.setText("There is no text found to be inboxed");
			return null;
		}
		StringBuilder result = new StringBuilder("");
		int length = inputTextHeader.length();
		int n = length + mPaddingData.getLp() + mPaddingData.getRp();
		
		String header = PrintHandlerUtils.getFormattedHeader(inputTextHeader, mPaddingData);
		String lineAboveAndBelow = PrintHandlerUtils.getHorizontalLine(length, mPaddingData.getLp() + mPaddingData.getRp());
		String paddingAbove = PrintHandlerUtils.getVerticalLine(mPaddingData.getTp(), n);
		String paddingBelow = PrintHandlerUtils.getVerticalLine(mPaddingData.getBp(), n);
		
		String printableTitle = result.append(lineAboveAndBelow).
				append("\n").
				append(paddingAbove).
				append("\n").
				append(header).
				append("\n").
				append(paddingBelow).
				append("\n").
				append(lineAboveAndBelow).toString();
		return printableTitle;
	}

	
	
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if(ke.getSource() == inputTextArea && !processed)
		{
			outPutTextArea.setText("");
			processed = true;
		}
		
	}
}
