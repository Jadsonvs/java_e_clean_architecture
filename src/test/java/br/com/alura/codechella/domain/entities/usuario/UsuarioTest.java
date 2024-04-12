package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "Jadson", "jadson@email.com", LocalDate.parse("1994-08-09")));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678999", "Jadson", "jadson@email.com", LocalDate.parse("1994-08-09")));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456789-99", "Jadson", "jadson@email.com", LocalDate.parse("1994-08-09")));
    }
}
