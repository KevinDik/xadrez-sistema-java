package boardGame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro criando tabuleiro, é necessário que tenha uma linha e uma coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		return pieces[row][column];
	}// retorna peca dada linha e coluna
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}//sobrecarga do metodo passando posicao
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("A posição selecionada já existe uma peça" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}//pega matriz na posicao dada e atribui a peca informada no metodo
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		return piece(position) != null;
	}
}
