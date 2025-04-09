public class HttpResponse {
    private final Status status;
    static final String CRLF = "\r\n";

    public HttpResponse(Status status) {
        this.status = status;
    }

    public String getResponse() {
        // hardcode the response for now
        return "HTTP/1.1 " + status.getCode() + " " + CRLF + CRLF;
    }
}
