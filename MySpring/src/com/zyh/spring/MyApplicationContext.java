package com.zyh.spring;
//通过它创建容器，并且它持有容器的引用，通过它可以从容器中获取对象
public interface MyApplicationContext {
  public Object getBean(String name);
}
