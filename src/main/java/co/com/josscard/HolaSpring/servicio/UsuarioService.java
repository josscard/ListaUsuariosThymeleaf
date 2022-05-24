
package co.com.josscard.HolaSpring.servicio;

import co.com.josscard.HolaSpring.Dao.UsuarioDao;
import co.com.josscard.HolaSpring.domain.Rol;
import co.com.josscard.HolaSpring.domain.Usuario;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario =usuarioDao.findByUsername(username);
        
        if (usuario==null) {
            throw new UsernameNotFoundException(username);
        }
        
        ArrayList roles = new ArrayList<GrantedAuthority>();
        
        usuario.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
    
}
