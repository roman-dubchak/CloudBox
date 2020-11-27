package com.geekbrains.cloud.storage.client.gui;

import javax.swing.*;
import java.awt.*;


public class ClientGUI extends JFrame implements Thread.UncaughtExceptionHandler{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;

    private final JPanel panelTop = new JPanel(new GridLayout(1,3));
    private final JTextArea cloudLog = new JTextArea();

    private final JTextField jtLogin = new JTextField("login");
    private final JTextField jtPassword = new JTextField("password");
    private final JButton btnLogin = new JButton("Start");

    private final JPanel panelButton = new JPanel(new BorderLayout());
    private final JButton btnSendFile = new JButton("Отаравить Файл");
    private final JButton btnDeleteFile = new JButton("Удалить Файл");
    private final JButton btnUpdate = new JButton("Обновить");

    private final String WINDOW_TITLE = "Cloud Box";
    private final String LOCAL_TITLE = "Локальный диск";
    private final String REMOTE_TITLE = "Облачное хранилище";

//    private final GridLayout grdCenter = new GridLayout(1,2);

    private ClientGUI(){
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
//        setSize(WIDTH, HEIGHT);
        setTitle(WINDOW_TITLE);
        cloudLog.setEditable(false);
        cloudLog.setLineWrap(true); // перенос строки в логе по ширине.

        panelTop.add(jtLogin);
        panelTop.add(jtPassword);
        panelTop.add(btnLogin);

        panelButton.add(btnSendFile, BorderLayout.WEST);
        panelButton.add(btnDeleteFile, BorderLayout.CENTER);
        panelButton.add(btnUpdate, BorderLayout.EAST);

//        panelButton.setVisible(false); включить при входе


//        Таблица с файлами
//        GridLayout grdCenter = new GridLayout(1,2);
//       grdCenter.addLayoutComponent();

        add(panelTop, BorderLayout.NORTH); // добавить панель наверх
        add(panelButton, BorderLayout.SOUTH);
//        add(grdCenter, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args)  {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI();
            }
        });
    }

    public void uncaughtException(Thread t, Throwable e) {
    }

}
