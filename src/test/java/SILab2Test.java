import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<String> createList(String usernames) {
        List<String> users = new ArrayList<>();
        return users;
    }
    SILab2 testunit = new SILab2();

    @Test
    void everyPathTest() {
        // prva pateka A,K
        assertFalse(testunit.function(null, null));

        // A,B,K
        assertFalse(testunit.function(new User(null, null, null), null));

        // A,B,C,D1,D2,I,J
        assertFalse(testunit.function(new User("nikola", "123123", ""), createList("username")));
        // A,B,C,D1,D2,I,K
        
        //assertFalse(testunit.function(new User("n1kola", "12345", ""), generated));
        // A,B,C,D1,(D2,E,F,G,H,D3,D2),I,J
        // A,B,C,D1,(D2,E,G,H,D3,D2),I,J


    }

}