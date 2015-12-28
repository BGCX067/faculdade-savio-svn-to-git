
package br.fmdn.tictactoc.game;


public class TicTacToc {

	private char[][] tabuleiro;
	private int turno;

	public TicTacToc() {

		this.tabuleiro = new char[][] { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, };
		this.turno = 0;
	}

	public char[][] getTabuleiro() {

		return this.tabuleiro;
	}

	public void jogar(int linha, int coluna) {

		boolean validar = (linha >= 0) && (linha <= 2);
		validar &= (coluna >= 0) && (coluna <= 2);
		if (validar) {
			if (this.tabuleiro[linha][coluna] == ' ') {
				this.tabuleiro[linha][coluna] = (this.turno % 2) == 0
						? 'O'
						: 'X';
				this.turno++;
			} else {
				throw new IllegalArgumentException("Posição ja preenchida");
			}
		} else {
			throw new IllegalArgumentException("Parametros inválidos");
		}
	}

	public boolean verificarJogo() {

		return this.verificarLinhas() || this.verificarColunas() || this.verificarVerticais();
	}

	private boolean verificarLinhas() {

		for (int x = 0; x < this.tabuleiro.length; x++) {
			char valor = this.tabuleiro[x][0];
			if (valor == ' ') {
				continue;
			}
			int y = 1;
			for (; y < this.tabuleiro[x].length; y++) {
				if (this.tabuleiro[x][y] == valor) {
					continue;
				} else {
					break;
				}
			}
			if (y == 3) {
				return true;
			}
		}
		return false;
	}

	private boolean verificarColunas() {
		for (int x = 0; x < this.tabuleiro.length; x++) {
			char valor = this.tabuleiro[0][x];
			if (valor == ' ') {
				continue;
			}
			int y = 1;
			for (; y < this.tabuleiro[0].length; y++) {
				if (this.tabuleiro[y][x] == valor) {
					continue;
				} else {
					break;
				}
			}
			if (y == 3) {
				return true;
			}
		}
		return false;
	}

	private boolean verificarVerticais() {
		boolean verificar = (this.tabuleiro[0][0] != ' ') && (this.tabuleiro[0][0] == this.tabuleiro[1][1]) && (this.tabuleiro[0][0] == this.tabuleiro[2][2]);
		verificar |= (this.tabuleiro[0][2] != ' ') && (this.tabuleiro[0][2] == this.tabuleiro[1][1]) && (this.tabuleiro[0][2] == this.tabuleiro[2][0]);
		return verificar;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < this.tabuleiro.length; i++) {
			for (int j = 0; j < this.tabuleiro[i].length; j++) {
				buffer.append("[ " + this.tabuleiro[i][j]+ " ] ");
			}
			buffer.append("\n");
		}
		return buffer.toString();
	}
	
	public String getValue(int x, int y){
		return this.tabuleiro[x][y]+"";
	}
}
