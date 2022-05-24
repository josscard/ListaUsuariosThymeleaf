
package co.com.josscard.HolaSpring.servicio;

import co.com.josscard.HolaSpring.Dao.PersonaDao;
import co.com.josscard.HolaSpring.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
       return (List<Persona>) personaDao.findAll();
        
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
        
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarpersona(Persona persona) {
        
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
