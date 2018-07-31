package lastorderapp.database;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lastorderapp.database.Departments;
import lastorderapp.database.Orders;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-06T11:55:27")
@StaticMetamodel(Workers.class)
public class Workers_ { 

    public static volatile SingularAttribute<Workers, BigDecimal> workerId;
    public static volatile SingularAttribute<Workers, Departments> workerDepartment;
    public static volatile CollectionAttribute<Workers, Orders> ordersCollection;
    public static volatile SingularAttribute<Workers, String> workerName;
    public static volatile CollectionAttribute<Workers, Orders> ordersCollection1;
    public static volatile SingularAttribute<Workers, String> workerPosition;
    public static volatile CollectionAttribute<Workers, Orders> ordersCollection2;

}