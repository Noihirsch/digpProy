package com.example.pocketHero.domains;
import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.ToString;


public class Player {
        public Player(){}

    @Id
    @GeneratedValue
    @JoinColumn(name="username")
    private String username;

    @ToString.Exclude 
    @OneToMany
    @JoinColumn (name="CHARACTER_ID") //opcional
    private List <Character> listOfCharacters;

    @Email (message = "Debe tener formato email válido")
    @NotEmpty
    private String email; 

    @NotEmpty
    private String password; 

      @ManyToOne
    @JoinColumn (name= "CAMPAIGN_ID", foreignKey = @ForeignKey(name="CAMPAIGN_KEY_FK"))
    @OnDelete (action = OnDeleteAction.CASCADE)
    private Campaign campaign;

    @NotEmpty
    private String icon; 

}
