
import java.util.Scanner;

/**
 * CalculatorViewer
 */
public class CalculatorView  {

    
    public String enterComplexNumber(Scanner inputScanner) {
        
        System.out.println("Введите комплексное число: ");
        String numberString = inputScanner.nextLine();
       
        return numberString;
    }

    
    public char enterAction(Scanner inputScanner) {
        
        System.out.println("Введите действие +, -, *, /");
        char myChar = inputScanner.nextLine().charAt(0);
        
        return myChar;
    }

}