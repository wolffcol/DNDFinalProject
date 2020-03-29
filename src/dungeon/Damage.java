package dungeon;

public class Damage extends EquipmentDecorator {

	public Damage(Equipment wrappedEquipment) {
		super(wrappedEquipment);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return wrappedEquipment.getDescription() + " of Damage";
	}

}
