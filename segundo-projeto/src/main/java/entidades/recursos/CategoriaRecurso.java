package entidades.recursos;

import java.util.List;

import entidades.Categoria;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("categoria")
public class CategoriaRecurso {

    @GET
    public List<Categoria> listar(){
        return Categoria.listAll();
    }

    @POST
    @Transactional
    public void salvar(Categoria categoria) {
        categoria.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir (@PathParam("codigo") Integer codigo) {
        Categoria categoria = Categoria.findById(codigo);

        if (categoria != null) {
            categoria.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar (@PathParam("codigo") Integer codigo, Categoria categoria) {
        Categoria categoriaExistente = Categoria.findById(codigo);

        if (categoriaExistente != null) {
            categoriaExistente.nome = categoria.nome;

            categoriaExistente.persist();
        }
    }
}

