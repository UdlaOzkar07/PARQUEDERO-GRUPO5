import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAdministracion extends JFrame{
    private ListaUsuario listaUsuario = new ListaUsuario();
    private ListaTarifa listaTarifa = new ListaTarifa();
    private ListaCliente listaCliente = new ListaCliente();
    private Grafo  ingresarVehiculo = new Grafo(10);
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
    private JButton btnIngresar;
    private JTextField txtPlaca;
    private JComboBox cbxMarca;
    private JLabel lblMarca;
    private JLabel lblTipoVehiculo;
    private JComboBox cbxTioVehiculo;
    private JButton btnRetirarPlaca;
    private JTextField txtRetirarPlaca;
    private JLabel lblRetirarVehiculo;
    private JLabel lblRetirarPlaca;
    private JTable tblTarifa;
    private JButton btnNuevoTarifa;
    private JButton btnEditarTarifa;
    private JButton btnEliminarTarifa;
    private JTable tblCliente;
    private JButton btnNuevoCliente;
    private JButton btnEditarCliente;
    private JButton btnEliminarCliente;
    private JTable table3;

    public FrmAdministracion() {
        setTitle("PARQUEADERO");
        setContentPane(Admin);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,400);
        setLocationRelativeTo(null);

        actualizarTabla();

        btnNuevoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmUsuario frmUsuario = new FrmUsuario(listaUsuario,-1);
                frmUsuario.setTitle("Nuevo Usuario");
                frmUsuario.setSize(400,400);
                frmUsuario.setLocationRelativeTo(Admin);
                frmUsuario.setVisible(true);
                crearTablaUsuario();
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
                    crearTablaUsuario();
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

        setVisible(true);
        btnNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearTablaCliente();
            }
        });
        btnEditarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearTablaCliente();
            }
        });
        btnEliminarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow = tblCliente.getSelectedRow();

                if(selectRow >= 0) {
                    if(JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea eliminar el registro?") == 0){
                        listaCliente.eliminarCliente(selectRow);
                        crearTablaCliente();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"Seleccionar un registro");
            }
        });
        btnNuevoTarifa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmTarifa frmTarifa = new FrmTarifa(listaTarifa,-1);
                frmTarifa.setTitle("Nueva Tarifa");
                frmTarifa.setSize(400,400);
                frmTarifa.setLocationRelativeTo(Admin);
                frmTarifa.setVisible(true);
                crearTablaTarifa();
            }
        });
        btnEditarTarifa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow = tblTarifa.getSelectedRow();
                if(selectRow >= 0) {
                    Integer idTarifa = (Integer) tblTarifa.getValueAt(selectRow,0);

                    FrmTarifa frmTarifa = new FrmTarifa(listaTarifa, selectRow);
                    frmTarifa.setTitle("Editar tarifa: " + idTarifa);
                    frmTarifa.setSize(400,400);
                    frmTarifa.setLocationRelativeTo(Admin);
                    frmTarifa.setVisible(true);
                    crearTablaTarifa();
                }
                else
                    JOptionPane.showMessageDialog(null,"Seleccionar un registro");
            }
        });
        btnEliminarTarifa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow = tblTarifa.getSelectedRow();

                if(selectRow >= 0) {
                    if(JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea eliminar el registro?") == 0){
                        listaTarifa.eliminarTarifa(selectRow);
                        crearTablaTarifa();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"Seleccionar un registro");
            }
        });
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                String tipoVehiculo = cbxTioVehiculo.getSelectedItem().toString();
                String marca = cbxMarca.getSelectedItem().toString();

                Vehiculo vehiculo = new Vehiculo(placa,tipoVehiculo,marca);
                ingresarVehiculo.agregarArista(0,1,vehiculo);
                JOptionPane.showMessageDialog(null,"Vehiculo Ingresado");
            }
        });
    }

    private void actualizarTabla(){
        crearTablaUsuario();
        crearTablaTarifa();
        crearTablaCliente();
    }

    public JPanel getAdmin() {
        return Admin;
    }

    private void crearTablaUsuario()
    {
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Id. Usuario");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Correo");
        modeloTabla.addColumn("Contraseña");

        modeloTabla.setRowCount(0);

        for (Usuario datos : listaUsuario.listarUsuarios()) {
            modeloTabla.addRow(new Object[]{datos.getIdUsuario(),datos.getNombre(),datos.getCorreo(), datos.getClave()});
        }

        tblUsuario.setModel(modeloTabla);
    }

    private void crearTablaTarifa()
    {
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Id. Tarifa");
        modeloTabla.addColumn("Tipo vehículo");
        modeloTabla.addColumn("Valor tarifa(Fracción hora)");

        modeloTabla.setRowCount(0);

        for (Tarifa datos : listaTarifa.listarTarifas()) {
            modeloTabla.addRow(new Object[]{datos.getIdTarifa(),datos.getTipoVehiculo(),datos.getValorTarifa()});
        }

        tblTarifa.setModel(modeloTabla);
    }
    private void crearTablaCliente()
    {
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Identificación");
        modeloTabla.addColumn("Tipo identificación");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Correo");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Dirección");

        modeloTabla.setRowCount(0);

        for (Cliente datos : listaCliente.listarClientes()) {
            modeloTabla.addRow(new Object[]{datos.getRuc(),datos.getTipoIdentificacion(),datos.getNombre(),datos.getApellido(),datos.getCorreo(),datos.getTelefono(),datos.getDireccion()});
        }

        tblCliente.setModel(modeloTabla);
    }
}
