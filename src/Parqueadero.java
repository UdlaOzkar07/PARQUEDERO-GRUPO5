import javax.swing.*;

public class Parqueadero {
    ListaUsuario usuarios = new ListaUsuario();
    Usuario     usuario;
    public static void main(String[] args){
        Parqueadero parqueadero = new Parqueadero();
        parqueadero.run();
    }

    private void run()
    {
        if (accederSistema() == true)
        {
            FrmAdministracion administracion = new FrmAdministracion();
        }
    }

    private boolean accederSistema()
    {
        FrmLogin dialog = new FrmLogin(usuarios);

        if (dialog.closedOk()){
            usuario = dialog.getUsuario();
            return true;
        }

        return false;
    }
}
