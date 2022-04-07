import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		DB db = new DB();
		Swing s = new Swing(db);
		db.InsertCar("joao", "UMA MARCA", "Celta");
		db.InsertCar("bruno", "UMA MARCA up", "UP");
		db.InsertDono("joao");
		db.InsertDono("bruno");
		db.InsertAbastecimento(2.5, 10, 2.5 * 10, "bruno", "UP");
		db.InsertAbastecimento(3.1, 10, 3.1 * 10, "bruno", "UP");
		db.InsertDespesa("Revisao", 250, "", "bruno", "UP");
		db.InsertDespesa("Rodas novas", 120, "", "bruno", "UP");
		db.InsertReceita("Uber", 35, "", "bruno", "UP");
		db.InsertReceita("Carona", 10, "", "bruno", "UP");
		db.SearchAllAbastecimentos("bruno", "UP");
		
		Veiculo car = db.SearchCar("bruno", "UP");
		System.out.println(car.getAllAbastecimentos());

		s.LoginPage();
	}
}

	
