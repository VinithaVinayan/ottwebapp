package com.ottapp.utils;

import org.slf4j.LoggerFactory;

public class Logger {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Logger.class);
    
    public static void info(String message) {
    	log.info(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }

    public static void warn(String message) {
       log.warn(message);
    }
}
