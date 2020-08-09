
public class ProjectTest {
	public static void main(String[] args) {
		Project defpj = new Project();
		System.out.println(defpj.getName());
		
		Project pj = new Project("Stonks");
		System.out.println(pj.getName());
	}
}
