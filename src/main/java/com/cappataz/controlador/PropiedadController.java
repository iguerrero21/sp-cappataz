package main.java.com.cappataz.controlador;

import main.java.com.cappataz.dao.PropiedadDAO;
import main.java.com.cappataz.modelo.Propiedad;
import main.java.com.cappataz.vista.PropiedadView;

import java.util.List;

public class PropiedadController {
    private PropiedadView view;
    private PropiedadDAO dao;

    public PropiedadController(PropiedadView view) {
        this.view = view;
        this.dao = new PropiedadDAO();
    }

    public void savePropiedad(Propiedad propiedad) {
        dao.savePropiedad(propiedad);
        view.mostrarDetallesPropiedades(new Object[] {
                propiedad.getIdPropiedad(),
                propiedad.getNombrePropiedad(),
                propiedad.getUbicacion(),
                propiedad.getSuperficie(),
                propiedad.getTipoPropiedad(),
                propiedad.getFechaRegistro(),
                ""
        });
    }

    public List<Object[]> getPropiedadesPaginated(int pageNumber, int pageSize) {
        int offset = pageNumber * pageSize;
        return dao.getPropiedadesPaginated(offset, pageSize);
    }

    public void displayAllPropiedades() {
        List<Object[]> propiedades = dao.getAllPropiedadesWithPropietario();
        view.mostrarTodasLasPropiedades(propiedades);
    }

    public void displayPropiedadById(int idPropiedad) {
        Object[] propiedad = dao.getPropiedadById(idPropiedad);
        if (propiedad != null) {
            view.mostrarDetallesPropiedades(propiedad);
        } else {
            System.out.println("No se encontró la propiedad con ID: " + idPropiedad);
        }
    }

    public void modifyPropiedad(int idPropiedad) {
        // Aquí se puede implementar la lógica para modificar una propiedad
        // Por ejemplo, se puede obtener la propiedad actual, mostrar los detalles al
        // usuario y permitirle actualizar los campos deseados.
    }

    public void displayPropiedadesByPropietario(int idPropietario) {
        List<Object[]> propiedades = dao.getPropiedadesByPropietario(idPropietario);
        // view.displayAllPropiedadesWithPropietario(propiedades);
    }
}

// package main.java.com.cappataz.controlador;

// import java.util.List;

// import main.java.com.cappataz.dao.PropiedadDAO;
// import main.java.com.cappataz.modelo.Propiedad;
// import main.java.com.cappataz.vista.PropiedadView;

// public class PropiedadController {
//     private PropiedadView view;
//     private PropiedadDAO dao;

//     public PropiedadController(PropiedadView view) {
//         this.view = view;
//         this.dao = new PropiedadDAO();
//     }

//     public void savePropiedad(Propiedad propiedad) {
//         dao.savePropiedad(propiedad);
//         view.displayPropiedadDetails(new Object[]{
//             propiedad.getIdPropiedad(),
//             propiedad.getNombrePropiedad(),
//             propiedad.getUbicacion(),
//             propiedad.getSuperficie(),
//             propiedad.getTipoPropiedad(),
//             propiedad.getFechaRegistro().toString(),
//             // Aquí podrías necesitar ajustar cómo obtienes el nombre del propietario si es necesario
//             // o podrías omitirlo si no está disponible en este punto
//             ""
//         });
//     }
    
//     public void displayAllPropiedades() {
//         List<Object[]> propiedades = dao.getAllPropiedadesWithPropietario();
//         view.displayAllPropiedadesWithPropietario(propiedades);
//     }

//     public void displayPropiedadById(int idPropiedad) {
//         Object[] propiedad = dao.getPropiedadById(idPropiedad);
//         if (propiedad != null) {
//             view.displayPropiedadDetails(propiedad);
//         } else {
//             System.out.println("No se encontró la propiedad con ID: " + idPropiedad);
//         }
//     }
// }

//-----------------------------------------------------------------

// package main.java.com.cappataz.controlador;

// import main.java.com.cappataz.dao.PropiedadDAO;
// import main.java.com.cappataz.modelo.Propiedad;
// import main.java.com.cappataz.vista.PropiedadView;

// import java.util.List;

// public class PropiedadController {
//     private Propiedad model;
//     private PropiedadView view;
//     private PropiedadDAO dao;

//     public PropiedadController(Propiedad model, PropiedadView view) {
//         this.model = model;
//         this.view = view;
//         this.dao = new PropiedadDAO();
//     }

//     public void savePropiedad() {
//         dao.savePropiedad(model);
//         view.displayPropiedadDetails(model);
//     }

//     public void displayAllPropiedades() {
//         List<Propiedad> propiedades = dao.getAllPropiedades();
//         view.displayAllPropiedades(propiedades);
//     }
// }
