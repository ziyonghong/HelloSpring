package com.zyh.spring;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MyClassPathXmlApplicationContext implements MyApplicationContext {

	private Map<String,String> id2FullName=new HashMap<String, String>();
	private Map<String, Object> id2Instance = new HashMap<String, Object>();

	public MyClassPathXmlApplicationContext(String fileName) {
		try {
			// 读取配置文件，并解析XML
			SAXReader reder = new SAXReader();

			// 使用SAXReader读取xml配置文件，返回DOM对象
			Document document = reder.read(this.getClass().getClassLoader()
					.getResourceAsStream(fileName));
			// 解析配置文件
			List<Element> eles = document.selectNodes("beans/bean");
			// 迭代查找到的节点
			for (Element e : eles) {
				String id = e.attributeValue("id");
				String className = e.attributeValue("class");
				String scope = e.attributeValue("scope");
				// System.out.println(id + " " + clazz);
				// 判断是否是单例
				if ("singleton".equals(scope)) {

					// 图纸
					Class<?> clazz = Class.forName(className);
					Object instance = clazz.newInstance();
					id2Instance.put(id, instance);

					// 获取该Element的子节点
					List<Element> proEles = e.selectNodes("property");
					for (Element pele : proEles) {
						String name = pele.attributeValue("name");
						String ref = pele.attributeValue("ref");
						// set+U+serDao,根据属性拼接方法名
//						String methodName = "set"
//								+ name.substring(0, 1).toUpperCase()
//								+ name.substring(1);
//						System.out.println(methodName);

						// 通过反射调用方法
						Object arg = id2Instance.get(ref);

						// 获取成员变量
						Field declaredField = clazz.getDeclaredField(name);
						// 暴力反射（将privte属性临时改变成public）
						declaredField.setAccessible(true);
						declaredField.set(instance, arg);
						
						// Class<?> type = declaredField.getType();
//						 Method method = clazz.getMethod(methodName, type);
						// Method method = clazz.getDeclaredMethod(methodName,
						// arg.getClass().getInterfaces()[0]);

						// 第一个参数：调用哪个对象的方法
						// 根据ref到map中查找已经创建好的引用的实例

//						method.invoke(instance, arg);
						System.out.println(instance);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 反射实例对象

		// 创建一个大容器（Map）

		// 将配置文件中的全类名通过反射实例化

		// 将实例化好的对象放入到容器（Map）中

	}

	@Override
	public Object getBean(String name) {
		// 根据名字到容器中取

		//
		return null;
	}

}
