import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class FactorialCalculator extends JPanel
{
   private JLabel heading;
   private JPanel headingPanel;
   private JLabel enter;
   private JTextField value;
   private JPanel calculate;
   private JButton calculateButton;
   private JPanel enterPanel;
   private JPanel factorialPanel;
   private JLabel answer;
   private JButton question;
   private JPanel questPanel;
   
   private int numberEntered;
   private int factorialGiven;
        
     public FactorialCalculator() 
    { 
      factorialPanel = new JPanel(); 
      factorialPanel.setLayout(new GridLayout(5,1));    
      heading = new JLabel("Factorial Calculator: n!");
      
      headingPanel = new JPanel();
      headingPanel.add(heading);
      
      buildQuestionPanel();
      buildEnterPanel();
      buildButtonPanel();
      
      factorialPanel.setBorder(BorderFactory.createEtchedBorder());
      
      factorialPanel.add(headingPanel);
      factorialPanel.add(questPanel);
      factorialPanel.add(enterPanel);
      factorialPanel.add(calculate);  
      
      add(factorialPanel);   
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
    		String str = "============ What is factorial? ============" + 
    			"\nFactorial is the product of all the positive integers" +
    				"\nfrom 1 up to n, where n is a positive integer." +
    					"\nWhen n is 0, its factorial is defined as 1." +
    			"\nIt is denoted as n! and read as n factorial." + "\nExample: 3! = 3*2*1 = 6" +
    				"\n========================================";
    			
    		JOptionPane.showMessageDialog(null, str);
    	}
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
     
      	int fac = factorial(number);
      	
      	JOptionPane.showMessageDialog(null, number + "! = " + fac);        
      }
    }
    
     public int factorial(int n) 
    {
       if(n == 0)
         return 1;
       else
         return n * factorial(n-1);      
    }  
}
