import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;

public class MetricConverter extends JFrame implements ActionListener
{
	//the components for cm-inch
	private JTextField cmText = new JTextField(6);
	private JLabel cmLabel = new JLabel("cm");
	private JButton cmToInchButton = new JButton("===>");
	private JButton inchToCmButton = new JButton("<===");
	private JPanel inchCmButtons = new JPanel();//compound container
	private JTextField inchText = new JTextField(6);
	private JLabel inchLabel = new JLabel("inches");
	private JPanel inchCmPanel = new JPanel();//compound container
	
	//the components for km-mile
	private JTextField kmText = new JTextField(6);
	private JLabel kmLabel = new JLabel("km");
	private JButton kmToMileButton = new JButton("===>");
	private JButton mileToKmButton = new JButton("<===");
	private JPanel mileKmButtons = new JPanel();//compound container
	private JTextField mileText = new JTextField(6);
	private JLabel mileLabel = new JLabel("miles");
	private JPanel mileKmPanel = new JPanel();//compound container
	
	//the components for kg-lbs
	private JTextField kgText = new JTextField(6);
	private JLabel kgLabel = new JLabel("kg");
	private JButton kgToLbButton = new JButton("===>");
	private JButton lbToKgButton = new JButton("<===");
	private JPanel kgLbButtons = new JPanel();//compound container
	private JTextField lbText = new JTextField(6);
	private JLabel lbLabel = new JLabel("lbs");
	private JPanel kgLbPanel = new JPanel();//compound container
	
	//clear screen button
	private JButton clearButton = new JButton("clear");
	private JPanel clearPanel = new JPanel();
	
	
	public MetricConverter()
	{
		//set window specifics
		setTitle("Metric Converter");
		setSize(320, 250);
		setLocation(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
		
		inchCmButtons.setLayout(new BorderLayout());
		inchCmButtons.add("North", cmToInchButton);
		inchCmButtons.add("South", inchToCmButton);
		//add components to the cm inch panel
		inchCmPanel.add(cmText);
		inchCmPanel.add(cmLabel);
		inchCmPanel.add(inchCmButtons);
		inchCmPanel.add(inchText);
		inchCmPanel.add(inchLabel);
		
		mileKmButtons.setLayout(new BorderLayout());
		mileKmButtons.add("North", kmToMileButton);
		mileKmButtons.add("South", mileToKmButton);
		//add components to the km mile panel
		mileKmPanel.add(kmText);
		mileKmPanel.add(kmLabel);
		mileKmPanel.add(mileKmButtons);
		mileKmPanel.add(mileText);
		mileKmPanel.add(mileLabel);
		
		kgLbButtons.setLayout(new BorderLayout());
		kgLbButtons.add("North", kgToLbButton);
		kgLbButtons.add("South", lbToKgButton);
		//add components to the kgLbPanel
		kgLbPanel.add(kgText);
		kgLbPanel.add(kgLabel);
		kgLbPanel.add(kgLbButtons);
		kgLbPanel.add(lbText);
		kgLbPanel.add(lbLabel);
		
		//add clear button to clear panel
		clearPanel.setLayout(new BorderLayout());
		clearPanel.add("South", clearButton);
		clearPanel.add(clearButton);
		
		//add the panels (which hold the window components)
		this.add(inchCmPanel);
		this.add(mileKmPanel);
		this.add(kgLbPanel);
		this.add(clearPanel);
		
		//give raised borders to the buttons
		cmToInchButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		inchToCmButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		kmToMileButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		mileToKmButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		kgToLbButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		lbToKgButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		
		//add actionListeners to buttons
		cmToInchButton.addActionListener(this);
		inchToCmButton.addActionListener(this);
		kmToMileButton.addActionListener(this);
		mileToKmButton.addActionListener(this);
		kgToLbButton.addActionListener(this);
		lbToKgButton.addActionListener(this);
		clearButton.addActionListener(this);
		
	}
	

	public void actionPerformed(ActionEvent e)
	{
		double d;
		String s;
		//format the output
		DecimalFormat df = new DecimalFormat("#####0.0#");
		
		//convert cm to inches
		if(e.getSource() == cmToInchButton)
		{
			s = cmText.getText();
			d = Double.parseDouble(s);
			d = d / 2.54;
			s = df.format(d);
			inchText.setText(s);
		}
		//inch to cm
		if(e.getSource() == inchToCmButton)
		{
			s = inchText.getText();
			d = Double.parseDouble(s);
			d = d * 2.54;
			s = df.format(d);
			cmText.setText(s);
		}
		//km to mile
		if(e.getSource() == kmToMileButton)
		{
			s = kmText.getText();
			d = Double.parseDouble(s);
			d = d/1.609;
			s = df.format(d);
			mileText.setText(s);
		}
		//mile to km
		if(e.getSource() == mileToKmButton)
		{
			s = mileText.getText();
			d = Double.parseDouble(s);
			d = d*1.609;
			s = df.format(d);
			kmText.setText(s);
		}
		//kg to lb
		if(e.getSource() == kgToLbButton)
		{
			s = kgText.getText();
			d = Double.parseDouble(s);
			d = d*2.2;
			s = df.format(d);
			lbText.setText(s);
		}
		//lb to kg
		if(e.getSource() == lbToKgButton)
		{
			s = lbText.getText();
			d = Double.parseDouble(s);
			d = d/2.2;
			s = df.format(d);
			kgText.setText(s);
		}
		//clear
		if(e.getSource() == clearButton)
		{
			s="";
			lbText.setText(s);
			kgText.setText(s);
			cmText.setText(s);
			inchText.setText(s);
			kmText.setText(s);
			mileText.setText(s);
		}
		
		
		
		
		
	}

}







