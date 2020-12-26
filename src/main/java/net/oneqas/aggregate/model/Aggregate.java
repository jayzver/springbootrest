package net.oneqas.aggregate.model;

import net.oneqas.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aggregate extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private List<Aggregate>
}
