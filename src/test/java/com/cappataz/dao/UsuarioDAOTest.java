package test.java.com.cappataz.dao;

import main.java.com.cappataz.modelo.Propietario;

import main.java.com.cappataz.dao.UsuarioDAO;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class UsuarioDAOTest {

    @Test
    public void testGetPropietarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Propietario> propietarios = usuarioDAO.getPropietarios();

        assertNotNull(propietarios);
        assertTrue("La lista de propietarios no debería estar vacía", propietarios.size() > 0);
    }

    // Otros métodos de prueba...
}
