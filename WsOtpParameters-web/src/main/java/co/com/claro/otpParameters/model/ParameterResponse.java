package co.com.claro.otpParameters.model;

import co.com.claro.otpParameters.entity.PqrParameters;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParameterResponse {

    @Getter @Setter
    private PqrParameters parameter;

    @Getter @Setter
    private  GenericResponse response;
}
