package com.common.file;  
  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.text.DateFormat;  
import java.util.Date;  
import java.util.Iterator;  
  
import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;  
  
/** 
 *  
 * ���������� 
 *  
 * @author Administrator 
 * @Date Jul 19, 2008 
 * @Time 9:46:11 AM 
 * @version 1.0 
 */  
public class FileUtil {  
  
    /** 
     * �����������г�ĳ�ļ��м������ļ���������ļ������ɸ�����չ������ 
     *  
     * @param path 
     *            �ļ��� 
     */  
    public static void list(File path) {  
        if (!path.exists()) {  
            System.out.println("�ļ����Ʋ�����!");  
        } else {  
            if (path.isFile()) {  
                if (path.getName().toLowerCase().endsWith(".pdf")  
                        || path.getName().toLowerCase().endsWith(".doc")  
                        || path.getName().toLowerCase().endsWith(".chm")  
                        || path.getName().toLowerCase().endsWith(".html")  
                        || path.getName().toLowerCase().endsWith(".htm")) {// �ļ���ʽ  
                    System.out.println(path);  
                    System.out.println(path.getName());  
                }  
            } else {  
                File[] files = path.listFiles();  
                for (int i = 0; i < files.length; i++) {  
                    list(files[i]);  
                }  
            }  
        }  
    }  
  
    /** 
     * ��������������һ��Ŀ¼�����ļ���ָ��·���£�����Դ�ļ�������Ŀ���ļ�·���� 
     *  
     * @param source 
     *            Դ�ļ� 
     * @param target 
     *            Ŀ���ļ�·�� 
     * @return void 
     */  
    public static void copy(File source, File target) {  
        File tarpath = new File(target, source.getName());  
        if (source.isDirectory()) {  
            tarpath.mkdir();  
            File[] dir = source.listFiles();  
            for (int i = 0; i < dir.length; i++) {  
                copy(dir[i], tarpath);  
            }  
        } else {  
            try {  
                InputStream is = new FileInputStream(source); // ���ڶ�ȡ�ļ���ԭʼ�ֽ���  
                OutputStream os = new FileOutputStream(tarpath); // ����д���ļ���ԭʼ�ֽڵ���  
                byte[] buf = new byte[1024];// �洢��ȡ���ݵĻ�������С  
                int len = 0;  
                while ((len = is.read(buf)) != -1) {  
                    os.write(buf, 0, len);  
                }  
                is.close();  
                os.close();  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        File file = new File("F:\\Tomcat");  
        list(file);  
        Date myDate = new Date();   
        DateFormat df = DateFormat.getDateInstance();  
        System.out.println(df.format(myDate));   
    }  
  
}  