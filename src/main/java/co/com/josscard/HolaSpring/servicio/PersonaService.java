package co.com.josscard.HolaSpring.servicio;

import co.com.josscard.HolaSpring.domain.Persona;
import java.util.List;

public interface PersonaService {
    
    public List<Persona> listarPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarpersona(Persona persona);
}
