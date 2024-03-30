package org.applications.crudservicos.entities;

import jakarta.persistence.*;

@Entity(name = "software_office")
public class SoftwareOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(name = "qtd_persons")
    private Integer qtd_persons_allocated;
    @Enumerated(EnumType.STRING)
    private TypeOfSoftwareOffice type;

    public String getName() {
        return name;
    }

    public Integer getQtd_persons_allocated() {
        return qtd_persons_allocated;
    }

    public TypeOfSoftwareOffice getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQtd_persons_allocated(Integer qtd_persons_allocated) {
        this.qtd_persons_allocated = qtd_persons_allocated;
    }

    public void setType(TypeOfSoftwareOffice type) {
        this.type = type;
    }
}
