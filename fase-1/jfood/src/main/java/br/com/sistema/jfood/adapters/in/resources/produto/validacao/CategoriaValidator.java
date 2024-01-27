package br.com.sistema.jfood.adapters.in.resources.produto.validacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CategoriaValidator implements ConstraintValidator<ValidaCategoria,CharSequence> {

    private List<String> categoriaValidas;

    @Override
    public void initialize(ValidaCategoria constraintAnnotation) {

        categoriaValidas = Stream.of(constraintAnnotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(charSequence)) {
            return true;
        }

        return categoriaValidas.contains(charSequence.toString());
    }
}
