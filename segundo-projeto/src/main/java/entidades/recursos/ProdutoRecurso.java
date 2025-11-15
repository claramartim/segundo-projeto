package recursos;

import java.util.List;

import entidades.Produto;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("produtos")
public class ProdutoRecurso {
    @GET
    public List<Produto> listar(){
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void salvar(Produto produto) {
        produto.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir (@PathParam("codigo") Integer codigo) {
        Produto produto = Produto.findById(codigo);

        if (produto != null) {
            produto.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar (@PathParam("codigo") Integer codigo, Produto produto) {
        Produto produtoExistente = Produto.findById(codigo);

        if (produtoExistente != null) {
            produtoExistente.nome = produto.nome;
            produtoExistente.quantidade = produto.quantidade;
            produtoExistente.preco = produto.preco;
            produtoExistente.categoria = produto.categoria;
            produtoExistente.fabricante = produto.fabricante;

            produtoExistente.persist();
        }
    }
}