package entidades.recursos;

import java.util.List;

import entidades.Categoria;
import entidades.Cliente;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("cliente")
public class ClienteResurso {

    @GET
    public List<Cliente> listar(){
        return Cliente.listAll();
    }

    @POST
    @Transactional
    public void salvar(Cliente cliente) {
        cliente.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir (@PathParam("codigo") Integer codigo) {
        Cliente cliente = Cliente.findById(codigo);

        if (cliente != null) {
            cliente.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar (@PathParam("codigo") Integer codigo, Cliente cliente) {
        Cliente clienteExistente = Cliente.findById(codigo);

        if (clienteExistente != null) {
            clienteExistente.nome = cliente.nome;
            clienteExistente.cpf = cliente.cpf;

            clienteExistente.persist();
        }
    }
}

