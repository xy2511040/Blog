package cn.jsmoon.test;

import org.apache.commons.lang.StringEscapeUtils;

public class SpringEscapeUtilsTest {
	public static void main(String[] args) {
		//没过滤以前
		String html="<html>";
		System.out.println("没过滤以前");
		System.out.println(html);
		System.out.println("-------------");
		//过滤以后
		System.out.println("过滤以后");
		System.out.println(StringEscapeUtils.escapeHtml(html));
	}

}
