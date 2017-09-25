package com.yy.core.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 文件名称:    DateUtil.java
 * <br>内容摘要:日期工具</br></p> 
 * @author:  tom:<a href="mailto:tomzhou@tcl.com">tomzhou@tcl.com</a> 
 * @version:  1.0    
 * @Date:     2017年7月20日 下午2:20:58  
 * <br/>修改历史:<br/>   
 * 修改日期       修改人员   版本    修改内容<br/>   
 * ---------------------------------------------- <br/> 
 * 2017年7月20日    tomzhou     1.0    1.0 XXXX <br/> 
 * @版权:   版权所有(C)2017
 * @公司:   深圳豪客互联网有限公司
 */
public class DateUtil {

	public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat("yyyyMMddHHmm");
	public static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String getToShotFormat() {
		Date date = new Date(System.currentTimeMillis());
		String str = yyyyMMdd.format(date);
		return str;
	}
	
	public static String getToShotFormatHHmmFormat() {
		Date date = new Date(System.currentTimeMillis());
		String str = yyyyMMddHHmm.format(date);
		return str;
	}
	
	public static String getToShotFormat(SimpleDateFormat dateFormat) {
		Date date = new Date(System.currentTimeMillis());
		String str = dateFormat.format(date);
		return str;
	}
	public static String getToShotFormat(String format,Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String str = dateFormat.format(date);
		return str;
	}
	
	public static void main(String[] args) throws Exception {
		BigDecimal score = new BigDecimal("0.4");
		System.out.println(score.add(new BigDecimal(DateUtil.getToShotFormatHHmmFormat())));
//		System.out.println(Double.MAX_VALUE);
//		Date date = new Date(Long.valueOf("1499701681000"));
//		System.out.println(yyyyMMddHHmmss.format(date));
	}
}
