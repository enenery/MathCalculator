import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MathCalculator extends JFrame
{
   private FactorialCalculator factorial;
   private EulerNumberCalculator euler;
   private TaylorSeriesCalculator taylor;
   
   public MathCalculator()
   {
      setTitle("Math Calculator");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new GridLayout(1, 3));
      
      factorial = new FactorialCalculator();
      euler = new EulerNumberCalculator();
      taylor = new TaylorSeriesCalculator();
      
      add(factorial);
      add(euler);
      add(taylor);
    
      pack();
      setVisible(true);      
   }
   public static void main(String [] args)
   {
      new MathCalculator();
   }
}   