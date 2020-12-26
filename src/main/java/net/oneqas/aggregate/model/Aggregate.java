package net.oneqas.aggregate.model;

import net.oneqas.commonClasses.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "aggregate")
public class Aggregate extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "serial_key")
    private String serialKey;
}
