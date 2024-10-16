package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Exceptions.JogoJaCompradoException;
import br.ufpb.dcx.libGames.Exceptions.SaldoInsuficienteException;
import br.ufpb.dcx.libGames.Exceptions.UsuarioJaExisteException;
import br.ufpb.dcx.libGames.Exceptions.UsuarioNaoExisteException;
import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;
import br.ufpb.dcx.libGames.Models.Value;

import java.util.List;

public class SystemLibGames implements ISystemLibGames {
    private UserController users;
    private BuyController boughts;
    private GameController games;

    public SystemLibGames() {
        users = new UserController();
        boughts = new BuyController();
        games = new GameController();
    }
    public boolean userCreate(String username, String name, double saldo) throws Exception {
        if (users.getUser(username) == null) {
            users.createUser(new User(username, name, new Value(saldo, "BRL", "R$")));
            return true;
        }

        throw new UsuarioJaExisteException("Usuário já cadastrado!");
    }

    public boolean userDelete(String username) throws UsuarioNaoExisteException {
        if (users.getUser(username) != null) {
            users.deleteUser(new User(username, "", new Value(0, "BRL", "R$")));
            return true;
        }
        throw new UsuarioNaoExisteException("Usuário não cadastrado!");
    }

    public User getUser(String username) {
        return users.getUser(username);
    }
    public Game getGame(String gameName) {
        return games.getGame(gameName);
    }
    public Game getGame(int id) {
        return games.getGame(id);
    }
    public int getQtdGames() {
        return games.getQtdGames();
    }
    public int getQtdUsers() {
        return users.getQtdUsers();
    }
    public String getAllUsers() {
        List<User> users = this.users.getAllUsers();
        String usersStr = "";
        for (User user: users) {
            usersStr += user.getUsername() + ",";
        }
        return usersStr;
    }

    public void userReport() {
        //TODO: Função para exibir tudo o que o usuário tem.
    }

    public boolean gameBuy(User user, Game game) throws Exception {
        if (!users.checkExistsUser(user.getUsername())) {
            throw new UsuarioNaoExisteException("Usuário não cadastrado!");
        }

        if (user.getBalance().getValue() < game.getPrice().getValue()) {
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }

        for (Game userGame: user.getGames().values()) {
            if (userGame.equals(game)) {
                throw new JogoJaCompradoException("Usuário já possui este jogo!");
            }
        }

        user.remBalance(game.getPrice());
        user.addGame(game);
        users.updateUser(user);


        return true;
    }

    public boolean gameRefund() {
        //TODO: Função para usuário devolver um jogo, caso não tenha passado 7 dias.
        //TODO: Remover do Map<> e adicionar o valor pago de volta ao usuário.

        return false;
    }

    public void gameReport() {
        //TODO: Função para exibir todos os dados do jogo.
    }
}
