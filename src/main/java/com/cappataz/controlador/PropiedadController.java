package main.java.com.cappataz.controlador;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import main.java.com.cappataz.dao.PropiedadDAO;
import main.java.com.cappataz.dao.UsuarioDAO;
import main.java.com.cappataz.gui.PanelGestionParcelas;
import main.java.com.cappataz.modelo.Propiedad;
import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.vista.PropiedadView;

public class PropiedadController {
    private PropiedadView view;
    private PropiedadDAO dao;
    private UsuarioDAO usuarioDAO;

    public PropiedadController(PropiedadView view) {
        this.view = view;
        this.dao = new PropiedadDAO();
        this.usuarioDAO = new UsuarioDAO();
        initialize();
    }

    private void initialize() {
        view.getBtnRegistrarPropiedad().addActionListener(e -> registrarPropiedad());

        view.getBtnVisualizarPropiedad().addActionListener(e -> {
            int selectedRow = view.getTablaPropiedades().getSelectedRow();
            if (selectedRow != -1) {
                Object value = view.getTablaPropiedades().getValueAt(selectedRow, 0); // Asegúrate de que es la columna correcta
                int idPropiedad = Integer.parseInt(value.toString());
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(view);
                topFrame.getContentPane().removeAll();
                topFrame.getContentPane().add(new PanelGestionParcelas(idPropiedad));
                topFrame.revalidate();
                topFrame.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una propiedad para visualizar.");
            }
        });

        view.getBtnModificarPropiedad().addActionListener(e -> {
            int selectedRow = view.getTablaPropiedades().getSelectedRow();
            if (selectedRow != -1) {
                Object value = view.getTablaPropiedades().getValueAt(selectedRow, 0); // Asegúrate de que es la columna
                                                                                      // correcta
                int idPropiedad = Integer.parseInt(value.toString());
                modifyPropiedad(idPropiedad);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una propiedad para modificar.");
            }
        });

        view.getBtnBorrarPropiedad().addActionListener(e -> {
            int selectedRow = view.getTablaPropiedades().getSelectedRow();
            if (selectedRow != -1) {
                Object value = view.getTablaPropiedades().getValueAt(selectedRow, 0); // Asegúrate de que es la columna
                                                                                      // correcta
                int idPropiedad = Integer.parseInt(value.toString());
                int confirmation = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de que desea borrar esta propiedad?", "Confirmar Borrado",
                        JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    deletePropiedad(idPropiedad);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una propiedad para borrar.");
            }
        });
    }

    public void cargarPropiedades() {
        List<Propiedad> propiedades = dao.getAllPropiedades();
        List<String> nombresPropietarios = obtenerNombresPropietarios(propiedades);
        view.mostrarPropiedades(propiedades, nombresPropietarios);
    }

    public void registrarPropiedad() {
        // Show dialog or new window for entering new property details
        String nombre = JOptionPane.showInputDialog("Nombre de la Propiedad");
        String ubicacion = JOptionPane.showInputDialog("Ubicación de la Propiedad");
        double superficie = Double.parseDouble(JOptionPane.showInputDialog("Superficie de la Propiedad"));
        String tipo = JOptionPane.showInputDialog("Tipo de la Propiedad");
        int idPropietario = Integer.parseInt(JOptionPane.showInputDialog("ID del Propietario"));

        Propiedad nuevaPropiedad = new Propiedad();
        nuevaPropiedad.setNombrePropiedad(nombre);
        nuevaPropiedad.setUbicacion(ubicacion);
        nuevaPropiedad.setSuperficie(superficie);
        nuevaPropiedad.setTipoPropiedad(tipo);
        nuevaPropiedad.setIdPropietario(idPropietario);

        savePropiedad(nuevaPropiedad);
    }

    public void savePropiedad(Propiedad propiedad) {
        dao.savePropiedad(propiedad);
        cargarPropiedades();
    }

    public void modifyPropiedad(int idPropiedad) {
        Propiedad propiedad = dao.getPropiedadById(idPropiedad);
        if (propiedad != null) {
            // Show the property details in a dialog or a new window for editing
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo Nombre", propiedad.getNombrePropiedad());
            String nuevaUbicacion = JOptionPane.showInputDialog("Nueva Ubicación", propiedad.getUbicacion());
            double nuevaSuperficie = Double
                    .parseDouble(JOptionPane.showInputDialog("Nueva Superficie", propiedad.getSuperficie()));
            String nuevoTipo = JOptionPane.showInputDialog("Nuevo Tipo", propiedad.getTipoPropiedad());

            propiedad.setNombrePropiedad(nuevoNombre);
            propiedad.setUbicacion(nuevaUbicacion);
            propiedad.setSuperficie(nuevaSuperficie);
            propiedad.setTipoPropiedad(nuevoTipo);
            dao.updatePropiedad(propiedad);
            cargarPropiedades();
        } else {
            JOptionPane.showMessageDialog(null, "Propiedad no encontrada");
        }
    }

    public void displayPropiedadById(int idPropiedad) {
        Propiedad propiedad = dao.getPropiedadById(idPropiedad);
        if (propiedad != null) {
            Propietario propietario = usuarioDAO.getPropietarioById(propiedad.getIdPropietario());
            JOptionPane.showMessageDialog(null,
                    "ID: " + propiedad.getIdPropiedad() + "\nNombre: " + propiedad.getNombrePropiedad()
                            + "\nUbicación: " + propiedad.getUbicacion() + "\nSuperficie: " + propiedad.getSuperficie()
                            + "\nTipo: " + propiedad.getTipoPropiedad() + "\nFecha de Registro: "
                            + propiedad.getFechaRegistro() + "\nPropietario: " + propietario.getNombre() + " "
                            + propietario.getApellido());
        } else {
            JOptionPane.showMessageDialog(null, "Propiedad no encontrada");
        }
    }

    public void deletePropiedad(int idPropiedad) {
        dao.deletePropiedad(idPropiedad);
        cargarPropiedades();
    }

    private List<String> obtenerNombresPropietarios(List<Propiedad> propiedades) {
        List<String> nombresPropietarios = new ArrayList<>();
        for (Propiedad propiedad : propiedades) {
            Propietario propietario = usuarioDAO.getPropietarioById(propiedad.getIdPropietario());
            nombresPropietarios.add(propietario.getNombre() + " " + propietario.getApellido());
        }
        return nombresPropietarios;
    }

    public void gestionarPropiedades() {
        cargarPropiedades();
    }

    public void filtrarPropiedadesPorPropietario() {
        List<Propietario> propietarios = usuarioDAO.getPropietarios();
        Propietario propietarioSeleccionado = (Propietario) JOptionPane.showInputDialog(null,
                "Seleccione un propietario", "Filtrar Propiedades", JOptionPane.QUESTION_MESSAGE, null,
                propietarios.toArray(), propietarios.get(0));
        if (propietarioSeleccionado != null) {
            List<Propiedad> propiedades = dao.getPropiedadesByPropietario(propietarioSeleccionado.getIdUsuario());
            List<String> nombresPropietarios = obtenerNombresPropietarios(propiedades);
            view.mostrarPropiedades(propiedades, nombresPropietarios);
        }
    }

    public List<Propiedad> getAllPropiedades() {
        return dao.getAllPropiedades();
    }

    public String getNombrePropietario(int idPropietario) {
        Propietario propietario = usuarioDAO.getPropietarioById(idPropietario);
        if (propietario != null) {
            return propietario.getNombre() + " " + propietario.getApellido();
        }
        return "Desconocido";
    }
}
