import Utils.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by Yhugo on 09/11/2016.
 */
public class Launch {

    public static void main(String[] args){
        Session sessionHibernate = HibernateUtil.currentSession();
    }
}
