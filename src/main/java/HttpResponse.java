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
                "{0} {1} {2}",
                HTTP_VERSION,
                httpResponse.status.getCode(),
                httpResponse.status.getMessage()
            );
        }
    }
}
