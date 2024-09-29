package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Controllers.UserController;
import br.ufpb.dcx.libGames.Controllers.BuyController;
import br.ufpb.dcx.libGames.Exceptions.UsuarioJaExisteException;
import br.ufpb.dcx.libGames.Exceptions.UsuarioNaoExisteException;
import br.ufpb.dcx.libGames.Models.User;
import br.ufpb.dcx.libGames.Models.Value;

public class SystemLibGames implements ISystemLibGames {
    private UserController users;
    private BuyController boughts;

    public SystemLibGames() {
        users = new UserController();
        boughts = new BuyController();
    }
    public boolean userCreate(String name, String username, double saldo) throws UsuarioJaExisteException {
        if (users.getUser(username) == null) {
            users.createUser(new User(name, username, new Value(saldo, "BRL", "R$")));
            return true;
        }

        throw new UsuarioJaExisteException("Usuário já cadastrado!");
    }

    public boolean userDelete(String username) throws UsuarioNaoExisteException {
        if (users.getUser(username) != null) {
            users.deleteUser(new User("", username, new Value(0, "BRL", "R$")));
            return true;
        }
        throw new UsuarioNaoExisteException("Usuário não cadastrado!");
    }

    public User getUser(String username) throws UsuarioNaoExisteException {
        return users.getUser(username);
    }

    public void userReport() {
        //TODO: Função para exibir tudo o que o usuário tem.
    }

    public boolean gameBuy() {
        //TODO: Função para usuário comprar um jogo.
        //TODO: Verificar se o usuário tem saldo disponível, subtrair o saldo e adicionar no Map<>

        return false;
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
