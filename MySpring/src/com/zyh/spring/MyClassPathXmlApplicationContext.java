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
			// ��ȡ�����ļ���������XML
			SAXReader reder = new SAXReader();

			// ʹ��SAXReader��ȡxml�����ļ�������DOM����
			Document document = reder.read(this.getClass().getClassLoader()
					.getResourceAsStream(fileName));
			// ���������ļ�
			List<Element> eles = document.selectNodes("beans/bean");
			// �������ҵ��Ľڵ�
			for (Element e : eles) {
				String id = e.attributeValue("id");
				String className = e.attributeValue("class");
				String scope = e.attributeValue("scope");
				// System.out.println(id + " " + clazz);
				// �ж��Ƿ��ǵ���
				if ("singleton".equals(scope)) {

					// ͼֽ
					Class<?> clazz = Class.forName(className);
					Object instance = clazz.newInstance();
					id2Instance.put(id, instance);

					// ��ȡ��Element���ӽڵ�
					List<Element> proEles = e.selectNodes("property");
					for (Element pele : proEles) {
						String name = pele.attributeValue("name");
						String ref = pele.attributeValue("ref");
						// set+U+serDao,��������ƴ�ӷ�����
//						String methodName = "set"
//								+ name.substring(0, 1).toUpperCase()
//								+ name.substring(1);
//						System.out.println(methodName);

						// ͨ��������÷���
						Object arg = id2Instance.get(ref);

						// ��ȡ��Ա����
						Field declaredField = clazz.getDeclaredField(name);
						// �������䣨��privte������ʱ�ı��public��
						declaredField.setAccessible(true);
						declaredField.set(instance, arg);
						
						// Class<?> type = declaredField.getType();
//						 Method method = clazz.getMethod(methodName, type);
						// Method method = clazz.getDeclaredMethod(methodName,
						// arg.getClass().getInterfaces()[0]);

						// ��һ�������������ĸ�����ķ���
						// ����ref��map�в����Ѿ������õ����õ�ʵ��

//						method.invoke(instance, arg);
						System.out.println(instance);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ����ʵ������

		// ����һ����������Map��

		// �������ļ��е�ȫ����ͨ������ʵ����

		// ��ʵ�����õĶ�����뵽������Map����

	}

	@Override
	public Object getBean(String name) {
		// �������ֵ�������ȡ

		//
		return null;
	}

}
