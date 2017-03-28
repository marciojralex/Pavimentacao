import br.com.pavimentacao.controler.OrcamentoMB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class OrcamentosTeste {
    private OrcamentoMB orcamento;
    
    private int peso;
    private static final int TONELADA_SEM_TAXA = 5;
   
    
    private double calcularTaxaPeso(int peso){
        if(peso > 5){
            return (peso - TONELADA_SEM_TAXA) * 0.02;
        }else{
            return 0.0;
        }
    }
    
    public OrcamentosTeste() {
    }
    
    @Before
    public void setUp() {
        orcamento = new OrcamentoMB();
        
        orcamento.setPeso(0);
        orcamento.setDistanciaNPavimentada(0.0);
        orcamento.setDistanciaPavimentada(0.0);
        orcamento.setResultado(0.0);
    }
   
    @Test
    public void cacambaPavimentada() {
        orcamento.setPeso(8);
        orcamento.setDistanciaPavimentada(100.0);
        orcamento.setTaxaVeiculo(1.05);
        orcamento.calcularOrcamento();
        double esperado = 62.7;
        Assert.assertEquals(esperado, orcamento.getResultado(), 0.01);
    }
     
    @Test
    public void bauNaoPavimentada() {
        orcamento.setPeso(4);
        orcamento.setDistanciaNPavimentada(60.0);
        orcamento.setTaxaVeiculo(1.0);
        orcamento.calcularOrcamento();
        double esperado = 37.2;
        Assert.assertEquals( esperado, orcamento.getResultado(), 0.01);
    }
     
    @Test
    public void carretaNaoPavimentada() {
        orcamento.setPeso(12);
        orcamento.setDistanciaNPavimentada(180);
        orcamento.setTaxaVeiculo(1.12);
        orcamento.calcularOrcamento();
        double esperado = 150.19;
        Assert.assertEquals(esperado, orcamento.getResultado(), 0.01);
    }
     
    @Test
    public void bauNaoPavimentadaEPavimentado() {
        orcamento.setPeso(6);
        orcamento.setDistanciaNPavimentada(20.0);
        orcamento.setDistanciaPavimentada(80.0);
        orcamento.setTaxaVeiculo(1.0);
        orcamento.calcularOrcamento();
        double esperado = 57.6;
        Assert.assertEquals(esperado, orcamento.getResultado(), 0.01);
    }
     
    @Test
    public void cacabaNaoPavimentadaEPavimentado() {
        orcamento.setPeso(5);
        orcamento.setDistanciaNPavimentada(30.0);
        orcamento.setDistanciaPavimentada(50.0);
        orcamento.setTaxaVeiculo(1.05);
        orcamento.calcularOrcamento();
        double esperado = 47.88;
        Assert.assertEquals( esperado, orcamento.getResultado(), 0.01);
    }
     
    @Test
     public void calcularTaxaPesoAcimaLimiteTeste() {
        peso = 6;
        double taxa = calcularTaxaPeso(peso);
        double esperado = 0.02;
        Assert.assertEquals(esperado, taxa, 0.01);
    }
    
     @Test
     public void calcularTaxaPesoAbaixoLimiteTeste() {
        peso = 5;
        double taxa = calcularTaxaPeso(peso);
        double esperado = 0.00;
        Assert.assertEquals(esperado, taxa, 0.01);
    }
}
