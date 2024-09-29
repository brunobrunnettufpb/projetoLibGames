package br.ufpb.dcx.libGames.Views.GUI;

import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class LibGamesProgramGUI {
    private JFrame dialog = new JFrame("Biblioteca de Jogos");
    private User selectedUser = null;
    private Game selectedGame = null;

    public LibGamesProgramGUI() {
        createDialog();
        createMenuBar();
        createLayout();
    }

    public void createDialog() {
        dialog.setLayout(new BorderLayout(0,5));
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
        JMenuBar menuBar = new JMenuBar();

        String[] menuNames = {"Arquivo", "Usuário"};
        HashMap<String, String[]> menuItemNames = new HashMap<>();

        menuItemNames.put("Arquivo", new String[] {"Sair"});
        menuItemNames.put("Usuário", new String[] {"Novo", "Apagar"});

        for (String menuName : menuNames) {
            JMenu menu = new JMenu(menuName);

            if (menuItemNames.containsKey(menuName)) {
                for (String itemName : menuItemNames.get(menuName)) {
                    JMenuItem item = new JMenuItem(itemName);
                    menu.add(item);
                }
                menuBar.add(menu);
            }
        }

        dialog.setJMenuBar(menuBar);
    }

    private void createLayout() {
        JLabel title = new JLabel("Loja de Jogos", JLabel.CENTER);
        title.setForeground(Color.RED);
        title.setFont(new Font("Serif", Font.BOLD, 24));
        dialog.add(title, BorderLayout.PAGE_START);

        {
            JPanel body = new JPanel();
            body.setLayout(new GridLayout(1,2,25,0));
            body.setBackground(Color.darkGray);

            // Lado esquerdo
            JPanel leftSide = new JPanel();
            leftSide.setLayout(new GridLayout(3,2));
            leftSide.setBackground(Color.gray);

            JLabel labUserName1 = new JLabel("Usuário:");
            JTextField tBoxUserName = new JTextField();
            JLabel labUserBalance1 = new JLabel("Saldo:");
            JTextField tBoxUserBalance = new JTextField();
            JLabel labUserGames = new JLabel("Jogos:");
            JComboBox<Game> cBoxUserGames = new JComboBox<>();
            leftSide.add(labUserName1);
            leftSide.add(tBoxUserName);
            leftSide.add(labUserBalance1);
            leftSide.add(tBoxUserBalance);
            leftSide.add(labUserGames);
            leftSide.add(cBoxUserGames);
            body.add(leftSide);

            // Lado direito
            JPanel rightSide = new JPanel();
            JPanel rightSide1 = new JPanel();
            JPanel rightSide2 = new JPanel();
            rightSide.setLayout(new GridLayout(2,1,0,50));
            rightSide1.setLayout(new GridLayout(1,1,5,5));
            rightSide2.setLayout(new GridLayout(3,2,5,5));
            rightSide.setBackground(Color.gray);
            rightSide1.setBackground(Color.gray);
            rightSide2.setBackground(Color.gray);

            Image gameImgResize = new ImageIcon(getImgPath("NONE")).getImage().getScaledInstance(240,240, Image.SCALE_SMOOTH);
            ImageIcon gameImg = new ImageIcon(gameImgResize);
            JButton labGameImg = new JButton(gameImg);
            JLabel labGameName = new JLabel("Jogo:");
            JTextField tBoxGameName = new JTextField("");
            tBoxGameName.disable();
            JLabel labGameValue = new JLabel("Valor:");
            JTextField tBoxGameValue = new JTextField("");
            tBoxGameValue.disable();
            JButton btnPrev = new JButton("Anterior");
            JButton btnNext = new JButton("Próximo");
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
            Container bottom = new Container();
            bottom.setLayout(new GridLayout(1, 2, 0, 0));
            bottom.setVisible(true);

            JButton comprar = new JButton("Comprar");
            JButton sair = new JButton("Sair");
            sair.setSize(100, 50);
            comprar.setSize(100, 50);
            bottom.add(comprar);
            bottom.add(sair);
            dialog.add(bottom, BorderLayout.PAGE_END);
        }
    }

    public void showUser(User user) {

    }

    private static String getImgPath(String game) {
        return "./imgs/"+game+".jpg";

    }

}