package lastorderapp.database;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lastorderapp.database.Orders;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-06T11:55:27")
@StaticMetamodel(Rooms.class)
public class Rooms_ { 

    public static volatile SingularAttribute<Rooms, String> roomAdress;
    public static volatile CollectionAttribute<Rooms, Orders> ordersCollection;
    public static volatile SingularAttribute<Rooms, BigDecimal> roomId;
    public static volatile SingularAttribute<Rooms, String> roomName;

}