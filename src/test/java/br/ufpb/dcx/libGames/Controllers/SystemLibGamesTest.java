package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class SystemLibGamesTest {
    SystemLibGames sistema = new SystemLibGames();

    @BeforeEach
    @AfterEach
    void ExcluiArquivo() {
        File file = new File(GravadorDeDadosController.USERSFILE);
        if (file.exists()) file.delete();
    }

    @Test
    void TestarCadadastroUsuario() {
        try {
            sistema.userCreate("jo22", "João", 50); // Cadastra no sistema
            assertEquals(1, sistema.getQtdUsers()); // Checa se cadastrou anterior.

            sistema.userCreate("mar80", "Maria", 100); // Cadastra no sistema
            assertEquals(2, sistema.getQtdUsers()); // Checa se cadastrou anterior.
        }
        catch (Exception ex) {
        }
    }

    @Test
    void TestarBuscarUsuario() {
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
    void TestarCadastrarJogos() {
        assertEquals(3, sistema.getQtdGames()); // Verifica se tem os 3 jogos cadastrados no sistema.
        assertNotNull(sistema.getGame("Witcher 3"));
        assertNotNull(sistema.getGame("Divinity 2"));
        assertNotNull(sistema.getGame("Baldurs Gate 3"));
    }

    @Test
    void TestarCompraDeJogo() {
        try {
            sistema.userCreate("jo22", "João", 50); // Cadastra no sistema
            User joao = sistema.getUser("jo22");
            assertTrue(joao.getGames().isEmpty()); // Verifica que não tem nenhum jogo comprado.

            Game game = sistema.getGame("Witcher 3");
            sistema.gameBuy(joao, game);
            joao = sistema.getUser("jo22"); // Atualiza pra poder verificar a compra.

            assertEquals(1, joao.getGames().size());

            game = sistema.getGame("Divinity 2");
            sistema.gameBuy(joao, game);
            joao = sistema.getUser("jo22"); // Atualiza pra poder verificar a compra.

            assertEquals(1, joao.getGames().size());
        }
        catch (Exception ex) {
        }
    }

    @Test
    void TestarDeletarUsuario() {
        try {
            sistema.userCreate("jo22", "João", 50); // Cadastra no sistema
            sistema.userCreate("mar80", "Maria", 100); // Cadastra no sistema
            assertEquals(2, sistema.getQtdUsers()); // Checa os que cadastrou anteriormente.

            sistema.userDelete("mar80");
            assertEquals(1, sistema.getQtdUsers()); // Checa se removeu.
            sistema.userDelete("jo22");
            assertEquals(0, sistema.getQtdUsers()); // Checa se removeu.
        }
        catch (Exception ex) {

        }
    }
}
