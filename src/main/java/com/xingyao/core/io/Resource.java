package com.xingyao.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Identify a resource
 */
public interface Resource {
    /**
     * Get the resource stream
     * @return
     * @throws IOException
     */
    InputStream getResource() throws IOException;
}
