package edu.byu.yc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Samuel Nuttall
 */
public class Poop {
    private static Logger logger = LoggerFactory.getLogger(Poop.class);

    public static void main(String[] args) {
        logger.info("I hate my life");
    }

    public static boolean cheese2() {
        if (true) {
            return false;
        } else if (false) {
            return true;
        }
        return true;
    }

    public boolean cheese() {
        if (true) {
            return false;
        } else if (true) {
            return true;
        } else return false;
    }
}
