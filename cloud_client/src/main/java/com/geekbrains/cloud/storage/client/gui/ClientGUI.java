package com.geekbrains.cloud.storage.client.gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class ClientGUI extends JFrame implements Thread.UncaughtExceptionHandler{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;

    private final JPanel panelTop = new JPanel(new GridLayout(1,3));
    private final JPanel panelCenter = new JPanel(new GridLayout(4,1));


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
    private final String NAME_TITLE = "Имя файла";
    private final String SIZE_TITLE = "Размер файла";

    //        Таблица с файлами
//    private final HashMap<String, String> fileList = new HashMap<String, String>(); мапа с файлами
    private final Object[][] tableExample =
                        {{"text1.txt", "16 KB"},
                        {"text2.txt", "21 KB"},
                        {"text3.txt", "4 KB"}};

    private final Object[] handlerTable = {NAME_TITLE,SIZE_TITLE};

    private final JTable cloudTable = new JTable(tableExample, handlerTable);

    private ClientGUI(){
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
//        setSize(WIDTH, HEIGHT);
        setTitle(WINDOW_TITLE);

//        cloudLog.setLineWrap(true); // перенос строки в логе по ширине.


        panelTop.add(jtLogin); // сделать по центру, остальное невидимое.
        panelTop.add(jtPassword);
        panelTop.add(btnLogin); // после успешной регистраиции это панеь невидима

        panelCenter.add(new Label(LOCAL_TITLE), 0);
        panelCenter.add(cloudTable);

        panelButton.add(btnSendFile, BorderLayout.WEST);
        panelButton.add(btnDeleteFile, BorderLayout.CENTER);
        panelButton.add(btnUpdate, BorderLayout.EAST);

//        panelButton.setVisible(false); включить панель с кнопками при входе




        add(panelTop, BorderLayout.NORTH); // добавить панель наверх
        add(panelCenter, BorderLayout.CENTER); // добавить центарльную панель
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
