package com.glqdlt.myho;

public class FileRenamerExpectedError extends FileRenamerError {

    public static class NotSupportFile extends FileRenamerError{
        public NotSupportFile(String fileName) {
            super(String.format("This file '%s' not supported file", fileName));
        }
    }

    public static class DateFiledNotFounded extends FileRenamerError {
        public DateFiledNotFounded(String fileName) {
            super(String.format("This file '%s' not founded attribute date field..", fileName));
        }
    }
}
