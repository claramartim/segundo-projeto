package entidades;

import jakarta.transaction.Transactional;

@QuarkusTest
public class ItemVendaTests {
    @test
    @Transactional
    public void TestSalvaQuantidadeParcialValorParcialEProdutoEMostraResultado(){
        ItemVenda itemvenda = new ItemVenda();
        itemvenda.quantParcial = "20";
        itemvenda.valorParcial = "15";
        itemvenda.produto = "11";

        itemvenda.persist();
        Assertions.assertEquals(itemvenda.codigo, 11);
    }
}
