package br.com.fiap.medieval_world.specification;

import br.com.fiap.medieval_world.controllers.PersonagemController;
import br.com.fiap.medieval_world.models.Personagem;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PersonagemSpecification {

    public static Specification<Personagem> withFilters(PersonagemController.PersonagemFilter filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.nome() != null && !filter.nome().isBlank()) {
                predicates.add(
                        builder.like(builder.lower(root.get("nome")), "%" + filter.nome().toLowerCase() + "%")
                );
            }

            if (filter.classe() != null) {
                predicates.add(
                        builder.equal(root.get("classe"), filter.classe())
                );
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}