package co.com.claro.otpParameters.dao;

import co.com.claro.otpParameters.entity.PqrParameters;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;

@Stateless
@ToString
public class PqrParametersDao extends AbstractDao<PqrParameters> implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;


    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String type;

    @Getter @Setter
    private String message;

    @Getter @Setter
    private String urlAccess;

    @Getter @Setter
    private Long state;

    @Getter @Setter
    private String createUser;

    @Getter @Setter
    private Date createDate;

    public PqrParametersDao() {
        super(PqrParameters.class);
    }

    public PqrParametersDao(EntityManager entityManager){
        super(PqrParameters.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

}
