package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleGround extends JPanel {
    private GameWindow gameWindow;
    private int fieldSize;
    private int dotsToWin;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;


    public BattleGround(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.BLUE);
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;


                if (isInit && !Logic.isGameFinished) {
                    Logic.humanTurn(cellY, cellX);

                }
                repaint();
            }

        });
    }

    void startNewGame(int fieldSize, int dotsToWin) {
        this.fieldSize = fieldSize;
        this.dotsToWin = dotsToWin;
        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;

        }


        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;
        ((Graphics2D) g).setStroke(new BasicStroke(3f));
        g.setColor(Color.black);
        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);

        }
        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);

        }
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, i, j);
                }


//                drawO(g, 0, 0);
            }
        }
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, i, j);
                }


//                drawO(g, 0, 0);
            }
        }
    }

    private void drawX(Graphics g, int y, int x) {

        g.setColor(Color.yellow);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));
        g.drawLine(x * cellWidth, y * cellHeight, (x + 1) * cellWidth, (y + 1) * cellHeight);
        g.drawLine(x * cellWidth, (y + 1) * cellHeight, (x + 1) * cellWidth, y * cellHeight);
    }

    private void drawO(Graphics g, int y, int x) {
        g.setColor(Color.yellow);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));
        g.drawOval((x * cellWidth), y * cellHeight, cellWidth, cellHeight);
    }
}