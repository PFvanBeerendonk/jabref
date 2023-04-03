package org.jabref.logic.citationkeypattern;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

class AbstractCitationKeyPatternTest {
    
    @Test
    void AbstractCitationKeyPatternParse() throws Exception {
        AbstractCitationKeyPattern pattern = mock(AbstractCitationKeyPattern.class, CALLS_REAL_METHODS);
        
        pattern.setDefaultValue("[field1]spacer1[field2]spacer2[field3]");
        List<String> expectedPattern = List.of(
            "[field1]spacer1[field2]spacer2[field3]",
            "[",
            "field1",
            "]",
            "spacer1",
            "[",
            "field2",
            "]",
            "spacer2",
            "[",
            "field3",
            "]"
        );
        assertEquals(expectedPattern, pattern.getDefaultValue());
    }

    @Test
    void AbstractCitationKeyPatternParseEmptySpacer() throws Exception {
        AbstractCitationKeyPattern pattern = mock(AbstractCitationKeyPattern.class, CALLS_REAL_METHODS);
        
        pattern.setDefaultValue("[field1][field2]spacer2[field3]");
        List<String> expectedPattern = List.of(
            "[field1][field2]spacer2[field3]",
            "[",
            "field1",
            "]",
            "[",
            "field2",
            "]",
            "spacer2",
            "[",
            "field3",
            "]"
        );
        assertEquals(expectedPattern, pattern.getDefaultValue());
    }
}
