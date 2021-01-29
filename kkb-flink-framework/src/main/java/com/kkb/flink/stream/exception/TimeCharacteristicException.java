package com.kkb.flink.stream.exception;

/**
 * @author taochanglian
 * @since 2020-08-03 11:06
 */
public class TimeCharacteristicException extends RuntimeException {


    private static final long serialVersionUID = -6203713473183995313L;

    public TimeCharacteristicException() {
        super();
    }

    public TimeCharacteristicException(String message) {
        super(message);
    }

    public TimeCharacteristicException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeCharacteristicException(Throwable cause) {
        super(cause);
    }

    protected TimeCharacteristicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
