import javax.swing.*;
import java.awt.event.*;

public class FrmUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtIdUsuario;
    private JTextField txtContrasena;
    private JLabel lblIdUsario;
    private JTextField txtNombre;
    private JLabel lblNombre;
    private JTextField txtCorreo;
    private JLabel lblCorreo;
    private JLabel lblContrasena;
    private int index;
    private ListaUsuario listaUsuario;

    public FrmUsuario(ListaUsuario listaUsuario, int index) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.index = index;
        this.listaUsuario = listaUsuario;

        if (index >= 0) {
            Usuario usuario = listaUsuario.obtenerUsuario(index);
            txtIdUsuario.setEditable(false);
            txtIdUsuario.setText(usuario.getIdUsuario());
            txtNombre.setText(usuario.getNombre());
            txtContrasena.setText(usuario.getClave());
            txtCorreo.setText(usuario.getCorreo());
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
        if (index < 0)
        {
            String idUsuario = txtIdUsuario.getText();
            String clave = txtContrasena.getText();
            String nombre = txtNombre.getText();
            String correo = txtCorreo.getText();

            Usuario usuario = new Usuario(idUsuario,clave,nombre,correo);
            listaUsuario.agregarUsuario(usuario);
        }else{
            String idUsuario = txtIdUsuario.getText();
            String clave = txtContrasena.getText();
            String nombre = txtNombre.getText();
            String correo = txtCorreo.getText();

            Usuario usuario = new Usuario(idUsuario,clave,nombre,correo);
            listaUsuario.actualizarUsuario(usuario,index);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
