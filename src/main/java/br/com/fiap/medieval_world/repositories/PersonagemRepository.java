package br.com.fiap.medieval_world.repositories;

import br.com.fiap.medieval_world.models.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
