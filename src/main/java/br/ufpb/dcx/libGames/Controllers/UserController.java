package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.User;

import java.util.Map;

public class UserController implements IUserController {
    private Map<Integer, User> users;

    public boolean createUser(String name, String username, String birthday) {
        return false;
    }
    public boolean deleteUser(String username) {
        return false;
    }
}
