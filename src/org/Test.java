package org;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Test {
	/*public static void main(final String[] args) {
		Integer a = 127;
		Integer b = 127;
		System.out.println(a == b);
		
		StringBuffer buffer =new StringBuffer("123");
		//反转
		buffer.reverse();
		System.out.println(buffer.toString());
		
		buffer.replace(0, 1, "卧槽");
		System.out.println(buffer.toString());
		
		System.out.println(buffer.toString().replace("1", "尼玛"));
		
		
	}*/
	public static void main(String path[]) throws Exception {
        URL u=new URL("https://www.baidu.com");
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        System.out.println(new String(b,"utf-8"));
}
}
