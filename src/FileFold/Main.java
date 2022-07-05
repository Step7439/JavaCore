package FileFold;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static Date date = new Date();

    public static void main(String[] args) {
        addfolder();
        addFiles();
        serializablE();
        addZip();
        deletDat();
        fos1();
    }

    public static void fos1() {
        try (FileOutputStream fos = new FileOutputStream("/home/acer/Games/temp/temp.txt", false)) {
            byte[] bytes = stringBuilder.toString().getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addfolder() {
        File dir1 = new File("/home/acer/Games", "src");
        File dir2 = new File("/home/acer/Games", "res");
        File dir3 = new File("/home/acer/Games", "savegames");
        File dir4 = new File("/home/acer/Games", "temp");
        File dir5 = new File("/home/acer/Games/src", "main");
        File dir6 = new File("/home/acer/Games/src", "test");
        File dir7 = new File("/home/acer/Games/res", "drawables");
        File dir8 = new File("/home/acer/Games/res", "vectors");
        File dir9 = new File("/home/acer/Games/res", "icons");

        File[] dir = {dir1, dir2, dir3, dir4, dir5, dir6, dir7, dir8, dir9};

        for (File file : dir) {
            if (file.mkdir()) {
                stringBuilder.append(date).append(" Каталог создан ").append(file).append("\n");
            }
        }
    }

    public static void addFiles() {
        File myFile1 = new File("/home/acer/Games/src/main/Main.java");
        File myFile2 = new File("/home/acer/Games/src/main/Utils.java");
        File myFile3 = new File("/home/acer/Games/temp/temp.txt");

        File[] myFile = {myFile1, myFile2, myFile3};

        for (File file : myFile) {
            try {
                if (file.createNewFile()) {
                    stringBuilder.append(date).append(" Файл сздан ").append(" ").append(file).append("\n");
                }
            } catch (IOException ex) {
                stringBuilder.append(date).append(" ").append(ex).append(" ").append(" ").append(file).append("\n");
            }
        }
    }

    public static void serializablE() {
        GameProgress gameProgress1 = new GameProgress(5, 35, 9, 0.1);
        GameProgress gameProgress2 = new GameProgress(1, 44, 10, 1.2);
        GameProgress gameProgress3 = new GameProgress(8, 78, 13, 2.4);

        GameProgress[] gameProgress = {gameProgress1, gameProgress2, gameProgress3};

        for (GameProgress progress : gameProgress) {
            try
                    (FileOutputStream fos = new FileOutputStream("/home/acer/Games/savegames/save.dat");
                     ObjectOutputStream seri1 = new ObjectOutputStream(fos)) {
                seri1.writeObject(progress);
                stringBuilder.append(date).append(" Сереализация Готова ").append(progress.toString()).append("\n");
            } catch (IOException e) {
                stringBuilder.append(date).append(" Сереализация Error").append("\n");
            }
        }
    }

    public static void addZip() {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("/home/acer/Games/savegames/zip_save.zip"));
             FileInputStream fis = new FileInputStream("/home/acer/Games/savegames/save.dat")) {
            ZipEntry entry = new ZipEntry("/home/acer/Games/savegames/save.dat");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (IOException e) {
            System.out.println(stringBuilder.append(date).append(" Ошибка создания zip!!! ").append(e.getMessage()).append("\n"));
        }
    }

    public static void deletDat() {
        try {
            Path path = Path.of("/home/acer/Games/savegames/save.dat");
            Files.delete(path);
            stringBuilder.append(date).append(" Удолили файл ").append(path).append("\n");
        } catch (IOException e) {
            stringBuilder.append(date).append(" Ошибка удолния!!!");
        }
    }

}
