package net.oneqas.aggregate.model;

import net.oneqas.commonClasses.BaseEntity;

import javax.persistence.*;

@Entity
public class Aggregate extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private List<Aggregate>
}
