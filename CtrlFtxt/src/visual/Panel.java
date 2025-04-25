package visual;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Panel extends JPanel{
	
	JLabel prompt, resposta, nomeArquivo;
	JButton importar, pesquisar;
	JTextField palavra;

	public Panel() {
		this.setPreferredSize(new Dimension(600, 420));
		this.setLayout(null);
		this.add(getPrompt());
		this.add(getImportar());
		this.add(getPesquisar());
		this.add(getResposta());
		this.add(getNomeArquivo());
		this.add(getPalavra());
	}
	
	public JLabel getPrompt() {
		if(prompt == null) {
			prompt = new JLabel();
			prompt.setText("Importe um Arquivo em Txt e pesquise por palavras nele:");
			prompt.setFont(new Font("KiwiSoda", Font.PLAIN, 21));
			prompt.setBounds(50, 50, 500, 40);
		}
		return prompt;
	}
	
	public JButton getImportar() {
		if(importar == null) {
			importar = new JButton();
			importar.setText("Importar Arquivo");
			importar.setFont(new Font("KiwiSoda", Font.PLAIN, 21));
			importar.setBounds(50, 125, 190, 40);
		}
		return importar;
	}

	public JLabel getNomeArquivo() {
		if(nomeArquivo == null) {
			nomeArquivo = new JLabel();
			nomeArquivo.setFont(new Font("KiwiSoda", Font.PLAIN, 21));
			nomeArquivo.setBounds(260, 125, 290, 40);
		}
		return nomeArquivo;
	}

	public JButton getPesquisar() {
		if(pesquisar == null) {
			pesquisar = new JButton();
			pesquisar.setText("Procurar por Palavra");
			pesquisar.setFont(new Font("KiwiSoda", Font.PLAIN, 21));
			pesquisar.setBounds(310, 200, 240, 40);
		}
		return pesquisar;
	}
	
	public JTextField getPalavra() {
		if(palavra == null) {
			palavra = new JTextField();
			palavra.setFont(new Font("KiwiSoda", Font.PLAIN, 21));
			palavra.setBounds(50, 200, 240, 40);
		}
		return palavra;
	}

	public JLabel getResposta() {
		if(resposta == null) {
			resposta = new JLabel();
			resposta.setHorizontalAlignment(SwingConstants.CENTER);
			resposta.setFont(new Font("KiwiSoda", Font.PLAIN, 21));
			resposta.setText("<html>Palavra:<br><br>\r\nNúmero de Ocorrências:</html>");
			resposta.setBounds(125, 280, 350, 89);
		}
		return resposta;
	}
}
