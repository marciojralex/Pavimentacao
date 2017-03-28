package br.com.pavimentacao.modelo;

public class Veiculo {
    
    private String veiculo = "";
    private double taxa = 0.0;

    public Veiculo() {
    }

    public Veiculo(String veiculo, double taxa) {
        this.veiculo = veiculo;
        this.taxa = taxa;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
    
    
}
