import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
//TODO: Sistemare l'output, mandare a capo il risultato, inserire le ore di utlizzo e fare i calcoli, fare la relazione
public class App extends Frame implements ActionListener {
    TextField tfkwh;
    TextField tfco2;
    TextField tfWatt;
    Label labkwh;
    Label labco2;
    Label LabWatt;
    Label LabinfoRisultatoCo2;
    Label LabInfoRisultaoKwh;
    Button b;
    public static DecimalFormat df = new DecimalFormat("0.0000");
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
        LabinfoRisultatoCo2 = new Label();
        LabinfoRisultatoCo2.setBounds(50, 230, 150, 50);
        LabinfoRisultatoCo2.setText("Co2 Emessi");
        LabInfoRisultaoKwh = new Label();
        LabInfoRisultaoKwh.setBounds(200, 230, 150, 50);
        LabInfoRisultaoKwh.setText("Costo Kwh");
        b = new Button("Calcola");
        b.setBounds(50, 300, 60, 30);
        b.addActionListener(this);
        add(labkwh);
        add(labco2);
        add(LabWatt);
        add(tfWatt);
        add(tfkwh);
        add(tfco2);
        add(LabinfoRisultatoCo2);
        add(LabInfoRisultaoKwh);
        add(b);
        setSize(width / 2, height / 2);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double co2 = Double.parseDouble(tfco2.getText());
            double kwh = Double.parseDouble(tfkwh.getText());
            double watt = Double.parseDouble(tfWatt.getText());
            Double calcoloCo2 = (co2 * watt) / 1000;
            Double calcoloCostoKwh = (kwh * watt) / 1000;
            String RisultatoCo2 =  df.format(calcoloCo2);
            String RisultatoKwh =  df.format(calcoloCostoKwh);
            LabInfoRisultaoKwh.setText("Costo Kwh: "
            + RisultatoKwh + "€");
            LabinfoRisultatoCo2.setText("Co2 Emessi: "
            + RisultatoCo2 + "g");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}