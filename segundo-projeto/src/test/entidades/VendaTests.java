package entidades;

import jakarta.transaction.Transactional;

@QuarkusTest
public class VendaTests {
    @test
    @Transactional
    public void TesteSalvaValorTotalQuantidadeTotalClienteEFuncionarioEMostraResultado(){
        Venda venda = new Venda();
        venda.valorT = "200";
        venda.quantT = "20";
        venda.cliente = "11";
        venda.funcionario = "11";
    
        venda.persist();
        Assertions.assertEquals(venda.codigo, 11);
    }
}
