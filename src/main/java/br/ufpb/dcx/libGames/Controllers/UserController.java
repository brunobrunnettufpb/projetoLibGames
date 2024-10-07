package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Exceptions.UsuarioJaExisteException;
import br.ufpb.dcx.libGames.Exceptions.UsuarioNaoExisteException;
import br.ufpb.dcx.libGames.Models.User;
import br.ufpb.dcx.libGames.Models.Value;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class UserController implements IUserController {
    private Map<String, User> users;
    private GravadorDeDadosController gravador = new GravadorDeDadosController();

    public UserController() {
        try {
            this.users = gravador.LoadUsers();
        }
        catch (Exception ex) {
            this.users = new HashMap<>();
        }
    }

    public boolean createUser(User user) throws Exception {
        if (!checkExistsUser(user.getName())) {
            users.put(user.getName(), user);
            try {
                gravador.SaveUsers(this.users);
            }
            catch (Exception ex) {
                throw ex;
            }
            return true;
        }
        throw new UsuarioJaExisteException("Usuário já cadastrado!");
    }
    public boolean updateUser(User user) throws Exception {
        if (checkExistsUser(user.getName())) {
//            users.replace(user.getUsername(), user);
            users.put(user.getName(), user);
            try {
                gravador.SaveUsers(this.users);
            }
            catch (Exception ex) {
                throw ex;
            }

            return true;
        }
        throw new UsuarioNaoExisteException("Usuário não cadastrado!");
    }
    public boolean deleteUser(User user) throws UsuarioNaoExisteException {
        if (checkExistsUser(user.getName())) {
            users.remove(user.getName());
            return true;
        }
        throw new UsuarioNaoExisteException("Usuário não cadastrado!");
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public boolean addFund(User user, Value value) throws UsuarioNaoExisteException {
        if (!checkExistsUser(user.getName())) {
            throw new UsuarioNaoExisteException("Usuário não cadastrado!");
        }

        users.get(user.getName()).addBalance(value);
        return true;
    }

    public boolean remFund(User user, Value value) throws UsuarioNaoExisteException {
        if (!checkExistsUser(user.getName())) {
            throw new UsuarioNaoExisteException("Usuário não cadastrado!");
        }

        users.get(user.getName()).remBalance(value);
        return true;
    }


    public boolean checkExistsUser(String username) {
        return users.get(username) != null;
    }
}
