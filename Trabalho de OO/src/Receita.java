public class Receita {
	private String tipoReceita;
	private	double valor;
	private String observacao;
	
	public Receita (String tipoReceita, double valorReceita, String observacaoReceita) {
		this.criar(tipoReceita, valorReceita, observacaoReceita);
	}

	boolean criar(String tipoReceita, double valor, String observacao){
		this.tipoReceita = tipoReceita;
        this.valor = valor;
        this.observacao = observacao;
		return true;
    }

	static String editar(){
        
        return "Editar";
    }

	static boolean excluir(){
        
        return true;
    }
}
