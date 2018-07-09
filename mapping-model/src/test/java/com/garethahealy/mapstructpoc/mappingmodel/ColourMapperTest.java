/*-
 * #%L
 * GarethHealy :: MapStruct PoC :: Mapping Model
 * %%
 * Copyright (C) 2013 - 2018 Gareth Healy
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
package com.garethahealy.mapstructpoc.mappingmodel;

import org.junit.Assert;
import org.junit.Test;

public class ColourMapperTest {

    @Test
    public void canToInteger() {
        ColourMapper mapper = new ColourMapper();
        Integer[] answer = mapper.toInteger("1,2,3");

        Assert.assertNotNull(answer);
        Assert.assertEquals(new Integer(1), answer[0]);
        Assert.assertEquals(new Integer(2), answer[1]);
        Assert.assertEquals(new Integer(3), answer[2]);
    }

    @Test
    public void canToString() {
        ColourMapper mapper = new ColourMapper();
        String answer = mapper.toString(new Integer[] {1, 2, 3});

        Assert.assertNotNull(answer);
        Assert.assertEquals("1,2,3", answer);
    }
}
