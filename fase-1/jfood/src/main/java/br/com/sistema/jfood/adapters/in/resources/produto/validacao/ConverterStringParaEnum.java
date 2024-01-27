package br.com.sistema.jfood.adapters.in.resources.produto.validacao;

import br.com.sistema.jfood.adapters.in.resources.produto.exception.ConverterStringParaEnumException;
import br.com.sistema.jfood.adapters.in.resources.produto.request.CategoriaRequest;
import org.springframework.core.convert.converter.Converter;

public class ConverterStringParaEnum implements Converter<String, CategoriaRequest> {
    @Override
    public CategoriaRequest convert(String source) {
        try {
            return CategoriaRequest.valueOf(source.toUpperCase());
        } catch (Exception e) {
            throw new ConverterStringParaEnumException(source);
        }
    }
}
