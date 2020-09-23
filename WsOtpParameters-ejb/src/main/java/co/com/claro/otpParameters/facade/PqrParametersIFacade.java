package co.com.claro.otpParameters.facade;

import co.com.claro.otpParameters.entity.PqrParameters;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PqrParametersIFacade {

    public List<PqrParameters> findAll();

    public List<PqrParameters> findAllByType(String type);

    public PqrParameters findByTypeAndName(String type, String name);
}
