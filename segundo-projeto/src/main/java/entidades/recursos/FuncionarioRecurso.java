package entidades.recursos;

import java.util.List;

import entidades.Categoria;
import entidades.Cliente;
import entidades.Fabricante;
import entidades.Funcionario;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("funcionario")
public class FuncionarioRecurso {

     @GET
    public List<Funcionario> listar(){
        return Funcionario.listAll();
    }

    @POST
    @Transactional
    public void salvar(Funcionario funcionario) {
        funcionario.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir (@PathParam("codigo") Integer codigo) {
        Funcionario funcionario = Funcionario.findById(codigo);

        if (funcionario != null) {
            funcionario.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar (@PathParam("codigo") Integer codigo, Funcionario funcionario) {
        Funcionario funcionarioExistente = Funcionario.findById(codigo);

        if (funcionarioExistente != null) {
            funcionarioExistente.nome = funcionario.nome;
            funcionarioExistente.cpf = funcionario.cpf;

            funcionarioExistente.persist();
        }
    }
}
