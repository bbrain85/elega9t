/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.commons.args;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArgumentParserTest {

    @Test
    public void canParseOptionWithNoValue() throws Exception {
        String arg = "-option";

        ArgumentParser test = new ArgumentParser(new ByteArrayInputStream(arg.getBytes()));

        final Map<String, Argument> parameters = test.parse();

        assertEquals(1, parameters.size());
        for (String param : parameters.keySet()) {
            assertEquals("option", param);
            assertNull(parameters.get(param).getValue());
        }
    }

    @Test
    public void canParseOptionWithValue() throws Exception {
        String arg = "-option xyz";

        ArgumentParser test = new ArgumentParser(new ByteArrayInputStream(arg.getBytes()));

        final Map<String, Argument> parameters = test.parse();

        assertEquals(1, parameters.size());
        for (String param : parameters.keySet()) {
            assertEquals("option", param);
            assertEquals("xyz", parameters.get(param).getValue());
        }
    }

    @Test
    public void canParseMultipleOptionsWithValue() throws Exception {
        NamedArgument[] expectedParameters = { new NamedArgument("option", "xyz"), new NamedArgument("anotherOp", "abc")};

        ArgumentParser test = new ArgumentParser(new ByteArrayInputStream(toString(expectedParameters).getBytes()));

        final Map<String, Argument> parameters = test.parse();

        assertEquals(expectedParameters.length, parameters.size());
        int index = 0;
        for (String param : parameters.keySet()) {
            assertEquals(expectedParameters[index].getName(), param);
            assertEquals(expectedParameters[index].getValue(), parameters.get(param).getValue());
            index++;
        }
    }

    @Test
    public void canParseMultipleMixedOptionsWithAndWithoutValue() throws Exception {
        NamedArgument[] expectedParameters = { new NamedArgument("option", "xyz"), new NamedArgument("anotherOp"), new NamedArgument("op", "opValue")};

        ArgumentParser test = new ArgumentParser(new ByteArrayInputStream(toString(expectedParameters).getBytes()));

        final Map<String, Argument> parameters = test.parse();

        assertEquals(expectedParameters.length, parameters.size());
        int index = 0;
        for (String param : parameters.keySet()) {
            assertEquals(expectedParameters[index].getName(), param);
            assertEquals(expectedParameters[index].getValue(), parameters.get(param).getValue());
            index++;
        }
    }

    @Test
    public void canParseMultipleMixedOptionsWithSingleQuotedValue() throws Exception {
        NamedArgument[] expectedParameters = { new NamedArgument("option", "'xyz'"), new NamedArgument("anotherOp"), new NamedArgument("op", "opValue")};

        ArgumentParser test = new ArgumentParser(new ByteArrayInputStream(toString(expectedParameters).getBytes()));

        final Map<String, Argument> parameters = test.parse();

        assertEquals(expectedParameters.length, parameters.size());
        int index = 0;
        for (String param : parameters.keySet()) {
            assertEquals(expectedParameters[index].getName(), param);
            assertEquals(expectedParameters[index].getValue(), parameters.get(param).getValue());
            index++;
        }
    }

    @Test
    public void canParseMultipleMixedOptionsWithDoubleQuotedValue() throws Exception {
        NamedArgument[] expectedParameters = { new NamedArgument("option", "xyz"), new NamedArgument("anotherOp"), new NamedArgument("op", "\"opValue\"")};

        ArgumentParser test = new ArgumentParser(new ByteArrayInputStream(toString(expectedParameters).getBytes()));

        final Map<String, Argument> parameters = test.parse();

        assertEquals(expectedParameters.length, parameters.size());
        int index = 0;
        for (String param : parameters.keySet()) {
            assertEquals(expectedParameters[index].getName(), param);
            assertEquals(expectedParameters[index].getValue(), parameters.get(param).getValue());
            index++;
        }
    }

    @Test(expected = DuplicateArgumentException.class)
    public void throwsDuplicateParameterExceptionWhenDuplicateParameterSpecified() throws Exception {
        NamedArgument[] expectedParameters = { new NamedArgument("option", "xyz"), new NamedArgument("option")};

        ArgumentParser test = new ArgumentParser(new ByteArrayInputStream(toString(expectedParameters).getBytes()));

        test.parse();
    }

    private String toString(NamedArgument[] expectedParameters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (NamedArgument expectedParameter : expectedParameters) {
            stringBuilder.append("-");
            stringBuilder.append(expectedParameter.getName());
            stringBuilder.append(" ");
            if(expectedParameter.getValue() != null) {
                stringBuilder.append(expectedParameter.getValue());
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

}
