package lastorderapp.database;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lastorderapp.database.Departments;
import lastorderapp.database.Rooms;
import lastorderapp.database.Tools;
import lastorderapp.database.Workers;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-06T11:55:27")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile CollectionAttribute<Orders, Tools> toolsCollection;
    public static volatile SingularAttribute<Orders, Date> endDate;
    public static volatile SingularAttribute<Orders, Departments> departmentId;
    public static volatile SingularAttribute<Orders, String> workType;
    public static volatile SingularAttribute<Orders, Long> id;
    public static volatile CollectionAttribute<Orders, Workers> workersCollection;
    public static volatile SingularAttribute<Orders, Workers> acceptedJobId;
    public static volatile SingularAttribute<Orders, Date> startDate;
    public static volatile SingularAttribute<Orders, Rooms> roomId;
    public static volatile SingularAttribute<Orders, Workers> issuedJobId;

}