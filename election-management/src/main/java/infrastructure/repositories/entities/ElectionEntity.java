package infrastructure.repositories.entities;

import domain.Election;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "elections")
public class ElectionEntity {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static ElectionEntity fromDomain(Election domain) {
        ElectionEntity entity = new ElectionEntity();
        entity.setId(domain.id());

        return entity;
    }
}
