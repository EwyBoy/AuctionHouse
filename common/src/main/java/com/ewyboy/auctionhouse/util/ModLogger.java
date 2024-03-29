package com.ewyboy.auctionhouse.util;

import com.ewyboy.auctionhouse.AuctionHouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModLogger {

    private static final Logger logger = LogManager.getLogger(AuctionHouse.MOD_ID);

    public static void debug(String message, Object... params) {
       logger.log(Level.DEBUG, String.format(message, params));
    }

    public static void info(String message, Object... params) {
        logger.log(Level.INFO, String.format(message, params));
    }

    public static void error(String message, Object... params) {
        logger.log(Level.ERROR, String.format(message, params));
    }

    public static void warning(String message, Object... params) {
        logger.log(Level.WARN, String.format(message, params));
    }

}