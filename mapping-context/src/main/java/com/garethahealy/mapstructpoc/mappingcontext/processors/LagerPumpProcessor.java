/*-
 * #%L
 * GarethHealy :: MapStruct PoC :: Mapping Context
 * %%
 * Copyright (C) 2013 - 2016 Gareth Healy
 * %%
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
 * #L%
 */
package com.garethahealy.mapstructpoc.mappingcontext.processors;

import com.garethahealy.mapstructpoc.mappingmodel.entities.Lager;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LagerPumpProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody(new Lager(Long.valueOf(101L), "Stella", "InBev", Double.valueOf(4.9), new Integer[] {255, 194, 0}, "Standard"));
    }
}
