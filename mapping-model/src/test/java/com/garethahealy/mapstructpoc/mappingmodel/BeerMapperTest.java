/*-
 * #%L
 * GarethHealy :: MapStruct PoC :: Mapping Model
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
package com.garethahealy.mapstructpoc.mappingmodel;

import com.garethahealy.mapstructpoc.mappingmodel.entities.Bitter;
import com.garethahealy.mapstructpoc.mappingmodel.entities.Larger;

import org.junit.Assert;
import org.junit.Test;

public class BeerMapperTest {

    @Test
    public void canLargerToBitter() {
        Larger larger = new Larger(Long.valueOf(101L), "Stella", "InBev", Double.valueOf(4.9), new Integer[] {255, 194, 0}, "Standard");
        Bitter bitter = BeerMapper.INSTANCE.largerToBitter(larger);

        Assert.assertNotNull(bitter);
        Assert.assertNotNull(bitter.getId());
        Assert.assertNotNull(bitter.getName());
        Assert.assertNotNull(bitter.getBrewery());
        Assert.assertNotNull(bitter.getStrength());
        Assert.assertNotNull(bitter.getColour());
        Assert.assertNotNull(bitter.getTaste());

        Assert.assertEquals(String.valueOf(larger.getId()), bitter.getId());
        Assert.assertEquals(larger.getName(), bitter.getName());
        Assert.assertEquals(larger.getBreweryId(), bitter.getBrewery());
        Assert.assertEquals(String.valueOf(larger.getPercentage()), bitter.getStrength());
        Assert.assertEquals("255,194,0", bitter.getColour());
        Assert.assertEquals(larger.getTastingNote(), bitter.getTaste());
    }
}
