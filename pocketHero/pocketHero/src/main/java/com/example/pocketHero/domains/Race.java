import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Race {

    @Id
    @GeneratedValue
    @Column(name="player_id")
    private Long id;

    private String name;

    private String description;

    private Long speed;

    private String size;

    private Language language;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trait> traits;
}