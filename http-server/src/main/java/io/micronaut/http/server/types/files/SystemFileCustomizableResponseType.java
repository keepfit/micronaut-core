/*
 * Copyright 2017 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.http.server.types.files;

import java.io.File;

/**
 * A special type for handling a {@link File}
 *
 * @author James Kleeh
 * @since 1.0
 */
public class SystemFileCustomizableResponseType implements FileCustomizableResponseType {

    protected final File file;

    public SystemFileCustomizableResponseType(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    @Override
    public long getLastModified() {
        return file.lastModified();
    }

    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    public long getLength() {
        return file.length();
    }

}