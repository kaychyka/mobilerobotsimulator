/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.mobilerobotsimulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Karin Pi�kur (2014190802) and Pedro de Oliveira Est�v�o (2011157312)
 */
public class ApplicationGUI extends javax.swing.JFrame {
    private String fileName, folderName;
    private ArrayList<Agent> agents = new ArrayList<Agent>();
    int[] dimen;
    
    /**
     * Creates new form SimulatorGUI
     */
    public ApplicationGUI() {
        setTitle("Mobile Robot Simulator");
        initComponents();
        showDataPanel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jFolderChooser = new javax.swing.JFileChooser();
        jFrameMap = new javax.swing.JFrame();
        browseFilePanel = new javax.swing.JPanel();
        selectFile = new javax.swing.JLabel();
        selectFileTF = new javax.swing.JTextField();
        btnBrowseFile = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        selectFolder = new javax.swing.JLabel();
        selectFolderTF = new javax.swing.JTextField();
        btnBrowseFolder = new javax.swing.JButton();
        showDataPanel = new javax.swing.JPanel();
        agentsMemoryData = new javax.swing.JLabel();
        btnFinish = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        agentsDetailsTP = new javax.swing.JTextPane();
        btnShowMap = new javax.swing.JButton();

        jFrameMap.getContentPane().setLayout(new java.awt.GridLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selectFile.setText("Select file for creating environment and entities: ");

        btnBrowseFile.setText("Browse");
        btnBrowseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseFileActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.setEnabled(false);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        selectFolder.setText("Select folder where you want to save data about agents: ");

        btnBrowseFolder.setText("Browse");
        btnBrowseFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout browseFilePanelLayout = new javax.swing.GroupLayout(browseFilePanel);
        browseFilePanel.setLayout(browseFilePanelLayout);
        browseFilePanelLayout.setHorizontalGroup(
            browseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(browseFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(browseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectFileTF)
                    .addGroup(browseFilePanelLayout.createSequentialGroup()
                        .addGroup(browseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectFile)
                            .addComponent(selectFolder))
                        .addGap(0, 101, Short.MAX_VALUE))
                    .addComponent(selectFolderTF)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, browseFilePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(browseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBrowseFolder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBrowseFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
                .addContainerGap())
        );
        browseFilePanelLayout.setVerticalGroup(
            browseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(browseFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectFileTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBrowseFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(selectFolder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectFolderTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBrowseFolder)
                .addGap(61, 61, 61)
                .addComponent(btnOK)
                .addContainerGap())
        );

        agentsMemoryData.setText("Agents' memory data:");

        btnFinish.setText("Finish");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        jScrollPane.setViewportView(agentsDetailsTP);

        btnShowMap.setText("Show map");
        btnShowMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showDataPanelLayout = new javax.swing.GroupLayout(showDataPanel);
        showDataPanel.setLayout(showDataPanelLayout);
        showDataPanelLayout.setHorizontalGroup(
            showDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(showDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addGroup(showDataPanelLayout.createSequentialGroup()
                        .addComponent(agentsMemoryData)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDataPanelLayout.createSequentialGroup()
                        .addGap(0, 174, Short.MAX_VALUE)
                        .addComponent(btnShowMap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        showDataPanelLayout.setVerticalGroup(
            showDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agentsMemoryData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(showDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinish)
                    .addComponent(btnShowMap))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(showDataPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(browseFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(showDataPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(browseFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Browses for a file we want to use for creating the environment 
     * @param evt - ActionEvent by AWT
     */
    private void btnBrowseFileActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int returnVal = jFileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            fileName = file.getAbsolutePath();
            selectFileTF.setText(fileName);

            if(folderName != null)
                if(fileName != null)
                    btnOK.setEnabled(true);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }                                             

    /**
     * Finishes/closes the application
     * @param evt - ActionEvent by AWT
     */
    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        System.exit(0);
    }                                         

    /**
     * Shows map of the environment
     * @param evt - actionEvent
     */
    private void btnShowMapActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        jFrameMap.setVisible(true);
        
    }  
    
    /**
     * Confirms entered file with environment details and folder for saving files with all data.
     * Generates environment and it's map  
     * @param evt - actionEvent
     */
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        browseFilePanel.setVisible(false);
        showDataPanel.setVisible(true);
        dimen = Main.generateEnviroment(agents, fileName);
        if(dimen != null){
        	agentsDetailsTP.setText(Main.returnData(agents, 10, folderName));
        	int col = dimen[0];
        	int row = dimen[1];
        	createEnvironmentMap(col, row);
    	}else{
        	System.out.println("You chose wrong file");
        	btnShowMap.setEnabled(false);
        }
    }                                     

    /**
     * Browses for a folder where we want to save all files created after agents life time
     * @param evt - ActionEvent
     */
    private void btnBrowseFolderActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        jFolderChooser.setDialogTitle("Select Folder");
        jFolderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFolderChooser.setAcceptAllFileFilterUsed(false);

        if (jFolderChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            folderName = jFolderChooser.getSelectedFile().toString();
            selectFolderTF.setText(folderName);
            
            if(folderName != null)
                if(fileName != null)
                    btnOK.setEnabled(true);
        } else {
            System.out.println("No Selection ");
        }
    }                                               

    /**
     * Creates the map of environment with all entities
     * @param col - number of columns (size X)
     * @param row - number of rows (size Y)
     */
    public void createEnvironmentMap(int col, int row) {
    	ArrayList<Entity> entities = Environment.getEntities();
    	jFrameMap.setTitle("Environment Map");
        jFrameMap.setLayout(new GridLayout(row, col));

        for (int i = 0; i < (col * row); i++) {
            JPanel pan = new JPanel();

            pan.setEnabled(true);
            pan.setBackground(Color.WHITE);
            pan.setSize(20, 20);
            pan.setLayout(new GridBagLayout());
            pan.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pan.setPreferredSize(new Dimension(20, 20));
            pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pan.addMouseListener(new BoxListener()); // add a mouse listener to make the panels clickable
            
            JLabel lab = null;

            int x = i/ row;
            int y = i % col;
            
            String text = ""; 
            String id = "";
            for (Entity entity : entities) {
				if(entity.getCoordX() == x)
					if(entity.getCoordY() == y){
						id += entity.getID()+"-";
						if(entity instanceof Agent)
							text += "X";
						else
							text += "O";		
					}
			}

            lab = new JLabel(text);
            pan.setName(id);
            pan.add(lab);

            jFrameMap.add(pan);
            jFrameMap.setSize(col*50, row*50);
        }
    }
    
    /**
     * 
     * Shows details about entities when we click on the location
     *
     */
    private class BoxListener extends MouseAdapter {
    	public void mouseClicked(MouseEvent me) {
            //show entities details
    		ArrayList<Entity> entities = Environment.getEntities();
            JPanel clickedBox =(JPanel) me.getSource(); // get the reference to the box that was clicked 
            String[] ids = clickedBox.getName().split("-"); 
            String showDetails = "";
            if(!clickedBox.getName().equals(""))
		        for (String id : ids) {
		        	for (Entity entity : entities) {
						if(entity.getID() == Integer.parseInt(id)){
							  showDetails += entity.toString();
						}
					}
				}
            //System.out.print(showDetails);
            JOptionPane.showMessageDialog(jFrameMap, showDetails, "Entities details", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApplicationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextPane agentsDetailsTP;
    private javax.swing.JLabel agentsMemoryData;
    private javax.swing.JPanel browseFilePanel;
    private javax.swing.JButton btnBrowseFile;
    private javax.swing.JButton btnBrowseFolder;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnShowMap;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JFileChooser jFolderChooser;
    private javax.swing.JFrame jFrameMap;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel selectFile;
    private javax.swing.JTextField selectFileTF;
    private javax.swing.JLabel selectFolder;
    private javax.swing.JTextField selectFolderTF;
    private javax.swing.JPanel showDataPanel;
    // End of variables declaration                   
}
