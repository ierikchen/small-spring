package com.avezah.springframework.beans.factory.support;

import com.avezah.springframework.beans.BeansException;
import com.avezah.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

	@Override
	protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		BeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
		if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined.");
		return this.beanDefinitionMap.get(beanName);
	}

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		this.beanDefinitionMap.put(beanName, beanDefinition);
	}
}
