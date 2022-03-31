public abstract class Veiculo {
    private String marca;
    private String modelo;
    private double quilometragem;
    private String donoVeiculo;
    private double abastecimento;
    private double servicos;
    private double despesas;
    private double receita;

    public Veiculo (String donoVeiculo, String marca , String modelo){
        this.donoVeiculo = donoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
    }


    static boolean excluirVeiculo(){
        
        return true;
    }

    static boolean alterarVeiculo(){
        
        return true;
    }

    static String cadastroDono(){
        
        return "Oi";
    }
    
    String getName(){
        return this.donoVeiculo;
    }
    
    String getModel(){
        return this.modelo;
    }
        
}
