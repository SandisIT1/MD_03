package lv.va.sludinajumuportals.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String surname;
    Character type;

    public User() {
    }

    public User(Long id, String name, String surname, Character type) 
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.type = type;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getSurname() 
    {
        return surname;
    }

    public void setSurname(String surname) 
    {
        this.surname = surname;
    }

    public Character getType(Character type) 
    {
        return type;
    }

    public void setType(Character type) 
    {
        this.type = type;
    }
}
