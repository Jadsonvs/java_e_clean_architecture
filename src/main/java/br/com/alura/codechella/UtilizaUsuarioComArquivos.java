package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivos {

    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-01", "Jadson Santos",
                "santos@email.com", LocalDate.parse("1994-04-12")));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-02", "Carol Martins",
                "carol@email.com", LocalDate.parse("1994-04-12")));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-03", "Jefferson Amador",
                "jefferson@email.com", LocalDate.parse("1994-04-12")));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-04", "adriana Viana",
                "adriana@email.com", LocalDate.parse("1994-04-12")));

//        System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());
        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");
    }
}
