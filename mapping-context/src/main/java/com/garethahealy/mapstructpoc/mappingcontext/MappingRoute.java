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
package com.garethahealy.mapstructpoc.mappingcontext;

import com.garethahealy.camelmapstruct.converter.MapStructTypeConverterLoader;
import com.garethahealy.mapstructpoc.mappingcontext.processors.BeerToLagerProcessor;
import com.garethahealy.mapstructpoc.mappingcontext.processors.LagerPumpProcessor;
import com.garethahealy.mapstructpoc.mappingmodel.BeerMapper;
import com.garethahealy.mapstructpoc.mappingmodel.entities.Bitter;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MappingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        new MapStructTypeConverterLoader<BeerMapper>(getContext(), BeerMapper.class);

        from("timer:hello-BeerToLagerProcessor?period=1s")
            .process(new LagerPumpProcessor())
            .process(new BeerToLagerProcessor())
            .log("${body}");

        from("timer:hello-convertBodyTo?period=1s")
            .process(new LagerPumpProcessor())
            .convertBodyTo(Bitter.class)
            .log("${body}");
    }
}
