import java.util.List;

import controller.OwnerHelper;
import model.Pets;

public class testmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OwnerHelper oh = new OwnerHelper();
		List<Pets> list = oh.getPetsByOwnerId(1);
		for(Pets x: list) {
			System.out.println(x.getPetName());
		}
	}

}
