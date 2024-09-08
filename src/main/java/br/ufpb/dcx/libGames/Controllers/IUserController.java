package br.ufpb.dcx.libGames.Controllers;

public interface IUserController {
    boolean createUser(String name, String username, String birthday);
    boolean deleteUser(String username);
}
