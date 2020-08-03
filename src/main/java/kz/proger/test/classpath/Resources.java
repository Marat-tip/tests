package kz.proger.test.classpath;

import com.sun.nio.zipfs.ZipInfo;

import java.io.InputStream;
import java.util.Scanner;

public class Resources {
    public static void main(String[] args) {
//        systemAndExtClassloaders();
//        classBinaryFile();
//        extClassLoaderResources();
        systemClassLoaderWithResourceFromExt();
    }

    private static void systemClassLoaderWithResourceFromExt() {
        System.out.println("system class loader with resource from ext folder");
        InputStream stream = Resources.class.getClassLoader().getResourceAsStream("app.properties");
        Scanner reader = new Scanner(stream);
        System.out.println(reader.nextLine());
    }

    private static void extClassLoaderResources() {
        System.out.println("ext class loader resources");
        InputStream resourceAsStream = ZipInfo.class.getClassLoader().getResourceAsStream("app.properties");
        Scanner reader = new Scanner(resourceAsStream);
        System.out.println(reader.nextLine());
    }

    private static void classBinaryFile() {
        System.out.println("class binary file");
        Resources res = new Resources();
        Scanner packageReader = new Scanner(res.getClass().getResourceAsStream("Resources.class"));
        System.out.println(packageReader.nextLine());
    }

    private static void systemAndExtClassloaders() {
        System.out.println("system and ext class loaders");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Scanner reader = new Scanner(classLoader.getResourceAsStream("@app.properties"));
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getResourceAsStream("java/lang/Collection.class"));
        System.out.println(reader.nextLine());
    }
}
