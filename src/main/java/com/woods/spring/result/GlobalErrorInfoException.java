package com.woods.spring.result;

public class GlobalErrorInfoException extends Exception{
    private ErrorInfo errorInfo;

    public GlobalErrorInfoException(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
