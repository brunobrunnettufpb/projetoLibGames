package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Exceptions.UsuarioJaExisteException;
import br.ufpb.dcx.libGames.Exceptions.UsuarioNaoExisteException;

public interface ISystemLibGames {
    boolean userCreate(String name, String username, double saldo) throws Exception;
    boolean userDelete(String username) throws Exception;
    void userReport() throws UsuarioNaoExisteException;

//    boolean gameBuy() throws UsuarioNaoExisteException;
    boolean gameRefund() throws Exception;
    void gameReport();
}
