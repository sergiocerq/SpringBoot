package org.applications.crudservicos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.applications.crudservicos.dtos.SoftwareOfficeDTO;

@Entity(name = "software_office")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoftwareOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(name = "qtd_persons")
    private Integer qtd_persons_allocated;
    @Enumerated(EnumType.STRING)
    private TypeOfSoftwareOffice type;

    public SoftwareOffice(SoftwareOfficeDTO newSoftwareOfficeDTO) {
    }

}
