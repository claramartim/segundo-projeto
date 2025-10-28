package entidades;

@QuarkusTest
public class FabricanteTests {

    @test
    @Transactional
    public void TestSalvaNomeDoFabricanteEMostraResultado(){
        Fabricante fabricante = new Fabricante();

        fabricante.nome = "Garafas Persoll";
        fabricante.persist();

        Asertions.assertEquals(fabricante.codigo, 11);



    }
}
