package com.fererlab.query.city.model;

import com.fererlab.query.core.model.QueryModel;

import javax.persistence.*;

@Entity
@Table(name = "CITY_TABLE")
@NamedQueries({
        @NamedQuery(name = "CITY_TABLE_FIND_BY_NAME", query = "select c from CityQuery c where c.name = :name")
})
public class CityQuery implements QueryModel<Integer> {

    private static final long serialVersionUID = -5819948978970016787L;

    public static final String NQ_FIND_BY_NAME = "CITY_TABLE_FIND_BY_NAME";

    private Integer id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "CT_NAME", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
