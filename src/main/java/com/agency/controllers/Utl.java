package com.agency.controllers;

import java.io.UnsupportedEncodingException;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
/**
 * 
 * @author BlackOrange
 * Convert parm from "iso-8859-1" to "utf-8"
 *
 */
public class Utl {
	public static String convert(String str) throws UnsupportedEncodingException {
		return new String(str.getBytes("iso-8859-1"),"utf-8");
		
	}
	
	/**
     * 汉字转换位汉语拼音首字母，英文字符不变
     *
     * @param chines 汉字
     * @return 拼音
     */
    public static String converterToFirstSpell(String chines) {
        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(
                            nameChar[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }
    /**
     * 
     * @param smsMob
     * 目标电话号码，多个号码用“，”分隔开
     * @param smsText
     * 短信内容
     * @return
     */
    public static String getResult(String smsMob,String smsText) {
    	//用户名
    	String Uid = "BlackOrange";  			
    	//接口安全秘钥
    	String Key = "c23ebca3d7a675704e9c";
    	HttpClientUtil client = HttpClientUtil.getInstance();
    	//UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
		if(result>0){
			return "UTF8成功发送条数:"+result;
		}else{
			return client.getErrorMsg(result);
		}	
	}
}
