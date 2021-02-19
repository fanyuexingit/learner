/**
 * @description:
 * @author: Andy
 * @time: 2021/01/27 9:46
 */
package _3_exceptionsDemo;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by fanyuexin on 2021/01/27
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("caught: " + e);
        }
        try {
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("caught: " + e);
        }
    }
}


class LoggingException extends Exception{

    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}