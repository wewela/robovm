/*
 * Copyright (C) 2012 Trillian AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robovm.rt.bro.ptr;

import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.robovm.rt.bro.Struct;
import org.robovm.rt.bro.annotation.StructMember;

/**
 * Points to a <code>float</code> value (<code>float *</code> in C).
 */
public final class FloatPtr extends Struct<FloatPtr> {

    /**
     * Pointer to {@link FloatPtr} (<code>float **</code> in C)
     */
    public static class Ptr extends org.robovm.rt.bro.ptr.Ptr<FloatPtr, Ptr> {}
    
    /**
     * Creates a new {@link FloatPtr} with a value of 0.0f.
     */
    public FloatPtr() {
    }
    
    /**
     * Creates a new {@link FloatPtr} and initializes it with the specified value.
     * 
     * @param value the value.
     */
    public FloatPtr(float value) {
        set(value);
    }

    /**
     * Returns the current value.
     * 
     * @return the value.
     */
    @StructMember(0)
    public native float get();
    
    /**
     * Sets the value.
     * 
     * @param value the new value.
     */
    @StructMember(0)
    public native void set(float value);
    
    /**
     * Returns a {@link FloatBuffer} which reads and writes to the same memory
     * location pointed to by this {@link FloatPtr}.
     * 
     * @param n the maximum number of floats the {@link FloatBuffer} can 
     *        read/write. This will be the {@link FloatBuffer}'s 
     *        <code>capacity</code>.
     * @return the {@link FloatBuffer}.
     */
    public FloatBuffer asFloatBuffer(int n) {
        return as(BytePtr.class).asByteBuffer(n << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
}
