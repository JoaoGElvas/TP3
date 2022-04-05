public abstract class Veiculo {
    private String marca;
    private String modelo;
    private double quilometragem;
    private String donoVeiculo;
    public Abastecimentos[] abastecimentos = new Abastecimentos[20];
    private int contAbastecimentos = -1;
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

    boolean addAbastecimento(Abastecimentos abastecimento){
        contAbastecimentos++;
        this.abastecimentos[contAbastecimentos] = abastecimento;
        return true;
    }
    
    void showAllAbastecimentos(){
        for (int i = 0; i <= contAbastecimentos; i++) {
			this.abastecimentos[contAbastecimentos].getInfo();
		}
    }

    
    String getName(){
        return this.donoVeiculo;
    }
    
    String getModel(){
        return this.modelo;
    }
    
    String getMarca(){
        return this.marca;
    }
        
}
