package equality;

import equality.model.AirplaneBadIdentity;
import equality.model.AirplaneWithUuid;
import equality.model.Make;
import equality.model.Model;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AirplaneBadIdentityTest {

    @Test
    public void badHashCodeTest() {
        // equals based upon single field - uuid
        Map<AirplaneBadIdentity, Integer> stockCount = new HashMap<>();
        UUID commonUuid = UUID.randomUUID();

        AirplaneBadIdentity a = new AirplaneBadIdentity(commonUuid, Make.AIRBUS, Model.A380);
        AirplaneBadIdentity b = new AirplaneBadIdentity(commonUuid, Make.AIRBUS, Model.A330);

        System.out.println("a hashcode: " + a.hashCode());
        System.out.println("a identity hash code: " + System.identityHashCode(a));

        System.out.println("b hashcode: " + b.hashCode());
        System.out.println("b identity hash code: " + System.identityHashCode(b));
        stockCount.put(a, 2);
        stockCount.put(b, 3);
        System.out.println("stockCount: " + stockCount);
        stockCount.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}