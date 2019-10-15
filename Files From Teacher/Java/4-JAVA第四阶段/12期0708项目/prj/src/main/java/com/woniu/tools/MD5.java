package com.woniu.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**   
 * @ClassName:  MD5   
 * @Description:TODO(加密)   
 * @author: 蜗牛学院老韩
 * @date:   2019年7月8日 上午11:09:10   
 *     
 * @Copyright: 2019 www.woniu.com Inc. All rights reserved. 
 */  
public class MD5 {
	
	public static String md5s(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String agrs[]) {
		for (int i = 0; i < 10000; i++) {
			System.out.println(MD5.md5s("000000"));
		}
	}

}