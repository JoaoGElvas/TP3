import java.util.ArrayList;
import java.util.Arrays;

public class DB {
    private static Dono[] donos = new Dono[50];
    int contadorDonos = -1;
    int contadorCarros = -1;
    private Carro[] veiculos = new Carro[50];
    private Receita[] receitas = new Receita[50];
    private Despesa[] despesas = new Despesa[50];
    private Relatorio[] relatorios = new Relatorio[50];
    private Abastecimentos[] abastecimentos = new Abastecimentos[50];
    
    public void InsertDono(String nome){
        if(contadorDonos < 0) contadorDonos++;
        
        donos[contadorDonos] = new Dono(nome);
        donos[contadorDonos].nome();
        contadorDonos++;
    }

    public boolean SearchDono(String nome){
        if(contadorDonos < 0){
            System.out.println("Nao ha registros ainda");
            return false;
        }
    	for(int cont = 0; cont <= contadorDonos; cont++) {
    		if(nome.equals(donos[cont].nome())) {
                System.out.println("Achei");
    			return true;
    		}
    	}
    	System.out.println("Nao achei");
    	return false;
    }

    public void InsertCar(String donoVeiculo, String marca , String modelo){
        contadorCarros++;
        veiculos[contadorCarros] = new Carro(donoVeiculo ,marca , modelo);
        System.out.println("qntd carros: " + contadorCarros);
    }

    public ArrayList<String> GetAllCarsByOwner(String name){
        if (contadorCarros < 0) {
			System.out.println("Nao ha carros ainda");
		}
        ArrayList<String> carsOfOwnerList = new ArrayList<String>();
        for(int i = 0; i <= contadorCarros; i++){
            System.out.println(veiculos[contadorCarros].getName());
            if(name.equals(veiculos[contadorCarros].getName())){
               carsOfOwnerList.add(veiculos[contadorCarros].getModel());
            }
        }

        return carsOfOwnerList;
    }
    
}