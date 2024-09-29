package br.ufpb.dcx.libGames.Views.GUI;

import br.ufpb.dcx.libGames.Controllers.SystemLibGames;
import br.ufpb.dcx.libGames.Exceptions.UsuarioNaoExisteException;
import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class LibGamesProgramGUI {
    private JFrame dialog = new JFrame("Biblioteca de Jogos");
    private SystemLibGames system;

    public LibGamesProgramGUI() {
        system = new SystemLibGames();

        createDialog();
        createMenuBar();
        createLayout();
    }

    public void createDialog() {
        dialog.setLayout(new BorderLayout(0,25));
        dialog.setSize(600, 600);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.getContentPane().setBackground(Color.darkGray);
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b) {
        dialog.setVisible(b);
    }

    /**
     * Cria a barra de menus iterando os valores de menuNames e menuItemNames e já define no dialog
     */
    private void createMenuBar() {
        menuBar = new JMenuBar();

        menuArquivo = new JMenu("Arquivo");
        menuArquivoSair = new JMenuItem("Sair");
        menuArquivoSair.addActionListener(a -> btnSair_Click());
        menuArquivo.add(menuArquivoSair);

        menuUsuario = new JMenu("Usuário");
        menuUsuarioCadastrar = new JMenuItem("Cadastrar");
        menuUsuarioCadastrar.addActionListener(a -> cadastrarUsuario());
        menuUsuarioBuscar = new JMenuItem("Buscar");
        menuUsuarioBuscar.addActionListener(a -> buscarUsuario());
        menuUsuarioApagar = new JMenuItem("Apagar");
        menuUsuarioApagar.addActionListener(a -> apagarUsuario());
        menuUsuario.add(menuUsuarioCadastrar);
        menuUsuario.add(menuUsuarioBuscar);
        menuUsuario.add(menuUsuarioApagar);

        menuBar.add(menuArquivo);
        menuBar.add(menuUsuario);

        dialog.setJMenuBar(menuBar);
    }

    private void createLayout() {
        top = new JPanel();
        top.setBackground(Color.darkGray);
        title = new JLabel("Loja de Jogos", JLabel.CENTER);
        title.setForeground(Color.RED);
        title.setFont(new Font("Serif", Font.BOLD, 24));
        top.add(title);
        dialog.add(top, BorderLayout.PAGE_START);

        {
            body = new JPanel();
            body.setLayout(new GridLayout(1,2,25,0));
            body.setBackground(Color.darkGray);

            // Lado esquerdo
            leftSide = new JPanel();
            leftSide.setLayout(new GridLayout(3,2));
            leftSide.setBackground(Color.gray);

            labUserName1 = new JLabel("Usuário:", JLabel.CENTER);
            tBoxUserName = new JTextField();
            tBoxUserName.setEditable(false);
            labUserBalance1 = new JLabel("Saldo:", JLabel.CENTER);
            tBoxUserBalance = new JTextField();
            tBoxUserBalance.setEditable(false);
            labUserGames = new JLabel("Jogos:", JLabel.CENTER);
            cBoxUserGames = new JComboBox<>();
            leftSide.add(labUserName1);
            leftSide.add(tBoxUserName);
            leftSide.add(labUserBalance1);
            leftSide.add(tBoxUserBalance);
            leftSide.add(labUserGames);
            leftSide.add(cBoxUserGames);
            body.add(leftSide);

            // Lado direito
            rightSide = new JPanel();
            rightSide1 = new JPanel();
            rightSide2 = new JPanel();
            rightSide.setLayout(new GridLayout(2,1,0,50));
            rightSide1.setLayout(new GridLayout(1,1,5,5));
            rightSide2.setLayout(new GridLayout(3,2,5,5));
            rightSide.setBackground(Color.gray);
            rightSide1.setBackground(Color.gray);
            rightSide2.setBackground(Color.gray);

            gameImg = new ImageIcon(new ImageIcon(getImgPath("NONE")).getImage().getScaledInstance(190,190, Image.SCALE_SMOOTH));
            labGameImg = new JLabel(gameImg);
            labGameName = new JLabel("Jogo:", JLabel.CENTER);
            tBoxGameName = new JTextField("");
            tBoxGameName.setEditable(false);
            labGameValue = new JLabel("Valor:", JLabel.CENTER);
            tBoxGameValue = new JTextField("");
            tBoxGameValue.setEditable(false);
            btnPrev = new JButton("Anterior");
            btnPrev.addActionListener(a -> btnPrev_Click());
            btnNext = new JButton("Próximo");
            btnNext.addActionListener(a -> btnNext_Click());
            rightSide1.add(labGameImg);
            rightSide2.add(labGameName);
            rightSide2.add(tBoxGameName);
            rightSide2.add(labGameValue);
            rightSide2.add(tBoxGameValue);
            rightSide2.add(btnPrev);
            rightSide2.add(btnNext);
            rightSide.add(rightSide1);
            rightSide.add(rightSide2);

            body.add(rightSide);

            dialog.add(body, BorderLayout.CENTER);
        }

        {
            bottom = new JPanel();
            bottom.setLayout(new GridLayout(1, 2, 0, 0));
            bottom.setVisible(true);

            comprar = new JButton("Comprar");
            comprar.setSize(100, 50);
            comprar.addActionListener(a -> btnComprar_Click());
            sair = new JButton("Sair");
            sair.setSize(100, 50);
            sair.addActionListener(a -> btnSair_Click());

            bottom.add(comprar);
            bottom.add(sair);
            dialog.add(bottom, BorderLayout.PAGE_END);
        }
    }

    private String getImgPath(String game) {
        return "./imgs/"+game+".jpg";
    }

    ///////////////
    // COMPONENTES
    ///////////////
    private JMenuBar menuBar;
    private JMenu menuArquivo;
    private JMenuItem menuArquivoSair;
    private JMenu menuUsuario;
    private JMenuItem menuUsuarioCadastrar;
    private JMenuItem menuUsuarioBuscar;
    private JMenuItem menuUsuarioApagar;


    private JPanel leftSide;
    private JPanel top;
    private JPanel body;
    private JPanel bottom;
    private JPanel rightSide;
    private JPanel rightSide1;
    private JPanel rightSide2;


    private ImageIcon gameImg;

    private JLabel title;
    private JLabel labUserName1;
    private JLabel labUserBalance1;
    private JLabel labUserGames;
    private JLabel labGameImg;
    private JLabel labGameName;
    private JLabel labGameValue;

    private JComboBox<String> cBoxUserGames;

    private JTextField tBoxUserName;
    private JTextField tBoxUserBalance;
    private JTextField tBoxGameName;
    private JTextField tBoxGameValue;

    private JButton btnPrev;
    private JButton btnNext ;
    private JButton comprar;
    private JButton sair;

    ///////////
    // EVENTS
    ///////////
    private void cadastrarUsuario() {
        try {
            String name = JOptionPane.showInputDialog("Digite o nome real do usuário:");
            String username = JOptionPane.showInputDialog("Digite um nome de usuário:");
            double balance = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo inicial deste usuário"));
            system.userCreate(name, username, balance);
            showUser(system.getUser(username));
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n\n"+ex.getMessage());
        }
    }
    private void buscarUsuario() {
        try {
            String username = JOptionPane.showInputDialog("Digite o nome de usuário:");
            User found = system.getUser(username);
            if (found != null) {
                showUser(found);
            }
            else {
                throw new UsuarioNaoExisteException("Usuário não cadastrado!");
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n\n"+ex.getMessage());
        }
    }
    private void apagarUsuario() {
        try {
            String username = tBoxUserName.getText();
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum usuário selecionado!");
                return;
            }
            if (JOptionPane.showConfirmDialog(null, String.format("Deseja apagar o usuário %s?", username), "Apagar Usuário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (system.userDelete(username)) {
                    JOptionPane.showMessageDialog(null, String.format("Usuário %s apagado com sucesso!", username));
                    clearUser();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Canelado!");
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n\n"+ex.getMessage());
        }
    }
    private void btnComprar_Click() {
        try {
            User selectedUser = system.getUser(tBoxUserName.getText());

            if (selectedUser == null) {
                JOptionPane.showMessageDialog(null, "Erro:\n\nSelecione um USUÁRIO!");
                return;
            }

            Game selectedGame = system.getGame(tBoxGameName.getText());

            if (selectedGame == null) {
                JOptionPane.showMessageDialog(null, "Erro:\n\nSelecione um JOGO!");
            }

            system.gameBuy(selectedUser, selectedGame);
            showUser(selectedUser);
            JOptionPane.showMessageDialog(null, "Jogo comprado com sucesso!");
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro:\n\n"+ex.getMessage());
        }
    }
    private void btnSair_Click() {
        System.exit(0);
    }
    private void btnPrev_Click() {
        try {
            int id = 2;
            Game selectedGame = system.getGame(tBoxGameName.getText());

            if (selectedGame != null) {
                id = selectedGame.getId();
            }

            id--;

            if (id < 1) {
                JOptionPane.showMessageDialog(null, "Erro:\n\nEste é o primeiro jogo da lista!");
                return;
            }

            selectedGame = system.getGame(id);
            showGame(selectedGame);
        }
        catch (Exception ex) {

        }
    }
    private void btnNext_Click() {
        try {
            int id = 0;
            Game selectedGame = system.getGame(tBoxGameName.getText());

            if (selectedGame != null) {
                id = selectedGame.getId();
            }

            id++;

            if (id > system.getQtdGames()) {
                JOptionPane.showMessageDialog(null, "Erro:\n\nEste é o último jogo da lista!");
                return;
            }

            selectedGame = system.getGame(id);
            showGame(selectedGame);
        }
        catch (Exception ex) {

        }
    }

    ///////////////
    // CONTROLLERS
    ///////////////
    private void showUser(User user) {
        clearUser();
        this.tBoxUserName.setText(user.getName());
        this.tBoxUserBalance.setText(String.format("%s%.2f", user.getBalance().getSymbol(), user.getBalance().getValue()));

        for(Game game: user.getGames().values()) {
            cBoxUserGames.addItem(game.getName());
        }
    }
    private void clearUser() {
        this.tBoxUserName.setText("");
        this.tBoxUserBalance.setText("");
        this.cBoxUserGames.removeAllItems();

    }
    private void showGame(Game game) {
        clearGame();
        this.tBoxGameName.setText(game.getName());
        this.tBoxGameValue.setText(String.format("%s%.2f", game.getPrice().getSymbol(), game.getPrice().getValue()));
        this.labGameImg.setIcon(new ImageIcon(new ImageIcon(getImgPath(game.getName())).getImage().getScaledInstance(190,190, Image.SCALE_SMOOTH)));
    }
    private void clearGame() {
        this.tBoxGameName.setText("");
        this.tBoxGameValue.setText("");
        this.labGameImg.setIcon(new ImageIcon(new ImageIcon(getImgPath("NONE")).getImage().getScaledInstance(190,190, Image.SCALE_SMOOTH)));
    }
}