
package br.fmdn.tictactoc;

import java.util.TreeSet;

import br.fmdn.tictactoc.game.TicTacToc;

public class TicTacTocIA {

	private TreeSet<TicTacToc> estados;

	public TicTacTocIA(TicTacToc jogo) {

		this.estados = new TreeSet<TicTacToc>();
		this.estados.add(jogo);
	}

	public void Formular() {

	}

	public void defender() {

	}

	public void atacar() {

	}

	public boolean perigo() {

		return true;
	}
}
