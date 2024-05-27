package main.java.com.cappataz;

import main.java.com.cappataz.controlador.UsuarioController;
import main.java.com.cappataz.menus.MenuAdministrador;
import main.java.com.cappataz.menus.MenuOperario;
import main.java.com.cappataz.menus.MenuPropietario;
import main.java.com.cappataz.modelo.Administrador;
import main.java.com.cappataz.modelo.Operario;
import main.java.com.cappataz.modelo.Propietario;
import main.java.com.cappataz.modelo.IUsuario;
import main.java.com.cappataz.vista.UsuarioView;

public class Main {
    public static void main(String[] args) throws Exception {
        UsuarioView usuarioView = new UsuarioView();
        UsuarioController usuarioController = new UsuarioController(null, usuarioView);

        System.out.println("");
        System.out.print("""
               .
               X                8                                                                                       
              X:X              X0X                                                                                      
             X0:8    XXXXXX    X::X                                                                                     
             X0:::X:        :X0:00X                                                                                     
              X::X            X:0X                                                                                      
              X:X:             X:X                                                                                      
               X                X                                                                                       
   XXXXXX     X8                0X     XXXXXX                                                                           
XX:888800X:X  X80              00X  X8:888880XXX                                                                        
X088888808888X8880            0088X080888808880X                                                                        
X008800888880X00800          88888X88880088880:X                                                                        
 X00::0808888X08XX8          8XXX8X8800088000:X                                                                         
  X00:0::8088X0X X08        88X X8X80080:0:00X                                                                          
   XX0:0:0000X8X8X00        80X8X0X0:000000XX                                                                           
       XXXX  X888088        088888X  X8XX                                                                               
          :  X800088        888808X    :         .488880.                                      888                      
              X88880        88008X              4887  X880                                     888                      
              :X8080        8008X               888    888                                     888                      
               X088:        :088X               888         88880.  888880.  888880.   88880.  888888  88880.  88888888 
               8008          888X               888            :880 888 :880 888 :880     :880 888        :880    4887  
               X00            80X               888    888 .4888888 888  888 888  888 .4888888 888    .4888888   4887   
               X               0X               X880  4887 888  888 888 4887 888 4887 888  888 X880.  888  888  4887    
               X  0XX088088X80  X                :X88887:  :X888888 888887:  888887:  :X888888  :X888 :X888888 88888888 
               X 8X:00000::00X8 X                                   888      888                                        
              X  0X0000000000X8  X                                  888      888                                        
             X   00X:000000:X08   X                                 888      888                                        
             X    88XX00008808    X                                                                                     
             X     0888XX8000     X                                                                                     
             X    808800800888    X                                 SISTEMA DE GESTIÓN GANADERA                         
              X 0000088800008800 X                                                                                      
               XXXXX88888888XXXXX                                                                                       
                    XXXXXXXX :                                                                                          
                     :::::                                                                                              
                     \n""");

        IUsuario usuario = null;
        while (usuario == null) {
            usuario = usuarioController.login();
        }


        switch (usuario.getIdRol()) {
            case 1:
                MenuAdministrador menuAdministrador = new MenuAdministrador((Administrador) usuario);
                menuAdministrador.mostrarMenu();
                break;
            case 2:
                MenuPropietario menuPropietario = new MenuPropietario((Propietario) usuario);
                menuPropietario.mostrarMenu();
                break;
            case 3:
                MenuOperario menuOperario = new MenuOperario((Operario) usuario);
                menuOperario.mostrarMenu();
                break;
            default:
                System.out.println("Rol no reconocido.");
                break;
        }
    }
}
