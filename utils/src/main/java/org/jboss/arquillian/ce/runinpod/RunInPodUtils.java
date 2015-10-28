/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015 Red Hat Inc. and/or its affiliates and other
 * contributors as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a full listing of
 * individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.arquillian.ce.runinpod;

import java.lang.reflect.Method;

import org.jboss.arquillian.ce.api.RunInPod;
import org.jboss.shrinkwrap.api.Archive;

/**
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
public class RunInPodUtils {

    public static boolean hasRunInPod(Class<?> clazz) {
        if (clazz == Object.class) {
            return false;
        }

        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            if (isRunInPod(clazz, m)) {
                return true;
            }
        }

        return hasRunInPod(clazz.getSuperclass());
    }

    public static boolean isRunInPod(Class<?> clazz, Method method) {
        if (clazz.isAnnotationPresent(RunInPod.class)) {
            return true;
        }
        if (method.isAnnotationPresent(RunInPod.class)) {
            return true;
        }
        return false;
    }

    public static Archive<?> getRunAsPodArchive(Class<?> clazz) {
        return null; // TODO
    }
}
