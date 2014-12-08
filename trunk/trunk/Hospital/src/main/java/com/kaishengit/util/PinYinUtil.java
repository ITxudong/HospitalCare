package com.kaishengit.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtil {

	public static String chineseToPinYin(String str) {
		StringBuilder sb = new StringBuilder();
		
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			try {
				String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(ch, format);
				if(pinyins != null) {
					sb.append(pinyins[0]);
				} else {
					sb.append(ch);
				}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
