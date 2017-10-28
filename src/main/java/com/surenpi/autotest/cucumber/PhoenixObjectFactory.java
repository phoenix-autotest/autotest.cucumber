package com.surenpi.autotest.cucumber;

import cucumber.api.java.ObjectFactory;
import cucumber.runtime.CucumberException;
import org.suren.autotest.web.framework.settings.Phoenix;
import org.suren.autotest.web.framework.settings.SpringUtils;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suren
 */
public class PhoenixObjectFactory implements ObjectFactory
{
    private final Map<Class<?>, Object> instances = new HashMap<Class<?>, Object>();
    private Phoenix phoenix = null;

    public void start()
    {
        phoenix = new Phoenix(CucumberApplication.class);
        phoenix.init(new String[]{"-browser", "chrome"});
    }

    public void stop()
    {
        instances.clear();

        phoenix.shutdown();
    }

    public boolean addClass(Class<?> clazz) {
        return true;
    }

    public <T> T getInstance(Class<T> type)
    {
        T instance = type.cast(instances.get(type));
        if (instance == null) {
            instance = cacheNewInstance(type);
        }
        return instance;
    }

    private <T> T cacheNewInstance(Class<T> type)
    {
        try
        {
            T instance = SpringUtils.getApplicationContext().getBean(type);
            instances.put(type, instance);

            return instance;
        } catch (Exception ex) {
            try
            {
                Constructor<T> constructor = type.getConstructor();
                T instance = constructor.newInstance();
                instances.put(type, instance);

                return instance;
            }
            catch(NoSuchMethodException e)
            {
                throw new CucumberException(String.format("%s doesn't have an empty constructor. If you need DI, put cucumber-picocontainer on the classpath", type), e);
            }
            catch(Exception e)
            {
                throw new CucumberException(String.format("Failed to instantiate %s", type), e);
            }
        }
    }
}