import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmLogin extends JDialog{
    Usuario usuario;
    private JTextField txtUsuario;
    private JPasswordField pswContrasena;
    private JButton btnIngresar;
    private JPanel contentPane;
    private JLabel lblIcon;
    private JButton btnSalir;
    private boolean closedOk;

    public FrmLogin(ListaUsuario listaUsuario) {
        setContentPane(contentPane);
        setMinimumSize(new Dimension(800,400));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUsuario=txtUsuario.getText();
                String contrasena= "";
                char [] password = pswContrasena.getPassword();
                for (int x=0;x<password.length;x++){
                    contrasena+=password[x];
                }

                if (listaUsuario.validarUsuario(idUsuario,contrasena)==true){
                    closedOk = true;
                    usuario = listaUsuario.buscarId(idUsuario);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(FrmLogin.this,"Usuario o contraseña incorrecto.","Intentar otra vez",JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public boolean closedOk()
    {
        return closedOk;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }
}

