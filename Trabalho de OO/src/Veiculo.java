import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private double quilometragem;
    private String donoVeiculo;
    public Abastecimentos[] abastecimentos = new Abastecimentos[20];
    private int contAbastecimentos = -1;
    private int contDespesa = -1;
    private int contReceita = -1;
    private double servicos;
    public Despesa[] despesas = new Despesa[20];
    public Receita[] receitas = new Receita[20];
    
    /**
     * Adiciona um veiculo
     * @param donoVeiculo é o dono do veiculo 
     * @param marca é a marca do veiculo
     * @param modelo é o modelo do veiculo 
    */

    public Veiculo (String donoVeiculo, String marca , String modelo){
        this.donoVeiculo = donoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
    }

    static String cadastroDono(){
        
        return "Oi";
    }
    
    /**
     * Adiciona abastecimentos no veiculo
     * @param abastecimento é o abastecimento adicionado no veiculo 
     * @return true
    */

    boolean addAbastecimento(Abastecimentos abastecimento){
        contAbastecimentos++;
        this.abastecimentos[contAbastecimentos] = abastecimento;
        return true;
    }
    
    /**
     * Pega todos os abastecimentos feitos do veiculo
     * @return listAbastecimentos
    */
    
    List<String> getAllAbastecimentos(){
        ArrayList<String> listAbastecimentos = new ArrayList<String>();
        for (int i = 0; i <= contAbastecimentos; i++) {
			listAbastecimentos.add(this.abastecimentos[i].getInfo());
		}
		return listAbastecimentos;
    }
    
    /**
     * Adiciona despesas no veiculo
     * @param despesa é a despesa adicionada no veiculo 
     * @return true
    */
    
    boolean addDespesa(Despesa despesa){
        contDespesa++;
        this.despesas[contDespesa] = despesa;
        return true;
    }
    
    /**
     * Pega todos as despesas feitas do veiculo
     * @return listDespesas
    */
    
    List<String> getAllDespesas(){
        ArrayList<String> listDespesas = new ArrayList<String>();
        for (int i = 0; i <= contDespesa; i++) {
            listDespesas.add(this.despesas[i].getInfo());
        }
        return listDespesas;
    }
    
    /**
     * Adiciona receita no veiculo
     * @param receita é a receita adicionada no veiculo 
     * @return true
    */
    
    boolean addReceita(Receita receita){
        contReceita++;
        this.receitas[contReceita] = receita;
        return true;
    } 
    
    /**
     * Pega todos as receitas feitas do veiculo
     * @return listReceitas
    */
    
    List<String> getAllReceitas(){
        ArrayList<String> listReceitas = new ArrayList<String>();
        for (int i = 0; i <= contReceita; i++) {
            listReceitas.add(this.receitas[i].getInfo());
        }
        return listReceitas;
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
