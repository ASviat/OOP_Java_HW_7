
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CalculatorModel
 */
public class CalculatorModel {

    public double real;
    public double imaginary;
    public char myChar;

    public CalculatorModel(double real, double imaginary, char myChar) {
        this.real = real;
        this.imaginary = imaginary;
        this.myChar = myChar;
    }

    public CalculatorModel() {

    }

    public CalculatorModel fromString(String input, Logger logger) { // обработать ситуацию с минусом, мол -2-5i

        if (input.contains("-") & input.charAt(0) != '-') {// +1-2i

            this.real = Double.parseDouble(input.substring(0, input.indexOf("-")));
            logger.log(Level.INFO, "Real = " + this.real);
            this.imaginary = Double.parseDouble(input.substring(input.indexOf("-"), input.length() - 1));
            logger.log(Level.INFO, "Imaginary = " + this.imaginary);
            this.myChar = '-';

            return new CalculatorModel(real, imaginary, myChar);

        }

        if (input.contains("+") & input.charAt(0) == '-') { // -1+2i

            this.real = Double.parseDouble(input.substring(0, input.indexOf("+")));
            logger.log(Level.INFO, "Real = " + this.real);
            this.imaginary = Double.parseDouble(input.substring(input.indexOf("+"), input.length() - 1));
            logger.log(Level.INFO, "Imaginary = " + this.imaginary);
            this.myChar = '+';

            return new CalculatorModel(real, imaginary, myChar);

        }
        if (!input.contains("+") & input.charAt(0) == '-') { // -1-2i

            this.real = -Double.parseDouble(input.substring(1, input.lastIndexOf('-')));
            logger.log(Level.INFO, "Real = " + this.real);
            this.imaginary = Double.parseDouble(input.substring(input.lastIndexOf('-'), input.length() - 1));
            logger.log(Level.INFO, "Imaginary = " + this.imaginary);
            this.myChar = '-';

            return new CalculatorModel(real, imaginary, myChar);

        }
        if (input.contains("+") & input.charAt(0) != '-') { // 1+2i

            this.real = Double.parseDouble(input.substring(0, input.lastIndexOf('+')));
            logger.log(Level.INFO, "Real = " + this.real);
            this.imaginary = Double.parseDouble(input.substring(input.lastIndexOf('+'), input.length() - 1));
            logger.log(Level.INFO, "Imaginary = " + this.imaginary);
            this.myChar = '+';

            return new CalculatorModel(real, imaginary, myChar);

        }
        return new CalculatorModel();

    }

}
