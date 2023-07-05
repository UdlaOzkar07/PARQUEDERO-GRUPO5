import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAdministracion {
    private ListaUsuario listaUsuario = new ListaUsuario();
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTabbedPane tabAdmin;
    private JPanel Admin;
    private JPanel Usuario;
    private JList<String> lstUsuarios;
    private JButton btnEditarUsuario;
    private JButton btnEliminarUsuario;
    private JTable tblUsuario;
    private JPanel JPTablaUsuario;
    private JScrollPane jscllTablaUsuario;
    private JPanel JPBotonesUsuario;
    private JButton btnNuevoUsuario;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Administracion");
        frame.setContentPane(new FrmAdministracion().Admin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(900,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public FrmAdministracion() {

        modeloTabla.addColumn("Id. Usuario");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Correo");
        modeloTabla.addColumn("Contraseña");

        actualizarTabla();

        btnNuevoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmUsuario frmUsuario = new FrmUsuario(listaUsuario,-1);
                frmUsuario.setTitle("Nuevo Usuario");
                frmUsuario.setSize(400,400);
                frmUsuario.setLocationRelativeTo(Admin);
                frmUsuario.setVisible(true);
                actualizarTabla();
            }
        });
        btnEditarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow = tblUsuario.getSelectedRow();
                if(selectRow >= 0) {
                    String idUsuario = (String) tblUsuario.getValueAt(selectRow,0);

                    FrmUsuario frmUsuario = new FrmUsuario(listaUsuario, selectRow);
                    frmUsuario.setTitle("Editar usuario: " + idUsuario);
                    frmUsuario.setSize(400,400);
                    frmUsuario.setLocationRelativeTo(Admin);
                    frmUsuario.setVisible(true);
                    actualizarTabla();
                }
                else
                    JOptionPane.showMessageDialog(null,"Seleccionar un registro");
            }
        });
        btnEliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow = tblUsuario.getSelectedRow();

                if(selectRow >= 0) {
                    if(JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea eliminar el registro?") == 0){
                        listaUsuario.eliminarUsuario(selectRow);
                        actualizarTabla();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"Seleccionar un registro");
            }
        });
    }

    private void actualizarTabla(){
        modeloTabla.setRowCount(0);

        for (Usuario datos : listaUsuario.listarUsuarios()) {
            modeloTabla.addRow(new Object[]{datos.getIdUsuario(),datos.getNombre(),datos.getCorreo(), datos.getClave()});
        }

        tblUsuario.setModel(modeloTabla);
    }
}
