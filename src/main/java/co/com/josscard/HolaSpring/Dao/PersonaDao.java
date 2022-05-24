
package co.com.josscard.HolaSpring.Dao;

import co.com.josscard.HolaSpring.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona, Long>{
    
}
