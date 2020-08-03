package kz.proger.test.classpath;


import com.sun.nio.zipfs.ZipInfo;

public class ClassLoaders {
    public static void main(String[] args) {
        System.out.println(ClassLoaders.class.getClassLoader());
        System.out.println(ClassLoaders.class.getClassLoader().getParent());
        System.out.println(ZipInfo.class.getClassLoader().getParent());
    }
}
