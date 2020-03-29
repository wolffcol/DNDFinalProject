package dungeon;

public abstract class EquipmentDecorator extends Equipment{
	
	protected Equipment wrappedEquipment;
	
	public EquipmentDecorator(Equipment wrappedEquipment) {
		this.wrappedEquipment = wrappedEquipment;
	}

}
