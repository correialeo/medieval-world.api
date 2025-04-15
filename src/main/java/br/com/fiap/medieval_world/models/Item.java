package br.com.fiap.medieval_world.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @NotNull(message = "Campo obrigatório")
    private EItemType type;
    @NotNull(message = "Campo obrigatório")
    private EItemRarity rarity;
    @NotNull(message = "Campo obrigatório")
    @Positive(message = "Preço precisa ser maior que zero.")
    private BigDecimal price;
    @NotNull(message = "O item deve ter um dono.")
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Personagem owner;
}