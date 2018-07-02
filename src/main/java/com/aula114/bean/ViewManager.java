package com.aula114.bean;

import com.aula114.service.ServiceUsuarios;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.aula114.model.Usuarios;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "usuarios")
//Permite que el objeto viva durante el tiempo que dure la sesion
@SessionScoped
public class ViewManager implements Serializable {

    private static final long serialVersionUID = 1L;
    private Usuarios item1 = new Usuarios();
    private ServiceUsuarios m = new ServiceUsuarios();
    private List<Usuarios> listaUsuarios = new ArrayList<>();
    private List<Usuarios> filterUsuarios = new ArrayList<>();
    private boolean existUser = true;
    private boolean isAdmin = true;
    private boolean edit;
    //Inyeccion de la clase serviceUsuarios, evita la utilizacion de new clase()
    @ManagedProperty("#{serviceUsuario}")
    private ServiceUsuarios service;

    /*
        Permite que el metodo bajo esta anotación se cargue nada mas arracancar
        la aplicacion
    
     */
    @PostConstruct
    public void listaUsuarios() {
        listaUsuarios = service.ListaUsuarios();
    }

    //Este metodo es utilizado para la inserción de los usuarios
    public String add() {

        /*
             comprobamos si el usuario se encuentra en la base de datos, en caso de 
             no encontrarse insertamos los datos del nuevo usuario en la base de datos        
         */
        if (!(service.existeUsuario(item1))) {
            /*
             Este metodo sera usado para que los usuarios se registren en la web,
             por tanto se agregará el rol noadmin automaticamente, para ello sera
             agregado directamente por medio del metodo setRol del objeto de tipo
             Usuario, una vez insertado, limpiamos los valores del objeto y retornamos
             a la vista del login.            
             */
            item1.setRol("noadmin");
            service.insert(item1);
            //Agregamos los datos del objeto a la lista(arrayList)
            listaUsuarios.add(item1);
            item1 = new Usuarios();
            existUser = true;
            return "login";
        }
        /*
            En caso contrario cambiamos la variable existeUser a false y retornamos
            a la vista de registro nuevamente.        
         */
        existUser = false;

        return "registro";
    }

    /*
        Metodo que permite recoger los datos del usuario seleccionado para ser 
        editado en la tabla listaUsuarios y permitira editar los campos    
     */
    public void edit(Usuarios usuarios) {
        this.item1 = usuarios;
        //System.out.println(item1);
        edit = true;
    }

    /*
        Metodo que guardara los datos ya editados.    
     */
    public void save() {
        service.updateUsuario(item1);
        item1.setNombre("admin");
        listaUsuarios = service.ListaUsuarios();
        edit = false;
    }

    //Metodo para eliminar al usuario seleccionado
    public void delete(Usuarios usuarios) {
        listaUsuarios.remove(usuarios);
        service.delete(usuarios.getNombre());
        item1.setNombre("admin");
        listaUsuarios = service.ListaUsuarios();
    }

    /*
        Este metodo servira para modificar los datos del perfil del usuario por
        el propio usuario
     */
    public void guardarDatosUsuario() {
        service.updateUsuario(item1);
        //item1 = new Usuarios();
        edit = false;
    }

    /*
        Metodo que permite la eliminacion de la cuenta del usuario de la pagina
     */
    public void baja(Usuarios usuario) {
        listaUsuarios.remove(usuario);
        service.delete(usuario.getNombre());
        item1.setNombre("");
    }

    /*
     *  Login de Usuario 
     */
    public String login() {
        /*
         * verifico si el valor de la propiedad password extraida de la base de
         * datos mysql coincide con el valor introducido en el imput de vista1,
         * si esto es afirmativo, entonces llamo al metodo grupos que realizara
         * un listado de los cursos que pertenecen a ese profesor que acaba de
         * iniciar sesion y este sera enviado a la vista2
         */

        if (m.verificarUsuario(item1) == true) {

            if (!(item1.getNombre().equals("admin"))) {
                this.item1 = service.obtenerUsuario(item1.getNombre());
                isAdmin = false;
            } else {
                listaUsuarios = service.ListaUsuarios();
                isAdmin = true;
            }
            return "home";
        }
        /* Si no es correcto no cambiará de vista */
        existUser = false;
        item1 = new Usuarios();
        return "login";
    }

    //Metodo desloguear, limpia los datos del objeto Usuario y reotna al login
    public String desloguear() {
        /*
                 * Para desloguear inicializo un nuevo objeto, con lo cual
                 * limpio el contenido del objeto e inicializo la variable
                 * existeUser a true y por ultimo retorno a la vista
                 * perteneciente al login.
         */

        item1 = new Usuarios();

        existUser = true;
        return "login";
    }

    //GETTER && ETTER
    public boolean isExistUser() {
        return existUser;
    }

    public ServiceUsuarios getM() {
        return m;
    }

    public Usuarios getItem1() {
        return item1;
    }

    public void setItem1(Usuarios item1) {
        this.item1 = item1;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public ServiceUsuarios getService() {
        return service;
    }

    public void setService(ServiceUsuarios service) {
        this.service = service;
    }

    public List<Usuarios> getFilterUsuarios() {
        return filterUsuarios;
    }

    public void setFilterUsuarios(List<Usuarios> filterUsuarios) {
        this.filterUsuarios = filterUsuarios;
    }

}
