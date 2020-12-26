package net.oneqas.auxiliaries;

import javax.persistence.*;

@Entity
@Table(name = "additional_properties")
public class AdditionalProperties
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "name_properties")
    private String nameProperties;
}
