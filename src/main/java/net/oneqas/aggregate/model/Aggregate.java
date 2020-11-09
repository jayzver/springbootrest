package net.oneqas.aggregate.model;

import javax.persistence.*;

@Entity
public class Aggregate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nameAggregate")
    String nameAggregate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameAggregate() {
        return nameAggregate;
    }

    public void setNameAggregate(String nameAggregate) {
        this.nameAggregate = nameAggregate;
    }

    @Override
    public String toString() {
        return "Aggregate{" +
                "id=" + id +
                ", nameAggregate='" + nameAggregate + '\'' +
                '}';
    }
}
