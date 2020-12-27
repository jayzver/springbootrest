package net.oneqas.auxiliaries;

import javax.persistence.*;

@Entity
@Table(name = "additional_properties")
public class AdditionalProperties
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aggregate_id")
    private Long aggregateId;

    @Column(name = "name_properties")
    private String nameProperties;

    @Column(name = "value_properties")
    private String valueProperties;
}
