import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		DB db = new DB();
		Swing s = new Swing(db);
		db.InsertCar("joao", "UMA MARCA", "Celta");
		db.InsertCar("joao", "UMA MARCA bruno", "UP");
		db.InsertDono("joao");
		db.InsertDono("bruno");
		ArrayList<String> cars = db.GetAllCarsByOwner("joao");
		System.out.println(cars);

		s.LoginPage();
	}
}

	
