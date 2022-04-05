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
    
    List<String> getAllAbastecimentos(){
        ArrayList<String> listAbastecimentos = new ArrayList<String>();
        for (int i = 0; i <= contAbastecimentos; i++) {
			listAbastecimentos.add(this.abastecimentos[i].getInfo());
		}
		return listAbastecimentos;
    }
    
    boolean addDespesa(Despesa despesa){
        contDespesa++;
        this.despesas[contDespesa] = despesa;
        return true;
    }
    
    List<String> getAllDespesas(){
        ArrayList<String> listDespesas = new ArrayList<String>();
        for (int i = 0; i <= contDespesa; i++) {
            listDespesas.add(this.despesas[i].getInfo());
        }
        return listDespesas;
    }
    
    boolean addReceita(Receita receita){
        contReceita++;
        this.receitas[contReceita] = receita;
        return true;
    } 
    
    List<String> getAllReceitas(){
        ArrayList<String> listReceitas = new ArrayList<String>();
        for (int i = 0; i <= contReceita; i++) {
            listReceitas.add(this.despesas[i].getInfo());
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
