package com.league.domain;


import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "Club")
@NamedQueries({
        @NamedQuery(name = "club.getAll", query = "Select c from Club c")})

public class Club {

    private Long idClub;
    private String name;
    private String owner;
    private String city;
    private int capacity;

    private List<Player> players = new ArrayList<Player>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getIdClub() {
        return idClub;
    }
    public void setIdClub(Long idClub) {
        this.idClub = idClub;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "club")
    @JsonIgnore
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
