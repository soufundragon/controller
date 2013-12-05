/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.config.yangjmxgenerator.plugin.ftl.model;


import org.opendaylight.controller.config.yangjmxgenerator.attribute.Dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModuleField extends Field {

    private final String nullableDefault, attributeName;
    private final boolean dependent;
    private final Dependency dependency;

    public ModuleField(List<String> modifiers, String type, String name,
            String attributeName, String nullableDefault, boolean isDependency,
            Dependency dependency) {
        super(modifiers, type, name);
        this.dependent = isDependency;
        this.dependency = dependency;
        this.attributeName = attributeName;
        if (type.startsWith(List.class.getName()) && nullableDefault == null) {
            String generics = type.substring(List.class.getName().length());
            nullableDefault = "new " + ArrayList.class.getName() + generics + "()";
        }
        this.nullableDefault = nullableDefault;
    }

    public ModuleField(String type, String name, String attributeName,
            String nullableDefault, boolean isDependency, Dependency dependency) {
        this(Collections.<String> emptyList(), type, name, attributeName,
                nullableDefault, isDependency, dependency);
    }

    public Dependency getDependency() {
        return dependency;
    }

    public String getNullableDefault() {
        return nullableDefault;
    }

    public boolean isDependent() {
        return dependent;
    }

    public String getAttributeName() {
        return attributeName;
    }

}
