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

    static String editar(){

        return "oi";
    }
    
    void nome(){
        System.out.println(this.nome);
    }

    static boolean excluir(){

        return false;
    }
}