public class Despesa {
    private String tipoDespesa;
    private	double valor;
    private String observacao;

    public Despesa(String tipoDespesa, double valorDespesa, String observacaoDespesa){
        this.criar(tipoDespesa, valorDespesa, observacaoDespesa);
    }

    boolean criar(String tipoDespesa, double valor, String observacao){
        this.tipoDespesa = tipoDespesa;
        this.valor = valor;
        this.observacao = observacao;
		return true;
    }

	static String editar(){
        
        return "Editar";
    }
    
    String getInfo(){
        return "Tipo de despesa: " + this.tipoDespesa + " Valor: " + this.valor;
    }
    
	static boolean excluir(){
        
        return true;
    }
}
