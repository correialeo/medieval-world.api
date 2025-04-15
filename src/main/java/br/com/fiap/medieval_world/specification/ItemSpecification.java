package br.com.fiap.medieval_world.specification;

import br.com.fiap.medieval_world.controllers.ItemController;
import br.com.fiap.medieval_world.models.Item;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class ItemSpecification {

    public static Specification<Item> withFilters(ItemController.ItemFilter filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.nome() != null && !filter.nome().isBlank()) {
                predicates.add(
                        builder.like(builder.lower(root.get("nome")), "%" + filter.nome().toLowerCase() + "%")
                );
            }

            if (filter.tipo() != null) {
                predicates.add(
                        builder.equal(root.get("type"), filter.tipo())
                );
            }

            if (filter.raridade() != null) {
                predicates.add(
                        builder.equal(root.get("rarity"), filter.raridade())
                );
            }

            if (filter.precoMin() != null && filter.precoMax() != null) {
                predicates.add(
                        builder.between(root.get("price"), filter.precoMin(), filter.precoMax())
                );
            } else if (filter.precoMin() != null) {
                predicates.add(
                        builder.greaterThanOrEqualTo(root.get("price"), filter.precoMin())
                );
            } else if (filter.precoMax() != null) {
                predicates.add(
                        builder.lessThanOrEqualTo(root.get("price"), filter.precoMax())
                );
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
