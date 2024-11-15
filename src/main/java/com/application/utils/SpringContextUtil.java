package com.application.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware, EnvironmentAware {

	private static ApplicationContext applicationContext;

	private static Environment environment;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		SpringContextUtil.applicationContext = arg0;
	}
	
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	public static <T> T getBean(String beanName, Class<T> cls) {
		return applicationContext.getBean(beanName, cls);
	}

	public static <T> T getBean(Class<T> cls) {
		return applicationContext.getBean(cls);
	}

	public static boolean isSingleton(String beanName) {
		return applicationContext.isSingleton(beanName);
	}

	public static boolean isPrototype(String beanName) {
		return applicationContext.isPrototype(beanName);
	}

	public static boolean containsBean(String beanName) {
		return applicationContext.containsBean(beanName);
	}

	public static Environment getEnvironment() {
		return environment;
	}

	@Override
	public void setEnvironment(Environment environment) {
		SpringContextUtil.environment = environment;
	}
}
