package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.AtualizarUsuario;
import br.com.alura.codechella.application.usecases.CadastrarUsuario;
import br.com.alura.codechella.application.usecases.ExcluirUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CadastrarUsuario cadastrarUsuario;

    private final ListarUsuarios listarUsuarios;

    private final ExcluirUsuario exluirUsuario;

    private final AtualizarUsuario atualizarUsuario;


    public UsuarioController(CadastrarUsuario cadastrarUsuario, ListarUsuarios listarUsuarios, ExcluirUsuario exluirUsuario, AtualizarUsuario atualizarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.exluirUsuario = exluirUsuario;
        this.atualizarUsuario = atualizarUsuario;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = cadastrarUsuario.cadastrarUsuario(new Usuario(dto.id(), dto.cpf(), dto.nome(), dto.email(), dto.nascimento()));
        return new UsuarioDto(salvo.getId(), salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuario() {
        return listarUsuarios.listarUsuarios().stream()
                .map(u -> new UsuarioDto(u.getId(), u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @PutMapping
    public UsuarioDto atualizarUsuario(@RequestBody UsuarioDto dto) {
        Usuario atualizado = atualizarUsuario.atualizar(new Usuario(dto.id(), dto.cpf(), dto.nome(), dto.email(), dto.nascimento()));
        return new UsuarioDto(atualizado.getId(), atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(), atualizado.getEmail());
    }


    @DeleteMapping("/{id}")
    public Void excluir(@PathVariable Long id) {
        exluirUsuario.excluir(id);
        return null;
    }

}
