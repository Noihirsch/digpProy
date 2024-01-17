package com.example.pocketHero.domains;
import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class Player {
    @Id
    @GeneratedValue
    @JoinColumn(name="id")
    private Long id;

    @NotEmpty
    private String username;

    @Email(message = "Debe tener formato email valido")
    private String email;
    
    @NotEmpty
    private String password; 

    @ToString.Exclude 
    @OneToMany
    @JoinColumn (name="CHARACTER_ID") //opcional
    private List <Character> listOfCharacters;


    @ManyToOne
    @JoinColumn (name= "CAMPAIGN_ID", foreignKey = @ForeignKey(name="CAMPAIGN_KEY_FK"))
    @OnDelete (action = OnDeleteAction.CASCADE)
    private Campaign campaign;


}
