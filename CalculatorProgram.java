// Создать проект калькулятора комплексных чисел (достаточно сделать сложение, умножение и деление).
// Применить при создании программы архитектурные паттерны, добавить логирование калькулятора.

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * CalcProgram
 */
public class CalculatorProgram {

    public static void main(String[] args) throws SecurityException, IOException {

        Scanner inputScanner = new Scanner(System.in);

        Logger logger = Logger.getLogger(CalculatorProgram.class.getName());
        FileHandler fh = new FileHandler("CalcLogger.txt", false);
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        CalculatorPresenter presenter = new CalculatorPresenter(new CalculatorView(), new CalculatorModel());

        presenter.performCalculation(logger, inputScanner);
        System.out.println();
        logger.info("Работа завершена.");
        inputScanner.close();
    }
}