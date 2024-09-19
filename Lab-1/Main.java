public class Main{

	public static void main(String args[]){

		Artist a1 = new Artist("Hafiz Ammar");

		Artwork art1 = new Artwork("Urdu", 2015, "Malik Aalam");
		Artwork art2 = new Artwork("Urdu", 2015);

		a1.display1();

		art1.display();
		art2.display();
	}

}
