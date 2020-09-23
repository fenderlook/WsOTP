package co.com.claro.otpParameters.facade;

import co.com.claro.otpParameters.controller.PqrParameterController;
import co.com.claro.otpParameters.entity.PqrParameters;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PqrParametersFacade implements PqrParametersIFacade ,Serializable {

    @EJB
    PqrParameterController parameterController;

    @Override
    public List<PqrParameters> findAll() {
        List<PqrParameters> parameters = new ArrayList<>();
        try {
            parameters = this.parameterController.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return parameters;
    }

    @Override
    public List<PqrParameters> findAllByType(String type) {
        List<PqrParameters> parameters = new ArrayList<>();
        try {
            parameters = this.parameterController.findAllByType(type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return parameters ;
    }

    @Override
    public PqrParameters findByTypeAndName(String type, String name) {
        PqrParameters parameter = new PqrParameters();
        try {
            parameter = this.parameterController.findByTypeAndName(type,name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return parameter;
    }
}
