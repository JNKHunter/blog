package tech.eats.art.blog.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by John on 11/15/16.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(targetEntity = Entry.class, mappedBy = "categories")
    private List<Entry> entries;

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
}
