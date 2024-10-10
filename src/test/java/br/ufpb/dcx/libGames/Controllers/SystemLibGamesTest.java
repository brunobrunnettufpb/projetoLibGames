package br.ufpb.dcx.libGames.Controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SystemLibGamesTest {
    @Test
    public void TestarCadadastroUsuario() {
        SystemLibGames sistema = new SystemLibGames();

        assertEquals(3, sistema.getQtdGames()); // Verifica se tem 3 jogos
        try {
            sistema.userCreate("Joao", "jo22", 50);
//            assertEquals(sistema.get);
        }
        catch (Exception ex) {

        }
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
