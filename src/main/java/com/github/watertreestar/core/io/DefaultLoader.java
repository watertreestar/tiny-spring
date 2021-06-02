package com.github.watertreestar.core.io;

import java.net.URL;

/**
 * A Default implementation of {@code ResourceLoader} which load resource from classpath
 */
public class DefaultLoader implements ResourceLoader{
    @Override
    public Resource loadResource(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new URLResource(url);
    }
}
