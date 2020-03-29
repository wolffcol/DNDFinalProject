package dungeon;

public class Originator {
	
	private State state;
	
	public void setState(){
		state = new State(GameStateManager.getHero(), GameStateManager.getDungeon(), GameStateManager.getCurrentRoom());
	}
	
	public State getState() {
		return state;
	}
	
	public Memento saveStateToMemento() {
		return new Memento(state);
	}
	
	public void getStateFromMemento(Memento memento) {
		state = memento.getState();
	}

}
