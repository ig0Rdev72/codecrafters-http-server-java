import java.text.MessageFormat;

public class HttpResponse {
    private final Status status;
    private static String HTTP_VERSION = "HTTP/1.1";

    // SEPERATOR is used to separate the header from the body
    static final String SEPERATOR = "\r\n";

    public HttpResponse(Status status) {
        this.status = status;
    }

    public String getResponse() {
        // hardcode the response for now
        return new MessageFormatter().format(this) + SEPERATOR;
    }

    class MessageFormatter {
        public String format(HttpResponse httpResponse) {
            return MessageFormat.format(
                "{0} {1} {2}{3}{4}",
                HTTP_VERSION,
                httpResponse.status.getCode(),
                httpResponse.status.getMessage(),
                addHeaders(httpResponse),
                SEPERATOR
            );
        }

        public String addHeaders(HttpResponse httpResponse) {
            // todo: Update this to iterator over each header and return a string representation with CRLF
            return MessageFormat.format(
                "{0}", SEPERATOR);
        }
    }
}
