package entidades;

import jakarta.transaction.Transactional;

@QuarkusTest
public class ProdutoTests {
    @test
    @Transactional
    public void TestSalvaNomeQuantidadePrecoValidadeCategoriaEFabricanteEMostraResultado(){
        Produto produto = new Produto();
        produto.nome = "Garrafinha";
        produto.quantidade = "20";
        produto.preco = "15";
        produto.validade = "2050-12-10";
        produto.categoria = "11";
        produto.fabricante = "11";

        produto.persist();
        Assertions.assertEquals(produto.codigo, 11);

    }
}
