package br.com.fiap.medieval_world.repositories;

import br.com.fiap.medieval_world.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
