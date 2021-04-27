import java.awt.*;
import java.awt.event.*;

public class App extends Frame implements ActionListener {
    TextField tfkwh;
    TextField tfco2;
    TextField tfWatt;
    Label labkwh;
    Label labco2;
    Label risultato;
    Label LabWatt;
    Button b;
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) size.getWidth();
    int height = (int) size.getHeight();

    App() {
        labkwh = new Label();
        labkwh.setBounds(50, 30, 150, 20);
        labkwh.setText("Costo kWh");
        tfkwh = new TextField("0.061");
        tfkwh.setBounds(50, 50, 150, 20);
        labco2 = new Label();
        labco2.setBounds(50, 70, 150, 20);
        labco2.setText("Co2/kWh in Grammi");
        tfco2 = new TextField("0.36");
        tfco2.setBounds(50, 90, 150, 20);
        LabWatt = new Label();
        LabWatt.setBounds(50, 110, 150, 20);
        LabWatt.setText("Consumo in Watt");
        tfWatt = new TextField();
        tfWatt.setBounds(50, 130, 150, 20);
        risultato = new Label();
        risultato.setBounds(50, 250, 300, 20);
        risultato.setText("Costo kWh");
        b = new Button("Calcola");
        b.setBounds(50, 300, 60, 30);
        b.addActionListener(this);
        add(labkwh);
        add(labco2);
        add(LabWatt);
        add(tfWatt);
        add(risultato);
        add(tfkwh);
        add(tfco2);
        add(b);
        setSize(width / 2, height / 2);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            risultato.setForeground(Color.black);
            double co2 = Double.parseDouble(tfco2.getText());
            double kwh = Double.parseDouble(tfkwh.getText());
            double watt = Double.parseDouble(tfWatt.getText());
            String risultatoFinale;
            Double calcoloCo2 = (co2 * watt) / 1000;
            Double calcoloCostoKwh = (kwh * watt) / 1000;
            risultatoFinale = Math.round(calcoloCo2 * 10000.0) / 10000.0+ " " + Math.round(calcoloCostoKwh * 10000.0) / 10000.0 + "€" ;
            risultato.setText(risultatoFinale);
        } catch (Exception ex) {
            System.out.println(ex);
            risultato.setForeground(Color.RED);
            risultato.setText("NaN");
        }
    }

    public static void main(String[] args) {
        new App();
    }
}