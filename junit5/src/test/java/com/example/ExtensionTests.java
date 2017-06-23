package com.example;

import com.example.extensions.MockitoExtension;
import com.example.extensions.TimingExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class, TimingExtension.class})
public class ExtensionTests {

    @BeforeEach
    void init(@Mock(name="person1") Person person1, @Mock(name="person2") Person person2) {
        when(person1.getName()).thenReturn("Dilbert");
        when(person2.getName()).thenReturn("Johny");
    }

    @Test
    void simpleTestWithInjectedMock1(@Mock(name="person1") Person person) {
        assertEquals("Dilbert", person.getName());
    }

    @Test
    void simpleTestWithInjectedMock2(@Mock(name="person2") Person person) {
        assertEquals("Johny", person.getName());
    }

}
