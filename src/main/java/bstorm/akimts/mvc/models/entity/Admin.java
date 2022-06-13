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
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Utilisateur{

    private UUID ref;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ADMIN_READ"),
                new SimpleGrantedAuthority("READ"),
                new SimpleGrantedAuthority("WRITE")
        );
    }
}
