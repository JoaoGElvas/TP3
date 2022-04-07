import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Classe que instancia o banco de dados
*/

public class DB {
    private static Dono[] donos = new Dono[50];
    int contadorDonos = -1;
    int contadorCarros = -1;
    public Carro[] veiculos = new Carro[50];
    private Receita[] receitas = new Receita[50];
    private Despesa[] despesas = new Despesa[50];
    private Relatorio[] relatorios = new Relatorio[50];

     /** M�todo para inserir um dono no DB
     * @return void*/
    
    public void InsertDono(String nome){
        contadorDonos++;
        donos[contadorDonos] = new Dono(nome);
    }
    
	// Abastecimento


    /**
     * Insert Abastecimento
     *@param precoLitro � o preco do litro registrado
     *@param litros � a quantidade de litros
     *@param valor � o valor feito a partir da multiplicacao preco*litro
     *@param owner dono o qual deve procurar
     *@param caToAdd � o carro especifico para inserir a despesa
     *@return void
     */

    public void InsertAbastecimento (double precoLitro, double litros, double valor , String owner, String carToAdd ) {
        for (int i = 0; i <= contadorCarros; i++) {
  			if(owner.equals(veiculos[i].getName()) && carToAdd.equals(veiculos[i].getModel())){
                Veiculo veiculo = SearchCar(owner, carToAdd);
                veiculo.addAbastecimento(new Abastecimentos(precoLitro,valor,litros));
  			}
  		} 
    }

    /** M�todo para procurar todos os abastecimentos de um carro especifico no DB
    * @param owner dono o qual devo procurar
    * @param carToAdd carro especifico para pegar os abastecimentos
    * @return Abastecimentos[] todos os abastecimentos de um veiculo*/
    
    public Abastecimentos[] SearchAllAbastecimentos(String owner, String carToAdd ) {
        int posToReturn = 0;
        for (int i = 0; i <= contadorCarros; i++) {
            if(owner.equals(veiculos[i].getName()) && carToAdd.equals(veiculos[i].getModel())){
               posToReturn = contadorCarros;         
            }
        }
        return veiculos[posToReturn].abastecimentos;   
    }
    
    //Despesa
    
    /** M�todo para inserir uma despesa no DB
     *@param tipoDespesa � o tipo de despesa 
     *@param valorDespesa � o valor da despesa 
     *@param observacaoDespesa � a sting de observa��o da despesa
     * @param owner dono o qual deve procurar
     * @param carToAdd � o carro especifico para inserir a despesa
     * @return void*/
    
    public void InsertDespesa (String tipoDespesa , double valorDespesa, String observacaoDespesa, String owner, String carToAdd ) {
        for (int i = 0; i <= contadorCarros; i++) {
  			if(owner.equals(veiculos[i].getName()) && carToAdd.equals(veiculos[i].getModel())){
                Veiculo veiculo = SearchCar(owner, carToAdd);
                veiculo.addDespesa(new Despesa(tipoDespesa,valorDespesa,observacaoDespesa));
  			}
  		} 
    }
    /** M�todo para procurar todas as despesas de um carro especifico no DB
     * @param owner dono o qual deve procurar
     * @param carToAdd � o carro especifico para pegar as despesas
     * @return Despesa[] todas as despesas do veiculo*/
     
    public Despesa[] SearchAllDespesas(String owner, String carToAdd ) {
        int posToReturn = 0;
        for (int i = 0; i < contadorCarros; i++) {
            if(owner.equals(veiculos[i].getName()) && carToAdd.equals(veiculos[i].getModel())){
               posToReturn = contadorCarros;         
            }
        }
        return veiculos[posToReturn].despesas;   
    } 
    
    //Receita
    
    /** M�todo para inserir uma receita no DB
     *@param tipoReceita � o tipo de receita 
     *@param valorReceita � o valor da receita 
     *@param observacaoReceita � a sting de observa��o da receita
     * @param owner dono o qual deve procurar
     * @param carToAdd � o carro especifico para inserir a despesa
     * @return void*/
    
    public void InsertReceita (String tipoReceita, double valorReceita, String observacaoReceita, String owner, String carToAdd ) {
        for (int i = 0; i <= contadorCarros; i++) {
  			if(owner.equals(veiculos[i].getName()) && carToAdd.equals(veiculos[i].getModel())){
                Veiculo veiculo = SearchCar(owner, carToAdd);
                veiculo.addReceita(new Receita(tipoReceita,valorReceita,observacaoReceita));
  			}
  		} 
    }
    
    /** M�todo para procurar todas as receitas de um carro especifico no DB
     * @param owner dono o qual deve procurar
     * @param carToAdd � o carro especifico para pegar as receitas
     * @return Receita[] todas as receitas do veiculo*/
    
    public Receita[] SearchAllReceitas(String owner, String carToAdd ) {
        int posToReturn = 0;
        for (int i = 0; i < contadorCarros; i++) {
            if(owner.equals(veiculos[i].getName()) && carToAdd.equals(veiculos[i].getModel())){
               posToReturn = contadorCarros;         
            }
        }
        return veiculos[posToReturn].receitas;   
    }
    
    
    
    //
    
    /** M�todo para procurar um dono especifico no DB
     * @param nome � o nome do dono o qual deve procurar
     * @return true quando existir um dono com esse nome
     * @return false quando n�o existir um dono com esse nome */
     
    public boolean SearchDono(String nome){
        if(contadorDonos < 0){
            System.out.println("Nao ha registros ainda");
            return false;
        }
    	for(int cont = 0; cont <= contadorDonos; cont++) {
    		if(nome.equals(donos[cont].nome())) {
    			return true;
    		}
    	}
    	System.out.println("Nao achei");
    	return false;
    }

    public void InsertCar(String donoVeiculo, String marca , String modelo){
        contadorCarros++;
        veiculos[contadorCarros] = new Carro(donoVeiculo ,marca , modelo);
    }
    
    /** M�todo para procurar todos os carros de uma pessoa no DB
     * @param name dono o qual deve procurar
     * @return ArrayList<String> todos os veiculos de uma pessoa no formato de string*/

    public ArrayList<String> GetAllCarsByOwner(String name){
        if (contadorCarros < 0) {
			System.out.println("Nao ha carros ainda");
		}
        ArrayList<String> carsOfOwnerList = new ArrayList<String>();
        for(int i = 0; i <= contadorCarros; i++){
            if(name.equals(veiculos[i].getName())){
               carsOfOwnerList.add(veiculos[i].getModel());
            }
        }


        return carsOfOwnerList;
    }

    /** M�todo para procurar todas as despesas de um carro especifico no DB
     * @param owner dono o qual deve procurar
     * @param carToFindModel � o carro especifico para buscar
     * @return Veiculo retorna um veiculo*/
       
    public Veiculo SearchCar(String owner , String carToFindModel) {
        Veiculo carToReturn = veiculos[0];
        for (int i = 0; i <= contadorCarros; i++) {
			if(owner.equals(veiculos[i].getName()) && carToFindModel.equals(veiculos[i].getModel())){
                carToReturn = veiculos[i];
                return carToReturn;
			}
		}
		return carToReturn;
	}
    
}