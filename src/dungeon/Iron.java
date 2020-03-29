package dungeon;

public class Iron extends EquipmentDecorator{

	
	
	public Iron(Equipment wrappedEquipment) {
		super(wrappedEquipment);
	}

	@Override
	public String getDescription() {
		return "Iron " + wrappedEquipment.getDescription();
		
	}

}
