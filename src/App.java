import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
//TODO: fare la relazione
public class App extends Frame implements ActionListener {
    TextField tfkwh;
    TextField tfco2;
    TextField tfWatt;
    TextField tfOre;
    Label labkwh;
    Label labco2;
    Label LabWatt;
    Label LabinfoRisultatoCo2;
    Label LabInfoRisultaoKwh;
    Label LabOreInfo;
    Label LabConsumoKwh;
    Label errori;
    Button b;
    public static DecimalFormat df = new DecimalFormat("0.0000");
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) size.getWidth();
    int height = (int) size.getHeight();


    App() {
        try {
            errori = new Label();
            errori.setBounds(250, 30, 250, 20);
            errori.setVisible(false);
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
            LabOreInfo = new Label("Utilizzo in ore");
            LabOreInfo.setBounds(50, 150, 150, 20);
            tfOre = new TextField("1");
            tfOre.setBounds(50, 170, 150, 20);
            LabinfoRisultatoCo2 = new Label();
            LabinfoRisultatoCo2.setBounds(50, 230, 150, 50);
            LabinfoRisultatoCo2.setText("Co2 Emessi");
            LabInfoRisultaoKwh = new Label();
            LabInfoRisultaoKwh.setBounds(200, 230, 150, 50);
            LabInfoRisultaoKwh.setText("Costo Kwh");
            LabConsumoKwh = new Label("Consumo in kWh");
            LabConsumoKwh.setBounds(350, 230, 200, 50);
            b = new Button("Calcola");
            b.setBounds(50, 300, 60, 30);
            b.addActionListener(this);
            add(errori);
            add(labkwh);
            add(labco2);
            add(LabWatt);
            add(tfWatt);
            add(tfkwh);
            add(tfco2);
            add(LabinfoRisultatoCo2);
            add(LabInfoRisultaoKwh);
            add(tfOre);
            add(LabOreInfo);
            add(LabConsumoKwh);
            add(b);
            setSize(width / 2, height / 2);
            setLayout(null);
            setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public void actionPerformed(ActionEvent e) {
        try {
            errori.setVisible(false);
            double co2 = Double.parseDouble(tfco2.getText());
            double kwh = Double.parseDouble(tfkwh.getText());
            double watt = Double.parseDouble(tfWatt.getText());
            double ore = Double.parseDouble(tfOre.getText());
            Double calcoloCo2 = ((co2 * watt) * ore) / 1000;
            Double calcoloCostoKwh = ((kwh * watt) * ore) / 1000;
            Double calcoloCosumoKwh = (watt * ore) / 1000;
            String RisultatoCo2 =  df.format(calcoloCo2);
            String RisultatoKwh =  df.format(calcoloCostoKwh);
            String RisultatoCosumokWh = df.format(calcoloCosumoKwh);
            LabInfoRisultaoKwh.setText("Costo Kwh: "
            + RisultatoKwh + "€");
            LabinfoRisultatoCo2.setText("Co2 Emessi: "
            + RisultatoCo2 + "g");
            LabConsumoKwh.setText("Consumo in kWh: "
            + RisultatoCosumokWh + "kWh");
        } catch (Exception ex) {
            System.out.println(ex);
            errori.setText("Errore verificato " + ex.getMessage());
            errori.setForeground(Color.RED);
            errori.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}