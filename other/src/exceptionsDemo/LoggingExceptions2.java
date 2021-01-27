/**
 * @description:
 * @author: Andy
 * @time: 2021/01/27 9:59
 */
package exceptionsDemo;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by fanyuexin on 2021/01/27
 */
public class LoggingExceptions2 {
    private static Logger logger = Logger.getLogger("LoggingExceptions2");

    static void logException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        }catch (NullPointerException e){
            logException(e);
        }
    }
}
