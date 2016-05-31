public class State implements Cloneable{
	private int[] state;
	private int inHand;
	private int position;
	private int size;
	private int currentPlayer;

	public State(){

	}

	public State(int hole, int stone){
		size = hole;
		state = new int[hole * 2 + 2];
		for(int i = 0 ; i < hole ; i ++){
			state[i] = state[i + hole + 1] = stone;
		}
	}

	private int isEndHole(int pos){
		return (pos == size) ?  0 : (pos == size * 2 + 1) ? 1 : -1;
	}

	private int getHoleOwner(int pos){
		return pos / (size + 1);
	}

	private void movePosition(){
		position ++;
		if(position >= state.length)
			position = 0;
	}

	private boolean inBound(int pos){
		return pos >= 0 && pos <= (pos * 2 + 1);
	}

	private int getEndHole(int player){
		if(player == 0)return size;
		return 2*size + 1;
	}

	private int getOpposite(int pos){
		if(pos < size){
			int delta = size - pos;
			return size + delta;
		}else{
			int delta = pos - size;
			return size - delta;
		}
	}

	public void startMove(int pos){
		if(!inBound(pos) || isEndHole(pos) >= 0 || state[pos] <= 0)
			throw new RuntimeException("Invalid hole");

		currentPlayer = getHoleOwner(pos);
		inHand = state[pos];
		state[pos] = 0;
		position = pos;
	}

	public int move(){
		if(inHand == 0){
			if(isEndHole(position) >= 0)
				return -(currentPlayer + 1);
			return -((currentPlayer ^ 1) + 1);
		}

		movePosition();
		
		if(isEndHole(position) == (currentPlayer ^ 1))
			movePosition();

		if(inHand == 1){
			if(isEndHole(position) == currentPlayer){
				inHand --;
				state[position] ++;
			}else if(state[position] > 0){
				inHand += state[position];
				state[position] = 0;
			}else{
				if(getHoleOwner(position) == currentPlayer){
					state[getEndHole(currentPlayer)] += state[getOpposite(position)];
					state[getOpposite(position)] = 0;
				}
				state[position] ++;
				inHand --;
			}
		}else{
			state[position] ++;
			inHand --;
		}

		return currentPlayer + 1;
	}

	public State clone(){
		State res = new State();
		res.setState(state.clone());
		res.setInHand(inHand);
		res.setPosition(position);
		res.setSize(size);
		res.setCurrentPlayer(currentPlayer);
		return res;
	}

	public void setState(int[] state){
		this.state  = state;
	}

	public void setInHand(int inHand){
		this.inHand = inHand;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public void setSize(int size){
		this.size = size;
	}

	public void setCurrentPlayer(int currentPlayer){
		this.currentPlayer = currentPlayer;
	}

	public int getHole(int idx){
		return state[idx];
	}

	public int getInHand(){
		return inHand;
	}

	public int getPosition(){
		return position;
	}

	public int getSize(){
		return size;
	}

	public boolean isEndGame(){
		for(int i = 0 ; i < size ; i ++)
			if(state[i] > 0)
				return false;

		for(int i = 0 ; i < size ; i ++)
			if(state[size + 1 + i] > 0)
				return false;

		return true;
	}
}
