package bstorm.akimts.mvc.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import javax.persistence.Entity;
import java.util.Collection;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manager extends Utilisateur {

    private String poste;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_MANAGER"),
                new SimpleGrantedAuthority("READ"),
                new SimpleGrantedAuthority("WRITE")
        );
    }
}
