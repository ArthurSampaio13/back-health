package br.com.bitwise.bithealth.modules.user.repository;

import br.com.bitwise.bithealth.modules.user.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByNumeroTelefone(String telefone);
    Usuario getUsuarioById(UUID id);
    Usuario getUsuarioByEmail(String email);
}
