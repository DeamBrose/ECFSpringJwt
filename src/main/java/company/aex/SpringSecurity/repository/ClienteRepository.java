package company.aex.SpringSecurity.repository;

import company.aex.SpringSecurity.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public Cliente findByNombre(String username);
}
