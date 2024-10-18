package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Exceptions.UsuarioJaExisteException;
import br.ufpb.dcx.libGames.Exceptions.UsuarioNaoExisteException;
import br.ufpb.dcx.libGames.Models.User;
import br.ufpb.dcx.libGames.Models.Value;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        if (!checkExistsUser(user.getUsername())) {
            users.put(user.getUsername(), user);
            gravador.SaveUsers(this.users);

            return true;
        }
        throw new UsuarioJaExisteException("Usuário já cadastrado!");
    }
    public boolean updateUser(User user) throws Exception {
        if (checkExistsUser(user.getUsername())) {
            users.put(user.getUsername(), user);
            gravador.SaveUsers(this.users);

            return true;
        }
        throw new UsuarioNaoExisteException("Usuário não cadastrado!");
    }
    public boolean deleteUser(User user) throws UsuarioNaoExisteException {
        if (checkExistsUser(user.getUsername())) {
            users.remove(user.getUsername());
            return true;
        }
        throw new UsuarioNaoExisteException("Usuário não cadastrado!");
    }

    public User getUser(String username) {
        return users.get(username);
    }
    public List<User> getAllUsers() {
        return new ArrayList<>(this.users.values());
    }

    public boolean addFund(User user, Value value) throws UsuarioNaoExisteException {
        if (!checkExistsUser(user.getUsername())) {
            throw new UsuarioNaoExisteException("Usuário não cadastrado!");
        }

        users.get(user.getUsername()).addBalance(value);
        return true;
    }

    public boolean remFund(User user, Value value) throws UsuarioNaoExisteException {
        if (!checkExistsUser(user.getUsername())) {
            throw new UsuarioNaoExisteException("Usuário não cadastrado!");
        }

        users.get(user.getUsername()).remBalance(value);
        return true;
    }

    public int getQtdUsers() {
        return this.users.size();
    }

    public boolean checkExistsUser(String username) {
        return users.get(username) != null;
    }
}
