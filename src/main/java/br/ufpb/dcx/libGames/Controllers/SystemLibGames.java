package br.ufpb.dcx.libGames.Controllers;

public class SystemLibGames implements ISystemLibGames {
    public boolean userCreate() {
        //TODO: Função para criar um usuário.
        return false;
    }

    public boolean userDelete() {
        //TODO: Função para deletar um usuário.
        return false;
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
