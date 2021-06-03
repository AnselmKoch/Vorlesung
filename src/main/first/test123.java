package src.main.first;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class test123 extends JFrame{

    public static ArrayList<RainDrop> rainDropArrayList = new ArrayList<>();



    public JFrame frame = this;
    public Graphics graphics = frame.getGraphics();
    public DrawPane drawPane = new DrawPane();
    public boolean firstTry = true;


    public test123() {
        graphics = frame.getGraphics();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(500, 750));
        setContentPane(new DrawPane());
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    class DrawPane extends JPanel {
        public DrawPane() {

        }

        public void paintComponent(Graphics graphics) {
            if(firstTry) {
            for(RainDrop rainDrop : rainDropArrayList) {
                graphics.setColor(Color.BLUE);
                int randomX = ThreadLocalRandom.current().nextInt(0, 500);
                rainDrop.setxPos(randomX);
                firstTry = false;
            }
            }else{
                repaint();
                removeAll();
                graphics.setColor(Color.BLUE);
                for(RainDrop rainDrop : rainDropArrayList) {
                    if(rainDrop.getxPos() == -10) {
                        int randomX = ThreadLocalRandom.current().nextInt(0, 500);
                        rainDrop.setxPos(randomX);
                    }
                    graphics.clearRect(rainDrop.getxPos(),rainDrop.getyPos() - rainDrop.getHeight(), rainDrop.getWidth(), rainDrop.getHeight());
                    graphics.fillRect(rainDrop.getxPos(), rainDrop.getyPos(), rainDrop.getWidth(), rainDrop.getHeight());
                }
            }
        }
    }


    // And From your main() method or any other method

    public void doTimer() {
        Timer spawnRainDropTimer = new Timer(5,new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomSpawnNr = ThreadLocalRandom.current().nextInt(0,2);
                if(randomSpawnNr == 1) {
                    if(i < 500) {
                        rainDropArrayList.add(new RainDrop(2, 100, 10F, Color.BLUE));
                    }
                    }
                for(RainDrop rainDrop : rainDropArrayList) {
                    if (rainDrop.getxPos() == -10) {
                        int randomX = ThreadLocalRandom.current().nextInt(0, 500);
                        rainDrop.setxPos(randomX);
                    }
                }
                i++;
            }

        });
        spawnRainDropTimer.setRepeats(true);
        Timer timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 50; i++) {

                }
                 Graphics graphics1 = frame.getGraphics();
                drawPane.paintComponent(graphics1);
                for(RainDrop rainDrop : rainDropArrayList) {
                    rainDrop.updateYPos();
                    if(rainDrop.getyPos() > 3000) {
                        rainDrop.setyPos(0);
                    }
                }
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
        spawnRainDropTimer.start();
        spawnRainDropTimer.setCoalesce(true);
    }


}
