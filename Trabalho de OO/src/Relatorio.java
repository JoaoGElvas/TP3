public class Relatorio {
    private	String tipoServico;
    private	double valor;
    private String observacao;

    public Relatorio(String tipoServico , double valor , String observacao){
        this.tipoServico = tipoServico;
        this.valor = valor;
        this.observacao = observacao;
    }

    public Relatorio(String tipoServico , double valor){
        this.tipoServico = tipoServico;
        this.valor = valor;
    }

    static String gerarRelatorio(){
        
        return "Relatorio";
    }
}
