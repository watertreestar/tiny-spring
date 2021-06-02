package com.github.watertreestar.beans.xml;

import com.github.watertreestar.beans.core.BeanDefinition;
import com.github.watertreestar.beans.core.BeanReference;
import com.github.watertreestar.beans.core.PropertyValue;
import com.github.watertreestar.beans.factory.BeanRegistry;
import com.github.watertreestar.beans.reader.BeanDefinitionReader;
import com.github.watertreestar.beans.core.BeanDefinition;
import com.github.watertreestar.beans.core.BeanReference;
import com.github.watertreestar.beans.core.PropertyValue;
import com.github.watertreestar.beans.factory.BeanFactory;
import com.github.watertreestar.beans.factory.BeanRegistry;
import com.github.watertreestar.beans.reader.BeanDefinitionReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author ranger
 * @Date 2020/9/6 21:26
 * 根据XML配置文件读取BeanDefinition配置
 **/
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    private String configLocation;

    private BeanRegistry beanRegistry;



    public XmlBeanDefinitionReader(String configLocation, BeanRegistry beanRegistry){
        this.configLocation = configLocation;
        this.beanRegistry  = beanRegistry;
    }

    public XmlBeanDefinitionReader(String configLocation){
        this.configLocation = configLocation;
    }

    public XmlBeanDefinitionReader(BeanRegistry beanRegistry){
        this.beanRegistry = beanRegistry;
    }


    @Override
    public void loadBeanDefinitions(String configPath) throws Exception {
        if(configPath != null){
            this.configLocation = configPath;
        }
        InputStream inputStream = new FileInputStream(configLocation);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    /**
     * 解析所有的BeanDefinitions
     * @param root
     */
    private void parseBeanDefinitions(Element root){
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                parseBeanDefinition(ele);
            }
        }
    }

    /**
     * 解析单个BeanDefinition
     * @param ele
     */
    private void parseBeanDefinition(Element ele){
        String name = ele.getAttribute("id");
        String beanClass = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition(name);
        try{
            beanDefinition.setBeanClass(beanClass);
        }catch (Exception e){
            System.out.println(e);
        }
        processProperty(ele, beanDefinition);
        beanRegistry.registerBeanDefinition(name,beanDefinition);
    }

    /**
     * 处理BeanDefinition属性
     * @param ele
     * @param beanDefinition
     */
    private void processProperty(Element ele, BeanDefinition beanDefinition) {
        NodeList propertyNodes = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNodes.getLength(); i++) {
            Node propertyNode = propertyNodes.item(i);
            if (propertyNode instanceof Element) {
                Element propertyElement = (Element) propertyNode;
                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    String ref = propertyElement.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("ref config error");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }


}
