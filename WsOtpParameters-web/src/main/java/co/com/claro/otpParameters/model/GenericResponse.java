package co.com.claro.otpParameters.model;

import lombok.Getter;
import lombok.Setter;

public class GenericResponse {

    @Getter @Setter
    private String returnCode ;
    @Getter @Setter
    private String menssageCode;
    @Getter @Setter
    private String descripcionCode;

    public GenericResponse() {
    }

    public GenericResponse(String returnCode,
                           String menssageCode,
                           String descripcionCode) {
        this.returnCode = returnCode;
        this.menssageCode = menssageCode;
        this.descripcionCode = descripcionCode;
    }


}
