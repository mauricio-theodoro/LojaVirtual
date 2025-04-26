package com.loja.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando um recurso não é encontrado.
 * Mapeada para status HTTP 404 (NOT FOUND).
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Construtor que recebe a mensagem de erro.
     *
     * @param message detalhe sobre o recurso não encontrado
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
