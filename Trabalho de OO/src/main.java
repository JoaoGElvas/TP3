import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		DB db = new DB();
		Swing s = new Swing(db);
		db.InsertCar("joao", "UMA MARCA", "Celta");
		db.InsertCar("bruno", "UMA MARCA up", "UP");
		db.InsertDono("joao");
		db.InsertDono("bruno");
		db.InsertAbastecimento(2.5, 10, 5.3, "bruno", "UP");
		db.SearchAllAbastecimentos("bruno", "UP");

		s.LoginPage();
	}
}

	
