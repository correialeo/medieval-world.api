package br.com.fiap.medieval_world.controllers;

import br.com.fiap.medieval_world.models.EItemRarity;
import br.com.fiap.medieval_world.models.EItemType;
import br.com.fiap.medieval_world.models.Item;
import br.com.fiap.medieval_world.repositories.ItemRepository;
import br.com.fiap.medieval_world.specification.ItemSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/item")
@Slf4j
public class ItemController {

    public record ItemFilter(
            String nome,
            EItemType tipo,
            EItemRarity raridade,
            BigDecimal precoMin,
            BigDecimal precoMax
    ) {}

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    @Cacheable("item")
    @Operation(description = "Get all items", tags = "item", summary = "Item's list")
    public List<Item> index(ItemFilter filter) {
        Specification<Item> specification = ItemSpecification.withFilters(filter);
        return itemRepository.findAll(specification);
    }

    @PostMapping
    @CacheEvict(value = "item", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(responses = {
            @ApiResponse(responseCode = "400", description = "Validation error")
    })
    public ResponseEntity<Item> createItem(@RequestBody @Valid Item item) {
        itemRepository.save(item);
        return ResponseEntity.status(201).body(item);
    }

    @GetMapping("{id}")
    public Item getById(@PathVariable Long id) {
        return getItem(id);
    }

    @PutMapping("{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody @Valid Item updatedItem) {
        Item existingItem = getItem(id);

        existingItem.setNome(updatedItem.getNome());
        existingItem.setType(updatedItem.getType());
        existingItem.setRarity(updatedItem.getRarity());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setOwner(updatedItem.getOwner());

        return itemRepository.save(existingItem);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.delete(getItem(id));
    }

    private Item getItem(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));
    }
}
