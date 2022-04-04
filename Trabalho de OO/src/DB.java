import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DB {
    private static Dono[] donos = new Dono[50];
    int contadorDonos = -1;
    int contadorCarros = -1;
    public Carro[] veiculos = new Carro[50];
    private Receita[] receitas = new Receita[50];
    private Despesa[] despesas = new Despesa[50];
    private Relatorio[] relatorios = new Relatorio[50];
    
    public void InsertDono(String nome){
        contadorDonos++;
        donos[contadorDonos] = new Dono(nome);
    }
    
    

    public void InsertAbastecimento (double precoLitro, double litros, double valor , String owner, String carToAdd ) {
        for (int i = 0; i < contadorCarros; i++) {
  			if(owner.equals(veiculos[contadorCarros].getName()) && carToAdd.equals(veiculos[contadorCarros].getModel())){
                Veiculo veiculo = SearchCar(owner, carToAdd);
                veiculo.addAbastecimento(new Abastecimentos(precoLitro,litros,valor));
  			}
  		} 
    }
    
    public void SearchAllAbastecimentos(String owner, String carToAdd ) {
        for (int i = 0; i < contadorCarros; i++) {
            if(owner.equals(veiculos[contadorCarros].getName()) && carToAdd.equals(veiculos[contadorCarros].getModel())){
               veiculos[contadorCarros].showAllAbastecimentos();            
            }
        } 
    }
    
    


    public boolean SearchDono(String nome){
        if(contadorDonos < 0){
            System.out.println("Não há registros ainda");
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


    public Veiculo SearchCar(String owner , String carToFindModel) {
        Veiculo carToReturn = veiculos[0];
        for (int i = 0; i < contadorCarros; i++) {
			if(owner.equals(veiculos[contadorCarros].getName()) && carToFindModel.equals(veiculos[contadorCarros].getModel())){
                carToReturn = veiculos[contadorCarros];
                return carToReturn;
			}
		}
		return carToReturn;
	}
    
}