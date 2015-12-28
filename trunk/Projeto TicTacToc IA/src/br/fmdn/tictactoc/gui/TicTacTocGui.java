
package br.fmdn.tictactoc.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.fmdn.tictactoc.game.TicTacToc;

public class TicTacTocGui extends JDialog {

	private static final long serialVersionUID = 1L;
	private TicTacToc jogo;
	
	private ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButtonVelha button = (JButtonVelha) e.getSource();

			TicTacTocGui.this.buttonOnClick(button);
		}

	};
	private void buttonOnClick(JButtonVelha button) {
		
		this.jogo.jogar(button.getPosX(), button.getPosY());
		String jogador = this.jogo.getValue(button.getPosX(), button.getPosY());
		button.setText(jogador);
		if (this.jogo.verificarJogo()) {
			JOptionPane.showMessageDialog(this,"\""+ jogador + " \" Ganhou essa partida!");
			int op = JOptionPane.showConfirmDialog(this, "Deseja Jogar novamente ?","TicTacToc", JOptionPane.YES_NO_OPTION);
			if(op == JOptionPane.YES_OPTION){
				this.jogo = new TicTacToc();
				for (int i = 0; i < this.buttons.length; i++) {
					for (int j = 0; j < this.buttons[i].length; j++) {
						this.buttons[i][j].setText(" ");
					}
				}
			}else{
				this.dispose();
			}
		}
	}
	private JButtonVelha[][] buttons;
	
	public TicTacTocGui() {
		this.jogo = new TicTacToc();
		this.buttons= new JButtonVelha[3][3];
		this.initComponents();
	}

	private void initComponents() {

		this.setTitle("Jogo da Velhar");
		this.setSize(200, 200);
		JPanel panel = new JPanel(new GridLayout(3, 3));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(panel);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButtonVelha button = new JButtonVelha(i, j);
				button.addActionListener(this.actionListener);
				panel.add(button);
				this.buttons[i][j] = button;
			}
		}
	}

	class JButtonVelha extends JButton {

		private static final long serialVersionUID = 1L;
		private int posX;
		private int posY;

		public JButtonVelha(int posX, int posY) {

			this.posX = posX;
			this.posY = posY;
			this.setText(" ");
		}

		public int getPosX() {

			return this.posX;
		}

		public void setPosX(int posX) {

			this.posX = posX;
		}

		public int getPosY() {

			return this.posY;
		}

		public void setPosY(int posY) {

			this.posY = posY;
		}
	}
}
