
package co.com.josscard.HolaSpring.Dao;

import co.com.josscard.HolaSpring.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}
