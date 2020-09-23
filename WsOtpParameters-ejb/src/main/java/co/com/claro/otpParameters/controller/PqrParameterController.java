package co.com.claro.otpParameters.controller;

import co.com.claro.otpParameters.dao.PqrParametersDao;
import co.com.claro.otpParameters.entity.PqrParameters;
import lombok.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@NoArgsConstructor
public class PqrParameterController {

    @PersistenceContext(name = "UpdateCase")
    @Getter @Setter
    private EntityManager entityManager;

    @EJB
    private PqrParametersDao pqrParametersDao;

    public List<PqrParameters> findAll() {
        List<PqrParameters> parameters = new ArrayList<>();
        parameters = this.entityManager
                .createNamedQuery("PqrParameters.findAll")
                .getResultList();
        return parameters;
    }

    public List<PqrParameters> findAllByType(String type) {
        List<PqrParameters> parameters = new ArrayList<>();
        parameters = this.entityManager
                .createNamedQuery("PqrParameters.findAllByType")
                .setParameter("type", type)
                .getResultList();
        return parameters;
    }

    public PqrParameters findByTypeAndName(String type, String name) {
        PqrParameters parameter = new PqrParameters();
        parameter = this.entityManager
                .createNamedQuery("PqrParameters.findByNameAndType", PqrParameters.class)
                .setParameter("type", type)
                .setParameter("name", name)
                .getSingleResult();
        return parameter;
    }

}
