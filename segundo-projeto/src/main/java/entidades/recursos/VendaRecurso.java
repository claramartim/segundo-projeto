package entidades.recursos;

import java.util.List;

import entidades.Categoria;
import entidades.Cliente;
import entidades.Fabricante;
import entidades.Funcionario;
import entidades.ItemVenda;
import entidades.Venda;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("venda")
public class VendaRecurso {

    @GET
    public List<Venda> listar(){
        return Venda.listAll();
    }

    @POST
    @Transactional
    public void salvar(Venda venda) {
        venda.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir (@PathParam("codigo") Integer codigo) {
        Venda venda = Venda.findById(codigo);

        if (venda != null) {
            venda.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar (@PathParam("codigo") Integer codigo, Venda venda) {
        Venda vendaExistente = Venda.findById(codigo);

        if (vendaExistente != null) {
            vendaExistente.horaVenda = venda.horaVenda;
            vendaExistente.valorT = venda.valorT;
            vendaExistente.quantT = venda.quantT;
            vendaExistente.cliente = venda.cliente;
            vendaExistente.funcionario = venda.funcionario;
            
            vendaExistente.persist();
        }
    }
}
