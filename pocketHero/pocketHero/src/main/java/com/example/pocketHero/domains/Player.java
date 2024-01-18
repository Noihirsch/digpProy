package com.example.pocketHero.domains;
import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "PLAYER")
@Getter
@Setter

public class Player {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @NotEmpty
    @Column(name = "username")
    private String username;

    @Email(message = "Debe tener formato email valido")
    @Column(name = "email")
    private String email;
    
    @NotEmpty
    @Column(name = "password")
    private String password; 

    @ToString.Exclude 
    @OneToMany
    @JoinColumn (name="CHARACTER_ID")
    private List <Character> listOfCharacters;


    @ManyToOne
    @JoinColumn (name= "CAMPAIGN_ID", foreignKey = @ForeignKey(name="CAMPAIGN_KEY_FK"))
    @OnDelete (action = OnDeleteAction.CASCADE)
    private Campaign campaign;

    


}
