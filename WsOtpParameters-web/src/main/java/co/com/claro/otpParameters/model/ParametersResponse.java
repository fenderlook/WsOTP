package co.com.claro.otpParameters.model;

import co.com.claro.otpParameters.entity.PqrParameters;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParametersResponse {

    @Getter @Setter
    private List<PqrParameters> parameters;

    @Getter @Setter
    private GenericResponse response;

}
