package br.ufpb.dcx.libGames.Models;

import java.util.*;

public class User {
    private int id;
    private String username;
    private String name;
    private Date birthday;
    private Value balance;
    private List<Game> games;

    public User(int id, String username, String name, Date birthday, Value balance, List<Game> games) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.birthday = birthday;
        this.balance = balance;
        this.games = games;
    }

    public User() {
        this(1, "", "", new Date(1900, Calendar.JANUARY, 1), new Value(0.0,"BRL", "R$"), new ArrayList<>());
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

    public List<Game> getGames() {
        return games;
    }
    public boolean addGame(Game game) {
        this.games.add(game);
        return true;
    }
    public boolean remGame(Game game) {
        this.games.remove(game);
        return true;
    }

    public void addBalance(int value) {
        this.balance.setValue(this.balance.getValue() + value);
    }
    public void remBalance(int value) {
        this.balance.setValue(this.balance.getValue() - value);
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
