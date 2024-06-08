package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.PropiedadDAO;
import main.java.com.cappataz.dao.UsuarioDAO;
import main.java.com.cappataz.modelo.Propiedad;
import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.vista.PropiedadView;

import java.util.ArrayList;
import java.util.List;


public class PropiedadController {
    private PropiedadView view;
    private PropiedadDAO dao;
    private UsuarioDAO usuarioDAO;

    public PropiedadController(PropiedadView view) {
        this.view = view;
        this.dao = new PropiedadDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    public void savePropiedad(Propiedad propiedad) {
        dao.savePropiedad(propiedad);
        view.mostrarDetallesPropiedad(propiedad);
    }

    public void modifyPropiedad(int idPropiedad) {
        Propiedad propiedad = dao.getPropiedadById(idPropiedad);
        if (propiedad != null) {
            view.mostrarDetallesPropiedad(propiedad);
            propiedad.setNombrePropiedad(view.getNombrePropiedad());
            propiedad.setUbicacion(view.getUbicacion());
            propiedad.setSuperficie(view.getSuperficie());
            propiedad.setTipoPropiedad(view.getTipoPropiedad());
            dao.updatePropiedad(propiedad);
        } else {
            view.mostrarError("Propiedad no encontrada");
        }
    }

    public void displayPropiedadById(int idPropiedad) {
        Propiedad propiedad = dao.getPropiedadById(idPropiedad);
        if (propiedad != null) {
            Propietario propietario = usuarioDAO.getPropietarioById(propiedad.getIdPropietario());
            view.mostrarDetallesPropiedadConPropietario(propiedad,
                    propietario.getNombre() + " " + propietario.getApellido());
        } else {
            view.mostrarError("Propiedad no encontrada");
        }
    }

    public List<Propiedad> getPropiedadesPaginated(int pageNumber, int pageSize) {
        return dao.getPropiedadesPaginated(pageNumber * pageSize, pageSize);
    }

    public List<Propiedad> getPropiedadesByPropietario(int idPropietario) {
        return dao.getPropiedadesByPropietario(idPropietario);
    }

    public void gestionarPropiedades() {
        int pageNumber = 0;
        boolean exit = false;

        while (!exit) {
            List<Propiedad> propiedades = getPropiedadesPaginated(pageNumber, 10);
            if (propiedades.isEmpty()) {
                view.mostrarMensaje("No hay más propiedades.");
                break;
            }
            List<String> nombresPropietarios = obtenerNombresPropietarios(propiedades);
            view.mostrarTodasLasPropiedades(propiedades, nombresPropietarios);

            int choice = view.mostrarMenuPropiedades();

            switch (choice) {
                case 1:
                    pageNumber++;
                    break;
                case 2:
                    if (pageNumber > 0)
                        pageNumber--;
                    break;
                case 3:
                    seleccionarPropiedad();
                    break;
                case 4:
                    modificarPropiedad();
                    break;
                case 5:
                    filtrarPropiedadesPorPropietario();
                    break;
                case 6:
                    exit = true;
                    break;
                case 7:
                    return;
                default:
                    view.mostrarMensaje("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private List<String> obtenerNombresPropietarios(List<Propiedad> propiedades) {
        List<String> nombresPropietarios = new ArrayList<>();
        for (Propiedad propiedad : propiedades) {
            Propietario propietario = usuarioDAO.getPropietarioById(propiedad.getIdPropietario());
            nombresPropietarios.add(propietario.getNombre() + " " + propietario.getApellido());
        }
        return nombresPropietarios;
    }

    public void filtrarPropiedadesPorPropietario() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Propietario> propietarios = usuarioDAO.getPropietarios();

        int choice = view.seleccionarPropietario(propietarios);

        if (choice < 1 || choice > propietarios.size()) {
            view.mostrarMensaje("Opción no válida. Por favor, intente de nuevo.");
            return;
        }

        Propietario propietarioSeleccionado = propietarios.get(choice - 1);
        List<Propiedad> propiedadesFiltradas = getPropiedadesByPropietario(propietarioSeleccionado.getIdUsuario());
        List<String> nombresPropietarios = obtenerNombresPropietarios(propiedadesFiltradas);
        view.mostrarTodasLasPropiedades(propiedadesFiltradas, nombresPropietarios);

        view.mostrarMenuGestionPropiedad();
    }

    private void seleccionarPropiedad() {
        int idPropiedad = view.getIdPropiedad();
        displayPropiedadById(idPropiedad);
    }

    private void modificarPropiedad() {
        int idPropiedad = view.getIdPropiedad();
        modifyPropiedad(idPropiedad);
    }
}
