package br.com.gaby.sistemaos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gaby.sistemaos.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	Iterable<User> findByName(String name);

	@Query("SELECT u.name FROM User u WHERE u.name LIKE CONCAT('%',:name,'%')")
	List<String> autocomplete(@Param("name") String name);
	
}
