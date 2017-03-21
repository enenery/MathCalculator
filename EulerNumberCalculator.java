import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EulerNumberCalculator extends JPanel 
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
   double[] eulerNums;
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
   private JLabel advancedLabel2;
   
   public EulerNumberCalculator()
   {
   	whole = new JPanel();
   	whole.setLayout(new GridLayout(2, 1));
   	eulerPanel = new JPanel();
   	eulerPanel.setLayout(new GridLayout(4, 1));
      heading = new JLabel("Euler Number Calculator: e");
      
      buildQuestionPanel();
      buildEnterPanel();
      buildButtonPanel();
      buildPrecisionPanel();
      headingPanel = new JPanel();
      headingPanel.add(heading);
      
      eulerPanel.setBorder(BorderFactory.createEtchedBorder());      
      eulerPanel.add(headingPanel);
      eulerPanel.add(questPanel);
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
    		String str = "========= What is the natural Euler number e? =========" + 
    			"\nThe number e is a famous and important irrational number" +
    				"\nin mathematics. e is calculated as follows:" +
    					"\n1/0! + 1/1! + 1/2! + 1/3! + 1/4! + 1/5! + 1/6! + 1/7! + ... 1/n!" +
    			"\n(n is a positive integer.)" + "\nExample: If n = 1, e = 2.5" +
    				"\n===============================================";
    			
    		JOptionPane.showMessageDialog(null, str);
    	}
    }
    
    public void buildPrecisionPanel()
    {
    	advanced = new JPanel();
    	advanced.setLayout(new GridLayout(2, 1));
    	advancedLabel = new JLabel("==============================Advanced Euler Number Calculator=============================");
    	advancedLabel2 = new JLabel("This will calculate the smallest number of items that will satisfy the precision specified.");
    	
    	advanced.add(advancedLabel);
    	advanced.add(advancedLabel2);
    	precisionPanel = new JPanel();
    	precisionPanel.setLayout(new GridLayout(5, 1));
    	
    	precisionLabel = new JLabel("Enter the precision to calculate the value of e:");
    	precisionText = new JTextField(5);
      
      adButton = new JPanel();
      
      advancedButton = new JButton("Calculate");
      advancedButton.addActionListener(new AdvancedButtonListener());
      
      adButton.add(advancedButton);
      
    	precisionPanel.add(advanced);
    	precisionPanel.add(precisionLabel);
    	precisionPanel.add(precisionText);
      precisionPanel.add(adButton);
    }
    
    private class AdvancedButtonListener implements ActionListener 
    {
      public void actionPerformed(ActionEvent e)
      {
      	boolean ans = true;
      	double test;
      	int n = 1;
      	
      	double r = Double.parseDouble(precisionText.getText());
      	while (r >= 2 || r < 0)
      	{
      		r = Double.parseDouble(JOptionPane.showInputDialog("The absolute error cannot exceed 1 and be less than 0"));     		
      	}
      		     	
        while(ans)
        {
        	test = 3.0/factorial(n+1);
        	
        	System.out.println("test: " + test +" r: " + r);
        	if(r > test)
        	{
        		ans = false;
        		System.out.println("test: " + test +" r: " + r);
        	}
        	else
        		n++;
        		
        	System.out.println(test);     		
        }
        
        JOptionPane.showMessageDialog(null, "The number of items which the absolute error:" + n);
 
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
      	 
      	 while (number < 0 || number > 10)
      	{
      		number = Integer.parseInt(JOptionPane.showInputDialog("Error: Reenter a nonnegative integer less than 11."));    			
      	}
         eulerNums = new double[number+1];
         
         for(int i = 0; i < number+1; i++)
         eulerNums[i] = getEuler(i);
         
         runningError = estimateError(number);
         
         String stri = "The actual value of e: " + Math.E +
         	"\nThe running error is less than " + runningError;
         	        
         String str = "n  |  Estimation" + "\n======================";
      
         for (int i = 0; i < eulerNums.length; i++)
         str += "\n" + i + "    " + eulerNums[i]; 
	   
      	JOptionPane.showMessageDialog(null, str);
      	JOptionPane.showMessageDialog(null, stri);
      }
    }
 
   public double getEuler(int num)
   {
      if (num == 0)
         return 1;
      else
      {         
         return 1.0/factorial(num)+getEuler(num-1);
      }
   }
   
   public int factorial(int number)
   {
      if (number < 2)
         return 1;
      else
         return number*factorial(number-1);
   }
   
   public double estimateError(int n)
   {
   		return 3.0/factorial(n+1);
   }
   
} 