package lastorderapp.database;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lastorderapp.database.Orders;
import lastorderapp.database.Workers;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-06T11:55:27")
@StaticMetamodel(Departments.class)
public class Departments_ { 

    public static volatile SingularAttribute<Departments, String> departmentName;
    public static volatile SingularAttribute<Departments, BigDecimal> departmentId;
    public static volatile CollectionAttribute<Departments, Orders> ordersCollection;
    public static volatile CollectionAttribute<Departments, Workers> workersCollection;

}