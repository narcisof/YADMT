/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.uteis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author MateusFelipe
 */
public class Arquivos {

    String nomeArquivoACO;
    String nomeArquivoKmeans;
    String nomeArquivoHierarquicos;

    public Arquivos() {
        nomeArquivoACO = "/nothing";
        nomeArquivoKmeans = "/nothing";
        nomeArquivoHierarquicos = "/nothing";
    }

    public void salvarFormigas(ArquivoFormigas obj) {
        if (this.nomeArquivoACO.equals("/nothing")) {
            this.salvarComoFormigas(obj);
        } else {
            File arquivo = new File(nomeArquivoACO);
            MyFileHandler MFH = new MyFileHandler();
            MFH.openFile(arquivo, "rw");
            MFH.saveFormigas(obj);
            this.setNomeArquivoACO(arquivo.toString());
            JOptionPane.showMessageDialog(null, "Configurações salvas com sucesso!");
        }
    }

    public void salvarComoFormigas(ArquivoFormigas obj) {
        File arquivo = new File("ACO.ydt");
        MyFileHandler MFH = new MyFileHandler();
        JFileChooser fileChosser = new JFileChooser();
        fileChosser.setFileFilter(new FileType());
        fileChosser.setSelectedFile(arquivo);
        fileChosser.setAcceptAllFileFilterUsed(false);
        fileChosser.showSaveDialog(fileChosser);
        int opt = 0;
        if (fileChosser.getSelectedFile() != null) {
            String aux = fileChosser.getSelectedFile().toString();
            if (!aux.endsWith(".ydt")) {
                aux += ".ydt";
            }

            while (aux.equals(nomeArquivoACO)) {
                opt = JOptionPane.showConfirmDialog(null,
                        "Deseja sobreescrever o arquivo?", "Confirmação", 1);
                if (opt != 1) {
                    break;
                }
                fileChosser.setSelectedFile(arquivo);
                fileChosser.showSaveDialog(fileChosser);
                aux = fileChosser.getSelectedFile().toString();
            }
            if (opt == 0) {
                arquivo = new File(aux);
            }

            if (opt == 0) {
                MFH.openFile(arquivo, "rw");
                MFH.saveFormigas(obj);
                this.setNomeArquivoACO(aux);
                JOptionPane.showMessageDialog(null, "Configurações salvas com sucesso!");
            }

        }
    }

    public ArquivoFormigas abrirFormigas() throws FileNotFoundException, IOException {
        JFileChooser fileChosser = new JFileChooser();
        fileChosser.setFileFilter(new FileType());
        fileChosser.showOpenDialog(fileChosser);
        File arquivo;
        MyFileHandler MFH = new MyFileHandler();
        if (fileChosser.getSelectedFile() != null) {
            arquivo = new File(fileChosser.getSelectedFile().toString());
            MFH.openFile(arquivo, "r");
            this.setNomeArquivoACO(arquivo.toString());
            return MFH.loadFormigas();
        }
        return null;
    }

    public void salvarHierarquicos(ArquivoHierarquicos obj) {
        if (this.nomeArquivoHierarquicos.equals("/nothing")) {
            this.salvarComoHierarquicos(obj);
        } else {
            File arquivo = new File(nomeArquivoHierarquicos);
            MyFileHandler MFH = new MyFileHandler();
            MFH.openFile(arquivo, "rw");
            MFH.saveHierarquicos(obj);
            this.setNomeArquivoHierarquicos(arquivo.toString());
            JOptionPane.showMessageDialog(null, "Configurações salvas com sucesso!");
        }
    }

    public void salvarComoHierarquicos(ArquivoHierarquicos obj) {
        File arquivo = new File("Hierarquico.ydt");
        MyFileHandler MFH = new MyFileHandler();
        JFileChooser fileChosser = new JFileChooser();
        fileChosser.setFileFilter(new FileType());
        fileChosser.setSelectedFile(arquivo);
        fileChosser.setAcceptAllFileFilterUsed(false);
        fileChosser.showSaveDialog(fileChosser);
        int opt = 0;
        if (fileChosser.getSelectedFile() != null) {

            String aux = fileChosser.getSelectedFile().toString();

            if (!aux.endsWith(".ydt")) {
                aux += ".ydt";
            }

            while (aux.equals(nomeArquivoHierarquicos)) {
                opt = JOptionPane.showConfirmDialog(null,
                        "Deseja sobreescrever o arquivo?", "Confirmação", 1);
                if (opt != 1) {
                    break;
                }
                fileChosser.setSelectedFile(arquivo);
                fileChosser.showSaveDialog(fileChosser);
                aux = fileChosser.getSelectedFile().toString();
            }
            if (opt == 0) {
                arquivo = new File(aux);
            }

            if (opt == 0) {
                MFH.openFile(arquivo, "rw");
                MFH.saveHierarquicos(obj);
                this.setNomeArquivoHierarquicos(aux);
                JOptionPane.showMessageDialog(null, "Configurações salvas com sucesso!");
            }

        }
    }

    public ArquivoHierarquicos abrirHierarquicos() throws FileNotFoundException, IOException {
        JFileChooser fileChosser = new JFileChooser();
        fileChosser.setFileFilter(new FileType());
        fileChosser.showOpenDialog(fileChosser);

        File arquivo;

        MyFileHandler MFH = new MyFileHandler();

        if (fileChosser.getSelectedFile() != null) {
            arquivo = new File(fileChosser.getSelectedFile().toString());

            MFH.openFile(arquivo, "r");
            this.setNomeArquivoHierarquicos(arquivo.toString());
            return MFH.loadHierarquicos();
        }
        return null;

    }

    public void salvarKmeans(ArquivoKmeans obj) {
        if (this.nomeArquivoKmeans.equals("/nothing")) {
            this.salvarComoKmeans(obj);
        } else {
            File arquivo = new File(nomeArquivoKmeans);
            MyFileHandler MFH = new MyFileHandler();
            MFH.openFile(arquivo, "rw");
            MFH.saveKmeans(obj);
            this.setNomeArquivoKmeans(arquivo.toString());
            JOptionPane.showMessageDialog(null, "Configurações salvas com sucesso!");
        }
    }

    public void salvarComoKmeans(ArquivoKmeans obj) {
        File arquivo = new File("kmeans.ydt");
        MyFileHandler MFH = new MyFileHandler();
        JFileChooser fileChosser = new JFileChooser();
        fileChosser.setFileFilter(new FileType());
        fileChosser.setSelectedFile(arquivo);
        fileChosser.setAcceptAllFileFilterUsed(false);
        fileChosser.showSaveDialog(fileChosser);
        int opt = 0;
        if (fileChosser.getSelectedFile() != null) {
            String aux = fileChosser.getSelectedFile().toString();
            if (!aux.endsWith(".ydt")) {
                aux += ".ydt";
            }

            while (aux.equals(nomeArquivoKmeans)) {
                opt = JOptionPane.showConfirmDialog(null,
                        "Deseja sobreescrever o arquivo?", "Confirmação", 1);
                if (opt != 1) {
                    break;
                }
                fileChosser.setSelectedFile(arquivo);
                fileChosser.showSaveDialog(fileChosser);
                aux = fileChosser.getSelectedFile().toString();
            }
            if (opt == 0) {
                arquivo = new File(aux);
            }

            if (opt == 0) {
                MFH.openFile(arquivo, "rw");
                MFH.saveKmeans(obj);
                this.setNomeArquivoKmeans(aux);
                JOptionPane.showMessageDialog(null, "Configurações salvas com sucesso!");
            }

        }
    }

    public ArquivoKmeans abrirKmeans() throws FileNotFoundException, IOException {
        JFileChooser fileChosser = new JFileChooser();
        fileChosser.setFileFilter(new FileType());
        fileChosser.showOpenDialog(fileChosser);
        File arquivo;
        MyFileHandler MFH = new MyFileHandler();
        if (fileChosser.getSelectedFile() != null) {
            arquivo = new File(fileChosser.getSelectedFile().toString());
            MFH.openFile(arquivo, "r");
            this.setNomeArquivoKmeans(arquivo.toString());
            return MFH.loadKmeans();
        }
        return null;
    }

    public String getNomeArquivoACO() {
        return nomeArquivoACO;
    }

    public void setNomeArquivoACO(String nomeArquivoACO) {
        this.nomeArquivoACO = nomeArquivoACO;
    }

    public String getNomeArquivoHierarquicos() {
        return nomeArquivoHierarquicos;
    }

    public void setNomeArquivoHierarquicos(String nomeArquivoHierarquicos) {
        this.nomeArquivoHierarquicos = nomeArquivoHierarquicos;
    }

    public String getNomeArquivoKmeans() {
        return nomeArquivoKmeans;
    }

    public void setNomeArquivoKmeans(String nomeArquivoKmeans) {
        this.nomeArquivoKmeans = nomeArquivoKmeans;
    }

}
