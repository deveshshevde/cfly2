package com.sun.mail.iap;

public class ParsingException extends ProtocolException {
    private static final long serialVersionUID = 7756119840142724839L;

    public ParsingException() {
    }

    public ParsingException(Response response) {
        super(response);
    }

    public ParsingException(String str) {
        super(str);
    }
}
