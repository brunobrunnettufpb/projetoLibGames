package br.ufpb.dcx.libGames.Views.GUI;

import javax.swing.*;
import java.awt.*;

public class LibGamesProgramGUI {
    private JFrame dialog = new JFrame("Biblioteca de Jogos");

    public LibGamesProgramGUI() {
        configDialog();

        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem menuArquivoSair = new JMenuItem("Sair");
        menuArquivo.add(menuArquivoSair);

        JMenu menuUser = new JMenu("Usuário");

        /*JMenuItem menuUserCadastrar = new JMenuItem("Cadastrar");
        JMenuItem menuUserDeletar = new JMenuItem("Deletar");
        JMenuItem menuUserRelatorio = new JMenuItem("Relatório");
        menuUser.add(menuUserCadastrar);
        menuUser.add(menuUserDeletar);
        menuUser.add(menuUserRelatorio);*/

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuArquivo);
        menuBar.add(menuUser);

        dialog.setJMenuBar(menuBar);

        JButton btnExit = new JButton("Sair");
    }

    public void configDialog() {
        dialog.setLayout(new GridLayout(3,2));
        dialog.setSize(600,400);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.getContentPane().setBackground(Color.lightGray);
    }

    public void setVisible(boolean b) {
        dialog.setVisible(b);
    }

    private JMenu createMenuBar(JMenu menuBar, String menuBarName, String[] menusName, String[] menusItens) {
        menuBar = new JMenu(menuBarName);

        for (String name: menusName) {
            JMenuItem menuName = new JMenuItem(name);
            menuBar.add(name);
        }

fgjdfklhjkfdjkhfh

        return menuBar;
    }
}
