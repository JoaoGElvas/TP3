/**
 * Classe que instancia a despesa
*/

public class Despesa {
    private String tipoDespesa;
    private	double valor;
    private String observacao;

    public Despesa(String tipoDespesa, double valorDespesa, String observacaoDespesa){
        this.criar(tipoDespesa, valorDespesa, observacaoDespesa);
    }
    
    /**
     * Registra os valores da despesa 
     * @param tipoDespesa qual o tipo de despesa
     * @param valor valor total da despesa
     * @param observacao alguma observacao
    */

    boolean criar(String tipoDespesa, double valor, String observacao){
        this.tipoDespesa = tipoDespesa;
        this.valor = valor;
        this.observacao = observacao;
		return true;
    }
    
    String getInfo(){
        return "Tipo de despesa: " + this.tipoDespesa + " Valor: " + this.valor;
    }
    
    double getValor(){
        return this.valor;
    }
    
}