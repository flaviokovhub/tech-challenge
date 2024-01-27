package br.com.sistema.jfood.adapters.in.resources.cliente.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record CadastraClienteRequest(@CPF String cpf, @NotBlank String nome, @Email String email) {
}
