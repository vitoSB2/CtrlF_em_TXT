package visual;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;

public class Panel extends JPanel{
	
	JLabel prompt, resposta, nomeArquivo;
	JButton importar, pesquisar;
	JTextField palavra;
	JScrollPane txtPane;
	JTextArea txt;

	public Panel() {
		setBackground(new Color(25, 25, 25));
		this.setPreferredSize(new Dimension(600, 640));
		this.setLayout(null);
		this.add(getPrompt());
		this.add(getImportar());
		this.add(getPesquisar());
		this.add(getResposta());
		this.add(getNomeArquivo());
		this.add(getPalavra());
		this.add(getTxtPane());
	}
	
	public JLabel getPrompt() {
		if(prompt == null) {
			prompt = new JLabel();
			prompt.setHorizontalAlignment(SwingConstants.CENTER);
			prompt.setForeground(new Color(255, 255, 255));
			prompt.setText("<html>Importe um Arquivo em Txt <br>e pesquise por palavras nele:</html>");
			prompt.setFont(new Font("GrapeSoda", Font.PLAIN, 28));
			prompt.setBounds(50, 20, 500, 73);
		}
		return prompt;
	}
	
	public JButton getImportar() {
		if(importar == null) {
			importar = new JButton();
			importar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			importar.setBorder(new LineBorder(new Color(82, 48, 48), 4, true));
			importar.setForeground(new Color(255, 255, 255));
			importar.setOpaque(false);
			importar.setBackground(new Color(82, 48, 48));
			importar.setText("Importar Arquivo");
			importar.setFont(new Font("GrapeSoda", Font.PLAIN, 25));
			importar.setBounds(50, 110, 208, 50);
			importar.setToolTipText("Clique para importar um arquivo em .txt");
			importar.setFocusable(false);
		}
		return importar;
	}

	public JLabel getNomeArquivo() {
		if(nomeArquivo == null) {
			nomeArquivo = new JLabel();
			nomeArquivo.setHorizontalAlignment(SwingConstants.CENTER);
			nomeArquivo.setForeground(new Color(239, 239, 239));
			nomeArquivo.setFont(new Font("GrapeSoda", Font.PLAIN, 24));
			nomeArquivo.setBounds(259, 110, 302, 50);
		}
		return nomeArquivo;
	}

	public JTextArea getTxt() {
		if(txt == null) {
			txt = new JTextArea();
			txt.setFont(new Font("GrapeSoda", Font.PLAIN, 20));
			txt.setLineWrap(true);
		    txt.setWrapStyleWord(true);
		    txt.setEditable(false);
	        txt.setBackground(new Color(25, 25, 25));
	        txt.setForeground(new Color(255, 255, 255)); 
		}
		return txt;
	}

	public JScrollPane getTxtPane() {
		if(txtPane == null) {
			txtPane = new JScrollPane();
			txtPane.setOpaque(false);
			txtPane.setBorder(null);
			txtPane.setBounds(50, 193, 500, 212);
			txtPane.setViewportView(getTxt());
		}
		return txtPane;
	}

	public JButton getPesquisar() {
		if(pesquisar == null) {
			pesquisar = new JButton();
			pesquisar.setForeground(new Color(255, 255, 255));
			pesquisar.setOpaque(false);
			pesquisar.setBorder(new LineBorder(new Color(65, 65, 65), 4, true));
			pesquisar.setFocusable(false);
			pesquisar.setBackground(new Color(230, 230, 230));
			pesquisar.setText("Procurar por Palavra");
			pesquisar.setFont(new Font("GrapeSoda", Font.PLAIN, 25));
			pesquisar.setBounds(293, 445, 257, 50);
			pesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return pesquisar;
	}
	
	public JTextField getPalavra() {
		if(palavra == null) {
			palavra = new JTextField();
			palavra.setForeground(new Color(255, 255, 255));
			palavra.setBackground(new Color(37, 37, 37));
			palavra.setAlignmentX(Component.LEFT_ALIGNMENT);
			palavra.setBorder(BorderFactory.createCompoundBorder(
				    new LineBorder(new Color(65, 65, 65)),
				    new EmptyBorder(0, 10, 0, 0)
				));
			palavra.setFont(new Font("GrapeSoda", Font.PLAIN, 21));
			palavra.setBounds(50, 450, 221, 40);
		}
		return palavra;
	}

	public JLabel getResposta() {
		if(resposta == null) {
			resposta = new JLabel();
			resposta.setForeground(new Color(255, 255, 255));
			resposta.setFont(new Font("GrapeSoda", Font.PLAIN, 28));
			resposta.setText("<html>Palavra:<br>\r\nNúmero de Ocorrências:</html>");
			resposta.setBounds(125, 529, 350, 65);
		}
		return resposta;
	}
}
