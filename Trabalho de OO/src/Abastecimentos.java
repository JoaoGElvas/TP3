
/**
 * Classe que instancia o abastecimento
*/

public class Abastecimentos {
	private double precoLitro;
	private	double valor;
	private double litros;
	
	public Abastecimentos (double precoLitro, double valor, double litros) {
		this.cadastroAbastecimento(precoLitro, valor, litros);
	}
	
	/**
     * Registra os valores dos abastecimentos
     * @param precoLitro preco do litro
     * @param valor valor total do abastecimento
     * @param litros quantidade de litros
    */
	
	boolean cadastroAbastecimento(double precoLitro, double valor, double litros){
		this.precoLitro = precoLitro;
        this.valor = valor;
        this.litros = litros;
		return true;
    }

	
    String getInfo(){
		return "Litros: " + this.litros + " Preco do litro: " + this.precoLitro;
    }
    
    double getValor(){
        return this.valor;
    }
}
