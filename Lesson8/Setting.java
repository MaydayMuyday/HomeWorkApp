package Lesson8;

import javafx.scene.control.Slider;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;

public class Setting extends JFrame {
    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;

    private JSlider sliderFieldSize;
    private JSlider sliderDotsToWin;
    private GameWindow gameWindow;

    public Setting(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(550, 400, 600, 500);
        setTitle("Игровые настройки");

        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderFieldSize.setMajorTickSpacing(1);

        sliderFieldSize.setPaintTicks(true);
        sliderFieldSize.setPaintLabels(true);

        sliderDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderDotsToWin.setMajorTickSpacing(1);

        sliderDotsToWin.setPaintTicks(true);
        sliderDotsToWin.setPaintLabels(true);

        sliderFieldSize.addChangeListener(e -> sliderDotsToWin.setMaximum(sliderFieldSize.getValue()));
        setLayout(new GridLayout(5, 1));


        add(new Label("Размер поля:"));
        add(sliderFieldSize);
        add(new Label("Выигрышная линия:"));
        add(sliderDotsToWin);


        JButton button = new JButton("НАЧАТЬ");
        add(button);
        button.addActionListener(e -> {
            int fieldSize = sliderFieldSize.getValue();
            int dotsToWin = sliderDotsToWin.getValue();
            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = dotsToWin;
            Logic.initMap();
            Logic.printMap();
            Logic.isGameFinished = false;
            gameWindow.startNewGame(fieldSize, dotsToWin);

//
            setVisible(false);
        });
        setVisible(false);
    }

    }
