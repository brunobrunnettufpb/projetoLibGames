package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.User;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class SystemLibGamesTest {
    @Test
    public void TestarCadadastroUsuario() {
        File file = new File(GravadorDeDadosController.USERSFILE);
        if (file.exists()) file.delete();

        SystemLibGames sistema = new SystemLibGames();

        assertEquals(3, sistema.getQtdGames()); // Verifica se tem 3 jogos
        try {
            sistema.userCreate("João", "jo22", 50);
            assertEquals(1, sistema.getQtdUsers()); // Checa se cadastrou João
            User jo = sistema.getUser("jo22");
            assertEquals("João", jo.getName()); // Checa se o nome é João
            assertEquals("jo22", jo.getUsername()); // Checa se o username é jo22
            assertEquals(50, jo.getBalance().getValue()); // Checa se o saldo é R$50

            sistema.userCreate("Maria", "mar80", 100);
            User maria = sistema.getUser("mar80");
            assertEquals(1, sistema.getQtdUsers()); // Checa se cadastrou Maria
            assertEquals("Maria", maria.getName()); // Checa se o nome é Maria
            assertEquals("mar80", maria.getUsername()); // Checa se o username é mar80
            assertEquals(100, maria.getBalance().getValue()); // Checa se o saldo é R$100
        }
        catch (Exception ex) {

        }
        file.delete();
    }

    @Test
    public void TestarCompraDeJogo() {
        // TODO: Compra de jogo.
    }

    @Test
    public void TestarPersistencia() {
        // TODO: Cadastrar usuário, comprar jogo e persistir os dados.
    }

    @Test
    public void TestarPersistenciaRecuperar() {
        // TODO: Recuperar os dados e verificar usuários cadastrados na função anterior.
        // TODO: Verificar a quantidades de jogos inserido na lista do usuário.
        // TODO: Verificar saldo do usuário.
    }
}
