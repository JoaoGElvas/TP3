import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		DB db = new DB();
		Swing s = new Swing(db);
		db.InsertCar("joao", "Uno Way", "Uno Way");
		db.InsertCar("joao", "Up TSI", "Up TSI");
		db.InsertDono("joao");
		db.InsertDono("bruno");
		ArrayList<String> cars = db.GetAllCarsByOwner("joao");
		System.out.println(cars);

		s.LoginPage();
	}
}

	
