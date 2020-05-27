package com.dh.xmlDemo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * dom4j解析xml
 */
public class Dom4jDemo {
    @Test
    public void test(){
        try {
            //1.获得解析器
            SAXReader saxReader=new SAXReader();
            //2.获取document对象
            Document doc= saxReader.read("src/web.xml");
            //3.获得根元素
            Element rootElement = doc.getRootElement();
//            System.out.println(rootElement.getName());
//            System.out.println(rootElement.attributeValue("version"));
            //4.获得子元素
            List<Element> elements = rootElement.elements();
            //5.遍历
            for (Element element:elements) {
                if("servlet".equals(element.getName())){
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    System.out.println(servletName.getText()+"--"+servletClass.getText()); //获得文本内容
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
