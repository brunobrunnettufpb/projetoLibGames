package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class SystemLibGamesTest {
    SystemLibGames sistema = new SystemLibGames();

    @BeforeAll
    @AfterAll
    static void ExcluiArquivo() {
        File file = new File(GravadorDeDadosController.USERSFILE);
        if (file.exists()) file.delete();
    }

    @Test
    void TestarCadadastroUsuario() {
        try {
            sistema.userCreate("jo22", "João", 50); // Cadastra no sistema
            User jo = sistema.getUser("jo22"); // Pega para checar se cadastrou correto
            assertEquals("João", jo.getName()); // Checa se o nome é João
            assertEquals("jo22", jo.getUsername()); // Checa se o username é jo22
            assertEquals(50, jo.getBalance().getValue()); // Checa se o saldo é R$50

            sistema.userCreate("mar80", "Maria", 100); // Cadastra no sistema
            User maria = sistema.getUser("mar80"); // Pega para checar se cadastrou correto
            assertEquals("Maria", maria.getName()); // Checa se o nome é Maria
            assertEquals("mar80", maria.getUsername()); // Checa se o username é mar80
            assertEquals(100, maria.getBalance().getValue()); // Checa se o saldo é R$100
        }
        catch (Exception ex) {
        }
    }

    @Test
    void TestarBuscarUsuario() {
        assertEquals(2, sistema.getQtdUsers()); // Checa se cadastrou os 2 no teste anterior.
    }

    @Test
    void TestaCadastrarJogos() {
        assertEquals(3, sistema.getQtdGames()); // Verifica se tem os 3 jogos cadastrados no sistema.
    }

    @Test
    void TestarCompraDeJogo() {
        try {
            User joao = sistema.getUser("jo22");
            assertTrue(joao.getGames().isEmpty()); // Verifica que não tem nenhum jogo comprado.

            Game game = sistema.getGame("Witcher 3");
            sistema.gameBuy(joao, game);
            joao = sistema.getUser("jo22"); // Atualiza pra poder verificar a compra.

            assertEquals(1, joao.getGames().size());
        }
        catch (Exception ex) {
        }
    }
}
