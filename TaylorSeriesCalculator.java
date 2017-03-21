import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaylorSeriesCalculator extends JPanel
{
    private JLabel heading;
    private JLabel enter;
    private JTextField value;
    private JButton calculateButton;
    private JPanel eulerPanel;
    private JPanel enterPanel;
    private JButton question;
    private JPanel questPanel;
    private JPanel calculate;
    private JPanel headingPanel;
    private JLabel enterX;
    private JTextField xField; 
    private JPanel xPanel;
    private JPanel panelX; 
    private double x; 
    double[] eulerNums; 
    private JPanel panelTextX;
    private JPanel panelLabelX;
    double runningError;
   private JPanel precisionPanel;
   private JLabel precisionLabel;
   private JTextField precisionText;
   private JPanel eulerBottomP;
   private JPanel whole;
   private JPanel advanced;
   private JLabel advancedLabel;
   private JButton advancedButton;
   private JLabel advancedN;
   private JTextField advancedNfield;
   private JPanel adButton;
   private JLabel entX;
   private JTextField xFd;
   private JPanel pp;
   double test;
   int n =1;
   private JLabel advancedLabel2;
    
    public TaylorSeriesCalculator() 
    {
    	whole = new JPanel();
   	    whole.setLayout(new GridLayout(2, 1));
    	eulerPanel = new JPanel();
   	  	eulerPanel.setLayout(new GridLayout(5, 1));
      	heading = new JLabel("Exponential Euler Number Calculator: e^x");
      	buildQuestionPanel();
      	buildEnterPanel();
      	buildButtonPanel();
      	buildXPanel();
      	buildPrecisionPanel();
      		
      	headingPanel = new JPanel();
      	headingPanel.add(heading);
      
      	eulerPanel.setBorder(BorderFactory.createEtchedBorder()); 
      		     
      	eulerPanel.add(headingPanel);
      	eulerPanel.add(questPanel);
      	eulerPanel.add(panelX);
      	eulerPanel.add(enterPanel);
      	eulerPanel.add(calculate);
      
      	eulerBottomP = new JPanel();
        eulerBottomP.setBorder(BorderFactory.createEtchedBorder());
        eulerBottomP.add(precisionPanel);
      
        whole.add(eulerPanel);
     	whole.add(eulerBottomP);
      	add(whole);
    }
    
    public void buildEnterPanel()
    {
      enterPanel = new JPanel();
      
      setLayout(new GridLayout(1, 2));
      
      enter = new JLabel("Enter the value of n: ");
      value = new JTextField(5);
      
      enterPanel.add(enter);
      enterPanel.add(value);
    }
 
    public void buildQuestionPanel()
    {
    	question = new JButton("?");
    	questPanel = new JPanel();
    	question.addActionListener(new QuestionListener());
    	questPanel.add(question);
    }
    
    private class QuestionListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		String str = "========= What is the Natural Exponential e? =========" + 
    			"\ne^x is estimated by using the Taylor's series." +
    				"\ne^x is calculated as follows:" +
    					"\n1+ x/1! + x^2/2! + x^3/3! + ... x^n/n!" +
    			"\n(x is a decimal number and n is a positive integer.)" + 
    				"\nExample: If e^2 = 7.389056099" +
    				"\n===============================================";
    			
    		JOptionPane.showMessageDialog(null, str);
    	}
    }
    
    public void buildXPanel()
    {
    	panelX = new JPanel();
    	panelX.setLayout(new GridLayout(1, 2));
    	panelTextX = new JPanel();
    	enterX = new JLabel("Enter the value of x: ");
    	xField = new JTextField(10);
    	panelTextX.add(xField);
    	panelLabelX = new JPanel();
    	panelLabelX.add(enterX);
    	
    	panelX.add(panelLabelX);
    	panelX.add(panelTextX);
    }
    
    public void buildPrecisionPanel()
    {
    	advanced = new JPanel();
    	advanced.setLayout(new GridLayout(2, 1));
    	advancedLabel = new JLabel("==============================Advanced Euler Number Calculator=============================");
    	advancedLabel2 = new JLabel("This will calculate the smallest number of items that will satisfy the precision specified.");
    	
    	advanced.add(advancedLabel);
    	advanced.add(advancedLabel2);
    	entX = new JLabel("Enter the value of x: ");
    	xFd = new JTextField(10);
    	
    	pp = new JPanel();
    	pp.add(entX);
    	pp.add(xFd);
    	
  
    	precisionPanel = new JPanel();
    	precisionPanel.setLayout(new GridLayout(5, 1));
    	
    	precisionLabel = new JLabel("Enter the precision to calculate the value of e:");
    	precisionText = new JTextField(5);
      
      adButton = new JPanel();
      
      advancedButton = new JButton("Calculate");
      advancedButton.addActionListener(new AdvancedButtonListener());
      
      adButton.add(advancedButton);
      	
    	precisionPanel.add(advanced);
    	precisionPanel.add(pp);
    	precisionPanel.add(precisionLabel);
    	precisionPanel.add(precisionText);
      precisionPanel.add(adButton);
    }
    
    private class AdvancedButtonListener implements ActionListener 
    {
      public void actionPerformed(ActionEvent e)
      {
      	double xs = Double.parseDouble(xFd.getText());
      	int num = 0;
      	
      	double r = Double.parseDouble(precisionText.getText());
      	while (r >= 2 || r < 0)
      	{
      		r = Double.parseDouble(JOptionPane.showInputDialog("The absolute error cannot exceed 1 and be less than 0"));     		
      	}
      	
      	if(xs > 0 && xs <= 1)
         num = error1(r);
         else if(xs < 0 && xs >= -1)
         	num = error2(r);
         else if (xs < -1)
         {
         	xs = -1.0*xs;
         	num = error3(r);
         }
         else if(xs > 1)
         	num = error4(r);
         else if(xs == 0)
         	num = 0;

        JOptionPane.showMessageDialog(null, "The number of items which the absolute error:" + num);
 
      }
    }
    
    
    
    public void buildButtonPanel()
    {
    	calculate = new JPanel();
    	calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ButtonListener());
        calculate.add(calculateButton);	
    }
    
    private class ButtonListener implements ActionListener
    {
      public void actionPerformed(ActionEvent e)
      { 
      	 int number = Integer.parseInt(value.getText());
      	 
      	 while (number < 1 || number > 10)
      	 number = Integer.parseInt(JOptionPane.showInputDialog("Error: n must be a positive integer less than 11."));
      	 
      	 x = Double.parseDouble(xField.getText());
      	 
         eulerNums = new double[number];
         
         for(int i = 0; i < eulerNums.length; i++)
         eulerNums[i] = getEuler(i+1, x);
         
         //In the order of (6a), (8), (9), (7)
         if(x > 0 && x <= 1)
         runningError = estimateError1(number);
         else if(x < 0 && x >= -1)
         	runningError = estimateError2(number);
         else if (x < -1)
         {
         	x = -1.0*x;
         	runningError = estimateError3(x, number);
         }
         else if(x > 1)
         	runningError = estimateError4(x, number);
         else if(x == 0)
         	runningError = 0;
         
         String stri = "The actual value of e: " + Math.pow(Math.E, x) +
         	"\nThe running error is less than " + runningError;
         
         String str = "n  |  Estimation" + "\n======================";
         
      	 int i = 0; 
         while (i < eulerNums.length)
         {
         	str += "\n" + (i+1) + "    " + eulerNums[i];
         	i++;
         }
         	   
      	JOptionPane.showMessageDialog(null, str);   
      	JOptionPane.showMessageDialog(null, stri);   
      }
    }
 
   public double getEuler(int num, double exp)
   {
      if (num == 0)
         return 1;
      else
      {         
         return Math.pow(exp, num)/factorial(num)+getEuler(num-1, exp);
      }
   }
   
   public int factorial(int number)
   {
      if (number < 2)
         return 1;
      else
         return number*factorial(number-1);
   }
   
   public double estimateError1(int n)
   {
   		return 3.0/factorial(n+1);
   }
  
   public double estimateError2(int n)
   {
   		return 1.0/factorial(n+1);
   }
   
   public double estimateError3(double N, int n)
   {
 		return Math.pow(N, n+1)/factorial(n+1);
   }
   
   public double estimateError4(double N, int n)
   {	
   		return (Math.pow(3, N)*Math.pow(N, n+1))/factorial(n+1);
   }
  
  	public int error1(double rr)
  	{	
  		boolean ans = true;
	
  		while(ans)
        {
        	test = 3.0/factorial(n+1);
        	
        	System.out.println("test: " + test +" r: " + rr);
        	if(rr > test)
        	{
        		ans = false;
        		System.out.println("test: " + test +" r: " + rr);
        	}
        	else
        		n++;
        	
        	
  		}
  		return n;
  	}
  	
  	public int error2(double rr)
  	{	
  		boolean ans = true;
  		
  		
  		while(ans)
        {
        	test = 1.0/factorial(n+1);
        	
        	System.out.println("test: " + test +" r: " + rr);
        	if(rr > test)
        	{
        		ans = false;
        		System.out.println("test: " + test +" r: " + rr);
        	}
        	else
        		n++;
        	
        
  		}
  		return n;
  	}
  	
  	public int error3(double rr)
  	{	
  		boolean ans = true;
  	
  		
  		while(ans)
        {
        	test = Math.pow(rr, n+1)/factorial(n+1);
        	
        	System.out.println("test: " + test +" r: " + rr);
        	if(rr > test)
        	{
        		ans = false;
        		System.out.println("test: " + test +" r: " + rr);
        	}
        	else
        		n++;
        	
        	
  		}
  		return n;
  	}
  	
  	public int error4(double rr)
  	{	
  		boolean ans = true;
  		
  		while(ans)
        {
        	test = (Math.pow(3, rr)*Math.pow(rr, n+1))/factorial(n+1);
        	
        	System.out.println("test: " + test +" r: " + rr);
        	if(rr > test)
        	{
        		ans = false;
        		System.out.println("test: " + test +" r: " + rr);
        	}
        	else
        		n++;
        	
        	
  		}
  		return n;
  	}
  	
}
