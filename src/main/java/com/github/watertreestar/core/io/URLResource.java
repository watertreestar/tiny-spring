package com.github.watertreestar.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLResource implements Resource{
    private URL url;

    public URLResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getResource() throws IOException {
        return this.url.openConnection().getInputStream();
    }
}
