package xws.microservice.auth.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@RequiredArgsConstructor
@Data
public class Firm {
    @Id
    @SequenceGenerator(name="company_id_seq",sequenceName="company_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="company_id_seq")
    private Long id;

    @Column(name = "cid", nullable = false, unique = true)
    private String cid;

    @Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
