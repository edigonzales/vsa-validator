package ch.so.agi.vsavalidator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ch.interlis.iom.IomObject;
import ch.interlis.iox_j.validator.ObjectPool;

public class Utils {
    public static Set<IomObject> createLeitungenCache(ObjectPool objectPool) {
        String LEITUNG_OBJECT_TAG = "VSADSSMINI_2020_LV95.VSADSSMini.Leitung";
        
        Set<IomObject> leitungenSet = new HashSet<IomObject>();
        objectPool.getBasketIds().stream().map((basketId) -> (objectPool.getObjectsOfBasketId(basketId)).valueIterator()).forEach((Iterator objectIterator) -> {
            while (objectIterator.hasNext()) {
                IomObject iomObj = (IomObject) objectIterator.next();
                if (iomObj != null && iomObj.getobjecttag().equals(LEITUNG_OBJECT_TAG)) {
                    leitungenSet.add(iomObj);
                }
            }
        });
        
        return leitungenSet;
    }
}
