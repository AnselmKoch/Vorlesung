package src.main.second;

/**
 *  @authors Anselm Koch 208900, Robin Schüle 208957 , Matthias Vollmer 208961, Martin Marsal 209390
 *
 *  Dieses Programm enthält zwei Schieberegler, der eine zeigt die Temperatur in Fahrenheit und der andere in Celcius
 *  beide Schieberegler zeigen die selbe Temperatur in einer anderen Maßeinheit an.
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderTemp extends JFrame implements ChangeListener {

    private JSlider fahrenheitSlider,celciusSlider;
    private JTextPane fahrenheitText,celciusText;
    JPanel fahrenheitPanel, celciusPanel;

    public static void main(String[] args) {
        SliderTemp sliderTemp = new SliderTemp();
    }

    /**
     * Konstruktor
     *
     * Erstellt alles notwendige für das Programm, Slider etc. und fügt diesen
     * die dazugehörigen Eigenschaften hinzu
     */
    public SliderTemp() {

        fahrenheitPanel = new JPanel();
        celciusPanel = new JPanel();
        fahrenheitSlider = new JSlider(SwingConstants.VERTICAL,-490,1000,0);
        celciusSlider = new JSlider(SwingConstants.VERTICAL, -270,500,0);
        fahrenheitSlider.setName("Fahrenheit");
        celciusSlider.setName("Celcius");
        fahrenheitText = new JTextPane();
        celciusText = new JTextPane();
        fahrenheitSlider.addChangeListener(this);
        celciusSlider.addChangeListener(this);
        fahrenheitText.setText("in Fahrenheit: 0");
        celciusText.setText("in Celcius: 0");
        fahrenheitText.setEditable(false);
        celciusText.setEditable(false);
        fahrenheitPanel.add(fahrenheitText);
        celciusPanel.add(celciusText);
        fahrenheitPanel.setLayout(new FlowLayout());
        celciusPanel.setLayout(new FlowLayout());
        fahrenheitSlider.setMajorTickSpacing(60);
        fahrenheitSlider.setMinorTickSpacing(30);
        fahrenheitSlider.setPaintTicks(true);
        fahrenheitSlider.setPaintLabels(true);
        celciusSlider.setMajorTickSpacing(30);
        celciusSlider.setMinorTickSpacing(15);
        celciusSlider.setPaintTicks(true);
        celciusSlider.setPaintLabels(true);
        fahrenheitPanel.add(fahrenheitSlider);
        celciusPanel.add(celciusSlider);
        add(fahrenheitPanel);
        add(celciusPanel);
        setLayout(new GridLayout(2,1));
        setSize(new Dimension(500,500));
        setVisible(true);
    }

    /**
     * Wird bei veränderung eines Schiebereglers durchgeführt:
     *
     * Überprüft welcher Schieberegler betätigt wurde und errechnet dann den Wert den
     * der andere Schieberegler haben müsste und setzt diesen auf den errechneten Wert
     * @param e
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider currentSlider = (JSlider) e.getSource();
        if(currentSlider.getName().equalsIgnoreCase("celcius")) {
            float ergebnis = (float)currentSlider.getValue() * 1.8F + 32;
            fahrenheitSlider.setValue((int)ergebnis);
            fahrenheitText.setText("in Fahrenheit: " + (int)ergebnis);

        }else{
            float ergebnis = (float) (currentSlider.getValue() - 32) * 0.5555555555F;
            celciusSlider.setValue((int)ergebnis);
            celciusText.setText("in Celcius: " + (int) ergebnis);
        }
    }
}
