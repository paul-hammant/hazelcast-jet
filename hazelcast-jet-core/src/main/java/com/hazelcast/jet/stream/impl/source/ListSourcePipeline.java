/*
 * Copyright (c) 2008-2017, Hazelcast, Inc. All Rights Reserved.
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

package com.hazelcast.jet.stream.impl.source;

import com.hazelcast.core.IList;
import com.hazelcast.jet.ProcessorMetaSupplier;
import com.hazelcast.jet.Processors;
import com.hazelcast.jet.stream.impl.pipeline.AbstractSourcePipeline;
import com.hazelcast.jet.stream.impl.pipeline.StreamContext;

public class ListSourcePipeline<E> extends AbstractSourcePipeline<E> {

    private final IList<E> list;

    public ListSourcePipeline(StreamContext context, IList<E> list) {
        super(context);
        this.list = list;
    }

    @Override
    protected ProcessorMetaSupplier getSourceMetaSupplier() {
        return Processors.readList(list.getName());
    }

    @Override
    protected String getName() {
        return "list-reader-" + list.getName();
    }

    @Override
    public boolean isOrdered() {
        return true;
    }
}

