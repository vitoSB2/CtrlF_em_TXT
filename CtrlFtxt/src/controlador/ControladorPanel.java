package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import visual.Panel;
import visual.Frame;

public class ControladorPanel implements ActionListener{

	Frame frame;
	Panel panel;
	boolean arquivoImportado = false;
	int palavraCount = 0;
	File arquivo;
	BufferedReader leitor;
	
	public ControladorPanel(Panel panel, Frame frame) {
		this.frame = frame;
		this.panel = panel;
		frame.pack();
		frame.setLocationRelativeTo(null);
		addEventos();
	}

	private void addEventos() {
		panel.getPesquisar().addActionListener(this);
		panel.getImportar().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.getImportar()) {
			// CRIA UMA ABA PARA A SELEÇÃO DE ARQUIVO
			JFileChooser fileChooser = new JFileChooser();
	        int resultado = fileChooser.showOpenDialog(null);
	        
	        // SE O ARQUIVO FOR SELECIONADO
	        if (resultado == JFileChooser.APPROVE_OPTION) {
	        	// GUARDA O ARQUIVO
	            arquivo = fileChooser.getSelectedFile();
	            
	            // TESTA SE O ARQUIVO EXISTE
	            if(!arquivo.exists()) {
	            	panel.getNomeArquivo().setForeground(Color.red);
		            panel.getNomeArquivo().setText("Arquivo Inexistente!!");
		            
		        // TESTA SE O ARQUIVO ESTÁ EM TXT
	            } else if(!arquivo.getName().toLowerCase().endsWith(".txt")) {
	            	panel.getNomeArquivo().setForeground(Color.red);
	    	        panel.getNomeArquivo().setText("Arquivo Selecionado não está em TXT!");
	    	        
	    	    // CASO O ARQUIVO EXISTA E ESTEJA EM TXT
	            } else {
	            	arquivoImportado = true;
	            	panel.getNomeArquivo().setForeground(Color.blue);
	            	panel.getNomeArquivo().setText(arquivo.getName());
	            }
	          
	        // CASO O ARQUIVO NÃO FOR SELECIONADO
	        } else {
	        	panel.getNomeArquivo().setForeground(Color.red);
	        	panel.getNomeArquivo().setText("Nenhum Arquivo Selecionado!!");
	        }
	            
		}
		
		if(e.getSource() == panel.getPesquisar()) {
			String palavra = panel.getPalavra().getText();
			palavraCount = 0;
			if(arquivoImportado && !palavra.isBlank()) {
				
				// CRIA UM LEITOR DE TXT
				try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
					String linha;
					
					// PASSA LINHA POR LINHA DO TXT
            		while ((linha = leitor.readLine()) != null) {
            			linha = linha.toLowerCase();
            		
            			for(int i=0; i <= linha.length() - palavra.length(); i++)
            				if(palavra.toLowerCase().equals(linha.substring(i, i+palavra.length())))
            					palavraCount ++;
            		}
            		
            		panel.getResposta().setText("<html>Palavra: " + palavra + "<br><br>Número de Ocorrências: " + palavraCount + "</html>");
            	} catch (IOException e1) {
            		e1.printStackTrace();
            	}
			}
		}
	}
}
