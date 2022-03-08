public class Receita {
	private String tipoServico;
	private	double valor;
	private String observacao;
	
	public Receita (String tipoServico, double valor, String observacao) {
		this.criar(tipoServico, valor, observacao);
	}

	boolean criar(String tipoServico, double valor, String observacao){
		this.tipoServico = tipoServico;
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
