/**
 * Classe Receita
*/

public class Receita {
	private String tipoReceita;
	private	double valor;
	private String observacao;
	
	public Receita (String tipoReceita, double valorReceita, String observacaoReceita) {
		this.criar(tipoReceita, valorReceita, observacaoReceita);
	}
	
	
    /**
     * Registra os valores da receita 
     * @param tipoReceita tipo da receita
     * @param valor valor da receita
     * @param observacao alguma observacao
     * @return true 
    */
	boolean criar(String tipoReceita, double valor, String observacao){
		this.tipoReceita = tipoReceita;
        this.valor = valor;
        this.observacao = observacao;
		return true;
    }

	static String editar(){
        
        return "Editar";
    }

	String getInfo(){
		return "Tipo: " + this.tipoReceita + " valor: " + this.valor;
	}
	
	double getValor(){
        return this.valor;
    }

}
