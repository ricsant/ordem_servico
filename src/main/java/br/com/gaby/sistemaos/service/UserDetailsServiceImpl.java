package br.com.gaby.sistemaos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.gaby.sistemaos.domain.ModelAnswer;
import br.com.gaby.sistemaos.domain.User;
import br.com.gaby.sistemaos.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelAnswer ma;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByUsername(username);

        return userOpt.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }
    
    public Iterable<User> listAll() {
        return userRepository.findAll();
    }

    public List<String> autocomplete(String name) {
        return userRepository.autocomplete(name);
    }

    public Iterable<User> listByName(String name) {
        return userRepository.findByName(name);
    }

    public ResponseEntity<?> createUpdate(User user, String action) {
        
        if ("".equals(user.getName())) {
            ma.setMessage("O nome do usuário é obrigatório");
            return new ResponseEntity<ModelAnswer>(ma, HttpStatus.BAD_REQUEST);
        } else if ("".equals(user.getUsername())) {
            ma.setMessage("O login do usuário é obrigatório");
            return new ResponseEntity<ModelAnswer>(ma, HttpStatus.BAD_REQUEST);
        } else if ("".equals(user.getPassword()) && "cadastrar".equals(action)) {
            ma.setMessage("A senha do usuário é obrigatória");
            return new ResponseEntity<ModelAnswer>(ma, HttpStatus.BAD_REQUEST);
        } else {
            if ("cadastrar".equals(action)) {
                return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<ModelAnswer> delete(Long id) {
        userRepository.deleteById(id);

        ma.setMessage("O usuário foi removido com sucesso!");

        return new ResponseEntity<ModelAnswer>(ma, HttpStatus.OK);
    }
}
