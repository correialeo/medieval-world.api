package br.com.fiap.medieval_world.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @NotNull(message = "Campo obrigatório")
    private EPersonagemClass classe;
    @NotNull(message = "Campo obrigatório")
    @Min(value = 1, message = "O nível deve ser maior que 0")
    private Integer nivel;
    @PositiveOrZero(message = "Moeda deve ser igual ou maior que zero")
    private BigDecimal moedas;
}