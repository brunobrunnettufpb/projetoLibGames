package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class GravadorDeDadosController {
    public static final String USERSFILE = "./users.dat";
    public static final String GAMESFILE = "./games.dat";

    public void SaveUsers(Map<String, User> dados) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USERSFILE))) {
            out.writeObject(dados);
        }
    }

    public void SaveGames(Map<String, Game> dados) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(GAMESFILE))) {
            out.writeObject(dados);
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    public Map<String, User> LoadUsers() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(USERSFILE))) {
            return (Map<String, User>) in.readObject();
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    public Map<String, Game> LoadGames() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(GAMESFILE))) {
            return (Map<String, Game>) in.readObject();
        }
        catch (Exception ex) {
            throw ex;
        }
    }
}
