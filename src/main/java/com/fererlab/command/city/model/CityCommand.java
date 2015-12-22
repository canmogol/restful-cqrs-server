package com.fererlab.command.city.model;

import com.fererlab.command.core.model.CommandModel;

import javax.persistence.*;

@Entity
@Table(name = "CITY_TABLE")
@NamedQueries({
        @NamedQuery(name = "CITY_TABLE_DELETE_BY_NAME", query = "delete from CityCommand c where c.name = :name")
})
public class CityCommand implements CommandModel<Integer> {

    private static final long serialVersionUID = -3238748978970047586L;

    public static final String NQ_DELETE_BY_NAME = "CITY_TABLE_DELETE_BY_NAME";

    private Integer id;
    private String name;
    private String hiddenName;
    private Integer population;

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

    @Column(name = "CT_HIDDEN_NAME", length = 100)
    public String getHiddenName() {
        return hiddenName;
    }

    public void setHiddenName(String hiddenName) {
        this.hiddenName = hiddenName;
    }

    @Column(name = "CT_POPULATION")
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

}
