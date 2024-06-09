package test.java.com.cappataz.dao;

import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Date;

import main.java.com.cappataz.dao.PropiedadDAO;
import main.java.com.cappataz.modelo.Propiedad;

public class PropiedadDAOTest {

    @Test
    public void testSavePropiedad() {
        PropiedadDAO propiedadDAO = new PropiedadDAO();
        Propiedad propiedad = new Propiedad(0, "La Cañada", "Ruta 74 km 225", 122.6, "Mixta", new Date(System.currentTimeMillis()), 4);
        propiedadDAO.savePropiedad(propiedad);


    }
    
}
