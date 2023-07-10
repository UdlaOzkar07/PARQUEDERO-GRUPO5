import javax.swing.*;
import java.awt.event.*;

public class FrmTarifa extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtIdTarifa;
    private JTextField txtValorTarifa;
    private JComboBox cbxTipoVehiculoTarifa;
    private JLabel lblIdTarifa;
    private JLabel lblTipoVehiculoTarifa;
    private JLabel lblTarifa;
    private int index;
    private ListaTarifa listaTarifa;

    public FrmTarifa(ListaTarifa listaTarifa,int index) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.index = index;
        this.listaTarifa = listaTarifa;

        if (index >= 0) {
            Tarifa tarifa = listaTarifa.obtenerTarifa(index);
            txtIdTarifa.setEditable(false);
            txtIdTarifa.setText(Integer.toString(tarifa.getIdTarifa()));
            cbxTipoVehiculoTarifa.getEditor().setItem(tarifa.getTipoVehiculo());
            txtValorTarifa.setText(Double.toString(tarifa.getValorTarifa()));
        }
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        int idTarifa = Integer.parseInt(txtIdTarifa.getText());
        String tipoVehiculo = cbxTipoVehiculoTarifa.getSelectedItem().toString();
        Double valorTarifa = Double.parseDouble(txtValorTarifa.getText());

        Tarifa tarifa = new Tarifa(idTarifa,tipoVehiculo,valorTarifa);

        if (index < 0)
        {
            listaTarifa.agregarTarifa(tarifa);
        }else{
            listaTarifa.actualizarTarifa(tarifa,index);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
