package Database;

import java.util.List;

public interface CRUD_Autores {
    public Object Insertar(Object obj);
    public List<Object> Consultar();
    public Boolean actualizar(Object obj);
    public Boolean eliminar(Object obj);
}
