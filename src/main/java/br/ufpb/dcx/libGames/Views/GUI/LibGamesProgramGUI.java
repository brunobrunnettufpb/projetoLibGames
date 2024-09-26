package br.ufpb.dcx.libGames.Views.GUI;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Dictionary;
import java.util.Hashtable;

public class LibGamesProgramGUI {

    //TODO: Menu à esquerda com os dados do usuário
    //TODO: Menu à direita com os dados do jogo

    private JFrame dialog = new JFrame("Biblioteca de Jogos");

    public LibGamesProgramGUI() {
        configDialog();



        /*JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem menuArquivoSair = new JMenuItem("Sair");
        menuArquivo.add(menuArquivoSair);

        JMenu menuUser = new JMenu("Usuário");

        JMenuItem menuUserCadastrar = new JMenuItem("Cadastrar");
        JMenuItem menuUserDeletar = new JMenuItem("Deletar");
        JMenuItem menuUserRelatorio = new JMenuItem("Relatório");
        menuUser.add(menuUserCadastrar);
        menuUser.add(menuUserDeletar);
        menuUser.add(menuUserRelatorio);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuArquivo);
        menuBar.add(menuUser);*/

        String[] menuNames = {"Arquivo", "Usuário"};
        Hashtable<String, String> menuItemNames = new Hashtable<>();
        menuItemNames.put("Arquivo", );

        JMenuBar menuBar = createMenuBar(menuNames, menuItemNames);

        dialog.setJMenuBar(menuBar);

        JButton btnExit = new JButton("Sair");
    }

    public void configDialog() {
        dialog.setLayout(new GridLayout(3, 2));
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.getContentPane().setBackground(Color.lightGray);
    }

    public void setVisible(boolean b) {
        dialog.setVisible(b);
    }

    private JMenuBar createMenuBar(String[] menuNames, Dictionary<String, String[]> menuItemNames) {
        JMenuBar menuBar = new JMenuBar();

        for (String menuName : menuNames) {
            JMenu menu = new JMenu(menuName);

            if (menuItemNames != null) {
                for (String itemName : menuItemNames.get(menuName)) {
                    JMenuItem item = new JMenuItem(itemName);
                    menu.add(item);
                }
                menuBar.add(menu);
            }
        }

        return menuBar;
    }
}