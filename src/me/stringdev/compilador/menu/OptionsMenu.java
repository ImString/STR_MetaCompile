package me.stringdev.compilador.menu;

import me.stringdev.compilador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OptionsMenu extends JFrame {

    public OptionsMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        jMenuItem1 = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("STR - Compilador Lua");
        setResizable(false);

        jLabel1.setFont(new Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Desenvolvido por ImString");

        jLabel2.setText("Discord: ImString#4343");

        jButton1.setText("Gerar Meta");
        jButton1.setHorizontalAlignment(SwingConstants.CENTER);
        jButton1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Exemplo:\ncString-client\nsString-server\ngString-shared\ndxlib");
        jTextArea1.setEnabled(false);
        jTextArea1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jTextArea1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea1);

        jLabel3.setFont(new Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("Palavras Chave:");

        jLabel4.setFont(new Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setLabelFor(jLabel1);
        jLabel4.setText("STRING COMPILADOR");

        jLabel5.setFont(new Font("Arial", 0, 11));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Texto de erro");
        jLabel5.setVisible(false);

        jMenu1.setText("Utilidades");
        jMenuItem1.setText("Ofuscador");
        jMenuBar1.add(jMenu1);
        jMenu1.add(jMenuItem1);

        jMenu2.setText("Avaliar");
        jMenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(240, 240, 240)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabel2))
                                                        .addComponent(jLabel1)
                                                        .addComponent(jButton1)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(200, 200, 200)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jScrollPane2)
                                                                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(55, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5)
                                .addGap(1, 1, 1)
                                .addComponent(jButton1)
                                .addGap(72, 72, 72)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(8, 8, 8))
        );

        pack();
    }

    private void jTextArea1MousePressed(MouseEvent evt) { // Clicar na area de escrever lista
        jTextArea1.setEnabled(true);
        jTextArea1.setEditable(true);
        jTextArea1.setText("");
    }

    private void jButton1MousePressed(MouseEvent evt) { //Clica no botão de gerar
        if (!jTextArea1.isEnabled()) {
            jLabel5.setVisible(true);
            jLabel5.setForeground(new Color(255, 0, 0));
            jLabel5.setText("Informe valores validos.");
            return;
        }

        if (jTextArea1.getText() == null) {
            jLabel5.setVisible(true);
            jLabel5.setBackground(Color.RED);
            jLabel5.setText("Informe valores validos.");
            return;
        }

        String filter = jTextArea1.getText();
        ArrayList<String> filterList = new ArrayList<>();
        for (int i = 0; i < filter.split("\n").length; i++) {
            filterList.add(filter.split("\n")[i]);
        }

        Main.getMetaManager().filterMeta(filterList);
        Main.getMetaManager().generateMeta();
    }

    private void jMenu2MousePressed(MouseEvent evt) { //Clica no menu "avaliar"
        String url_open = "https://github.com/ImString";
        try {
            Desktop.getDesktop().browse(URI.create(url_open));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openMenu() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OptionsMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(OptionsMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OptionsMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(OptionsMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionsMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuItem jMenuItem1;
    private JMenuBar jMenuBar1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    // End of variables declaration
}