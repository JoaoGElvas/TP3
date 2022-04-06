    public class Abastecimentos {
	private double precoLitro;
	private	double valor;
	private double litros;
	
	public Abastecimentos (double precoLitro, double valor, double litros) {
		this.cadastroAbastecimento(precoLitro, valor, litros);
	}

	boolean cadastroAbastecimento(double precoLitro, double valor, double litros){
		this.precoLitro = precoLitro;
        this.valor = valor;
        this.litros = litros;
		return true;
    }
    
    String getInfo(){
		return "Litros: " + this.litros + " Preco do litro: " + this.precoLitro;
    }

	static boolean excluirAbastecimento(){
        
        return true;
    }

	static boolean alterarAbastecimento(){
        
        return true;
    }
}
