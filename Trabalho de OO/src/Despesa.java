public class Despesa {
    private String precoLitro;
    private	double valor;
    private String observacao;

    public Despesa(String precoLitro, double valor, String observacao){
        this.criar(precoLitro, valor, observacao);
    }

    boolean criar(String precoLitro, double valor, String observacao){
        this.precoLitro = precoLitro;
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
