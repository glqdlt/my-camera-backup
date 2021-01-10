package com.glqdlt.myho;

public class FileRenamerError extends RuntimeException {
    public FileRenamerError() {
    }

    public FileRenamerError(String message) {
        super(message);
    }

    public FileRenamerError(String message, Throwable cause) {
        super(message, cause);
    }

    public FileRenamerError(Throwable cause) {
        super(cause);
    }

    public FileRenamerError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
