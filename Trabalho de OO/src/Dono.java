/**
 * Classe Dono
*/

public class Dono {
    private String nome;
    private int qtdVeiculo;


    public Dono(String nome){
        this.criar(nome);
    }
    
    /**
     * Registra os valores da despesa 
     * @param nome nome do dono
     * @return true 
    */
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

}