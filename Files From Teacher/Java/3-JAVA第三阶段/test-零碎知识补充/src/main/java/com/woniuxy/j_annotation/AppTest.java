package com.woniuxy.j_annotation;

import java.lang.reflect.Field;

public class AppTest {

	public static void main(String[] args) {
		String code = f1(User.class);
		
		System.out.println(code);
		
	}

	private static String f1(Class clazz) {
		
		
		Table table = (Table) clazz.getAnnotation(Table.class);
		String tableName = table.name();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("create table " + tableName + "\r\n");
		sb.append("(\r\n");
		
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			if(f.isAnnotationPresent(Column.class)) {
				Column column = f.getAnnotation(Column.class);
				String columnName = column.name();
				String columnType = "";
				if(f.isAnnotationPresent(SQLInteger.class)) {
					columnType = " int ";
				} else if(f.isAnnotationPresent(SQLString.class)) {
					SQLString ss = f.getAnnotation(SQLString.class);
					int len = ss.length();
					columnType = " varchar("+len+") ";
				}
				sb.append("\t" + columnName + " " + columnType + ",\r\n");
			}
		}
		
		sb.deleteCharAt(sb.length() - 3);
		
		sb.append(")\r\n");
		
		return sb.toString();
	}
}


