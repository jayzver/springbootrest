package net.oneqas.aggregate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aggregate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
