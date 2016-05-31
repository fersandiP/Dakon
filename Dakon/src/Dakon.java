import java.util.ArrayList;
import java.util.Random;

public class Dakon{
	private int size;
	private int player;
	private State state;
	private Random random;

	public Dakon(){
		random = new Random();
	}

	public void init(int hole, int stone){
		if(hole <= 0 || stone <= 0)
			throw new RuntimeException("Invalid parameter");

		player = 0;
		size = hole;
		state = new State(hole, stone);
	}

	public int getCurrentPlayer(){
		return player + 1;
	}

	private void check(){
		if(state == null)
			throw new RuntimeException("Object not initialized");
		if(state.isEndGame())
			throw new RuntimeException("Game ended");
	}

	public State move(int position){
		check();

		state.startMove(position);

		State res = state.clone();

		while (state.move() >= 0) {}
		player = -state.move() - 1;

		if(!canMove(player))
			player ^= 1;

		return res;
	}

	private boolean canMove(int player){
		if(player == 0){
			for(int i = 0 ; i < size ; i ++)
				if(state.getHole(i) != 0)
					return true;
		}else{
			for(int i = 0 ; i < size ; i ++)
				if(state.getHole(size + 1 + i) != 0)
					return true;
		}
		return false;
	}

	public State move(){
		check();

		if(player == 0){
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i = 0 ; i < size ; i ++)
				if(state.getHole(i) != 0)
					arr.add(i);
			return move(arr.get(random.nextInt(arr.size())));
		}else{
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i = 0 ; i < size ; i ++)
				if(state.getHole(size + 1 + i) != 0)
					arr.add(size + 1 + i);
			return move(arr.get(random.nextInt(arr.size())));
		}
	}

	public int getSize(){
		return size;
	}

	public State getState(){
		return state;
	}
}