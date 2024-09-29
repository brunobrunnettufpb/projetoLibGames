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
            tBoxUserName.setEnabled(false);
            labUserBalance1 = new JLabel("Saldo:", JLabel.CENTER);
            tBoxUserBalance = new JTextField();
            tBoxUserBalance.setEnabled(false);
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
            btnGameImg = new JButton(gameImg);
            btnGameImg.setBackground(Color.gray);
            btnGameImg.setBorderPainted(false);
            labGameName = new JLabel("Jogo:", JLabel.CENTER);
            tBoxGameName = new JTextField("");
            tBoxGameName.setEnabled(false);
            labGameValue = new JLabel("Valor:", JLabel.CENTER);
            tBoxGameValue = new JTextField("");
            tBoxGameValue.setEnabled(false);
            btnPrev = new JButton("Anterior");
            btnNext = new JButton("Próximo");
            rightSide1.add(btnGameImg);
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

    public void showUser(User user) {

    }

    private static String getImgPath(String game) {
        return "./imgs/"+game+".jpg";

    }

    ///////////////
    // COMPONENTES
    ///////////////

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
    private JLabel labGameName;
    private JLabel labGameValue;

    private JComboBox<Game> cBoxUserGames;

    private JTextField tBoxUserName;
    private JTextField tBoxUserBalance;
    private JTextField tBoxGameName;
    private JTextField tBoxGameValue;

    private JButton btnGameImg;
    private JButton btnPrev;
    private JButton btnNext ;
    private JButton comprar;
    private JButton sair;

    ///////////
    // EVENTS
    ///////////
    private void btnComprar_Click() {
        title.setText("COMPROU!");
    }
    private void btnSair_Click() {
        System.exit(0);
    }

}