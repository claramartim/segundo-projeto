package entidades;

import jakarta.transaction.Transactional;

@QuarkusTest
public class FuncionarioTests {
    @test
    @Transactional
    public void TestSalvaNomeECpfDoFuncionarioEMostraResultado(){
        Funcionario funcionario = new Funcionario();

        funcionario.nome = "Jober";
        funcionario.cpf = "10938465097";

        funcionario.persist();
        Assertions.assertEquals(funcionario.codigo, 11);
    }
}
