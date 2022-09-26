/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.tapemaker;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.ImageFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author gohan
 */
public class SuperPlaylistMaker extends javax.swing.JFrame {

    /**
     * Creates new form TapeMakerUI
     */
    public SuperPlaylistMaker() {
        initComponents();
    }
    
    public String songName, songTime, playlistName, getCurrentDirectory, line, DELIMITER = ",";
    public int songTimeSec, songChoice, totalTimeSec, totalTimeMin, totalTimeHour, playlistData;
    public ArrayList<String> playlistSong = new ArrayList<>(), playlistTimeString = new ArrayList<>();
    public ArrayList<Integer> playlistTime = new ArrayList<>(); 
    
    //Writes playlists to CSV files
    public static void fileWriter(String playlistName, ArrayList<String> playlistSong, ArrayList<Integer> playlistTime, ArrayList<String> playlistTimeString, String getCurrentDirectory) throws IOException
    {
        FileWriter csvWriter = new FileWriter(getCurrentDirectory + "\\" + playlistName + ".csv");
        csvWriter.write(playlistName + "\n");                                   //Line 1 is Playlist Name
        for (int i = 0; i < playlistSong.size(); i++)                           //Line 2 is Playlist Songs
            {
                csvWriter.append(playlistSong.get(i) + ",");
            }
        csvWriter.write("\n");
        for (int i = 0; i < playlistTime.size(); i++)                           //Line 3 is Playlist Song Time in Seconds
            {
                csvWriter.append(playlistTime.get(i) + ",");
            }
        csvWriter.write("\n");
        for (int i = 0; i < playlistTime.size(); i++)                           //Line 4 is Playlist Song Time in MM:SS format
            {
                csvWriter.append(playlistTimeString.get(i) + ",");
            }
        csvWriter.flush();
        csvWriter.close();
    }
    
    //Reads CSV and converts the data back into a playlist
    public void fileReader(String getCurrentDirectory, String DELIMITER, String line, String playlistName, ArrayList<String> playlistSong, ArrayList<Integer> playlistTime, ArrayList<String> playlistTimeString) throws IOException
    {
        BufferedReader br = Files.newBufferedReader(Paths.get(getCurrentDirectory));
        
        line = br.readLine();
        String[] tokens = line.split(DELIMITER);
        for (String token : tokens)
        {
            playlistName = token;                                               //Line 1 only has the Playlist Name
        } 
        
        line = br.readLine();                                                   //Playlist Song
        tokens = line.split(DELIMITER);
        for (String token : tokens)
        {
            playlistSong.add(token);
        }
        
        line = br.readLine();                                                   //Playlist Song Time (SEC)
        tokens = line.split(DELIMITER);
        for (String token : tokens)
        {
            playlistTime.add(Integer.parseInt(token));
        }
        
        line = br.readLine();                                                   //Playlist Song Time (MM:SS)
        tokens = line.split(DELIMITER);
        for (String token : tokens)
        {
            playlistTimeString.add(token);
        }
        br.close();
    }
    
    //Takes all the lists and correctly outputs the data
    public static void outputPlaylist(int totalTimeSec, int totalTimeMin, int totalTimeHour, JTextArea jTextArea2, JTextField jTextField4, ArrayList<String> playlistSong, ArrayList<Integer> playlistTime, ArrayList<String> playlistTimeString)
    {
        totalTimeSec = 0;
        totalTimeMin = 0;
        totalTimeHour = 0;
        for (int i = 0; i < playlistSong.size(); i++)
        {
            jTextArea2.append((i+1) + ". " + playlistSong.get(i) + "        ");
            jTextArea2.append(playlistTimeString.get(i)  + "\n");
        }
        for (int i = 0; i < playlistTime.size(); i++)
        {
            totalTimeSec += playlistTime.get(i);
        }
        totalTimeMin = totalTimeSec / 60;
        totalTimeSec -= totalTimeMin * 60;
        totalTimeHour = totalTimeMin / 60;
        totalTimeMin -= totalTimeHour * 60;
        jTextField4.setText(String.format("%02d:%02d:%02d", totalTimeHour, totalTimeMin, totalTimeSec));
    }        
    
    public int minToSec(String songTime)                                        //Converts (MM:SS) to seconds
    {
        int songMinToSec;
        String timeDelimited = songTime;
        String[] songTimeMinSec = timeDelimited.split(":");
        songMinToSec = (Integer.parseInt(songTimeMinSec[0])) * 60;
        songTimeSec = (songMinToSec + (Integer.parseInt(songTimeMinSec[1])));
        return songTimeSec;
    }
    
    public static JFrame f = new JFrame("Changelog :)");                        //Popup Windows
    public static JFrame f2 = new JFrame("Save Location");
    
    public static void changelogFrame() {
        JPanel p = new JPanel();
        JTextArea t = new JTextArea();
        t.setText("10/16/2020 v0.3a\n- Corrected Button Colors, again...\n- Save & Open playlists\n- Edit playlist Name \n- Overwrite Saved Files \n- Removed Exit Button\n- Removed Herobrine");
        p.add(t);
        f.add(p);
        f.setSize(300, 200);
        f.show();
    } 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jFrame1 = new javax.swing.JFrame();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");

        jMenu2.setText("jMenu2");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel15.setText("jLabel15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("TapeMake");

        jLabel2.setText("By Gio Perez");

        jButton1.setBackground(new java.awt.Color(0, 179, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(179, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remove");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Song Title:");

        jLabel5.setText("Time (MM:SS)");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Clear");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(2);
        jTextArea2.setRows(5);
        jTextArea2.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel6.setText("0.3a");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Total Time:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel8.setText("(Index of Song to Remove)");

        jButton5.setBackground(new java.awt.Color(102, 153, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Changelog");
        jButton5.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jButton5InputMethodTextChanged(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 122, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(179, 179, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Open");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Playlist Name:");

        jTextField6.setText("C:\\");
            jTextField6.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField6ActionPerformed(evt);
                }
            });

            jLabel9.setText("Directory:");

            jLabel10.setText("*If saving file, put the directory of the folder you'd like to save the file to");

            jLabel11.setText("*If opening file, put the directory of the file you'd like to open, including the extension (.csv)");

            jLabel12.setText("e.g. \"C:\\Users\\user_name\\folder_name\"");

            jLabel13.setText("e.g. \"C:\\Users\\user_name\\folder_name\\file_name.csv\"");

            jLabel14.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
            jLabel14.setText("Please email any bugs/issues to gioperezcolon@gmail.com");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(13, 13, 13)
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8))
                                .addComponent(jLabel4))
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jButton3)
                                    .addGap(10, 10, 10))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel5)
                                    .addContainerGap())))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel12))))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jTextField1)
                                    .addGap(11, 11, 11)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1)
                                    .addGap(106, 106, 106)
                                    .addComponent(jLabel2))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField5))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField6)))
                            .addContainerGap())))
                .addGroup(layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jLabel14)
                    .addGap(0, 0, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5)
                        .addComponent(jButton4)
                        .addComponent(jButton6))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel10)
                    .addGap(2, 2, 2)
                    .addComponent(jLabel12)
                    .addGap(9, 9, 9)
                    .addComponent(jLabel11)
                    .addGap(2, 2, 2)
                    .addComponent(jLabel13)
                    .addGap(14, 14, 14)
                    .addComponent(jLabel14)
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

                                                                                //Song Field
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

                                                                                //Add Button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        playlistSong.add(jTextField1.getText());
        playlistTimeString.add(jTextField2.getText());
        playlistTime.add(minToSec(jTextField2.getText()));
        jTextArea2.setText("");
        jTextField4.setText("");
        outputPlaylist(totalTimeSec, totalTimeMin, totalTimeHour, jTextArea2, jTextField4, playlistSong, playlistTime, playlistTimeString);
    }//GEN-LAST:event_jButton1ActionPerformed

                                                                                //Clear Button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextArea2.setText("");
        playlistSong = new ArrayList<>();
        playlistTime = new ArrayList<>();
        playlistTimeString = new ArrayList<>();
    }//GEN-LAST:event_jButton3ActionPerformed

                                                                                //Time Field
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

                                                                                //Remove Button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        songChoice = Integer.parseInt(jTextField3.getText());
        totalTimeSec = 0;
        totalTimeMin = 0;
        totalTimeHour = 0;
        playlistSong.remove(songChoice-1);
        playlistTime.remove(songChoice-1);
        playlistTimeString.remove(songChoice-1);
        jTextArea2.setText("");
        for (int i = 0; i < playlistSong.size(); i++)
        {
            jTextArea2.append((i+1) + ". " + playlistSong.get(i) + "        ");
            jTextArea2.append(playlistTimeString.get(i)  + "\n");
        }
        for (int i = 0; i < playlistTime.size(); i++)
        {
            totalTimeSec += playlistTime.get(i);
        }
        totalTimeMin = totalTimeSec / 60;
        totalTimeSec -= totalTimeMin * 60;
        totalTimeHour = totalTimeMin / 60;
        totalTimeMin -= totalTimeHour * 60;
        jTextField4.setText(String.format("%02d:%02d:%02d", totalTimeHour, totalTimeMin, totalTimeSec));
    }//GEN-LAST:event_jButton2ActionPerformed
                                                                                //Total Time Field
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        jTextField4.setText("");
    }//GEN-LAST:event_jTextField4ActionPerformed
                                                                                //Changelog Button
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        changelogFrame();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jButton5InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5InputMethodTextChanged

                                                                                //Open File Button
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextArea2.setText("");
        playlistSong = new ArrayList<>();
        playlistTime = new ArrayList<>();
        playlistTimeString = new ArrayList<>();
        getCurrentDirectory = jTextField6.getText();
        
        try {
            fileReader(getCurrentDirectory, DELIMITER, line, playlistName, playlistSong, playlistTime, playlistTimeString);
            outputPlaylist(totalTimeSec, totalTimeMin, totalTimeHour, jTextArea2, jTextField4, playlistSong, playlistTime, playlistTimeString);
        } catch (IOException ex) {
            Logger.getLogger(SuperPlaylistMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed
                                                                                //Playlist Name Field
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

                                                                                //Save File Button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        playlistName = jTextField5.getText();
        getCurrentDirectory = jTextField6.getText();
        try {
            fileWriter(playlistName, playlistSong, playlistTime, playlistTimeString, getCurrentDirectory);
        } catch (IOException ex) {
            Logger.getLogger(SuperPlaylistMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
                                                                                //Directory Field
    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

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
            java.util.logging.Logger.getLogger(SuperPlaylistMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuperPlaylistMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuperPlaylistMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuperPlaylistMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuperPlaylistMaker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
