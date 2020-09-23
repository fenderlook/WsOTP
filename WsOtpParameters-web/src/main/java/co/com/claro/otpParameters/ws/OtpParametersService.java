/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpParameters.ws;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import co.com.claro.otpParameters.entity.PqrParameters;
import co.com.claro.otpParameters.facade.PqrParametersIFacade;
import co.com.claro.otpParameters.model.GenericResponse;
import co.com.claro.otpParameters.model.ParameterResponse;
import co.com.claro.otpParameters.model.ParametersResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omarMad
 */
@Path("OtpParameters")
@Stateless
@TransactionManagement
public class OtpParametersService {

    @EJB
    private PqrParametersIFacade parametersIFacade;

    public OtpParametersService() {
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("parametersByName")
    public ParameterResponse parametersByName(@QueryParam("name") String name) throws JsonProcessingException {
        ParameterResponse parameterResponse = new ParameterResponse();
        GenericResponse response = new GenericResponse("00", "OK", "OK");
        PqrParameters parameter = new PqrParameters();
        try {
            parameter = this.parametersIFacade.findByTypeAndName("P", name);
        } catch (Exception e) {
            response = new GenericResponse("99",
                    "Error consulta",
                    e.getMessage());
            e.printStackTrace();
        }
        parameterResponse.setParameter(parameter);
        parameterResponse.setResponse(response);
        return parameterResponse;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("parameters/")
    public ParametersResponse parameters() throws JsonProcessingException {
        ParametersResponse parametersResponse = new ParametersResponse();
        GenericResponse response = new GenericResponse("00", "OK", "OK");
        List<PqrParameters> parameters = new ArrayList<>();
        try {
            parameters = this.parametersIFacade.findAllByType("P");
        } catch (Exception e) {
            response = new GenericResponse("99",
                    "Error consulta",
                    e.getMessage());
            e.printStackTrace();
        }
        parametersResponse.setParameters(parameters);
        parametersResponse.setResponse(response);
        return parametersResponse;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("functionalityByName")
    public ParameterResponse functionalityByName(@QueryParam("name") String name) throws JsonProcessingException {
        ParameterResponse parameterResponse = new ParameterResponse();
        GenericResponse response = new GenericResponse("00", "OK", "OK");
        PqrParameters parameter = new PqrParameters();
        try {
            parameter = this.parametersIFacade.findByTypeAndName("F", name);
        } catch (Exception e) {
            e.printStackTrace();
            response = new GenericResponse("99",
                    "Error consulta",
                    e.getMessage());
        }
        parameterResponse.setParameter(parameter);
        parameterResponse.setResponse(response);
        return parameterResponse;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("functionality/")
    public ParametersResponse functionality() throws JsonProcessingException {
        ParametersResponse parametersResponse = new ParametersResponse();
        GenericResponse response = new GenericResponse("00", "OK", "OK");
        List<PqrParameters> parameters = new ArrayList<>();
        try {
            parameters = this.parametersIFacade.findAllByType("F");
        } catch (Exception e) {
            response = new GenericResponse("99",
                    "Error consulta",
                    e.getMessage());
            e.printStackTrace();
        }
        parametersResponse.setParameters(parameters);
        parametersResponse.setResponse(response);
        return parametersResponse;
    }

}
