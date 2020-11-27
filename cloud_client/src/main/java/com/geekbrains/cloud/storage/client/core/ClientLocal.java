package com.geekbrains.cloud.storage.client.core;

import java.io.*;

public class ClientLocal {
    private DataInputStream dis;
    private DataOutputStream dos;
    private FileInputStream fis;

    private void sendClientFile(File file){
        // Подключение к сети
        try  {
            FileInputStream fis = new FileInputStream(file); // в трай с ресурсами, сейчас ошибка
            int sizeFileName = file.getName().getBytes().length;
            dos.writeInt(sizeFileName); // почему int? в лекции byte
            dos.writeUTF(file.getName());
            long sizeFile = file.length();
            dos.writeLong(sizeFile);
            int n = 1024;
            byte[] b1 = new byte[n];
            while (sizeFile / n >= 1){
                fis.read(b1);
                dos.write(b1);
                sizeFile -= n;
            }
            byte[] b2 = new byte[(int) sizeFile % n];
            fis.read(b2);
            dos.write(b2);
            dos.close(); // в трай с ресурсами, сейчас ошибка

        }   catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readClientFile(){
        try {
            int sizeFileName = dis.readInt();
            String nameFile = dis.readUTF();
            long sizeFile = dis.readLong();
            System.out.println(sizeFile);

            File fileServer = new File("server\\" + nameFile);
            FileOutputStream fos = new FileOutputStream(fileServer);

            int n = 1024;
            byte[] b1 = new byte[n];
            while (sizeFile / n >= 1){
                fis.read(b1);
                fos.write(b1);
                sizeFile -= n;
            }
            byte[] b2 = new byte[(int) sizeFile % n];
            fis.read(b2);
            fos.write(b2);
            fos.flush();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
