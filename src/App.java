import java.awt.*;
import java.awt.event.*;


public class App extends Frame implements ActionListener {
    TextField tfkwh;
    TextField tfco2;
    Label labkwh;
    Label labco2;
    Label risultao;
    Button b;

    App() {
        labkwh = new Label();
        labkwh.setBounds(50, 30, 150, 20);
        labkwh.setText("Costo kWh");
        tfkwh = new TextField();
        tfkwh.setBounds(50, 50, 150, 20);
        labco2 = new Label();
        labco2.setBounds(50, 70, 150, 20);
        labco2.setText("Co2/kWh");
        tfco2 = new TextField();
        tfco2.setBounds(50, 100, 150, 20);
        risultao = new Label();
        risultao.setBounds(50, 250, 150, 20);
        risultao.setText("Costo kWh");
        b = new Button("Calcola");
        b.setBounds(50, 300, 60, 30);
        b.addActionListener(this);
        add(labkwh);
        add(labco2);
        add(risultao);
        add(tfkwh);
        add(tfco2);
        add(b);
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double co2 = Double.parseDouble(tfco2.getText());
            double kwh = Double.parseDouble(tfkwh.getText());
            Double calcolo = co2 * kwh;
            risultao.setText(calcolo.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}