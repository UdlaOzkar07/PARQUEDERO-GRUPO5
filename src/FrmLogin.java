import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrmLogin extends JDialog{

    private JTextField txtUsuario;
    private JPasswordField pswContrasena;
    private JButton btnIngresar;
    private JPanel login;
    private JTextArea txtPrueba;

    public FrmLogin(ListaUsuario listaUsuario) {
        setContentPane(login);
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario=txtUsuario.getText();
                String contrasena= "";
                char [] password = pswContrasena.getPassword();
                for (int x=0;x<password.length;x++){
                    contrasena+=password[x];
                }
                //JOptionPane.showMessageDialog(null,contrasena);
                if (listaUsuario.vaidarUsuario(usuario,contrasena)==true){
                    /*JFrame frmAdministracion = new JFrame("Sistema de Parqueadero");
                    frmAdministracion.setVisible(true);
                    frmAdministracion.setContentPane(new FrmAdministracion().getAdmin());
                    frmAdministracion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //frame.pack();
                    frmAdministracion.setSize(500,250);
                    */
                    dispose();
                    FrmParquear frmParquear = new FrmParquear();
                    frmParquear.setTitle("Nuevo Usuario");
                    frmParquear.setSize(400,400);
                    //frmParquear.setLocationRelativeTo(Admin);
                    frmParquear.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecto.");
                }
            }
        });
    }

    /*public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Parqueadero");
        frame.setVisible(true);
        frame.setContentPane(new FrmLogin().login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(500,250);


    }*/
}

