package edu.byu.yc;

import java.io.File;

/**
 * @author Samuel Nuttall
 */
public class SymbolTableTests {

    private final String root = System.getProperty("user.dir");

    private final File noAllCapsFile = new File(new File(root, "test-files"), "NoAllCaps.java");
    private final File hasAllCapsFile = new File(new File(root, "test-files"), "HasAllCaps.java");
    private final String noAllCaps = TypeChecker.readFile(noAllCapsFile.getPath());
    private final String hasAllCaps = TypeChecker.readFile(hasAllCapsFile.getPath());
}
