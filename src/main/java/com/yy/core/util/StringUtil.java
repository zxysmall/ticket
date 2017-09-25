package com.yy.core.util;

/**
 * 文件名称:    StringUtil.java
 * <br>内容摘要:StringUtil</br></p> 
 * @author:  tom:<a href="mailto:tomzhou@tcl.com">tomzhou@tcl.com</a> 
 * @version:  1.0    
 * @Date:     2017年7月20日 下午2:21:08  
 * <br/>修改历史:<br/>   
 * 修改日期       修改人员   版本    修改内容<br/>   
 * ---------------------------------------------- <br/> 
 * 2017年7月20日    tomzhou     1.0    1.0 XXXX <br/> 
 * @版权:   版权所有(C)2017
 * @公司:   深圳豪客互联网有限公司
 */
public class StringUtil {
	
	public static boolean isBlank(String arg)
	{
		return (arg==null||arg.trim().equals(""));
	}
}
