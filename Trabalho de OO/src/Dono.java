public class Dono {
    private String nome;
    private int qtdVeiculo;


    public Dono(String nome){
        this.criar(nome);
    }

    boolean criar(String nome){
        this.nome = nome;
        return true;
    }

    String editar(String novoNome){
    	this.nome = novoNome;
        return novoNome;
    }
    
    String nome(){
        return this.nome;
    }

    static boolean excluir(){

        return false;
    }
}