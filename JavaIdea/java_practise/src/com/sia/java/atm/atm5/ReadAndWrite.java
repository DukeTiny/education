package com.sia.java.atm.atm5;

import java.io.*;

public class ReadAndWrite {

    File file = new File("usersInfo.txt");
    static final String OPRATOR = ",";
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fw = null;
    PrintWriter pw = null;

    public static String[] getStrs() {
        return strs;
    }

    private static String[] strs = new String[4];

    UserData extract(UserData user) {
        StringBuffer sb = new StringBuffer();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ( br.ready() ) {
                String tempstr = br.readLine();
                if( !tempstr.equals("")) {
                    strs = tempstr.split(OPRATOR);
                    if (strs[1].equals(user.getuName())) {
                        user.setUserId(strs[0]);
                        user.setuPwd(strs[2]);
                        user.setBalance( Double.parseDouble(strs[3]) );
                        continue;
                    }
                    sb.append( tempstr + "\r\n");
                }
            }
            this.readerClose();
            fw = new FileWriter( file );
            pw = new PrintWriter(fw);
            pw.print( sb.toString() );
            this.writerClose();
            if ( user!=null ) return user;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    void appendToFile( UserData users ) {
        try {
            fw = new FileWriter( file,true );
            pw = new PrintWriter(fw);
            pw.print( users.toString() +"\r\n");
            this.writerClose();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    void readerClose() {
        try {
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void writerClose() {
        try {
            fw.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
