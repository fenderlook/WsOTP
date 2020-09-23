package co.com.claro.otpParameters.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PQR_PARAMETERS")
@NamedQueries({
        @NamedQuery(name = "PqrParameters.findAll", query = "SELECT q FROM PqrParameters q"),
        @NamedQuery(name = "PqrParameters.findAllByType", query = "SELECT q FROM PqrParameters q" +
                " WHERE q.type = :type "),
        @NamedQuery(name = "PqrParameters.findByNameAndType", query = "SELECT q FROM PqrParameters q" +
                " WHERE q.type = :type AND q.name = :name")
})
public class PqrParameters implements Serializable {

    @Id
    @Column(name = "ID")
    @Getter @Setter
    private Long id;

    @Column(name = "NAME")
    @Getter @Setter
    private String name;

    @Column(name = "TYPE")
    @Getter @Setter
    private String type;

    @Column(name = "MESSAGE")
    @Getter @Setter
    private String message;

    @Column(name = "URL_ACCESS")
    @Getter @Setter
    private String urlAccess;

    @Column(name = "STATE")
    @Getter @Setter
    private Long state;

    @Column(name = "CREATE_USER")
    @Getter @Setter
    private String createUser;

    @Column(name = "CREATE_DATE")
    @Getter @Setter
    private Date createDate;
}



