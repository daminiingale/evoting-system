package com.damini.evoting.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String party;

    public Candidates() {
    }

    public Candidates(String name, String party) {
        this.name = name;
        this.party = party;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }
}