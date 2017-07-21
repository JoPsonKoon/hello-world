package org;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @date 2017年7月21日 下午3:25:47
 * @author jopson
 * @Description: TODO(使用反射机制，检查对象属性)
 */
public class CheckObj {
	public boolean checkObjIsNull(Object obj) throws IllegalAccessException {
		if(obj == null) return true;
		for (Field f : obj.getClass().getDeclaredFields()) {
			f.setAccessible(true);//值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。值为 false 则指示反射的对象应该实施 Java 语言访问检查。
			if(f.getName().equals("serialVersionUID"))//序列化的这个属性不检查
				continue;
			String objType = f.getType().getSimpleName();
			System.out.println(objType);
			// String property = f.getName(); //属性名
			if (StringUtils.isBlank((String) f.get(obj))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @author jopson
	 * @Description: TODO(检查对象指定属性值 	att==null ：true ？false )
	 * @param obj
	 * @param strs
	 *            需要检查的属性
	 * @return
	 * @throws IllegalAccessException
	 */
	public boolean checkObjSpecifiedAttributes(Object obj, String... attributes) throws IllegalAccessException {
		if(obj == null) return true;
		List<String> list = Arrays.asList(attributes);
		for (Field f : obj.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			if(f.getName().equals("serialVersionUID")) //序列化的这个属性不检查
				continue;
			if (list.contains(f.getName())) { // 需要验证的属性
				if (f.get(obj) == null) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @author jopson
	 * @Description: TODO(不检查对象指定属性值  att==null：true ？false )
	 * @param obj
	 * @param strs
	 *            不需要检查的属性
	 * @return
	 * @throws IllegalAccessException
	 */
	public boolean notCheckObjSpecifiedAttributes(Object obj, String... attributes) throws IllegalAccessException {
		if(obj == null) return true;
		List<String> list = Arrays.asList(attributes);
		for (Field f : obj.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			if(f.getName().equals("serialVersionUID"))//序列化的这个属性不检查
				continue;
			if (list.contains(f.getName())) // 需要验证的属性
				continue;
			if (f.get(obj) == null) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IllegalAccessException {
		CheckObject checkObject = new CheckObject();
		checkObject.setAaa("aaa属性");
		checkObject.setBbb("bbb属性");
		checkObject.setCcc(null);
		CheckObj checkObj = new CheckObj();
		System.out.println(checkObj.checkObjIsNull(checkObject));
		// System.out.println(checkObj.checkObjSpecifiedAttributes(checkObject, "aaa"));
		// System.out.println(checkObj.notCheckObjSpecifiedAttributes(checkObject, "ccc"));
	}
}

class CheckObject {
	private String aaa;
	private String bbb;
	private String ccc;
	private int ddd;
	private List<String> eee;

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public String getBbb() {
		return bbb;
	}

	public void setBbb(String bbb) {
		this.bbb = bbb;
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public List<String> getEee() {
		return eee;
	}

	public void setEee(List<String> eee) {
		this.eee = eee;
	}

}