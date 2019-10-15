package com.sia.java.practise.io_practise;

import java.io.*;

public class CopyAll {

    public static void main(String[] args) throws IOException {
        String dir1 = "D:/woniu";
        String dir2 = "D:/copy";

        copy(new File(dir1), new File(dir2));
    }

    static void copy(File file1, File file2) throws IOException {
        if (file1.isDirectory()) {
            File[] files = file1.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        InputStream in = new FileInputStream(f);
                        byte[] bytes = new byte[(int) f.length()];
                        in.read(bytes);
                        in.close();
                        if (!file2.exists() ) {
                            file2.mkdir();
                        }
                        OutputStream out = new FileOutputStream(f.getAbsolutePath().replace(f.getParent(), file2.getCanonicalPath()));
                        out.write(bytes);
                        out.close();
                    }
                    if (f.isDirectory()) {
                        if ( !file2.exists() ) {
                            file2.mkdir();
                        }
                        File temp = new File(f.getCanonicalPath().replace(f.getParent(), file2.getCanonicalPath()));
                        temp.mkdir();
                        copy(f, temp);
                    }
                }
            }
        }
    }
}
