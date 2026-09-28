package u_dev.parkovka.config.exeptions;

public class ErrorResponse {
    private String code;
    private String message;

    public ErrorResponse(){}

    public ErrorResponse(String errorCode, String message) {
        this.code = errorCode;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
