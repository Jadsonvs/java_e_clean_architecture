package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CadastrarUsuarioUseCase;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuario;


    public UsuarioController(CadastrarUsuarioUseCase cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = cadastrarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.email(), dto.nascimento()));
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }

}
