package entidades.recursos;

import java.util.List;

import entidades.Categoria;
import entidades.Cliente;
import entidades.Fabricante;
import entidades.Funcionario;
import entidades.ItemVenda;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("itemVenda")
public class ItemVendaRecurso {

    @GET
    public List<ItemVenda> listar(){
        return ItemVenda.listAll();
    }

    @POST
    @Transactional
    public void salvar(ItemVenda itemVenda) {
        itemVenda.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir (@PathParam("codigo") Integer codigo) {
        ItemVenda itemVenda = ItemVenda.findById(codigo);

        if (itemVenda != null) {
            itemVenda.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar (@PathParam("codigo") Integer codigo, ItemVenda itemVenda) {
        ItemVenda itemVendaExistente = ItemVenda.findById(codigo);

        if (itemVendaExistente != null) {
            itemVendaExistente.quantParcial = itemVenda.quantParcial;
            itemVendaExistente.valorParcial = itemVenda.valorParcial;
            itemVendaExistente.produto = itemVenda.produto;

            itemVendaExistente.persist();
        }
    }
}
