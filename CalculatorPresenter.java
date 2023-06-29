
/**
 * CalculatorPresenter
 */
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorPresenter {

    CalculatorView view;
    CalculatorModel model;

    public CalculatorPresenter(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
    }

    public void performCalculation(Logger logger, Scanner inputScanner) {
        logger.info("Программа запущена.");
        String firstNumber = view.enterComplexNumber(inputScanner);
        CalculatorModel model1 = model.fromString(firstNumber, logger);
        logger.log(Level.INFO, "Реальная часть 1 комплексного числа = " + model1.real);
        System.out.println();

        char myAction = view.enterAction(inputScanner);
        logger.log(Level.INFO, "Знак между комплексными числами = " + myAction);
        System.out.println();

        String secondNumber = view.enterComplexNumber(inputScanner);
        CalculatorModel model2 = model.fromString(secondNumber, logger);
        logger.log(Level.INFO, "Реальная часть 2 комплексного числа = " + model2.real);

        switch (myAction) {
            case '+':
                if (model1.imaginary + model2.imaginary >= 0) {
                    System.out.printf("Результат: %.1f" + " + " + "%.1f" + "i\n",
                            (model1.real + model2.real), (model1.imaginary + model2.imaginary));
                    logger.info("Результат предоставлен.");
                    break;
                }
                if (model1.imaginary + model2.imaginary < 0) {
                    System.out.printf("Результат: %.1f" + "%.1f" + "i\n",
                            (model1.real + model2.real), (model1.imaginary + model2.imaginary));
                    logger.info("Результат предоставлен.");
                    break;
                }
            case '-':
                if (model1.imaginary + model2.imaginary >= 0) {
                    System.out.printf("Результат: %.1f" + " + " + "%.1f" + "i\n",
                            (model1.real - model2.real), (model1.imaginary - model2.imaginary));
                    logger.info("Результат предоставлен.");
                    break;
                } else {
                    System.out.printf("Результат: %.1f" + "%.1f" + "i\n",
                            (model1.real - model2.real), (model1.imaginary - model2.imaginary));
                    logger.info("Результат предоставлен.");
                    break;
                }
            case '*':
                if ((model1.real * model2.imaginary) + (model1.imaginary * model2.real) > 0) {
                    System.out.printf("Результат: %.1f" + " + " + "%.1f" + "i\n",
                            ((model1.real * model2.real) - (model1.imaginary * model2.imaginary)),
                            (model1.real * model2.imaginary) + (model1.imaginary * model2.real));
                    logger.info("Результат предоставлен.");
                } else {
                    System.out.printf("Результат: %.1f" + "%.1f" + "i\n",
                            (model1.real * model2.real - model1.imaginary * model2.imaginary),
                            (model1.real * model2.imaginary) + (model1.imaginary * model2.real));
                    logger.info("Результат предоставлен.");
                }
                break;
            case '/':
                if ((model2.real * model1.imaginary - model1.real * model2.imaginary)
                        / ((model2.real * model2.real) + (model2.imaginary * model2.imaginary)) > 0) {
                    System.out.printf("Результат: %.1f" + " + " + "%.1f" + "i\n",
                            (model1.real * model2.real + model1.imaginary * model2.imaginary)
                                    / ((model2.real * model2.real) + (model2.imaginary * model2.imaginary)),
                            (model2.real * model1.imaginary - model1.real * model2.imaginary)
                                    / ((model2.real * model2.real) + (model2.imaginary * model2.imaginary)));
                    logger.info("Результат предоставлен.");
                } else {
                    System.out.printf("Результат: %.1f" + "%.1f" + "i\n",
                            (model1.real * model2.real + model1.imaginary * model2.imaginary)
                                    / ((model2.real * model2.real) + (model2.imaginary * model2.imaginary)),
                            (model2.real * model1.imaginary - model1.real * model2.imaginary)
                                    / ((model2.real * model2.real) + (model2.imaginary * model2.imaginary)));
                    logger.info("Результат предоставлен.");
                }
        }
    }
}