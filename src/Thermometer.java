import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class Thermometer extends JFrame implements ChangeListener {
    private JSlider slider;
    private JPanel panel;
    private JLabel label;
    private JLabel label2;

    public Thermometer(){
        setTitle("Thermometer");
        setDefaultCloseOperation(3);


        panel= new JPanel();
        label=new JLabel();
        label2=new JLabel("°C");
        slider= new JSlider(-20,100,0);
        slider.setPreferredSize(new Dimension(400,200));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        label2.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,25));
        label2.setForeground(Color.red);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(20);

        slider.setPaintLabels(true);
        slider.setFont(new Font(Font.MONOSPACED, Font.ITALIC,20));
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.addChangeListener(this);

             //ALT+0176 press alt type 0176 for °
        label.setText(" °F = " + slider.getValue());
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD,25));

        panel.add(label2);
        panel.add(slider);
        panel.add(label);

        add(panel);



        setLocation(500,350);
        setSize(420,420);
        setVisible(true);

    }


    @Override
    public void stateChanged(ChangeEvent e) {

        label.setText(" °F = " + ((slider.getValue()*9/5)+32) );
        label2.setText("°C = " +slider.getValue());
    }

    public static void main(String[] args) {
        new Thermometer();
    }
}
