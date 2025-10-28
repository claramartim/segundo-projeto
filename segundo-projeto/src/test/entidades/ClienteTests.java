package entidades;

import jakarta.transaction.Transactional;

@QuarkusTest
public class ClienteTests {
    @test
    @Transactional
    public void TestSalvaNomeECpfDoClienteEMostraResultadoDoClienteSalvo(){
        Cliente cliente = new Cliente();

        cliente.nome = "Helena";
        cliente.cpf = "63721433021";

        cliente.persist();

        Assertions.assertEquals(cliente.codigo, 11);
    }
}
