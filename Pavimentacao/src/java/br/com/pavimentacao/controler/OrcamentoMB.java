package br.com.pavimentacao.controler;

import br.com.pavimentacao.modelo.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class OrcamentoMB {

    private List<Veiculo> veiculos;
    private int peso;
    private double distanciaPavimentada;
    private double distanciaNPavimentada;
    private static final double DISTANCIA_PAVIMENTADA_TAXA = 0.54;
    private static final double DISTANCIA_NAO_PAVIMENTADA_TAXA = 0.62;
    private static final int TONELADA_SEM_TAXA = 5;
    private double resultado;
    private double taxaVeiculo;
    
    public OrcamentoMB() {
        veiculos = new ArrayList<>();
        popularLista();
    }

    private void popularLista(){
        veiculos.add(new Veiculo("Caminhão Baú", 1.00));
        veiculos.add(new Veiculo("Caminhão Caçamba", 1.05));
        veiculos.add(new Veiculo("Carreta", 1.12));
    }
    
    public void calcularOrcamento(){
        double pesoTotal = calcularTaxaPeso(peso);
        double pavimentado = 0;
        double naoPavimentado = 0;

        if( distanciaPavimentada > 0){
            pavimentado = ((distanciaPavimentada * DISTANCIA_PAVIMENTADA_TAXA) * taxaVeiculo) +  (distanciaPavimentada * pesoTotal);
        }
        if(distanciaNPavimentada >0){
            naoPavimentado = ((distanciaNPavimentada * DISTANCIA_NAO_PAVIMENTADA_TAXA) * taxaVeiculo) +  (distanciaNPavimentada * pesoTotal);
        }
        
        resultado = pavimentado + naoPavimentado;
        
    }
    
    public void limpar(){
        distanciaNPavimentada = 0.0;
        distanciaPavimentada = 0.0;
        peso = 0;
        resultado = 0.0;
    }
    private double calcularTaxaPeso(int peso){
        if(peso > 5){
            return (peso - TONELADA_SEM_TAXA) * 0.02;
        }else{
            return 0.0;
        }
        
    }
    
    
    // *************** getters e setters *************
    
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getTaxaVeiculo() {
        return taxaVeiculo;
    }

    public void setTaxaVeiculo(double taxaVeiculo) {
        this.taxaVeiculo = taxaVeiculo;
    }

    public double getDistanciaPavimentada() {
        return distanciaPavimentada;
    }

    public void setDistanciaPavimentada(double distanciaPavimentada) {
        this.distanciaPavimentada = distanciaPavimentada;
    }

    public double getDistanciaNPavimentada() {
        return distanciaNPavimentada;
    }

    public void setDistanciaNPavimentada(double distanciaNPavimentada) {
        this.distanciaNPavimentada = distanciaNPavimentada;
    }
    
}
