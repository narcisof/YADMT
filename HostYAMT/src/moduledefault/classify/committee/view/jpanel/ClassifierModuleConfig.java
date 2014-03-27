package moduledefault.classify.committee.view.jpanel;

import controller.FacadeHost;
import controller.ModuleFactory;
import interfaces.mining.classify.ClassifierModuleInterface;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ModuleAvailable;
import view.jdialog.JDialogConfig;
import view.jpanel.JPanelPreprocess;

/**
 *
 * @author tiago.sippert
 */
public class ClassifierModuleConfig {

    public ClassifierModuleInterface classifierModule = null;
    private JLabel jLabelClassifier = null;
    private JButton jButtonConfiguration = null;
    private JComboBox jComboBoxClassifier = null;
    public ModuleAvailable<ClassifierModuleInterface> classifierModuleSelected = null;

    public void initConfig(Integer id, JPanel jPanelClassifiers) {

        Integer linha = id;

        jLabelClassifier = new JLabel("Classificador " + (linha));

        jButtonConfiguration = new JButton("Configurações");

        jButtonConfiguration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialogConfig jDialogConfig = new JDialogConfig(FacadeHost.getViewMain(), true);
                jDialogConfig.addPanel(classifierModule.getPainelConfig());
                jDialogConfig.setTitle("Configurações do Classificador");
                jDialogConfig.setSize(jDialogConfig.getWidth() < 300 ? 300 : jDialogConfig.getWidth(), jDialogConfig.getHeight());
                classifierModule.setJDialogConfig(jDialogConfig);
                jDialogConfig.setVisible(true);           
            }
        });

        jComboBoxClassifier = new JComboBox();
        for (ModuleAvailable<ClassifierModuleInterface> c : ModuleFactory.getArrayListClassifierModules()) {
            if (!c.getName().equals("Máquina de Comitê")) {
                jComboBoxClassifier.addItem(c);
            }
        }

        jComboBoxClassifier.setSelectedItem(classifierModuleSelected);
        jButtonConfiguration.setEnabled(classifierModuleSelected!=null);

        jComboBoxClassifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (jComboBoxClassifier.getSelectedItem() instanceof ModuleAvailable) {
                    try {
                        classifierModule = ((ModuleAvailable<ClassifierModuleInterface>) jComboBoxClassifier.getSelectedItem()).getConstructor().newInstance();
                        classifierModule.setHost(FacadeHost.getHost());
                        if (classifierModule.getPainelConfig() != null) {
                            jButtonConfiguration.setEnabled(true);
                        } else {
                            jButtonConfiguration.setEnabled(false);
                        }
                        classifierModuleSelected = ((ModuleAvailable<ClassifierModuleInterface>) jComboBoxClassifier.getSelectedItem());
                    } catch (InstantiationException ex) {
                        Logger.getLogger(JPanelPreprocess.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(JPanelPreprocess.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(JPanelPreprocess.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(JPanelPreprocess.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    jButtonConfiguration.setEnabled(false);
                    classifierModule = null;
                }
            }
        });

        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = linha;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = gridBagConstraints.EAST;
        jPanelClassifiers.add(jLabelClassifier, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        //gridBagConstraints.gridy = linha;
        //gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        jPanelClassifiers.add(jComboBoxClassifier, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        //gridBagConstraints.gridy = linha;
        gridBagConstraints.ipadx = 0;
        jPanelClassifiers.add(jButtonConfiguration, gridBagConstraints);

        jPanelClassifiers.doLayout();

    }
}
