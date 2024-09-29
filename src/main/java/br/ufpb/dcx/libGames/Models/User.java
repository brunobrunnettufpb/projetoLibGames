package br.ufpb.dcx.libGames.Models;

import java.util.*;

public class User {
    private int id;
    private String name;
    private Date birthday;
    private String username;
    private Value balance;
    private HashMap<String, Game> games;

    public User(String username, String name, Date birthday, Value balance, HashMap<String, Game> games) {
        this.name = name;
        this.birthday = birthday;
        this.username = username;
        this.balance = balance;
        this.games = games;
    }

    public User(String username, String name, Value balance) {
        this(username, name, new Date(1900, Calendar.JANUARY, 1), balance, new HashMap<String, Game>());
    }

    public User() {
        this("", "", new Date(1900, Calendar.JANUARY, 1), new Value(0.0,"BRL", "R$"), new HashMap<String, Game>());
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Value getBalance() {
        return balance;
    }
    public void setBalance(Value balance) {
        this.balance = balance;
    }
    public boolean addBalance(Value value) {
        this.balance.setValue(this.balance.getValue() + value.getValue());
        return true;
    }
    public boolean remBalance(Value value) {
        if (this.balance.getValue()-value.getValue() < 0) {
            return false;
        }

        this.balance.setValue(this.balance.getValue() - value.getValue());
        return true;
    }

    public Game getGame(String gameName) {
        return this.games.get(gameName);
    }
    public HashMap<String, Game> getGames() {
        return games;
    }
    public boolean addGame(Game game) {
        this.games.put(game.getName(), game);
        return true;
    }
    public boolean remGame(Game game) {
        this.games.remove(game);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(username);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(birthday);
        return result;
    }

    @Override
    public String toString() {
        String lib = this.games.toString(); //TODO: Percorrer a lista e concatenar na string (usar foreach (e talvez StringBuilder())
        return String.format("Usuário de ID {} de nome {} com username {} nascido em {} possui {}{} de saldo e possui os jogos {}.", this.id, this.name, this.username, this.birthday, this.balance.getSymbol(), this.balance.getValue(), lib);
    }
}
