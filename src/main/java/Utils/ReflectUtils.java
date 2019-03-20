package Utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TO USE REFLECTION OBJECT MUST USE GET AND SETTERS.
 *
 * @author Francisco Martins<francisco_jcm_7@hotmail.com>
 */
public class ReflectUtils {
    
    /**
     * Returns an Map of attribute -> value from an object.
     * 
     * @param dataObj
     * @return 
     */
    public Map<String, Object> getValues(Object dataObj) {
        try {
            Map<String, Object> retObj = new HashMap<>();
            BeanInfo bi = Introspector.getBeanInfo(dataObj.getClass());
            for (PropertyDescriptor it : bi.getPropertyDescriptors()) {
                retObj.put(
                        it.getName(),
                        it.getReadMethod().invoke(dataObj)
                );
            }

            return retObj;
        } catch (IntrospectionException
                | IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException ex) {
            Logger.getLogger(
                    ReflectUtils.class.getName()
            ).log(Level.SEVERE, null, ex);

            return new HashMap<>(0);
        }
    }
}
