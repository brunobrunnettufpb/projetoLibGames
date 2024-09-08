package br.ufpb.dcx.libGames.Controllers;

public interface ISystemLibGames {
    boolean userCreate();
    boolean userDelete();
    void userReport();

    boolean gameBuy();
    boolean gameRefund();
    void gameReport();
}
