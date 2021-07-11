package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private BattleGround battleGround;
    private Setting setting;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(550, 300, 600, 600);
        setTitle("Крестики-Нолики");


        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton startGame = new JButton("START");

        panel.add(startGame);
        JButton exitGame = new JButton("EXIT");

        panel.add(exitGame);
        add(panel, BorderLayout.NORTH);

        battleGround = new BattleGround(this);
        add(battleGround, BorderLayout.CENTER);

        setting = new Setting(this);

        startGame.addActionListener(e -> setting.setVisible(true));
        exitGame.addActionListener(e -> System.exit(0));



        setVisible(true);
    }
    void startNewGame(int fieldSize, int dotsToWin){
        battleGround.startNewGame(fieldSize, dotsToWin);
    }
    }

