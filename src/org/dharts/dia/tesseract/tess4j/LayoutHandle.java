/* File: LayoutHandle.java
 * Created: Oct 27, 2012
 * Author: Neal Audenaert
 *
 * Copyright 2012 Digital Archives, Research & Technology Services
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dharts.dia.tesseract.tess4j;

import org.dharts.dia.tesseract.tess4j.TessAPI.TessPageIterator;

/**
 * Implements {@link BasePageHandle} for use with layout analysis results.
 */
public class LayoutHandle extends BasePageHandle<TessPageIterator> {
    
    /**
     * Creates a new {@link LayoutHandle}. This is intended to be called by 
     * {@link TesseractHandle}.
     *  
     * @param ctx The initial context for this handle. 
     * @param handle The low-level handle to the Tesseract page iterator.
     * @return The created {@link LayoutHandle} 
     */
    static LayoutHandle create(HandleContext<TessPageIterator> ctx, TessPageIterator handle) {
        return new LayoutHandle(ctx, handle);
    }
    
    /**
     * Copies a {@link LayoutHandle}. 
     * @param handle The handle to copy.
     * @return A copy of the supplied handle. 
     */
    public static LayoutHandle copy(BasePageHandle<TessPageIterator> handle) {
        TessPageIterator newHandle = handle.context.copy(handle.iterator);
        return new LayoutHandle(handle.context, newHandle);
    }
    
    private LayoutHandle(HandleContext<TessPageIterator> ctx, TessPageIterator handle) {
        super(ctx, handle);
    }
}
