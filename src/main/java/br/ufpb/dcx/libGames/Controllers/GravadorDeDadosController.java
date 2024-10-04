package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class GravadorDeDadosController {
    public void SaveUsers(Map<String, User> dados) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./users.txt"))) {
            out.writeObject(dados);
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    public void SaveGames(Map<String, Game> dados) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./games.txt"))) {
            out.writeObject(dados);
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    public Map<String, User> LoadUsers() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./games.txt"))) {
            return (Map<String, User>) in.readObject();
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    public Map<String, Game> LoadGames() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("games.txt"))) {
            return (Map<String, Game>) in.readObject();
        }
        catch (Exception ex) {
            throw ex;
        }
    }
}
