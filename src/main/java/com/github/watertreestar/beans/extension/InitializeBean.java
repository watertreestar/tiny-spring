package com.github.watertreestar.beans.extension;

/**
 * @Author ranger
 * @Date 2020/9/8 20:52
 **/
public interface InitializeBean {

    /**
     * Invoked by the containing {@link com.xingyao.beans.factory.BeanFactory}after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     * @throws Exception in the event of misconfiguration (such as failure to set an
     * essential property) or if initialization fails for any other reason
     */
    void afterPropertiesSet() throws Exception;
}
