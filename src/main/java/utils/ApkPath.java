package utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class work with apk file
 */
public class ApkPath {

    private ApkPath() {
        throw new IllegalStateException("ApkPath class");
    }

    private static final Logger LOGGER = Logger.getLogger(ApkPath.class.getName());

    private static File classpathRoot = new File(System.getProperty("user.dir"));
    private static File appRoot = new File(classpathRoot, "src/main/app/");
    private static FilenameFilter filter = (dir, name) -> name.endsWith(".apk");

    private static File getApk() {
        String[] children = appRoot.list(filter);
        String apk = null;
        if (children == null) {
            LOGGER.log(Level.SEVERE,"Either dir does not exist or is not a directory");
        } else {
            for (String filename : children) {
                apk = filename;
            }
        }
        return new File(appRoot + File.separator + apk);
    }

    public static String pathToApk() {
        return getApk().getAbsolutePath();
    }
}