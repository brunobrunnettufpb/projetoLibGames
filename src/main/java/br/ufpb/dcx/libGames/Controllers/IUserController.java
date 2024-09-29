package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Exceptions.UsuarioJaExisteException;
import br.ufpb.dcx.libGames.Exceptions.UsuarioNaoExisteException;
import br.ufpb.dcx.libGames.Models.User;

public interface IUserController {

    boolean createUser(User user) throws UsuarioJaExisteException;
    boolean deleteUser(User user) throws UsuarioNaoExisteException;
}
