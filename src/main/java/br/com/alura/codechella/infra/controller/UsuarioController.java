package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CadastrarUsuarioUseCase;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuario;

    private final ListarUsuarios listarUsuarios;


    public UsuarioController(CadastrarUsuarioUseCase cadastrarUsuario, ListarUsuarios listarUsuarios) {
        this.cadastrarUsuario = cadastrarUsuario;
        this.listarUsuarios = listarUsuarios;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = cadastrarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.email(), dto.nascimento()));
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuario() {
        return listarUsuarios.listarUsuarios().stream()
                .map(u -> new UsuarioDto(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }

}
