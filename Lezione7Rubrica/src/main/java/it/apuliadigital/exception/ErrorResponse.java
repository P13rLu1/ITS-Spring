package it.apuliadigital.exception;
import java.util.Objects;

public class ErrorResponse {
    private int statusCode;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(String message) {
        super();
        this.message = message;
    }

    public ErrorResponse(int statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponse statusCode(int statusCode) {
        setStatusCode(statusCode);
        return this;
    }

    public ErrorResponse message(String message) {
        setMessage(message);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ErrorResponse errorResponse)) {
            return false;
        }
        return statusCode == errorResponse.statusCode && Objects.equals(message, errorResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, message);
    }

    @Override
    public String toString() {
        return "{" +
                " statusCode='" + getStatusCode() + "'" +
                ", message='" + getMessage() + "'" +
                "}";
    }
}
