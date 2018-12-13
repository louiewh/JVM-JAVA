package com.wh.jvm;

import com.wh.jvm.classfile.ClassReader;
import com.wh.jvm.classpath.ClassPath;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


/**
 * Created by louie.wang on 2017/12/11.
 */

public class Jvm {
    static final String TAG = "JvmMain: ";

    String mVersion = "0.0.1";
    String mCp;
    String mXJre;
    public ClassPath mClassPath;
    public ClassReader mClassReader;

    public void startJvm(String [] args){

        System.err.println(TAG+"startJvm !!!");
        parseCmd(args);
        mClassPath = new ClassPath(mCp);
        mClassReader = new ClassReader();
    }

    public void parseCmd(String [] args){

        Options options = new Options();

        options.addOption("h", "help", false, "Show Usage");
        options.addOption("v", "version", false, "Show Version");
        options.addOption("cp", "classpath", true, "Jar path");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("h")) {
                printUsage();
            }

            if (cmd.hasOption("version")) {
                System.err.println(TAG+"Version : " +mVersion);
            }

            if (cmd.hasOption("classpath")) {
                mCp = cmd.getOptionValue("classpath");
            }

            if(cmd.getArgList().size() == 0){
                printUsage();
            }
        } catch (ParseException e) {
            System.err.println(TAG+e.getMessage());
            e.printStackTrace();
        }

    }

    byte[] readClass(String classname){
        byte[] bytesClass = mClassPath.readClass(classname);
        System.err.println(classname);
        System.err.println(Utils.ByteArrayToHexString(bytesClass));

        return bytesClass;
    }

    public static void printUsage(){
        System.err.println(TAG+"Usage: java [-options] class [args...]");
    }


    public int sum(){
        int i = 5;
        int j = 8;
        int sum = i + j;

        return sum;

    }
}
