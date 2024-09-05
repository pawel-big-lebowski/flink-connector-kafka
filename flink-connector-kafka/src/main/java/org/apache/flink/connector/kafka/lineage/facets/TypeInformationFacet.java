/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.connector.kafka.lineage.facets;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.api.lineage.LineageDatasetFacet;

import java.util.Objects;

/**
 * Facet containing TypeInformation object. Can be used as an intermediate step for evaluating
 * schema dataset facet.
 */
public class TypeInformationFacet implements LineageDatasetFacet {

    public static final String TYPE_INFORMATION_FACET_NAME = "typeInformation";

    private TypeInformation typeInformation;

    public TypeInformationFacet(TypeInformation typeInformation) {
        this.typeInformation = typeInformation;
    }

    @Override
    public String name() {
        return TYPE_INFORMATION_FACET_NAME;
    }

    public TypeInformation getTypeInformation() {
        return typeInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TypeInformationFacet that = (TypeInformationFacet) o;
        return Objects.equals(typeInformation, that.typeInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeInformation);
    }
}
