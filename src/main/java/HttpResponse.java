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
        return HTTP_VERSION + " " + status.toString() + SEPERATOR + SEPERATOR;
    }
}
